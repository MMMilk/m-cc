var app = angular.module("loginApp",[]);
app.controller('loginCtrl',function ($scope,$http,$location) {
    $scope.submitForm = function () {
        $http({
            method:'post',
            url:'/login/loginSubmit',
            params:{
                "username":$scope.username,
                "password":$scope.password,
                "authority":$scope.authority
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(function(resp){
            var flg = resp.data.msg;
            if(flg == "success"){
               // window.open("success","_self");
               window.location.href="../login/success";
            }else{
                alert("登录错误");
            }
        },function(resp){
            console.log(resp.data);
        });
    }
});


var myApp=angular.module("myApp",[]);
myApp.controller("myCon",function ($scope,$http) {
    $http.get("/login/showInfo").then(function (response) {
        $scope.userName=response.data.username;
    })
})

