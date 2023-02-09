package com.example.app_sepiem;

import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public interface GpsListener extends LocationListener, GpsStatus.Listener{

    public void onLocationChanged(Location location);

    public void onProviderDisable(String provider);

    public void onProviderEnable(String provider);

    public void onStatusChanged(String provider, int status, Bundle extras);

    public void onGpsStatusChanged(int event);
}
