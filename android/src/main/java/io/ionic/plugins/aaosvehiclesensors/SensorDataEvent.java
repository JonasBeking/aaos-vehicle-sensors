package com.capacitorplugin.sensor;

import com.capacitorplugin.datautils.dataevent.DataEvent;
import com.getcapacitor.JSObject;

public class SensorDataEvent extends DataEvent {
    SensorDataEvent(String eventName,int sensorType) {
        super(eventName);
        putData("sensorType",sensorType);
    }
}
