<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>供货商配置</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/H-ui.min.css"  />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/H-ui.admin.css"  />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/lib/Hui-iconfont/1.0.1/iconfont.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-ui-1.11.4.custom/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/Pagination/kkpager_orange.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/style/pagination/pagination.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/lib/icheck/icheck.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/Dropdownlist/chosen-searchs.css"/>

</head>
<body>
	<div class="pd-20">
		<form action="" method="post" class="form form-horizontal" id="frmUser">
		 	<input type="hidden" value="2" id="userType" name="userType" />
		 	<input type="hidden" value="1" id="usingFlag" name="usingFlag" />
		 	<input type="hidden" value="${supplier.supplierID}" id="supplierID" name="supplierID" />
		 	<input type="hidden" value="${systemSupplierList}" id="systemSupplierList" name="systemSupplierList"/>
		     <div class="row cl">
		      	<label class="form-label col-3" for="supplierName">供货商名称：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入供货商名称" value="${supplier.supplierName}" id="supplierName" name="supplierName" datatype="*2-16" nullmsg="供货商名称不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="supplierCode">供货商编码：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入供货商编码" value="${supplier.supplierCode}" id="supplierCode" name="supplierCode" datatype="*2-16" nullmsg="供货商编码不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="officeAddr">办公地点：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入办公地点" value="${supplier.officeAddr}" id="officeAddr" name="officeAddr" datatype="*2-16" nullmsg="办公地点不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="saleContent">经营类型：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入经营类型" value="${supplier.saleContent}" id="saleContent" name="saleContent" datatype="*2-16" nullmsg="经营类型不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="consignorName">负责人：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入负责人" value="${supplier.consignorName}" id="consignorName" name="consignorName" datatype="*2-16" nullmsg="负责人不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="consignorPhone">电话：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入电话" value="${supplier.consignorPhone}" id="consignorPhone" name="consignorPhone" datatype="*2-16" nullmsg="电话不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="consignorMobile">座机：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入座机" value="${supplier.consignorMobile}" id="consignorMobile" name="consignorMobile" />
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="consignorFax">传真：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入传真" value="${supplier.consignorFax}" id="consignorFax" name="consignorFax" />
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
			<div class="row cl">
				<label class="form-label col-3" for="fileUpload">资质证件列表：</label>
			    <div class="formControls col-5" >
			    	<c:forEach var="clist" items="${certificatesList}" varStatus="i">	       		        
	       		            <c:if test="${i.index%5==0}"><br/></c:if>			        
					        <input type="checkbox" class="cb" name="ctid" id="ctid" value="${clist.certificatesID}" <c:forEach var="slist" items="${certificatesItemList}"><c:if test="${slist.certificatesID==clist.certificatesID}">checked="checked"</c:if></c:forEach>/>${clist.certificatesName}&nbsp;&nbsp;
					 </c:forEach>
					
			    </div>
			    <div class="col-4"> </div>
			</div>  
		    <div class="row cl">
		      	<label class="form-label col-3" for="Memo">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
		      	<div class="formControls col-5">
		        	<textarea id="memo" name="memo" class="textarea" dragonfly="true" onkeyup="textarealength(this,100)" >${user.memo }</textarea>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
				<label class="form-label col-3" for="fileUpload">服务单位：</label>
			    <div class="formControls col-5" >
			    	<select class="text" id="systemID" name="systemID" onchange="getFlag(this)">
						<option value="0" >请选择</option>
			  				<c:forEach items="${systemList}" var="i">
	                 				<option  value="${i.systemID}">${i.systemName}</option>
	                		</c:forEach>
						</select>
					
			    </div>
			    <div class="col-4"> </div>
			</div>  
			<div class="row cl" id="div1" style="display: none;">
		      	<label class="form-label col-3" for="consignorFax">审核状态：</label>
		      	<div class="formControls col-5">
		      	<input type="text" id="flag" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px " disabled="disabled"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl" id="div2" style="display: none;">
		      	<label class="form-label col-3" for="consignorFax">失败原因：</label>
		      	<div class="formControls col-5">
<!-- 		      	<input type="text" id="reason" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px " disabled="disabled"/> -->
		      	<textarea id="reason" name="reason" class="textarea" dragonfly="true" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px " disabled="disabled"></textarea>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<div class="col-9 col-offset-3">
		        	<button class="btn btn-primary radius" type="submit" ><i class="Hui-iconfont">&#xe632;</i> 保存</button>
					<button class="btn btn-success radius" type="button" onclick="addSystem();"><i class="Hui-iconfont">&#xe604;</i> 新增服务单位</button>
		      	</div>
		    </div>
		</form>
	</div>
<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=basePath%>/js/H-ui.admin.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/Dropdownlist/chosen.jquery.js"></script>
<script type="text/javascript">

$(function(){
	$(".select").chosen();
	
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#frmUser").Validform({
		tiptype:2,
		callback:function(form){
		layer.confirm('确认保存吗？',function(index){
			//验证两次密码是否相同
			var password=$("#password").val();
			var password1=$("#password1").val();
			if(password!=password1){
				layer.msg('两次输入密码不同请重新输入!');
				return false;
			}
			var userType = $("#userType").val();
			if(userType==2){
			if($(".cb:checked").length==0){
				layer.msg('请选择资质证件!');
				return false;
			}
			}
			//保存用户信息
			saveUserInfo();
		});
		return false;
		}
	});	 
});
//保存用户信息方法
function saveUserInfo(){
	var ids="";
	if($(".cb:checked").length!=0){
		ids = $(".cb:checked")[0].value;
		for(var i=1;i<$(".cb:checked").length;i++){
			ids+=","+ $(".cb:checked")[i].value;
		}
	}
	var options={
			type:"POST",
			dateType:"json",
			url:"<%=basePath%>/supplier/updateSupplier.action",
			data:{'ids':ids},
			success:function(data){
				var json=JSON.parse(data);
				if(json.result=="success"){
					parent.layer.msg(json.code);							
					var index = layer.index; //获取当前弹层的索引号
					layer.close(index);
				}else{
					layer.msg(json.code);
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown) {
				layer.msg('输入不合法！',{icon: 5,time:2000});
			}
	};
	$("#frmUser").ajaxSubmit(options);
}
/**
 * 判断特殊字符 并排除
 */
function ValidateValue(textbox){
	var IllegalString = "\`~@#;,.!#$%^&*(){}|\\:\"<>?=/,\'";
	
    var textboxvalue = textbox.value;
    var index = textboxvalue.length - 1;
      
    var s = textbox.value.charAt(index);
      
    if(IllegalString.indexOf(s)>=0){
    	s = textboxvalue.substring(0,index);
    	textbox.value = s;
    }
} 
function layer_close(){
	//window.open('about:blank','_self'); window.close();
	var aCloseIndex=$(".active").index();
	alert(aCloseIndex)
	var iframe_box=$("#iframe_box");
	if(aCloseIndex>0){
		$(".active").remove();
		$('#iframe_box').find('.show_iframe').eq(aCloseIndex).remove();	
		//num==0?num=0:num--;
		$("#min_title_list li").removeClass("active").eq(aCloseIndex-1).addClass("active");
		iframe_box.find(".show_iframe").hide().eq(aCloseIndex-1).show();
		tabNavallwidth2();
	}else{
		return false;
	}
}

function tabNavallwidth2(){
	var taballwidth=0,
		$tabNav = $(".acrossTab"),
		$tabNavWp = $(".Hui-tabNav-wp"),
		$tabNavitem = $(".acrossTab li"),
		$tabNavmore =$(".Hui-tabNav-more");
	if (!$tabNav[0]){return}
	$tabNavitem.each(function(index, element) {
        taballwidth+=Number(parseFloat($(this).width()+60))});
	$tabNav.width(taballwidth+25);
	var w = $tabNavWp.width();
	if(taballwidth+25>w){
		$tabNavmore.show()}
	else{
		$tabNavmore.hide();
		$tabNav.css({left:0})}
}

function getFlag(obj){
	var systemID=obj.value;
	//alert(systemID)
	if(systemID==0){
		$("#div1").hide();
		$("#div2").hide();
		return;
	}
	var partList = jQuery.parseJSON( '${systemSupplierList}');
    $.each(partList,function(key,value){
    	
    if(systemID==value.systemID){
    	
    	var flag=value.usingFlag;
    	$("#div1").show();
    	$("#div2").hide();
    	if(flag==1){
    	$("#flag").val("通过");
    	}else if(flag==0){
    		$("#flag").val("待审核");
    	}else {
    		$("#flag").val("未通过");
    		$("#div2").show();
    		//$("#div1").hide();
    		$("#reason").val(value.reason);
    	}
    }
	});   
	
}

function addSystem(){
	 url="<%=basePath%>/supplier/addSystemSupplierInit.action?supplierID=";
	 var supplierID=$("#supplierID").val();
			url=url+supplierID;
			layer_show('新增物流系统',url,'500','280');
}
</script>	
</body>
</html>
