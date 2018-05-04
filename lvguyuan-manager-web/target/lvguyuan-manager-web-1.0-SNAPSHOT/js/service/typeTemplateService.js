//模板管理服务层
app.service('typeTemplateService',function($http){
    //查询列表
    this.findAll = function(){
        return $http.get('/typeTemplate/findAll.do');
    };
    //分页查询
    this.findPage = function(page,rows){
        return $http.get('/typeTemplate/findPage.do?page='+page+'&rows='+rows);
    };
    //单个查询
    this.findOne = function(id){
        return $http.get("/typeTemplate/findOne.do?id="+id);
    };
    //添加
    this.add = function(entity){
        return $http.post('/typeTemplate/add.do',entity);
    };
    //删除
    this.delete = function(selectIds){
        return $http.post('/typeTemplate/delete.do?ids='+selectIds);
    };

    //更新
    this.update = function(entity){
        return $http.post('/typeTemplate/update.do',entity);
    };

    //条件查询
    this.sarch = function(page,rows,sarchEneity){
        return $http.post('/typeTemplate/search.do?page='+page+'&rows='+rows,sarchEneity);
    }

    //品牌下拉列表
    this.selectBrandOptionList = function(){
        return $http.get('/brand/selectOptionList.do');
    }

    //规格下拉列表
    this.selectSpecificationOptionList = function () {
        return $http.get('/specification/selectOptionList.do')
    }

});