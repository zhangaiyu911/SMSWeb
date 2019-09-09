<%@ page contentType="text/html;charset=GBK" %>
<%@ taglib uri="/WEB-INF/runqianReport4.tld" prefix="report" %>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="com.runqian.report4.usermodel.Context"%>
<html>
<head>
<title>��ӡԤ��</title>
<style type="text/css">
html,body{
	margin: 0px;
	padding: 0px;
}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("GBK");
	String report = request.getParameter("raq");
	String reportFileHome = Context.getInitCtx().getMainDir();
	StringBuffer param = new StringBuffer();
	
	//��֤�������Ƶ�������
	int iTmp = 0;
	if( (iTmp = report.lastIndexOf(".raq")) <= 0 ){
		report = report + ".raq";
		iTmp = 0;
	}
	
	Enumeration paramNames = request.getParameterNames();
	if(paramNames!=null){
		while(paramNames.hasMoreElements()){
			String paramName = (String) paramNames.nextElement();
			String paramValue=URLDecoder.decode(request.getParameter(paramName),"utf-8");
			if(paramValue!=null){
				//�Ѳ���ƴ��name=value;name2=value2;..����ʽ
				param.append(paramName).append("=").append(paramValue).append(";");
			}
		}
	}

	//���´����Ǽ����������Ƿ�����Ӧ�Ĳ���ģ��
	String paramFile = report.substring(0,iTmp)+"_arg.raq";
	File f=new File(application.getRealPath(reportFileHome + File.separator + paramFile));
%>
<%//�������ģ����ڣ�����ʾ����ģ��
	if(f.exists()) {
%>
	<table id="param_tbl">
		<tr>
			<td>
				<report:param name="form1" paramFileName="<%=paramFile%>" needSubmit="no" params="<%=param.toString()%>"/>
			</td>
			<td>
				<a href="javascript:_submit(form1)"><img src="../images/query.jpg" border="no" style="vertical-align:middle" /></a>
			</td>
		</tr>
	</table>
<% 
	}
%>

<table align="center">
	<tr>
		<td>		
			<report:print name="report1" reportFileName="<%=report%>" params="<%=param.toString()%>" width="800" height="600" generateParamForm="no" exceptionPage="/reportJsp/myError2.jsp" />
		</td>
	</tr>
</table>
</body>
</html>
