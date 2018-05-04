//商品分类服务层
app.service('itemCatService',function($http){
    //查询父类列表
    this.findByParentId = function(parentId){
        return $http.get('/itemCat/findByParentId.do?parentId='+parentId);
    }
    //查询单个
    this.findOne = function(id){
        return $http.get('/itemCat/findOne.do?id='+id);
    };
    //更新
    this.update = function(entity){
        return $http.post('/itemCat/update.do',entity);
    };
    //添加
    this.add = function(entity){
        return $http.post('/itemCat/add.do',entity);
    };
    //删除
    this.delete = function(ids){
        return $http.get('/itemCat/delete.do?ids='+ids);
    };
});