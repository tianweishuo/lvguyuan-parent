//服务层
app.service('brandService',function($http){
    //查询品牌列表
    this.findAll = function(){
        return $http.get("/brand/findAll.do");
    };
    //分页查询
    this.findPage = function(page,rows){
        return $http.get("/brand/findPage.do?page="+page+'&rows='+rows);
    };
    //添加
    this.add = function(entity){
        return $http.post("/brand/add.do",entity);
    };
    //更改
    this.update = function(entity){
        return $http.post("/brand/update.do",entity);
    };
    //单个查询
    this.findOne = function(id){
        return $http.get("/brand/findOne.do?id="+id);
    }
    //删除
    this.delete = function(selectIds){
        return $http.get("/brand/delete.do?ids="+selectIds);
    };
    //条件查询
    this.sarch = function(page,rows,sarchEneity){
        return $http.post('/brand/sarch.do?page='+page+'&rows='+rows,sarchEneity);
    };
});