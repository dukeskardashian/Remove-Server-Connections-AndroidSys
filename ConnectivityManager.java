ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
if (connectivityManager != null) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        Network[] networks = connectivityManager.getAllNetworks();
        for (Network network : networks) {
            connectivityManager.bindProcessToNetwork(null); // Deaktivieren Sie die Verbindung zum Netzwerk
        }
    } else {
        // Für ältere Android-Versionen (vor Marshmallow) können Sie die mobilen Daten- und WLAN-Verbindungen deaktivieren
        connectivityManager.setMobileDataEnabled(false);
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(false);
    }
}
