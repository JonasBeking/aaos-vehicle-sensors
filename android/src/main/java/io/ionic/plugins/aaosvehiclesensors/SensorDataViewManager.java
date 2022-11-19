package io.ionic.plugins.aaosvehiclesensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.getcapacitor.Bridge;
import com.getcapacitor.PluginCall;

import io.ionic.plugins.aaosdatautils.dataerror.DataViewRegisterException;
import io.ionic.plugins.aaosdatautils.dataview.DataView;
import io.ionic.plugins.aaosdatautils.dataview.DataViewManager;

public class SensorDataViewManager extends DataViewManager<SensorCallback> {

    private final SensorManager sensorManager;

    SensorDataViewManager(Context context) {
        this.dataCallbackBuilder = new SensorCallback.Builder();
        this.sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    public DataView<SensorCallback> generate(PluginCall pluginCall, Integer dataId, String addressableName, Boolean isActive) {
        DataView<SensorCallback> sensorDataView = super.generate(pluginCall,dataId,addressableName,isActive);
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
