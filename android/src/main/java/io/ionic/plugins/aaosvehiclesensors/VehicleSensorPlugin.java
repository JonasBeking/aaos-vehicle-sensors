package io.ionic.plugins.aaosvehiclesensors;

import android.util.Log;

public class VehicleSensorPlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
