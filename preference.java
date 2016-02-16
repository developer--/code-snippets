// save into preference
public void saveIntoPrefs(String...values){
	SharedPreferences prefs = getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
	SharedPreferences.Editor editor = prefs.edit();
	prefs.putString(Key1,values[0]);
	prefs.putString(Key2,values[1]);
	prefs.putString(Key3,values[2]);
	editor.apply();
}

//Get preference by name
public SharedPreferences getSharedPref(String PREFERENCE_NAME){
	SharedPreferences prefs = getSharedPreferences(PREFERENCE_NAME, Activity.MODE_PRIVATE);
}

//retrieve data from preference
public void getDataFromPref(){
	SharedPreferences prefs = getSharedPref(PREFERENCE_NAME);
	String value = prefs.getString(Key2,DEFAULT_VALUE);
}