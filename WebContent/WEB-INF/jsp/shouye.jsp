<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进入</title>
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/shouye.js"></script>
	<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=path%>/css/blackeasyui.css"
	type="text/css">
	<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" href="<%=path%>/css/icon.css"
	type="text/css">
	<link rel="shortcut icon" href="#" />
<script type="text/javascript">

</script>
</head>
<body>
	<div id="keyidong" class="dd-demo" style="position: absolute;z-index:9999">
	<img alt="" src="./css/images/a4f51f087bf40ad1c21d42275d2c11dfabecce8c.gif" width=300px height=150px>
	</div>
	<div style="margin:20px 0;">
	</div>
<!-- 	<input class="easyui-searchbox" data-options="prompt:'输入用户名',menu:'#search',searcher:doSearch" style="width:300px"></input> -->
	<div id="divg">
	<div id="tb">
	<span>用户名：</span>
	<input id="yhmsearch" class="easyui-textbox" data-options="prompt:'输入用户名'" style="width:300px">
	<input class="easyui-linkbutton" type="button" onclick="yhmsearch()" value="查询"></br>
	<input class="easyui-linkbutton"  type="button" onclick="add()" value="+添加">
	<input class="easyui-linkbutton" type="button" onclick="shanchuyh()" value="-删除">
	</div>
<!-- 	列表 -->
	<table id="ttg" toolbar="#tb">
	</table>
	</div>
	<div id="tianjiadg" class="easyui-dialog" data-options="closed:true"
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
		</form>
	</div>
<!-- 	tmd原来validtype影响datagrid传值 -->
	<div id="xiugaidg" class="easyui-dialog" data-options="closed:true"
		>
		<form id="xiugaif"  method="post" >
			用户名：&emsp;<input  type="text" id="xiugainame"
				name="xiugainame" data-options="required:true,validType:['zhucenameyz','zhucenameweikong','zhucenameexist'],missingMessage:'请输入用户名'" ><span
				id="yhmyanzheng"></span></br>
<!-- 				<input class="easyui-textbox" id="loginName" type="text" name="loginName" data-options="iconCls:'icon-man',required:true,validType:['loginName','username_isExist'],missingMessage:'请输入用户名'"/> -->
				 密&emsp;&emsp;码：<input
				 type="text" id="xiugaipwd" name="xiugaipwd"
				data-options="required:true" missingMessage="请输入"></br> 
				 身份证号：<input type="text"
				id="xiugaizjhm" name="xiugaizjhm"></br> 
				<input type="hidden" id="id">
		</form>
	</div>
	${map }</br>
	<p>${str }</p>
</body>
</html>