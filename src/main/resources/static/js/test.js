var app=angular.module("myApp",[]);
app.controller("myCon",function ($scope,$http) {
    $http.get("/index4").then(function (response) {

        $scope.hello=response.data.name
    })
})
