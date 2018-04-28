//控制层
app.controller('brandController',function($scope,$controller,brandService){
    //继承
    $controller('baseController',{$scope:$scope});
    //查询品牌列表
    $scope.findAll = function(){
        brandService.findAll().success(
            function(response){
                $scope.list = response;
            }
        );
    };
    //分页查询
    $scope.findPage = function (page,rows) {
        brandService.findPage(page,rows).success(
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
            object = brandService.update($scope.entity);
        }else{
            object = brandService.add($scope.entity);
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
        brandService.findOne(id).success(
            function(response){
                $scope.entity = response;
            }
        );
    };
    //删除
    $scope.delete = function(){
        brandService.delete($scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.reloadList();
                }else{
                    alert(response.message);
                }
            }
        );
    };

    $scope.sarchEneity = {};
    //条件查询
    $scope.sarch = function(page,rows){
        brandService.sarch(page,rows,$scope.sarchEneity).success(
            function(response){
                $scope.list = response.rows;//显示当前页数据
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        );
    }
});