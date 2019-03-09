<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath();%>
<%@ page import="shitilei.YhVo" %>
<%YhVo yhvo=(YhVo)request.getAttribute("yhvo");%>
<%    String yhid="aaa";
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>no title</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div class="window-shadow"  style="position:fixed; left:40%;right:40%;top:30%;margin: 0 auto">
<div>想成为万众瞩目、无与伦比、傲视群雄、强者恒强、欧阳白雪、曲高和寡、鹤立鸡群，引领潮流的VIP吗？
			<div>
			<a class="panel-title" style="margin-left:10%;">算了，洗洗睡吧</a>
<%-- 			<%yhid=yhvo.getYhid(); %> --%>
			<a class="panel-title" style="margin-left:30%;" onclick="jiaruvip('<%=yhvo%>')">立刻加入</a>
			</div>
			</div>
</div>

			
<script type="text/javascript" src="<%=path %>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/renshengdianfeng.js"></script>
<link rel="stylesheet" href="<%=path %>/css/xuanku.css" type="text/css">
<script type="text/javascript">
</script>
<style type="text/css">
</style>

</body>
</html>