<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="shitilei.YhVo" %>
<%@ page import="shitilei.PermissionsVo" %>
<%YhVo yhvo=(YhVo)request.getAttribute("yhvo");
String yhid=yhvo.getYhid();
List permissionsvo=yhvo.getPv();
String permissionsname="";
String rolename="";
for(int i=0;i<permissionsvo.size();i++){
	PermissionsVo pv=(PermissionsVo)permissionsvo.get(i);
	permissionsname += pv.getPermissionsname();
	rolename += pv.getRolename();
}
%>
<% String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>反正可改的</title>
<script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/lailalaodi.js"></script>
<%-- 	<script type="text/javascript" src="<%=path%>/js/lailalaodi.js"></script> --%>
	<script type="text/javascript" src="<%=path%>/js/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="<%=path%>/css/defaulteasyui.css"
	type="text/css">
	<link rel="stylesheet" href="<%=path%>/css/zidingyi.css"
	type="text/css">
	<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" href="<%=path%>/css/icon.css"
	type="text/css">
<!-- 	不知道有什么用，但加了前端控制台不报错。。 -->
	<link rel="shortcut icon" href="#" />
</head>
<body class="easyui-layout" onload="lunhuan()">

<!-- <div style="margin:20px 0;"></div> -->
<!-- 	<div class="easyui-layout" style="width:100%;height:100%"> -->
		<div data-options="region:'north'" style="height:50px"></div>
		<div data-options="region:'south',split:false" style="height:50px;"></div>
<!-- 		<div data-options="region:'east',split:true" title="East" style="width:180px;"> -->
<!-- 			<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true,dnd:true"></ul> -->
<!-- 		</div> -->
		<div data-options="region:'west'" split="true" style="width:20%;"minWidth=20px>
		<div  width=200px height=100px >
					<img alt="" src="<%=path %>/css/images/wangleta.jpg" width=270px height=130px id="imp1" style="display: none;">
					<img alt="" src="<%=path %>/css/images/140167238.jpg" width=270px height=130px id="imp2" style="display: none;">
					<img alt="" src="<%=path %>/css/images/aoooo.gif" width=270px height=130px id="imp3" style="display: none;">
				</div>
		<%if(rolename.indexOf("VIP")!=-1){ %>
			<div class="easyui-accordion" data-options="fit:true,border:false"collapsible="false">
				<div title="WALL·E" style="overflow: auto">
<%-- 					<a class="easyui-linkbutton" onclick="tianjiatab('标题','URL地址')">用户管理</a> --%>
					<%if(permissionsname.indexOf("用户管理")!=-1){ %>
					<span class="spanfun" onclick="tianjiatab('用户管理','<%=path%>/xxxxx/shouye')">用户管理</span>
					<%} %>
					<%if(permissionsname.indexOf("VIP嘿嘿嘿")!=-1){ %>
					<ul class="ulbiankuang" onclick="tianjiatab('にっぽん','<%=path%>/xxxxx/show')">にっぽん</ul>
					<%} %>
				</div>
				<%if(permissionsname.indexOf("注册统计")!=-1){ %>
				<div title="Wow" data-options="selected:true" >
					<span class="spanfun"  onclick="tianjiatab('注册统计','<%=path%>/xxxxx/zhucetongji')">注册统计</span>
				</div>
				<%} %>
				<div title="EVE" data-options="selected:true" >
					<span class="spanfun"  onclick="tianjiatab('只是百度','http://www.baidu.com')">不可描述的页面</span>
				</div>
			</div>
			<%} %>
		<%if(rolename.indexOf("VIP")==-1){ %>
			<div class="easyui-accordion" data-options="fit:true,border:false"collapsible="false">
				<div title="Wow" data-options="selected:true" >
					<span class="spanfun"  onclick="tianjiatab('注册统计','<%=path%>/xxxxx/zhucetongji')">注册统计</span>
				</div>
			</div>
			<%} %>
		</div>
		<div  data-options="region:'center',title:'欠儿',iconCls:'icon-ok'">
			<div id="centertab" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
		<%if(rolename.indexOf("VIP")==-1){ %>
			<div class="window-shadow"  style="position:fixed; left:40%;right:40%;top:30%;margin: 0 auto">
<div>想成为万众瞩目、无与伦比、傲视群雄、强者恒强、欧阳白雪、曲高和寡、鹤立鸡群，引领潮流的VIP吗？
			<div>
			<a class="panel-title" style="margin-left:10%;" onclick="haishiyaojiaruvip('<%=yhid%>')">算了，洗洗睡吧</a>
<%-- 			<%yhid=yhvo.getYhid(); %> --%>
			<input type="button"  style="margin-left:30%;" onclick="jiaruvip('<%=yhid%>')" value="立刻加入">
			</div>
			</div>
</div>
<%} %>
<!-- 			为什么url不行，href可以？ -->
<%-- 			<div title="如何去做，你曾经说我走以后" data-options="href:'<%=path%>/xxxxx/renshengdianfeng'"></div> --%>
<!-- 			data-options="url:'datagrid_data1.json',method:'get',singleSelect:true,fit:true,fitColumns:true"> -->
<!-- 						<thead> -->
<!-- 			<div>想成为万众瞩目、无与伦比、傲视群雄、强者恒强、欧阳白雪。曲高和寡。鹤立鸡群，引领潮流的VIP吗？ -->
<!-- 			<div>洗洗睡吧</div> -->
<!-- 			<div>立刻加入</div> -->
<!-- 			</div> -->
			
			</div>
		</div>
<!-- 	</div> -->
</body>
</html>