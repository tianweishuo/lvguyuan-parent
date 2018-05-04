//商品分类控制层
app.controller('itemCatController',function($scope,itemCatService){
    //继承Controller
    //$controller('baseController',{$scope:$scope});
    //默认为1级
    $scope.grade=1;
    //设置级别
    $scope.setGrade=function(value){
        $scope.grade=value;
    }
    //读取列表
    $scope.selectList=function(p_entity){
        if($scope.grade==1){//如果为1级
            $scope.entity_1=null;
            $scope.entity_2=null;
        }
        if($scope.grade==2){//如果为2级
            $scope.entity_1=p_entity;
            $scope.entity_2=null;
        }
        if($scope.grade==3){//如果为3级
            $scope.entity_2=p_entity;
        }
        $scope.findByParentId(p_entity.id);	//查询此级下级列表
    }

    //上级ID
    $scope.parentId=0;
    //根据上级ID显示下级列表
    $scope.findByParentId=function(parentId){
        $scope.parentId=parentId;//记住上级ID
        itemCatService.findByParentId(parentId).success(
            function(response){
                $scope.list=response;
            }
        );
    };
    //保存
    $scope.save=function(){
        var serviceObject;//服务层对象
        if($scope.entity.id!=null){//如果有ID
            serviceObject=itemCatService.update( $scope.entity ); //修改
        }else{
            $scope.entity.parentId=$scope.parentId;//赋予上级ID
            serviceObject=itemCatService.add( $scope.entity  );//增加
        }
        serviceObject.success(
            function(response){
                if(response.success){
                    //重新查询
                    $scope.findByParentId($scope.parentId);//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    };
    //查询单个
    $scope.findOne = function(id){
        itemCatService.findOne(id).success(
            function(response){
                $scope.entity = response;
            }
        );
    };
    //删除
    $scope.delete = function(){
        itemCatService.delete($scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.findByParentId($scope.parentId);//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    };
    //选中的ID集合
    $scope.selectIds=[];
    //更新复选框
    $scope.updateSelection = function($event, id){
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.selectIds.push( id);
        }else{
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除
        }
    };

});