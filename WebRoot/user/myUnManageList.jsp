<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'center.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="/taglibs.jsp" %>
	
<script type="text/javascript"><!--
var datagrid;

	$(function() {
        SearchForm = $('#userSearch_form').form();
        editRow = undefined;    
		$('#datagrid').datagrid({
			url : 'mypropertyAction!queryAllUn.action',
		/* 	title : 'ccccc',
			iconCls : 'icon-save', */
			singleSelect : true,
		    pagination : 'true',
			pageSize : 5,
			pageList : [ 5, 20, 30 ],
			fit : true,
			fitColumns: true,/*自适应宽  */
			nowrap : false, /*折行显示  */
			border : false,
			idField : 'id',/*主键  */
			sortName : 'enddate',/*初始排序  */
			sortOrder : 'asc',/*排序方式 */
			rownumbers : true,
			columns : [ [ {
				title : '编号',
			//	field : '',
				checkbox : true,
				width : 100
			/* 	editor:{ 编辑状态
				 type:'validatebox',
				 options:{
				  required: true,
				 }
				
				} */
			},{
				title : '学号',
				field : 'userid',
	            sortable : true,
				width : 100
			/* 	editor:{ 编辑状态
				 type:'validatebox',
				 options:{
				  required: true,
				 }
				
				} */
			}, {
				title : '床',
				field : 'bed',
				sortable : true,
				width : 100,
				styler: function(value,row,index){
				 if (value=="1"){
					return 'background-color:#69D34E;';
					}else {
					return 'background-color:#F73F47;';
				} 
					
               },
				formatter:function(value,rowDate,rowIndex){
				  if (value=="1"){
					return '没问题';
				} else {
					return '须修理';
				} 
			 }				

			},{
				title : '桌子',
				field : 'desk',
				sortable : true,
				width : 100,
	            styler: function(value,row,index){
				 if (value=="1"){
					return 'background-color:#69D34E;';
					}else {
					return 'background-color:#F73F47;';
				} 
					
               },
				formatter:function(value,rowDate,rowIndex){
				  if (value=="1"){
					return '没问题';
				} else {
					return '须修理';
				} 
			 }				

			},{
				title : '椅子',
				field : 'chair',
				sortable : true,
				width : 100,
				styler: function(value,row,index){
				 if (value=="1"){
					return 'background-color:#69D34E;';
					}else {
					return 'background-color:#F73F47;';
				} 
					
               },
				formatter:function(value,rowDate,rowIndex){
				  if (value=="1"){
					return '没问题';
				} else {
					return '须修理';
				} 
			 }				

			},{
				title : '柜子',
				field : 'cupboard',
				sortable : true,
				width : 100,
				styler: function(value,row,index){
				 if (value=="1"){
					return 'background-color:#69D34E;';
					}else {
					return 'background-color:#F73F47;';
				} 
					
               },
				formatter:function(value,rowDate,rowIndex){
				  if (value=="1"){
					return '没问题';
				} else {
					return '须修理';
				} 
			 }

			}, {
				title : '提交时间',
				field : 'startdate',
				sortable : true,
				width : 100,
			},{
				title : '状态',
				field : 'status',
				sortable : true,
				width : 100,
				formatter : function(value,rowDate,rowIndex){
				if (value=="1"){
					return '未提交';
				}if (value=="2"){
					return '处理中';
				} else {
					return '处理完毕';
				} 
			}
			
			}, {
				title : '控制',
				field : 'id',
				width : 100,
				formatter : function(value,rowDate,rowIndex){
				return '<button onclick="updaterowInD('+rowIndex+');">编辑</button>';
				}

			}] ],
			toolbar:[{
			text:'增加报修',
			iconCls:'icon-add',
			width:100,
			handler:function(){
            addrow();
			  }
			},'-',{
			text:'修改报修',
			iconCls:'icon-edit',
			width:100,
			handler:function(){
			updaterow();
			  }
			},'-',{
			text:'删除',
			iconCls:'icon-remove',
			width:100,
			handler:function(){  
			deleterow();
			  }			
		  }]
		});
	});
	
  	  function searchform(){/*查询*/
 	  console.info(su.serializeForm(SearchForm));
	$('#datagrid').datagrid('load',su.serializeForm(SearchForm));  
	}; 
	 function cleanform(){/*清空查询*/
	SearchForm.find('input').val(''); 
	$('#datagrid').datagrid('load',{});  
	};
	function addrow(){/*新增*/
	$('#MyPopWindow').window({
  			title:'添加信息',
  			href:'user/addPage.jsp',
  			width:300,
  			height:350,
  			onLoad:function(){
  				$('#userForm').form('load', "");
  			  },
  			onClose: function(){
  				$('#userForm').form('load',"");
  			  }
  			});
	}
		  
  	function deleterow(){/* //删除 */
  		$.messager.confirm('提示','确定要删除吗?',function(result){
	        if (result){
	        	var rows = $('#datagrid').datagrid('getSelections');
	            console.info(rows);
	        	var ps = "";
	        	$.each(rows,function(i,n){
	        		if(i==0) 
	        			ps += "id="+n.id;
	        		else
	        			ps += "&id="+n.id;
	        	});
	        	
	        	$.ajax({
				type : 'POST',
				url : 'mypropertyAction!delete.action',
				cache : false,
				dataType : 'json',
				data : ps,
				success : function(msg) {
				    $('#datagrid').datagrid('reload'); 
					$.messager.show({
							title : '提示',
							msg : msg.mes
						});						
			    	}		
        		});
	        }
	        rows.length=0;/*选中行设为零修复bug  */
	    });
  	}
    function updaterowInD(i){/*  	//更新另一种方法  */
		var row = $('#datagrid').datagrid('getRows');
			$('#MyPopWindow').window({
  			title:'修改信息',
  			href:'user/addPage.jsp',
  			width:300,
  			height:350,
  			onLoad: function(){
  			  			//自动将数据填充到表单中，无需再查询数据库，这里需要注意：
  			//如果用的是struts2，它的表单元素的名称都是user.id这样的，那load的时候不能加.user要.form('load', rows[0]);
  			//而spring mvc中表单元素的名称不带对象前缀，直拉就是id，所以这里load的时候是：.form('load', rows[0].user)
  				$('#userForm').form('load', row[i]);
  			  },
   			onClose: function(){
  				$('#userForm').form('load',"");
  			  }  			  
  			});
	}
    function updaterow(){/*  	//更新  */
     
		var rows = $('#datagrid').datagrid('getSelections');
		//这里有一个jquery easyui datagrid的一个小bug，必须把主键单独列出来，要不然不能多选
		if(rows.length==0){
			$.messager.alert('提示',"请选择你要更新的用户",'info');
			return;
		}
		if(rows.length > 1){
			$.messager.alert('提示',"只能选择一位用户进行更新",'info');
			return;
		}
			$('#MyPopWindow').window({
  			title:'修改信息',
  			href:'user/addPage.jsp',
  			width:300,
  			height:350,
  			onClose: function(){
  				$('#userForm').form('load',"");
  			  },  
  			onLoad: function(){
  			  			//自动将数据填充到表单中，无需再查询数据库，这里需要注意：
  			//如果用的是struts2，它的表单元素的名称都是user.id这样的，那load的时候不能加.user要.form('load', rows[0]);
  			//而spring mvc中表单元素的名称不带对象前缀，直拉就是id，所以这里load的时候是：.form('load', rows[0].user)
  				$('#userForm').form('load', rows[0]);
  			  }
  		
  			});
	}
  	
</script>
  </head>
  
  <body class="easyui-layout" >
  <div id="MyPopWindow" modal="true" shadow="false" minimizable="false" cache="false" maximizable="false" collapsible="false" resizable="false" style="margin: 0px;padding: 0px;"></div>  
      <div region="center" id="center" border="false" >
      <table id="datagrid"></table>
      </div>
  </body>
</html>
