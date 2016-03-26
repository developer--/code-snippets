/*
* @return boolean return true if the application can access the internet
*/
private boolean haveInternet(){
        NetworkInfo info = ((ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info==null || !info.isConnected()) {
                return false;
        }
        if (info.isRoaming()) {
                // here is the roaming option you can change it if you want to disable internet while roaming, just return false
                return true;
        }
        return true;
}