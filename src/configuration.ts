import type {AutomotiveCapacitorConfig} from "@capacitor-community/aaos-data-utils";
import {AutomotiveDataPluginConfiguration, ConfigurationError} from "@capacitor-community/aaos-data-utils";

const pluginPath = "./node_modules/@capacitor-community/aaos-vehicle-sensors/android/src/main/java/io/ionic/plugins/aaosvehiclesensors/SensorDataPlugin.java"


export class VehicleSensorPluginConfiguration extends AutomotiveDataPluginConfiguration{

    constructor(automotiveCapacitorConfig : AutomotiveCapacitorConfig) {
        if(!automotiveCapacitorConfig.plugins.VehicleSensorPlugin) {
            throw new ConfigurationError("Missing AutomotiveCapacitorConfig property VehicleSensorPlugin")
        }
        super("SensorDataPlugin",pluginPath,automotiveCapacitorConfig.plugins.VehicleSensorPlugin.allowedSensorTypes);
    }

    getRequiredPermissions(): Set<string> {
        return new Set<string>();
    }

}
