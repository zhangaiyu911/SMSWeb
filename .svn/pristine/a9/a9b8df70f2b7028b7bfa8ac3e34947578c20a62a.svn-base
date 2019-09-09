<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>入库单管理</title>
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
<script type="text/javascript" src="<%=basePath%>/script/util.js"></script>
<script type="text/javascript" src="<%=basePath%>/lib/My97DatePicker/WdatePicker.js"></script>
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
	var inStockType=$("#inStockType").val();
	var pro = "&systemID="+$("#systemID").val()
		+ "&supplierID="+$("#supplierID").val()
	+"&begintime="+$("#begintime").val()
	+"&endtime="+$("#endtime").val()
	+"&inStockType="+inStockType;
	$("#pro").val(pro);
	
	$.ajax({
		type : "POST", // 用POST方式传输
		dataType : "json", // 数据格式:JSON
		async : false,
		url : '<%=basePath%>/inStock/getInStockCount.action', // 目标地址
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
		url : '<%=basePath%>/inStock/getInStockPage.action', // 目标地址
		data : pro + "&page=" + page + "&limit=" + pagenum,
		success : function(json) {
			$(".inStockTable tr:gt(0)").remove();
			var inStockType=$("#inStockType").val();
			// 遍历查询到的数据,输入前台
			$.each(json, function(i, n) {
				var html = "";
				//明细
				html += "<tr class='text-c'>";
				html += "<td><input type='checkbox' class='cb' name='itemID'  value='"+n.instockID+"' /></td>";
				html += "<td>"+(i+1)+"</td>";
				html += "<td>"+ n.instockID +"</td>";
				html += "<td>"+ n.supplierName +"</td>";
				if(inStockType==1){
					html += "<td>"+ n.customerName +"</td>";
					}
				html += "<td>"+ n.instockmoney +"</td>";
				if(n.instocktime==null||n.instocktime==""){
					html += "<td></td>";
				}else{
					html += "<td>" +(new Date(n.instocktime.replace('-','/'))).Format('yyyy-MM-dd') + "</td>";	
				}
				if(n.operdate==null||n.operdate==""){
					html += "<td></td>";
				}else{
					html += "<td>" +(new Date(n.operdate.replace('-','/'))).Format('yyyy-MM-dd') + "</td>";	
				}
				
				
				html += "<td><a class='btn_set btn016' style='color:green' onclick='oper(" + n.systemID + ","+n.instockID+")'>操作</a></td>";
				html += "</tr>";
				
				$(".inStockTable").append(html);
			});
			//$('.inStockTable').alterBgColor();   //表格选中效果
			$('table').tableCheckbox();
			$(".tablelist tbody tr:odd").addClass('odd');//表格选中效果
		},
		error : function() {
			$(".inStockTable tr:gt(0)").remove();
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
function searchInStockItem(){
	var supplierID=$("#supplierID").val();
	var systemID=$("#systemID").val();
	var begintime=$("#begintime").val();
	var endtime=$("#endtime").val();
	if(supplierID=="0"||systemID==""){
		layer.msg('请选择供货商,系统平台',{icon:5,time:2000});
		return;
	}
	if(begintime=="0"||endtime==""){
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
	<input type="hidden" name="systemID" id="systemID" value="${systemID}" />
	<input type="hidden" name="inStockType" id="inStockType" value="${inStockType}" />
	
		<nav class="breadcrumb">
			<i class="Hui-iconfont">&#xe67f;</i> 首页 
			<span class="c-gray en">&gt;</span> 报表管理
			<span class="c-gray en">&gt;</span> <c:if test="${inStockType==1}">食堂</c:if><c:if test="${inStockType==2}">采购</c:if>入库单列表 
			<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
				<i class="Hui-iconfont">&#xe68f;</i>
			</a>
		</nav>
		<div class="pd-20">
			<div id="tab-system" class="HuiTab">
				
				<div class="tabCon">
					<div class="cl pd-5 bg-1 bk-gray mt"> 
						<span class="l" id="box1">	
<!--                		 	<a class="btn_set btn004" href="javascript:;"  id="dialog-link">查询</a> -->
               		 	<a class="btn_set btn004" href="javascript:;"  onclick="searchInStockItem()">查询</a>
               		 	<a class="btn_set btn013" href="javascript:;"  onclick="print()">打印</a>
						</span>
						<span class="l" id="box2" style="display:none">
							<a class="btn_set btn005"  href="javascript:;"  onclick="orderback('返回','','')" >返回</a>
<!-- 	               		 	<a class="btn_set btn004" href="javascript:;"  onclick="print()">打印</a> -->
						</span>  
						
					</div>
				 <div class="dialog_div">
				 <label class="dialog_label">客户：</label>
				<select class="select dialog_select" id="systemID" name="systemID" onchange="getSupplier(this)">
					<option value="0" >请选择</option>
						<c:forEach items="${wuliuSystemList}" var="i">
		                	<option  value="${i.systemID}">${i.systemName}</option>
		               	</c:forEach>
				</select>
						<label class="dialog_label">供货商：</label>
						<select class="select dialog_select" id="supplierID" name="supplierID">
						<option value="0" >请选择</option>
			  				<c:forEach items="${systemSupplierList}" var="i">
                  				<option  value="${i.supplierID}">${i.supplierName}</option>
                 			</c:forEach>
						</select>
				<label class="dialog_label">开始时间:</label>
				<input type="text" class="select dialog_select" id="begintime"	name="begintime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
				<label class="dialog_label">结束时间:</label>
				<input type="text" class="select dialog_select" id="endtime" name="endtime" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			</div> 	
					
				<div  id="table1" >
				<div id="pagination" class="digg"></div>
					<div class="mt table_box tablelist container">
						<div class="div_scroll">
							<table width="100%" class="inStockTable">
								<thead>
									<tr class="text-c">
										<th width="4%"><input type="checkbox"/></th>
										<th width="4%">序号</th>
										<th width="12%">入库单号</th>
										<th width="12%">供货商名称</th>
										<c:if test="${inStockType==1}">
										<th width="12%">食堂名称</th>
										</c:if>
										<th width="12%">入库金额(元)</th>
										<th width="10%">入库时间</th>
										<th width="10%">操作时间</th>
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
					<div class="mt table_box tablelist container">
						<div class="div_scroll">
							<table width="100%" class="inStockItemTable">
								<thead>
									<tr class="text-c">
										<th width="4%"><input type="checkbox"/></th>
										<th width="4%">序号</th>
										<th width="10%">入库单号</th>
										<th width="10%">商品编号</th>
										<th width="10%">客户名称</th>
										<th width="5%">单位</th>
										<th width="10%">入库数量</th>
										<th width="10%">入库单价(元)</th>
										<th width="10%">入库金额(元)</th>
										<th width="10%">生产日期</th>
										<th width="10%">保质期</th>
										<th width="7%">操作</th>
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
			
		function oper(supplierID,instockID){
			$("#box1").hide();
			$("#table1").hide();
			$("#box2").show();
			$("#table2").show();
			getOrderingItemList(supplierID,instockID);
		}
		
		//返回操作
		function orderback(){
			$("#box2").hide();
			$("#table2").hide();
			$("#box1").show();
			$("#table1").show();
			search(0);
		}
		function getOrderingItemList(systemID,instockID) {
			var inStockType=$("#inStockType").val();
			var pro = "&systemID="+systemID+ "&instockid="+instockID+"&inStockType="+inStockType;
			$.ajax({
				type : "POST", // 用POST方式传输
				dataType : "json", // 数据格式:JSON
				url : '<%=basePath%>/inStock/getInStockItemList.action', // 目标地址
				data : pro ,
				success : function(json) {
					$(".inStockItemTable tr:gt(0)").remove();
					// 遍历查询到的数据,输入前台
					var orderingID=0;
					$.each(json, function(i, n) {
						var html = "";
						orderingID=n.orderingID;
						//明细
						html += "<tr class='text-c'>";
						html += "<td><input type='checkbox' class='cb' name='itemID'  value='"+n.itemID+"' /></td>";
						html += "<td>"+(i+1)+"</td>";
						html += "<td>"+ n.instockid +"</td>";
						html += "<td>"+ n.uid +"</td>";
						html += "<td>"+ n.productName +"</td>";
						html += "<td>"+ n.unit +"</td>";
						html += "<td>"+ n.instockquantity +"</td>";
						html += "<td>"+ n.instockprice +"</td>";
						html += "<td>"+ n.instockmoney +"</td>";
						if(n.produceDate==null||n.produceDate==""){
							html += "<td></td>";
						}else{
							html += "<td>" +(new Date(n.produceDate.replace('-','/'))).Format('yyyy-MM-dd') + "</td>";	
						}
						if(n.shelfLife==null||n.shelfLife==""){
							html += "<td></td>";
						}else{
							html += "<td>" +(new Date(n.shelfLife.replace('-','/'))).Format('yyyy-MM-dd') + "</td>";	
						}
						html += "<td><a class='btn_set btn034' href='javascript:;'  onclick='filedetail("+n.orderingItemID+","+n.billsource+")'>索证 详情</a></td>";
						html += "</tr>";
						
						$(".inStockItemTable").append(html);
					});
					$("#orderingID").val(orderingID);
					//$('.inStockTable').alterBgColor();   //表格选中效果
					$('table').tableCheckbox();
					$(".tablelist tbody tr:odd").addClass('odd');//表格选中效果
				},
				error : function() {
					$(".inStockItemTable tr:gt(0)").remove();
				}
				
			});
		};
	
		function filedetail(orderingItemID,orderingID){
 			var systemID=$("#systemID").val();
			var supplierID=$("#supplierID").val();
			
			$.ajax({
				type : "POST", // 用POST方式传输
				dataType : "json", // 返回数据格式:JSON
				async : false,
				url : "<%=basePath%>/order/checkCertificates.action", // 目标地址
				data : {orderingItemID:orderingItemID,orderingID:orderingID,systemID:systemID,supplierID:supplierID},					
				success : function(json) {
					if(json=="0"){
						parent.layer.msg('未上传索证!',{icon:5,time:1000});
						layer.closeAll('dialog');
						
					}else{
						var url1="<%=basePath%>/order/showCertificates.action?supplierID="+supplierID+"&systemID="+systemID+"&orderingID="+orderingID+"&orderingItemID="+orderingItemID;
						layer_show('索证展示',url1,'900','600');
					}
					
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					layer.msg('输入不合法！',{icon: 5,time:2000});
				}
			});	
			
			
			
		}
		//打印
		function print(){
			var inStockType=$("#inStockType").val();
			var strReportFile = "";
			if(inStockType==1){
				//食堂
				 strReportFile = "InStockNoSum2.raq";
			}else{
				//采购
				strReportFile = "InStockNoSum.raq";
			}
			var supplierID=$("#supplierID").val();
			var systemID=$("#systemID").val();
			var begintime=$("#begintime").val();
			var endtime=$("#endtime").val();
			var supplierName=$("#supplierID option:selected").text();
			var systemName=$("#systemID option:selected").text();
			if(supplierID=="0"||systemID==""){
				layer.msg('请选择供货商,系统平台',{icon:5,time:2000});
				return;
			}
			if(begintime=="0"||endtime==""){
				layer.msg('请选择开始时间,结束时间',{icon:5,time:2000});
				return;
			}
			if(begintime>endtime){
				layer.msg('请选择正确的开始时间和结束时间',{icon:5,time:2000});
				return;
			}
			if($(".cb:checked").length==0){
				layer.msg('请选择内容!',{icon:5,time:3000});
				return;
			}else if($(".cb:checked").length>1){
				layer.msg('只能选择一条!',{icon:5,time:3000});
				return;
			}
			var ids = $(".cb:checked")[0].value;
			var strUserName = "<%=(String) request.getSession().getAttribute("g_UserName")%>";
			var url="<%=basePath%>/reportJSP/showReport.jsp?raq="+strReportFile+"&UserName="+strUserName+"&SupplierID="+supplierID+
					"&SystemID="+systemID+"&BeginDate="+begintime+"&EndDate="+endtime+"&SupplierName="+encodeURI(encodeURI(supplierName))+"&SystemName="+encodeURI(encodeURI(systemName))+"&InstockIDS="+ids;
			
		 	var name = "报表打印预览";
		  	//以下为打印预览语句，调试用
		  	window.open(url,name,"height="+(screen.availHeight-80)+", width="+(screen.availWidth-20)+",top=10,left=10,toolbar=no , menubar=no, scrollbars=1, resizable=1,location=0,status=1");
		}
		
		//获取供货商
		function getSupplier(obj){
			var systemID =obj.value;
			 if (systemID!="0") {
					//获取部门子类列表
					$.ajax({
						dataType : "json", 
						async : false,
						url : "<%=basePath%>/inStock/getSupplierList.action?systemID="+systemID, 
						success : function(data) {
							
							var options='';
								options+='<option value="0" >请选择</option>';
							for ( var i in data.systemSupplierList) {
								var systemSupplier=data.systemSupplierList[i];
								options+='<option value="'+systemSupplier.supplierID+'">'+systemSupplier.supplierName+'</option>';
							}
							$('#supplierID').html(options);
						},
						error : function(XMLHttpRequest, textStatus, errorThrown) {
							layer.msg('输入不合法！',{icon: 5,time:2000});
						}
					});	
			}else{
				$('#supplierID').empty(); 
				$("#supplierID").append("<option value='0'>请选择</option>");
			}
			
		}
		</script> 

	</body>
</html>
