var a=true;
$.extend($.fn.validatebox.defaults.rules, {//这里要写在最上边
	// 验证用户名输入
	zhucenameyz : {
		validator : function(value){
			return /^[a-zA-Z0-9_ ]{1,}$/.test(value);
		},
		message : '只能输入英文、数字、下划线、空格'
	},
//验证两次密码输入一致
	    equals: {
	        validator: function(value,param){
	            return value == $(param[0]).val();
	        },
	        message: '密码不一致！'
	    },
	//验证用户名是否存在
	zhucenameexist:{
		validator : function(value){
			$.ajax({
				type:"post",
				url:"./ccc/ajaxyhmyanzheng",
				data:{"zhucename":value},
				contextType : "application/json; charset=utf-8",
				dataType:"json",
				success:function(data){
					if(data){
						if(data.yanzheng=="had"){
						  $("#yhmyanzheng").html("用户已经注册过");
							console.log(data.yanzheng);
							a=false;
//							console.log(a);
						}
						else{
						  $("#yhmyanzheng").html("用户名可以使用");
							console.log("meiiyou");
							a=true;
						}
					}
				}
			});
			console.log(a);
			return a;
		},
		message: '用户名已存在'
	}
})

//表格
$(function() {
	$("#ttg")
			.datagrid(
					{
						title : '用户列表',
						url : './ccc/liebiao',
						method : 'post',
						loadmsg : '骚等',
						pagination : true,// 设置true将在数据表格底部显示分页工具栏。
						rownumbers : true,// 设置为true将显示行数。
						pagesize : 10,
						pageList : [ 10, 15, 20 ],
						pageNumber:1,//行数改变，初始化至第一页
						loadFilter:pagerFilter,//启用前台分页方法
//						queryParams : {name:$("yhmsearch").val()},// 当请求远程数据时，发送的额外参数。至今还没用到过。。
//						sortName:'zjhm',
						idField : 'id',
						columns : [ [
								{
									field : 'id',
									title : '你就是我的唯一',
									width : 220,
									align : 'center',
									sortable : true
								},
								{
									field : 'name',
									title : '用户名',
									width : 120,
									align : 'center',
									sortable : false
								},
								{
									field : 'pwd',
									title : '密码',
									width : 120,
									align : 'center',
									sortable : false
								},
								{
									field : 'zjhm',
									title : '证件号码',
									width : 120,
									align : 'center',
									sortable : true
								},
								{
									field : 'zhucedate',
									title : '注册时间',
									width : 120,
									align : 'center',
									sortable : true
								},
								{
									field : 'opt',
									title : '操作',
									width : 120,
									align : 'center',
									formatter : function(value, row, index) {//value：当前列对应字段值。row：当前的行记录数据。index：当前的行下标。
//										alert(index);
										var btn = '<input type="button" id='
												+ index
												+ ' value="编辑" onclick="return xiugaiYh('+ index +')"/>';
										return btn;
									}
								}
//								{
//									field : 'opt',
//									title : '操作',
//									width : 120,
//									align : 'center',
//									editor:{//行内编辑
//										type:'text',
//										opentions:{
//											
//										}
//									}
//								}
								] ],
//						toolbar : [
//								{
//									id:'add',
//									text:'添加',
//									iconcls:'icon-add',
//									handler:function(){
//									add();	
//									}
//								},
//								{
//									id:'del',
//									text : '删除',
//									iconcls : 'icon-remove',
//									handler : function() {
//										var rows = $("#ttg").datagrid('getSelections');// 获得所有选中行；
////											datagrid.datagrid('getSelections');//全局定义datagrid时
//										var ids = [];
//										for (i = 0; i < rows.length; i++) {
//											ids.push(rows[i].name);//选中了哪些行
//										}
//										console.info(ids.join(','));
//										if(rows.length>1){
//											$.messager.alert('提示', '不支持批量删除,请单选',
//											'error');
//										} 
//										else if (rows.length <= 0) {
//											$.messager.alert('提示', '请点击选择要删除的数据',
//											'error');
//										} else {
//											console.log(rows.name);
//											$.messager
//											.confirm(
//													'请确认',
//													'您确定要删除当前选择的所有项吗？',
//													function(b) {
//														if (b) {// 选择“确定”
//															var ids = [];
//															for (i = 0; i < rows.length; i++) {
//																ids.push(rows[i].name);// 更改了
//															}
//															console.info(ids.join(','));// 方便调试
//															$.ajax({
//																		url : './ccc/shanchuyh',
//																		data : {
//																			ids : ids.join(',')// 规定要发送到服务器的数据。
//																		},
//																		dataType : 'json',// 预期响应的数据类型。
//																		success : function(
//																				rsp) {
//																			if (rsp.mess == "success") {
//																				$("#ttg").datagrid('reload');
//																				$("#ttg").datagrid('unselectAll');
//																				$.messager
//																						.show({
//																							title : '提示',
//																							msg : '删除成功'
//																						});
//																			} else {
//																				$.messager
//																						.confirm(
//																								"提示",
//																								"删除失败，请重试！");
//																			}
//																		}
//																	});//利用AJAX改变页面
//														} else {// 选择“取消”
//															$("#ttg").datagrid('unselectAll');
//														}
//													});
//										}
//									}
//								},
//								'-', {  
//						            text: document.getElementById('yhmsearch').innerHTML,
//						        }
//								],
					})
})
//分页功能    
            function pagerFilter(data) {
                if (typeof data.length == 'number' && typeof data.splice == 'function') {
                    data = {
                        total: data.length,
                        rows: data
                    }
                }
                var dg = $(this);
                var opts = dg.datagrid('options');//取得分页属性对象
                var pager = dg.datagrid('getPager');//取得页面对象
                pager.pagination({
                    onSelectPage: function (pageNum, pageSize) {
                        opts.pageNumber = pageNum;
                        opts.pageSize = pageSize;
//                        alert('pageNumber:'+pageNum+',pageSize:'+pageSize);
                        pager.pagination('refresh', {
                            pageNumber: pageNum,
                            pageSize: pageSize
                        });
                        dg.datagrid('loadData', data);
                    }
                });
                if (!data.originalRows) {
                    if(data.rows)
                        data.originalRows = (data.rows);
                    else if(data.data && data.data.rows)
                        data.originalRows = (data.data.rows);
                    else
                        data.originalRows = [];
                }
                var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
                var end = start + parseInt(opts.pageSize);
                data.rows = (data.originalRows.slice(start, end));
                return data;
            }

function add(){
	$('#tianjiadg').dialog('open');
}
//添加弹窗
$(function(){
	$("#tianjiadg").dialog({
		title:'添加用户',
		width: 500,   
	    height: 200,
	    padding:10,
		buttons:[
		         {
		        	 text:'注册',
		        	 iconCls: 'icon-ok',
	            	 width:70,
	            	 height:30,
	            	 handler:function(){
	            		 tianjiayh();
//	            		$("#ttg").datagrid("reload"); 
	            	 }
	            	 },
		         {
		        	 text:'取消',
		        	 iconCls: 'icon-cancel',
	            	 width:70,
	            	 height:30,
	            	 handler:function(){
	            		 quxiaotianjia();
	            	 }
	            	 }
		         ]
	})
})
//删除
function shanchuyh(){
	var rows = $("#ttg").datagrid('getSelections');// 获得所有选中行；
//	datagrid.datagrid('getSelections');//全局定义datagrid时
var ids = [];
for (i = 0; i < rows.length; i++) {
	ids.push(rows[i].name);//选中了哪些行
}
console.info(ids.join(','));
if(rows.length>1){
	$.messager.alert('提示', '不支持批量删除,请单选',
	'error');
} 
else if (rows.length <= 0) {
	$.messager.alert('提示', '请点击选择要删除的数据',
	'error');
} else {
	console.log(rows.name);
	$.messager
	.confirm(
			'请确认',
			'您确定要删除当前选择的所有项吗？',
			function(b) {
				if (b) {// 选择“确定”
					var ids = [];
					for (i = 0; i < rows.length; i++) {
						ids.push(rows[i].name);// 更改了
					}
					console.info(ids.join(','));// 方便调试
					$.ajax({
								url : './ccc/shanchuyh',
								data : {
									ids : ids.join(',')// 规定要发送到服务器的数据。
								},
								dataType : 'json',// 预期响应的数据类型。
								success : function(
										rsp) {
									if (rsp.mess == "success") {
										$("#ttg").datagrid('reload');
										$("#ttg").datagrid('unselectAll');
										$.messager
												.show({
													title : '提示',
													msg : '删除成功'
												});
									} else {
										$.messager
												.confirm(
														"提示",
														"删除失败，请重试！");
									}
								}
							});//利用AJAX改变页面
				} else {// 选择“取消”
					$("#ttg").datagrid('unselectAll');
				}
			});
}
}
//修改弹窗
function xiugaiYh(rowindex) {
//	var row = $('#ttg').datagrid('getSelected');//获得选中行
	var rows = $('#ttg').datagrid('getRows');//获得所有行
//	var rows = $('#ttg').datagrid('getData');
//	alert(rows.length);
//	var rowid=rows[rowindex];
	var rrr=rows[rowindex];
	if (rows){
//		alert(' ID:'+row.id+"name:"+row.name);
		var id=rrr.id;
		alert(rrr.name+"+"+id);
		$("#id").val(id);
		$("#xiugainame").val(rrr.name);
		$("#xiugaipwd").val(rrr.pwd);
		$("#xiugaizjhm").val(rrr.zjhm);
		$("#xiugaidg").dialog("open");
	}
}
//修改dialog
$(function(){
	$("#xiugaidg").dialog({
		title:'修改用户',
		width: 500,   
	    height: 200,
	    padding:10,
		buttons:[
		         {
		        	 text:'提交',
		        	 iconCls: 'icon-ok',
	            	 width:70,
	            	 height:30,
	            	 handler:function(){
	            		 xiugai(); 
	            	 }
	            	 },
		         {
		        	 text:'取消',
		        	 iconCls: 'icon-cancel',
	            	 width:70,
	            	 height:30,
	            	 handler:function(){
	            		 quxiaoxiugai();
	            	 }
	            	 }
		         ]
	})
})
//添加用户
function tianjiayh(){
	if($("#fff").form("validate")){
		var name =$("#zhucename").val();
		var pwd =$("#zhucepwd").val();
		var zjhm=$("#zjhm").val();
//		var obj=$("#fff").serializeArray();
//		console.log(obj);
		$.ajax({
			type:"post",
			url:"./ccc/zhuce",
			data:{"name":name,"pwd":pwd,"zjhm":zjhm},
			dataType:"json",
			contextType:"application/json; charset=utf-8",
			success:function(data){
				if(data.xinxi=="wanshi"){
					$.messager.show({
						title:"tishi",
						msg : data.xinxi
					})
				}
				$("#tianjiadg").dialog('close');
				$.messager.show({
					title:"提示",
				msg : '注册成功'
			})
			$("#ttg").datagrid("reload");
			}
			})
	}else{
		$.messager.show({
			title:"提示",
		msg : '请按照要求输入'
	})
	}
	$("#ttg").datagrid("reload");
}
//修改用户提交
function xiugai(){
	var id=$("#id").val();//我ztm是个银柴
	var name=$("#xiugainame").val();
	var pwd=$("#xiugaipwd").val();
	var zjhm=$("#xiugaizjhm").val();
	$.ajax({
		type:"post",
		data:{"id":id,"name":name,"pwd":pwd,"zjhm":zjhm},
		dataType:"json",
		contextType:"application/json; charset=utf-8",
		url:"./ccc/xiugaiyh",
		success:function(data){
			if(data){
				if(data.mess=="ol"){
					$.messager.show({
						title:"提示",
						msg:"修改成功"
					})
					$("#xiugaidg").dialog("close");
					$("#ttg").datagrid("reload");
				}else if(data.mess=="empty"){
					$.messager.show({
						title:"提示",
						msg:"用户名或密码不能为空，修改失败"
					})
				}else if(data.mess=="zazhengdi"){
					$.messager.show({
						title:"提示",
						msg:"修改失败"
					})
				}
			}
		}
	})
}
//查询
function yhmsearch(){
	alert($("#yhmsearch").val());
	$("#ttg").datagrid('reload',{
		name:$("#yhmsearch").val()
	})
}
function doSearch(value){
	alert(value);
}
function quxiaotianjia(){
	$("#fff").form("clear");
	$("#tianjiadg").dialog("close");
//	$(this).dialog("close");
}
function quxiaoxiugai(){
	$("#xiugaif").form("clear");
	$("#xiugaidg").dialog("close");
}
$(function(){	
	$("#keyidong").draggable();
})