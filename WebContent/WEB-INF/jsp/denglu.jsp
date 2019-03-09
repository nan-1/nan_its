<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	String contextpath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进入</title>
<script type="text/javascript"
	src="<%=contextpath%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=contextpath%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=contextpath%>/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="<%=contextpath%>/js/denglu.js"></script>
<link rel="stylesheet" href="<%=contextpath%>/css/blackeasyui.css"
	type="text/css">
	<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" href="<%=contextpath%>/css/icon.css"
	type="text/css">
	<link rel="shortcut icon" href="#" />
<script type="text/javascript">

</script>
</head>
<body>
	<div>
	<form id="ff" action="<%=contextpath%>/ccc/modelonly" method="post"
		onSubmit="return denglu()">
		用户名：<input type="text" id="dengluname" name="dengluname" placeholder="请输入用户名">
		<span id="yhmti">${text }</span></br>
		密&emsp;码：<input type="password" id="denglupwd" name="denglupwd">
		<p id="mmti"></p>
		<input type="submit" class="easyui-linkbutton" id="denglu" name="denglu" value="登录">
		<input type="reset" calss="easyui-reset" id="chongzhi" name="chongzhi" value="重置">
	</form>
<!-- 	<input type="button" value="注册"> -->
	<div style="margin: 20px 0;">
		<a class="easyui-linkbutton" id="tianjia" onclick="tianjia()">注册</a>
	</div>
	</div>
	<div id="w" class="easyui-dialog"
		data-options="closed:true"
		>
		<form id="fff"  method="post" >
			用户名：&emsp;<input class="easyui-textbox" type="text" id="zhucename"
				name="zhucename" data-options="required:true,validType:['zhucenameyz','zhucenameweikong','zhucenameexist'],missingMessage:'请输入用户名'" ><span
				id="yhmyanzheng"></span></br>
<!-- 				<input class="easyui-textbox" id="loginName" type="text" name="loginName" data-options="iconCls:'icon-man',required:true,validType:['loginName','username_isExist'],missingMessage:'请输入用户名'"/> -->
				 密&emsp;&emsp;码：<input
				class="easyui-textbox" type="password" id="zhucepwd" name="zhucepwd"
				data-options="required:true" missingMessage="请输入"></br> 确认密码：<input
				class="easyui-textbox" type="password" id="qrpwd" name="qrpwd"
				data-options="required:true" validType="equals['#zhucepwd']"></br> 身份证号：<input type="text"
				id="zjhm" name="zjhm"></br> 
<!-- 				<a class="easyui-linkbutton" id="zhuce"  -->
<!-- 				name="zhuce"  onclick="zhuce()">提交</a> -->
		</form>
	</div>
	${contextpath }
</body>
</html>