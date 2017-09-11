var fs   = require('fs');
var path = require('path');
var util = require('util');
var yaml = require('js-yaml');
var watch = require('node-watch');

var requestTag = 'request';
//var logTag = 'request.log';
var data = '';

watch('config/', { recursive: true }, function(evt, name) {
	  console.log('%s changed event: %s', name,evt);
	  readDataFromFile();
});

function readDataFromFile() {
	try {
	      var filename = path.join(__dirname, '../config/cs-request.yml'),
	      contents = fs.readFileSync(filename, 'utf8');
	      data = yaml.load(contents);
	} catch (err) {
	  console.log(err.stack || String(err));
	}	
}

function reader() {
	//console.log(util.inspect(data, false, 10, true));
	if(data === '') {
		console.log('Going to load yml file');
		readDataFromFile();
	}
	var request = data[requestTag];
	//console.log('request data : '+JSON.stringify(request));
	return request;
}

/*function readLogProperties() {
	if(data === '') {
		readDataFromFile();
	}
	var logInfo = data[logTag];
	console.log('Log data : '+JSON.stringify(logInfo));
	return logInfo;
}*/

module.exports = {
		reader : reader
		//readLogProperties : readLogProperties
	};

//readLogProperties();