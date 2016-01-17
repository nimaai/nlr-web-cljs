timeIntervals = require('./data/time-intervals.json')
sanskritNames = require('./data/sanskrit-names.json')

module.exports =
  getLilaIndex: require('./lib/index.coffee').getLilaIndex
  getLilaProgress: require('./lib/progress.coffee').getLilaProgress
  getTimeInterval: (i) -> timeIntervals[i]
  getSanskritName: (i) -> sanskritNames[i]
  time: require('./lib/time.coffee')

