// example of filtering and sharing multiple images with texts
// remove facebook from sharing intents
    private void shareFilter(){

        String share = getShareTexts();
        ArrayList<Uri> uris = getImageUris();

        List<Intent> targets = new ArrayList<>();
        Intent template = new Intent(Intent.ACTION_SEND_MULTIPLE);
        template.setType("image/*");
        List<ResolveInfo> candidates = getActivity().getPackageManager().
                queryIntentActivities(template, 0);

        // remove facebook which has a broken share intent
        for (ResolveInfo candidate : candidates) {
            String packageName = candidate.activityInfo.packageName;
            if (!packageName.equals("com.facebook.katana")) {
                Intent target = new Intent(Intent.ACTION_SEND_MULTIPLE);
                target.setType("image/*");
                target.putParcelableArrayListExtra(Intent.EXTRA_STREAM,uris);
                target.putExtra(Intent.EXTRA_TEXT, share);
                target.setPackage(packageName);
                targets.add(target);
            }
        }
        Intent chooser = Intent.createChooser(targets.remove(0), "Share Via");
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, targets.toArray(new Parcelable[targets.size()]));
        startActivity(chooser);

    }