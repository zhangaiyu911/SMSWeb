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
<script type="text/javascript" src="<%=basePath%>/js/Dropdownlist/userRoleDept.js"></script>

</head>
<body>
	<div class="pd-20">
		<form action="" method="post" class="form form-horizontal" id="frmUserRoleDept">
		 	<input type="hidden" value="${user.userID }" id="userID" name="userID" />
		 	<div class="row cl">
		      	<label class="form-label col-0" for="realname">用户姓名：</label>
		      	<div class="formControls col-2">
		        	<input type="text" class="input-text" value="${user.realname}"  id="realname" name="realname" readonly="readonly" />
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
				<label class="form-label col-0" for="roleName">角色名称：</label>
			    <div class="formControls col-5">
			    	<select class="select" size ="1" id="roleID" datatype="*" nullmsg="请选择角色！" onchange="getUserRoleDepartmentList()">
				       	<option value="" >请选择</option>
						<c:forEach items="${roleList}" var="i">
	                    	<option  value="${i.roleID}">${i.roleName}</option>
	                    </c:forEach>
					</select>
			    </div> 
			    <div class="col-4"> </div>
			</div> 
		    <div class="table_box  container">
			    <div class="row cl">
			    	<label class="form-label col-0">角色权限部门配置</label>
			    </div>
				<div class="div_scroll">
					<table width="100%" class="tablelist" id="deptTbl">
						<thead>
							<tr class="text-c">
								<th width="5%"><input type="checkbox" id="checkAllParent"/></th>
								<th width="15%">部门名称</th>
								<th width="80%">班组名称</th>
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
	
    //总的checkbox
	$("#checkAllParent").on("click",function(){	
		
		if(document.getElementById("checkAllParent").checked==true){
			$(this).closest("table").find("tr > td input:checkbox").prop("checked",true);
		}else{
			$(this).closest("table").find("tr > td input:checkbox").prop('checked',false);
		}
	});
    
   	
    
   
});
//每行第一个总的checkbox
function aa(obj){
	if(obj.checked==true){
		$(obj).closest('tr').find(".cbs").prop("checked",true);
	}else{
		$(obj).closest('tr').find(".cbs").prop("checked",false);
	}
}
function bb(obj){
	$(obj).closest('tr').find(".cb").prop("checked",$(obj).closest('tr').find(".cbs").length == $(obj).closest('tr').find(".cbs:checked").length);
}


function getUserRoleDepartmentList(){
	
	
	var userID=$("#userID").val();
	var roleID=$("#roleID").val();
	if(roleID==null||roleID==""){
		layer.msg("请选择要设置权限的角色");
		return ;
	}
	$.ajax({
		type : "POST", // 用POST方式传输
		dataType : "json", // 返回数据格式:JSON
		async : false,
		url : "<%=basePath%>/user/userRoleAuthConfigInit2.action", // 目标地址
		data : {"userID":userID,"roleID":roleID},					
		success : function(data) {
			if(data.result=="success"){
				$("#deptTbl tr:gt(0)").remove();
				var html="";
				for(var i=0;i<data.deptList.length;i++){
					html += "<tr class='text-c'>";
					var flag=0;
					for(var j=0;j<data.userRoleDeptList.length;j++){
						if(data.deptList[i].departmentID==data.userRoleDeptList[j].departmentID){
							var deptid=data.deptList[i].departmentID;
							html += "<td><input onclick='aa(this)' type='checkbox' class='cb' name='selectParent' value='"+data.deptList[i].departmentID+"' checked='checked'/></td>";
							html += "<td><span class='c-green'>"+ data.deptList[i].departmentName +"</span></td>";
							html +="<td>";
							for ( var z = 0; z < data[deptid].length; z++) {
						
								html+="<span class='c-green'><input onclick='bb(this)' type='checkbox' class='cbs' value='"+data[deptid][z].departmentID+"' checked='checked'/>"+ data[deptid][z].departmentName +"</span>";
								
							}
							html +="</td>";
							flag=1;
						}
					}
					if(flag==0){
						var deptid=data.deptList[i].departmentID;
						html += "<td><input onclick='aa(this)' type='checkbox' class='cb' name='selectParent' id ='"+data.deptList[i].departmentID+"' value='"+data.deptList[i].departmentID+"' /></td>";
						html += "<td><span class='c-red'>"+ data.deptList[i].departmentName +"</span></td>";
						html +="<td>";
						for ( var z = 0; z < data[deptid].length; z++) {
					
							html+="<span class='c-red'><input onclick='bb(this)' type='checkbox' class='cbs' value='"+data[deptid][z].departmentID+"' />"+ data[deptid][z].departmentName +"</span>";
							
						}
						html +="</td>";
						flag=1;
					}

					html += "</tr>";

				}
				$("#deptTbl").append(html);
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
//});
}
$(function(){
	
	$(".select").chosen();
	
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#frmUserRoleDept").Validform({
		tiptype:2,
		callback:function(form){
		layer.confirm('确认保存吗？',function(index){
			//保存信息
			var userID=$("#userID").val();
			var roleID=$("#roleID").val();
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
			$.ajax({
				type : "POST", // 用POST方式传输
				dataType : "json", // 返回数据格式:JSON
				async : false,
				url : "<%=basePath%>/user/saveUserRoleDeptList.action", // 目标地址
				data : {"ids":ids,"userID":userID,"roleID":roleID},					
				success : function(data) {
					layer.msg(data.code);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					layer.msg('系统错误,请重试!');
				}
			});	
		});
		return false;
		}
	});
});
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
