<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script><!--
	$(function() {
	   /*登陆弹出框*/
		$('#login').dialog({
			closed : false,
			modal : true,
			closable:false
		});
		/*登陆验证*/
		$('#loginin').bind('click', function() {
		if($('#loginform').form('validate')){
			$.ajax({
				type : "POST",
				url : "loginAction!login.action",
				cache : false,
				dataType : 'json',
				data : $('#loginform').serialize(),
				success : function(result) {
					if (result.msg == 0) {
						$.messager.show({
							title : '提示',
							msg : '用户名或密码错误',
						});
					}else if(result.msg == 1){
					$.messager.show({
							title : '提示',
							msg : '登陆成功,正在跳转',
						});
						window.setTimeout("location.href='user/main.jsp'",1000);
						
					}else if(result.msg == 2){
					$.messager.show({
							title : '提示',
							msg : '登陆成功(维修员),正在跳转',
						});
						window.setTimeout("location.href='admin/main.jsp'",1000);
						
					}else if(result.msg == 3){
					$.messager.show({
							title : '提示',
							msg : '登陆成功(管理员),正在跳转',
						});
						window.setTimeout("location.href='manage/main.jsp'",1000);
						
					}		
				}
			});
			}
		});
		
		/*
		$('#regist').bind('click', function() {
		 $('#checkPwd').css({display:""});
		 $('#submit').css({display:""});
		});
		注册验证*/
     $('#submit').bind('click', function() {
		if($('#loginform').form('validate')){
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

--></script>
</head>
  
  <body>
    <div style="position: absolute; left: 10px; top: 50px; ">
  <img src="<%=basePath%>img/33.jpg"></img></div>
  <div style="position: absolute; right: 60px; top: 5px; ">
  <img src="<%=basePath%>img/xybs_05.jpg" width="170px" height="170px"></img></div>
  <div id="login" class="easyui-dialog" title="登陆" style="width:300px;height:200px;">
  <form id="loginform">
      <table style="width:280px;margin-top: 30px	">
      	 <tr >
      	 <td align="right">账号：</td>
      	 <td><input type="text" name="name" style="width: 150px" class="easyui-validatebox" required="true"></td>
      	 </tr>
      	 <tr>
      	 <td align="right">密码：</td>
      	 <td><input id="eqpwd" type="password" name="password"  style="width: 150px" class="easyui-validatebox" required="true"  ></td>
      	 </tr>
      	 <tr id="checkPwd" style="display:none">
      	 <td align="right">重复密码：</td>
      	 <td><input type="password" name="userpwd1"  style="width: 150px" class="easyui-validatebox" validType="eqpwd['#eqpwd']"></td>
      	 </tr>
      	 
      </table>
     </form> 
      <div id="bb" style="margin-top: 20px ;" align="center">
	<a id="loginin" href="#" class="easyui-linkbutton">登陆</a>
	<a id="regist" href="#" class="easyui-linkbutton">取消</a>
	<a id="submit" href="#" class="easyui-linkbutton" style="display: none;">提交</a>
</div>
      
      </div>
  </body>
</html>
