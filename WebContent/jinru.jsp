<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%String contextpath=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进入</title>
<script type="text/javascript" src="<%=contextpath %>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=contextpath %>/js/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="<%=contextpath%>/css/easyui.css" type="text/css">
<link rel="stylesheet" href="<%=contextpath%>/css/icon.css" type="text/css">
<script type="text/javascript">
$().ready(function(){
	$("#button").click(function(){
		var name=$("#text").val();		
	})
})
function denglu(){
	var name=document.getElementById("name").value;
	var pwd=document.getElementById("pwd").value;
	if(name==""){
		//$("#yhmti").html("用户名不能为空");
		alert("用户名不能为空");
		return false;
	}
	if(pwd==""){
		alert("密码不能为空");
		//$("#mmti").html("密码不能为空");
		return false;
	}
	return true;
}
function tijiao(){
	var name=document.getElementById("zhucename");
	var pwd=document.getElementById("zhucepwd");
}
</script>
</head>
<body>
<form id="ff"  method="post" onSubmit="return denglu()">
用户名：<input type="text" id="name" name="name" placeholder="请输入用户名"><p id="yhmti"></p>
密&emsp;码：<input type="password" id="pwd" name="pwd"><p id="mmti"></p>
<input type="submit" id="button" name="but" value="登录">
</form>
<input type="button" value="注册">
<div style="margin:20px 0;">
		<a  class="easyui-linkbutton" onclick="$('#w').window('open')">注册</a>		
	</div>
	<div id="w" class="easyui-window" title="注册" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">
		<form id="fff" action="./ccc/zhuce" >
		用户名：&emsp;<input class="easyui-textbox" type="text" id="zhucename" name="zhucename" data-options="required:true" ></br>
		密&emsp;&emsp;码：<input class="easyui-textbox" type="password" id="zhucepwd" name="zhucepwd" data-options="required:true"></br>
		确认密码：<input class="easyui-textbox" type="password" id="qrpwd" name="qrpwd" data-options="required:true"></br>
		身份证号：<input type="text" id="zjhm" name="zjhm"></br>
		<input type="submit" id="zhuce" name="but" onclick="tijiao()"value="提交">
		</form>
	</div>
<table>
<% %>
</table>
${map }<br>
${text }
<p>${list }</p>
</body>
</html>