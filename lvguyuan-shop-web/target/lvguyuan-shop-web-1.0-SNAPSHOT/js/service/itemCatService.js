app.service('itemCatService',function($http){



    //查询父类列表
    this.findByParentId = function(parentId){
        return $http.get('/itemCat/findByParentId.do?parentId='+parentId);
    }

    //查询单个
    this.findOne = function(id){
        return $http.get('/itemCat/findOne.do?id='+id);
    }



});