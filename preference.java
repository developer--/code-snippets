// save into preference
private static MyPrefHelper myPrefHelper;
    private MyPrefHelper() {
    }

    public static MyPrefHelper getPrefInstance() {
        if (myPrefHelper == null)
            myPrefHelper = new MyPrefHelper();
        return myPrefHelper;
    }

    private static final String PREFERENCE_NAME = "facebook_login";

    public static final String ACCESS_TOKEN_VALUE = "access_token";
    public static final String LOGIN_STATUS = "login_status";

    // save into preference
    public void saveIntoPrefs(Context context,String...values){
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        for (int i = 0; i < values.length; i++) {
            editor.putString("key"+i,values[i]);
        }
        editor.apply();
    }

    public static void saveIntoPrefs(Context context, String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key,value);
        editor.apply();
    }

    //Get preference by name
    public static SharedPreferences getSharedPref(Context context,String PREFERENCE_NAME){
        return context.getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
    }

    //retrieve data from preference
    public static String getDataFromPref(Context context, String key){
        SharedPreferences prefs = getSharedPref(context,PREFERENCE_NAME);
        return prefs.getString(key, "");
    }

    public static void deleteMyPrefValue(Context context, String key){

    }

    /**
     * შევამოწმოთ ჩანაწერი შენახულია თუ არა
     * შესაბამის key ზე
     */
    public static boolean checkPrefValue(Context context, String key){
        SharedPreferences prefs = getSharedPref(context,PREFERENCE_NAME);
        return prefs.getBoolean(key,false);
    }

    public static void changeBooleans(Context context, String key, boolean value){
        SharedPreferences prefs = getSharedPref(context,PREFERENCE_NAME);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }
