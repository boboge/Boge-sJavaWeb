<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
  	
  </head>
  
  <body>
  <script type="text/javascript">
		$(function(){		
          $('#nn').numberbox({//数字框
            min:0,
            precision:2
         }); 
		$(".easyui-combobox").combobox({  //下拉框不可编辑
			editable:false   
         });  
		
			//下拉表格初始化
			$('#addDeptId').combobox({
				valueField:'id', //值字段
			    textField:'name', //显示的字段
			    url:'',
			    panelHeight:'auto',
			/*     required:true, */
				editable:false//不可编辑，只能选择
			});
		});
		
		addOrUpdate = function(){		  
			var r = $('#userForm').form('validate');
			if(!r) {
				return false;
			}
				$.ajax({
				type : 'POST',
				url : 'publicpropertyAction!addOrUpdate.action',
				cache : false,
				dataType : 'json',
				data : $('#userForm').serialize(),
				success : function(result) {
			        $('#PubPopWindow').window('close');
				    $('#datagrid').datagrid('load'); 
					$.messager.show({
							title : '提示',
							msg : result.mes
						});						
				}
			});
		};
		
	function closeWindow(){
		 $('#PubPopWindow').window('close');		
		};
		
	</script>
  	<!-- 验证还是jquery-validation好用，这里省事没用 -->
	<form id="userForm" method="post" style="margin: 20px;text-align: center;">
	    <input type="hidden" name="id">
		<input type="hidden" name="userid">
		<input type="hidden" name="dname">
		灯泡&nbsp;&nbsp;&nbsp;&nbsp;：<select data-options="readonly:true" class="easyui-combobox" name="bulb" style="width:200px;"><option value="1" selected>好</option><option value="0" >须修理</option></select><br>
		空调&nbsp;&nbsp;&nbsp;&nbsp;：<select data-options="readonly:true" class="easyui-combobox" name="airconditioning" style="width:200px;"><option value="1" selected>好</option><option value="0" >须修理</option></select><br>
		热水器&nbsp;&nbsp;：<select data-options="readonly:true" class="easyui-combobox" name="waterheater" style="width:200px;"><option value="1" selected>好</option><option value="0">须修理</option></select><br>
		水龙头&nbsp;&nbsp;：<select data-options="readonly:true" class="easyui-combobox" name="faucet" style="width:200px;"><option value="1" selected>好</option><option value="0">须修理</option></select><br>
		插座&nbsp;&nbsp;&nbsp;&nbsp;：<select data-options="readonly:true" class="easyui-combobox" name="outlet" style="width:200px;"><option value="1" selected>好</option><option value="0">须修理</option></select><br>
		厕所&nbsp;&nbsp;&nbsp;&nbsp;：<select data-options="readonly:true" class="easyui-combobox" name="toilet" style="width:200px;"><option value="1" selected>好</option><option value="0">须修理</option></select><br>	
		门锁&nbsp;&nbsp;&nbsp;&nbsp;：<select data-options="readonly:true" class="easyui-combobox" name="loker" style="width:200px;"><option value="1" selected>好</option><option value="0">须修理</option></select><br>	
		晾衣架&nbsp;&nbsp;：<select data-options="readonly:true" class="easyui-combobox" name="clothesrods" style="width:200px;"><option value="1" selected>好</option><option value="0">须修理</option></select><br>	
		处理&nbsp;&nbsp;&nbsp;&nbsp;：<select class="easyui-combobox" name="status" style="width:200px;"><option value="2" selected>处理中</option><option value="3">已处理</option></select><br>	
		报修时间：<input readonly="readonly" name="startdate" style="width: 200px;"  class="easyui-validatebox" ><br>
		处理时间：<input name="enddate" style="width: 200px;" onClick="WdatePicker()"  class="easyui-validatebox" required="true"><br>
		费用&nbsp;&nbsp;&nbsp;&nbsp;：<input name="price" class="easyui-numberbox" style="width: 200px;" id="nn"><br>
		备注&nbsp;&nbsp;：<br>
		<textarea readonly="readonly" name="remark" rows="" cols="5" style="width:200px"></textarea>	
		<br>
		<a href="javascript:void(0);" id="btn-back" onclick="closeWindow();" class="easyui-linkbutton" iconCls="icon-back">返回</a>
		<a href="javascript:void(0);" id="btn-add" onclick="addOrUpdate();" class="easyui-linkbutton" iconCls="icon-save">保存</a>
	</form>
  </body>
</html>
