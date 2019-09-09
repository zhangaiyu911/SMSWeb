<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>角色编辑</title>
<jsp:include page="/includes/head_css.jsp" flush="true"/>
<jsp:include page="/includes/head_js.jsp" flush="true"/>
<script type="text/javascript" src="<%=basePath%>/js/jquery.form.js"></script>
</head>
<body>
	<div class="pd-20">
	    <form action="" method="post" class="form form-horizontal" id="frmRole">
			<input type="hidden" id="roleID" value="${role.roleID }"/>
			<div class="row cl">
		    	<label class="form-label col-3" for="roleName"><span class="c-red">*</span>角色名称：</label>
		      	<div class="formControls col-5">
		        	<input type="text" class="input-text" value="${role.roleName}" placeholder="请输入角色名称" id="roleName" name="roleName" datatype="*2-16" nullmsg="角色名称不能为空"  onkeyup = "ValidateValue(this)"/>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3"><span class="c-red">*</span>启用标识：</label>
		      	<div class="formControls col-5 skin-minimal">
		        	<div class="radio-box">
		        		<input type="radio" name="usingFlags" value="1" <c:if test="${role.usingFlag == 1}">checked="true"</c:if> >使用</input>
		        	</div>
		        	<div class="radio-box">
		        		<input type="radio" name="usingFlags" value="2" <c:if test="${role.usingFlag == 2}">checked="true"</c:if> >禁用</input>
		        	</div>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3"><span class="c-red">*</span>类型：</label>
		      	<div class="formControls col-5 skin-minimal">
		        	<div class="radio-box">
		        		<input type="radio" name="roleType" value="1" <c:if test="${role.roleType == 1}">checked="true"</c:if> >普通</input>
		        	</div>
		        	<div class="radio-box">
		        		<input type="radio" name="roleType" value="2" <c:if test="${role.roleType == 2}">checked="true"</c:if> >薪酬</input>
		        	</div>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    <div class="row cl">
		      	<label class="form-label col-3" for="Memo">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
		      	<div class="formControls col-5">
		        	<textarea id="memo" name="memo" class="textarea" dragonfly="true" onkeyup="textarealength(this,100)" >${role.memo }</textarea>
		      	</div>
		      	<div class="col-4"> </div>
		    </div>
		    
		    <div class="table_box  container">
			    <div class="row cl">
			    	<label class="form-label col-3">角色功能权限配置</label>
			    </div>
				<div class="div_scroll">
					<table width="100%" class="tablelist" id="functionTbl">
						<thead>
							<tr class="text-c">
								<th width="5%"><input type="checkbox"/></th>
								<th width="15%">功能名称</th>
								<th width="5%"><input type="checkbox"/></th>
								<th width="15%">功能名称</th>
								<th width="5%"><input type="checkbox"/></th>
								<th width="15%">功能名称</th>
								<th width="5%"><input type="checkbox"/></th>
								<th width="15%">功能名称</th>
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

<script type="text/javascript">

$(function(){
	
	var roleID=$("#roleID").val();
	$.ajax({
		type : "POST", // 用POST方式传输
		dataType : "json", // 返回数据格式:JSON
		async : false,
		url : "<%=basePath%>/systemManage/roleFunctionConfigInit.action", // 目标地址
		data : {"roleID":roleID},					
		success : function(data) {
			if(data.result=="success"){
				$("#functionTbl tr:gt(0)").remove();
				var html="";
				for(var i=0;i<data.functionList.length;i++){
					if(i%4==0){
						html += "<tr class='text-c'>";
					}
					var flag=0;
					for(var j=0;j<data.roleItemList.length;j++){
						if(data.functionList[i].functionID==data.roleItemList[j].functionID){
							html += "<td><input type='checkbox' class='cb' value='"+data.functionList[i].functionID+"' checked='checked'/></td>";
							html += "<td><span class='c-green'>"+ data.functionList[i].functionName +"</span></td>";
							flag=1;
						}
					}
					if(flag==0){
						html += "<td><input type='checkbox' class='cb' id ='"+data.functionList[i].functionID+"' value='"+data.functionList[i].functionID+"' /></td>";
						html += "<td><span class='c-red'>"+ data.functionList[i].functionName +"</span></td>";
					}
					
					if(i%4==3){
						html += "</tr>";
						$("#functionTbl").append(html);
						html="";
					}
					if(i==data.functionList.length-1&&i%4!=3){
						for(var j=1;j<4-i%4;j++){
							html+="<td></td><td></td>";
						}
						html += "</tr>";
						$("#functionTbl").append(html);
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
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#frmRole").Validform({
		tiptype:2,
		callback:function(form){
		layer.confirm('确认保存吗？',function(index){
			//保存角色信息
			saveRoleInfo();
		});
		return false;
		}
	});	 
});

//保存角色信息方法
function saveRoleInfo(){
	var roleID = $("#roleID").val();
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
		url:"<%=basePath%>/systemManage/roleFunctionConfig.action",
		data:{"roleID":roleID,"usingFlag":usingFlag,"ids":ids},
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
	$("#frmRole").ajaxSubmit(options);
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
