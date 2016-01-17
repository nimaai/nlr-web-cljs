module.exports = {
  entry: './main-limited.coffee',
  output: {
    filename: 'main-limited.js',
    path: './dist/cljs',
    library: 'nlrCore'
  },
  resolve: {
    // we can leave off file extensions for js-like sources:
    // still need to transform them with a loader!
    'extensions': [
      // (node.js) defaults:
     '', // need to leave this…
     '.js',
     '.json',
      //  extra:
     '.coffee'
    ]
  },
  module: {
    loaders: [
      {
        test: /\.coffee$/,
        loader: 'coffee-loader'
      },
      {
        test: /\.json$/,
        loader: 'json-loader'
      }
    ]
  }
}
