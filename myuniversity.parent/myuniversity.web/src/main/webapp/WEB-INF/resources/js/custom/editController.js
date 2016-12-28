app
		.controller(
				'editController',
				function($rootScope, $scope, $location, $http, $filter, $q,
						$sce, localStorageService, $timeout, $compile) {
					/*
					 * $scope.goDashboard = function() { $timeout(function() {
					 * location.href = "#/"; }, 6000); }
					 */

					// edit event
					// populating edit event data
					$scope.getEditEventData = function() {
						console.log("Calling edit event data");
						var ele = window.location.href.split("/");
						var len = window.location.href.split("/").length;
						var eventId = ele[len - 1];
						$scope.eventdataEdit = {};
						$scope.eventdataEdit.eventId = eventId;

						// first get all screen data
						var request = $http({
							method : "get",
							url : '/myuniversity/events/getFilterItemsData',
						});
						request
								.success(function(response) {

									$scope.tags = response.tags;
									$scope.interests = response.interests;
									$scope.category = response.skillsCategory;
									$scope.advertisement = response.advertisement;

									for (var i = 0; i < response.skillsCategory.length; i++) {
										for (var j = 0; j < response.skillsCategory[i].skiills.length; j++) {
											$scope.skills
													.push(response.skillsCategory[i].skiills[j]);
										}
									}
									//
									var request = $http({
										method : "POST",
										url : '/myuniversity/events/getEventDetails',
										headers : {
											'Content-Type' : 'application/json',
											'Accept' : 'application/xml'
										},
										data : $scope.eventdataEdit
									});
									request
											.success(function(response) {
												console.log("tag data");
												console.log(response);
												temp = response;
												$scope.eventEdit = {};
												$scope.eventEdit.badgeDto = temp.badgeDto;
												$scope.eventEdit.capacity = temp.capacity;
												$scope.eventEdit.eventAddress = temp.eventAddress;
												$scope.eventEdit.eventFromTime = temp.eventFromTime;
												$scope.eventEdit.eventLongDesc = temp.eventLongDesc;
												$scope.eventEdit.eventName = temp.eventName;
												$scope.eventEdit.eventShortDesc = temp.eventShortDesc;
												$scope.eventEdit.eventToTime = temp.eventToTime;
												$scope.eventEdit.eventTypeId = temp.eventTypeId;
												$scope.eventEdit.featured = temp.featured;
												$scope.eventEdit.id = temp.id;
												$scope.eventEdit.interest = temp.interest;
												$scope.eventEdit.keyword = temp.keyword;
												$scope.eventEdit.skillBadgeRowDto = temp.skillBadgeRowDto;
												$scope.eventEdit.sponsor = temp.sponsor;
												$scope.eventEdit.tags = temp.tags;
												$scope.eventEdit.advertisements = temp.advertisements;
												if (temp.published == false) {
													console.log("Prasad");
													$scope.checkedPublishEdit = false;
												} else {
													$scope.checkedPublishEdit = true;
												}
												var date = new Date(
														response.eventFromTime);
												var sHour = date.getHours();
												var sAmPm = "AM";
												if (date.getHours() > 12) {
													sAmPm = "PM";
													sHour = sHour - 12;
												} else if (sHour == 0) {
													sHour = "12";
												}
												$scope.eventFromDateEdit = (date
														.getMonth() + 1)
														+ '/'
														+ date.getDate()
														+ '/'
														+ date.getFullYear()
														+ ' '
														+ sHour
														+ ":"
														+ date.getMinutes()
														+ " " + sAmPm;

												var dateEnd = new Date(
														response.eventToTime);
												var eHour = dateEnd.getHours();
												var eAmPm = "AM";
												if (dateEnd.getHours() > 12) {
													eAmPm = "PM";
													eHour = eHour - 12;
												} else if (eHour == 0) {
													eHour = "12";
												}

												$scope.eventToDateEdit = (dateEnd
														.getMonth() + 1)
														+ '/'
														+ dateEnd.getDate()
														+ '/'
														+ dateEnd.getFullYear()
														+ ' '
														+ eHour
														+ ":"
														+ dateEnd.getMinutes()
														+ " " + eAmPm;

												if (response.evenType == "PRIVATE") {
													$scope.eventTypeId = 2;
												} else {
													$scope.eventTypeId = 1;
												}
												// tagValEdit
												var tagValEdit = angular
														.element('.tagValEdit');
												for (var j = 0; j < tagValEdit.length; j++) {
													for ( var i in $scope.eventEdit.tags) {
														if (tagValEdit[j].value == i
																&& $scope.eventEdit.tags[i] == true) {
															tagValEdit[j].checked = true;
														}
													}
												}// end of tag
												// interest
												var interestValEdit = angular
														.element('.interestValEdit');
												for (var j = 0; j < interestValEdit.length; j++) {
													for (var i = 0; i < $scope.eventEdit.interest.length; i++) {
														if (interestValEdit[j].value == $scope.eventEdit.interest[i]) {
															interestValEdit[j].checked = true;
														}
													}
												}// end of interest

												// advertisement
												var advertisementValEdit = angular
														.element('.advertisementValEdit');
												for (var j = 0; j < advertisementValEdit.length; j++) {
													for (var i = 0; i < $scope.eventEdit.advertisements.length; i++) {
														if (advertisementValEdit[j].value == $scope.eventEdit.advertisements[i].id) {
															advertisementValEdit[j].checked = true;
														}
													}
												}// end of advertisement

												// social badges
												
												if ($scope.eventEdit.skillBadgeRowDto.length > 0) {
												var skillTable = angular
														.element("#skillsTableEdit");
												console.log("skillTable" +skillTable);
												$scope.skillIndexTemp = 0;
												var skillIndex = $scope.skillIndexTemp++;
												var text = '';
												$scope.checkedEdit=true;

												for (var i = 0; i < $scope.eventEdit.skillBadgeRowDto.length; i++) {
													$scope.event.skillSch[skillIndex] = {};
													//
													var date = new Date(
															$scope.eventEdit.skillBadgeRowDto[i].eventStartTime);
													var sHour = date.getHours();
													var sAmPm = "AM";
													if (date.getHours() > 12) {
														sAmPm = "PM";
														sHour = sHour - 12;
													} else if (sHour == 0) {
														sHour = "12";
													}
													var eventFromDateSkill = (date
															.getMonth() + 1)
															+ '/'
															+ date.getDate()
															+ '/'
															+ date
																	.getFullYear()
															+ ' '
															+ sHour
															+ ":"
															+ date.getMinutes()
															+ " " + sAmPm;

													var dateEnd = new Date(
															$scope.eventEdit.skillBadgeRowDto[i].eventEndTime);
													var eHour = dateEnd
															.getHours();
													var eAmPm = "AM";
													if (dateEnd.getHours() > 12) {
														eAmPm = "PM";
														eHour = eHour - 12;
													} else if (eHour == 0) {
														eHour = "12";
													}

													var eventToDateSkill = (dateEnd
															.getMonth() + 1)
															+ '/'
															+ dateEnd.getDate()
															+ '/'
															+ dateEnd
																	.getFullYear()
															+ ' '
															+ eHour
															+ ":"
															+ dateEnd
																	.getMinutes()
															+ " " + eAmPm;

													// setting event times
													var todaysDate = (dateEnd - date);
													var hours = (todaysDate / (60 * 60 * 1000));
													console.log("duration of edit" +hours);
													$scope.event.skillSch[skillIndex].selected_skills = $scope.eventEdit.skillBadgeRowDto[i].skillId;
													$scope.event.skillSch[skillIndex].startDate = eventFromDateSkill;
													$scope.event.skillSch[skillIndex].endDate = eventToDateSkill;
													$scope.skillSch[skillIndex] = {};
													$scope.skillSch[skillIndex].duration =  Math.floor(hours);

													text += '<tr class="skillRowEdit" ind="'
															+ skillIndex
															+ '"><td class="skillRowSrEdit">'
															+ (++$scope.skillTableRow)
															+ '</td>'
															+ '<td>'
															+ '<select class="skills form-control" ng-model="event.skillSch['
															+ skillIndex
															+ '].selected_skills" ng-init="populateCategoryEdit(event.skillSch['
															+ skillIndex
															+ '].selected_skills,'
															+ skillIndex
															+ ')"> '
															+ '<option value="0">Select Skills</option>'
															+ '<option ng-repeat="item in skills" value="{{item.id}}" ng-selected="{{item.id==event.skillSch['
															+ skillIndex
															+ '].selected_skills}}">{{item.skillName}}</option>'
															+ '</select>'
															+ '</td>'
															+ '<td><div class="datepicker_my1_edit input-group date">'
															+ '<input type="text" class="form-control skillStartDateEdit" ng-model="event.skillSch['
															+ skillIndex
															+ '].startDate" index-val="'
															+ skillIndex
															+ '" ng-blur="durationCalEdit('
															+ skillIndex
															+ ')">'
															+ '<span class="input-group-addon">'
															+ '<span class="glyphicon glyphicon-calendar"></span></span></div>'
															+ '</td>'
															+ '<td><div class="datepicker_my2_edit input-group date">'
															+ '<input type="text" class="form-control skillEndDateEdit" ng-model="event.skillSch['
															+ skillIndex
															+ '].endDate" index-val="'
															+ skillIndex
															+ '" ng-blur="durationCalEdit('
															+ skillIndex
															+ ')"/>'
															+ '<span class="input-group-addon">'
															+ '<span class="glyphicon glyphicon-calendar"></span></span></div>'
															+ '</td>'
															+ '<td>'
															+ '{{skillSch['
															+ skillIndex
															+ '].duration}}</td>'
															+ '<td>{{categoryName['
															+ skillIndex
															+ ']}} </td>'
															+ '<td><a data-toggle="modal"> <span class="glyphicon glyphicon-trash" ng-click="removeRowEdit('
															+ skillIndex
															+ ')"></span></a></td></tr>';

													skillIndex++;
												}
											
												$scope.skillIndexTemp = skillIndex;
												//
												var selectMenu = $compile(text);
												var content = selectMenu($scope);
												skillTable.append(content);
												
											}

												// setting social badges
												console.log('event data');
												console
														.log($scope.eventEdit.badgeDto);

												if ($scope.eventEdit.badgeDto.length > 0) {
													var socialTable = angular
															.element("#socialTableEdit");
													$scope.socialTableRow = 0;
													$scope.socialIndexTemp = 0;
													var tempIndex = $scope.socialIndexTemp++;
													var text = '';
													$scope.checked_social_edit = true;

													for (var i = 0; i < $scope.eventEdit.badgeDto.length; i++) {
														$scope.event.socialBadge[tempIndex] = {};
														$scope.event.socialBadge[tempIndex].badgeId = $scope.eventEdit.badgeDto[i].socialBadgeId;
														$scope.event.socialBadge[tempIndex].description = $scope.eventEdit.badgeDto[i].description;
														console
																.log($scope.event.socialBadge[tempIndex]);

														text += '<tr class="socialRowEdit" indSocial="'
																+ tempIndex
																+ '"><td class="socialRowSrEdit">'
																+ (++$scope.socialTableRow)
																+ '</td>'
																+ '<td>'
																+ '<select id="socialBadge" class="form-control socialClass" ng-change="validateDuplcateSocialBadges()" ng-model="selected"> '
																+ '<option value="0">Select Badge Name</option>'
																+ '<option ng-repeat="item in SocialBadge" value="{{item.id}}" ng-selected="{{item.id==event.socialBadge['
																+ tempIndex
																+ '].badgeId}}">{{item.badgeName}}</option>'
																+ '</select>'
																+ '</td>'
																+ '<td><textarea class="form-control" maxlength="50" rows="1" id="Desc" ng-model="event.socialBadge['
																+ tempIndex
																+ '].description"></textarea></td>'
																+ '<td><a data-toggle="modal"> <span class="glyphicon glyphicon-trash" ng-click="removeSocialRowEdit('
																+ tempIndex
																+ ')"></span></a></td></tr>';

														tempIndex++;
													}

													$scope.socialIndexTemp = tempIndex;

													console
															.log("Slected data ::");
													console
															.log($scope.event.socialBadge);
													var selectMenu = $compile(text);
													var content = selectMenu($scope);
													socialTable.append(content);
												}
											});
									// end of edit
								});

					}
					// end of getting event data for edit
					// $scope.getEditEventData();

					// updating edit event
					$scope.goDashboard = function() {
						$timeout(function() {
							location.href = "#/";
						}, 6000);
					}

					$scope.updateEvent = function() {

						$('#editEventModel').modal('show');
						$('#editEventLabel').html('Please wait.....');

						$scope.eventEdit.badgeDto = [];
						$scope.eventEdit.skillBadgeRowDto = [];
						$scope.eventEdit.eventTypeId = $scope.eventTypeId;
						$scope.eventEdit.published = $scope.checkedPublishEdit;
						var tags = angular.element(".tagValEdit");
						var interests = angular.element(".interestValEdit");
						var advertisement = angular
								.element(".advertisementValEdit");
						$scope.eventEdit.tags = [];
						$scope.eventEdit.interest = [];
						$scope.eventEdit.advertisements = [];

						for (var i = 0; i < tags.length; i++) {
							if (tags[i].checked) {
								console.log(tags[i].checked);
								$scope.eventEdit.tags.push(tags[i].value);
							}
						}
						for (var j = 0; j < interests.length; j++) {
							if (interests[j].checked) {
								console.log(interests[j].checked);
								$scope.eventEdit.interest
										.push(interests[j].value);
							}
						}

						for (var k = 0; k < advertisement.length; k++) {
							if (advertisement[k].checked) {
								$scope.eventEdit.advertisements
										.push(advertisement[k].value);
							}
						}

						var socialRowSr = angular.element('.socialRowEdit');
						for (var i = 0; i < socialRowSr.length; i++) {
							$scope.eventEdit.badgeDto[i] = {};
							$scope.eventEdit.badgeDto[i].badgeId = socialRowSr[i].children[1].children[0].value;
							$scope.eventEdit.badgeDto[i].description = socialRowSr[i].children[2].children[0].value;
						}

						console.log('scocial rows update');
						console.log($scope.eventEdit.badgeDto);

						var skillRow = angular.element('.skillRowEdit');
						for (var i = 0; i < skillRow.length; i++) {
							$scope.eventEdit.skillBadgeRowDto[i] = {};
							$scope.eventEdit.skillBadgeRowDto[i].selected_skills = skillRow[i].children[1].children[0].value;
							$scope.eventEdit.skillBadgeRowDto[i].startDate = new Date(
									skillRow[i].children[2].children[0].children[0].value)
									.getTime();
							$scope.eventEdit.skillBadgeRowDto[i].endDate = new Date(
									skillRow[i].children[3].children[0].children[0].value)
									.getTime();
						}
						var sdate = new Date(angular.element(
								'#eventFromTimeEdit').val());
						var edate = new Date(angular
								.element('#eventToTimeEdit').val());
						console.log(sdate);
						$scope.eventEdit.eventFromTime = sdate;
						$scope.eventEdit.eventToTime = edate;
						console.log("Request for edit");
						console.log($scope.eventEdit);
						var request = $http({
							method : "post",
							url : '/myuniversity/events/updateEvent',
							headers : {
								'Content-Type' : 'application/json',
								'Accept' : 'application/xml'
							},
							data : $scope.eventEdit
						});
						request.success(function(response) {
							if (response == "Event updated successfully") {
								$('#editEventLabel').html(response);
							} else {
								$('#editEventErrorLabel').html(response);
							}
							$scope.goDashboard();
							$timeout(function() {
								$('#editEventModel').modal('hide');
							}, 5000);
						});

					}// end of update event

					// validating update data

					$scope.submitEditForm = function() {
						console.log("Submitting");
						var isValid = true;
						var eventName = angular.element('#eventNameEdit').val();
						var eventLoc = angular.element('#eventLocEdit').val();
						var eventLongDesc = angular.element(
								'#eventLongDescEdit').val();
						var KeySearch = angular.element('#keySearchEdit').val();
						var eventType = angular.element('#eventTypeEdit').val();
						var capacity = angular.element('#capacityEdit').val();
						var eventFromTime = angular.element(
								'#eventFromTimeEdit').val();
						var eventToTime = angular.element('#eventToTimeEdit')
								.val();

						var editTags = angular.element('.tagValEdit');
						var editInterests = angular.element('.interestValEdit');
						var tagEditError = angular.element('#tagEditError');
						var interestEditError = angular
								.element('#interestEditError');

						var eventNameError = angular
								.element('#eventNameErrorEdit');
						var eventLocError = angular
								.element('#eventLocErrorEdit');
						var eventLongError = angular
								.element('#eventLongErrorEdit');
						var keySearchError = angular
								.element('#keySearchErrorEdit');
						var eventStartError = angular
								.element('#eventStartErrorEdit');
						var eventEndError = angular
								.element('#eventEndErrorEdit');
						var eventTypeError = angular
								.element('#eventTypeErrorEdit');
						var eventCapacityError = angular
								.element('#eventCapacityErrorEdit');
						var checkedErrorEdit = angular
								.element('#checkedErrorEdit');
						var assginSkillErrorEdit = angular
								.element('#assginSkillErrorEdit');
						var assginSocialErrorEdit = angular
								.element('#assginSocialErrorEdit');

						
						var skillRow = angular.element('.skillRowEdit');
						var socialRowSr = angular.element('.socialRowEdit');
							
												
						if (!$scope.checkedEdit
								&& !$scope.checked_social_edit) {
							console.log("Not checked any badge");
							checkedErrorEdit
									.text('At least one badge should be checked');
							checkedErrorEdit.css('color', 'red');
							console.log("not coming");
							isValid = false;
						} else {
							checkedErrorEdit.text('');
						}
						
						if($scope.checkedEdit && skillRow.length==0){
							console.log("checked one");
							assginSkillErrorEdit.text('Please fill data for at least one badge.');
							assginSkillErrorEdit.css('color', 'red');
							isValid = false;
						} else {
							assginSkillErrorEdit.text('');
						}
						
						if($scope.checked_social_edit && socialRowSr.length==0){
							console.log("checked one");
							assginSocialErrorEdit.text('Please fill data for at least one badge.');
							assginSocialErrorEdit.css('color', 'red');
							isValid = false;
						} else {
							assginSocialErrorEdit.text('');
						}
						
						
						for (var i = 0; i < skillRow.length; i++) {
							if ((skillRow[i].children[1].children[0].value == 0)
									|| (skillRow[i].children[2].children[0].children[0].value == '')
									|| (skillRow[i].children[3].children[0].children[0].value == '')) {
								assginSkillErrorEdit
										.text('Please fill row data correctly.');
								assginSkillErrorEdit.css('color', 'red');
								isValid = false;
							} else {
								assginSkillErrorEdit.text('');
							}
						}
						
						for (var i = 0; i < socialRowSr.length; i++) {
							if ((socialRowSr[i].children[1].children[0].value == 0)
									|| (socialRowSr[i].children[2].children[0].value
											.trim() == '')) {
								assginSocialErrorEdit
										.text('Please fill row data correctly.');
								assginSocialErrorEdit.css('color', 'red');
								isValid = false;
							} else {
								assginSocialErrorEdit.text('');
							}

						}
						
						//check for duplicate values here
						var socialbadges = angular.element('.socialClass');
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
								var assginSocialErrorEditTemp = angular.element('#assginSocialErrorEdit');
								assginSocialErrorEditTemp.text('You already added this badge.');
								assginSocialErrorEditTemp.css('color', 'red');
								isValid = false;
								break;
							}else{
								assginSocialErrorEditTemp.text('');
							}
						}
						var tagFlag = false;
						for (var i = 0; i < editTags.length; i++) {
							if (editTags[i].checked) {
								tagFlag = true;
								break;
							}
						}
						if (tagFlag == false) {
							tagEditError
									.text('Please select at least one Tag.');
							tagEditError.css('color', 'red');
							isValid = false;
						} else {
							tagEditError.text('');
						}

						var interestFlag = false;

						for (var i = 0; i < editInterests.length; i++) {
							if (editInterests[i].checked) {
								interestFlag = true;
								break;
							}
						}
						if (interestFlag == false) {
							interestEditError
									.text('Please select at least one Interest.');
							interestEditError.css('color', 'red');
							isValid = false;
						} else {
							interestEditError.text('');
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
							eventTypeError.text('Please select event type.');
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

						var socialbadges = angular.element('.socialClass');
						var value1, value2;
						for(var i=0;i<socialbadges.length-1;i++){
							var socialFlag=false;
							for(var j=i+1;j<socialbadges.length;j++){
								value1=$(socialbadges[i]).val();
								value2=$(socialbadges[j]).val();
								
								if(value1==value2){
									socialFlag=true;
									break;
								}
							}
							
						}
				
						
								
						console.log(isValid);
						if (isValid) {

							$scope.updateEvent();
						}
					};

					// duration calculation in edit
					$scope.durationCalEdit = function(currentIndex) {

						var startDates = angular.element('.skillStartDateEdit');
						var endDates = angular.element('.skillEndDateEdit');

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
						if (startDates[currentIndexTemp].value.trim() != ''
								&& endDates[currentIndexTemp].value.trim() != '') {
							var todaysDate = (endDateVal - dateVal);
							var hours = (todaysDate / (60 * 60 * 1000));

							$scope.skillSch[currentIndex].duration = Math
									.floor(hours);

						} else {
							$scope.skillSch[currentIndex].duration = "";

						}

					}

					// adding new skill row for edit
					// adding new row in skills
					$scope.addNewRowSkillEdit = function() {
						var dateflag = true;
						var assginSkillError = angular
								.element('#assginSkillErrorEdit');
						// check if startdate and end date is selected then only
						// allow them to add the rows
						var eventStartTime = angular.element(
								'#eventFromTimeEdit').val();
						var eventEndTime = angular.element('#eventToTimeEdit')
								.val()

						if (eventStartTime == undefined
								&& eventEndTime == undefined) {

						} else {
							if (eventStartTime.trim() == ""
									|| eventEndTime.trim() == "") {

								dateflag = false;
								assginSkillError
										.text("Please select event start date and end date");
								assginSkillError.css("color", "red");

							} else {
								assginSkillError.text('');
							}
						}

						if (dateflag) {
							console.log("U r in adding new skill");
							var skillTable = angular
									.element("#skillsTableEdit");
							console.log($scope.skillIndexTemp);
							var skillIndex = $scope.skillIndexTemp++;

							$scope.event.skillSch[skillIndex] = {};
							$scope.event.skillSch[skillIndex].selected_skills = 0;
							$scope.event.skillSch[skillIndex].startDate = "";
							$scope.event.skillSch[skillIndex].endDate = "";
							$scope.skillSch[skillIndex] = {};
							$scope.skillSch[skillIndex].duration = "";
							var text = '<tr class="skillRowEdit" ind="'
									+ skillIndex
									+ '"><td class="skillRowSrEdit">'
									+ (++$scope.skillTableRow)
									+ '</td>'
									+ '<td>'
									+ '<select id="skills" class="form-control" ng-model="event.skillSch['
									+ skillIndex
									+ '].selected_skills" ng-change="populateCategoryEdit(event.skillSch['
									+ skillIndex
									+ '].selected_skills,'
									+ skillIndex
									+ ')"> '
									+ '<option value="0">Select Skills</option>'
									+ '<option ng-repeat="item in skills" value="{{item.id}}">{{item.skillName}}</option>'
									+ '</select>'
									+ '</td>'
									+ '<td><div class="datepicker_my1_edit input-group date">'
									+ '<input type="text" class="form-control skillStartDateEdit" ng-model="event.skillSch['
									+ skillIndex
									+ '].startDate" index-val="'
									+ skillIndex
									+ '" ng-blur="durationCalEdit('
									+ skillIndex
									+ ')">'
									+ '<span class="input-group-addon">'
									+ '<span class="glyphicon glyphicon-calendar"></span></span></div>'
									+ '</td>'
									+ '<td><div class="datepicker_my2_edit input-group date">'
									+ '<input type="text" class="form-control skillEndDateEdit" ng-model="event.skillSch['
									+ skillIndex
									+ '].endDate" index-val="'
									+ skillIndex
									+ '" ng-blur="durationCalEdit('
									+ skillIndex
									+ ')"/>'
									+ '<span class="input-group-addon">'
									+ '<span class="glyphicon glyphicon-calendar"></span></span></div>'
									+ '</td>'
									+ '<td>'
									+ '{{skillSch['
									+ skillIndex
									+ '].duration}}</td>'
									+ '<td>{{categoryName['
									+ skillIndex
									+ ']}} </td>'
									+ '<td><a data-toggle="modal"> <span class="glyphicon glyphicon-trash" ng-click="removeRowEdit('
									+ skillIndex + ')"></span></a></td></tr>';

							var selectMenu = $compile(text);
							var content = selectMenu($scope);
							skillTable.append(content);

							var sr = angular.element('.skillRowSrEdit');
							for (var i = 0; i < sr.length; i++) {
								$(sr[i]).html(i + 1);
							}

						}
					};

					// adding social badge for edit

					// adding new row in social badge.
					$scope.addNewRowSocialEdit = function() {
						var socialTable = angular.element("#socialTableEdit");
						var tempIndex = $scope.socialIndexTemp++;
						$scope.event.socialBadge[tempIndex] = {};
						$scope.event.socialBadge[tempIndex].badgeId = 0;
						$scope.event.socialBadge[tempIndex].description = ""
						console.log($scope.event.socialBadge[tempIndex]);
						var text = '<tr class="socialRowEdit" indSocial="'
								+ tempIndex
								+ '"><td class="socialRowSrEdit">'
								+ (++$scope.socialTableRow)
								+ '</td>'
								+ '<td>'
								+ '<select id="socialBadge"  class="form-control socialClass" ng-change="validateDuplcateSocialBadges();" ng-model="event.socialBadge['
								+ tempIndex
								+ '].badgeId" ng-change="validateDuplcateSocialBadges()" > '
								+ '<option value="0">Select Badge Name</option>'
								+ '<option ng-repeat="item in SocialBadge" value="{{item.id}}">{{item.badgeName}}</option>'
								+ '</select>'
								+ '</td>'
								+ '<td><textarea class="form-control" rows="1" id="Desc" ng-model="event.socialBadge['
								+ tempIndex
								+ '].description"></textarea></td>'
								+ '<td><a data-toggle="modal"> <span class="glyphicon glyphicon-trash" ng-click="removeSocialRowEdit('
								+ tempIndex + ')"></span></a></td></tr>';

						var selectMenu = $compile(text);
						var content = selectMenu($scope);
						socialTable.append(content);
						// rearranging social row sr index
						var sr = angular.element('.socialRowSrEdit');
						for (var i = 0; i < sr.length; i++) {
							$(sr[i]).html(i + 1);
						}

					};

					// removing skill row.
					$scope.removeRowEdit = function(index) {
						$scope.event.skillSch[index] = {};
						var rows = angular.element('.skillRowEdit');
						for (var i = 0; i < rows.length; i++) {
							if ($(rows[i]).attr('ind') == index) {
								$(rows[i]).remove();
							}
						}
						// rearranging the serial number
						var sr = angular.element('.skillRowSrEdit');
						for (var i = 0; i < sr.length; i++) {
							$(sr[i]).html(i + 1);
						}

					}
					// removing social row.
					$scope.removeSocialRowEdit = function(indexSocial) {
						// making deleted object empty
						$scope.event.socialBadge[indexSocial] = {};
						var rows = angular.element('.socialRowEdit');
						for (var i = 0; i < rows.length; i++) {
							if ($(rows[i]).attr('indSocial') == indexSocial) {
								$(rows[i]).remove();
							}
						}

						// rearranging social row index
						var sr = angular.element('.socialRowSrEdit');
						for (var i = 0; i < sr.length; i++) {
							$(sr[i]).html(i + 1);
						}
					}

					// populating category
					$scope.populateCategoryEdit = function(indexVal, rowIndex) {

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
				
					// when Social badge checkbox is checked or Unchecked
					$scope.checkForEditValidation = function() {
						if (!$scope.checked_social_edit) {
							var rows = $("#socialTableEdit > tr").length;
							if (rows >= 1) {
								$('#editEventModelSocialCheck').modal({
									show : true,
									backdrop : 'static',
									keyboard : false
								// to prevent closing with Esc button (if you
								// want this too)
								});
							}
						}
					};

					// when Social badge No option is clicked
					$scope.cantUncheckedSocial = function() {
						$scope.checked_social_edit = true;
						$('#editEventModelSocialCheck').modal('hide');
						
						console.log("cant check the checkbx..");
					};

					// when Social badge Yes option is clicked
					$scope.UncheckedSocial = function() {
						$scope.checked_social_edit = false;
						$('#editEventModelSocialCheck').modal('hide');
						$("#socialTableEdit > tr").remove();
					};

					// when Skill badge checkbox is checked or Unchecked
					$scope.UncheckSkillvalidation = function() {
						if (!$scope.checkedEdit) {
							var rows1 = $("#skillsTableEdit > tr").length;
							if (rows1 >= 1) {
								$('#editEventModelSkillCheck').modal({
									show : true,
									backdrop : 'static',
									keyboard : false
								// to prevent closing with Esc button (if you
								// want this too)
								});
							}
							;
						}
					};

					// when Skill badge No option is clicked
					$scope.cantUncheckedSkill = function() {
						$scope.checkedEdit = true;
						$('#editEventModelSkillCheck').modal('hide');
					};

					// when Skill badge Yes option is clicked
					$scope.UncheckedSkill = function() {
						$scope.checkedEdit = false;
						$('#editEventModelSkillCheck').modal('hide');
						$("#skillsTableEdit > tr").remove();
					};

				});