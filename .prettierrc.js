module.exports = {
  endOfLine: 'auto',
  printWidth: 120,
  tabWidth: 2,
  useTabs: false,
  semi: true,
  singleQuote: true,
  quoteProps: 'preserve',
  trailingComma: 'none',
  bracketSpacing: true,
  bracketSameLine: false,
  jsxSingleQuote: true,
  arrowParens: 'avoid',

  plugins: ['@trivago/prettier-plugin-sort-imports'],

  importOrder: ['^react$', '^react-native$', '^expo', '<THIRD_PARTY_MODULES>', '^@sw/(.*)$', '^[../]', '^[./]'],
  importOrderSeparation: true,
  importOrderSortSpecifiers: true
};
