<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=basePath%>/js/H-ui.admin.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/Dropdownlist/chosen.jquery.js"></script>
<title>添加餐券页面</title>


</head>
<body>
	<form action="" type="POST" id="frmSupplier">
		<div align="center">
			<br>
			餐票名称:<input name="cardname" type="text"><br>
			餐票类型:<input name="cardtype" type="text"><br>
			可用金额:<input name="realmoney" type="text"><br>
			服务费用:<input name="servicemoney" type="text"><br>
			全部金额:<input name="totalmoney" type="text"><br>
			使用时间:<input name="usedate" type="text"><br>
		</div>
		<div align="center">
			<br>
			<button type="submit" > 保存</button>
			<button onclick="layer_close();">取消</button>
		</div>
	</form>	
<script>
	function close(){
		console.log();
		layer_close();
	}
$(function(){
	$("#frmSupplier").Validform({
		tiptype:2,
		callback:function(form){
		layer.confirm('确认保存吗？',function(index){
			//保存用户信息
			saveUserInfo();
		});
		return false;
		}
	});
})

//保存用户信息方法
function saveUserInfo(){
	var options={
			type:"POST",
			dateType:"json",
			url:"<%=basePath%>/coupon/saveMealCoupon.action",
			success:function(data){
				var json=JSON.parse(data);
				if(json.result=="success"){
					parent.layer.msg(json.code);							
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
				}else{
					layer.msg(json.code);
				}
			}
	};
	$("#frmSupplier").ajaxSubmit(options);
}
	

</script>
	
	
</body>
</html>