$(function(){
	$("#tongjitable").datagrid({
		title:'注册统计（月份）',
		url:'../tongji/zhuce',
		pagination:true,
		rownumbers:true,
		pageSize:10,
		pageList:[ 10, 15, 20 ],
		method:'post',
		pageNumber:1,//行数改变，初始化至第一页
		loadFilter:pagerFilter,//启用前台分页方法
		idField : 'zhucedate',
		columns:[
		         [
		          {
		        	  field:'zhucedate',
		        	  title:'注册月份',
		        	  width:200,
		        	  align:'center'
		          },
		          {
		        	  field:'nums',
		        	  title:'数量',
		        	  width:200,
		        	  align:'center'
		          }
		          ]]
	
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