import { WebPlugin } from '@capacitor/core';

import type { VehicleSensorPluginPlugin } from './definitions';

export class VehicleSensorPluginWeb extends WebPlugin implements VehicleSensorPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
