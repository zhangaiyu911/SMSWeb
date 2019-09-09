<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage=""%>
<%@ include file="/includes/include_core.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />	
<title>详情</title>
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
.container{margin-left: 30px; margin-top: 20px;}
.container a{cursor:}
.containers{margin-left: 30px; margin-top: 10px;}
img{cursor: pointer;}
#pic{position: absolute; display: none;z-index:99;}
#pic img{max-width:500px}
</style>
</head>
<body>
<%-- <input type="hidden" id="itemID" name="itemID" value="${itemID}"/> --%>
<input type="hidden" id="page" name="page" value="${page}"/>
<input type="hidden" name="errorcode" id="errorcode" value="${errorcode}" />
	<div class="pd-20">
		<form action="" method="post" class="form form-horizontal" id="formUser">
			  	   <input type="hidden" id="supplierID" name="supplierID" value="${supplierID}"/>
	  	      <c:forEach var="certificatesItemList" items="${certificatesItemList}" varStatus="i">	
	  	      
				<table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-size:14px" class="container">
				  <tr>
				  	<td><input type="checkbox" class="cb" id="itemID" name="itemID" value="${certificatesItemList.itemID}"/></td>
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
						
				  	         <a href="<%=basePath%>/images/zanwu.jpg">
				  	         <img src="<%=basePath%>/images/zanwu.jpg" width="200" height="150" id="img${certificatesItemList.itemID}" />
				  	         </a>
						 </c:if>		  	            

			  	        
					</td>
				  </tr>
				</table>  
	 		  	        	
	  	        <br/>
	  	      </c:forEach>
	  	      
		    <div class="row cl">
		      	<div class="col-9 col-offset-3">
		        	<button class="btn btn-danger radius" type="button"  onclick="certificates_del()"><i class="Hui-iconfont">&#xe632;</i> 删除</button>
					<button class="btn btn-default radius" type="button" onclick="layer_close();"><i class="Hui-iconfont">&#xe66b;</i>取消</button>
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
	
	var errorcode = $("#errorcode").val();
	if (errorcode != '') {
		show_success_msg(errorcode, '2000');
	}
	
	$(".select").chosen();
	
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
// 	$(".container a").hover(function(){
		
//         $(this).append("<p id='pic'><img src='"+this.href+"'></p>");
//         $(".container a").mousemove(function(e){
//             $("#pic").css({
//                 "top":(e.pageY+10)+"px",
//                 "left":(e.pageX-400)+"px"
//             }).fadeIn("fast");
//             // $("#pic").fadeIn("fast");
//         });
//     },function(){
//         $("#pic").remove();
//     });
// 	$(".container a").click(function(){
// 		return false;
// 	}); 
	
	 
});



/*不通过*/
function certificates_del(){
		layer.confirm('确认要删除吗？',function(index){
			if($(".cb:checked").length==0){
				layer.msg('请选择要删除的内容!',{icon:5,time:3000});
				return;
			}
			var ids = $(".cb:checked")[0].value;
			for(var i=1;i<$(".cb:checked").length;i++){
				ids+=","+ $(".cb:checked")[i].value;
			}
			url="<%=basePath%>/order/delCertificatesOrdering.action?supplierID=";
			$.ajax({
				type :"POST",
				dataType:"json",
				async:false,
				url:url,
				data:{ids:ids},
				success:function(data){
					if(data.result=="success"){
						layer.msg('成功！！',{icon:6,time:1000});
						parent.search(0);
						var index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
					}else{
						layer.msg('失败!',{icon:5,time:1000});
					}
				}
			});
			});
}



	

	

	




</script>	
</body>
</html>
