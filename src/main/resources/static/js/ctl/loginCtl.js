//登录
var app = angular.module("loginApp",[]);
app.controller('loginCtrl',function ($scope,$http) {
        $scope.submit= function () {
            $http({
                method:'post',
                url:'/login/loginSubmit',
                params:{
                    "username":$scope.username,
                    "password":$scope.password
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
                    if(flg == "usersError"){
                        alert("输入的用户不存在，请重新输入");
                    }else{
                        alert("输入的密码不正确，请重新输入");
                    }
                }
            },function(resp){
                console.log(resp.data);
            });
        }
});

//获取邮箱验证码
var emailApp = angular.module("emailApp",[]);
emailApp.controller('emailCtl',function ($scope,$http) {
    var eamil = $scope.email;
    $scope.submit = function(){
        $http({
            method:'post',
            url:'/login/getEmail',
            params:{
                "eamil":eamil
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(function(resp){
            alert("1111");
        },function(resp){
            console.log(resp.data);
        });
    }
});







//登录成功获取用户名
var myApp=angular.module("myApp",[]);
myApp.controller("myCon",function ($scope,$http) {
    $http.get("/login/showInfo").then(function (response) {
        $scope.userName=response.data.username;
    })
});






