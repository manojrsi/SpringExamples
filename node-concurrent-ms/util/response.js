function response(){
      this.response = [];
      };


var status200RespWithNoData = function(res) {
	res.writeHead(200, {"Content-Type" : "application/json"});
	res.end();
};

var status200RespWithdata = function(res, data) {
	var instance=new response();
	
	for(var i=0;i<data.length;i++)
		{
		instance.response[i]=JSON.parse(data[i]);
		}
	res.writeHead(200, {"Content-Type" : "application/json"});
	res.write(JSON.stringify(instance));
	res.end();
};

var status200waterfallWithdata=function(res, data) {
	var instance=new response();
	console.log(data);
	instance.response=JSON.parse(data);

	res.writeHead(200, {"Content-Type" : "application/json"});
	res.write(JSON.stringify(instance));
	res.end();
};

var errorResponse = function(res, err) {
	jsonErrorResponse.description = err;
	res.writeHead(500, {"Content-Type" : "application/json"});
	res.write(JSON.stringify(jsonErrorResponse));
	res.end();
};

var missingParamResponse = function(res) {
	res.writeHead(500, {"Content-Type" : "application/json"});
	res.write({'Error' : '500, Mandatory data not provided!!'});
	res.end();
};

var noDataResponse = function(res) {
	res.writeHead(500, {"Content-Type" : "application/json"});
	res.write({'Error' : '500, requested data not available!!'});
	res.end();
};

module.exports = {
		status200RespWithNoData: status200RespWithNoData,
		status200RespWithdata: status200RespWithdata,
		status200waterfallWithdata : status200waterfallWithdata,
		errorResponse: errorResponse,
		missingParamResponse: missingParamResponse,
		noDataResponse: noDataResponse
};

var jsonErrorResponse = {
		errorCode: '404',
		message: 'Internal server error',
		description:''
};