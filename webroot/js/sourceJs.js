

function selectOptionAction(){
		if (this.pagerform.changepage.value!="-1"){
			window.location.href=this.pagerform.changepage.value;
		}
	}
	
	// middle form func
	
	function checkedAll(){
		if(document.middleform.allchecked.checked)
		{
			for(var i=0;i<document.middleform.elements.length;i++)
			{
				if(document.middleform.elements[i].type=="checkbox")
					document.middleform.elements[i].checked=true;
			}
		}
		else
		{
			for(var i=0;i<document.middleform.elements.length;i++)
			{
				if(document.middleform.elements[i].type=="checkbox")
					document.middleform.elements[i].checked=false;
			}
		}
	}
	
	
	function addSource(){
	
		//var checkedUser;
		
		//checkedUser = isSingleChecked(document.middleform);
		
		//if(checkedUser != null){
		
		//	window.alert(checkedUser);
			
			window.location.href='showAddSource.do';
		
		//}
	}
	
	
	function approveSource(){
		var checkedUser;
		
		checkedUser = isSingleChecked(document.middleform);
		
		if(checkedUser != null){
		
			window.alert(checkedUser);
			
			window.location.href='showSourceUpdate.do?sourceId='+checkedUser;
		
		}
	}
	
	function isSingleCheckedAtLeast(form){
		
		var checkTimes = 0 ;
		
		var tempVar="" ;
		
		for(var i=0;i<form.elements.length;i++)
			{
				if(form.elements[i].type=="checkbox" && form.elements[i].name=="sId"){
			
					if(form.elements[i].checked){
					
						if(tempVar == ""){
							tempVar = form.elements[i].value;
						}else{
							tempVar = tempVar+","+form.elements[i].value;
						}
						
						
						checkTimes++;
					}
				}
			}
		
		if(checkTimes < 1){
			windowout();
			return null;
		}
		
		return tempVar;
	}
	
	
	function updateSource(){
	
		var checkedUser;
		
		checkedUser = isSingleChecked(document.middleform);
		
		if(checkedUser != null){
		
			window.alert(checkedUser);
			
			window.location.href='showSourceUpdate.do?sourceId='+checkedUser;
		
		}
	}
	
	
	function delSource(){
		
		var wasChecked=false;
		
		wasChecked = isChecked(document.middleform);
		
		if(wasChecked){
		
			document.middleform.action="deleteSource.do";
			//form.currentPageNo.value=<c:out value="${requestScope.Pagination.currentPageNo}"/>;
			document.middleform.submit();
		
		}else{
			windowout();
		}
	}
	
	
	function isSingleChecked(form){
		
		var checkTimes = 0 ;
		
		var tempVar ;
		
		for(var i=0;i<form.elements.length;i++)
			{
				if(form.elements[i].type=="checkbox" && form.elements[i].name=="sId"){
			
					if(form.elements[i].checked){
					
						tempVar = form.elements[i].value;
						
						checkTimes++;
					}
				}
			}
		
		if(checkTimes > 1)
		{
			window.alert("不能多选！");
			
			return null;
			
		}else if(checkTimes < 1){
			
			windowout();
			
			return null;
		}
		
		return tempVar;
	}
	
	function isChecked(form){
	
		for(var i=0;i<form.elements.length;i++)
			{
				if(form.elements[i].type=="checkbox" && form.elements[i].name=="sId"){
					if(form.elements[i].checked){
						return true;
					}
				}
			}
		return false;
	}
	

	
	
	
	function windowout(){
		window.alert("请至少选择一个资源！");
	}
	