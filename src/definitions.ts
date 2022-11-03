export interface VehicleSensorPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
