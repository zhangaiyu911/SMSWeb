<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function print2(){
	alert(0);
	var strReportFile = "employeeInfo.raq";

	var url = "/reportJsp/showReport.jsp?raq=" + strReportFile;

	alert(url);
 	var name = "报表打印预览";

  	//以下为打印预览语句，调试用
  	window.open(url,name,"height="+(screen.availHeight-80)+", width="+(screen.availWidth-10)+",top=0,left=0,toolbar=no , menubar=no, scrollbars=1, resizable=1,location=0,status=1");
}
</script>
</head>
<body>
<input type="button" onclick="print2()"/>
</body>
</html>