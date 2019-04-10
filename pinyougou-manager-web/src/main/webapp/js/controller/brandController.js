 //品牌控制层 
    	app.controller('brandController',function($scope,$controller,brandService){
    		
    		$controller('baseController',{$scope:$scope});//继承
    		/* $scope.findAll=function(){
    			//$http.get('../brand/findAll.do').success(
    			brandService.findAll().success(
    					function(response){
    						$scope.list =response
    						
    					}	
    			);
    		}  */
    	 	
    		//品牌列表分页
    		$scope.findPage=function(page,size){
    			//$http.get('../brand/findPage.do?page='+page+'&size='+size).success(
    			brandService.findPage(page,size).success(
    				function(response){
    					$scope.list=response.rows;//显示当前页数据
    					$scope.paginationConf.totalItems=response.total;//更新总记录数
    					
    				}		
    			);
    			
    		}
    		
    		//添加品牌或修改品牌
    	 	/* $scope.save=function(){
    			//var methodName='add';//方法名
    			var object=null;//定义对象
    			
    			if($scope.entity.id!=null){
    				//methodName='update'
    				object =brandService.update($scope.entity);
    			}else{
    				object =brandService.add($scope.entity);
    			}
    			//$http.post('../brand/'+methodName+'.do',$scope.entity).success(
    			object.success(
    				function(response){
    					if(response.success){
    						$scope.reloadList();
    					}else{
    						alert(response.message);
    					}
    				}		
    			);
    		} */
    		
    		//修改版，在controller层进行判断
    	 	 $scope.save=function(){
    			//$http.post('../brand/save.do',$scope.entity).success(
    			brandService.save($scope.entity).success(
    				function(response){
    					if(response.success){
    						$scope.reloadList();
    						alert(response.message);
    					}else{
    						alert(response.message);
    					}
    					
    				}		
    			);
    		}  
    		
    		//根据ID查品牌实体
    		$scope.findById=function(id){
    			//$http.get('../brand/findById.do?id='+id).success(
    			brandService.findById(id).success(
    				function(response){
    					$scope.entity=response;
    				}		
    			);
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
    		
    		
    		//删除
    		$scope.dele=function(){
    			//$http.get('../brand/delete.do?ids='+$scope.selectIds).success(
    			brandService.dele($scope.selectIds).success(
    				function(response){
    					if(response.success){
    						$scope.reloadList();
    					}else{
    						alert(response.message);
    					}
    				}		
    			);
    		}
    		 
    		$scope.searchEntity={}; 
    		//条件查询
    		$scope.search=function(page,size){
    			//$http.post('../brand/search.do?page='+page+'&size='+size,$scope.searchEntity).success(
    			brandService.search(page,size,$scope.searchEntity).success(
        				function(response){
        					$scope.list=response.rows;//显示当前页数据
        					$scope.paginationConf.totalItems=response.total;//更新总记录数
        					
        				}		
        			);
    		}
    		
    		
    	});
    		
    		
    	
    	