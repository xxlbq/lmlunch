/************************************************
 * 常量
 *
 ************************************************/
var RATE_GET_URL = "getRate.do";
 
/************************************************
 * Response 常量
 *
 ************************************************/
var ResponseStatus = new Object();
ResponseStatus.SUCCESS = 0;
ResponseStatus.ERROR = 1;
ResponseStatus.ERROR_PARAM_CURRENCYPAIR = 2;
ResponseStatus.ERROR_NO_RATE = 3;
ResponseStatus.CONNECT_SERV_FAIL = 999;

/************************************************
 * 日文信息
 ************************************************/
var ErrorMsg = new Object();
ErrorMsg.ERROR = "内部処理にてエラーが発生しました。システム管理者へ連絡してください。";
ErrorMsg.ERROR_PARAM_CURRENCYPAIR = "通貨ペアが違います。";
ErrorMsg.ERROR_NO_RATE = "レートがありません。";
ErrorMsg.CONNECT_SERV_FAIL = "サーバ接続に失敗しました。システム管理者へ連絡してください。"

/************************************************
 * Methods
 ************************************************/
function mapErrMsg(code) {
	switch (code) {
	case ResponseStatus.ERROR:
		return ErrorMsg.ERROR;
	case ResponseStatus.ERROR_PARAM_CURRENCYPAIR:
		return ErrorMsg.ERROR_PARAM_CURRENCYPAIR;
	case ResponseStatus.ERROR_NO_RATE:
		return ErrorMsg.ERROR_NO_RATE;
	}
}

function getSpotRateInfo(currencyPair, successCallback, failCallback) {
   var url = RATE_GET_URL + "?pair=" + currencyPair;
   new Ajax.Request(url, 
       { method:'post',  
		asynchronous:'true' , 
        onSuccess: function(transport){
			try {
				var responseText = transport.responseText;
				var result = eval("(" + responseText + ")");
				
				if (result == null) {
					fail(failCallback);
					return;
				}
			
			var status = result.status;
				
				if (status == null) {
					fail(failCallback);
					return;
				}
				
				if (status.statusCode == null) {
					fail(failCallback);
					return;
				}
				
			switch (status.statusCode) {
			case ResponseStatus.SUCCESS:
				if (successCallback != null) {
				
					var data = result.data;
				
					if (data == null) {
						fail(failCallback);
						return;
					}
				
					var rateInfo = convertRateInfo(data);
					successCallback(rateInfo);
				}
				break;
			case ResponseStatus.ERROR:
	        	var err = new Object();
	        	err.code = status.statusCode;
	        	err.message = mapErrMsg(status.statusCode);
	        	if (failCallback != null) {
	        		failCallback(err);
	        	}
				break;
			case ResponseStatus.ERROR_PARAM_CURRENCYPAIR:
	        	var err = new Object();
	        	err.code = status.statusCode;
	        	err.message = mapErrMsg(status.statusCode);
	        	if (failCallback != null) {
	        		failCallback(err);
	        	}
				break;
			case ResponseStatus.ERROR_NO_RATE:
	        	var err = new Object();
	        	err.code = status.statusCode;
	        	err.message = mapErrMsg(status.statusCode);
	        	if (failCallback != null) {
	        		failCallback(err);
	        	}
				break;
			case ResponseStatus.CONNECT_SERV_FAIL:
	        	var err = new Object();
	        	err.code = status.statusCode;
	        	err.message = mapErrMsg(status.statusCode);
	        	if (failCallback != null) {
	        		failCallback(err);
	        	}
				break;
			}
			
			} catch(e) {
				fail(failCallback);
				return;
			}
        },
        onFailure: function(){
        	var err = new Object();
        	err.code = ResponseStatus.CONNECT_SERV_FAIL;
        	err.message = ErrorMsg.CONNECT_SERV_FAIL;
        	if (failCallback != null) {
        		failCallback(err);
        	}
        }
       }
   );
}

function fail(failCallback) {
	var err = new Object();
	err.code = ResponseStatus.ERROR;
	err.message = ErrorMsg.ERROR;
	if (failCallback != null) {
		failCallback(err);
	}
}

function convertRateInfo(data) {
	var result = new Object();
	result.currencyPair = data.currencyPair;
	result.askRate = new Number(data.askRate);
	result.bidRate = new Number(data.bidRate);
	result.highRate = new Number(data.highRate);
	result.lowRate = new Number(data.lowRate);
	result.currencyDecimal = new Number(data.currencyDecimal);
	return result;
}

