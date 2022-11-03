package com.capacitorplugin.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.capacitorplugin.datautils.dataerror.DataViewRegisterException;
import com.capacitorplugin.datautils.dataview.DataView;
import com.capacitorplugin.datautils.dataview.DataViewManager;
import com.getcapacitor.Bridge;
import com.getcapacitor.PluginCall;

public class SensorDataViewManager extends DataViewManager<SensorCallback> {

    private final SensorManager sensorManager;

    SensorDataViewManager(Context context) {
        this.dataCallbackBuilder = new SensorCallback.Builder();
        this.sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    public DataView<SensorCallback> generate(PluginCall pluginCall, Integer dataId, String addressableName, Boolean isActive, Boolean overwriteOldEvents) {
        DataView<SensorCallback> sensorDataView = super.generate(pluginCall,dataId,addressableName,isActive, overwriteOldEvents);
        Sensor desiredSensor = sensorManager.getDefaultSensor(dataId);
        boolean success = sensorManager.registerListener(sensorDataView.getCallback(), desiredSensor, SensorManager.SENSOR_DELAY_NORMAL);
        if(!success) {
            throw new DataViewRegisterException(dataId);
        }
        return sensorDataView;
    }

    @Override
    public DataView<SensorCallback> remove(String addressableName, Bridge bridge) {
        DataView<SensorCallback> sensorDataView = super.remove(addressableName, bridge);
        sensorManager.unregisterListener(sensorDataView.getCallback());
        return sensorDataView;
    }
}
