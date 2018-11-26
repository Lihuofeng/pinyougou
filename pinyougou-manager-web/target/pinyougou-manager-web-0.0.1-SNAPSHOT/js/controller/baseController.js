app.controller('baseController',function($scope){
	//分页控件配置 currentPage：当前页码，totalItems：总记录数，itemsPerPage：每页的记录数，perPageOptions：分页选项,onChange：当页面变更后自动触发的方法
	$scope.paginationConf = {
		 currentPage: 1,
		 totalItems: 10,
		 itemsPerPage: 10,
		 perPageOptions: [10, 20, 30, 40, 50],
		 onChange: function(){
        	 $scope.reloadList();//重新加载
 		}
	}; 

	
	//刷新列表
	$scope.reloadList=function(){
		//切换页码 
		$scope.search($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
	}
	
	 //用户勾选的ID集合 
	$scope.selectIds=[];
	//用户勾选复选
	 $scope.updateSelection=function($event,id){
		//$event.target :$event不是代表input，是源，通过$event.target获取input
		if($event.target.checked){
			$scope.selectIds.push(id); //.push向集合中添加元素
		}else{
			var index =$scope.selectIds.indexOf(id); //查找值的位置
			$scope.selectIds.splice(index,1);//从$scope.selectIds移除,index:移除的位置，1：移除的个数
		}
	} 
	
});