export interface ThemeColors {
  primary: string;
  secondary: string;
  background: string;
  surface: string;
  text: string;
  subtleText: string;
  error: string;
  success: string;
  border: string;
}

export interface ThemeSpacing {
  none: number;
  small: number;
  medium: number;
  large: number;
  huge: number;
}

export interface ThemeTypography {
  h1: number;
  h2: number;
  body: number;
  button: number;
  caption: number;
}

export interface Theme {
  id: 'light' | 'dark';
  colors: ThemeColors;
  spacing: ThemeSpacing;
  typography: ThemeTypography;
}
