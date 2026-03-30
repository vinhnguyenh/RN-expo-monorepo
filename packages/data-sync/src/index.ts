// Reexport the native module. On web, it will be resolved to DataSyncNativeKotlinModule.web.ts
// and on native platforms to DataSyncNativeKotlinModule.ts
export { default } from './DataSyncNativeKotlinModule';
export * from './DataSyncNativeKotlin.types';
