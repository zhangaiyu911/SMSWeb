<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>修改密码</title>
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
	<div class="pd-20" style="margin-right: auto; margin-left: auto; ">
		<form action="" method="post" class="form form-horizontal" id="frmUser">
		 	<input type="hidden" value="${user.userID }" id="userID" name="userID" />
		 	<input  type="hidden" value="${user.password}" id="upassword"/>
		    <div class="row cl">
		      	<label class="form-label col-3" for="password"><span class="c-red">*</span>旧密码：</label>
		      	<div class="formControls col-5">
		        	<input type="password" class="input-text" placeholder="请输入旧密码" id="password2" datatype="*6-16" nullmsg="密码不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		 	<div class="row cl">
		      	<label class="form-label col-3" for="password1"><span class="c-red">*</span>新密码：</label>
		      	<div class="formControls col-5">
		        	<input type="password" class="input-text" placeholder="请输入新密码" id="password" name="password" datatype="*6-16" nullmsg="密码不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3" for="password1"><span class="c-red">*</span>重复新密码：</label>
		      	<div class="formControls col-5">
		        	<input type="password" class="input-text" placeholder="再次输入新密码" id="password1" name="password1" datatype="*6-16" nullmsg="密码不能为空" onkeyup = "ValidateValue(this)"/>
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
	
	$("#frmUser").Validform({
		tiptype:2,
		callback:function(form){
		layer.confirm('确认保存吗？',function(index){
			//确认与旧密码是否匹配
			var upassword=$("#upassword").val();
			var password2=$("#password2").val();
			if(upassword!=password2){
				layer.msg('与旧密码输入不同，请重新输入!');
				return false;
			}
			//验证两次密码是否相同
			var password=$("#password").val();
			var password1=$("#password1").val();
			if(password!=password1){
				layer.msg('两次输入密码不同请重新输入!');
				return false;
			}
			if(upassword==password){
				layer.msg('新密码与旧密码相同请重新输入!');
				return false;
			}
			//保存用户信息
			saveUserInfo();
			window.open('<%=basePath%>','_parent');
			parent.layer.msg("修改密码成功，请重新登录...");
		});
		return false;
		}
	});	 
});
//保存用户信息方法
function saveUserInfo(){
	var userID=$("#userID").val();
	var password=$("#password").val();
	var options={
			type:"POST",
			dateType:"json",
			url:"<%=basePath%>/user/saveUserPassword.action",
			data:{'userID':userID,'password':password},
			success:function(data){
				var json=JSON.parse(data);
				if(json.result=="success"){
					parent.layer.msg(json.code);							
					var index = parent.layer.getFrameIndex(window.name);
					//关闭编辑页面
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
</script>	
</body>
</html>
