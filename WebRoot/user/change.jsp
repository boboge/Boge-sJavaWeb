<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改个人信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	$(function(){
			$.ajax({
				type : 'POST',
				url : 'userAction!getInfo.action',
				cache : false,
				dataType : 'json',
				success : function(result) {
					$("#userid").val(result.user.userid);
					$("#name").val(result.user.name);
					$("#id").val(result.user.id);
					$("#flag").val(result.user.flag);
				}
			});
			
	  $('#submit1').bind('click', function() {
		if($('#changeForm').form('validate')){
				$.ajax({
				type : "POST",
				url : "userAction!addOrUpdate.action",
				cache : false,
				dataType : 'json',
				data : $('#changeForm').serialize(),
				success : function(result) {
					if (result.msg == 1) {
						$.messager.show({
							title : '提示',
							msg : '操作成功',
						});
					$("#eqpwd").val("");
					$("#password").val("");
					}else {
					$.messager.show({
							title : '提示',
							msg : '操作失败',
						});
						
					}	
				}
			});
			}
		});
			

  });
  
  		$.extend($.fn.validatebox.defaults.rules, {
			eqpwd : {
				validator : function(value, param) {
					return value == $(param[0]).val();
				},
				message : '两次密码不一致'
			}
		});
		

	
		
	
	</script>

  </head>
  
  <body>
  <div id="login" style="margin-left: 300px;margin-top: 50px;" >
  <form id="changeForm" action="userAction!addOrUpdate.action" method="post">
        <input id="id" name="id" type="hidden">
        <input id="flag" name="flag" type="hidden">
      <table style="width:280px;margin-top: 30px; ">
      	 <tr >
      	 <td align="right">学号：</td>
      	 <td><input readonly="readonly" type="text" id="userid" name="userid" style="width: 150px" class="easyui-validatebox"></td>
      	 </tr>
      	 <tr >
      	 <td align="right">用户名：</td>
      	 <td><input type="text" id="name" name="name" style="width: 150px" class="easyui-validatebox"></td>
      	 </tr>      	 
      	 <tr>
      	 <td align="right">密码：</td>
      	 <td><input id="eqpwd" type="password" name="password"  style="width: 150px" class="easyui-validatebox" required="true"></td>
      	 </tr>
      	 <tr id="checkPwd">
      	 <td align="right">重复密码：</td>
      	 <td><input id="password" type="password" name="userpwd1"  style="width: 150px" class="easyui-validatebox" validType="eqpwd['#eqpwd']"></td>
      	 </tr>
      </table>
     </form> 
      <div style="margin-top: 20px ;margin-left: 80px;">
	<a id="submit1" href="javascript:void(0);" class="easyui-linkbutton">修改</a>
	<a id="loginin" href="javascript:void(0);" class="easyui-linkbutton">取消</a>
       </div>
  </div>
  </body>
</html>
