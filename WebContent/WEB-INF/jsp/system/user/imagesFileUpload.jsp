<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>上传文件</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/H-ui.min.css"  />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/H-ui.admin.css"  />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/lib/Hui-iconfont/1.0.1/iconfont.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-ui-1.11.4.custom/jquery-ui.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/Pagination/kkpager_orange.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/style/pagination/pagination.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/lib/icheck/icheck.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/Dropdownlist/chosen-searchs.css"/>
<style  type="text/css">
		
		html,body{
			height:100%;
			margin:auto;
			padding:0;
			text-align:center;
			
		}
		table{
			border-collapse:collapse;
			margin:0 auto;
			width:98%;
			color:#262627; 
			font-size:14px;
		}
		table th{
			background:#cdeafa url(/NKTYWLXTWeb/images/caption_bg.jpg) repeat-x;
			font-size:12px;
			height:27px;
			line-height:27px;
		}
		
		th,td{
			border:1px solid #b7c0c9;
		}
		.search{
			background:#9cc1de url(/NKTYWLXTWeb/images/btn_bg.gif) repeat-x;
			border:1px solid #6d90b0;
			height:23px;
			line-height:23px;
			padding:0 3px;
		}
		</style>
</head>
<body>
	<div class="pd-20">
		<form action="" name="sf" id="sf" enctype="multipart/form-data" method="post">	
 	 
 	  <input type="hidden" name="sqid" id="sqid" value="${sqid}"/>
 	  
 	  <table width="665" border="0" cellspacing="0" cellpadding="0">
		 <tr>
		   <td align="right" valign="middle">		   			  
		   <input type="button" class="search" id="wwww"  onclick="closewindows()" value="完成 " />		  
		   </td>
		 </tr>
	  </table>
	  
	  <table width="665" border="0" cellpadding="0" cellspacing="0">
		<tr><td height="30px">
		本地文件选择：<input type="file" name="onefile" id="onefile" onchange="ajaxFileUpload(this.value);" style=""/>
		<span id="mess"></span>
		</td></tr>
	  </table>
	  
      </form>
	</div>
<script type="text/javascript" src="<%=basePath%>/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="<%=basePath%>/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/H-ui.js"></script> 
<script type="text/javascript" src="<%=basePath%>/js/H-ui.admin.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/Dropdownlist/chosen.jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/ajaxfileupload.js"></script>
		<script language=JavaScript>
        
			$(function(){
				
			});
			
			var imagesphoto = "";
			
			function closewindows(){
				
				var sqid = $("#sqid").val();
				if(imagesphoto!=''){
					
					$("#photourl"+sqid,window.parent.document).val(imagesphoto);
					$("#mess"+sqid,window.parent.document).html("本地文件已上传");
					$("#img"+sqid,window.parent.document).attr("src","<%=basePath%>/certificates/"+imagesphoto);
					<%-- opener.document.getElementById("photourl"+sqid).value=imagesphoto;					
					opener.document.getElementById("mess"+sqid).html="本地文件已上传！";					
					opener.document.getElementById("img"+sqid).src="<%=basePath%>"+"//"+imagesphoto; --%>
					
				}else{
					
					opener.document.getElementById("photourl"+sqid).value="";		
				}
				
			
				var index = parent.layer.getFrameIndex(window.name);
				parent.layer.close(index);
				
			}
			
			
			//文件上传  
			function ajaxFileUpload(fileurl){
				var sqid=$("#sqid").val();
				
				$("#wwww").attr("disabled", true);
			
				
				if(fileurl!=""){
					//后缀名
					var ext=fileurl.substring(fileurl.lastIndexOf(".")+1).toLowerCase();	
					
					if(ext=="jpg"||ext=="png"||ext=="bmp"){
						
					    $.ajaxFileUpload({
							url:'<%=basePath%>/user/QualificationsPhotoFileUpload.action?itemID='+sqid,
							secureuri:false,
							type: 'post',
							dataType: 'json',
							fileElementId:'onefile',							
							success: function (data){															
								$("#mess").html("本地文件已上传！");
								imagesphoto = data.certificates;
								$("#wwww").attr("disabled", false);
							}
					    });
					    
					}else{						
						alert("文件类型不正确！请上传.jpg .png .bmp类型的文件");
					}
				}
			}
		
		
		</script>
</body>
</html>
