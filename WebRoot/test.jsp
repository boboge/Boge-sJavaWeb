<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/uploads/common/js/jquery-1.7.min.js"></script>
<style>
#listover {margin:160px;border:1px solid #ccc;width:225px;}
.over { background-color:#2dfeff;}
li {width:210px;list-style: none;height:22px;padding:2px 0 2px 8px;}
</style>
<title>基于jQuery简单实例：鼠标经过文字背景变色效果</title>
</head>
<body>
<ul id="listover">
<li>这是第一行，烈火网特效代码</li>
<li>这是第二行，烈火网特效代码</li>
<li>这是第三行，烈火网特效代码</li>
<li>这是第四行，烈火网特效代码</li>
<li>这是第五行，烈火网特效代码</li>
<li>这是第六行，烈火网特效代码</li>
</ul>
<script>
$(function(){
$("#listover li").hover(function(){
$(this).addClass("over");
},function(){
$(this).removeClass("over");
})
})
</script>
</body>
</html>
