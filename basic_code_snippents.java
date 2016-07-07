	@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onBackPressed();
    }

    public void onBackPressed() {
        if (getView() != null) {
            this.getView().setFocusableInTouchMode(true);
            this.getView().requestFocus();
            this.getView().setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        if (MainActivity.fabMenu != null) {
                            MainActivity.fabMenu.setVisibility(View.VISIBLE);
                        }
                        doBack();
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    public void doBack() {
        getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }


    //get typeface
    private Typeface getTypeFace(){
        return Typeface.createFromAsset(mContext.getAssets(),"my_font.ttf");
    }


    /**
    * ჩაკეცილი თუა და ლანჩერით ვხსნით 
    */
    private void killIfIsnotTaskRoot() {}
    if (!isTaskRoot()
                && getIntent().hasCategory(Intent.CATEGORY_LAUNCHER)
                && getIntent().getAction() != null
                && getIntent().getAction().equals(Intent.ACTION_MAIN)) {

            finish();
            return;
        }
    }