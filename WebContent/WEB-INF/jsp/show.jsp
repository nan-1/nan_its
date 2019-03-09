<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
    <%@ page import="java.util.*" %>
    <%@ page import="shitilei.YhVo" %>
<%YhVo yhvo=(YhVo)request.getAttribute("yhvo");%>
<%    String yhid="aaa";
    %>
    <%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./css/xuanku.css" type="text/css">
<script type="text/javascript" src="<%=path %>/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

</script>
<title>Insert title here</title>
<style type="text/css">
div {
				color: blueviolet;
				text-align: center;
/* 				font-size: 20px; */
				margin-top:50px;
				margin-left: 350px;
			}
#one {
				border: dashed;
				background: gold;
				color: saddlebrown;
			}
			
			#two {
/* 				border: double; */
				color: red;
				background: green;
			}
			div ul li:hover div {
				color: white;
				display: block;
			}
			
			div ul li div {
				display: none;
			}
			div li:hover div {
				color: red;
				display: block;
			}
			
			div li div {
				display: none;
			}
#aaa {
/* 				border: dashed; */
/* 				background: gold; */
/* 				color: saddlebrown; */
			margin-left: 290px;
			}
body{
				background-image:url("<%=path%>/css/images/a69337f3jw1ewbcfr4il3g20b4069x6p.gif");
			}
</style>
</head>
<body>
<%-- <c:forEach>

</c:forEach> --%>
<%
//             List<String> list = (List<String>)request.getAttribute("list");

//             for(String str : list)
//             {
        %>
<%--             <p>循环数 ： <%=str%></p> --%>
        <%
//             }
        %>
<div id="keyidong" class="dd-demo" style="position: absolute;z-index:9999;margin-left: 0px;margin-top: 50px;">
	<img alt="" src="<%=path %>/css/images/aoooo.gif" width=200px height=100px id="imp3" >
	</div>
<div id="keyidong" class="dd-demo" style="position: absolute;z-index:9999;margin-left: 0px;margin-top: 250px;">
	<img alt="" src="<%=path %>/css/images/a4f51f087bf40ad1c21d42275d2c11dfabecce8c.gif" width=200px height=100px>
	</div>
<div id="one">
			<li ><a href="">阴吹思婷</a>
			<div>
						小朋友就知道你要点开看</div></li>

		</div>
		<div id="two" >
			<div>
				叶子，是不会飞翔的翅膀
			</div>
			<ul>
<!-- 				<li> -->
					给我一个理由忘记
					<div>
						我就想一个哑巴一样，反正我也不擅长抵抗</div>					
<!-- 				</li> -->
			</ul>
			</div>
			<h1 style="color:rgba(0,0,0,0)">我明知道你走的太早</h1>
			<div id="aaa" >
			<div>
			<h1 style="color:rgba(0,0,0,0)">被你发现了</h1>				
			</div>
			<ul>
				<li>
					<h1 style="color:rgba(0,0,0,0)">你这臭不要脸的</h1>	
					<div>
						<a href="http://www.99a10.com">给你，拿去</a>
						</div>					
				</li>
			</ul>
			</div>
						
</body>
</html>