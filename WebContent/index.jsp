<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>武汉大学物流系统云订货平台</title>
<jsp:include page="/includes/include_index.jsp" />
<script type="text/javascript" src="<%=basePath%>/js/H-ui.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/H-ui.admin.js"></script>
</head>
<body>
	<input type="hidden" id="user" value="${user}" />
	<input type="hidden" id="userID" value="${user.userID}"/>
	<input type="hidden" id="userType" value="${user.userType}"/>
	<input type="hidden" id="usingFlag" value="${usingFlag}"/>
	<input type="hidden" id=userName value="${user.userName}"/>
	<header class="Hui-header cl"> 
		<a class="Hui-logo l" title="武汉大学饮食中心云订货平台"><img src="<%=basePath%>/images/university_logo.png" class="logo" />云订货平台</a>
		<ul class="Hui-userbar">
			<li>你好,${user.userName}</li>
			<li class="dropDown dropDown_hover">
				<a href="#"><i class="Hui-iconfont">&#xe6d5;</i></a>
				<ul class="dropDown-menu radius box-shadow">
					<li><a href="#" onclick="user_edit('修改密码','','500','280')">修改密码</a></li>
					<li><a href="<%=basePath%>/login/login.action">退出</a></li>
				</ul>
			</li>
<!-- 			<li id="Hui-msg"> -->
<!-- 				<a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size: 18px">&#xe68a;</i></a> -->
<!-- 			</li> -->
		<li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" title="换肤"><i class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
			<ul class="dropDown-menu radius box-shadow">
				<li><a href="javascript:;" data-val="default" title="默认（绿色）">默认（绿色）</a></li>
				<li><a href="javascript:;" data-val="blue" title="黑色">黑色</a></li>
				<li><a href="javascript:;" data-val="green" title="蓝色">蓝色</a></li>
				<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
				<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
				<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
			</ul>
		</li>
	</ul>
	<div class="search_tool" id="search_tool">
		<i class="Hui-iconfont" title="快速检索">&#xe681;</i>
	</div>
	</header>

	<!-- 菜单栏 -->
	<aside class="Hui-aside"> 
		<input runat="server"	id="divScrollValue" type="hidden" value="" />
		<div class="menu_dropdown bk_2" id="modules">
		<c:if test="${user.userType==1}">
		<dl>
			<dt>
				<i class="Hui-iconfont">&#xe669;</i> 供货商管理  <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<li><a _href="<%=basePath%>/login/supplierList.action" href="javascript:void(0)">供货商审核</a>	</li>
				<li><a _href="<%=basePath%>/login/registCodeList.action?userID=${user.userID}" href="javascript:void(0)">验证码管理</a>	</li>
			</dd>
		</dl>
		<dl>
			<dt>
				<i class="Hui-iconfont">&#xe627;</i> 报表管理 <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a _href="<%=basePath%>/login/systemInStockList.action?userID=${user.userID}&inStockType=2" href="javascript:void(0)">采购入库单</a>	</li>
					<li><a _href="<%=basePath%>/login/systemInStockItemSummary.action?userID=${user.userID}&inStockType=2" href="javascript:void(0)">采购入库明细</a>	</li>
					<li><a _href="<%=basePath%>/login/systemInStockList.action?userID=${user.userID}&inStockType=1" href="javascript:void(0)">食堂入库单</a>	</li>
					<li><a _href="<%=basePath%>/login/systemInStockItemSummary.action?userID=${user.userID}&inStockType=1" href="javascript:void(0)">食堂入库明细</a>	</li>
				</ul>
			</dd>
		</dl>
		<dl>
			<dt>
				<i class="Hui-iconfont">&#xe6b4;</i> 电子券管理  <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<li><a _href="<%=basePath%>/coupon/mealCoupon.action" href="javascript:void(0)">餐券列表</a>	</li>
			</dd>
		</dl>
		</c:if>
		<c:if test="${user.userType==2}">
			<c:if test="${usingFlag==1}">
				<dl>
					<dt>
						<i class="Hui-iconfont">&#xe640;</i> 定单下载 <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
					<dd>
						<ul>
							<li><a _href="<%=basePath%>/login/notDownloadStockOrderList.action?userID=${user.userID}" href="javascript:void(0)">下载采购定单</a>	</li>
							<li><a _href="<%=basePath%>/login/notDownloadOrderList.action?userID=${user.userID}" href="javascript:void(0)">下载食堂定单</a>	</li>
						</ul>
					</dd>
				</dl>
				<dl>
					<dt>
						<i class="Hui-iconfont">&#xe692;</i> 供货配置 <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
					<dd>
						<ul>
							<li><a _href="<%=basePath%>/login/stockOrderList.action?userID=${user.userID}" href="javascript:void(0)">配置采购定单</a>	</li>
							<li><a _href="<%=basePath%>/login/orderList.action?userID=${user.userID}" href="javascript:void(0)">配置食堂定单</a>	</li>
						</ul>
					</dd>
				</dl>
				<dl>
					<dt>
						<i class="Hui-iconfont">&#xe627;</i> 报表管理 <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
					</dt>
					<dd>
						<ul>
							<li><a _href="<%=basePath%>/login/inStockList.action?userID=${user.userID}&inStockType=2" href="javascript:void(0)">采购送货单</a>	</li>
							<li><a _href="<%=basePath%>/login/inStockItemSummary.action?userID=${user.userID}&inStockType=2" href="javascript:void(0)">采购送货明细</a>	</li>
							<li><a _href="<%=basePath%>/login/inStockList.action?userID=${user.userID}&inStockType=1" href="javascript:void(0)">食堂送货单</a>	</li>
							<li><a _href="<%=basePath%>/login/inStockItemSummary.action?userID=${user.userID}&inStockType=1" href="javascript:void(0)">食堂送货明细</a>	</li>
						</ul>
					</dd>
				</dl>
			</c:if>
		<dl>
			<dt>
				<i class="Hui-iconfont">&#xe669;</i> 供货商管理 <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<ul>
					<li><a _href="<%=basePath%>/supplier/getSupplier.action?userID=${user.userID}" href="javascript:void(0)">供货商配置</a>	</li>
					<li><a _href="<%=basePath%>/supplier/getCertificatesItems.action?userID=${user.userID}" href="javascript:void(0)">供货商证件配置</a>	</li>
					
				</ul>
			</dd>
		</dl>
		<dl>
			<dt>
				<i class="Hui-iconfont">&#xe6b4;</i> 电子券管理  <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
			</dt>
			<dd>
				<li><a _href="<%=basePath%>/coupon/mealCoupon.action" href="javascript:void(0)">餐券列表</a>	</li>
			</dd>
		</dl>
		</c:if>
		</div>
	</aside>
	<div class="dislpayArrow">
		<a class="pngfix" href="javascript:void(0);"onclick="displaynavbar(this)"></a>
	</div>
	<section class="Hui-article-box">

	<div id="Hui-tabNav" class="Hui-tabNav">

		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active"><span title="我的桌面" id="mydesk"
					>我的桌面</span><em></em></li>
			</ul>

		</div>
		<div class="Hui-tabNav-more btn-group">
			<a id="js-tabNav-prev" class="btn radius btn-default size-S"
				href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a> <a
				id="js-tabNav-next" class="btn radius btn-default size-S"
				href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
		</div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display: none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" id="mydesk2"
				></iframe>
		</div>
	</div>

	</section>
	<div class="Hui-bottom">Copyright &copy; 天津市南开太阳高技术发展有限公司</div>
	<script type="text/javascript">
		$(function() {
			$.Huitab("#tab-system .tabBar span", "#tab-system .tabCon",
					"current", "click", "0");
			
			var userID=$("#userID").val();
			var userType=$("#userType").val();
			var usingFlag=$("#usingFlag").val();
			var userName=$("#userName").val();
			var href="<%=basePath%>/welcome.html?userID="+userID+"&userType="+userType+"&usingFlag="+usingFlag;
			$("#mydesk").attr("data-href",href);
			$("#mydesk2").attr("src",href);

		});
		$("#search_tool").click(function() {
			$("#search_pannel").fadeToggle();
		});
		
		/*用户-编辑*/
		function user_edit(title,url,w,h){
		 url="<%=basePath%>/user/editUserPassword.action?userID=";
		 var userID=$("#userID").val();
				url=url+userID;
				layer_show(title,url,w,h);
			}
	</script>

</body>
</html>
