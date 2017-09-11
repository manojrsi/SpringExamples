/**
 * Start of concurrent-ms service 
 */

var express = require('express');
var app = express();
var readFile = require('./util/readconfig');
var config = readFile.reader();

//initialize the logger.
var logger = require('avs-commons-logging-nodejs')(config.log.path, config.log.level, '.yyyy-MM-dd');

app.use(function(req, res, next) {
    function afterResponse() {
    	logger.info('Response Generated');
        res.removeListener('finish', afterResponse);
        res.removeListener('close', afterResponse);
    }
    res.on('finish', afterResponse);
    res.on('close', afterResponse);

    logger.info('Concurrent Service Started');
    next();
});

app.use('/', require('./api/interceptor'));
app.use('/', require('./api/get-request'));

//all environments
app.set('port', process.env.PORT || 4000);
app.listen(app.get('port'));
console.log('You are listening to port: ' + app.get('port'));
logger.info('Node Server Port: ' + app.get('port'));