//商品管理
app.controller('goodsController',function($scope,$controller,goodsService,uploadService,itemCatService,typeTemplateService){
    //继承controller
    $controller('baseController',{$scope:$scope});

    //保存
    $scope.add = function(){
        $scope.entity.goodsDesc.introduction = editor.html();

        goodsService.add($scope.entity).success(
            function(response){
                if(response.success){
                    $scope.entity = {};
                    editor.html("");//清空富文本编辑器
                }{
                    alert(response.message);
                }
            }
        );
    };

    //上传文件
    $scope.uploadFile = function(){
        uploadService.uploadFile().success(
            function(response){
                if(response.success){
                    $scope.image_entity.url =  response.message;
                }else{
                    alert(response.message);
                }
            }
        );
    };


    //定义页面实体结构
    $scope.entity = {goods:{},goodsDesc:{itemImages:[],specificationItems:[],customAttributeItems:[]}};
    //列表中添加图片
    $scope.add_image_entity = function(){
        $scope.entity.goodsDesc.itemImages.push($scope.image_entity);
    }

    //列表中移除图片
    $scope.remove_image_entity = function(index){
        $scope.entity.goodsDesc.itemImages.splice(index,1);
    }

    //查询以及菜单分类
    $scope.selectItemCat1List = function(){
        itemCatService.findByParentId(0).success(
            function(response){
                $scope.itemCat1List = response;
            }
        );
    }

    //监控菜单
    $scope.$watch('entity.goods.category1Id',function(newValue,oldValue){
        itemCatService.findByParentId(newValue).success(
            function(response){
                $scope.itemCat2List = response;
            }
        );
    });

    //监控菜单
    $scope.$watch('entity.goods.category2Id',function(newValue,oldValue){
        itemCatService.findByParentId(newValue).success(
            function(response){
                $scope.itemCat3List = response;
            }
        );
    });

    //监控菜单
    $scope.$watch('entity.goods.category3Id',function(newValue,oldValue){
        itemCatService.findOne(newValue).success(
            function(response){
                $scope.entity.goods.typeTemplateId = response.typeId;
            }
        );
    });

    //监控模板ID
    $scope.$watch('entity.goods.typeTemplateId', function(newValue, oldValue) {
        //扩展属性
        typeTemplateService.findOne(newValue).success(
            function(response){
                $scope.typeTemplate=response;//获取类型模板
                $scope.typeTemplate.brandIds= JSON.parse( $scope.typeTemplate.brandIds);//品牌列表
                $scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems);
            }
        );

        //规格列表
        typeTemplateService.findSpecList(newValue).success(
            function(response){
                $scope.specList = response;
            }
        );
    });


    $scope.updateSpecAttribute = function($event,name,value){
        console.info(name+":"+value);
        var object = $scope.searchObjectByKey($scope.entity.goodsDesc.specificationItems,'attributeName',name);
        if(object != null){
            if($event.target.checked){
                object.attributeValue.push(value);
            }else{
                object.attributeValue.splice(object.attributeValue.indexOf(value),1);
                if(object.attributeValue.length == 0){
                    $scope.entity.goodsDesc.specificationItems.splice($scope.entity.goodsDesc.specificationItems.indexOf(object),1);
                }
            }
        }else{
            $scope.entity.goodsDesc.specificationItems.push({"attributeName":name,"attributeValue":[value]});
        }

    }

    //创建SKU列表
    $scope.createItemList = function(){
        //列表初始化
        $scope.entity.itemList = [{spec:{},price:0,num:99999,status:'0',isDefault:'0'}];
        var items = $scope.entity.goodsDesc.specificationItems;
        for(var i = 0 ;i < items.length ; i++){
            $scope.entity.itemList = addColumn($scope.entity.itemList,items[i].attributeName,items[i].attributeValue);
        }

    };

    //[{"attributeName":"网络制式","attributeValue":["移动3G","移动4G"]},{"attributeName":"屏幕尺寸","attributeValue":["6寸","5.5寸"]}]
    addColumn = function(list,columnName,columnValues){
        var newList = [];
        for(var i = 0;i < list.length ;i++){
            var oldRow = list[i];
            for(var j = 0 ; j < columnValues.length; j++){
                var newRow = JSON.parse(JSON.stringify(oldRow));
                newRow.spec[columnName] = columnValues[j];
                newList.push(newRow);
            }
        }
        return newList;
    }

});