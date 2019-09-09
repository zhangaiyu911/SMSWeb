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
<title>����Ķ�����ҳ�������˵��</title>  

<script>

	
function Connect(){
	clearForm();
	var start = new Date();
    var ret = trendcote.connect();
	var end = new Date();
    var conn = JSON.parse(ret);
	document.getElementById("ReadCard_time").value = end.getTime() - start.getTime() + "����";
    document.all['result'].value = ret;
}

function Disconnect(){
	clearForm();
	var start = new Date();
    var ret = trendcote.disconnect();
	var end = new Date();
    var disConn = JSON.parse(ret);
	document.getElementById("ReadCard_time").value = end.getTime() - start.getTime() + "����";
    document.all['result'].value = ret;
}
function GetVersion()
{
	clearForm();
	var start = new Date();
    var ret = CertCtl.getVersion();
	var end = new Date();
    var disConn = JSON.parse(ret);
	document.getElementById("ReadCard_time").value = end.getTime() - start.getTime() + "����";
    document.all['result'].value = ret;
}

function GetStatus() {
	clearForm();
    var ret = CertCtl.getStatus();
    var cert  = JSON.parse(ret);
    document.all['result'].value = ret;
}


function ReadCert() {
	clearForm();
	var start = new Date();
    var ret = trendcote.readcard();
	var end = new Date();
    var cert  = JSON.parse(ret);
	document.getElementById("ReadCard_time").value = end.getTime() - start.getTime() + "����";
    document.all['result'].value = ret;
}

function ReadIDCard(){
	clearForm();
    var ret = trendcote.connect();
    var conn = JSON.parse(ret);
	if(conn.resultFlag != 0){
		 document.all['result'].value = "����ʧ��:"+conn.errorMsg;
	}
	var start = new Date();
	ret = trendcote.readcard();
	var end = new Date();
	document.getElementById("ReadCard_time").value = end.getTime() - start.getTime() + "����";

	var cert  = JSON.parse(ret);
	if(cert.resultFlag != 0){
		document.all['result'].value = "readCertʧ��:"+cert.errorMsg;
	}else{
		document.all['result'].value = "�����ɹ�";
		document.all['Name'].value = cert.resultContent.partyName;
		document.all['Sex'].value = cert.resultContent.gender;
		document.all['Nation'].value = cert.resultContent.nation;
		document.all['Born'].value = cert.resultContent.bornDay;
		document.all['Address'].value = cert.resultContent.certAddress;
		document.all['CardNo'].value = cert.resultContent.certNumber;
		document.all['Police'].value = cert.resultContent.certOrg;
		document.all['ActivityLFrom'].value = cert.resultContent.effDate;
		document.all['ActivityLTo'].value = cert.resultContent.expDate;
        document.all['PhotoDisplay'].src = 'data:image/jpeg;base64,' + cert.resultContent.identityPic;
	}
	ret = trendcote.disconnect();
    var disConn = JSON.parse(ret);
	if(disConn.resultFlag != 0){
		document.all['result'].value = "disconnectʧ��:"+disConn.errorMsg;
	}
}


function clearForm() {
  document.all['Name'].value = '';
  document.all['Sex'].value = '';
  document.all['Nation'].value = '';
  document.all['Born'].value = '';
  document.all['Address'].value = '';
  document.all['CardNo'].value = '';
  document.all['Police'].value = '';
  document.all['ActivityLFrom'].value = '';
  document.all['ActivityLTo'].value = '';
  document.all['result'].value = '';
  
}

function SetBtAddr(){
	var addr = document.getElementById("btmac").value;
	console.log(addr);
	CertCtl.SetBtDeviceAddress(addr);
}
	</script>
</head>  
<body>  
<object id="trendcote" TYPE="application/idcard-reader" width=0 height=0">
<p style="color:#FF0000;">�ؼ������ã�����δ��ȷ��װ�ؼ������������߿ؼ�δ���á�</p>
</object> 

<div>
<table border="0" width="100%" cellpadding="0" cellspacing="1">

<tr>

</tr>

<tr>
<td><input type="button"  value="��ȡ" onclick="ReadIDCard()"></td>

</tr>


</table>

<table border="0" width="100%" cellpadding="0" cellspacing="0">


<tr>
<td>&nbsp;</td>
<td></td>
</tr>

<tr>
<td align="right">ʱ�䣺</td>
<td><input type="text" name="ReadCard_time"  id="ReadCard_time" size="49"></td>
</tr>

<tr>
<td align="right">������</td>
<td><input type="text" name="Name" size="49"></td>
</tr>

<tr>
<td align="right">�Ա�</td>
<td><input type="text" name="Sex" size="49">(ȡֵΪ��1������ʾ���С�����0������ʾ��Ů����)</td>
</tr>

<tr>
<td align="right">���壺</td>
<td><input type="text" name="Nation" size="49"></td>
</tr>

<tr>
<td align="right">������</td>
<td><input type="text" name="Born" size="49"></td>
</tr>

<tr>
<td align="right">��ַ��</td>
<td><input type="text" name="Address" size="49"></td>
</tr>


<tr>
<td align="right">���֤�ţ�</td>
<td><input type="text" name="CardNo" size="49" style="color: #FF0000"></td>
</tr>


<tr>
<td align="right">ǩ�����أ�</td>
<td><input type="text" name="Police" size="49"></td>
</tr>

<tr>
<td align="right">������ʼ��</td>
<td><input type="text" name="ActivityLFrom" size="49"></td>
</tr>


<tr>
<td align="right">����ʧЧ��</td>
<td><input type="text" name="ActivityLTo" size="49"></td>
</tr>

<tr>
<td align="right">��Ƭ��</td>
<td><img name="PhotoDisplay" style="width:102px; height:126px;"/></td>
</tr>

<tr>
<td align="right">�����</td>
<td><textarea rows="8"  id="result" cols="47"></textarea></td>
</tr>

</table>
	</div>
</body>  
</html>