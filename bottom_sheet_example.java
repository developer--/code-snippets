// save into preference
<RelativeLayout
        app:layout_behavior="android.support.design.widget.BottomSheetBehavior"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        xmlns:ratioIV="http://schemas.android.com/apk/res-auto"
        android:background="@color/clinic_adapter_view_back_color"
        app:behavior_hideable="true"
        android:id="@+id/bottom_sheet"
        >

        //content here



</RelativeLayout>

//Java

    /**
     * BottomSheet init
     */
    private void initBottomSheet(){
        bottomSheet = mCoordinatorRootViewLayout.findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
    }

   /**
     * შევამოწმოთ შიტის მდგომარეობა გახსნილია თუ არა
     */
    private void checkSheetBehavior(){
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    //your logic here
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                    //your logic here
            }
        });
    }
    
//compile 'com.android.support:design:23.2.0'
