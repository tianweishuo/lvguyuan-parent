//模板管理控制层
app.controller('typeTemplateController',function($scope,$controller,typeTemplateService){
    //继承
    $controller('baseController',{$scope:$scope});
    //查询品牌列表
    $scope.findAll = function(){
        typeTemplateService.findAll().success(
            function(response){
                $scope.list = response;
            }
        );
    };
    //分页查询
    $scope.findPage = function (page,rows) {
        typeTemplateService.findPage(page,rows).success(
            function(response){
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        )
    };
    //新增或修改
    $scope.save = function(){
        var object = null;//方法名称
        if($scope.entity.id != null){
            object = typeTemplateService.update($scope.entity);
        }else{
            object = typeTemplateService.add($scope.entity);
        }

        object.success(
            function(response){
                if(response.success){
                    $scope.reloadList();//刷新
                }else{
                    alert(response.message);
                }
            }
        )
    };
    //单个查询
    $scope.findOne = function(id){
        typeTemplateService.findOne(id).success(
            function(response){
                $scope.entity= response;
                $scope.entity.brandIds=  JSON.parse($scope.entity.brandIds);//转换品牌列表
                $scope.entity.specIds=  JSON.parse($scope.entity.specIds);//转换规格列表
                $scope.entity.customAttributeItems= JSON.parse($scope.entity.customAttributeItems);//转换扩展属性
            }
        );
    };
    //删除
    $scope.delete = function(){
        typeTemplateService.delete($scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.reloadList();
                }else{
                    alert(response.message);
                }
            }
        );
    };
    //查询列表
    $scope.sarchEneity = {};
    //条件查询
    $scope.sarch = function(page,rows){
        typeTemplateService.sarch(page,rows,$scope.sarchEneity).success(
            function(response){
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };
    //品牌列表
    $scope.brandList={data:[]};
    //读取品牌列表
    $scope.findBrandList = function(){
        typeTemplateService.selectBrandOptionList().success(
            function (response) {
                $scope.brandList={data:response};
            }
        );

    }
    //规格列
    $scope.sepcList={data:[]};
    //读取规格列表
    $scope.findSepcList = function(){
        typeTemplateService.selectSpecificationOptionList().success(
            function(response){
                $scope.sepcList={data:response};
            }
        );
    };
    //新增扩展属性
    $scope.addTableRow = function(){
        $scope.entity.customAttributeItems.push({});
    };
    //删除扩展属性行
    $scope.deleTableRow=function(index){
        $scope.entity.customAttributeItems.splice(index,1);//删除
    }
});