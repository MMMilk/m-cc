function showPic() {
    var windowURL = window.URL || window.webkitURL;
    var file = document.getElementById("up_files").files;
    var html= "";
    for(var i = 0 ; i < file.length ;i++){
        var url = windowURL.createObjectURL(file[i]);
        html = html+"<img src='"+url+" ' width='40px;' height='40px;'/>&nbsp;&nbsp;&nbsp;";
        $("#showPic").html(html);
    }
}

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
    };

    $http({
        method:"get",
        url:"/file/getInfo",
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
    }).then(function (resp) {
        //alert(JSON.stringify(resp.data));
        $scope.urlList = resp.data.data;
    });


});


//excel下载
function excelDown() {
    $.ajax({
        type: "post",
        url: "/file/excelDown",
        dataType: "json",
        async: true,
        success: function () {
            alert("-----------------excel");
        },
        error: function () {
            alert("====================excel");
        }
    })
}


//文件压缩包下载
function zipDown() {
    $.ajax({
        type: "post",
        url: "/file/zipDown",
        async: true,
        success: function () {
            alert("-----------------zip");
        },
        error: function () {
            alert("====================zip");
        }
    })
}