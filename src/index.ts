import type { VehicleErrorEvent} from "@capacitor-community/aaos-data-utils";
import {VehicleDataProxy} from "@capacitor-community/aaos-data-utils";
import { registerPlugin } from '@capacitor/core';

import type {VehicleSensorDataEvent, VehicleSensorPluginInterface} from "./definitions";

const VehicleSensorService = registerPlugin<VehicleSensorPluginInterface>('SensorDataPlugin')

export class VehicleSensorPlugin extends VehicleDataProxy<VehicleSensorDataEvent,VehicleErrorEvent>{

  constructor() {
    super(VehicleSensorService);
  }

}

export * from "./configuration"
