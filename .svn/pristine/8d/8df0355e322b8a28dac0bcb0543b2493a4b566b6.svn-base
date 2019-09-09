<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>功能编辑</title>
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
		<form action="" method="post" class="form form-horizontal" id="frmFunction">
		 	<input type="hidden" value="${function.functionID }" id="functionID" name="functionID" />
		    <div class="row cl">
		    	<label class="form-label col-3" for="username"><span class="c-red">*</span>功能名称：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" value="${function.functionName}" placeholder="请输入功能名称" id="functionName" name="functionName" datatype="*2-16" nullmsg="功能名称不能为空"  onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
				<label class="form-label col-3" for="moduleName"><span class="c-red">*</span>模块名称：</label>
			    <div class="formControls col-5">
			    	<select class="select" size ="1" id="moduleID"  datatype="*" nullmsg="请选择模块！">
				       	<option value="" >请选择</option>
						<c:forEach items="${moduleList}" var="i">
	                    	<option <c:if test="${i.moduleID==function.moduleID}">selected='selected'</c:if> value="${i.moduleID}">${i.moduleName }</option>
	                    </c:forEach>
					</select>
			    </div> 
			    <div class="col-4"> </div>
			</div>
			<div class="row cl">
		      	<label class="form-label col-3" for="functionCode"><span class="c-red">*</span>系统名称：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" value="${function.functionCode}" placeholder="请输入访问路径" id="functionCode" name="functionCode" datatype="*" nullmsg="系统名称不能为空" />
		      	</div>
		      	<div class="col-4"> </div>
		    </div> 
		   	<div class="row cl">
		      	<label class="form-label col-3" for="functionUrl"><span class="c-red">*</span>访问路径：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" value="${function.functionUrl}" placeholder="请输入访问路径" id="functionUrl" name="functionUrl" datatype="*" nullmsg="访问路径不能为空" />
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3" for="showOrder"><span class="c-red">*</span>显示顺序：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" value="${function.showOrder}" placeholder="请输入访问路径" id="showOrder" name="showOrder" datatype="n" nullmsg="显示顺序不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3"><span class="c-red">*</span>启用标识：</label>
		      	<div class="formControls col-5 skin-minimal">
		        	<div class="radio-box">
		        		<input type="radio" name="usingFlags" value="1" <c:if test="${function.usingFlag == 1}">checked="true"</c:if> >使用</input>
		        	</div>
		        	<div class="radio-box">
		        		<input type="radio" name="usingFlags" value="2" <c:if test="${function.usingFlag == 2}">checked="true"</c:if> >禁用</input>
		        	</div>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3" for="Memo">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
		      	<div class="formControls col-5">
		        	<textarea id="memo" name="memo" class="textarea" dragonfly="true" onkeyup="textarealength(this,100)" >${function.memo }</textarea>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<div class="col-9 col-offset-3">
		        	<button class="btn btn-primary radius" type="submit" ><i class="Hui-iconfont">&#xe632;</i> 保存</button>
					<button class="btn btn-default radius" type="button" onclick="layer_close();"><i class="Hui-iconfont">&#xe66b;</i>取消</button>
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
	
	$("#frmFunction").Validform({
		tiptype:2,
		callback:function(form){
		layer.confirm('确认保存吗？',function(index){
			//保存用户信息
			saveFunctionInfo();
		});
		return false;
		}
	});	 
});
//保存用户信息方法
function saveFunctionInfo(){
	var moduleID = $("#moduleID").val();
	var usingFlag = $("input[name=\"usingFlags\"]:checked").val();
	var options={
			type:"POST",
			dateType:"json",
			url:"<%=basePath%>/systemManage/saveFunction.action",
			data:{'moduleID':moduleID,'usingFlag':usingFlag},
			success:function(data){
				var json=JSON.parse(data);
				if(json.result=="success"){
					parent.layer.msg(json.code);							
					var index = parent.layer.getFrameIndex(window.name);
					//关闭编辑页面
					parent.search(0);
					parent.layer.close(index);
				}else{
					layer.msg(json.code);
				}
			},
			error:function(XMLHttpRequest, textStatus, errorThrown) {
				layer.msg('输入不合法！',{icon: 5,time:2000});
			}
	};
	$("#frmFunction").ajaxSubmit(options);
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
</script>	
</body>
</html>
