
var pageApp = angular.module("pageApp",[]);
pageApp.controller("pageCtl",function ($scope,$http,$sce) {

    var pageSize = $("#pageSize").val();//页面的数据条数
    var pageNum = $("#pageNum").val();//页数
    //加载页面数据
    $http({
        method:"get",
        url:"/page/getInfo",
        params:{"pageSize":pageSize,"pageNum":pageNum},
        headers:{
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    }).then(function (resp) {
        $scope.items =resp.data.data;
        var totalPages = resp.data.totalPages;
        $scope.numTotals = resp.data.totalCount;
        $("#pageTotals").val(resp.data.totalPages);

        if(totalPages > 0 ){
            if(totalPages ==1){
                $scope.pageTotal = [1];
            }else if(totalPages == 2){
                $scope.pageTotal = [1,2];
            }else {
                $scope.pageTotal = [1,2,3];
            }
        }
    });

    $scope.goPage = function (flg) {
        var pageSize = $("#pageSize").val();//页面的数据条数
        var pageNum = $("#pageNum").val();//页数
        var pageTotals = $("#pageTotals").val();//页数
        if(flg == 'first'){
             pageNum = 1;
        }else if(flg == 'last'){
            pageNum = pageTotals;
        }else if(flg == 'back'){
            pageNum = pageNum*1 - 1*1;
            if(pageNum == 1){
                $("#backId").attr("disabled","disabled");
            }
        }else if(flg == 'next'){
            pageNum = pageNum*1 + 1*1;
            if(pageNum == pageTotals){
                alert(pageNum+"====="+pageTotals);
                $("#nextId").attr("disabled","disabled");
            }
        }else {
            pageNum = flg;
        }
        $("#pageNum").val(pageNum);

        if(pageNum == 1){
            $("#backId").attr("disabled","disabled");
        }else {
            $("#backId").removeAttr("disabled");
        }

        if(flg == 'last'){
            $("#nextId").attr("disabled","disabled");
        }else {
            $("#nextId").removeAttr("disabled");
        }

        $http({
            method:"get",
            url:"/page/getInfo",
            params:{"pageSize":pageSize,"pageNum":pageNum},
            headers:{
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(function (resp) {
            $scope.items =resp.data.data;
            $scope.numTotals = resp.data.totalCount;
        });




    }
});



