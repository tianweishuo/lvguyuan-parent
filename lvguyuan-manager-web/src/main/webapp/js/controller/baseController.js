app.controller('baseController',function($scope){
    //分页控件配置 currentPage当前页 totalItems总记录数 itemsPerPage每页记录数 perPageOptions分页选项
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();
        }
    };
    //刷新列表
    $scope.reloadList = function(){
        $scope.sarch($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);//重新加载
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