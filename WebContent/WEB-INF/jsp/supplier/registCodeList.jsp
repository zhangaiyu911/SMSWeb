<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>供货商审核</title>
<link href="<%=basePath%>/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-ui-1.11.4.custom/jquery-ui.css"/>
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/Pagination/kkpager_orange.css"/>
<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="<%=basePath%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=basePath%>/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="<%=basePath%>/js/jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.tableCheckbox.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/Pagination/kkpager.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/style/pagination/pagination.css"/>
<script type="text/javascript" src="<%=basePath%>/script/pagination/jquery.pagination.js"></script>
<script type="text/javascript">

$(function(){	
	$.Huitab("#tab-system .tabBar span","#tab-system .tabCon","current","click","0");
	// 取得错误编码
	var errorcode = $("#errorcode").val();
	if (errorcode != '') {
		show_success_msg(errorcode, '2000');
	}
	$("#errorcode").val('');
	var page = $("#page").val();
	if (null == page || '' == page || 0 == page)
		page = 0;
	else 
		page = page - 1;
	//search(page);
	
	//查询点击事件
	$('#search').click(function(){
		
		//search(0);
	});

});

function search(page) {
	
	var pro = "&systemID="+$("#systemID").val();
	$("#pro").val(pro);
	
	$.ajax({
		type : "POST", // 用POST方式传输
		dataType : "json", // 数据格式:JSON
		async : false,
		url : '<%=basePath%>/registCode/getRegistCodeCount.action', // 目标地址
		data : pro,
		success : function(data) {
			$("#dataCount").val(data);
			InitData(page, 10, $("#dataCount").val()); // 一开始初始化第一页的内容
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			show_err_msg('查询失败!');	
		}
	});
};

// /功能：翻页回调
// / 方法名：pageselectCallback
// / 参 数：
// / page_id：页码
// / 返回值：
function pageselectCallback(page_id, jq) {
	InitData(page_id, 10, $("#dataCount").val());
};
// /功能：分页显示职务信息
// / 方法名：InitData
// / 参 数：
// / pageindx：页码
// / pagenum：一页显示总数
// / pc:总数据数
// / 返回值：
function InitData(pageindx, pagenum, pc) {
	
	var pro = $("#pro").val();
	var page = parseInt(pageindx) + 1;
	$("#page").val(page);
	$.ajax({
		type : "POST", // 用POST方式传输
		dataType : "json", // 数据格式:JSON
		url : '<%=basePath%>/registCode/getRegistCodePage.action', // 目标地址
		data : pro + "&page=" + page + "&limit=" + pagenum,
		success : function(json) {
			$(".registCodeTable tr:gt(0)").remove();
			// 遍历查询到的数据,输入前台
			$.each(json, function(i, n) {
				var html = "";
				//明细
				html += "<tr class='text-c'>";
				html += "<td>"+(i+1)+"</td>";
				html += "<td>"+ n.registCodeStr +"</td>";
				if (1==n.usingFlag) {
					html += "<td>未使用</td>";
				}else if (2==n.usingFlag) {
					html += "<td>已使用</td>";
				}
				else{
					html += "<td>错误的状态，请修改</td>";
				}
				html += "</tr>";
				
				$(".registCodeTable").append(html);
			});
			//$('.registCodeTable').alterBgColor();   //表格选中效果
			$('table').tableCheckbox();
			$(".tablelist tbody tr:odd").addClass('odd');//表格选中效果
		},
		error : function() {
			$(".registCodeTable tr:gt(0)").remove();
		}
		
	});
	
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

function searchSupplier(){
	var systemID=$("#systemID").val();
	if(systemID=='0'){
		layer.msg('请选择系统平台',{icon:5,time:2000});
		return;
	}
	search(0);
}
</script>	
</head>
	<body>
	
    <input id="pro" type="hidden" />
    <input id="dataCount" type="hidden" />
    <input id="page" type="hidden" value="${page}" />
	<input type="hidden" name="errorcode" id="errorcode" value="${errorcode}" />
	
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe67f;</i> 首页 
			<span class="c-gray en">&gt;</span> 验证码管理
			<span class="c-gray en">&gt;</span> 验证码列表 
			<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
				<i class="Hui-iconfont">&#xe68f;</i>
			</a>
		</nav>
		<div class="pd-20">
			<div id="tab-system" class="HuiTab">
				
				<div class="tabCon">
					<div class="cl pd-5 bg-1 bk-gray mt"> 
						<span class="l">
						<a class="btn_set btn004" href="javascript:;"  onclick="searchSupplier()">查询</a>
						<a class="btn_set btn015" href="javascript:;" onclick="registCode_add()">生产验证码</a>
						</span> 
						
					</div>
					
					<div class="dialog_div">
						<label class="dialog_label">物流系统：</label>
						<select class="select dialog_select" id="systemID" name="systemID">
						<option value="0" >请选择</option>
			  				<c:forEach items="${wuliuSystemList}" var="i">
	                 				<option  value="${i.systemID}">${i.systemName}</option>
	                			</c:forEach>
						</select>
					</div> 	
					
				<div id="pagination" class="digg"></div>
					<div class="mt table_box tablelist container">
						<div class="div_scroll">
							<table width="100%" class="registCodeTable">
								<thead>
									<tr class="text-c">
										<th width="4%">序号</th>
										<th width="12%">注册码</th>
										<th width="12%">状态</th>
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>
						</div>	
					</div>
				
				</div>
				
			</div>
			
		</div>

		
		<script type="text/javascript">
			
		/*搜索*/
		$( "#dialog" ).dialog({
			autoOpen: false,
			modal: true,  
			title:'搜索条件',
			width: 550,
		});

		$("#conserve").click(function(){
			search(0);
			$( "#dialog" ).dialog( "close" );
		});
		$("#back").click(function(){
			$( "#dialog" ).dialog( "close" );	
		});
		$( "#dialog-link" ).click(function( event ) {
			$( "#dialog" ).dialog( "open" );
			event.preventDefault();
		});	
			
			/*职务-添加*/
			function post_add(title,url,id,w,h){
				//alert(url);
				layer_show(title,url,w,h);
			}
			
			/*职务-编辑*/
			function post_edit(title,url,id,w,h){
				if($(".cb:checked").length==0){
					layer.msg('请选择内容!',{icon:5,time:3000});
				}else if($(".cb:checked").length>1){
					layer.msg('只能编辑一条!',{icon:5,time:3000});
				}
				else{
					//alert($(".cb:checked")[0].value);
					//alert(url+$(".cb:checked")[0].value);
					layer_show(title,url+$(".cb:checked")[0].value,w,h);
					
				}
			}
			


			/*隔行变色，选中变色*/
			$('table').tableCheckbox();
			
						
			function getParameter(name) { 
				var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
				var r = window.location.search.substr(1).match(reg); 
				if (r!=null) return unescape(r[2]); return null;
			}
			$(function(){
				$(".tablelist tbody tr:odd").addClass('odd');
				/*分页*/
				var totalPage = 20;
				var totalRecords = 390;
				var pageNo = getParameter('pno');
				if(!pageNo){
					pageNo = 1;
				}
				//生成分页
				//有些参数是可选的，比如lang，若不传有默认值
				kkpager.generPageHtml({
					pno : pageNo,
					//总页码
					total : totalPage,
					//总数据条数
					totalRecords : totalRecords,
					//链接前部
					hrefFormer : 'pager_test_orange_color',
					//链接尾部
					hrefLatter : '.html',
					getLink : function(n){
						return this.hrefFormer + this.hrefLatter + "?pno="+n;
					}
				});
			
				
			});
			
		function oper(supplierID,itemID){
			var page = $("#page").val();
			if (null == page || '' == page || 0 == page){
	 			page = 1;
	 		}
			var url="<%=basePath%>/supplier/updateCertificates.action?supplierID="+supplierID+"&itemID="+itemID+"&page="+page;
			layer_show('上传证件',url,'900','600'); 
		}
		
		function registCode_add(){
			var systemID=$("#systemID").val();
			if(systemID=='0'){
				layer.msg('请选择系统平台',{icon:5,time:2000});
				return;
			}
			
			$.ajax({
				type : "POST", // 用POST方式传输
				dataType : "json", // 数据格式:JSON
				async : false,
				url : '<%=basePath%>/registCode/saveRegistCode.action', // 目标地址
				data : {systemID:systemID},
				success : function(data) {
					if(data.result=="success"){
						search(0);
					}else{
						layer.msg(json.code);
					}
				},
				
			});
		}

		</script> 

	</body>
</html>
