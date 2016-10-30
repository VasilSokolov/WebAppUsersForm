'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user={id:null,userName:'',email:'',country:''};
    self.users=[];

    fetchAllUsers();

    function fetchAllUsers(){
        AuthorService.fetchAllUsers()
            .then(
            function(data) {
                self.authors = data;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

}]);
