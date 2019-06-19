var fileApp = angular.module("fileApp",[]);
fileApp.controller("fileCtrl",function ($scope,$http) {
    $scope.uploadFile = function () {
        var form = new FormData();
        var file = document.getElementById("up_files").files;
        for(var i = 0 ; i < file.length ;i++){
            form.append("file",file[i]);
        }
        $http({
            method:"post",
            url:"/file/fileUpload",
            data:form,
            headers:{'Content-Type':undefined},
            transformRequest:angular.identity
        }).then(function (resp) {
            alert("111");
        }).catch(function (error) {//加上catch
            console.log(error);
        })
    }


});