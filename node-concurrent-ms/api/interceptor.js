/**
 * Module to intercept all get request
 */
var express = require('express');
var router = express.Router();
var readFile = require('../util/readconfig');

function validateRequest(){
	console.log("validateRequest Called....");
}

function getRouteHandler(req, res, next) {
	// res.send('some json');

	console.log("Alll .......");

	var path=req.params[0].split("/");
	var config = readFile.reader();
	for (var requestData of config.reqdata) {
		console.log("requestData.requestname : "+requestData.requestname);
		console.log("path[0] : "+path[0]);
		if (requestData.requestname === path[0]) {
			for (var urls of requestData.urls) {

				console.log("urls.intercept : "+urls.intercept);
				var intercept = urls.intercept;
				console.log("intercept "+intercept);
				if( typeof intercept != 'undefined' || intercept != null ) {
					console.log("options[j] intercept "+intercept);
					validateRequest();
				}
			}
		}
	}
	next();

}

router.route('/*').get(getRouteHandler);
module.exports = router;