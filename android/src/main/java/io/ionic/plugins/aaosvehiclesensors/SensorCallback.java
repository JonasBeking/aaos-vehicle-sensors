package com.capacitorplugin.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

import com.capacitorplugin.datautils.datacallback.DataCallback;
import com.capacitorplugin.datautils.datacallback.DataCallbackBuilder;
import com.capacitorplugin.datautils.dataview.DataView;
import com.getcapacitor.JSArray;

import org.json.JSONException;

public class SensorCallback implements DataCallback<SensorCallback>, SensorEventListener {

    private final String TAG = "CarVolumeEventCallback";
    DataView<SensorCallback> dataView;

    public SensorCallback(DataView<SensorCallback> dataView) {
        this.dataView = dataView;
    }

    @Override
    public DataView<SensorCallback> getDataView() {
        return this.dataView;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;
        JSArray valueArray = new JSArray();
        for(float value : values) {
            try{
                valueArray.put(value);
            } catch(JSONException e) {
                Log.e(TAG,"Failed deconstructing value array from sensor to JSArray");
            }

        }
        Log.d(TAG,"Received SensorEvent 'ValueChanged' with values: " + valueArray + " for Sensor: " + sensorEvent.sensor.getName());
        SensorDataEvent sensorDataEvent = new SensorDataEvent("change-value",sensorEvent.sensor.getType());
        sensorDataEvent.putData("values",valueArray);
        this.passDataToView(sensorDataEvent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d(TAG,"Received SensorEvent 'AccuracyChanged' with new accuracy: " + accuracy + " for Sensor: " + sensor.getName());
        SensorDataEvent sensorDataEvent = new SensorDataEvent("change-value",sensor.getType());
        sensorDataEvent.putData("accuracy",accuracy);
        this.passDataToView(sensorDataEvent);
    }

    public static class Builder implements DataCallbackBuilder<SensorCallback> {

        @Override
        public SensorCallback build(DataView<SensorCallback> dataView) {
            return null;
        }
    }
}
