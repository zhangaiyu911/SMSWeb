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
<style type="">
</style>
</head>
<body>
	<div class="pd-20">
	 <input type="hidden" id="index" name="index" value="${index}"/>
		<form action="" method="post" class="form form-horizontal" id="formUser">
			  	   <input type="hidden" id="supplierID" name="supplierID" value="${supplierID}"/>
			  	   <input type="hidden" id="ids" name="ids" value="${ids}"/>
	  	      <c:forEach var="certificatesItemList" items="${certificatesItemList}" varStatus="i">	
	  	      
				<table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-size:14px">
				  <tr>
				    <td align="center" valign="middle" width="180px" height="30">
							证件名称：
					</td>
					<td align="left" valign="middle" width="400px">
					 &nbsp;${certificatesItemList.certificatesName}
	  	             <input type="hidden" name="tmpurl${certificatesItemList.itemID}" id="tmpurl${certificatesItemList.itemID}" value=""/>
					</td>
					<td rowspan="4" style="padding-left:10px" align="left" valign="middle" >
					&nbsp;
					
						 <c:if test="${certificatesItemList.savePath!=''}">								 					  	         
			  	         <a href="<%=basePath%>/certificates/${certificatesItemList.savePath}" target="_blank">
			  	         <img src="<%=basePath%>/certificates/${certificatesItemList.savePath}" width="200" height="110" id="img${certificatesItemList.itemID}" />
			  	         </a>
						 </c:if>
						 
						 <c:if test="${certificatesItemList.savePath==''}">
						
			  	         <img src="<%=basePath%>/images/zanwu.jpg" width="200" height="150" id="img${certificatesItemList.itemID}" />
			  	        
						 </c:if>		  	            

			  	        
					</td>
				  </tr>
				  <tr>
				    <td align="center" valign="middle" height="30">证件到期日期：</td>
				    <td align="left" valign="middle">
				    &nbsp;<input class="Wdate inputreadonly" maxlength="20" readonly="readonly" type="text" name="stopdate${certificatesItemList.itemID}" id="stopdate${certificatesItemList.itemID}" value="${certificatesItemList.endDate}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" datatype="*" nullmsg="到期日期不能为空" onchange="ischeckstopdate(${certificatesItemList.itemID},this.value);"/>
	  	            <span id="stopdatemess${certificatesItemList.itemID}"></span>
	  	            </td>			  	            
				  </tr>
				    <tr>
				    <td align="center" valign="middle" height="30">证件编号：</td>
				    <td align="left" valign="middle">						    
				    &nbsp;<input type="text" maxlength="20" name="certificatenum${certificatesItemList.itemID}" id="certificatenum${certificatesItemList.itemID}" value="${certificatesItemList.certificatesCode}" datatype="*" nullmsg="证件号不能为空"/>
	  	            </td>
				  </tr>
				  <tr>
				    <td align="center" valign="middle" height="30">
				           文件上传：	
<%-- 				    <input type="hidden" readonly="readonly" name="photourl${certificatesItemList.itemID}" id="photourl${certificatesItemList.itemID}" value="${certificatesItemList.savePath}" onchange="photopai(${certificatesItemList.itemID});"/>					   --%>
				    </td>
				    <td align="left" valign="middle">
				    						        
			  	        <span id="mess${certificatesItemList.itemID}"></span>					  	        
						<input type="hidden" name="photourl${certificatesItemList.itemID}" id="photourl${certificatesItemList.itemID}" value="${certificatesItemList.savePath}" onchange="photopai(${certificatesItemList.itemID});"/>			  	        
			  	        			  	        
			  	        
<%-- 			  	        <input type="button" name="f" id="f" value="证件拍照" onclick="openphotograph(${qualificationsList.sqid});"/> --%>
				    
<%-- 				        <input type="button" name="g" id="g" value="本地照片" onclick="upf(${certificatesItemList.itemID})"/> --%>
				        <div class="div1">
					        <div class="div2" id="imgdiv" >上传照片</div>
					        <input type="file" class="inputstyle" id="onefile${certificatesItemList.itemID}" name="onefile${certificatesItemList.itemID}" onchange="ajaxFileUpload(this.value,${certificatesItemList.itemID});" />
						</div>
				        
				    
				    
				    </td>
				  </tr>  
				</table>  
	 		  	        	
	  	        <br/>
	  	      </c:forEach>
		    <div class="row cl">
		      	<div class="col-9 col-offset-3">
		        	<button class="btn btn-primary radius" type="button"  onclick="savedata()"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
<!-- 					<button class="btn btn-default radius" type="button" onclick="layer_close();"><i class="Hui-iconfont">&#xe66b;</i>取消</button> -->
		      	</div>
		    </div>
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
<script type="text/javascript">

$(function(){
	
	$(".select").chosen();
	
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});	
	 
});

/**
 * 判断特殊字符 并排除
 */
function ValidateValue(textbox){
	var IllegalString = "\`~@#;,.!#$%^&*(){}|\\:\"<>?=/,\'";
	
    var textboxvalue = textbox.value;
    var index = textboxvalue.length - 1;
      
    var s = textbox.value.charAt(index);
      
    if(IllegalString.indexOf(s)>=0){
    	s = textboxvalue.substring(0,index);
    	textbox.value = s;
    }
} 


//验证到期日期大于今天
function ischeckstopdate(sqid,stopdate){

	var stopdate1 = new Date(stopdate.replace(/-/g, "/"));
    var dangqian = new Date(getCurrentDate().replace(/-/g, "/"));

    
	var days = dangqian.getTime() - stopdate1.getTime();
 
    var time = parseInt(days / (1000 * 60 * 60 * 24));
    
    if(time>=0){
    	$("#stopdatemess"+sqid).html("<font color='#990000'>证件到期日期应大于当前日期！</font>");
    }else{
    	$("#stopdatemess"+sqid).html("");
    }
}

//保存数据
function savedata(){

	//验证证件到期日期
	
	var CurrentDate = getCurrentDate();//获取当前日期
				    
	var stopdate=$("input[id^='stopdate']");
	
	for(var i=0;i<stopdate.length;i++){
		
// 		if(stopdate[i].value.length>0){
			
			if(stopdate[i].value.length==0){						
				alert("请填写证件到期日期!");
				return;
			}
			var startDate = new Date(stopdate[i].value.replace("-",",")).getTime() ;  //上传日期
			var Current = new Date(CurrentDate.replace("-",",")).getTime() ;  //当前日期 
	
			if(Current>startDate){
				alert("请输入正确的证件到期日期!");
				return;
			}
// 		}
	}
	
	//验证证件编号
	var cnumlist = $("input[id^='certificatenum']");//获取所有证件编号集合

	for(var i=0;i<cnumlist.length;i++){
		
		var cnum_tmp = cnumlist[i].value;	
		
		if(cnum_tmp.length>0){			
			if (/[@#\$%\^&\*]+/g.test(cnum_tmp)) {
				alert("请输入正确的证件编号");			
				return;
			};			
		}else{
			alert("请输入正确的证件编号");			
			return;
		};
	}
	
	var imgList=$("input[id^='photourl']");
	for ( var i = 0; i < imgList.length; i++) {
		var img_tmp=imgList[i].value;
		if(img_tmp.length==0){
			alert("请上传证件");			
			return;
		};
	}
	
	var options={
			type:"POST",
			dateType:"json",
			url:"<%=basePath%>/user/saveCertificatesItem.action",
			success:function(data){
			 var json=JSON.parse(data);	
				if(json.result=="success"){
					parent.parent.layer.msg(json.code);							
					var index = layer.index; //获取当前弹层的索引号
					layer.close(index);
				}else{
					parent.layer.msg(json.code);
				}; 
				
			},
			error:function(XMLHttpRequest, textStatus, errorThrown) {
				layer.msg('输入不合法！',{icon: 5,time:2000});
			}
	};
	$("#formUser").ajaxSubmit(options); 
}

function getCurrentDate(){			
	var day = new Date();		
	var Year = 0; 
	var Month = 0; 
	var Day = 0; 
	var CurrentDate = "";
	
	Year = day.getFullYear(); 
	Month = day.getMonth()+1; 
	Day = day.getDate(); 
	
	CurrentDate += Year + "-"; 
	
	if (Month >= 10){ 
		CurrentDate += Month + "-"; 
	}else{ 
		CurrentDate += "0" + Month + "-"; 
	} 
	if (Day >= 10 ){ 
		CurrentDate += Day ; 
	}else{ 
		CurrentDate += "0" + Day ; 
	}
	return CurrentDate;
};
//文件上传  
function ajaxFileUpload(fileurl,sqid){
	
	$("#wwww").attr("disabled", true);

	
	if(fileurl!=""){
		//后缀名
		var ext=fileurl.substring(fileurl.lastIndexOf(".")+1).toLowerCase();	
		
		if(ext=="jpg"||ext=="png"||ext=="bmp"){
			
			var options={
					type:"POST",
					dateType:"json",
					url:"<%=basePath%>/user/QualificationsPhotoFileUpload.action?itemID="+sqid,
					success:function(data){
					 var json=JSON.parse(data);	
						if(json.result=="success"){
							var imagesphoto = json.certificates;
							$("#photourl"+sqid).val(imagesphoto);
							$("#img"+sqid).attr("src","<%=basePath%>/certificates/"+imagesphoto);
						}else{
							parent.layer.msg(json.code);
						}; 
						
					},
					error:function(XMLHttpRequest, textStatus, errorThrown) {
						layer.msg('输入不合法！',{icon: 5,time:2000});
					}
			};
			$("#formUser").ajaxSubmit(options); 
		    
		}else{						
			alert("文件类型不正确！请上传.jpg .png .bmp类型的文件");
		};
		
		
		
		
		
	};
}
</script>	
</body>
</html>
