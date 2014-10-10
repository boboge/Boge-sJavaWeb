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
    
    <title>学生财物管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript">
$(function(){
/* $("li").hover(
  function () {
  	$(this).css("background-color","red");
  },
  function () {
  	$(this).css("background-color","");
  }
); */


$("li").click(function(){
    $("li").css("background-color","");
  	$(this).css("background-color","#F96F75");

});

});


function  addTab(title, url){  /*动态增加tabs */
    if ($('#tabs').tabs('exists', title)){  
        $('#tabs').tabs('select', title);  
    } else {  
        var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';  
        $('#tabs').tabs('add',{  
            title:title,  
            content:content,  
            closable:true  
        });  
    }  
} 
function loginout(){
window.top.location.href="loginAction!loginout.action";

}

</script>
  </head>
  <body class="easyui-layout" id="mainBody">
     <div region="north" style="height:102px;"><img src="<%=basePath%>img/dsa.png"></img>
      <div style="position: absolute; right: 20px; top: 10px; "><img src="<%=basePath%>img/xybs_05.jpg" width="60px" height="60px"></img></div>
    <div style="position: absolute; right: 0px; bottom: 0px; ">
        <span>您好，${sessionScope.username}&nbsp;&nbsp;</span>
   <a href="javascript:void(0);" class="easyui-menubutton" menu="#login_out" iconCls="icon-back">注销</a>
     </div>
<div id="login_out" style="width: 100px; display: none;">
	<div class="menu-sep"></div>
	<div onclick="loginout();">重新登录</div>
	<div onclick="loginout();">退出系统</div>
</div>
    </div>
        <div region="west" split="true" title="菜单" style="width:200px;" >
         <div id="menu" class="easyui-accordion"  fit="true" border="false" >
         <div title="综合管理" style="overflow:hidden;">
        		   <ul>					
						<li style="cursor: pointer;" 
							onclick = "addTab('用户管理','manage/userManage.jsp')">用户管理
						</li>
					</ul>
        		   <ul>
						<li style="cursor: pointer;" 
							onclick = "addTab('报修管理(个人)','manage/PersonManage.jsp')">报修管理(个人)
						</li>        		   					
						<li style="cursor: pointer;" 
							onclick = "addTab('报修管理(寝室)','manage/PubManage.jsp')">报修管理(寝室)
						</li>
					</ul>					
		 </div>
         <div title="个人管理" style="overflow:hidden;">
        		   <ul>					
				<li style="cursor: pointer;" 
					onclick = "addTab('密码修改','user/change.jsp')">密码修改
				</li>
					</ul>					
		 </div>		 
      </div>
    </div><!-- 左边 -->
        
    <div region="south" title="Design by SuperSoft" style="height:50px;"></div>
    <div region="center" title="内容" id="center" >
    <div id="tabs" class="easyui-tabs" fit="true" border="false">  
    <div title="Home">  
    </div>  
    </div> 
    </div>
   
  </body>
</html>
