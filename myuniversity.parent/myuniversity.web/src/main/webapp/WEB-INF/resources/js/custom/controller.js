app
    .controller(
        'MainController',
        function($rootScope, $scope, $location, $http, $filter, $q,
            $sce, localStorageService, $timeout, $compile) {
            if (angular.isUndefined($scope.editbtngroup) ||
                $scope.editbtngroup == false) {
                $scope.createbtngroup = true;
                $scope.prioritybtn = "Yes";
                $scope.successcreatemsg = false;
                $scope.createadvTitle = true;
                $scope.editadvTitle = false;
            }
            if ($scope.prioritybtn == "Yes") {
                $scope.prioritybtn = true;
            } else if ($scope.prioritybtn == "No") {
                $scope.prioritybtn = false;
            }

            $scope.AllEventBean = [];
            $scope.EventRequestBean = {};
            $scope.eventTypes = [];
            $scope.universityId = "";
            $scope.loggedUser = "";
            $scope.skillTableRow = 0;
            $scope.socialTableRow = 0;
            $scope.skills = [];
            $scope.tags = [];
            $scope.interests = [];
            $scope.evets = {};
            $scope.event = {};
            $scope.selected = {};
            $scope.resource = {};
            $scope.category = {};
            $scope.selected_skills = 0;
            $scope.selected_social_badge = "";
            $scope.categoryName = [];
            $scope.resources = [];
            $scope.eventTypeId = 0;
            $scope.event.general = {};
            $scope.socialBadge = {};
            $scope.socialBadge.general = {};
            $scope.event.skillSch = [];
            $scope.skillIndexTemp = 0;
            $scope.event.socialBadge = [];
            $scope.socialIndexTemp = 0;
            $scope.skillSch = [];
            $scope.socBadge = {};
            $scope.skillBadges = [];
            $scope.skillBadges[0] = {};
            $scope.skillBadges[1] = {};
            $scope.skillBadges[2] = {};
            $scope.skillBadges[3] = {};
            $scope.skillBadges[0].skillBadgeName = "bronze";
            $scope.skillBadges[1].skillBadgeName = "silver";
            $scope.skillBadges[2].skillBadgeName = "gold";
            $scope.skillBadges[3].skillBadgeName = "platinum";
            $scope.socialBadge.general.numberOfEvents = 0;
            $scope.event.general.eventFromTime = "";
            $scope.event.general.eventToTime = "";
            $scope.something = "";

           
            // getting logged user
            $scope.getloggedUser = function() {
                var request = $http({
                    method: "GET",
                    url: '/myuniversity/usersDetail/userName'

                });
                request
                    .success(function(response) {
                        // console.log("logged USer" + response);
                        var loggUser = angular
                            .element('#loggedUserName');
                        loggUser.html(response.fullName +
                            '<span class="caret"></span>');
                        console.log(response);
                        $scope.universityId = response.universityId;
                        // calling after we get university id
                        $scope.getSkillBadge();
                        // $scope.getAllCurrentUniversityEvents();
                        $scope.showadv(1);

                        $scope.geteventtoedit = function(obj) {
                        	
                            var date = new Date(obj.fromDate);
                            var sHour = date.getHours();
                            var sAmPm = "AM";
                            if (date.getHours() > 12) {
                                sAmPm = "PM";
                                sHour = sHour - 12;
                            } else if (sHour == 0) {
                                sHour = "12";
                            }
                            $scope.AdvFromDateEdit = (date
                                    .getMonth() + 1) +
                                '/' +
                                date.getDate() +
                                '/' +
                                date.getFullYear() +
                                ' ' +
                                sHour +
                                ":" +
                                date.getMinutes() +
                                " " +
                                sAmPm;

                            var dateEnd = new Date(obj.toDate);
                            var eHour = dateEnd.getHours();
                            var eAmPm = "AM";
                            if (dateEnd.getHours() > 12) {
                                eAmPm = "PM";
                                eHour = eHour - 12;
                            } else if (eHour == 0) {
                                eHour = "12";
                            }

                            $scope.advToDateEdit = (dateEnd
                                    .getMonth() + 1) +
                                '/' +
                                dateEnd.getDate() +
                                '/' +
                                dateEnd.getFullYear() +
                                ' ' +
                                eHour +
                                ":" +
                                dateEnd.getMinutes() +
                                " " +
                                eAmPm;
                            $scope.createbtngroup = false;
                            $scope.editbtngroup = true;
                            $scope.createadvTitle = false;
                            $scope.editadvTitle = true;
                            $scope.something = obj;
                            console.log($scope.something);
                            $scope.addid = obj.id;
                            $scope.addname = obj.name;
                            $scope.addstartdate = $scope.AdvFromDateEdit;
                            $scope.addenddate = $scope.advToDateEdit;
                            $scope.weburl = obj.webURL;
                            $scope.adddesc = obj.description;
                            $scope.prioritybtn = obj.isPublished;
                        }

                        $scope.saveeditedadv = function(
                            saveeditadvobj) {
                            var request = $http({
                                method: "POST",
                                url: '/myuniversity/ads/edit',
                                headers: {
                                    'Content-Type': 'application/json',
                                    'Accept': 'application/xml'
                                },
                                data: saveeditadvobj
                            });
                            request.success(function(response) {
                                $scope.savededitedadv = response;
                                $scope.showadv(1);
                            });
                        }

                        $scope.creatteeadv = function() {
                            $scope.something = "";
                            $scope.addid = "";
                            $scope.addname = "";
                            $scope.addstartdate = "";
                            $scope.addenddate = "";
                            $scope.weburl = "";
                            $scope.adddesc = "";
                            $scope.createbtngroup = true;
                            $scope.createadvTitle = true;
                            $scope.editadvTitle = false;
                            $scope.editbtngroup = false;
                            $scope.prioritybtn = false;
                        };

                    });
            };



            // show advertisements
            $scope.showadv = function(pgno) {
                if (angular.isUndefined(pgno)) {
                    pgno = 1;
                }
                $scope.showadds = {
                    "fromDate": null,
                    "toDate": null,
                    "start": (pgno.count - 1) * 12,
                    "limit": 12
                }
                console.log($scope.showadds);
                var request = $http({
                    method: "POST",
                    url: '/myuniversity/ads/show',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/xml'
                    },
                    data: $scope.showadds

                });
                //console.log(request);
                request
                    .success(function(response) {
                        console.log(response);
                        console.log(response.count);
                        $scope.pageCount = [];
                        for (var i = 1; i <= Math
                            .ceil(response.count / 12); i++) {
                            $scope.pageCount.push(i);
                        }
                        console.log("count" + $scope.pageCount);
                        $scope.showadarray = response;
                        console.log($scope.showadarray);
                    });
            }

            // create advertisements
            $scope.createadv = function($setPristine) {
                if ($scope.prioritybtn == true) {
                    $scope.prioritybtn = "Yes";
                } else if ($scope.prioritybtn == false) {
                    $scope.prioritybtn = "No";
                }

                $scope.startdateofad = new Date(angular.element('#startDateAd').val());
                console.log("start date" +$scope.startdateofad);
                $scope.enddateofad = new Date(angular.element('#endDateAd').val());
                console.log("end date" +$scope.enddateofad);
                
                $scope.createadds = {
                    "name": $scope.addname,
                    "fromDate": $scope.startdateofad,
                    "toDate": $scope.enddateofad,
                    "webURL": $scope.weburl,
                    "description": $scope.adddesc,
                    "published": $scope.prioritybtn
                }
                
                console.log($scope.createadds);
                var request = $http({
                    method: "POST",
                    url: '/myuniversity//ads/create',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/xml'
                    },
                    data: $scope.createadds
                });
                request
                    .success(
                        function(response) {
                            console.log($scope.createadds);
                            if (response == "success") {
                                $("#warning-alert")
                                    .fadeTo(100, 500)
                                    .slideUp(
                                        500,
                                        function() {
                                            $(
                                                    "#warning-alert")
                                                .alert(
                                                    'close');
                                        });
                                $scope.successcreatemsg = true;
                                $("#success-alert").alert();
                                $("#success-alert")
                                    .fadeTo(2000, 500)
                                    .slideUp(
                                        500,
                                        function() {
                                            $(
                                                    "#success-alert")
                                                .alert(
                                                    'close');
                                        });

                                /*$("#success-alert").show();
													$timeout(function() {
													    $('#success-alert').hide();
													}, 1000);*/

                            }
                            $scope.addname = " ";
                            $scope.addstartdate = null;
                            $scope.addenddate = null;
                            $scope.weburl = " ";
                            $scope.adddesc = " ";
                            $scope.prioritybtn = true;
                            //$scope.newuserForm.$setPristine();
                            $timeout(function() {
                                console.log("clear fields");
                                $scope.addname = " ";
                                $scope.addstartdate = " ";
                                $scope.addenddate = " ";
                                $scope.weburl = "";
                                $scope.adddesc = "";
                                $scope.prioritybtn = true;
                                $scope.newuserForm.$setPristine();
                            }, 500);

                            $scope.createadstatus = response;
                        }).error(function(response) {
                        $scope.warningcreatemsg = true;
                        $("#warning-alert").alert();
                        // $("#warning-alert").slideUp(500,
                        // function(){
                        // $("#warning-alert").alert('close');
                        // });
                    });
            };

            // Reset create adv
            $scope.resetcreateadvert = function($setPristine) {
                $scope.addname = " ";
                $scope.addstartdate = null;
                $scope.addenddate = null;
                $scope.weburl = "";
                $scope.adddesc = "";
                $scope.prioritybtn = true;
                //$scope.newuserForm.$setPristine();
                $timeout(function() {
                    console.log("clear fields");
                    $scope.addname = " ";
                    $scope.addstartdate = "";
                    $scope.addenddate = "";
                    $scope.weburl = "";
                    $scope.adddesc = "";
                    $scope.prioritybtn = true;
                    $scope.newuserForm.$setPristine();
                }, 1000);
            }

            // get adv to edit advertisements
            $scope.getadv = function(obj) {
                $scope.geteventtoedit(obj);
            };

            // save adv after edit
            $scope.saveeditedadvmain = function() {
                if ($scope.prioritybtn == true) {
                    $scope.prioritybtn = "Yes";
                } else if ($scope.prioritybtn == false) {
                    $scope.prioritybtn = "No";
                }
                var startdateofadvv = new Date(angular.element(
                    '#startDateAd').val());
                var enddateofadvv = new Date(angular.element(
                    '#endDateAd').val());
                var saveeditadvobj = {
                    "id": $scope.addid,
                    "name": $scope.addname,
                    "fromDate": startdateofadvv,
                    "toDate": enddateofadvv,
                    "webURL": $scope.weburl,
                    "description": $scope.adddesc,
                    "published": $scope.prioritybtn
                };
                $scope.saveeditedadv(saveeditadvobj);
            };

            // Delete Adv
            $scope.deleteadv = function(obj) {
                var request = $http({
                    method: "GET",
                    url: '/myuniversity/ads/delete?adId=' + obj

                });
                request.success(function(response) {
                    $scope.showadv(1);
                });
            };

            // getting logged userId
            $scope.getloggedUserId = function() {
                var request = $http({
                    method: "GET",
                    url: '/myuniversity/usersDetail/userId'

                });
                request
                    .success(function(response) {

                        $scope.loggedUserId = response;
                        $scope.event.general.eventCreatedBy = $scope.loggedUserId;

                    });
            };

            // setting badge data
            $scope.loboBadge = [];

            // getting lobo badges
            $scope.getAllLoboBadges = function() {
                var request = $http({
                    method: "post",
                    url: '/myuniversity/loboBadge/getLoboBadges',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/xml'
                    }
                });
                request.success(function(response) {
                    $scope.loboBadge = response;
                });
            };

            // saving lobo badges
            $scope.saveLoboBadges = function() {

                $('#saveLoboModel').modal('show');
                $('#successLoboLable').html('Please wait.....');
                var request = $http({
                    method: "post",
                    url: '/myuniversity/loboBadge/createOrUpdateLoboBadges',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/xml'
                    },
                    data: $scope.loboBadge
                });
                request.success(function(response) {
                    $('#successLoboLable').html(response);
                    $timeout(function() {
                        $('#saveLoboModel').modal('hide');
                    }, 5000);
                    $scope.getAllLoboBadges();
                });
            };

            // validating skill badge creation
            $scope.validateSkillBadge = function() {
                    var isvalid = true;
                    var skillBadgeError1 = angular
                        .element("#skillBadgeError1");
                    var bronze = $scope.skillBadges[0].skillBadgePoints;
                    var silver = $scope.skillBadges[1].skillBadgePoints;
                    var gold = $scope.skillBadges[2].skillBadgePoints;
                    var platinum = $scope.skillBadges[3].skillBadgePoints;

                    if (bronze == "" || silver == "" || gold == "" || platinum == "") {
                        isvalid = false;
                        skillBadgeError1
                            .text("Please fill all skill badges data.");
                        skillBadgeError1.css('color', 'red');
                    } else if ((isNaN(bronze) || isNaN(silver) || isNaN(gold) || isNaN(platinum)) ||
                        (bronze < 1 || silver < 1 || gold < 1 || platinum < 1)) {
                        isvalid = false;
                        skillBadgeError1
                            .text("Data should not negative and should be number");
                        skillBadgeError1.css('color', 'red');
                    } else if (bronze >= silver || bronze >= gold || bronze >= platinum) {
                        isvalid = false;
                        skillBadgeError1
                            .text("Bronze data should not be greater than silver, gold and platinum");
                        skillBadgeError1.css('color', 'red');
                    } else if (silver >= gold || silver >= platinum) {
                        isvalid = false;
                        skillBadgeError1
                            .text("Silver data should not be greater than gold and platinum");
                        skillBadgeError1.css('color', 'red');
                    } else if (gold >= platinum) {
                        isvalid = false;
                        skillBadgeError1
                            .text("Gold data should not be greater than platinum");
                        skillBadgeError1.css('color', 'red');
                    } else {
                        skillBadgeError1.text(" ");
                    }

                    if (isvalid) {

                        $scope.createSkillBadge();
                    }

                }
                // pagination
            $scope.getAllCurrentUniversityEventsPage = function(pages) {
                var request = $http({
                    method: "GET",
                    url: '/myuniversity/usersDetail/userName'
                });
                request
                    .success(function(response) {
                        $scope.universityId = response.universityId;
                        $scope.EventRequestBean.universityId = $scope.universityId;
                        $scope.EventRequestBean.start = (pages.count - 1) * 16;
                        $scope.EventRequestBean.limit = 16;
                        $scope.EventRequestBean.fromDate = new Date(
                            angular.element('#startDateDash')
                            .val());
                        $scope.EventRequestBean.toDate = new Date(
                            angular.element('#endDateDash')
                            .val());
                        var request = $http({
                            method: "POST",
                            url: '/myuniversity/events/getAllCurrentUniversityEvents',
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/xml'
                            },
                            data: $scope.EventRequestBean
                        });
                        request
                            .success(function(response) {
                            	 console.log("$scope.response::" +response);
                                $scope.AllEventBean = response.eventBeanList;
                                // $scope.pageCount =
                                // Math.floor(response.totalCount/16);

                                $scope.pageCount = [];

                                for (var i = 1; i <= Math
                                    .ceil(response.totalCount / 16); i++) {
                                    $scope.pageCount.push(i);
                                    console.log("$scope.pageCount:: " +$scope.pageCount);
                                }
                                for (var i = 0; i < $scope.AllEventBean.length; i++) {
                                    var dateObj = new Date(
                                        $scope.AllEventBean[i].eventFromTime);
                                    var monthNames = [
                                        "January",
                                        "February",
                                        "March", "April",
                                        "May", "June",
                                        "July", "August",
                                        "September",
                                        "October",
                                        "November",
                                        "December"
                                    ];

                                    $scope.AllEventBean[i].day = dateObj
                                        .getUTCDate();
                                    //console.log("$scope.AllEventBean[i].day" +$scope.AllEventBean[i].day);
                                    $scope.AllEventBean[i].month = monthNames[dateObj
                                        .getUTCMonth()];
                                    //console.log("$scope.AllEventBean[i].month" +$scope.AllEventBean[i].month);
                                    if ($scope.AllEventBean[i].eventLongDesc != null) {
                                        if ($scope.AllEventBean[i].eventLongDesc.length >= 20) {
                                            $scope.AllEventBean[i].eventLongDesc = $scope.AllEventBean[i].eventLongDesc
                                                .substring(
                                                    0,
                                                    40);
                                            $scope.AllEventBean[i].eventLongDesc = $scope.AllEventBean[i].eventLongDesc +
                                                '...';
                                        }
                                    }
                                }

                            });

                    });
                //
            };
            $scope.validateDashboardDate = function() {
                var isValid = true;
                var dateErrorLable = angular.element('#dateErrorLable');
                var startDateDash = angular.element('#startDateDash').val();
                var endDateDash = angular.element('#endDateDash').val();
                console.log(startDateDash);
                console.log(endDateDash);

                if (startDateDash == '' || endDateDash == '') {
                    dateErrorLable.text('Please enter Date&Time properly for search.');
                    dateErrorLable.css('color', 'red');
                    isValid = false;
                } else {
                    dateErrorLable.text('');
                }

                if (isValid) {
                    $scope.getAllCurrentUniversityEvents();
                }
            }

            // getting dashboard details
            $scope.getAllCurrentUniversityEvents = function() {
            	$('#pleaseWaitModel').modal('show');
				$('#pleaseWaitLabel').html('Please wait.....');
                var request = $http({
                    method: "GET",
                    url: '/myuniversity/usersDetail/userName'
                });
                request
                    .success(function(response) {
                        $scope.universityId = response.universityId;
                        $scope.EventRequestBean.universityId = $scope.universityId;
                        $scope.EventRequestBean.start = 0;
                        $scope.EventRequestBean.limit = 16;
                        $scope.EventRequestBean.eventName = angular
                        .element('#searchDash').val();
                        
                        $scope.EventRequestBean.fromDate = new Date(
                            angular.element('#startDateDash')
                            .val());
                        $scope.EventRequestBean.toDate = new Date(
                            angular.element('#endDateDash')
                            .val());

                        
                        console.log("$scope.EventRequestBean.eventName" +$scope.EventRequestBean.eventName);
                        var request = $http({
                            method: "POST",
                            url: '/myuniversity/events/getAllCurrentUniversityEvents',
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/xml'
                            },
                            data: $scope.EventRequestBean
                        });
                        request
                            .success(function(response) {
                            	console.log("response" +$scope.EventRequestBean);
                            	$('#pleaseWaitModel').modal('hide');
                                if (response.eventBeanList == 0) {
                                    $('#searchEventModel').modal('show');
                                    $('#searchEventErrorLabel').html('Event Not Found!');
                                    $timeout(function() {
                                        $('#searchEventModel').modal('hide');
                                    }, 2000);
                                }


                                $scope.AllEventBean = response.eventBeanList;
                                //console.log("allEventBean" + $scope.AllEventBean.length);
                                // $scope.pageCount =
                               console.log("count" +response.totalCount/16);

                                $scope.pageCount = [];
                                for (var i = 1; i <= Math.ceil(response.totalCount / 16); i++) {
                                    $scope.pageCount.push(i);
                                }
                                console.log(" $scope.pageCount" +$scope.pageCount);
                                for (var i = 0; i < $scope.AllEventBean.length; i++) {
                                    var dateObj = new Date(
                                        $scope.AllEventBean[i].eventFromTime);
                                    // var month =
                                    // dateObj.getUTCMonth() +
                                    // 1; //months from 1-12
                                    // console.log('dev
                                    // month'+month);
                                    // var day =
                                    // dateObj.getUTCDate();
                                    // $scope.AllEventBean[i].day=day;
                                    var monthNames = [
                                        "January",
                                        "February",
                                        "March", "April",
                                        "May", "June",
                                        "July", "August",
                                        "September",
                                        "October",
                                        "November",
                                        "December"
                                    ];

                                    // var d = new Date(month);
                                    console.log(dateObj
                                        .getUTCMonth());
                                    console
                                        .log('day' +
                                            dateObj
                                            .getUTCDate());

                                    $scope.AllEventBean[i].day = dateObj
                                        .getUTCDate();
                                    $scope.AllEventBean[i].month = monthNames[dateObj
                                        .getUTCMonth()];
                                    if ($scope.AllEventBean[i].eventLongDesc != null) {
                                        if ($scope.AllEventBean[i].eventLongDesc.length >= 80) {
                                            $scope.AllEventBean[i].eventLongDesc = $scope.AllEventBean[i].eventLongDesc
                                                .substring(
                                                    0,
                                                    80);
                                            $scope.AllEventBean[i].eventLongDesc = $scope.AllEventBean[i].eventLongDesc +
                                                '...';
                                        }
                                    }
                                }

                            });

                    });
                //
            };

            // create skill badge
            $scope.createSkillBadge = function() {
                    $('#successSkillmodel').modal('show');
                    $('#skillLable').html('Please wait.....');
                    $scope.skillBadges[0].universityId = $scope.universityId;
                    $scope.skillBadges[1].universityId = $scope.universityId;
                    $scope.skillBadges[2].universityId = $scope.universityId;
                    $scope.skillBadges[3].universityId = $scope.universityId;

                    var request = $http({
                        method: "post",
                        url: '/myuniversity/badge/createSkillBadge',
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/xml'
                        },
                        data: $scope.skillBadges

                    });
                    request.success(function(response) {
                        $('#skillLable').html(response);
                        $timeout(function() {
                            $('#successSkillmodel').modal('hide');
                        }, 5000);

                    });
                }
                // populating skill badges when we loading page.
            $scope.getSkillBadge = function() {
                $scope.skillBadgeData = {};
                $scope.skillBadgeData.universityId = $scope.universityId;
                var request = $http({
                    method: "POST",
                    url: '/myuniversity/badge/getSkillBadgeData',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/xml'
                    },
                    data: $scope.skillBadgeData
                });
                request.success(function(response) {
                    $scope.skillBadges = response;
                });
            };
            // clearing skill badge text values and also validation
            // errors.
            $scope.clearSkillBadge = function() {
                    for (var i = 0; i < $scope.skillBadges.length; i++) {
                        $scope.skillBadges[i].skillBadgePoints = "";
                    }
                    var skillBadgeError1 = angular
                        .element("#skillBadgeError1");
                    skillBadgeError1.text('');
                }
                // clearing social badge values and also validation errors.
            $scope.clearSocialBadge = function() {

                    var deptError = angular.element('#deptError');
                    var descError = angular.element('#descError');
                    var noOfEventError = angular.element('#noOfEventError');
                    var badgeNameError = angular.element('#badgeNameError');

                    deptError.text('');
                    descError.text('');
                    noOfEventError.text('');
                    badgeNameError.text('');

                    var badgeName = angular.element('#badgeName');
                    var noOfEvents = angular.element('#noOfEvent');
                    var badgeDescription = angular.element('#description');
                    badgeName.val("");
                    noOfEvents.val("0");
                    badgeDescription.val("");
                    var depts = angular.element('.deptVal');

                    for (var i = 0; i < depts.length; i++) {
                        depts[i].checked = false;
                    }

                }
                // deletion of social badges.
            $scope.deleteSocialBadgeRow = function(badgeId) {
                    $('#deleteSocialmodel').modal('show');
                    $('#deleteBadgeMsg').html('Please wait.....');

                    $scope.deleteBadgeData = {};
                    $scope.deleteBadgeData = badgeId.obj.id;

                    var request = $http({
                        method: "DELETE",
                        url: '/myuniversity/badge/deleteSocialBadge',
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/xml'
                        },
                        data: $scope.deleteBadgeData
                    });
                    request.success(function(response) {
                        $('#deleteBadgeMsg').html(response);
                        $timeout(function() {
                            $('#deleteSocialmodel').modal('hide');
                        }, 5000);
                        // loading data again
                        $scope.getSocialBadge();
                    });

                }
                // setting data to edit social badge model.
            $scope.setSocailBadgeModal = function(badge) {

                    var deptError = angular.element('#deptErrorTemp');
                    var descError = angular.element('#descErrorTemp');
                    var noOfEventError = angular
                        .element('#noOfEventErrorTemp');
                    var badgeNameError = angular
                        .element('#badgeNameErrorTemp');
                    deptError.text('');
                    descError.text('');
                    noOfEventError.text('');
                    badgeNameError.text('');

                    var updateSuccess = angular.element("#updateSuccess");
                    updateSuccess.text(" ");
                    $('#badgeId').val(badge.obj.id);
                    $('#badgeNameTemp').val(badge.obj.badgeName);
                    $('#noOfEventTemp').val(badge.obj.numberOfEvents);
                    $('#descriptionTemp').val(badge.obj.badgeDescription);
                    // set the value
                    // console.log(badge.obj);
                    var deptHtml = "";
                    $('#deptPop').html("");
                    for (var i = 0; i < $scope.departments.length; i++) {
                        var flag = false;
                        for (var j = 0; j < badge.obj.departments.length; j++) {
                            if ($scope.departments[i].id == badge.obj.departments[j]) {
                                flag = true;
                                break;
                            }
                        }
                        if (flag) {
                            deptHtml += '<li  class="DeptTemp" style="list-style:none;"><input class="deptValTemp" type="checkbox" value="' +
                                $scope.departments[i].id +
                                '" checked >' +
                                $scope.departments[i].depName +
                                '</li>';
                        } else {
                            deptHtml += '<li  class="DeptTemp" style="list-style:none;"><input class="deptValTemp" type="checkbox" value="' +
                                $scope.departments[i].id +
                                '" >' +
                                $scope.departments[i].depName +
                                '</li>';
                        }
                    }

                    // console.log(deptHtml);

                    $('#deptPop').html(deptHtml);
                    $('#editSocialModel').modal('show');

                }
                // creation of event
            $scope.setEventData = function() {
                $('#editmodel').modal('show');
                $('#myModalLabel').html('Please wait.....');
                var tags = angular.element(".tagVal");
                var interests = angular.element(".interestVal");
                var eventTypes = angular.element("#eventType");
                var advertisement = angular
                    .element(".advertisementVal");
                $scope.event.general.evenType = {};
                $scope.event.general.evenType.id = eventTypes.val();
                $scope.event.general.evenType.eventType = eventTypes
                    .text();
                $scope.event.general.eventCreatedBy = $scope.loggedUserId;
                console.log($scope.event.general.eventCreatedBy);
                $scope.event.general.universityId = $scope.universityId;
                // $scope.event.general.universityId = "1";
                $scope.event.general.published = $scope.checkedPublish;
                console.log("event created with unpublished");
                console.log($scope.event.general.published);
                $scope.event.general.eventFromTime = new Date(angular
                    .element('#eventFromTime').val());
                $scope.event.general.eventToTime = new Date(angular
                    .element('#eventToTime').val());
                $scope.event.tags = [];
                $scope.event.interests = [];
                $scope.event.advertisements = [];

                for (var i = 0; i < tags.length; i++) {
                    if (tags[i].checked) {
                        console.log(tags[i].checked);
                        $scope.event.tags.push(tags[i].value);
                    }
                }
                for (var j = 0; j < interests.length; j++) {
                    if (interests[j].checked) {
                        $scope.event.interests.push(interests[j].value);
                    }
                }

                for (var k = 0; k < advertisement.length; k++) {
                    if (advertisement[k].checked) {
                        $scope.event.advertisements
                            .push(advertisement[k].value);
                    }
                }

                console.log("$scope.event.ads " +
                    angular.toJson($scope.event));
                // getting skiil schedule data
                var startDates = angular.element('.skillStartDate');
                var endDates = angular.element('.skillEndDate');

                for (var i = 0; i < startDates.length; i++) {
                    var ind = startDates[i].attributes['index-val'].value;
                    var dateVal = startDates[i].value;
                    var endDateVal = endDates[i].value;

                    $scope.event.skillSch[ind].startDate = new Date(
                        dateVal);
                    $scope.event.skillSch[ind].endDate = new Date(
                        endDateVal);
                    var todaysDate = ($scope.event.skillSch[ind].endDate - $scope.event.skillSch[ind].startDate);
                    var hours = (todaysDate / (60 * 60 * 1000));
                }

                // remove empty object from skills
                var tempSkillSch = [];
                for (var i = 0; i < $scope.event.skillSch.length; i++) {
                    if ($scope.event.skillSch[i].selected_skills != undefined) {
                        tempSkillSch.push($scope.event.skillSch[i]);
                    }
                }
                $scope.event.skillSch = tempSkillSch;
                // removing empty objects from social badges also

                var tempSocial = [];
                for (var i = 0; i < $scope.event.socialBadge.length; i++) {
                    if ($scope.event.socialBadge[i].badgeId != undefined) {
                        tempSocial.push($scope.event.socialBadge[i]);
                    }
                }
                $scope.event.socialBadge = tempSocial;
                // calling create event service
                var request = $http({
                    method: "GET",
                    url: '/myuniversity/usersDetail/userName'

                });
                request
                    .success(function(response) {
                        $scope.universityId = response.universityId;
                        $scope.event.general.universityId = $scope.universityId;

                        var request = $http({
                            method: "post",
                            url: '/myuniversity/events/createEvent',
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/xml'
                            },
                            data: $scope.event

                        });
                        request
                            .success(function(response) {
                                $('#myModalLabel').html(
                                    response);
                                // clearing form when event
                                // getting created
                                // successfully .
                                if (response == "Event created successfully") {
                                    $scope.event = {};
                                    $scope.skillSch = [];
                                    $scope.categoryName = [];
                                    $scope.skillIndexTemp = 0;
                                    $scope.skillTableRow = 0;
                                    $scope.event.skillSch = [];
                                    $scope.socialIndexTemp = 0;
                                    $scope.event.socialBadge = [];
                                    $scope.socialTableRow = 0;
                                    $scope.eventTypeId = 0;
                                    $scope.checked_social = false;
                                    $scope.checkedPublish = false;
                                    $scope.checked = true;

                                    var skillTable = angular
                                        .element("#skillsTable");
                                    skillTable.html("");
                                    var socialTable = angular
                                        .element("#socialTable");
                                    socialTable.html('');

                                    $("#scrollTag")
                                        .scrollTop(1);
                                    $("#scrollAd").scrollTop(1);
                                    $("#scrollInt")
                                        .scrollTop(1);

                                    for (var i = 0; i < tags.length; i++) {
                                        tags[i].checked = false;
                                    }
                                    for (var i = 0; i < interests.length; i++) {
                                        interests[i].checked = false;
                                    }

                                    for (var i = 0; i < advertisement.length; i++) {
                                        advertisement[i].checked = false;
                                    }
                                

                                }
                                $timeout(function() {
                                    $('#editmodel').modal(
                                        'hide');
                                }, 5000);

                            });
                    });
            };

            // calling create social badge service.
            $scope.createSocialBadges = function() {

                var badgeName = angular.element('#badgeName').val();
                var noOfEvents = angular.element('#noOfEvent').val();
                var badgeDescription = angular.element('#description')
                    .val();

                $scope.newSocialBadge = {};
                $scope.newSocialBadge.general = {};

                $scope.newSocialBadge.general.badgeName = badgeName;
                $scope.newSocialBadge.general.numberOfEvents = noOfEvents;
                $scope.newSocialBadge.general.badgeDescription = badgeDescription;

                $scope.newSocialBadge.departments = [];
                var dept = angular.element(".deptVal");
                for (var i = 0; i < dept.length; i++) {
                    if (dept[i].checked) {
                        $scope.newSocialBadge.departments
                            .push(dept[i].value);

                    }
                }

                var request = $http({
                    method: "post",
                    url: '/myuniversity/badge/createSocialBadge',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/xml'
                    },
                    data: $scope.newSocialBadge
                });
                request
                    .success(function(response) {
                        var createSuccess = angular
                            .element("#createSuccess");
                        createSuccess.text(response);

                        $timeout(
                            function() {
                                createSuccess.text(" ");
                                var badgeName = angular
                                    .element('#badgeName');
                                var noOfEvents = angular
                                    .element('#noOfEvent');
                                var badgeDescription = angular
                                    .element('#description');
                                badgeName.val("");
                                noOfEvents.val("0");
                                badgeDescription.val("");
                                var depts = angular
                                    .element('.deptVal');

                                for (var i = 0; i < depts.length; i++) {
                                    depts[i].checked = false;
                                }

                            }, 5000);
                        if (response == "Social badge created successfully") {

                            $scope.getSocialBadge();
                        }
                    });

            };

            // validating social badge data.
            $scope.validateBadge = function() {

                var isValid = true;
                var id = angular.element('#badgeId').val();
                var badgeName = angular.element('#badgeName').val();
                var noOfEvent = angular.element('#noOfEvent').val();
                var description = angular.element('#description').val();
                var dept = angular.element('.deptVal');

                var deptError = angular.element('#deptError');
                var descError = angular.element('#descError');
                var noOfEventError = angular.element('#noOfEventError');
                var badgeNameError = angular.element('#badgeNameError');

                var flag = false;
                for (var i = 0; i < dept.length; i++) {
                    if (dept[i].checked) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    deptError
                        .text('Please select at least one Department.');
                    deptError.css('color', 'red');
                    isValid = false;
                } else {
                    deptError.text('');
                }

                if (badgeName == '') {
                    badgeNameError.text('Badge name required');
                    badgeNameError.css('color', 'red');
                    isValid = false;
                } else {
                    badgeNameError.text('');
                }

                if (description == '') {
                    descError.text('Event name required');
                    descError.css('color', 'red');
                    isValid = false;
                } else {
                    descError.text('');
                }

                if (noOfEvent == 0) {
                    noOfEventError
                        .text('Please select number of event');
                    noOfEventError.css('color', 'red');
                    isValid = false;
                } else {
                    noOfEventError.text('');
                }

                if (isValid) {
                    $scope.createSocialBadges();
                }

            }

            // validating update social badge screen data.
            $scope.validateEditBadge = function() {

                    var isValid = true;
                    var id = angular.element('#badgeId').val();
                    var badgeName = angular.element('#badgeNameTemp').val();
                    var noOfEvent = angular.element('#noOfEventTemp').val();
                    var description = angular.element('#descriptionTemp')
                        .val();
                    var dept = angular.element('.deptValTemp');

                    var deptError = angular.element('#deptErrorTemp');
                    var descError = angular.element('#descErrorTemp');
                    var noOfEventError = angular
                        .element('#noOfEventErrorTemp');
                    var badgeNameError = angular
                        .element('#badgeNameErrorTemp');

                    $scope.socialBadge.general.id = id;
                    $scope.socialBadge.general.badgeName = badgeName;
                    $scope.socialBadge.general.numberOfEvents = noOfEvent;
                    $scope.socialBadge.general.badgeDescription = description;
                    $scope.socialBadge.departments = [];

                    var flag = false;
                    for (var i = 0; i < dept.length; i++) {
                        if (dept[i].checked) {
                            $scope.socialBadge.departments
                                .push(dept[i].value);
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {
                        deptError
                            .text('Please select at least one Department.');
                        deptError.css('color', 'red');
                        isValid = false;
                    } else {
                        deptError.text('');
                    }

                    if (badgeName == '') {
                        badgeNameError.text('Badge name required');
                        badgeNameError.css('color', 'red');
                        isValid = false;
                    } else {
                        badgeNameError.text('');
                    }

                    if (description == '') {
                        descError.text('Description required');
                        descError.css('color', 'red');
                        isValid = false;
                    } else {
                        descError.text('');
                    }

                    if (noOfEvent == 0) {
                        noOfEventError
                            .text('Please select number of event');
                        noOfEventError.css('color', 'red');
                        isValid = false;
                    } else {
                        noOfEventError.text('');
                    }

                    if (isValid) {
                        $scope.createSocialBadgesTemp();
                    }
                }
                // updating social badge calling update service.
            $scope.createSocialBadgesTemp = function() {

                var id = angular.element('#badgeId').val();
                var badgeName = angular.element('#badgeNameTemp').val();
                var noOfEvent = angular.element('#noOfEventTemp').val();
                var description = angular.element('#descriptionTemp')
                    .val();
                var dept = angular.element('.deptValTemp');

                $scope.socialBadge.general.id = id;
                $scope.socialBadge.general.badgeName = badgeName;
                $scope.socialBadge.general.numberOfEvents = noOfEvent;
                $scope.socialBadge.general.badgeDescription = description;
                $scope.socialBadge.departments = [];

                for (var i = 0; i < dept.length; i++) {
                    if (dept[i].checked) {
                        $scope.socialBadge.departments
                            .push(dept[i].value);
                    }
                }
                var request = $http({
                    method: "post",
                    url: '/myuniversity/badge/updateSocialBadge',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/xml'
                    },
                    data: $scope.socialBadge
                });
                request.success(function(response) {

                    var successMsg = angular.element("#updateSuccess");
                    successMsg.text(response);
                    $scope.getSocialBadge();
                    $timeout(function() {
                        $('#editSocialModel').modal('hide');
                    }, 5000);

                });
            };
            // validating event creation form.
            // check to make sure the form is completely valid
            $scope.submitForm = function(isValid) {
                isValid = true;
                console.log('submiting form');
                var inValid = false;
                var flagSkill = true;
                var flagSocial = true;
                var skillLength = $scope.event.skillSch.length;
                var socialLength = $scope.event.socialBadge.length;
                var assginBadgeError = angular
                    .element('#assginBadgeError');
                var assginSkillError = angular
                    .element('#assginSkillError');
                var assginSocialError = angular
                    .element('#assginSocialError');
                
                var startDates = angular.element('.skillStartDate');
                var endDates = angular.element('.skillEndDate');

                for (var i = 0; i < startDates.length; i++) {

                    var ind = startDates[i].attributes['index-val'].value;
                    var dateVal = startDates[i].value;
                    var endDateVal = endDates[i].value;

                    $scope.event.skillSch[ind].startDate = new Date(
                        dateVal);
                    $scope.event.skillSch[ind].endDate = new Date(
                        endDateVal);

                    if ($scope.event.skillSch[ind].selected_skills != undefined) {
                        if ($scope.event.skillSch[ind].selected_skills == 0 ||
                            $scope.event.skillSch[ind].startDate == 'Invalid Date' ||
                            $scope.event.skillSch[ind].endDate == 'Invalid Date') {
                            flagSkill = false;
                            break;
                        }
                    }
                }
                // removing empty objects from event skill

                if (flagSkill == false &&
                    $scope.event.skillSch.length > 0) {
                    assginSkillError
                        .text('Please fill row data correctly.');
                    assginSkillError.css('color', 'red');
                    isValid = false;
                } else {
                    assginSkillError.text('');
                }
                // validation for social badge

                for (var i = 0; i < $scope.event.socialBadge.length; i++) {

                    if ($scope.event.socialBadge[i].badgeId != undefined) {
                        if ($scope.event.socialBadge[i].badgeId == 0 ||
                            $scope.event.socialBadge[i].description
                            .trim() == '') {
                            flagSocial = false;
                            break;
                        }
                    }
                }
                if (flagSocial == false &&
                    $scope.event.socialBadge.length > 0) {
                    assginSocialError
                        .text('Please fill row data correctly.');
                    assginSocialError.css('color', 'red');
                    isValid = false;
                } else {
                    assginSocialError.text('');
                }
                
              //validating duplicate badges
				var socialbadges = angular.element('.socialBadgeClass');
				var value1, value2;
				for(var i=0;i<socialbadges.length-1;i++){
					var flag=false;
					for(var j=i+1;j<socialbadges.length;j++){
						value1=$(socialbadges[i]).val();
						value2=$(socialbadges[j]).val();
						
						if(value1==value2){
							flag=true;
							break;
						}
					}
					if(flag==true){
						console.log("duplicate values");
						var assginSocialErrorTemp = angular.element('#assginSocialError');
						assginSocialErrorTemp.text('You already added this badge.');
						assginSocialErrorTemp.css('color', 'red');
						isValid = false;
						//break;
					}
				}
                
                
                var eventName = angular.element('#eventName').val();
                var eventLoc = angular.element('#eventLoc').val();
                var eventLongDesc = angular.element('#eventLongDesc')
                    .val();
                var KeySearch = angular.element('#keySearch').val();
                var eventType = angular.element('#eventType').val();
                var capacity = angular.element('#capacity').val();
                var eventFromTime = angular.element('#eventFromTime')
                    .val();
                var eventToTime = angular.element('#eventToTime').val();
                var tags = angular.element('.tagVal');

                var interests = angular.element('.interestVal');
                var advertisement = angular
                    .element('.advertisementVal');

                var eventNameError = angular.element('#eventNameError');
                var eventLocError = angular.element('#eventLocError');
                var eventLongError = angular.element('#eventLongError');
                var keySearchError = angular.element('#keySearchError');
                var eventStartError = angular
                    .element('#eventStartError');
                var eventEndError = angular.element('#eventEndError');
                var eventTypeError = angular.element('#eventTypeError');
                var eventCapacityError = angular
                    .element('#eventCapacityError');
                var tagError = angular.element('#tagError');

                var interestError = angular.element('#interestError');
                var advertisementError = angular
                    .element('#advertisementError');
                
               
                console.log("advertisemtent" +advertisement.length);
                
                
                var Addflag = false;
                for (var i = 0; i < advertisement.length; i++) {
                    if (advertisement[i].checked) {
                        Addflag = true;
                        break;
                    }
                }
                if (Addflag == false) {
                    advertisementError
                        .text('Please select at least one Advertisement.');
                    advertisementError.css('color', 'red');
                    isValid = false;
                } else {
                    advertisementError.text('');
                }
                
                
                
                if(Addflag == false && advertisement.length == 0){
               	    advertisementError.text('Create at least one Advertisement.');
                }

                var flag = false;
                for (var i = 0; i < tags.length; i++) {
                    if (tags[i].checked) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false) {
                    tagError.text('Please select at least one Tag.');
                    tagError.css('color', 'red');
                    isValid = false;
                } else {
                    tagError.text('');
                }

                var flag1 = false;

                for (var i = 0; i < interests.length; i++) {
                    if (interests[i].checked) {
                        flag1 = true;
                        break;
                    }
                }
                if (flag1 == false) {
                    interestError
                        .text('Please select at least one Interest.');
                    interestError.css('color', 'red');
                    isValid = false;
                } else {
                    interestError.text('');
                }

                if (skillLength == 0 && socialLength == 0) {
                    assginBadgeError
                        .text('Please fill data for at least one badge.');
                    assginBadgeError.css('color', 'red');
                    isValid = false;
                } else {
                    assginBadgeError.text('');
                }

                if (eventName == '') {
                    eventNameError.text('Event name required');
                    eventNameError.css('color', 'red');
                    isValid = false;
                } else {
                    eventNameError.text('');
                }

                if (eventLoc == '') {
                    eventLocError.text('Event location required');
                    eventLocError.css('color', 'red');
                    isValid = false;
                } else {
                    eventLocError.text('');
                }

                if (eventLongDesc == '') {
                    eventLongError.text('Event description required');
                    eventLongError.css('color', 'red');
                    isValid = false;
                } else {
                    eventLongError.text('');
                }

                if (KeySearch == '') {
                    keySearchError.text('Keywords required');
                    keySearchError.css('color', 'red');
                    isValid = false;
                } else {
                    keySearchError.text('');
                }

                if (eventType == 0) {
                    eventTypeErr
                    or.text('Please select event type.');
                    eventTypeError.css('color', 'red');
                    isValid = false;
                } else {
                    eventTypeError.text('');
                }

                if (eventFromTime == "") {
                    eventStartError.text('Event start date required');
                    eventStartError.css('color', 'red');
                    isValid = false;
                } else {
                    eventStartError.text('');
                }

                if (eventToTime == "") {
                    eventEndError.text('Event End date required.');
                    eventEndError.css('color', 'red');
                    isValid = false;
                } else {
                    eventEndError.text('');
                }

                if (capacity == "") {
                    eventCapacityError.text('Event capacity required.');
                    eventCapacityError.css('color', 'red');
                    isValid = false;
                } else if (isNaN(capacity) || capacity < 1) {
                    eventCapacityError
                        .text('Please enter valid capacity');
                    eventCapacityError.css('color', 'red');
                    isValid = false;

                } else {
                    eventCapacityError.text('');
                }
                
                 
                console.log("valid" + isValid);
                if (isValid) {

                    $scope.setEventData();
                }
            };

            // getting data for building the form
            $scope.getAllScreenData = function() {
                var request = $http({
                    method: "get",
                    url: '/myuniversity/events/getFilterItemsData',
                });
                console.log(request);
                request
                    .success(function(response) {
                        $scope.tags = response.tags;
                        $scope.interests = response.interests;
                        $scope.category = response.skillsCategory;
                        $scope.advertisement = response.advertisement;

                        console.log("add data");
                        console.log($scope.advertisement);
                        for (var i = 0; i < response.skillsCategory.length; i++) {
                            for (var j = 0; j < response.skillsCategory[i].skiills.length; j++) {
                                $scope.skills.push(response.skillsCategory[i].skiills[j]);
                            }
                        }
                    });
            };
            // getting social badge data.
            $scope.getSocialBadge = function() {

                var request = $http({
                    method: "get",
                    url: '/myuniversity/badge/getAlldepartment',
                });
                request
                    .success(function(response) {
                        $scope.departments = response;

                        var requestTemp = $http({
                            method: "get",
                            url: '/myuniversity/badge/getSocialBadgeData',
                        });
                        requestTemp
                            .success(function(response) {
                                $scope.SocialBadge = response;
                                console.log($scope.SocialBadge);
                                for (var i = 0; i < response.length; i++) {
                                    var depttem = "";
                                    for (var j = 0; j < response[i].departments.length; j++) {

                                        for (var k = 0; k < $scope.departments.length; k++) {
                                            if (response[i].departments[j] == $scope.departments[k].id) {
                                                depttem += $scope.departments[k].depName +
                                                    ",";
                                            }
                                        }
                                    }
                                    response[i].deptTemp = depttem
                                        .substring(
                                            0,
                                            depttem.length - 1);

                                }
                                $scope.SocialBadge = response;
                                console.log('social badges');
                                console.log($scope.SocialBadge);
                            });
                    });
            };
            // event screen clearing.with clear button.

            $scope.clearEventScreen = function() {
            	 	$scope.checked = true;
                   	$scope.eventForm = {};
                    var tags = angular.element(".tagVal");
                    var interests = angular.element(".interestVal");
                    var advertisement = angular
                        .element(".advertisementVal");
                    $scope.event = {};
                    $scope.skillSch = [];
                    $scope.categoryName = [];
                    $scope.skillIndexTemp = 0;
                    $scope.skillTableRow = 0;
                    $scope.event.skillSch = [];
                    $scope.socialIndexTemp = 0;
                    $scope.event.socialBadge = [];
                    $scope.socialTableRow = 0;
                    $scope.eventTypeId = 0;
                    $scope.checked_social = false;
                    $scope.checkedPublish = false;
                   

                    var skillTable = angular.element("#skillsTable");
                    skillTable.html("");
                    var socialTable = angular.element("#socialTable");
                    socialTable.html('');

                    for (var i = 0; i < advertisement.length; i++) {
                        advertisement[i].checked = false;
                    }

                    for (var i = 0; i < tags.length; i++) {
                        tags[i].checked = false;
                    }
                    for (var i = 0; i < interests.length; i++) {
                        interests[i].checked = false;
                    }

                    var assginBadgeError = angular
                        .element('#assginBadgeError');
                    var assginSkillError = angular
                        .element('#assginSkillError');
                    var assginSocialError = angular
                        .element('#assginSocialError');
                    var eventNameError = angular.element('#eventNameError');
                    var eventLocError = angular.element('#eventLocError');
                    var eventLongError = angular.element('#eventLongError');
                    var keySearchError = angular.element('#keySearchError');
                    var eventStartError = angular
                        .element('#eventStartError');
                    var eventEndError = angular.element('#eventEndError');
                    var eventTypeError = angular.element('#eventTypeError');
                    var eventCapacityError = angular
                        .element('#eventCapacityError');
                    var tagError = angular.element('#tagError');
                    var interestError = angular.element('#interestError');
                    var advertisementError = angular
                        .element('#advertisementError');

                    $("#scrollTag").scrollTop(1);
                    $("#scrollAd").scrollTop(1);
                    $("#scrollInt").scrollTop(1);

                    assginBadgeError.text('');
                    assginSkillError.text('');
                    assginSocialError.text('');
                    eventNameError.text('');
                    eventLocError.text('');
                    eventLongError.text('');
                    eventStartError.text('');
                    eventEndError.text('');
                    keySearchError.text('');
                    eventTypeError.text('');
                    eventCapacityError.text('');
                    tagError.text('');
                    interestError.text('');
                    advertisementError.text('');

                    // $scope.event.general.eventFromTime={text:undefined};
                    // $scope.event.general.eventToTime = null;

                }
                // populating all departments at init.
            $scope.getAllDepartments = function() {
                var request = $http({
                    method: "get",
                    url: '/myuniversity/badge/getAlldepartment',
                });
                request.success(function(response) {
                    $scope.departments = response;
                });
            };
            // removing skill row.
            $scope.removeRow = function(index) {
                    $scope.event.skillSch[index] = {};
                    var rows = angular.element('.skillRow');
                    for (var i = 0; i < rows.length; i++) {
                        if ($(rows[i]).attr('ind') == index) {
                            $(rows[i]).remove();
                        }
                    }
                    // rearranging the serial number
                    var sr = angular.element('.skillRowSr');
                    for (var i = 0; i < sr.length; i++) {
                        $(sr[i]).html(i + 1);
                    }

                }
                // removing social row.
            $scope.removeSocialRow = function(indexSocial) {
                    // making deleted object empty
                    $scope.event.socialBadge[indexSocial] = {};
                    var rows = angular.element('.socialRow');
                    for (var i = 0; i < rows.length; i++) {
                        if ($(rows[i]).attr('indSocial') == indexSocial) {
                            $(rows[i]).remove();
                        }
                    }

                    // rearranging social row index
                    var sr = angular.element('.socialRowSr');
                    for (var i = 0; i < sr.length; i++) {
                        $(sr[i]).html(i + 1);
                    }
                }
                // calculating duration.
            $scope.durationCal = function(currentIndex) {

                var startDates = angular.element('.skillStartDate');
                var endDates = angular.element('.skillEndDate');

                console.log(currentIndex);

                var currentIndexTemp;
                for (var i = 0; i < startDates.length; i++) {
                    console.log($(startDates[i]).attr('index-val'));
                    if ($(startDates[i]).attr('index-val') == currentIndex) {
                        currentIndexTemp = i;
                    }
                }

                var dateVal = new Date(
                    startDates[currentIndexTemp].value);
                var endDateVal = new Date(
                    endDates[currentIndexTemp].value);

                console.log(dateVal);
                console.log(endDateVal);
                if (startDates[currentIndexTemp].value.trim() != '' &&
                    endDates[currentIndexTemp].value.trim() != '') {
                    var todaysDate = (endDateVal - dateVal);
                    var hours = (todaysDate / (60 * 60 * 1000));
                    console.log("Math.floor(hours)" +Math .floor(hours));
                    $scope.skillSch[currentIndex].duration = Math
                        .floor(hours);

                } else {
                    $scope.skillSch[currentIndex].duration = "";

                }

            }

            // adding new row in skills
            $scope.addNewRowSkill = function() {
                var dateflag = true;
                var assginSkillError = angular
                    .element('#assginSkillError');
                // check if startdate and end date is selected then only
                // allow them to add the rows
                var eventStartTime = angular.element('#eventFromTime')
                    .val();
                var eventEndTime = angular.element('#eventToTime')
                    .val()

                if (eventStartTime == undefined &&
                    eventEndTime == undefined) {

                } else {
                    if (eventStartTime.trim() == "" ||
                        eventEndTime.trim() == "") {

                        dateflag = false;
                        assginSkillError
                            .text("Please select event start date and end date");
                        assginSkillError.css("color", "red");

                    } else {
                        assginSkillError.text('');
                    }
                }

                if (dateflag) {
                    var skillTable = angular.element("#skillsTable");
                    console.log($scope.skillIndexTemp);
                    var skillIndex = $scope.skillIndexTemp++;

                    $scope.event.skillSch[skillIndex] = {};
                    $scope.event.skillSch[skillIndex].selected_skills = 0;
                    $scope.event.skillSch[skillIndex].startDate = "";
                    $scope.event.skillSch[skillIndex].endDate = "";
                    $scope.skillSch[skillIndex] = {};
                    $scope.skillSch[skillIndex].duration = "";
                    var text = '<tr class="skillRow" ind="' +
                        skillIndex +
                        '"><td class="skillRowSr">' +
                        (++$scope.skillTableRow) +
                        '</td>' +
                        '<td>' +
                        '<select id="skills" class="form-control" ng-model="event.skillSch[' +
                        skillIndex +
                        '].selected_skills" ng-change="populateCategory(event.skillSch[' +
                        skillIndex +
                        '].selected_skills,' +
                        skillIndex +
                        ')"> ' +
                        '<option value="0">Select Skills</option>' +
                        '<option ng-repeat="item in skills" value="{{item.id}}">{{item.skillName}}</option>' +
                        '</select>' +
                        '</td>' +
                        '<td><div class="datepicker_my1 input-group date">' +
                        '<input type="text" class="form-control skillStartDate" ng-model="event.skillSch[' +
                        skillIndex +
                        '].startDate" index-val="' +
                        skillIndex +
                        '" ng-blur="durationCal(' +
                        skillIndex +
                        ')">' +
                        '<span class="input-group-addon">' +
                        '<span class="glyphicon glyphicon-calendar"></span></span></div>' +
                        '</td>' +
                        '<td><div class="datepicker_my2 input-group date">' +
                        '<input type="text" class="form-control skillEndDate" ng-model="event.skillSch[' +
                        skillIndex +
                        '].endDate" index-val="' +
                        skillIndex +
                        '" ng-blur="durationCal(' +
                        skillIndex +
                        ')"/>' +
                        '<span class="input-group-addon">' +
                        '<span class="glyphicon glyphicon-calendar"></span></span></div>' +
                        '</td>' +
                        '<td>' +
                        '{{skillSch[' +
                        skillIndex +
                        '].duration}}</td>' +
                        '<td>{{categoryName[' +
                        skillIndex +
                        ']}} </td>' +
                        '<td><a data-toggle="modal"> <span class="glyphicon glyphicon-trash" ng-click="removeRow(' +
                        skillIndex + ')"></span></a></td></tr>';

                    var selectMenu = $compile(text);
                    var content = selectMenu($scope);
                    skillTable.append(content);

                    var sr = angular.element('.skillRowSr');
                    for (var i = 0; i < sr.length; i++) {
                        $(sr[i]).html(i + 1);
                    }

                }
            };
            // adding new row in social badge.
            $scope.addNewRowSocial = function() {
                var socialTable = angular.element("#socialTable");
                var tempIndex = $scope.socialIndexTemp++;
                $scope.event.socialBadge[tempIndex] = {};
                $scope.event.socialBadge[tempIndex].badgeId = 0;
                $scope.event.socialBadge[tempIndex].description = ""
                console.log($scope.event.socialBadge[tempIndex]);
                var text = '<tr class="socialRow" indSocial="' +
                    tempIndex +
                    '"><td class="socialRowSr">' +
                    (++$scope.socialTableRow) +
                    '</td>' +
                    '<td>' +
                    '<select id="socialBadge" class="form-control socialBadgeClass" ng-model="event.socialBadge[' +
                    tempIndex +
                    '].badgeId" > ' +
                    '<option value="0">Select Badge Name</option>' +
                    '<option ng-repeat="item in SocialBadge" value="{{item.id}}">{{item.badgeName}}</option>' +
                    '</select>' +
                    '</td>' +
                    '<td><textarea class="form-control" maxlength="50" rows="1" id="Desc" ng-model="event.socialBadge[' +
                    tempIndex +
                    '].description"></textarea></td>' +
                    '<td><a data-toggle="modal"> <span class="glyphicon glyphicon-trash" ng-click="removeSocialRow(' +
                    tempIndex + ')"></span></a></td></tr>';

                var selectMenu = $compile(text);
                var content = selectMenu($scope);
                socialTable.append(content);
                // rearranging social row sr index
                var sr = angular.element('.socialRowSr');
                for (var i = 0; i < sr.length; i++) {
                    $(sr[i]).html(i + 1);
                }

            };

     
            // creation of path finder.
            $scope.setResourceData = function() {
                $scope.resource.createdDate = null;

                var request = $http({
                    method: "post",
                    url: '/myuniversity/resource/createResource',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/xml'
                    },
                    data: $scope.resource
                });
                request.success(function(response) {
                    $scope.getAllResourcesData();
                    $scope.resource.title = "";
                    $scope.resource.notes = "";
                });
            };

            // getting all ath finder data.
            $scope.getAllResourcesData = function() {

                var dataSend = {};
                dataSend.pageNumber = 1;
                dataSend.noOfRecords = 10;
                var request = $http({
                    method: "post",
                    url: '/myuniversity/resource/getAllResources',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/xml'
                    },
                    data: dataSend
                });
                request.success(function(response) {
                    $scope.resources = response.resources;
                });

            };
            // populating category
            $scope.populateCategory = function(indexVal, rowIndex) {

                var categoryNameTemp = "";
                var skill_temp = $scope.skills[indexVal - 1];

                for (var i = 0; i < $scope.category.length; i++) {
                    for (var j = 0; j < $scope.category[i].skiills.length; j++) {
                        if ($scope.category[i].skiills[j].skillName == skill_temp.skillName) {
                            categoryNameTemp = $scope.category[i].categoryName;
                        }

                    }
                }
                // log the category
                $scope.categoryName[rowIndex] = categoryNameTemp;
            };

            // get event types
            $scope.getEventType = function() {
                var request = $http({
                    method: "post",
                    url: '/myuniversity/events/getEventType',
                });
                request.success(function(response) {
                    $scope.eventTypes = response;
                });
            };

            // logging out from application
            $scope.logout = function() {
                $scope.$emit('event:logoutRequest');
                $location.path("/login");
            };
            // logging into application.
            $scope.login = function(credentials) {
                $scope.$emit('event:loginRequest', credentials.email,
                    credentials.password);
                $location.path($rootScope.navigateTo);
            };
            // forgot password.
            $scope.forgotPasswd = function() {
                var forgotPassLabel = angular.element("#errorpwd");
                var request = $http({
                    method: "POST",
                    url: "/myuniversity/userRegistration/forgotPassword",
                    data: {
                        "email": $scope.passwordRequest,
                        "type": "web"
                    }
                });
                request.success(function(response) {
                    forgotPassLabel.text(response);

                });
            }

        });