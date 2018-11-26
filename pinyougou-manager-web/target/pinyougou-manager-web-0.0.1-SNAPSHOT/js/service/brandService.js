//品牌服务层
       app.service('brandService',function($http){
    	   this.findAll=function(){
    		   return $http.get('../brand/findAll.do');
    	   }
    	   
    	   this.findPage=function(page,size){
    		   return $http.get('../brand/findPage.do?page='+page+'&size='+size);
    	   }
    	   
    	   
    	   this.findById=function(id){
    		   return $http.get('../brand/findById.do?id='+id);
    	   }
    	   
    	  /* this.add=function(entity){
    		  return  $http.post('../brand/add.do',entity);
    	   }
    	   
    	   this.update=function(entity){
    		   return $http.post('../brand/update.do',entity);
    	   }*/
    	   
    	   
    	  this.save=function(entity){
    		   return $http.post('../brand/save.do',entity);
    	   } 
    	   
    	   this.dele=function(ids){
    		   return $http.get('../brand/delete.do?ids='+ids);
    	   }
    	   
    	   
    	   this.search=function(page,size,searchEntity){
    		   return $http.post('../brand/search.do?page='+page+'&size='+size,searchEntity);
    	   }
    	   
    	   //品牌下拉列表
    	   this.selectOptionList=function(){
    		   return $http.get('../brand/selectOptionList.do');
    	   }
    	   
       });