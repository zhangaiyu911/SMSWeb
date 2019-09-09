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
		 	<input type="hidden" value="${user.userID }" id="userID" name="userID" />
		    <div class="row cl">
		    	<label class="form-label col-3" for="username"><span class="c-red">*</span>用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" value="${user.username}" placeholder="请输入用户名" id="username" name="username" datatype="*2-16" nullmsg="用户名不能为空"  onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3" for="password"><span class="c-red">*</span>登录密码：</label>
		      	<div class="formControls col-5">
		        	<input type="password" class="input-text" value="${user.password}" placeholder="请输入密码" id="password" name="password" datatype="*2-16" nullmsg="密码不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		 	<div class="row cl">
		      	<label class="form-label col-3" for="password1"><span class="c-red">*</span>重复密码：</label>
		      	<div class="formControls col-5">
		        	<input type="password" class="input-text" value="${user.password}" placeholder="再次输入密码" id="password1" name="password1" datatype="*2-16" nullmsg="密码不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
				<label class="form-label col-3" for="departmentName"><span class="c-red">*</span>部门名称：</label>
			    <div class="formControls col-5">
			    	<select class="select" size ="1" id="departmentID" datatype="*" nullmsg="请选择部门！">
				       	<option value="" >请选择</option>
						<c:forEach items="${deptList}" var="i">
	                    	<option <c:if test="${i.departmentID==user.departmentID}">selected='selected'</c:if> value="${i.departmentID}">${i.departmentName }</option>
	                    </c:forEach>
					</select>
			    </div> 
			    <div class="col-4"> </div>
			</div> 
		   	<div class="row cl">
		      	<label class="form-label col-3" for="realname"><span class="c-red">*</span>用户姓名：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" value="${user.realname}" placeholder="请输入用户姓名" id="realname" name="realname" datatype="*2-16" nullmsg="用户名不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3" for="idnumber"><span class="c-red">*</span>身份证号：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" value="${user.idnumber}" placeholder="请输入身份证号" id="idnumber" name="idnumber" datatype="*18-18" nullmsg="用户名不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3" for="linkphone"><span class="c-red">*</span>联系电话：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" value="${user.linkphone}" placeholder="请输入联系电话" id="linkphone" name="linkphone" datatype="*2-16" nullmsg="用户名不能为空" onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3"><span class="c-red">*</span>启用标识：</label>
		      	<div class="formControls col-5 skin-minimal">
		        	<div class="radio-box">
		        		<input type="radio" name="usingFlags" value="1" <c:if test="${user.usingFlag == 1}">checked="true"</c:if> >使用</input>
		        	</div>
		        	<div class="radio-box">
		        		<input type="radio" name="usingFlags" value="2" <c:if test="${user.usingFlag == 2}">checked="true"</c:if> >禁用</input>
		        	</div>
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
		    <div class="table_box  container">
			    <div class="row cl">
			    	<label class="form-label col-3">用户角色配置</label>
			    </div>
				<div class="div_scroll">
					<table width="100%" class="tablelist" id="roleTbl">
						<thead>
							<tr class="text-c">
								<th width="5%"><input type="checkbox"/></th>
								<th width="15%">角色名称</th>
								<th width="5%"><input type="checkbox"/></th>
								<th width="15%">角色名称</th>
								<th width="5%"><input type="checkbox"/></th>
								<th width="15%">角色名称</th>
								<th width="5%"><input type="checkbox"/></th>
								<th width="15%">角色名称</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>	
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
	
	var userID=$("#userID").val();
	$.ajax({
		type : "POST", // 用POST方式传输
		dataType : "json", // 返回数据格式:JSON
		async : false,
		url : "<%=basePath%>/systemManage/userRoleConfigInit.action", // 目标地址
		data : {"userID":userID},					
		success : function(data) {
			if(data.result=="success"){
				$("#roleTbl tr:gt(0)").remove();
				var html="";
				for(var i=0;i<data.roleList.length;i++){
					if(i%4==0){
						html += "<tr class='text-c'>";
					}
					var flag=0;
					for(var j=0;j<data.userRoleList.length;j++){
						if(data.roleList[i].roleID==data.userRoleList[j].roleID){
							html += "<td><input type='checkbox' class='cb' value='"+data.roleList[i].roleID+"' checked='checked'/></td>";
							html += "<td><span class='c-green'>"+ data.roleList[i].roleName +"</span></td>";
							flag=1;
						}
					}
					if(flag==0){
						html += "<td><input type='checkbox' class='cb' id ='"+data.roleList[i].roleID+"' value='"+data.roleList[i].roleID+"' /></td>";
						html += "<td><span class='c-red'>"+ data.roleList[i].roleName +"</span></td>";
					}
					
					if(i%4==3){
						html += "</tr>";
						$("#roleTbl").append(html);
						html="";
					}
					if(i==data.roleList.length-1&&i%4!=3){
						for(var j=1;j<4-i%4;j++){
							html+="<td></td><td></td>";
						}
						html += "</tr>";
						$("#roleTbl").append(html);
					}
				}
				/*隔行变色，选中变色*/
// 				$('table').tableCheckbox();//选中变色(整行,此处不适用)
				$(".tablelist tbody tr:odd").addClass('odd');//隔行变色
			}else{
				layer.msg(data.code);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			layer.msg('系统错误！');
		}
	});	
});
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
			//保存用户信息
			saveUserInfo();
		});
		return false;
		}
	});	 
});
//保存用户信息方法
function saveUserInfo(){
	var deptid = $("#departmentID").val();
	var usingFlag = $("input[name=\"usingFlags\"]:checked").val();
	var ids="";
	if($(".cb:checked").length==0){
		layer.msg('请选择要配置的项目!!');
		return;
	}else{
		ids = $(".cb:checked")[0].value;
		for(var i=1;i<$(".cb:checked").length;i++){
			ids+=","+ $(".cb:checked")[i].value;
		}
	}
	var options={
			type:"POST",
			dateType:"json",
			url:"<%=basePath%>/systemManage/saveUser.action",
			data:{'deptid':deptid,'usingFlag':usingFlag,'ids':ids},
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
