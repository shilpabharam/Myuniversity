app.config(['$routeProvider', '$httpProvider', 'localStorageServiceProvider', function($routeProvider, $httpProvider, localStorageServiceProvider) {


    // ======= local storage configuration ========

    localStorageServiceProvider.prefix = 'example';

	// ======= router configuration =============

    /*.when('/', {
		controller : "loginValidateController",
		resolve: {
			user: localStorageServiceProvider.localStorageService.get('localStorageUser')
		}
	})*/
    
	$routeProvider.when('/', {
			templateUrl: 'resources/html/partials/view/dashboard.html',
			controller: 'MainController'
		}).when('/createEvent', {
			templateUrl: 'resources/html/partials/view/ev.html',
			controller: 'MainController'
		}).when('/createAdvertisement', {
			templateUrl: 'resources/html/partials/view/create_advertisement.html',
			controller: 'MainController'
		}).when('/showAdvertisements', {
			templateUrl: 'resources/html/partials/view/show_advertisements.html',
			controller: 'MainController'
		}).when('/editEvent/:eventId', {
			templateUrl: 'resources/html/partials/view/edit_event.html',
			controller: 'editController'
		}).when('/badges', {
			templateUrl: 'resources/html/partials/view/badge.html',
			controller: 'MainController'
		}).otherwise({
	        redirectTo: '/',
	        controller: 'MainController'
	    });
	// ======== http configuration ===============
//	$locationProvider.html5Mode(true).hashPrefix('');
	//configure $http to view a login whenever a 401 unauthorized response arrives
    $httpProvider.responseInterceptors.push(function ($rootScope, $q) {
        return function (promise) {
            return promise.then(
                //success -> don't intercept
                function (response) {
                    return response;
                },
                //error -> if 401 save the request and broadcast an event
                function (response) {
                    if (response.status === 401) {
                        var deferred = $q.defer(),
                            req = {
                                config: response.config,
                                deferred: deferred
                            };

                        $httpProvider.defaults.headers.common.Authorization = null;

                        $rootScope.requests401.push(req);
                        //$rootScope.$broadcast('event:loginRequired');

                        return deferred.promise;
                    }
                    return $q.reject(response);
                }
            );
        };
    });
}]);