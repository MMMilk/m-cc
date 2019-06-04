/*
angular.module("loginApp",[])
    .controller("loginCtrl",function ($scope,$http) {

        $http.get("/login/loginSubmit").then(function (data) {

           alert("111");
        })


    })*/

var formData = {
    method: 'POST',
    url: 'http://localhost:8080/login/loginSubmit',
    data: {username:'1',password:'1',authority:'0'}
}


var app = angular.module("loginApp",[]);
app.controller('loginCtrl',function ($scope,$http) {
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
        }).then(function(data){
            console.log(data);
        },function(data){
            console.log(data);
        });
    }
});
