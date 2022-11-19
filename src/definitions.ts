import type {VehicleDataEvent, VehicleDataService, VehicleErrorEvent} from "@capacitor-community/aaos-data-utils";


export enum SensorType {
  ACCELEROMETER = 1,
  ACCELEROMETER_UNCALIBRATED = 35,
  //ALL = -1,
  AMBIENT_TEMPERATURE = 13,
  DEVICE_PRIVATE_BASE = 65536,
  GAME_ROTATION_VECTOR = 15,
  GEOMAGNETIC_ROTATION_VECTOR = 20,
  GRAVITY = 9,
  GYROSCOPE = 4,
  GYROSCOPE_UNCALIBRATED = 16,
  HEART_BEAT = 31,
  HEART_RATE = 21,
  HINGE_ANGLE = 36,
  LIGHT = 5,
  LINEAR_ACCELERATION = 10,
  LOW_LATENCY_OFFBODY_DETECT = 34,
  MAGNETIC_FIELD = 2,
  MAGNETIC_FIELD_UNCALIBRATED = 14,
  MOTION_DETECT = 30,
}


export interface VehicleSensorDataEvent extends VehicleDataEvent{
  data : {
    sensorType : string,
    values? : number[],
    accuracy? : number
  }
}

/**
 * This is the interface
 */
export type VehicleSensorPluginInterface = VehicleDataService<VehicleSensorDataEvent,VehicleErrorEvent>
