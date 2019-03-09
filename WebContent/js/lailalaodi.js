//$(function(){
//	
//})

var nowshow=1
			function lunhuan(index){
				if(Number(index)){
					
					//当鼠标点击触发
					clearTimeout(sid);
					nowshow=index;
				}
				for(var i=1;i<4;i++){
					//只显示当前
					if(i==nowshow){
						document.getElementById("imp"+nowshow).style.display=""
					}else{
						document.getElementById("imp"+i).style.display="none"
					}
				}
				if(nowshow==3)
					nowshow=1
				else
					nowshow++;
				
				sid=setTimeout('lunhuan()',5000);
			}
function tianjiatab(title,url){
	if ($('#centertab').tabs('exists', title)){
		$('#centertab').tabs('select', title);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		$('#centertab').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
}

function jiaruvip(yhid){
	var yhid=yhid;
	$.ajax({
		type:"post",
		url:"../ccc/jiaruvip",
		data:{"yhid":yhid},
		contextType : "application/json; charset=utf-8",
		dataType:"json",
		success:function(data){
			if(data){
				if(data.shenmeqingkuang=="no"){
					console.log(data.shenmeqingkuang);
//					a=false;
//					console.log(a);
				}
				else{
					console.log("ok");
					
					window.parent.location.href='http://localhost:8080/nan_its/';
//					a=true;
				}
			}
		}
	});
}

function haishiyaojiaruvip(yhid){
	alert("不行，上了贼船还想跑，休想！！");
	$.ajax({
		type:"post",
		url:"../ccc/jiaruvip",
		data:{"yhid":yhid},
		contextType : "application/json; charset=utf-8",
		dataType:"json",
		success:function(data){
			if(data){
				if(data.shenmeqingkuang=="no"){
					console.log(data.shenmeqingkuang);
				}
				else{
					console.log("ok");
					alert("已加入");
					window.parent.location.href='http://localhost:8080/nan_its/';
				}
			}
		}
	});
}