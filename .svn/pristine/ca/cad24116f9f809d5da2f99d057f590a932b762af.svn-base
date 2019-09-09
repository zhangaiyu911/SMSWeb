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
<input type="hidden" id="itemID" name="itemID" value="${itemID}"/>
<input type="hidden" id="page" name="page" value="${page}"/>
	<div class="pd-20">
		<form action="" method="post" class="form form-horizontal" id="formUser">
		<div class="mt table_box tablelist container">
		<div class="div_scroll">
		<table width="100%" class="supplierTable">
			<tbody>
				<tr class="text-c">
					<th width="12%">供货商名称：${systemSupplier.supplierName}</th>
					<th width="12%">负责人名称：${systemSupplier.consignorName}</th>
					<th width="10%">供货商简码：${systemSupplier.supplierCode}</th>
				</tr>
				<tr class="text-c">
					<th width="10%">电话：${systemSupplier.consignorPhone}</th>
					<th width="10%">传真：${systemSupplier.consignorFax}</th>
					<th width="10%">座机：${systemSupplier.consignorMobile}</th>
				</tr>
				<tr class="text-c">
					<th width="10%">经营类型：${systemSupplier.saleContent}</th>
					<th width="10%">办公地点：${systemSupplier.officeAddr}</th>
					<th width="10%">简介：${systemSupplier.memo}</th>
				</tr>
			</tbody>
		</table>
		</div>
		</div>
			  	   <input type="hidden" id="supplierID" name="supplierID" value="${supplierID}"/>
			  	   <input type="hidden" id="ids" name="ids" value="${ids}"/>
	  	      <c:forEach var="certificatesItemList" items="${certificatesItemList}" varStatus="i">	
	  	      
				<table width="100%" border="0" cellpadding="0" cellspacing="0" style="font-size:14px" class="container">
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
						
				  	         <a href="<%=basePath%>/images/zanwu.jpg">
				  	         <img src="<%=basePath%>/images/zanwu.jpg" width="200" height="150" id="img${certificatesItemList.itemID}" />
				  	         </a>
						 </c:if>		  	            

			  	        
					</td>
				  </tr>
				  <tr>
				    <td align="center" valign="middle" height="30">证件到期日期：</td>
				    <td align="left" valign="middle">
				    &nbsp;<input class="inputreadonly" maxlength="20" readonly="readonly" type="text" name="stopdate${certificatesItemList.itemID}" id="stopdate${certificatesItemList.itemID}" value="${certificatesItemList.endDate}" />
	  	            <span id="stopdatemess${certificatesItemList.itemID}"></span>
	  	            </td>			  	            
				  </tr>
				    <tr>
				    <td align="center" valign="middle" height="30">证件编号：</td>
				    <td align="left" valign="middle">						    
				    &nbsp;<input type="text" maxlength="20"  readonly="readonly" name="certificatenum${certificatesItemList.itemID}" id="certificatenum${certificatesItemList.itemID}" value="${certificatesItemList.certificatesCode}" datatype="*" nullmsg="证件号不能为空"/>
	  	            </td>
				  </tr>
 
				</table>  
	 		  	        	
	  	        <br/>
	  	      </c:forEach>
	  	      
	  	     <div class="row cl">
		      <label class="form-label col-3" for="staff_confirmation">不通过原因：</label>
		      <div class="formControls col-5">
		      
		     <textarea id="memo" name="memo" class="textarea" dragonfly="true" onkeyup="textarealength(this,100)" ></textarea>
		      
		      </div>
		      <div class="col-4"> </div>
		    </div> 
		    <div class="row cl">
		      	<div class="col-9 col-offset-3">
		        	<button class="btn btn-primary radius" type="button"  onclick="supplier_open()"><i class="Hui-iconfont">&#xe632;</i> 通过</button>
		        	<button class="btn btn-danger radius" type="button"  onclick="supplier_del()"><i class="Hui-iconfont">&#xe632;</i> 不通过</button>
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

/*通过*/
function supplier_open(){
	layer.confirm('确认要通过吗？',function(index){
		var page = $("#page").val();
		var itemID=$("#itemID").val();
		//alert(page);
		url="<%=basePath%>/supplier/successSupplier.action?supplierID=";
		$.ajax({
			type :"POST",
			dataType:"json",
			async:false,
			url:url,
			data:{ids:itemID},
			success:function(data){
				if(data.result=="success"){
					layer.msg('成功！！',{icon:6,time:1000});
					parent.search(page-1);
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
				}else{
					layer.msg('失败!',{icon:5,time:1000});
				}
			}
		});
		
		
	});
}

/*不通过*/
function supplier_del(){
		layer.confirm('确认要不通过吗？',function(index){
			var memo = $("#memo").val();
			var page = $("#page").val();
			var itemID=$("#itemID").val();
			//alert(page);
			url="<%=basePath%>/supplier/delSupplier.action?supplierID=";
			$.ajax({
				type :"POST",
				dataType:"json",
				async:false,
				url:url,
				data:{ids:itemID,"memo":memo},
				success:function(data){
					if(data.result=="success"){
						layer.msg('成功！！',{icon:6,time:1000});
						parent.search(page-1);
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
