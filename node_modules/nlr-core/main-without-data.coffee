timeIntervals = require('./data/time-intervals.json')

module.exports =
  getLilaIndex: require('./lib/index.coffee').getLilaIndex
  getLilaProgress: require('./lib/progress.coffee').getLilaProgress
  getTimeInterval: (i) -> timeIntervals[i]
  time: require('./lib/time.coffee')

