package com.capacitorplugin.sensor;

import com.capacitorplugin.datautils.dataerror.DataErrorHandler;
import com.capacitorplugin.datautils.dataservice.DataPlugin;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "SensorDataService")
public class SensorDataService extends DataPlugin<SensorCallback> {
    @Override
    public void load() {
        super.load();
        this.dataViewManager = new SensorDataViewManager(super.getContext());
        this.dataErrorHandler = new DataErrorHandler();
    }
}
