/************************************************
 * 常量定义
 *
 ************************************************/
// 表格显示每行的背景颜色
var bg0 = "#dfd7ce";
var bg1 = "#ffffff";
var class1_1 = "table_color_1";
var class1_2 = "table_color_2";
var class2_1 = "table_nocolor_1";
var class2_2 = "table_nocolor_2";
// 数值变化时单元格背景的变化颜色
var upStyle = "#0000FF";
var downStyle = "#FF0000";
var upEndColor = "FF6666";
var downEndColor = "66FF66";
// 对货币对统计的table的id
var currencyPairTabId = "currencyPairTab";
// 对货币统计的table的id
var currencyTabId = "currencyTab";
// 查询请求的url
var actionUrl = "stayPosiPl.do";
// 查询提交的间隔时间，毫秒单位
var intervalTime = 2000;

/************************************************
 * Response 常量
 *
 ************************************************/
var ResponseStatus = new Object();
ResponseStatus.SUCCESS = 0;
ResponseStatus.ERROR = 1;
ResponseStatus.PARAM_ERROR_CURRENCYAIR = 2;
ResponseStatus.PARAM_ERROR_DEALTYPE = 3;
ResponseStatus.COVER_ERROR = 4;
ResponseStatus.COVER_ALL_ERROR = 5;
ResponseStatus.CLOSED_MARKET = 6;
ResponseStatus.COVER_TIME_OUT = 7;
ResponseStatus.COVER_FAIL = 8;
ResponseStatus.COVER_ALL_FAIL = 9;
ResponseStatus.COVER_PARTIAL_SUCCESS = 10;

/************************************************
 * 日文信息
 ************************************************/
var connectServFail = "サーバ接続に失敗しました。システム管理者へ連絡してください。";
var defaultErrorMsg = "内部処理にてエラーが発生しました。システム管理者へ連絡してください。";
var dealFailureMsg = "Dealが失敗しました。";
var dealFinishMsg = "Dealが完了しました。";
var coverAllFailureMsg = "全部COVERが失敗しました。";
var coverAllFinishMsg = "全部COVERが完了しました。";
var coverErrorMsg = "内部処理にてエラーが発生しました。システム管理者へ連絡してください。";
var currencyPairErrMsg = "通貨ペアが違います。";
var dealTypeErrMsg = "Dealのタイプが違います。";
var closedMarket = "市場がクローズした。";
var timeoutMsg = "Dealがタイムアウトになっています。";

/************************************************
 * 全局变量
 ************************************************/
//单元格背景颜色渐变时使用，保存需要渐变的元素及渐变色
var highlightList = new Array();
//自动刷新时通过 setInterval设定的时间间隔对象
var stayPosiRequestInterval;
//自动刷新开关,true-页面自动刷新,false-页面不自动刷新,一般调试的时候使用
var autoSwitch = true;
//是否正在手动cover，点击deal 或coverall时都会设置true
var manulCovering = false;

/************************************************
 * 函数定义
 ************************************************/
/**
 * 将要产生渐变色的单元格及添加到highlight缓冲区中
 * @param element 单元格元素
 * @param value 用来判断增长还是下降的值
 * @param bgColor 原始的背景色, 渐变后会恢复成这个颜色
 */
function highlight(element, value, bgColor) {
	if (value > 0 || value < 0) {
		highlightList.push(new Array(element, value, bgColor));
	}
}

/**
 * 对highlight缓冲区的元素进行颜色渐变显示.
 */
function doHighlight() {
	for (i = 0; i < highlightList.length; i++) {
		element = highlightList[i][0];
		value = highlightList[i][1];
		oldBg = highlightList[i][2];
		effectArgs = null;
		if (value > 0) {
			effectArgs = {startcolor:oldBg, endcolor:upEndColor, restorecolor:oldBg};
		} else {
			effectArgs = {startcolor:oldBg, endcolor:downEndColor, restorecolor:oldBg};
		}
		new Effect.Highlight(element.id, effectArgs);
	}
	highlightList = new Array();
}

/**
 * 显示进度条
 */
function showProgressIndicator() {
	var indicator = $("progressBar");
	indicator.style.position="absolute";
	indicator.style.visibility='visible';
	indicator.style.left = document.body.scrollLeft + 320 + "px";
	indicator.style.top = document.body.scrollTop + 220 + "px";
}

/**
 * 根据浏览器滚动条的位置, 对进度条的位置进行调整, 使之保持在屏幕固定的位置
 */
function progressIndicatorPosiAdjust() {
	var indicator = $("progressBar");
	var visi = indicator.style.visibility;
	if (visi == 'visible') {
		indicator.style.position="absolute";
		indicator.style.left = document.body.scrollLeft + 320 + "px";
		indicator.style.top = document.body.scrollTop + 220 + "px";
	}
}

/**
 * 隐藏进度条
 */
function hideProgressIndicator() {
	var indicator = $("progressBar");
	indicator.style.position="absolute";
	indicator.style.visibility='hidden';
	indicator.style.left = "320px";
	indicator.style.right = "220px";
}

/**
 * 显示tooltip提示
 * @param x 坐标x
 * @param y 坐标y
 * @param msg 提示信息
 */
function showTip(x, y, msg) {
	var tipBar = $("tipBar");
	var tipMessage = $("tipMessage");
	if(tipBar == null) {
		return;
	}
	if (tipMessage == null) {
		return;
	}
	appendText(tipMessage, msg);
	tipBar.style.position="absolute";
	tipBar.style.visibility = "visible";
	tipBar.style.left = document.body.scrollLeft + x + "px";
	tipBar.style.top = document.body.scrollTop + y + "px";
}

/**
 * 隐藏tooltip 提示
 */
function hideTip() {
	var tipBar = $("tipBar");
	tipBar.style.position="absolute";
	tipBar.style.visibility='hidden';
}

/**
 * 显示页面刷新时的进度条
 */
function showLoadingBar(x, y) {
	var bar = $("loadingBar");
	if(bar == null) {
		return;
	}
	bar.style.position="absolute";
	bar.style.visibility = "visible";
	bar.style.left = x + "px";
	bar.style.top = y + "px";
}

/**
 * 隐藏页面刷新时的进度条
 */
function hideLoadingBar() {
	var bar = $("loadingBar");
	bar.style.position="absolute";
	bar.style.visibility='hidden';
}

/**
 * 在一个table行中查找一个单元格。
 * @pamra row tr元素
 * @param cellId td的id属性
 */
function findCell(row, cellId) {
	var cells = row.cells;
	if (cells == null) {
		return null;
	} else {
		for (i = 0; i < cells.length; i++) {
			if (cellId == cells[i].getAttribute("id")) {
				return cells[i];
			}
		}
		return null;
	}
}

/**
 * 将数值字符串转换为 Number 对象
 * @param str 一个数值的字符串,比如 "12"
 */
function convertNumber(str) {
	if (str == null || str == "") {
		return null;
	} else {
		return new Number(str);
	}
}

/**
 * 将每货币对的 JSON对象转换为 Object bean.
 * @param currencyPairResult JSON对象
 */
function converObj(currencyPairResult) {
	var currencyPairObj = new Array(currencyPairResult.length);
	var list = currencyPairResult;
	var arr;
	var bean;
	for (i = 0; i < list.length; i++) {
		arr = list[i];
		bean = new Object();
		j = 0;
		bean.currencyPair = arr[j++];
		bean.stayStatus = arr[j++];
		bean.longAmount = arr[j++];
		bean.longAmountIncrement = arr[j++];
		bean.shortAmount = arr[j++];
		bean.shortAmountIncrement = arr[j++];
		bean.longCostRate = arr[j++];
		bean.longCostRateIncrement = arr[j++];
		bean.shortCostRate = arr[j++];
		bean.shortCostRateIncrement = arr[j++];
		bean.totalAmount = arr[j++];
		bean.totalAmountIncrement = arr[j++];
		bean.totalCostRate = arr[j++];
		bean.totalCostRateIncrement = arr[j++];
		bean.bestBidRate = arr[j++];
		bean.bestBidRateIncrement = arr[j++];
		bean.bestBidRatePip = arr[j++];
		bean.bestBidRatePipIncrement = arr[j++];
		bean.bestAskRate = arr[j++];
		bean.bestAskRateIncrement = arr[j++];
		bean.bestAskRatePip = arr[j++];
		bean.bestAskRatePipIncrement = arr[j++];
		bean.longStayTime = arr[j++];
		bean.longStayTimeLevel = convertNumber(arr[j++]).valueOf();
		bean.longStayTimeIncrement = arr[j++];
		bean.shortStayTime = arr[j++];
		bean.shortStayTimeLevel = convertNumber(arr[j++]).valueOf();
		bean.shortStayTimeIncrement = arr[j++];
		bean.conversionRate = arr[j++];
		bean.conversionRateIncrement = arr[j++];
		bean.longPl = arr[j++];
		bean.longPlIncrement = arr[j++];
		bean.shortPl = arr[j++];
		bean.shortPlIncrement = arr[j++];
		bean.totalPl = arr[j++];
		bean.totalPlIncrement = arr[j++];
		bean.longFeed = arr[j++];
		bean.shortFeed = arr[j++];
		bean.unknownAmount = arr[j++];
		bean.unknownAmountIncrement = arr[j++];
		bean.todayTotalPl = arr[j++];
		bean.todayTotalPlIncrement = arr[j++];
		currencyPairObj[i] = bean;
	}

	return currencyPairObj;
}

/**
 * 显示信息框, 模态的, 本质是调用的alert.
 * 会先停止自动刷新, 提示信息后, 在启动自动刷新.
 * @param msg 信息
 */
function showMessage(msg) {
	stopAutoRequest();
	alert(msg);
	autoRequest();
}

/**
 * 显示error信息, 模态的, 本质是调用的alert.
 * 会先停止自动刷新, 提示信息后, 不再启动自动刷新.
 * @param msg 信息
 */
function showErrMessage(msg) {
	stopAutoRequest();
	alert(msg);
}

/**
 * 显示连接错误信息, 模态的, 本质是调用的alert.
 * 会先停止自动刷新, 提示信息后, 不再启动自动刷新.
 */
function showConnectFail() {
	stopAutoRequest();
	alert(connectServFail);
	var searchErr = $("searchErr");
	searchErr.style.visibility='visible';
}

/**
 * 点击deal连接后, 提示的确认框.
 */
function confirmDeal() {
	return confirm("Dealを実行します。");
}

/**
 * 点击cover all按钮后, 提示的确认框.
 */
function confirmCoverAll() {
	return confirm("全部COVERを実行します。");
}

/**
 * 停止自动刷新.
 */
function stopAutoRequest() {
	if (stayPosiRequestInterval) {
		clearInterval(stayPosiRequestInterval);
		stayPosiRequestInterval = null;
	}
}

/**
 * 使coverall按钮可用.
 */
function enableCoverAllBtn() {
	var btn = $("btnCoverAll");
	if (btn) {
		if(btn.disabled) {
			btn.disabled = false;
		}
	}
}

/**
 * 禁用coverall按钮
 */
function disableCoverAllBtn() {
	var btn = $("btnCoverAll");
	if (btn) {
		if(!btn.disabled) {
			btn.disabled = true;
		}
	}
}

/**
 * 向一个元素追加文本.
 */
function appendText(element, text) {
	if (element.firstChild) {
		element.firstChild.nodeValue = text;
	} else {
		element.appendChild(document.createTextNode(text));
	}
}

/**
 * 执行coverall.
 */
function coverAll() {
	if(! confirmCoverAll() ) {
		return ;
	}
	
	manulCovering = true;
	showProgressIndicator();
	
	stopAutoRequest();
	var param = "?method=coverall";
    var url = actionUrl + param;
    new Ajax.Request(url, 
        { method:'post',  
        asynchronous:'true' , 
        onSuccess: function(transport){
        		manulCovering = false;
        		hideProgressIndicator();
        		
				var responseText = transport.responseText;
				enableCoverAllBtn();
				var result = eval("(" + responseText + ")");
				var status = result.status;
				switch (status.code) {
				case ResponseStatus.SUCCESS:
					showMessage(coverAllFinishMsg);
					break;
				case ResponseStatus.ERROR:
					showMessage(defaultErrorMsg);
					break;
			 	case ResponseStatus.COVER_ALL_ERROR:
			 		showMessage(coverErrorMsg);
			 		break;
			 	case ResponseStatus.COVER_ALL_FAIL:
			 		showMessage(coverAllFailureMsg);
			 		break;
			 	case ResponseStatus.CLOSED_MARKET:
			 		showMessage(closedMarket);
			 		break;
			 	case ResponseStatus.COVER_TIME_OUT:
			 		showMessage(timeoutMsg);
			 		break;
			 	case ResponseStatus.COVER_PARTIAL_SUCCESS:
			 		var data = result.data;
			 		var msg = "";
			 		for (i = 0; i < data.length; i++) {
			 			if (i > 0) {
			 				msg = msg + "\n";
			 			}
			 			msg = msg.concat("Rejected 5 counts,");
			 			msg = msg.concat(" " + data[i].currencyPair);
			 			msg = msg.concat(" " + fmtNumber(data[i].amount));
			 			msg = msg.concat(" for All CP");
			 		}
			 		showMessage(msg);
			 		break;
			 	}
            },
        onFailure: function(){
       		manulCovering = false;
       		hideProgressIndicator();
        	enableCoverAllBtn();showConnectFail();
        	}
        }
    );
    autoRequest();
}

/**
 * 执行deal。
 * @param type deal的类型. 0-longDeal, 1-shortDeal, 2-totalDeal
 * @param pair 货币对
 */
function dealRequest(type, pair) {
	if (! confirmDeal()) {
		return ;
	}
	
	manulCovering = true;
	showProgressIndicator();
	
	var cell;
	
	if (type == 0) {
		cell = $("td_longDeal_".concat(pair));
	} else if (type == 1) {
		cell = $("td_shortDeal_".concat(pair));
	} else if (type == 2) {
		cell = $("td_totalDeal_".concat(pair));
	}
	
	disableDealLink(cell, pair);
	stopAutoRequest();
	var param = "?method=search";
	if (type == 0) {
		param = "?method=cover&type=0&pair=" + pair;
	} else if (type == 1) {
		param = "?method=cover&type=1&pair=" + pair;
	} else {
		param = "?method=cover&type=2&pair=" + pair;
	}
	
    var url = actionUrl + param;
    new Ajax.Request(url, 
        { method:'post',  
        asynchronous:'true' , 
        onSuccess: function(transport){
        		manulCovering = false;
        		hideProgressIndicator();
				var responseText = transport.responseText;
				var result = eval("(" + responseText + ")");
				var status = result.status;
				switch (status.code) {
				case ResponseStatus.SUCCESS:
					showMessage(dealFinishMsg);
					break;
				case ResponseStatus.ERROR:
					showMessage(defaultErrorMsg);
					break;
			 	case ResponseStatus.PARAM_ERROR_CURRENCYAIR:
			 		showMessage(currencyPairErrMsg);
			 		break;
			 	case ResponseStatus.PARAM_ERROR_DEALTYPE:
			 		showMessage(dealTypeErrMsg);
			 		break;
			 	case ResponseStatus.COVER_ERROR:
			 		showMessage(coverErrorMsg);
			 		break;
			 	case ResponseStatus.COVER_FAIL:
			 		showMessage(dealFailureMsg);
			 		break;
			 	case ResponseStatus.CLOSED_MARKET:
			 		showMessage(closedMarket);
			 		break;
			 	case ResponseStatus.COVER_TIME_OUT:
			 		showMessage(timeoutMsg);
			 		break;
			 	case ResponseStatus.COVER_PARTIAL_SUCCESS:
			 		var data = result.data;
			 		var msg = "Rejected 5 counts,";
		 			msg = msg.concat(" " + data.currencyPair);
		 			msg = msg.concat(" " + fmtNumber(data.amount));
		 			msg = msg.concat(" for All CP");
			 		showMessage(msg);
			 		break;
			 	}
            },
        	onFailure: function(){
        		manulCovering = false;
        		hideProgressIndicator();
        		showConnectFail();
        	}
        }
    );
    autoRequest();
}

/**
 * 向table单元格追加一个deal链接.
 * @param element 单元格元素
 * @param currencyPair 货币对
 * @param type deal的类型. 0-longDeal, 1-shortDeal, 2-totalDeal
 * @param value longAmount/shortAmount/totalAmount,根据此amount来设置该链接是否可以点击.
 */
function appendDealLink(element, currencyPair, type, value) {
	var nodes = element.childNodes;
	var link;
	var id = element.getAttribute("id") + "link";

	for (i = 0; i < nodes.length; i++) {
		link = null;
		if (nodes[i].getAttribute("id") == id) {
			link = nodes[i];
			break;
		}
	}
	
	if (link == null) {
		link = document.createElement("a");
		link.setAttribute("id", id);
		appendText(link, "Deal");
		element.appendChild(link);
	}
	
	if (value > 0 || (value < 0 && type == 2)) {
		link.setAttribute("href", "javascript:void(0)");
		link.style.color="#0000FF";
		link.setAttribute("onclick", function(){dealRequest(type,currencyPair);});
	} else {
		link.removeAttribute("href");
		link.setAttribute("onclick", function(){});
		link.style.color="#888888";
	}
}

/**
 * 禁用deal链接, 使其点击后不起作用
 * @param element 包含deal链接的单元格元素
 * @param currencyPair 货币对
 */
function disableDealLink(element, currencyPair) {
	var nodes = element.childNodes;
	var link;
	var id = element.getAttribute("id") + "link";

	for (i = 0; i < nodes.length; i++) {
		link = null;
		if (nodes[i].getAttribute("id") == id) {
			link = nodes[i];
			break;
		}
	}
	if (link != null) {
		link.removeAttribute("href");
		link.setAttribute("onclick", function(){});
		link.style.color="#888888";
	}
}

/**
 * 打开顾客约定明细画面
 * @param currencyPair
 * @return
 */
function showStayPosiCustExecutions(currencyPair){
	window.open("cpSpotSearch.do?method=showCusExecution&type=2&pair=" + currencyPair,'','scrollbars=yes,top=100,left=100,width=1000,height=600');
}

/**
 * 在显示货币对的那一列单元格添加货币对的链接.
 * @param element 单元格元素
 * @param currencyPair 货币对
 */
function appendCurrencyPairLink(element, currencyPair) {
	var link = document.createElement("a");
	link.setAttribute("href", "javascript:showStayPosiCustExecutions('" + currencyPair + "')");
	//link.setAttribute("onclick", function(){showStayPosiCustExecutions(currencyPair);});
	appendText(link, currencyPair);
	element.appendChild(link);
}

/**
 * 设置unknown数量的链接.
 * @param element 包含链接的单元格元素
 * @param currencyPair 货币对
 * @param value unknown的数量, 要作为链接的文本显示
 */
function setUnknownLink(element, currencyPair, value) {
	var nodes = element.childNodes;
	var id = "a_unknownAmount_" + currencyPair;
	var link = $(id);
	var href = "cpSpotUnknown.do?method=search&pair=" + currencyPair;
	if (link == null) {
		link = document.createElement("a");
		link.setAttribute("id", id);
		if (value != 0) {
			link.setAttribute("href", href);
		} else {
			link.removeAttribute("href");
		}
		link.setAttribute("target", "cpSportUnknown")
		appendText(link, fmtNumber(value));
		element.appendChild(link);
	} else {
		if (value != 0) {
			link.setAttribute("href", href);
		} else {
			link.removeAttribute("href");
		}
		appendText(link, fmtNumber(value));
	}

}

/**
 * 设置某数值文本的前景色, 大于0蓝色，小于0红色
 * @param element 包含文本的单元格元素
 * @param value 数值.
 */
function setUpDownColor(element, value) {
	var color = "";
	if (value > 0) {
		color = upStyle;
	} else if (value < 0){
		color = downStyle;
	}
	element.style.color = color;
}

/**
 * 向一个元素中设置文本.
 * @param id 元素的id
 * @param value 文本
 */
function setValue(id, value) {
	$(id).firstChild.nodeValue = value;
}

/**
 * 设置某元素的某个属性值
 * @param id 该元素的id
 * @param attrib 元素属性名, 比如: align, width等
 * @param value 属性值
 * @return
 */
function setAttributeValue(id, attrib, value) {
	$(id).setAttribute(attrib, value);
}

/**
 * 手动刷新页面
 * @return
 */
function manulRequest() {
	requestSearch();
}

/**
 * 自动刷新页面
 * @return
 */
function autoRequest() {
	showLoadingBar(480, 160);
	requestSearch();
	
	if (autoSwitch) {
		if (stayPosiRequestInterval == null) {
			stayPosiRequestInterval = setInterval("requestSearch()", intervalTime);
		}
	}
}

/**
 * 提交刷新页面的请求, 并刷新页面
 * @return
 */
function requestSearch() {
	if (manulCovering) {
		return;
	}
	
    var url = actionUrl + "?method=search";
    new Ajax.Request(url, 
        { method:'post',  
			asynchronous:'true' , 
	        onSuccess: function(transport){
	        	hideLoadingBar();
				if (manulCovering) {
					return;
				}
				var responseText = transport.responseText;
				handleResponse(responseText);
	        },
	        onFailure: function(){
	        	hideLoadingBar();
				if (manulCovering) {
					return;
				}
	        	showConnectFail();
	        }
        }
    );
}

/**
 * 查找在一个bean列表中, 是否对应某个id, 主要是对应按货币对儿统计部分的table
 * @param id 格式为: "tr_${currencyPair}",列如"tr_USD/JPY"
 * @param beans
 * @return
 */
function findCurrencyPairResultBean(id, beans) {
	for (i = 0; i < beans.length; i++) {
		bean = beans[i];
		if (id == "tr_" + bean.currencyPair) {
			return true;
		}
	}
	return false;
}

/**
 * 查找在一个bean列表中, 是否对应某个id, 主要是对应按货币统计部分的table
 * @param id 格式为: "tr_${currency}",列如"tr_JPY"
 * @param beans
 * @return
 */
function findCurrencyResultBean(id, beans) {
	for (bean in beans) {
		if (id == "tr_" + bean.currency) {
			return true;
		}
	}
	return false;
}

/**
 * 处理http response的字符流, 转换成js的object, 然后加以显示
 * @param responseText http response的字符流
 * @return
 */
function handleResponse(responseText) {
    var result = eval('(' + responseText + ')');
	var status = result.status;
	switch (status.code) {
	case ResponseStatus.ERROR:
		showErrMessage(defaultErrorMsg);
		break;
 	}
    
    showUpdateTime(result.updateTime);
    
	var stayPositionPlBean = result.data;
	if (stayPositionPlBean != null) {
		stayPositionPlBean.currencyPairResult = converObj(stayPositionPlBean.currencyPairResult);
		showResult(stayPositionPlBean);
	}
}

/**
 * 显示当前页面的刷新的时间
 * @param time
 * @return
 */
function showUpdateTime(time) {
	var element = $("updateTime");
	appendText(element, time);
}

//格式化数值, 利用MochiKit提供的格式工具
var defaultNumberFormatter = MochiKit.Format.numberFormatter("###,###");

/**
 * 格式化数值
 * @param value
 * @return
 */
function fmtNumber(value) {
	return defaultNumberFormatter(value);
}

/**
 * 根据level得到对应的时间等级，然后和value组合.
 * level:
 *   1 - m, 分钟级
 *   2 - h, 小时级
 *   3 - d, 日级
 *   4 - M, 月级
 *   5 - y, 年级
 *   其它数值代表 秒级.
 */
function computeStayTime(value, level) {
	switch (level) {
	case 1:
		return value + " m";
	case 2:
		return value + " h";
	case 3:
		return value + " d";
	case 4:
		return value + " M";
	case 5:
		return value + " y";
	default:
		return value + "";
	}
}

/**
 * 将查询的结果显示在网页上.
 * 该方法利用了DOM操作对网页元素进行更新.
 * @param stayPositionPlBean 包含了返回结果数据的bean
 */
function showResult(stayPositionPlBean) {
	var currencyPairResult = stayPositionPlBean.currencyPairResult;
	var currencyResult = stayPositionPlBean.currencyResult;
	var index = 2;
	var bg = bg0;
	var bgClass1 = class1_1;
	var bgClass2 = class1_2;
	var currencyPairTab = $(currencyPairTabId + "Body");
	var currencyTab = $(currencyTabId);
    var currencyPair;
    var row;
    var row2;
    var cell;

    /*
     * 处理货币对结果部分
     */
    var rows = currencyPairTab.rows;
    var i = 0;
    var j = 0;
    var found = false;
    // 如果最新的数据中某货币对已经不存在了, 那么需要从table中删除该行
    for (i = rows.length - 1; i > 1; i--) {
    	found = false;
		for (j = 0; j < currencyPairResult.length; j++) {
			if (rows[i].getAttribute("id") == "tr_"+currencyPairResult[j].currencyPair+"_0" ||
				rows[i].getAttribute("id") == "tr_"+currencyPairResult[j].currencyPair+"_1") {
				found = true;
				break;
			}
		}
		if (!found) {
			currencyPairTab.deleteRow(i);
		}
    }
    
    //显示前先禁用cover all 按钮
    disableCoverAllBtn();
    
	for(i = 0; i < currencyPairResult.length; i++) {
	    bean = currencyPairResult[i];
		if ((index / 2) % 2 == 1) {
			bg = bg0;
			bgClass1 = class1_1;
			bgClass2 = class1_2;
		} else {
			bg = bg1;
			bgClass1 = class2_1;
			bgClass2 = class2_2;
		}
	    currencyPair = bean.currencyPair;
		
	    // 只要有一个货币对有滞留交易, 就启用coverall 按钮
		if (bean.longAmount > 0 || bean.shortAmount > 0 || bean.totalAmount > 0) {
			enableCoverAllBtn();
		}

		var trId = "tr_" + currencyPair;
		row = $(trId + "_0");
		row2 = $(trId + "_1");
		var value;
		
		if (row) {
			/*
			 * 如果某货币对行存在那么就更新
			 */
			cell = findCell(row, "td_currencyPair_".concat(currencyPair));
			value = currencyPair;
			setValue(cell, value);
			setAttributeValue(cell, "className", bgClass1);
			
			cell = findCell(row, "td_stayStatus_".concat(currencyPair));
			value = bean.stayStatus;
			setValue(cell, value);
			setAttributeValue(cell, "className", bgClass2);
			
			cell = findCell(row, "td_longAmount_".concat(currencyPair));
			value = bean.longAmount;
			setValue(cell, (value>0?"+":"") + fmtNumber(value));
			setAttributeValue(cell, "className", bgClass2);
			highlight(cell, bean.longAmountIncrement, bg);
			
			cell = findCell(row, "td_shortAmount_".concat(currencyPair));
			value = bean.shortAmount;
			setValue(cell, (value>0?"-":"") + fmtNumber(value));
			setAttributeValue(cell, "className", bgClass2);
			highlight(cell, bean.shortAmountIncrement, bg);
			
			cell = findCell(row, "td_totalAmount_".concat(currencyPair));
			value = bean.totalAmount;
			setValue(cell, fmtNumber(value));
			setAttributeValue(cell, "className", bgClass2);
			setUpDownColor(cell, value);
			highlight(cell, bean.totalAmountIncrement, bg);

			cell = findCell(row, "td_bestBidRate_".concat(currencyPair));
			value = bean.bestBidRate;
			setValue(cell, (value == null ? "-" : value));
			setAttributeValue(cell, "className", bgClass2);
			highlight(cell, bean.bestBidRateIncrement, bg);
			
			cell = findCell(row, "td_bestAskRate_".concat(currencyPair));
			value = bean.bestAskRate;
			setValue(cell, (value == null ? "-" : value));
			setAttributeValue(cell, "className", bgClass2);
			highlight(cell, bean.bestAskRateIncrement, bg);
			
			cell = findCell(row, "td_longFeed_".concat(currencyPair));
			value = bean.longFeed;
			setValue(cell, value);
			setAttributeValue(cell, "className", bgClass2);
			
			cell = findCell(row, "td_shortFeed_".concat(currencyPair));
			value = bean.shortFeed;
			setValue(cell, value);
			setAttributeValue(cell, "className", bgClass2);
			
			cell = findCell(row, "td_longStayTime_".concat(currencyPair));
			value = bean.longStayTime;
			setValue(cell, computeStayTime(value, bean.longStayTimeLevel));
			setAttributeValue(cell, "className", bgClass2);
			highlight(cell, bean.longStayTimeIncrement, bg);
			
			cell = findCell(row, "td_shortStayTime_".concat(currencyPair));
			value = bean.shortStayTime;
			setValue(cell, computeStayTime(value, bean.shortStayTimeLevel));
			setAttributeValue(cell, "className", bgClass2);
			highlight(cell, bean.shortStayTimeIncrement, bg);
			
			cell = findCell(row, "td_conversionRate_".concat(currencyPair));
			value = bean.conversionRate;
			setValue(cell, (value == null ? "-" : value));
			setAttributeValue(cell, "className", bgClass2);
			highlight(cell, bean.conversionRateIncrement, bg);
			
			cell = findCell(row, "td_longPl_".concat(currencyPair));
			value = bean.longPl;
			setValue(cell, (value == null ? "-" : fmtNumber(value)));
			setAttributeValue(cell, "className", bgClass2);
			setUpDownColor(cell, value);
			highlight(cell, bean.longPlIncrement, bg);
			
			cell = findCell(row, "td_shortPl_".concat(currencyPair));
			value = bean.shortPl;
			setValue(cell, (value == null ? "-" : fmtNumber(value)));
			setAttributeValue(cell, "className", bgClass2);
			setUpDownColor(cell, value);
			highlight(cell, bean.shortPlIncrement, bg);
			
			cell = findCell(row, "td_totalPl_".concat(currencyPair));
			value = bean.totalPl;
			setValue(cell, (value == null ? "-" : fmtNumber(value)));
			setAttributeValue(cell, "className", bgClass2);
			setUpDownColor(cell, value);
			highlight(cell, bean.totalPlIncrement, bg);
			
			value = bean.unknownAmount;
			cell = findCell(row, "td_unknownAmount_".concat(currencyPair));
			setAttributeValue(cell, "className", bgClass2);
			setUnknownLink(cell, currencyPair, value);
			highlight(cell, bean.unknownAmountIncrement, bg);
			
			cell = findCell(row, "td_longDeal_".concat(currencyPair));
			setAttributeValue(cell, "className", bgClass2);
			appendDealLink(cell, currencyPair, 0, bean.longAmount);
			
			cell = findCell(row, "td_shortDeal_".concat(currencyPair));
			setAttributeValue(cell, "className", bgClass2);
			appendDealLink(cell, currencyPair, 1, bean.shortAmount);
			
			cell = findCell(row, "td_totalDeal_".concat(currencyPair));
			setAttributeValue(cell, "className", bgClass2);
			appendDealLink(cell, currencyPair, 2, Math.abs(bean.longAmount) + Math.abs(bean.shortAmount));
		} else {
			/*
			 * 如果某货币对行不存在就插入
			 */
			row = currencyPairTab.insertRow(index);
			row.setAttribute("id", trId + "_0");

			var cellIndex = row.cells.length;
			value = currencyPair;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_currencyPair_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass1);
			cell.setAttribute("rowSpan", 2);
			appendCurrencyPairLink(cell, value);

			value = bean.stayStatus;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_stayStatus_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("rowSpan", 2);
			appendText(cell, value);
			
			value = bean.longAmount;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_longAmount_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, (value>0?"+":"") + fmtNumber(value));
			highlight(cell, bean.longAmountIncrement, bg);

			value = bean.shortAmount;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_shortAmount_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, (value>0?"-":"")  + fmtNumber(value));
			highlight(cell, bean.shortAmountIncrement, bg);
			
			value = bean.totalAmount;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_totalAmount_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, "" + fmtNumber(value));
			setUpDownColor(cell, value);
			highlight(cell, bean.totalAmountIncrement, bg);
			
			value = bean.bestBidRate;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_bestBidRate_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, (value == null ? "-" : value));
			highlight(cell, bean.bestBidRateIncrement, bg);
			
			value = bean.bestAskRate;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_bestAskRate_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, (value == null ? "-" : value));
			highlight(cell, bean.bestAskRateIncrement, bg);
			
			value = bean.longFeed;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_longFeed_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("rowSpan", 2);
			appendText(cell, value);
			
			value = bean.shortFeed;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_shortFeed_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("rowSpan", 2);
			appendText(cell, value);
			
			value = bean.longStayTime;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_longStayTime_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("rowSpan", 2);
			appendText(cell, computeStayTime(value, bean.longStayTimeLevel));
			highlight(cell, bean.longStayTimeIncrement, bg);
			
			value = bean.shortStayTime;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_shortStayTime_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("rowSpan", 2);
			appendText(cell, computeStayTime(value, bean.shortStayTimeLevel));
			highlight(cell, bean.shortStayTimeIncrement, bg);
			
			value = bean.conversionRate;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_conversionRate_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("rowSpan", 2);
			appendText(cell, (value == null ? "-" : value));
			highlight(cell, bean.conversionRateIncrement, bg);
			
			value = bean.longPl;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_longPl_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, (value == null ? "-" : fmtNumber(value)));
			setUpDownColor(cell, value);
			highlight(cell, bean.longPlIncrement, bg);
			
			value = bean.shortPl;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_shortPl_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, (value == null ? "-" : fmtNumber(value)));
			setUpDownColor(cell, value);
			highlight(cell, bean.shortPlIncrement, bg);
			
			value = bean.totalPl;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_totalPl_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			setUpDownColor(cell, value);
			appendText(cell, (value == null ? "-" : fmtNumber(value)));
			highlight(cell, bean.totalPlIncrement, bg);
			
			value = bean.unknownAmount;
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_unknownAmount_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("rowSpan", 2);
			setUnknownLink(cell, currencyPair, value);
			highlight(cell, bean.unknownAmountIncrement, bg);

			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_longDeal_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("rowSpan", 2);
			cell.setAttribute("className", bgClass2);
			appendDealLink(cell, currencyPair, 0, bean.longAmount);
			
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_shortDeal_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("rowSpan", 2);
			appendDealLink(cell, currencyPair, 1, bean.shortAmount);
			
			cell = row.insertCell(cellIndex++);
			cell.setAttribute("id", "td_totalDeal_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("rowSpan", 2);
			appendDealLink(cell, currencyPair, 2, Math.abs(bean.longAmount) + Math.abs(bean.shortAmount));
		}

		// 每个货币对都跨2行, 这里处理第二行内容的显示
		index++;
		if (row2) {
			// 存在就更新
			value = bean.longCostRate;
			cell = findCell(row2, "td_longCostRate_" + currencyPair);
			cell.setAttribute("className", bgClass1);
			setValue(cell, (value == 0 ? "-" : value));
			highlight(cell, bean.longCostRateIncrement, bg);
			
			value = bean.shortCostRate;
			cell = findCell(row2, "td_shortCostRate_" + currencyPair);
			cell.setAttribute("className", bgClass2);
			setValue(cell, value == 0 ? "-" : ((value>0?"-":"") + value));
			highlight(cell, bean.shortCostRateIncrement, bg);
			
			value = bean.totalCostRate;
			cell = findCell(row2, "td_totalCostRate_" + currencyPair);
			cell.setAttribute("className", bgClass2);
			setValue(cell, value == 0 ? "-" : value);
			highlight(cell, bean.totalCostRateIncrement, bg);
			
			value = bean.bestBidRatePip;
			cell = findCell(row2, "td_bestBidRatePip_" + currencyPair);
			cell.setAttribute("className", bgClass2);
			setValue(cell, (value == null ? "-" : Math.abs(value)));
			setUpDownColor(cell, value);
			highlight(cell, bean.bestBidRatePipIncrement, bg);
			
			value = bean.bestAskRatePip;
			cell = findCell(row2, "td_bestAskRatePip_" + currencyPair);
			cell.setAttribute("className", bgClass2);
			setValue(cell, (value == null ? "-" : Math.abs(value)));
			setUpDownColor(cell, value * -1);
			highlight(cell, bean.bestAskRatePipIncrement, bg);
			
			cell = findCell(row2, "td_todayTotalPl_".concat(currencyPair));
			value = bean.todayTotalPl;
			setValue(cell, (value == null ? "-" : fmtNumber(value)));
			cell.setAttribute("className", bgClass2);
			setUpDownColor(cell, value);
			highlight(cell, bean.todayTotalPlIncrement, bg);
		} else {
			// 不存在就插入
			row2 = currencyPairTab.insertRow(index);
			row2.setAttribute("id", trId + "_1");
			
			var cellIndex = row2.cells.length;
			value = bean.longCostRate;
			cell = row2.insertCell(cellIndex++);
			cell.setAttribute("id", "td_longCostRate" + "_" + currencyPair);
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass1);
			appendText(cell, (value == 0 ? "-" : value));
			highlight(cell, bean.longCostRateIncrement, bg);
			
			value = bean.shortCostRate;
			cell = row2.insertCell(cellIndex++);
			cell.setAttribute("id", "td_shortCostRate" + "_" + currencyPair);
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, value == 0 ? "-" : ((value>0?"-":"") + value));
			highlight(cell, bean.shortCostRateIncrement, bg);

			cell = row2.insertCell(cellIndex++);
			value = bean.totalCostRate;
			cell.setAttribute("id", "td_totalCostRate" + "_" + currencyPair);
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, value == 0 ? "-" : value);
			setUpDownColor(cell, value);
			highlight(cell, bean.totalCostRateIncrement, bg);
			
			cell = row2.insertCell(cellIndex++);
			value = bean.bestBidRatePip;
			cell.setAttribute("id", "td_bestBidRatePip" + "_" + currencyPair);
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, (value == null ? "-" : Math.abs(value)));
			setUpDownColor(cell, value);
			highlight(cell, bean.bestBidRatePipIncrement, bg);
			
			cell = row2.insertCell(cellIndex++);
			value = bean.bestAskRatePip;
			cell.setAttribute("id", "td_bestAskRatePip" + "_" + currencyPair);
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, (value == null ? "-" : Math.abs(value)));
			setUpDownColor(cell, value * -1);
			highlight(cell, bean.bestAskRatePipIncrement, bg);
			
			value = value = bean.todayTotalPl;
			cell = row2.insertCell(cellIndex++);
			cell.setAttribute("id", "td_todayTotalPl_".concat(currencyPair));
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			cell.setAttribute("colSpan", 3);
			cell.setAttribute("onmousemove", function(){showTip(event.clientX, event.clientY, '当日の累積Total P/L');});
			cell.setAttribute("onmouseout", function(){hideTip();});
			appendText(cell, (value == null ? "-" : fmtNumber(value)));
			setUpDownColor(cell, value);
			highlight(cell, bean.todayTotalPlIncrement, bg);
			
		}
		index++;
	}
	
	/*
	 * 按货币统计部分
	 */
	
	// 删除table中所有的数据行
	rows = currencyTab.rows;
    for (i = rows.length - 1; i > 1; i--) {
		for (j = 0; j < currencyResult.length; j++) {
			if (rows[i].getAttribute("id") == "tr_"+currencyResult[j].currency) {
				currencyTab.deleteRow(i);
				break;
			}
		}
    }
    
    // 设置最新请求得到的数据
    var currency;
	for(i = 0; i < currencyResult.length; i++) {
		element = currencyResult[i];
		if (i % 2 == 0) {
			bg = bg0;
			bgClass1 = class1_1;
			bgClass2 = class1_2;
		} else {
			bg = bg1;
			bgClass1 = class2_1;
			bgClass2 = class2_2;
		}
		
		currency = element.currency;
		var trId = "tr_" + currency;
		row = $(trId);
		if (row) {
			cell = $("td_pl_" + currency);
			setAttributeValue(cell, "className", bgClass2);
			setValue(cell, fmtNumber(element.pl));
			highlight(cell, element.plIncrement, bg);
			
			cell = $("td_todayPl_" + currency);
			setAttributeValue(cell, "className", bgClass2);
			setValue(cell, fmtNumber(element.todayPl));
			highlight(cell, element.todayPlIncrement, bg);
		} else {
			row = currencyTab.insertRow(i + 1);
			row.setAttribute("id", trId);
			
			cell = row.insertCell(row.cells.length);
			cell.setAttribute("id", "td_currency_" + currency);
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass1);
			appendText(cell, currency);
			
			cell = row.insertCell(row.cells.length);
			cell.setAttribute("id", "td_pl_" + currency);
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, "" + fmtNumber(element.pl));
			highlight(cell, element.plIncrement, bg);
			
			cell = row.insertCell(row.cells.length);
			cell.setAttribute("id", "td_todayPl_" + currency);
			cell.setAttribute("noWrap", "true");
			cell.setAttribute("className", bgClass2);
			appendText(cell, "" + fmtNumber(element.todayPl));
			highlight(cell, element.todayPlIncrement, bg);
		}
	}
	
	// show highlight
	doHighlight();
}

/*
 * 当浏览器的滚动条滚动时, 网页上的进度提示需要保持屏幕中间位置。
 */
window.onscroll = function() {progressIndicatorPosiAdjust()};
