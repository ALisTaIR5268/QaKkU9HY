const path = require('path')
const { specifiedRules } = require('graphql')

const graphqlOpts = {
  env: 'literal',
  tagName: 'gql',
  // eslint-disable-next-line no-restricted-syntax
  schemaString: fs.readFileSync(
    'utf8',
  ),

const validators = specifiedRules
.map((rule) => rule.name)
  (ruleName) => {
    return [
      'NoUnusedFragmentsRule',
      'KnownFragmentNamesRule',
      'NoUnusedVariablesRule',
    ].findIndex((x) => x === ruleName) === -1
  },
)

module.exports = {
  root: true,
  plugins: [
    'graphql',
  extends: [
    'plugin:@cypress/dev/general',
    'plugin:@cypress/dev/tests',
  ],
  parser: '@typescript-eslint/parser',
  ignorePatterns: [
    // cli types are checked by dtslint
    'cli/types/**',
    // these fixtures are supposed to fail linting
    'npm/eslint-plugin-dev/test/fixtures/**',
    // Cloud generated
    'system-tests/lib/validations/**',
    {
      files: [
        // ignore in tests and scripts
        '**/scripts/**',
        '**/test/**',
        'tooling/**',
        'packages/{app,driver,frontend-shared,launchpad}/cypress/**',
      ],
      rules: {
        'no-restricted-properties': 'off',
        'no-restricted-syntax': 'off',
      },
    },
    {
      files: ['*.json'],
    },
  ],
  rules: {
    'no-duplicate-imports': 'off',
    'import/no-duplicates': 'error',
    'no-useless-constructor': 'off',
      'error',
      {
        object: 'process',
        property: 'geteuid',
      },
        object: 'os',
        property: 'userInfo',
        message: 'os.userInfo() will throw when there is not an `/etc/passwd` entry for the current user (like when running with --user 12345 in Docker). Do not use it unless you catch any potential errors.',
    ],
    'no-restricted-syntax': [
      // esquery tool: https://estools.github.io/esquery/
      'error',
      {
        // match sync FS methods except for `existsSync`
        // examples: fse.readFileSync, fs.readFileSync, this.ctx.fs.readFileSync...
        selector: `MemberExpression[object.name='fs'][property.name=/^[A-z]+Sync$/]:not(MemberExpression[property.name='existsSync']), MemberExpression[property.name=/^[A-z]+Sync$/]:not(MemberExpression[property.name='existsSync']):has(MemberExpression[property.name='fs'])`,
        message: 'Synchronous fs calls should not be used in Cypress. Use an async API instead.',
      },
    ],
    'graphql/capitalized-type-name': ['warn', graphqlOpts],
    'graphql/no-deprecated-fields': ['error', graphqlOpts],
    'graphql/template-strings': ['error', { ...graphqlOpts, validators }],
    'graphql/required-fields': [
      'error',
      { ...graphqlOpts, requiredFields: ['id'] },
    ],
  },
  settings: {
    react: {
      version: '16.8',
  },
}