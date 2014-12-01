angular
    .module('eventManager', ['ngRoute', 'ngResource'])
    .config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.
                when('/overview', {
                    templateUrl: '/app/view/overview.html',
                    controller: 'overviewController'

                }).
                when('/events', {
                    templateUrl: '/app/view/events.html',
                    controller: 'eventsController'

                }).
                when('/users', {
                    templateUrl: '/app/view/users.html',
                    controller: 'usersController'

                }).
                when('/groups', {
                    templateUrl: '/app/view/groups.html',
                    controller: 'groupsController'

                }).
                otherwise({
                    redirectTo: '/overview'
                });
        }]);
;