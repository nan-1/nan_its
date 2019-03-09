var a=true;
$.extend($.fn.validatebox.defaults.rules, {//这里要写在最上边
//	zhucenameyz : {// 验证用户名输入
//		validator : function(value){
//			return /^[A-Za-z]+$/i.test(value);
//		},
//		message : '请输入英文'
//	},
	zhucenameyz : {// 验证用户名输入
		validator : function(value){
			return /^[a-zA-Z0-9_ ]{1,}$/.test(value);
		},
		message : '只能输入英文、数字、下划线、空格'
	},
	//验证用户名是否为空
//	zhucenameweikong:{
//		validator : function(value){
//			return /^[A-Za-z]+$/i.test(value);
//		},
//		message: '请输入用户名'
//	},
//验证两次密码输入
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
//注册弹窗
function tianjia(){
	$('#w').dialog('open');
	$('#fff').form('clear');//每次打开dialog清空form列表；另外的方式是关闭的时候刷新页面location.reload();
}
//页面加载完成之后创建注册的dialog
	$(function(){
$("#w").dialog({
	title:'注册',
	width: 500,   
    height: 200,
    padding:10,
//    closable: true,//false设置dialog不允许被关闭
    cache: false,
    modal: true,
    buttons:[
             {
            	 text:'注册',
            	 iconCls: 'icon-ok',
            	 width:70,
            	 height:30,
            	 handler:function(){
            		 zhuce();//处理用户注册
            	 }
             },
             {
            	 text:'重置',
            	 iconCls: 'icon-reload',
            	 width:70,
            	 height:30,
            	 handler:function(){
            		 chongzhi();//重置输入框
            	 }
             }
             ]
})
})
//注册:easyui的ajax异步方式
//function zhuce() {
//		if($("#fff").form('validate')){
//		$("#fff").form('submit',{
//			url:"./ccc/zhuce",
//			success:function(data){
//				if(data.xinxi=="wanshi"){
//					$.messager.show({
//						title:"tishi",
//						msg : data.xinxi
//					})
//				}
//				$("#w").dialog('close');
//				$.messager.show({
//					title:"提示",
//				msg : '注册成功'
//			})
//			}
//		})
//			}else{
//				$.messager.show({
//					title:"提示",
//				msg : '请按要求输入'
//			})
//			}
//		}
//注册正常ajax方式
function zhuce() {
		if($("#fff").form('validate')){
		var name =$("#zhucename").val();
		var pwd =$("#zhucepwd").val();
		var zjhm=$("#zjhm").val();
		var obj=$("#fff").serializeArray();
		console.log(obj);
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
				$("#w").dialog('close');
				$.messager.show({
					title:"提示",
				msg : '注册成功'
			})
//                $.modalDialog.handler = undefined;
			}
		})
			}else{
				$.messager.show({
					title:"提示",
				msg : '请按要求输入'
			})
			}
		}
function chongzhi(){
		$("#fff").form('clear');
}
/*重置form表单*/
//56               function doReset(formId){
//57                   $(':input','#'+formId)
//58                    .not(':button, :submit, :reset, :hidden')
//59                    .val('')
//60                    .removeAttr('checked')
//61                    .removeAttr('selected');
//62               }

	// 表单validatebox验证
//表单提交时验证
//$("#fff").form({
//	url:"./ccc/zhuce",
//	onSubmit:function(){
//		return (this).form('validate');
//	},
//	success:function(data){
//		$.messager.alert('操作提示', '操作提示未通过', 'info');
//	}
//})

//
//$("#zhuce").click(function(){
//	var name=$("#zhucename").val();
//	var pwd=$("#zhucepwd").val();
//	var zjhm=$("#zjhm").val();
//	console.log(name);
//if($("#fff").form('validate')){
//	$.ajax({
//		type:"post",
//		url:"./ccc/zhuce",
//		data:{"name":name,"pwd":pwd,"zjhm":zjhm},
//		contextType:"application/json; charset=utf-8",
//		dataType:"json",
//		success: function(data){
//			if(data.xinxi=="wanshi"){
//				$.messager.show({
//					title:"tishi",
//					msg : data.xinxi
//				})
////				$.modalDialog.handler.dialog('destroy');
////                $.modalDialog.handler = undefined;
//			}else{
//				$.messager.show({
//					title:"tishi",
//					msg : data.xinxi
//				})
//			}
//		}
//	})
//}
//else{
//	alert("存在校验项未通过！");
////	parent.$.messager.alert('操作提示','存在校验项未通过！',"warning");
//}
//})

$().ready(function(){
		$("#name").focus(function(){
		    $("#name").css("background-color","#FFFFCC");
	})
})
//	$().ready(function() {
//		$("#zhucename").blur(function() {
//			yhmyanzheng();
//		})
//			function yhmyanzheng(){				
//	alert("aa");
//			var name = $("#zhucename").val();
//			$.ajax({
//				type : "post",
//				url : "./ccc/woajax",
//				data : {
//					"name" : name
//				},
//				dataType : "json",
//				contextType : "application/json; charset=utf-8",
//				success : function(data) {
//					console.log(typeof data);
//					if (data) {
//						alert("lailalaodi");
//						if (data.yanzheng == "had") {
//							$("#yhmyanzheng").html("用户已经注册过");
//						}
//					} else {
//						alert("no");
//					}
//				}
//			})
//		
//	}
//	})
//登录判断
	function denglu() {
		var name = document.getElementById("dengluname").value;
		var pwd = document.getElementById("denglupwd").value;
		alert(name);
		if (name == "") {
			//$("#yhmti").html("用户名不能为空");
			alert("用户名不能为空");
			return false;
		}
		if (pwd == "") {
			alert("密码不能为空");
			//$("#mmti").html("密码不能为空");
			return false;
		}
		
		return true;
		//window.location.href="<%=path%>/jsp/show.jsp";
		//window.open("<%=path%>/jsp/show.jsp"); //打开新窗口
	}
	//重置
	$(function(){
		$("#chongzhi").click(function(){
			$("#name").val("");
			$("#pwd").val("");
		})
	})
