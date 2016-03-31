package geolab.dags.global_helper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by Jemo on 3/30/16.
 */
public class MyOptionsHelper  {

    private static MyOptionsHelper myOptionsHelper;
    private MyOptionsHelper(){}

    public static MyOptionsHelper getMyOptionsHelper() {
        if (myOptionsHelper == null)
            myOptionsHelper = new MyOptionsHelper();
        return myOptionsHelper;
    }

    /**
     * დავსტარტოთ კამერა ინტენტი და დავაბრუნოთ Uri
     * @param activity
     * @return
     */
    public Uri captureImage(Activity activity) {
        Intent chooserIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (chooserIntent.resolveActivity(activity.getPackageManager()) != null) {
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.TITLE, "Image File name");
            Uri takenImageUri = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            Intent intentPicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intentPicture.putExtra(MediaStore.EXTRA_OUTPUT, takenImageUri);
            activity.startActivityForResult(intentPicture, MyConstants.REQUEST_IMAGE_CAPTURE);
            return takenImageUri;
        }
        return null;
    }

    public void chooseImageFromGallery(Activity activity){
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(i, MyConstants.RESULT_LOAD_IMAGE);
    }

    public String getRealPathFromURI(Uri contentUri, Activity activity){
        try {
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor cursor = activity.managedQuery(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        catch (Exception e){
            return contentUri.getPath();
        }
    }
}




//In activity onResult
 @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && data != null) {
            switch (requestCode){
                case MyConstants.REQUEST_IMAGE_CAPTURE:
                    if (takenImageUri != null) {
                        Uri imagePath =  Uri.parse(MyOptionsHelper.getMyOptionsHelper().getRealPathFromURI(takenImageUri,this));
                        startUploadActivity(imagePath);
                    }
                    break;
                case MyConstants.RESULT_LOAD_IMAGE:
                    Uri chosenImagePath = Uri.parse(MyOptionsHelper.getMyOptionsHelper().getRealPathFromURI(data.getData(), this));
                    startUploadActivity(choosedImagePath);
                    break;

            }
        }
    }



