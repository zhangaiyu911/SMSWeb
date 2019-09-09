<%@ page contentType="text/html; charset=utf-8" language="java"	import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>用户登录</title>
<jsp:include page="/includes/include_login.jsp" />
<script>
	//判断用户名、密码是否输入
	$(function() {
		// 取得错误编码
		var errorcode = $("#errorcode").val().trim();
		if (errorcode != '') {
			layer.msg(errorcode, {
				icon : 5,
				time : 1000
			});
		}
		$("#errorcode").val("");
	});

	//检查用户名、密码是否输入
	function check() {
		var username = $("#username").val();
		var password = $('#password').val();
		if (username == '') {
			errorcode = '请输入用户名！';
			layer.msg(errorcode, {
				icon : 5,
				time : 1000
			});
			return false;
		} else if (password == '') {
			errorcode = '请输入密码！';
			layer.msg(errorcode, {
				icon : 5,
				time : 1000
			});
			return false;
		}
		return true;
	}
	//注册按钮点击事件
	function userRegist(){
		var title="新用户注册";
		url="<%=basePath%>/user/userRegist.action";
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}
</script>
</head>
<body>
	<input type="hidden" value="${errorcode }" id="errorcode" />
	<div class="header">
		<div class="header_img"></div>
	</div>
	<div class="loginWraper">
		<div id="loginform" class="loginBox">
			<div class="login_title">用户登录</div>
			<form class="login_form" action="<%=basePath%>/login/login.action"
				method="post" onsubmit="return check();">
				<div class="row cl">
					<label class="form-label col-3" dir="rtl"> <i
						class="Hui-iconfont">&#xe60d;</i></label>
					<div class="formControls col-8">
						<input id="username" name="username" type="text"
							value="${username}" placeholder="用户名" class="input-text size-L" />
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-3" dir="rtl"><i
						class="Hui-iconfont">&#xe60e;</i></label>
					<div class="formControls col-8">
						<input id="password" name="password" type="password"
							placeholder="密码" class="input-text size-L">
					</div>
				</div>
				<div class="row">
					<div class="formControls col-8 col-offset-3">
						<input type="submit" id="login"
							class="btn btn-success radius size-L"
							value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
						<input
							type="reset" id="reset" class="btn btn-default radius size-L"
							value="&nbsp;重&nbsp;&nbsp;&nbsp;&nbsp;置&nbsp;">
						<input
							type="button" id="regist" class="btn btn-default radius size-L"
							value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;" onclick="userRegist()"/>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="footer">Copyright &copy; 天津市南开太阳高技术发展有限公司</div>
</body>
</html>
