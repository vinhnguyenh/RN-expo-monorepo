import { NativeModule, requireNativeModule } from 'expo';

import { DataSyncNativeKotlinModuleEvents } from './DataSyncNativeKotlin.types';

declare class DataSyncNativeKotlinModule extends NativeModule<DataSyncNativeKotlinModuleEvents> {
  PI: number;
  hello(): string;
  setValueAsync(value: string): Promise<void>;
}

// This call loads the native module object from the JSI.
export default requireNativeModule<DataSyncNativeKotlinModule>('DataSyncNativeKotlin');
