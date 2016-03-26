private double[] getGPS() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);  
        List<String> providers = lm.getProviders(true);

        /* Loop over the array backwards, and if you get an accurate location, then break out the loop*/
        Location l = null;
        
        for (int i=providers.size()-1; i>=0; i--) {
                l = lm.getLastKnownLocation(providers.get(i));
                if (l != null) break;
        }
        
        double[] gps = new double[2];
        if (l != null) {
                gps[0] = l.getLatitude();
                gps[1] = l.getLongitude();
        }
        return gps;
}