#!/usr/bin/env coffee

process.chdir('./scripts')

handlebars = require('handlebars')
fs = require('fs')
nlrCore = require('../node_modules/nlr-core')

fileBuffer = fs.readFileSync('../resources/templates/lila.handlebar')
fileContent = fileBuffer.toString()
template = handlebars.compile(fileContent)

for i in [0..7]
  templateValues =
    index: i
    sanskritName: nlrCore.getSanskritName(i)
    englishName: nlrCore.getEnglishName(i)
    timeInterval: nlrCore.time.formatTimeInterval(nlrCore.getTimeInterval(i))
    shortDescription: nlrCore.getShortDescription(i)
    rupaDescription: nlrCore.getRupaDescription(i)
    vishvanathDescription: nlrCore.getVishvanathDescription(i)
    longDescription: nlrCore.getLongDescription(i).join(' ')

  fs.writeFile \
    "../resources/public/#{nlrCore.getSanskritName(i).toLowerCase()}.html",
    template(templateValues)
