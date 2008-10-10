<!--
function MM_openBrWindow(theURL,winName,features) {
  window.open(theURL,winName,features);
}

function fieldDisplayControlSpan(field, visibility) {
	field.style.visibility = (visibility) ? "visible" : "hidden";
}

function getSpansByName(name) {
	var   arr   =   document.getElementsByTagName("span");
	var   aResult   =   new   Array();

	for   (var   i=0;   i<arr.length;   i++) {
		if   (arr[i].id   ==   name) {
			aResult[aResult.length]   =   arr[i];
		}
	}
	
	return aResult;
}

function openWin1(){
	var popup = null;
	popup = window.open('','','width=543,height=280,resizable=0,scrollbars=yes,status=yes');
	
	if (popup != null) {
	
		popup.location.href = 'zipCodeSearch.do?zipSelect=1&zipCode='+document.forms[0].zipCode1.value;
	}
}

function openWin2(){
	var popup = null;
	popup = window.open('','','width=543,height=280,resizable=0,scrollbars=yes,status=yes');
	
	if (popup != null) {
	
		popup.location.href = 'zipCodeSearch.do?zipSelect=2&zipCode='+document.forms[0].zipCode2.value;
	}
}

function openWinChargeManZipCode(prefix, zipSelect){
	var popup = null;
	popup = window.open('','','width=543,height=280,resizable=0,scrollbars=yes,status=yes');
	
	if (popup != null) {
		zipCode = document.getElementsByName(prefix +".chargeManZipCode" + zipSelect)[0];
		popup.location.href = 'zipCodeSearch.do?prefix='+prefix+'&zipSelect='+zipSelect+'&zipCode='+zipCode.value;
	}
}

function checkPiNote() {
	var value1 = document.forms[0].principalIncome.value;
	var commentText = document.forms[0].piNote;
	
	if (value1 == '5') {
		commentText.style.display = "";
	} else {
		commentText.style.display = "none";
		commentText.value = "";
	}
}

function checkAddress2Star() {
	var value1 = document.forms[0].jobName.value;
	
	var address2star = getSpansByName("address2star");
	
	if (value1 == '' || value1 == '9' || value1 == '10' || value1 == '12' || value1 == '13') {
		for (i=0; i< address2star.length; i++) {
			fieldDisplayControlSpan(address2star[i], false);
		}
	} else {
		for (i=0; i< address2star.length; i++) {
			fieldDisplayControlSpan(address2star[i], true);
		}
	}
}

var useFinancialAssetsCheckBoxInnerHtml = null;

function checkUseFinancialAssetsCheckBox() {

	var jobNameValue = document.forms[0].jobName.value;
	var financialAssetsValue = document.forms[0].financialAssets.value;
	
	var useFinancialAssetsCheckBox = document.getElementById("useFinancialAssetsCheckBox");
	
	if (useFinancialAssetsCheckBoxInnerHtml == null) {
		useFinancialAssetsCheckBoxInnerHtml = useFinancialAssetsCheckBox.innerHTML;
	}
	
	// var innerHtml = '<br />投資資金はご自身の資産でお間違いありませんか？&nbsp;<input type="checkbox" name="useFinancialAssetsCheck" value="on">&nbsp;はい';
	
	if ((jobNameValue == '10' || jobNameValue == '12') && (financialAssetsValue == '0')) {
		useFinancialAssetsCheckBox.innerHTML = useFinancialAssetsCheckBoxInnerHtml;
		// fieldDisplayControlSpan(useFinancialAssetsCheckBox, true);
	} else {
		useFinancialAssetsCheckBox.innerHTML = '';
		// fieldDisplayControlSpan(useFinancialAssetsCheckBox, false);
	}
}

function checkJobNameNote() {
	var value1 = document.forms[0].jobName.value;
	var commentText = document.forms[0].jobNameNote;
	
	if (value1 == '13') {
		commentText.style.display = "";
	} else {
		commentText.style.display = "none";
		commentText.value = "";
	}
}

function checkIndustryTypeNote() {
	var value1 = document.forms[0].industryType.value;
	var commentText = document.forms[0].industryTypeNote;
	
	if (value1 == '21') {
		commentText.style.display = "";
	} else {
		commentText.style.display = "none";
		commentText.value = "";
	}
}

function checkContractPurpose() {
	var radio = document.forms[0].contractPurpose;
	var radioText = document.forms[0].contractPurposeComment;
	
	if (radio[6].checked) {
		radioText.disabled = false;
	} else {
		radioText.disabled = true;
		radioText.value = "";
	}
}

/*
function checkMjhfExperience() {
	var radio = document.forms[0].mjhfExperienceFlag;
	var radioText = document.forms[0].mjhfExperienceYear;
	
	if (radio[0].checked) {
		radioText.disabled = false;
	} else {
		radioText.disabled = true;
		radioText.value = "";
	}
}

function checkStockExperience() {
	var radio = document.forms[0].stockExperienceFlag;
	var radioText = document.forms[0].stockExperienceYear;
	
	if (radio[0].checked) {
		radioText.disabled = false;
	} else {
		radioText.disabled = true;
		radioText.value = "";
	}
}

function checkStockMarginExperience() {
	var radio = document.forms[0].stockMarginExperienceFlag;
	var radioText = document.forms[0].stockMarginExperienceYear;
	
	if (radio[0].checked) {
		radioText.disabled = false;
	} else {
		radioText.disabled = true;
		radioText.value = "";
	}
}

function checkStockIdxOptionExp() {
	var radio = document.forms[0].stockIdxOptionExpFlag;
	var radioText = document.forms[0].stockIdxOptionExpYear;
	
	if (radio[0].checked) {
		radioText.disabled = false;
	} else {
		radioText.disabled = true;
		radioText.value = "";
	}
}

function checkProductOptionExp() {
	var radio = document.forms[0].productOptionExpFlag;
	var radioText = document.forms[0].productOptionExpYear;
	
	if (radio[0].checked) {
		radioText.disabled = false;
	} else {
		radioText.disabled = true;
		radioText.value = "";
	}
}
*/

function checkOtherExperience() {
	var value1 = document.forms[0].otherExperience.value;
	var commentText = document.forms[0].otherExperienceYear;
	
	if (value1 != '') {
		commentText.disabled = false;
	} else {
		commentText.disabled = true;
		commentText.value = "";
	}
}

function checkDocumentSendAddressFlag() {
	var radio = document.forms[0].documentSendAddressFlag;
	
	var address2star = getSpansByName("address2star");
	
	var texts = new Array(6);
	texts[0]=document.forms[0].zipCode2;
	texts[1]=document.forms[0].city2;
	texts[2]=document.forms[0].section2;
	texts[3]=document.forms[0].sectionKana2;
	texts[4]=document.forms[0].buildingName;
	texts[5]=document.forms[0].buildingNameKana;
	
	if (radio[0].checked) {
		for (i=0; i<texts.length; i++) {
			if (texts[i]!=null) {
				texts[i].disabled=true;
			}
		}
		
		for (i=0; i< address2star.length; i++) {
			fieldDisplayControlSpan(address2star[i], false);
		}
	} else {
		for (i=0; i<texts.length; i++) {
			if (texts[i]!=null) {
				texts[i].disabled=false;
			}
		}
		
		for (i=0; i< address2star.length; i++) {
			fieldDisplayControlSpan(address2star[i], true);
		}
	}
}

function nst(t) {
  
  if (t == null) {
  	return;
  }
  
  var stmp = "";
  if(t.value==stmp) return;
  var ms = t.value.replace(/[^\d]/g,"");
  var txt = ms.split(".");
  while(/\d{4}(,|$)/.test(txt[0]))
    txt[0] = txt[0].replace(/(\d)(\d{3}(,|$))/,"$1,$2");

  stmp = txt[0]+(txt.length>1?"."+txt[1]:"");

  if (stmp != t.value) {
  	t.value = stmp;
  }
}

function limitDigit(t) {
  
  if (t == null) {
  	return;
  }
  
  var stmp = "";
  if(t.value==stmp) return;
  var ms = t.value.replace(/\D/g,"");
  
  if (ms != t.value) {
  	t.value = ms;
  }
}

/* 
* 半角<=>全角 *
* 参数说明:
* str:要转换的字符串
* flag:标记，为０时半转全，为非０时全转半
* 返回值类型：字符串
*/
function halfFullConvert(str, flag) {

	var i; 
	var result=''; 
	if (str.length<=0) {
		return result;
	}

	for(i=0;i<str.length;i++) {
	
		str1=str.charCodeAt(i);
		
		if (str1==32&&!flag) {
			result+='　'; 
		} else if (str1<125&&!flag) {
			result+=String.fromCharCode(str1+65248); 
		} else if (str1>65248&&flag) {
			result+=String.fromCharCode(str1-65248); 
		} else {
			result+=String.fromCharCode(str1);
		}
	}
	
	return result;
}

/**
* 半角<=>全角 *
* 参数说明:
* field:要转换的控件
* flag:标记，为０时半转全，为非０时全转半
*/
function fieldHalfFullConvert(field,flag) {
	
	var str = field.value;
	
	var result = halfFullConvert(str, flag);
	
	if (str != result) {
		field.value= result;
	}
}

	function initCustomer() {
			limitDigit(document.getElementsByName("zipCode1")[0]);
			limitDigit(document.getElementsByName("zipCode2")[0]);
			
			checkContractPurpose();
			
			/*
			checkMjhfExperience();
			checkStockExperience();
			checkStockMarginExperience();
			checkStockIdxOptionExp();
			checkProductOptionExp();
			*/
			
			checkOtherExperience();
			checkIndustryTypeNote();

	}
	
	function initPensonal() {
			initCustomer();
			checkJobNameNote();
			checkPiNote();
			checkAddress2Star();
			checkUseFinancialAssetsCheckBox();
			// nst(document.getElementsByName("firstTransferAmount")[0]);
	}
	
	function initArtifical() {
			initCustomer();
			//checkDocumentSendAddressFlag();
	}
	
//-->