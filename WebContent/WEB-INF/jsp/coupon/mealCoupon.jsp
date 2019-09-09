<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=basePath%>/js/H-ui.admin.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/Dropdownlist/chosen.jquery.js"></script>

<title>餐券列表</title>

<style>
#bu1 {
	margin-left:700px;
    padding:5px;
}
</style>


<script>

function add(){
	console.log("成功进入方法!");
	url = "<%=basePath%>/coupon/addMealCoupon.action";
	layer_show('新增餐票',url,'450','400');
}

function test(){
	console.log("成功进入方法!");
	$.ajax({
		type : "POST",
		dataType : "json", 
		async : false,
		url : "<%=basePath%>/coupon/test.action", 
		success : "添加成功"
	});	
	console.log("方法执行成功!");
}
</script>

</head>

<body>
	<h1 align="center">点餐啦点餐啦</h1>
	
	<div id="bu1">
	
		<button type="submit" onclick="add()">添加</button>
	</div>
	
	<div id="ta1">
	<table align="center" border="1">
		<tr>
			<td></td>
			<td>餐券名称</td>
			<td>餐券类型</td>
			<td>可用金额</td>
			<td>服务费用</td>
			<td>全部金额</td>
			<td>使用时间</td>
		</tr>	
		<c:forEach var = "item" items="${couponList}" >
		<tr>
			<td><input type="checkbox"></td>
			<td>${item.cardName}</td>
			<td>${item.cardType}</td>
			<td>${item.realMoney}</td>
			<td>${item.serviceMoney}</td>
			<td>${item.totalMoney}</td>
			<td></td>
		</tr>
		</c:forEach>
		
	</table>
	
	</div>




</body>



</html>