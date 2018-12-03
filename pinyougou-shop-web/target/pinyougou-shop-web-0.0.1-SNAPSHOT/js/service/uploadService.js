app.service('uploadService',function($http){
	//上传文件
	this.uploadFile=function(){
		var formdata=new FormData();//Formdata对象是HTML5的类，代表表单数据（二进制）
		formdata.append('file',file.files[0]);//file  文件上传框的name
		return $http({
			url:'../upload.do',
			method:'POST',
			data:formdata,//上传文件
			headers:{'Content-type':undefined},//上传文件必须指定类型，默认类型是json格式
			transformRequest:angular.identity //对表单进行二进制的序列化（angular提供）
		});
	}
	
});