$(document).ready(
		function() {
			
			//Event start date
			$(document).on('click','#datetimepicker1',function() {
				$('#eventFromTime').datetimepicker({
					useCurrent : false
				});
				$("#eventFromTime").data("DateTimePicker").minDate(
						new Date());
				$("#eventFromTime").data("DateTimePicker").show();
			});
			
			//Event end date
			$(document).on('click','#datetimepicker2',function() {
				
				$('#eventToTime').datetimepicker({
					
					useCurrent : false
				});
				$('#eventToTime').data("DateTimePicker").minDate(
						new Date($("#eventFromTime").val()));
				$("#eventToTime").data("DateTimePicker").show();
			});


			
			//edit event start date
			$(document).on('click','#datetimepickerEdit1',function() {
				$('#eventFromTimeEdit').datetimepicker({
					useCurrent : false
				});
				$("#eventFromTimeEdit").data("DateTimePicker").show();
				$("#eventFromTimeEdit").data("DateTimePicker").minDate(
						new Date());
				$("#eventFromTimeEdit").data("DateTimePicker").maxDate(
						new Date($("#eventToTimeEdit").val()));
				
			});
			
			//edit event end date
			$(document).on('click','#datetimepickerEdit2',function() {
				
				$('#eventToTimeEdit').datetimepicker({
					
					useCurrent : false
				});
				$('#eventToTimeEdit').data("DateTimePicker").minDate(
						new Date($("#eventFromTimeEdit").val()));
				$("#eventToTimeEdit").data("DateTimePicker").show();
			});
			
			
			//Skill start date 
			$(document).on('click','.datepicker_my1',function() {
				console.log("correct");
						var child = $(this).children('.skillStartDate');
						$(child[0]).datetimepicker({
							useCurrent:false
							
						});
						$(child[0]).data("DateTimePicker").show();
						$(child[0]).data("DateTimePicker").minDate(
								new Date($("#eventFromTime").val()));
						$(child[0]).data("DateTimePicker").maxDate(
								new Date($("#eventToTime").val()));

					});
			
			//edit skill start date
			
			$(document).on('click','.datepicker_my1_edit',function() {
				
				var child = $(this).children('.skillStartDateEdit');
				$(child[0]).datetimepicker({
					useCurrent:false
					
				});
				$(child[0]).data("DateTimePicker").show();
				console.log("correct1");
				$(child[0]).data("DateTimePicker").minDate(
						new Date($("#eventFromTimeEdit").val()));
				$(child[0]).data("DateTimePicker").maxDate(
						new Date($("#eventToTimeEdit").val()));

			});
			//edit skill end date
			$(document).on('click', '.datepicker_my2_edit', function() {
				var child = $(this).children('.skillEndDateEdit');
				$(child[0]).datetimepicker({
					useCurrent:true
				});
				$(child[0]).data("DateTimePicker").show();
				$(child[0]).data("DateTimePicker").minDate(
						new Date($(".skillStartDateEdit").val()));
				$(child[0]).data("DateTimePicker").maxDate(
						new Date($("#eventToTimeEdit").val()));
			});	
		
			
			//Skill end date
			$(document).on('click', '.datepicker_my2', function() {
				var child = $(this).children('.skillEndDate');
				$(child[0]).datetimepicker({
					useCurrent:true
				});
				$(child[0]).data("DateTimePicker").show();
				$(child[0]).data("DateTimePicker").minDate(
						new Date($(".skillStartDate").val()));
				$(child[0]).data("DateTimePicker").maxDate(
						new Date($("#eventToTime").val()));
			});	
});