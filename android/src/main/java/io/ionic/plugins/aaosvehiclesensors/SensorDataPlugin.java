package io.ionic.plugins.aaosvehiclesensors;

import com.getcapacitor.annotation.CapacitorPlugin;

import io.ionic.plugins.aaosdatautils.DataPlugin;
import io.ionic.plugins.aaosdatautils.dataerror.DataErrorHandler;

@CapacitorPlugin(name = "VehicleSensorPlugin")
public class SensorDataPlugin extends DataPlugin<SensorCallback> {
    @Override
    public void load() {
        super.load();
        this.dataViewManager = new SensorDataViewManager(super.getContext());
        this.dataErrorHandler = new DataErrorHandler();
    }
}
