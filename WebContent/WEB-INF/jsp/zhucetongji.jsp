<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>huiyoude</title>
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/zhucetongji.js"></script>
	<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=path%>/css/blackeasyui.css"
	type="text/css">
	<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" href="<%=path%>/css/icon.css"
	type="text/css">
	<link rel="shortcut icon" href="#" />
</head>
<body>
<table id="tongjitable" ></table>
</body>
</html>