package io.ionic.plugins.aaosvehiclesensors;


import io.ionic.plugins.aaosdatautils.dataevent.DataValueEvent;

public class SensorDataEvent extends DataValueEvent {

    enum Name{
        CHANGE_VALUE,
        CHANGE_ACCURACY
    }

    SensorDataEvent(SensorDataEvent.Name eventName,int sensorType) {
        super(eventName.ordinal());
        putData("sensorType",sensorType);
    }
}
