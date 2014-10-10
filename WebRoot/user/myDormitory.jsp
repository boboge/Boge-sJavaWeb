<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myDormitory.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
$(function(){
			$.ajax({
				type : 'POST',
				url : 'dormitoryAction!getInfo.action',
				cache : false,
				dataType : 'json',
				success : function(result) {
					$("#dname").val(result.dormitory.dname);
					$("#dnumber").val(result.dormitory.dnumber);
					$("#id").val(result.dormitory.id);
					$("#userid").val(result.dormitory.userid);		
				}
			});

  });
  
</script>
  </head>
  
  <body>
  <form action="dormitoryAction!addOrUpdate.action" method="post">
  <input id="id" name="id" type="hidden">
  <input id="userid" name="userid" type="hidden">
   寝室名：<input id="dname" name="dname" type="text">
   寝室号：<input id="dnumber" name="dnumber" type="text">
 <input type="submit" value="保存">
 </form>
  <br>
  </body>
</html>
