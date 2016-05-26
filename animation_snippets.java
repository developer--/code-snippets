
/**
* რივეალ ეფექტი გამოჩენისას
*/
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    void enterReveal(View view) {
        // previously invisible view

        // get the center for the clipping circle
        int cx = view.getMeasuredWidth() / 2;
        int cy = view.getMeasuredHeight() / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(view.getWidth(), view.getHeight()) / 2;

        // create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);

        // make the view visible and start the animation
        view.setVisibility(View.VISIBLE);
        anim.start();
    }



    //გაქრობა რივეალ ანიმაციით 
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    void exitReveal(final View myView) {
        // previously visible view
        // get the center for the clipping circle
        int cx = myView.getMeasuredWidth() / 2;
        int cy = myView.getMeasuredHeight() / 2;

        // get the initial radius for the clipping circle
        int initialRadius = myView.getWidth() / 2;

        // create the animation (the final radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                myView.setVisibility(View.INVISIBLE);
            }
        });

        // start the animation
        anim.start();
    }




    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
            // get the final radius for the clipping circle
        int finalRadius = Math.max(frameLayout.getWidth(), frameLayout.getHeight()) / 2;
        // create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(frameLayout, (int) motionEvent.getX(), (int) motionEvent.getY(), 0, finalRadius*2);

        anim.start();
        return false;
    }





    private void sharedTrasitionAnimation(){
        Pair<View, String> p1 = Pair.create((View) staticImage[0], "transition_name_1");
        Pair<View, String> p2 = Pair.create((View) descriptionTextView[0] , "transition_name_2");
        Pair<View, String> p3 = Pair.create((View) descriptionTextView[1] , "transition_name_3");

        ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(getActivity(), p1,p2,p3);
        startActivity(intent, options.toBundle());
    }








