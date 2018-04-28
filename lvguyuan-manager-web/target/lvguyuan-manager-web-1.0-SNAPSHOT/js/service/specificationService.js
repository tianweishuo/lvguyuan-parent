//规格服务层
app.service("specificationService",function($http){
    //查询列表
    this.findAll = function(){
        return $http.get('/specification/findAll.do');
    };
    //分页查询
    this.findPage = function(page,rows){
        return $http.get('/specification/findPage.do?page='+page+'&rows='+rows);
    };
    //单个查询
    this.findOne = function(id){
        return $http.get("/specification/findOne.do?id="+id);
    };
    //添加
    this.add = function(entity){
        return $http.post('/specification/add.do',entity);
    };
    //删除
    this.delete = function(selectIds){
        return $http.post('/specification/delete.do?ids='+selectIds);
    };

    //更新
    this.update = function(entity){
        return $http.post('/specification/update.do',entity);
    };

    //条件查询
    this.sarch = function(page,rows,sarchEneity){
        return $http.post('/specification/search.do?page='+page+'&rows='+rows,sarchEneity);
    }
});