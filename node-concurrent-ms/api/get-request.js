/**
 * Module to route all get request
 */

var express = require('express');
var app = express();
var router = express.Router();
var microController = require('../controllers/parallelSeriesController');
var waterfallController = require('../controllers/waterfallController');
var readFile = require('../util/readconfig');
var url = require("url");


//API version 1
router.use('/', router);

app.get('/*', function(req, res) {
	console.log("Get api.");
	var path=req.params[0].split("/");
	var config = readFile.reader();
	console.log('Config : '+JSON.stringify(config));
	var flag=true;
    
	for (var i = 0; i < config.reqdata.length; i++) {
		if (config.reqdata[i].requestname === path[0]) {
			flag=false;
			if (config.reqdata[i].executiontype == "parallel"
				|| config.reqdata[i].executiontype == "series") {
				console.log("@ msController called");
				microController.sendRequest(config.reqdata[i], req, res,path);
			} else {
				console.log("@ waterfallController called");
				waterfallController.sendRequest(config.reqdata[i], req, res);
			}
			break;
		}
	}
	if(flag)
		res.end();
});

module.exports = app;