import { Theme } from '../types/theme';

import { darkColors, lightColors } from './colors';
import { defaultSpacing } from './spacing';
import { defaultTypography } from './typography';

const baseTheme: Omit<Theme, 'id' | 'colors'> = {
  spacing: defaultSpacing,
  typography: defaultTypography
};

export const lightTheme: Theme = {
  id: 'light',
  colors: lightColors,
  ...baseTheme
};

export const darkTheme: Theme = {
  id: 'dark',
  colors: darkColors,
  ...baseTheme
};

export * from './colors';
export * from './spacing';
export * from './typography';
