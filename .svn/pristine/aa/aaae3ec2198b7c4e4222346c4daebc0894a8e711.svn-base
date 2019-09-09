<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>订单管理</title>
<link href="<%=basePath%>/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-ui-1.11.4.custom/jquery-ui.css"/>
<link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/Pagination/kkpager_orange.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/style/pagination/pagination.css"/>
<jsp:include page="/includes/head_js.jsp" flush="true"/>
<script type="text/javascript" src="<%=basePath%>/lib/laydate-master/laydate.dev.js"></script> 
<script type="text/javascript" src="<%=basePath%>/js/jquery.form.js"></script>
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
	$("#begintime").val((new Date()).Format('yyyy-MM-dd'));
	var now=new Date();
	now.setDate(now.getDate()+1);
	$("#endtime").val((now).Format('yyyy-MM-dd'));
	
	//查询点击事件
	$('#search').click(function(){
		
		search(0);
	});

});

function search(page) {
	
	var pro = "&systemID="+$("#systemID").val()
		+ "&supplierID="+$("#supplierID").val()
	+"&begintime="+$("#begintime").val()
	+"&endtime="+$("#endtime").val();
	$("#pro").val(pro);
	
	$.ajax({
		type : "POST", // 用POST方式传输
		dataType : "json", // 数据格式:JSON
		async : false,
		url : '<%=basePath%>/order/getNotDownloadOrderingCount.action', // 目标地址
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
		url : '<%=basePath%>/order/getNotDownloadOrderingPage.action', // 目标地址
		data : pro + "&page=" + page + "&limit=" + pagenum,
		success : function(json) {
			$(".orderingTable tr:gt(0)").remove();
			// 遍历查询到的数据,输入前台
			$.each(json, function(i, n) {
				var html = "";
				//明细
				html += "<tr class='text-c'>";
				html += "<td><input type='checkbox' class='cbc' name='itemID'  value='"+n.itemID+"' /></td>";
				html += "<td>"+(i+1)+"</td>";
				html += "<td>"+ n.orderingID +"</td>";
				html += "<td>"+ n.customerName +"</td>";
				if(n.orderingTime==null||n.orderingTime==""){
					html += "<td></td>";
				}else{
					html += "<td>" +(new Date(n.orderingTime.replace('-','/'))).Format('yyyy-MM-dd') + "</td>";	
				}
				if (0==n.orderingFlag) {
					html += "<td>未处理</td>";
				}else if (1==n.orderingFlag) {
					html += "<td>已处理</td>";
				}else if (2==n.orderingFlag) {
					html += "<td>已配置</td>";
				}
				else if (3==n.orderingFlag) {
					html += "<td><span class='c-red'>作废</span></td>";
				}
				else{
					html += "<td>错误的状态，请修改</td>";
				}
				html += "<td><a class='btn_set btn016' style='color:green' onclick='oper(" + n.systemID + ","+n.orderingID+","+n.itemID+")'>详情</a></td>";
				html += "</tr>";
				
				$(".orderingTable").append(html);
			});
			//$('.orderingTable').alterBgColor();   //表格选中效果
			$('table').tableCheckbox();
			$(".tablelist tbody tr:odd").addClass('odd');//表格选中效果
		},
		error : function() {
			$(".orderingTable tr:gt(0)").remove();
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
function searchOrder(){
	var supplierID=$("#supplierID").val();
	var systemID=$("#systemID").val();
	var begintime=$("#begintime").val();
	var endtime=$("#endtime").val();
	if(supplierID==""||systemID=="0"){
		layer.msg('请选择系统平台',{icon:5,time:2000});
		return;
	}
	if(begintime==""||endtime==""){
		layer.msg('请选择开始时间,结束时间',{icon:5,time:2000});
		return;
	}
	if(begintime>endtime){
		layer.msg('请选择正确的开始时间和结束时间',{icon:5,time:2000});
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
	<input type="hidden" name="supplierID" id="supplierID" value="${supplierID}" />
	
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe67f;</i> 首页 
			<span class="c-gray en">&gt;</span> 订单下载
			<span class="c-gray en">&gt;</span> 下载食堂定单列表 
			<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
				<i class="Hui-iconfont">&#xe68f;</i>
			</a>
		</nav>
		<div class="pd-20">
			<div id="tab-system" class="HuiTab">
				
				<div class="tabCon">
					<div class="cl pd-5 bg-1 bk-gray mt"> 
						<span class="l" id="box1">
	               		 	<a class="btn_set btn004" href="javascript:;"  onclick="searchOrder()">查询</a>
	               		 	<a class="btn_set btn009" href="javascript:;"  onclick="downloadOrder()">下载</a>
						</span>
						<span class="l" id="box2" style="display:none">
							<a class="btn_set btn005"  href="javascript:;"  onclick="orderback('返回','','')" >返回</a>
	               		 	<a class="btn_set btn009" href="javascript:;"  onclick="downloadOrder2()">下载</a>
						</span>  
						
					</div>
					
			<div class="dialog_div" id="dialogdiv">
				<label class="dialog_label">客&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户：</label>
				<select class="select dialog_select" id="systemID" name="systemID">
				<option value="0" >请选择</option>
	  				<c:forEach items="${systemSupplierList}" var="i">
                				<option  value="${i.systemID}">${i.systemName}</option>
               			</c:forEach>
				</select>
				<label class="dialog_label">开始时间:</label>
				<input type="text" class="select dialog_select" id="begintime"	name="begintime"   onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
				<label class="dialog_label">结束时间:</label>
				<input type="text" class="select dialog_select" id="endtime" name="endtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
				
			</div> 
					
				<div  id="table1" >
				<div id="pagination" class="digg"></div>
					<div class="mt table_box tablelist container">
						<div class="div_scroll">
							<table width="100%" class="orderingTable">
								<thead>
									<tr class="text-c">
										<th width="4%"><input type="checkbox"/></th>
										<th width="4%">序号</th>
										<th width="12%">订单号</th>
										<th width="12%">客户名称</th>
										<th width="12%">订货日期</th>
										<th width="10%">订单状态</th>
										<th width="6%">操作</th>
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>
						</div>	
					</div>
				</div>
				
				<div  id="table2" id="table2" style="display: none;">
				<input type="hidden" id="orderingID" name="orderingID"/>
				<input type="hidden" id="count" name="count"/>
				<input type="hidden" id="itemIDS" name="itemIDS"/>
					<div class="mt table_box tablelist container">
						<div class="div_scroll">
							<table width="100%" class="orderingItemTable">
								<thead>
									<tr class="text-c">
										<th width="4%"><input type="checkbox"/></th>
										<th width="4%">序号</th>
										<th width="10%">定货单号</th>
										<th width="10%">商品编号</th>
										<th width="10%">客户名称</th>
										<th width="10%">单位</th>
										<th width="10%">定货数量</th>
										<th width="10%">处理数量</th>
										<th width="10%">生产日期</th>
										<th width="10%">保质期</th>
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
			
		function oper(supplierID,orderingID,itemID){
			$("#box1").hide();
			$("#table1").hide();
			$("#dialogdiv").hide();
			$("#box2").show();
			$("#table2").show();
			$("#itemIDS").val(itemID);
			getOrderingItemList(supplierID,orderingID);
		}
		
		//返回操作
		function orderback(){
			$("#box2").hide();
			$("#table2").hide();
			$("#box1").show();
			$("#table1").show();
			$("#dialogdiv").show();
			search(0);
		}
		function getOrderingItemList(systemID,orderingID) {
			
			var pro = "&systemID="+systemID+ "&orderingID="+orderingID;
			$.ajax({
				type : "POST", // 用POST方式传输
				dataType : "json", // 数据格式:JSON
				url : '<%=basePath%>/order/getOrderingItemList.action', // 目标地址
				data : pro ,
				success : function(json) {
					var viewOrderingItemList=json.viewOrderingItemList;
					$("#count").val(json.count);
					$(".orderingItemTable tr:gt(0)").remove();
					// 遍历查询到的数据,输入前台
					var orderingID=0;
					$.each(viewOrderingItemList, function(i, n) {
						var html = "";
						orderingID=n.orderingID;
						//明细
						html += "<tr class='text-c'>";
						html += "<td><input type='checkbox' class='cb' name='itemID'    value='"+n.itemID+"' /></td>";
						html +="<input type='hidden' class='cb' name='itemID"+i+"' id='itemID"+i+"'   value='"+n.itemID+"' />";
						html += "<td>"+(i+1)+"</td>";
						html += "<td>"+ n.orderingID +"</td>";
						html += "<td>"+ n.uid +"</td>";
						html += "<td>"+ n.productName +"</td>";
						html += "<td>"+ n.unit +"</td>";
						html += "<td>"+ n.orderingQuantity +"</td>";
						html += "<td>"+ n.dealQuantity +"</td>";
						if(n.productionDate==null||n.productionDate==""){
							html += "<td></td>";
						}else{
							html += "<td>" +(new Date(n.productionDate.replace('-','/'))).Format('yyyy-MM-dd') + "</td>";	
						}
						if(n.shelfLife==null||n.shelfLife==""){
							html += "<td></td>";
						}else{
							html += "<td>" +(new Date(n.shelfLife.replace('-','/'))).Format('yyyy-MM-dd') + "</td>";	
						}
						html += "</tr>";
						
						$(".orderingItemTable").append(html);
					});
					$("#orderingID").val(orderingID);
					
					
					//证件下拉框
					var options='';
					options+='<option value="" >请选择</option>';
					for ( var i in json.certificatesList) {
						var certificates=json.certificatesList[i];
						options+='<option value="'+certificates.certificatesID+'">'+certificates.certificatesName+'</option>';
					}
					$('#certificatesID').html(options);
					
					//$('.orderingTable').alterBgColor();   //表格选中效果
					$('table').tableCheckbox();
					$(".tablelist tbody tr:odd").addClass('odd');//表格选中效果
				},
				error : function() {
					$(".orderingItemTable tr:gt(0)").remove();
				}
				
			});
		};


		
		function downloadOrder(){
			if($(".cbc:checked").length==0){
				layer.msg('请选择要下载的内容!',{icon:5,time:3000});
			}else{
				layer.confirm('确认要下载吗？',function(index){
					url="<%=basePath%>/order/downloadOrdering.action?itemID=";
					var ids = $(".cbc:checked")[0].value;
					for(var i=1;i<$(".cbc:checked").length;i++){
						ids+=","+ $(".cbc:checked")[i].value;
					}
					$.ajax({
						type :"POST",
						dataType:"json",
						async:false,
						url:url,
						data:{ids:ids},
						success:function(data){
							if(data.result=="success"){
								layer.msg(data.code,{
									icon:6,time:1000
								});
								search(0);
							}else{
								layer.msg(data.code,{icon:5,time:1000});
							}
						}
					});
				});}
		}
		
		function downloadOrder2(){
				layer.confirm('确认要下载吗？',function(index){
					var itemID=$("#itemIDS").val();
					url="<%=basePath%>/order/downloadOrdering.action";
					$.ajax({
						type :"POST",
						dataType:"json",
						async:false,
						url:url,
						data:{ids:itemID},
						success:function(data){
							if(data.result=="success"){
								layer.msg(data.code,{
									icon:6,time:1000
								});
								orderback();
							}else{
								layer.msg(data.code,{icon:5,time:1000});
							}
						}
					});
				});}
		
		</script> 

	</body>
</html>
