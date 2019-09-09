<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>角色管理</title>
<jsp:include page="/includes/head_css.jsp" flush="true"/>
<jsp:include page="/includes/head_js.jsp" flush="true"/>

<script type="text/javascript">
//初始化页面
$(function(){
 	$.Huitab("#tab-system .tabBar span","#tab-system .tabCon","current","click","0");
	var page = $("#page").val();
	if (null == page || '' == page || 0 == page)
		page = 0;
	else 
		page = page - 1;
	//查询页面信息
	search(page);
});
//查询页面信息(数据数量)
function search(page) {
	var stype=$("#stype").val();
	var sRoleName = $("#sRoleName").val();
	if(sRoleName==""||sRoleName==null){
		sRoleName="";
	}
	var pro = "&stype="+stype+"&sRoleName="+sRoleName;
	$("#pro").val(pro);
	$.ajax({
		type : "POST", // 用POST方式传输
		dataType : "json", // 数据格式:JSON
		async : false,
		url : '<%=basePath%>/systemManage/getRoleCount.action', // 目标地址
		data : pro,
		success : function(data) {
			$("#dataCount").val(data);
			//分页显示数据
			InitData(page, 10, $("#dataCount").val()); // 一开始初始化第一页的内容
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			show_err_msg('查询失败!');
		}
	});
};



/**
 * 功能：分页显示用户信息
 * 创建：刘雪成 2016年9月20日09:37:12
 * pageindx:页码
 * pagenum:每页显示总数
 * pc：数据总条目数
 */
function InitData(pageindx, pagenum, pc) {
	var page = parseInt(pageindx) + 1;
	$("#page").val(page);
	var pro = $("#pro").val();
	$.ajax({
		type : "POST", // 用POST方式传输
		dataType : "json", // 数据格式:JSON
		url : '<%=basePath%>/systemManage/getRolePage.action', // 目标地址
		data : pro+"&page=" + page + "&limit=" + pagenum,
		success : function(json) {
			$("#roleTbl tr:gt(0)").remove();
			// 遍历查询到的数据,输入前台
			$.each(json, function(i, n) {
				var html = "";
				//职务类型明细
				html += "<tr class='text-c'>";
				html += "<td><input type='checkbox' class='cb' value='"+n.roleID+"' /></td>";
				html += "<td>"+eval(i+1)+"</td>";
				html += "<td>"+ n.roleName +"</td>";
				if (1==n.usingFlag) {
					html += "<td>使用</td>";
				}else if (2==n.usingFlag) {
					html += "<td><span class='c-red'>禁用</span></td>";
				}else{
					html += "<td>错误的状态，请修改</td>";
				}
				if(n.memo==null){
					html += "<td class='text-l'></td>";
				}else{
					html += "<td class='text-l'> " + n.memo + "</td>";
				}
				//html+="<td><a class='btn_set btn022' href='javascript:;' onclick='roleConfig("+n.roleID+")'>角色配置</a></td>";
				html += "</tr>";
				$("#roleTbl").append(html);
			});
			/*隔行变色，选中变色*/
			$('table').tableCheckbox();//选中变色
			$(".tablelist tbody tr:odd").addClass('odd');//隔行变色
		},
		error : function() {
			$("#roleTbl tr:gt(0)").remove();
		}
	});
	//分页按钮
	$("#pagination").pagination(pc, {
		callback : pageselectCallback,
		prev_text : '<< 上一页',
		next_text : '下一页 >>',
		items_per_page : pagenum,
		num_display_entries : 6,
		current_page : pageindx,
		num_edge_entries : 5
	});
}
/**
 * 翻页回调方法
 */
function pageselectCallback(page_id, jq) {
	InitData(page_id, 10, $("#dataCount").val());
}
</script>	
</head>
<body>
<input id="pro" type="hidden" />
<input id="dataCount" type="hidden" />
<input id="page" type="hidden" value="${page}" />
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span> 角色管理
		<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
			<i class="Hui-iconfont">&#xe68f;</i>
		</a>
	</nav>
	<div class="pd-20">
		<div id="tab-system" class="HuiTab">
			
			<div class="tabCon">
				
				<div class="cl pd-5 bg-1 bk-gray"> 
					<span class="l">
						<a class="btn_set btn015"  href="javascript:;" onclick="role_add('添加角色','','600','450')">添加</a>
						<a class="btn_set btn016"  href="javascript:;" onclick="role_edit('编辑角色','','600','450')">编辑</a>
						<a class="btn_set btn018"  href="javascript:;" onclick="role_open()">启用</a>
						<a class="btn_set btn001"  href="javascript:;" onclick="role_close()">禁用</a>
						<label for="stype"><select class="text" id="stype" onchange="role_search()">
							<option <c:if test="${0==stype }">selected='selected'</c:if>value=0>全部</option>
							<option <c:if test="${0==stype }">selected='selected'</c:if>value=1>启用</option>
							<option <c:if test="${0==stype }">selected='selected'</c:if>value=2>禁用</option>
						</select></label>
						<a class="btn_set btn004"  href="javascript:;" onclick="role_search()">查询</a>
						<label for="sRoleName"><input type="text" id="sRoleName" value="${sUserName}" placeholder="请输入角色名称" onchange="role_search()"/></label>
					</span> 
				</div>
				<div id="pagination" class="digg" style="clear:both"></div>
				<div class="table_box  container">
					<div class="div_scroll">
						<table width="100%" class="tablelist" id="roleTbl">
							<thead>
								<tr class="text-c">
									<th width="5%"><input type="checkbox"/></th>
									<th width="5%">序号</th>
									<th width="15%">角色名称</th>
									<th width="5%">状态</th>
									<th width="15%">备注</th>
<!-- 									<th width="15%">操作</th> -->
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>	
				</div>
			</div>
		</div>
	</div>
	
<script type="text/javascript">
/*用户-添加*/
function role_add(title,url,w,h){
	url="<%=basePath%>/systemManage/editRoleInit.action?roleID=0";
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*用户-编辑*/
function role_edit(title,url,w,h){
	url="<%=basePath%>/systemManage/editRoleInit.action?roleID=";
	if($(".cb:checked").length==0){
		layer.msg('请选择要编辑的内容!');
		return false;
	}else if($(".cb:checked").length>1){
		layer.msg('只能编辑一条数据!');
		return false;
	}else{
		url=url+$(".cb:checked")[0].value;
	}
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/**
 * 批量启用方法
 */
function role_open(){
	if($(".cb:checked").length==0){
		layer.msg('请选择要启用的内容!!',{icon:5,time:1000});
	}else{
		layer.confirm('确认要启用吗？',function(index){
			var page = $("#page").val();
			url="<%=basePath%>/systemManage/openRole.action";
			var ids = $(".cb:checked")[0].value;
			for(var i=1;i<$(".cb:checked").length;i++){
				ids+=","+ $(".cb:checked")[i].value;
			}
			$.ajax({
				type :"POST",
				dataType:"json",
				async:false,
				url:url,
				data:{ids:ids},
				success:function(data){
					if(data.result=="success"){
						layer.msg(data.code);
						search(page-1);
					}else{
						layer.msg('操作失败!');
					}
				}
			});
		});
	}
}

/**
 * 批量禁用方法
 * 创建：刘雪成 2016年8月5日09:52:07
 */
function role_close(page){
	if($(".cb:checked").length==0){
		layer.msg('请选择要禁用的内容!!',{icon:5,time:1000});
	}else{
		layer.confirm('确认要禁用吗？',function(index){
			var page = $("#page").val();
			url="<%=basePath%>/systemManage/closeRole.action";
			var ids = $(".cb:checked")[0].value;
			for(var i=1;i<$(".cb:checked").length;i++){
				ids+=","+ $(".cb:checked")[i].value;
			}
			$.ajax({
				type :"POST",
				dataType:"json",
				async:false,
				url:url,
				data:{ids:ids},
				success:function(data){
					if(data.result=="success"){
						layer.msg(data.code);
						search(page-1);
					}else{
						layer.msg('操作失败!');
					}
				}
			});
		 });
	}
}
//根据条件查询用户信息
function user_search(){
	search(0);
}

function roleConfig(roleID){
	var title="角色权限配置";
	url="<%=basePath%>/systemManage/roleConfig.action?roleID="+roleID;
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
</script> 

</body>
</html>