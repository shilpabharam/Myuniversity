app
		.controller(
				'BadgeController',
				function($rootScope, $scope, $location, $http, $filter, $q,
						$sce, localStorageService, $timeout, $compile) {
					$scope.socialBadges = [];
					$scope.socialBadges[0] = {};
					$scope.socialBadges[1] = {};
					$scope.socialBadges[2] = {};
					$scope.universityId="";
					
					$scope.socialBadges[0].socialBadgeName = "bronze";
					$scope.socialBadges[1].socialBadgeName = "silver";
					$scope.socialBadges[2].socialBadgeName = "gold";
	
					// getting logged user
					$scope.getloggedUserBadge = function() {
						console.log("Badge controller");
						var request = $http({
							method : "GET",
							url : '/myuniversity/usersDetail/userName'
						});
						request.success(function(response) {
							console.log(response);
						$scope.universityId = response.universityId;
						$scope.getSocialBadgePoints();
					});
					}
					
					//clearing social badge points
					$scope.clearBadgeEvent = function(){
						for (var i = 0; i < $scope.socialBadges.length; i++) {
							$scope.socialBadges[i].socialBadgePoints = "";
						}
						var socialEventError = angular
								.element("#socialEventError");
						socialEventError.text('');
							
					}
					//validating social badge points
					$scope.validateSocialEvent=function(){
						var isvalid = true;
						var socialEventError = angular
								.element("#socialEventError");
						
						  var bronze = $scope.socialBadges[0].socialBadgePoints;
		                  var silver = $scope.socialBadges[1].socialBadgePoints;
		                  var gold = $scope.socialBadges[2].socialBadgePoints;
						
		                  if (bronze == "" || silver == "" || gold == "") {
		                        isvalid = false;
		                        socialEventError
		                            .text("Please fill all social badges data.");
		                        socialEventError.css('color', 'red');
		                    } else if ((isNaN(bronze) || isNaN(silver) || isNaN(gold)) ||
		                        (bronze < 1 || silver < 1 || gold < 1)) {
		                        isvalid = false;
		                        socialEventError
		                            .text("Data should not negative and should be number");
		                        socialEventError.css('color', 'red');
		                    } else if (bronze >= silver || bronze >= gold) {
		                        isvalid = false;
		                        socialEventError
		                            .text("Bronze data should not be greater than silver and gold");
		                        socialEventError.css('color', 'red');
		                    } else if (silver >= gold) {
		                        isvalid = false;
		                        socialEventError
		                            .text("Silver data should not be greater than gold");
		                        socialEventError.css('color', 'red');
		                    } else {
		                    	socialEventError.text(" ");
		                    }

						if (isvalid) {
							$scope.createSocialEvent();
						}
					}
					//creating social badge points
					$scope.createSocialEvent=function(){
						
						$('#successSocialEventmodel').modal('show');
						$('#badgeLabel').html('Please wait.....');
						$scope.socialBadges[0].universityId = $scope.universityId;
						$scope.socialBadges[1].universityId = $scope.universityId;
						$scope.socialBadges[2].universityId = $scope.universityId;
				
						console.log($scope.socialBadges);
						var request = $http({
							method : "post",
							url : '/myuniversity/badge/createSocialBadgePoints',
							headers : {
								'Content-Type' : 'application/json',
								'Accept' : 'application/xml'
							},
							data : $scope.socialBadges

						});
						request.success(function(response) {
							$('#badgeLabel').html(response);
							$timeout(function() {
								$('#successSocialEventmodel').modal('hide');
							}, 5000);

						});
					}
					
					$scope.getSocialBadgePoints = function() {
						$scope.socialBadgeData = {};
						$scope.socialBadgeData.universityId =$scope.universityId;
						var request = $http({
							method : "POST",
							url : '/myuniversity/badge/getSocialBadgePoints',
							headers : {
								'Content-Type' : 'application/json',
								'Accept' : 'application/xml'
							},
							data : $scope.socialBadgeData
						});
						request.success(function(response) {
							$scope.socialBadges=response;
							console.log("points");
							console.log($scope.socialBadges);
						});
					};
});