<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
  </head>
  
  <body>
  <script type="text/javascript">
		$(function(){

		});
		
		addOrUpdate = function(){		  
			var r = $('#userForm').form('validate');
			if(!r) {
				return false;
			}
				$.ajax({
				type : 'POST',
				url : 'userAction!addOrUpdate.action',
				cache : false,
				dataType : 'json',
				data : $('#userForm').serialize(),
				success : function(result) {
			        $('#MyPopWindow').window('close');
				    $('#datagrid').datagrid('load'); 
					$.messager.show({
							title : '提示',
							msg : result.msg
						});						
				 }
			});
		};
		
		function closeWindow(){
		  $('#MyPopWindow').window('close');		
		};
		
	</script>
	<form id="userForm" method="post" style="margin: 20px;text-align: center;">
	    <input type="hidden" name="flag" value="1">
	    <input type="hidden" name="id">
		学号：<input required="true" type="text" name="userid" id="userid" style="width:200px;" class="easyui-validatebox" ><br>
		姓名：<input required="true" type="text" name="name" style="width:200px;" class="easyui-validatebox" ><br>
		密码：<input type="password" readonly="readonly"  name="password" style="width:200px;"><br>
		<a href="javascript:void(0);" id="btn-back" onclick="closeWindow();" class="easyui-linkbutton" iconCls="icon-back">返回</a>
		<a href="javascript:void(0);" id="btn-add" onclick="addOrUpdate();" class="easyui-linkbutton" iconCls="icon-save">保存</a>
	</form>
  </body>
</html>
