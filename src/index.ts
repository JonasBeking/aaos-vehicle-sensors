import { registerPlugin } from '@capacitor/core';

import type { VehicleSensorPluginPlugin } from './definitions';

const VehicleSensorPlugin = registerPlugin<VehicleSensorPluginPlugin>('VehicleSensorPlugin', {
  web: () => import('./web').then(m => new m.VehicleSensorPluginWeb()),
});

export * from './definitions';
export { VehicleSensorPlugin };
