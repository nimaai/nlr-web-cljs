var nlrCore =
/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};

/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {

/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId])
/******/ 			return installedModules[moduleId].exports;

/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			exports: {},
/******/ 			id: moduleId,
/******/ 			loaded: false
/******/ 		};

/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);

/******/ 		// Flag the module as loaded
/******/ 		module.loaded = true;

/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}


/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;

/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;

/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";

/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ function(module, exports, __webpack_require__) {

	var timeIntervals;

	timeIntervals = __webpack_require__(1);

	module.exports = {
	  getLilaIndex: __webpack_require__(2).getLilaIndex,
	  getLilaProgress: __webpack_require__(4).getLilaProgress,
	  getTimeInterval: function(i) {
	    return timeIntervals[i];
	  },
	  time: __webpack_require__(3)
	};


/***/ },
/* 1 */
/***/ function(module, exports) {

	module.exports = [
		[
			[
				22,
				48
			],
			[
				3,
				36
			]
		],
		[
			[
				3,
				36
			],
			[
				6,
				0
			]
		],
		[
			[
				6,
				0
			],
			[
				8,
				24
			]
		],
		[
			[
				8,
				24
			],
			[
				10,
				48
			]
		],
		[
			[
				10,
				48
			],
			[
				15,
				36
			]
		],
		[
			[
				15,
				36
			],
			[
				18,
				0
			]
		],
		[
			[
				18,
				0
			],
			[
				20,
				24
			]
		],
		[
			[
				20,
				24
			],
			[
				22,
				48
			]
		]
	];

/***/ },
/* 2 */
/***/ function(module, exports, __webpack_require__) {

	exports.getLilaIndex = function(d) {
	  var bh, bm, eh, em, getDayTimeInMinutes, i, index, j, timeIntervals, timeNowInMinutes;
	  timeIntervals = __webpack_require__(1);
	  getDayTimeInMinutes = __webpack_require__(3).getDayTimeInMinutes;
	  timeNowInMinutes = getDayTimeInMinutes(d.getHours(), d.getMinutes());
	  index = 0;
	  for (i = j = 0; j <= 7; i = ++j) {
	    bh = timeIntervals[i][0][0];
	    bm = timeIntervals[i][0][1];
	    eh = timeIntervals[i][1][0];
	    em = timeIntervals[i][1][1];
	    if (timeNowInMinutes < getDayTimeInMinutes(eh, em)) {
	      index = i;
	      break;
	    }
	  }
	  return index;
	};


/***/ },
/* 3 */
/***/ function(module, exports) {

	var formatTime;

	formatTime = function(h, m) {
	  if (m < 10) {
	    m = "0" + m;
	  }
	  return h + ":" + m;
	};

	exports.formatTime = formatTime;

	exports.getDayTimeInMinutes = function(hs, ms) {
	  return hs * 60 + ms;
	};

	exports.formatTimeInterval = function(interval) {
	  var bh, bm, eh, em;
	  bh = interval[0][0];
	  bm = interval[0][1];
	  eh = interval[1][0];
	  em = interval[1][1];
	  return (formatTime(bh, bm)) + " - " + (formatTime(eh, em));
	};


/***/ },
/* 4 */
/***/ function(module, exports, __webpack_require__) {

	exports.getLilaProgress = function(d) {
	  var after_midnight, before_midnight, bh, bm, eh, elapsedTimeInMinutes, em, getDayTimeInMinutes, i, lilaSpanInMinutes, timeIntervals, timeNowInMinutes;
	  timeIntervals = __webpack_require__(1);
	  getDayTimeInMinutes = __webpack_require__(3).getDayTimeInMinutes;
	  i = __webpack_require__(2).getLilaIndex(d);
	  bh = timeIntervals[i][0][0];
	  bm = timeIntervals[i][0][1];
	  eh = timeIntervals[i][1][0];
	  em = timeIntervals[i][1][1];
	  timeNowInMinutes = getDayTimeInMinutes(d.getHours(), d.getMinutes());
	  lilaSpanInMinutes = i === 0 ? (before_midnight = getDayTimeInMinutes(23, 59) - getDayTimeInMinutes(bh, bm), after_midnight = getDayTimeInMinutes(eh, em), before_midnight + 1 + after_midnight) : getDayTimeInMinutes(eh, em) - getDayTimeInMinutes(bh, bm);
	  elapsedTimeInMinutes = i === 0 ? (getDayTimeInMinutes(bh, bm) <= timeNowInMinutes && timeNowInMinutes <= getDayTimeInMinutes(23, 59)) ? timeNowInMinutes - getDayTimeInMinutes(bh, bm) : (before_midnight = getDayTimeInMinutes(23, 59) - getDayTimeInMinutes(bh, bm), after_midnight = timeNowInMinutes, before_midnight + 1 + after_midnight) : timeNowInMinutes - getDayTimeInMinutes(bh, bm);
	  return Math.round((elapsedTimeInMinutes / lilaSpanInMinutes) * 100);
	};


/***/ }
/******/ ]);