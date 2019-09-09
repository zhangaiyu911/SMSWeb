<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>用户编辑</title>
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
		    <div class="row cl">
		    	<label class="form-label col-3" for="username"><span class="c-red">*</span>用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" placeholder="请输入用户名" id="userName" name="userName" datatype="*2-16" nullmsg="用户名不能为空"  onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3" for="password"><span class="c-red">*</span>登录密码：</label>
		      	<div class="formControls col-5">
		        	<input type="password" class="input-text" placeholder="请输入密码" id="password" name="password" datatype="*6-16" nullmsg="密码不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		 	<div class="row cl">
		      	<label class="form-label col-3" for="password1"><span class="c-red">*</span>重复密码：</label>
		      	<div class="formControls col-5">
		        	<input type="password" class="input-text" placeholder="再次输入密码" id="password1" name="password1" datatype="*6-16" nullmsg="重复密码不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3" for="registCodeStr"><span class="c-red">*</span>验证码：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入验证码" id="registCodeStr" name="registCodeStr" datatype="*2-16" nullmsg="验证码不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="linkphone"><span class="c-red">*</span>联系电话：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入联系电话" id="linkphone" name="linkphone" datatype="*2-16" nullmsg="联系电话不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="wuliuSupplierID"><span class="c-red">*</span>供货商编号：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入供货商编号" id="wuliuSupplierID" name="wuliuSupplierID" datatype="*" nullmsg="供货商编号不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="supplierName"><span class="c-red">*</span>供货商名称：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入供货商名称" id="supplierName" name="supplierName" datatype="*2-16" nullmsg="供货商名称不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="supplierCode"><span class="c-red">*</span>供货商简码：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入供货商简码" id="supplierCode" name="supplierCode" datatype="*2-16" nullmsg="供货商简码不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="officeAddr"><span class="c-red">*</span>办公地点：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入办公地点" id="officeAddr" name="officeAddr" datatype="*2-16" nullmsg="办公地点不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="saleContent"><span class="c-red">*</span>经营类型：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入经营类型" id="saleContent" name="saleContent" datatype="*2-16" nullmsg="经营类型不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="consignorName"><span class="c-red">*</span>负责人：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入负责人" id="consignorName" name="consignorName" datatype="*2-16" nullmsg="负责人不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="consignorPhone"><span class="c-red">*</span>电话：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入电话" id="consignorPhone" name="consignorPhone" datatype="*2-16" nullmsg="电话不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="consignorMobile">座机：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入座机" id="consignorMobile" name="consignorMobile" />
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		     <div class="row cl">
		      	<label class="form-label col-3" for="consignorFax">传真：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text"  placeholder="请输入传真" id="consignorFax" name="consignorFax" />
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
<!-- 		    <div class="row cl"> -->
<!-- 				<label class="form-label col-3" for="userType"><span class="c-red">*</span>用户类型：</label> -->
<!-- 			    <div class="formControls col-5"> -->
<!-- 			    	<select class="input-text"  id="userType" datatype="*" nullmsg="请选择类型！" onchange="saveCertificates()"> -->
<!-- 				       	<option value="" >请选择</option> -->
<!-- 	                    <option value="1">系统管理员</option> -->
<!-- 	                    <option value="2">供货商</option> -->
<!-- 					</select> -->
<!-- 			    </div>  -->
<!-- 			    <div class="col-4"> </div> -->
<!-- 			</div> -->
			<div class="row cl">
				<label class="form-label col-3" for="fileUpload"><span class="c-red">*</span>资质证件列表：</label>
			    <div class="formControls col-5" >
			    	<c:forEach var="clist" items="${certificatesList}" varStatus="i">	       		        
	       		            <c:if test="${i.index%5==0}"><br/></c:if>			        
					        <input type="checkbox" class="cb" name="ctid" id="ctid" value="${clist.certificatesID}" />${clist.certificatesName}&nbsp;&nbsp;
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
			url:"<%=basePath%>/user/saveUser.action",
			data:{'ids':ids},
			success:function(data){
				var json=JSON.parse(data);
				if(json.result=="success"){
					parent.layer.msg(json.code);							
					var index = parent.layer.getFrameIndex(window.name);
					//关闭编辑页面
					//parent.search(0);
					var ids=json.ids;
					var supplierID=json.supplierID;
					var url1="<%=basePath%>/user/updateCertificates.action?supplierID="+supplierID+"&ids="+ids+"&index="+index;
					layer_show('上传证件',url1,'900','600');
					//parent.layer.close(index);
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
