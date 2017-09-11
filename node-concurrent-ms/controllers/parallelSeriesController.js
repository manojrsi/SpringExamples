/**
 * Paralle and Series request Controller
 */
var express = require('express');
var message = require('../util/response');
var logConf = require('../util/readconfig').reader();
var app = express();
var util = require('util');
var http = require('http');
var async = require('async');
var strformat=require('strformat');

logger = require('avs-commons-logging-nodejs')(logConf.log.path, logConf.log.level, '.yyyy-MM-dd');

var sendRequest = function(config,req, res,pathVariable) {
	logger.info('path values : '+pathVariable);
	var stack = [];
	var result = [];
	var options = [];
	var opt;

	var j = 0;
	for (var i = 0; i < config.urls.length; i++) {
		console.log( strformat(strformat(config.urls[i].url, pathVariable),req.query));
		options[i] = {
				host : config.urls[i].host,
				port : config.urls[i].port,
				method: config.urls[i].method,
				path : strformat(strformat(config.urls[i].url, pathVariable),req.query)
		};
		var functionOne = function(callback) {
			opt = options[j];
			var httpreq = http.request(opt, function(response) {
				var body = '';
				console.log('start call  request');
				response.on('data', function(data) {
					body += data;
				});
				response.on('end', function() {
					console.log('end ');
					result[0] = body;
					callback(null, result[0]);
				});
			});
			httpreq.on('error', function(ex) {
				message.errorResponse(res,ex);
				});
			httpreq.end();
			j++
		};

		stack.push(functionOne);
	}
	if (config.executiontype == "parallel") {
		async.parallel(stack, function(error, result) {
			message.status200RespWithdata(res, result);
			console.log("Parrelel execution in last");
			logger.info("Parrelel execution result: "+result);
		});
	} else {
		async.series(stack, function(error, result) {
			message.status200RespWithdata(res, result);
			console.log("series execution in last");
			logger.info("series execution result: "+result);
		});
	}
	logger.info('End of method');
};

module.exports = {
		sendRequest : sendRequest
};