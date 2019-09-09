<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>  
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";     
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
	<style>
	a:link { 

text-decoration: none; 
} 
a:visited { 
text-decoration: none; 
} 
a:hover { 


text-decoration: none; 
} 
		</style>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">  
<title>身份阅读器网页组件安装说明</title>  
<script>
	function test()
	{
		var obj=document.getElementById("idreader");
		if((obj==null) || (obj==undefined ))
		{
			alert("无法启动身份证阅读器组件");
			return;
		}
		alert("启动身份证阅读器组件成功");
		var result=obj.GetIDCardSN();
		var myobj=document.getElementById("CardSN");
		myobj.innerHTML="【"+result+"】";
	}
	
	</script>
</head>  
<body>  
<object id=certid classid=clsid:5FDE5079-BB94-4B8C-9ACE-239EE4FBF1F2  codebase="<%=basePath%>RootCertCA365.CAB#Version=1,0,2,0" ></object>
<object id="idreader" classid="clsid:53D79AF8-DF43-4111-81DC-C235D96CEBD5" codebase="<%=basePath%>IDCardX.CAB#version=1,1,0,0" ></object>  

<div>
	<h3>身份证阅读器网页组件安装说明</h3><br />
	<hr>
	<ul>
		<li style="list-style:none"> 1、下载并安装身份证阅读器驱动程序 </li> <a href="<%=basePath%>USBDrv3.0-x86.msi"> X86(32位)驱动下载  </a>&nbsp;&nbsp;<a href="<%=basePath%>USBDrv3.0-x64.msi"> X64(64位)驱动下载  </a><br/>
		<li style="list-style:none"> 2、下载并安装身份证阅读器的根证书</li><a href="<%=basePath%>rootFree.der"> 身份证阅读器的组件的根证书下载  </a><span>证书存储请指定【受信任的根证书颁布机构】</span><br/>
		<li style="list-style:none"> 3、下载并安装身份证阅读器的组件证书 </li><a href="<%=basePath%>clientCert.der"> 身份证阅读器的组件证书下载  </a><span>证书存储请指定【受信任的发布者】</span><br/>
		<li style="list-style:none"> 4、测试身份证阅读器 </li>【目前仅支持IE,不支持谷歌浏览器，非IE浏览器请使用IE兼容模式】<a href="javascript:test()">读身份证信息：</a> <font color="red"> <span id="CardSN"></span></font><br/>
		</ul>
	
	<hr>
	
	
	</div>
</body>  
</html>