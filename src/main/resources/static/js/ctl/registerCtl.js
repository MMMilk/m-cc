
function getEamil() {
    $.ajax({
        url : "/login/getEmail",//请求地址
        data : {"email" : $("#email").val()},
        type : "post",//请求方式
        async:true,
        success : function(data) { //发送成功
            alert("请查收验证码！")
        },
        error : function(data) {
        }
    });
}

//注册


var registerApp = angular.module("registerApp",[]);
registerApp.controller('registerCtl',function ($scope,$http) {
    $scope.submit = function(){
        $http({
            method:'post',
            url:'/login/registered',
            params:{
                "email": $("#email").val(),
                "code":$scope.verification,
                "password": $scope.onePassword
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(function(resp){
            var mes = resp.data.msg;
            alert(mes);
        },function(resp){
            console.log(resp.data.msg);
        });
    }
});
