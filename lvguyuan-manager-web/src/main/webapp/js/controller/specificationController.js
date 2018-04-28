//规格控制层
app.controller('specificationController',function($scope,$controller,specificationService){
    //继承
    $controller('baseController',{$scope:$scope});
    //查询品牌列表
    $scope.findAll = function(){
        specificationService.findAll().success(
            function(response){
                $scope.list = response;
            }
        );
    };
    //分页查询
    $scope.findPage = function (page,rows) {
        specificationService.findPage(page,rows).success(
            function(response){
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        )
    };
    //单个查询
    $scope.findOne = function(id){
        specificationService.findOne(id).success(
            function(response){
                $scope.entity= response;
            }
        );
    };
    //删除
    $scope.delete = function(){
        specificationService.delete($scope.selectIds).success(
            function (response) {
                if(response.success){
                    $scope.reloadList();
                }
            }
        );
    };
    //新增或修改
    $scope.save = function(){
        var servicObject = null;//方法名称
        if($scope.entity.specification.id != null){
            //修改
            servicObject = specificationService.update($scope.entity);
        }else{
            //新增
            servicObject = specificationService.add($scope.entity);
        }
        servicObject.success(
            function (response) {
                if(response.success){
                    //刷新
                    $scope.reloadList();
                }else{
                    alert(response.message);
                }
            }
        );

    };
    //条件查询参数
    $scope.sarchEneity = {};
    //条件查询
    $scope.sarch = function(page,rows){
        specificationService.sarch(page,rows,$scope.sarchEneity).success(
            function(response){
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    };
    //增加行数据
    $scope.addTableRow = function(){
        $scope.entity.specificationOptionList.push({});
    };
    //删除表格行
    $scope.deletTableRow = function(index){
        $scope.entity.specificationOptionList.splice(index,1);
    }

});