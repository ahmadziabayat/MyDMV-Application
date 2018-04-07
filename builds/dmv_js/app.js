var myQuiz = angular.module('myQuiz',
    ['ngRoute', 'firebase']);

myQuiz.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/DMV', {
            templateUrl: '/index.html',
            controller: 'QuizController'
        }).
        // when('/register', {
        //     templateUrl: 'views/register.html',
        //     controller: 'RegistrationController'
        // }).
        // when('/checkins/:uId/:mId', {
        //     templateUrl: 'views/checkins.html',
        //     controller: 'CheckInsController'
        // }).
        // when('/checkins/:uId/:mId/checkinsList', {
        //     templateUrl: 'views/checkinslist.html',
        //     controller: 'CheckInsController'
        // }).
        // when('/meetings', {
        //     templateUrl: 'views/meetings.html',
        //     controller: 'MeetingsController',
        //     resolve: {
        //         currentAuth: function(Authentication) {
        //             return Authentication.requireAuth();
        //         } //currentAuth
        //     }//resolve
        // }).
        otherwise({
            redirectTo: '/index.html'
        });
}]);
