jQuery(function($) {
	
		$('.datachecked').attr('checked', 'checked');
		
		$('.btndocpreview').hide();
		$('.btn_publish').hide();
		$('.EditCollBtn').hide();
		
		$('.PickDocTemplate').attr('data-doc',localStorage.getItem("docID"));
		
		/*$(document).on('load', '.DocumentButtons', function(e) {
			$('.btndocpreview').hide();
			$('.btn_publish').hide();
		});*/
			
		
		
		$DocpageCount = 2;
		/*$('.btndocpreview').hide();
		$('.btn_publish').hide();*/
		
		
		//CKEDITOR.inline( 'TemplateEditor' );
		
		/*$(".Btnckeditor").click(function() {
			$('.TemplatePage').hide();
			$('.CKEditor').show();
			$( 'textarea.Editor' ).val('');
			$('.EditorSave').attr('data-id',$DocpageCount);
			$('.PickDocTemplate').attr('data-ctab',$DocpageCount);
			$(".MakeEditorThumb").append('<div class="editorthumbnail thumbnail" data-id="'+$DocpageCount+'"><img alt="100%x200" data-src="holder.js/100%x200" width="50%" style="display: block;" src="resources/images/doc.png" data-holder-rendered="true"></div>');
			$DocpageCount++;
		});
		
		$('input[name="title"]').attr('class','valueToHtml');*/
		
		$(document).on('click', '#templateSave', function(e) {
			$DocID = parseInt($('.PickDocTemplate').attr('data-doc'));
			//$TempTitle = $('.TempTitle').val();
			var TimeStamp = new Date().toISOString().replace(/\D/g,"").substr(0,14);
			
			for(i=1;i<=8;i++)
			{
				$("#checked"+i).addClass('col-sm-12 PreviewGone');
			}
			
			//$(".widget-title").html('<span class="PreviewTitle">'+$TempTitle+'</span>');
			
			$('.datachecked:checked').each(function(){
				$getCheckBoxID = $(this).attr('data-id');
				$checked = $(this).is(':checked') ? 1 : 0;
				
				if($checked == 1)
				{
					$("#"+$getCheckBoxID).addClass('col-sm-12 PreviewDone');
				}
			    
			});
			
		
			
			
//			var targetInputEle = $('.TempTitle');
//			$.each(targetInputEle, function(index, ele){
//				$(ele).replaceWith("<span class='PreviewTempTitle' data-ele='input'>" + $(ele).val() + "</span>");
//			});
//			
//			var targetEle = $('#templateCKEditor');
//			$.each(targetEle, function(index, ele){
//				$(ele).replaceWith("<span class='PreviewtemplateContent' data-ele='textarea'>" + $(ele).val() + "</span>");
//			});
//			
//			$TemplateData = document.getElementById('dbTemplate').innerHTML;
//			
//			$('.btndocpreview').attr('href','/preview?docId='+$DocID);
//			$('.btndocpublish').attr('href','/publish?docID='+$DocID);

			console.log("TEMPLATE TIMESTAMP ---> "+TimeStamp);
			var data = JSON.stringify({commit:true,docId:$DocID,docTimeStamp:parseInt(TimeStamp),docPage:{pageNum:1,pageContent:$TemplateData}});
			$.ajaxSetup({async: false});
			$.ajax({
				    url: '/scrydocs/manageDocs/saveUpdateDocHistory',
				    type: 'PUT',
				    headers: {"Content-Type": "application/json"},
				    dataType: 'json',
				    data: data,
				    success: function(result) {},
				    async:   false
				});
		});
		
		$('.EditorSave').click(function(e) {
			
			$('#loading').css("display","block");
			
			$DocID = parseInt($('.PickDocTemplate').attr('data-doc'));
			var TimeStamp = new Date().toISOString().replace(/\D/g,"").substr(0,14);
			/* Template Save */
			for(i=1;i<=8;i++)
			{
				$("#checked"+i).addClass('col-sm-12 PreviewGone');
			}
			
			
			$('.datachecked:checked').each(function(){
				$getCheckBoxID = $(this).attr('data-id');
				$checked = $(this).is(':checked') ? 1 : 0;
				
				if($checked == 1)
				{
					$("#"+$getCheckBoxID).addClass('col-sm-12 PreviewDone');
				}
			    
			});
			
		
			
			
			var targetInputEle = $('.TempTitle');
			$.each(targetInputEle, function(index, ele){
				$(ele).replaceWith("<span class='PreviewTempTitle' data-ele='input'>" + $(ele).val() + "</span>");
			});
			
			var targetEle = $('#templateCKEditor');
			$.each(targetEle, function(index, ele){
				$(ele).replaceWith("<span class='PreviewtemplateContent' data-ele='textarea'>" + $(ele).val() + "</span>");
			});
			
			
			
			$TemplateData = document.getElementById('dbTemplate').innerHTML;
			
			$('.btndocpreview').attr('href','/scrydocs/#/preview?docId='+$DocID);
			$('.btn_publish').attr('href','/scrydocs/publish?docId='+$DocID);
			

			console.log("Content ---> "+$TemplateData);
			
			$TemplateSaveData = $TemplateData.replace('<script>CKEDITOR.inline( "TemplateEditor", {toolbar: [[ "Bold", "Italic", "Underline" ]]})</script><script>CKEDITOR.replace("Editor", { on: {instanceReady: function(ev) { $(".cke_button__smartdoc_icon").html("Track Content"); }},height: 1122,width: 1200});</script>',"");
			
			
			var data = JSON.stringify({commit:true,docId:$DocID,docTimeStamp:parseInt(TimeStamp),docPage:{pageNum:1,pageContent:$TemplateSaveData}});
			$.ajaxSetup({async: false});
			$.ajax({
				    url: '/scrydocs/manageDocs/saveUpdateDocHistory',
				    type: 'PUT',
				    headers: {"Content-Type": "application/json"},
				    dataType: 'json',
				    data: data,
				    success: function(result) {},
				    async:   false
				});
			/* Template Save*/
			
			
			
			
			/* CKEditor Data Save */
			
			$CKEditorData = $( 'textarea.Editor' ).val();
			var CKEditors = CKEDITOR.instances['Editor'].getData()
			var TotalPageLength = CKEditors.length;
			var TotalPages = Math.round((TotalPageLength / 5000 )) + 1 ;

			$('.btndocpreview').attr('href','/scrydocs/#/preview?docId='+$DocID);
			
			var StartCharacter = 0;
			var EndCharacter = 5000;
			console.log("CKEDITOR TIMESTAMP ---> "+TimeStamp);
			var targetEle = $('.valueToHtml');
				$.each(targetEle, function(index, ele){
					$(ele).replaceWith("<p data-ele='textarea'><br>" + $(ele).val() + "<br></p>");
				});
				$("#templateEdit").removeAttr('disabled');
			
			for(i=0;i<TotalPages;i++){
				if(i!=0){
						var StartCharacter = EndCharacter + 0;
						var EndCharacter = EndCharacter + 5000;
				}
				var PageNum = i+2;
				$CKDataSend = CKEditors.slice(StartCharacter, EndCharacter);
				var CKData = JSON.stringify({commit: true, docId: $DocID,docTimeStamp:parseInt(TimeStamp),docPage:{pageNum:PageNum,pageContent:$CKDataSend}});
				$.ajaxSetup({async: false});
				$.ajax({
				    url: '/scrydocs/manageDocs/saveUpdateDocHistory',
				    type: 'PUT',
				    headers: {"Content-Type": "application/json"},
				    dataType: 'json',
				    data: CKData,
				    success: function(result) {},
				    async:   false
				});
			}
			
			$('.docsaved').html("Document Saved");
			
			var fade_out = function() {
				
				$('.docsaved').html("");
				}

			setTimeout(fade_out, 1000);
			
			$('.btndocpreview').show();
			$('.btn_publish').show();
			$('.EditCollBtn').show();
			$('#loading').hide();
			/* CKEditor Data Save */
			
		});
		
		$(document).on('click', '#CreateDocEditorSave', function(e) {
			
			$('#loading').css("display","block");
			
			$DocID = parseInt($('.PickDocTemplate').attr('data-doc'));
			var TimeStamp = new Date().toISOString().replace(/\D/g,"").substr(0,14);
			/* Template Save */
			for(i=1;i<=8;i++)
			{
				$("#checked"+i).addClass('col-sm-12 PreviewGone');
			}
			
			
			$('.datachecked:checked').each(function(){
				$getCheckBoxID = $(this).attr('data-id');
				$checked = $(this).is(':checked') ? 1 : 0;
				
				if($checked == 1)
				{
					$("#"+$getCheckBoxID).addClass('col-sm-12 PreviewDone');
				}
			    
			});
			
		
			
			
			var targetInputEle = $('.TempTitle');
			$.each(targetInputEle, function(index, ele){
				$(ele).replaceWith("<span class='PreviewTempTitle' data-ele='input'>" + $(ele).val() + "</span>");
			});
			
			var targetEle = $('#templateCKEditor');
			$.each(targetEle, function(index, ele){
				$(ele).replaceWith("<span class='PreviewtemplateContent' data-ele='textarea'>" + $(ele).val() + "</span>");
			});
			
			$TemplateData = document.getElementById('dbTemplate').innerHTML;
			
			$('.btndocpreview').attr('href','/scrydocs/#/preview?docId='+$DocID);
			$('.btn_publish').attr('href','/scrydocs/publish?docId='+$DocID);
			

			console.log("Content ---> "+$TemplateData);
			
			$TemplateSaveData = $TemplateData.replace('<script>CKEDITOR.inline( "TemplateEditor" )</script><script>CKEDITOR.replace("Editor", { on: {instanceReady: function(ev) { $(".cke_button__smartdoc_icon").html("Track Content"); }},height: 1122,width: 1065});</script>',"");
			
			
			var data = JSON.stringify({commit:true,docId:$DocID,docTimeStamp:parseInt(TimeStamp),docPage:{pageNum:1,pageContent:$TemplateSaveData}});
			$.ajaxSetup({async: false});
			$.ajax({
				    url: '/scrydocs/manageDocs/saveUpdateDocHistory',
				    type: 'PUT',
				    headers: {"Content-Type": "application/json"},
				    dataType: 'json',
				    data: data,
				    success: function(result) {},
				    async:   false
				});
			/* Template Save*/
			
			
			
			
			/* CKEditor Data Save */
			
			$CKEditorData = $( 'textarea.Editor' ).val();
			var CKEditors = CKEDITOR.instances['Editor'].getData()
			var TotalPageLength = CKEditors.length;
			var TotalPages = Math.round((TotalPageLength / 5000 )) + 1 ;

			$('.btndocpreview').attr('href','/scrydocs/#/preview?docId='+$DocID);
			
			var StartCharacter = 0;
			var EndCharacter = 5000;
			console.log("CKEDITOR TIMESTAMP ---> "+TimeStamp);
			var targetEle = $('.valueToHtml');
				$.each(targetEle, function(index, ele){
					$(ele).replaceWith("<p data-ele='textarea'><br>" + $(ele).val() + "<br></p>");
				});
				$("#templateEdit").removeAttr('disabled');
			
			for(i=0;i<TotalPages;i++){
				if(i!=0){
						var StartCharacter = EndCharacter + 0;
						var EndCharacter = EndCharacter + 5000;
				}
				var PageNum = i+2;
				$CKDataSend = CKEditors.slice(StartCharacter, EndCharacter);
				var CKData = JSON.stringify({commit: true, docId: $DocID,docTimeStamp:parseInt(TimeStamp),docPage:{pageNum:PageNum,pageContent:$CKDataSend}});
				$.ajaxSetup({async: false});
				$.ajax({
				    url: '/scrydocs/manageDocs/saveUpdateDocHistory',
				    type: 'PUT',
				    headers: {"Content-Type": "application/json"},
				    dataType: 'json',
				    data: CKData,
				    success: function(result) {},
				    async:   false
				});
			}
			
			$('.docsaved').html("Document Saved");
			
			var fade_out = function() {
				
				$('.docsaved').html("");
				}

			setTimeout(fade_out, 1000);
			
			$('.btndocpreview').show();
			$('.btn_publish').show();
			$('#loading').hide();
			/* CKEditor Data Save */
			
		});
		
		//$(document).on('click', '.editorthumbnail', function(e) {
		$('.editorthumbnail').click(function(e) {
			var TimeStamp = new Date().toISOString().replace(/\D/g,"").substr(0,14);
			$PickedTab = $(this).attr('data-id');
			$CurrentTab = $('.PickDocTemplate').attr('data-ctab');
			$DocID = parseInt($('.PickDocTemplate').attr('data-doc'));
			$CKEditorData = $( 'textarea.Editor' ).val();
			$TemplateData = document.getElementById('dbTemplate').innerHTML;
			
			$('.PickDocTemplate').attr('data-ctab',$PickedTab);
			$('.cke_button__smartdoc_icon').text("Track Content");
			
			var CKEditors = CKEDITOR.instances['Editor'].getData()
			var TotalPageLength = CKEditors.length;
			var TotalPages = Math.round((TotalPageLength / 5000 )) + 1 ;

			var StartCharacter = 0;
			var EndCharacter = 5000;
			
			
			
			if($CurrentTab!=1){
				
				var targetEle = $('.valueToHtml');
				$.each(targetEle, function(index, ele){
					$(ele).replaceWith("<p data-ele='textarea'>" + $(ele).val() + "</p>");
				});
				$("#templateEdit").removeAttr('disabled');
				
				for(i=1;i<=TotalPages;i++)
				{
					
					if(i!=1){
						var StartCharacter = EndCharacter + 1;
						var EndCharacter = EndCharacter + 5000;
					}
					
					var PageNum = i+1;
					//console.log(StartCharacter+"<--->"+EndCharacter);
					console.log("TEMPLATE TIMESTAMP ---> "+TimeStamp);
					$CKDataSend = $CKEditorData.slice(StartCharacter, EndCharacter);
					
					var SendData1 = JSON.stringify({commit: true, docId: $DocID,docTimeStamp:parseInt(TimeStamp),docPage:{pageNum:PageNum,pageContent:$CKDataSend}});
					$.ajaxSetup({async: false});
					$.ajax({
					    url: '/scrydocs/manageDocs/saveUpdateDocHistory',
					    type: 'PUT',
					    headers: {"Content-Type": "application/json"},
					    dataType: 'json',
					    data: SendData1,
					    success: function(result) {},
					    async:   false
					});
					
					
					
				}
				
				
			}else{
			
				
				$.ajaxSetup({async: false});
				var SendData2 = JSON.stringify({commit:true,docId:$DocID,docTimeStamp:parseInt(TimeStamp),docPage:{pageNum:$CurrentTab,pageContent:$TemplateData}});
				$.ajax({
				    url: '/scrydocs/manageDocs/saveUpdateDocHistory',
				    type: 'PUT',
				    headers: {"Content-Type": "application/json"},
				    dataType: 'json',
				    data: SendData2,
				    success: function(result) {},
				    async:   false
				});
			}
			
			if($PickedTab==1){
				$('.TemplatePage').show();
				$('.CKEditor').hide();
			}else{
				$('.TemplatePage').hide();
				$('.CKEditor').show();
			}
			
			/*
			if($CurrentTab!=1){
				
				var SendData1 = {"commit":true,"docId":$DocID,"docPage":{"pageNum":$CurrentTab,"pageContent":$CKEditorData}};
			
				$.ajax({
				    url: '/scrydocs/manageDocs/saveUpdateDocHistory',
				    type: 'PUT',
				    headers: { "Content-Type": "application/json"},
				    dataType: 'json',
				    data: SendData1,
				    success: function(result) {}
				});
			}else{
				var SendData2 = {"commit":true,"docId":$DocID,"docPage":{"pageNum":$CurrentTab,"pageContent":$TemplateData}};
				$.ajax({
				    url: '/smartdoc/manageDocs/saveUpdateDocHistory',
				    type: 'PUT',
				    headers: { "Content-Type": "application/json"},
				    dataType: 'json',
				    data: SendData2,
				    success: function(result) {
				        
				    }
				});
			}
			
			$.post('/scrydocs/manageDocs/getDocumentPreviewByPageNumber?docId='+$DocID+'&pageNum='+$CurrentTab, {}, function(result){
				if($PickedTab==1){
					$('.TemplatePage').show();
					$('.CKEditor').hide();
					$('.DefaultTemplate').html(result.pageContent);
				}else{
					$('.TemplatePage').hide();
					$('.CKEditor').show();
					$( 'textarea.Editor' ).val(result.pageContent);
				}
	    	});*/
			
		});
		
		
		
		//$('.CKTemplateButton').hide();
		
		$("#templateEdit").click(function() {
			var targetEle = $('p[data-ele="textarea"]');
			$.each(targetEle, function(index, ele){
				$(ele).replaceWith("<textarea class='form-control valueToHtml'>" + $(ele).text() + "</textarea>");
			});
			$(this).attr('disabled','disabled');
		});
		
		$("#templateSave").click(function() {
			var targetEle = $('.valueToHtml');
			$.each(targetEle, function(index, ele){
				$(ele).replaceWith("<p data-ele='textarea'>" + $(ele).val() + "</p>");
			});
			$("#templateEdit").removeAttr('disabled');
		});
		
		$('.Btnckeditor').click(function(){
			$('.TemplatePage').hide();
			$('.CKEditor').show();
			$( 'textarea.Editor' ).val('');
			$('.EditorSave').attr('data-id',$DocpageCount);
			$('.PickDocTemplate').attr('data-ctab',$DocpageCount);
			$(".MakeEditorThumb").append('<div class="editorthumbnail thumbnail" data-id="'+$DocpageCount+'"><img alt="100%x200" data-src="holder.js/100%x200" width="50%" style="display: block;" src="resources/images/doc.png" data-holder-rendered="true"></div>');
			$DocpageCount++;
			
			
			$('.nactive').show();
			$('.nactive').css({"background":"green","border":"5px solid green"});
			$('.thumbnail.active').css({"background":"#fff","border":"0px"});
			//$('#dbTemplate').hide();
			$('.TemplateButton').hide();
			$('.CKTemplateButton').show();
			$('.ckhide').show();
			
		});
		
		$('.nactive').click(function(){
			$('.nactive').show();
			$('.nactive').css({"background":"green","border":"5px solid green"});
			$('.thumbnail.active').css({"background":"#fff","border":"0px"});
			$('#dbTemplate').hide();
			$('.TemplateButton').hide();
			$('.CKTemplateButton').show();
			$('.ckhide').show();
			
			
			
		});
		
		$('.active').click(function(){
			$('.nactive').css({"background":"#fff","border":"0px"});
			$('.thumbnail.active').css({"background":"green","border":"5px solid green"});
			$('#dbTemplate').show();
			$('.TemplateButton').show();
			$('.CKTemplateButton').hide();
			$('.ckhide').hide();
			
			var targetEle = $('p[data-ele="textarea"]');
			$.each(targetEle, function(index, ele){
				$(ele).replaceWith("<textarea class='form-control valueToHtml'>" + $(ele).text() + "</textarea>");
			});
			$(this).attr('disabled','disabled');
			
		});
		
		$( 'textarea.Editor' ).ckeditor({
				height: 1122,
	            toolbarStartupExpanded: true,
	            width: 1065,
	            resize_enabled: false,
	            removePlugins: 'about'
		});
		
		
		/*$(document).on('load', 'textarea.Editor', function(e) {}).ckeditor({
			height: 1122,
            toolbarStartupExpanded: true,
            width: 1065,
            resize_enabled: false,
            removePlugins: 'about'
		});*/
		
		CKEDITOR.replace("Editor", { on: {instanceReady: function(ev) { $('.cke_button__smartdoc_icon').html('Track Content'); }},height: 1122,width: 1065});
		
		$( 'textarea.CKEditors' ).ckeditor({
			height: 1122,
            toolbarStartupExpanded: true,
            width: 1065,
            resize_enabled: false,
            removePlugins: 'about'
		});
		
		$(document).on('load', 'textarea#templateCKEditor', function(e) {}).ckeditor({
			height: 400,
            toolbarStartupExpanded: false,
            width: 300,
            resize_enabled: false,
            removePlugins: 'about'
		});
		
		
		
		
		/*$('.datachecked').click(function(){
			$getCheckBoxID = $(this).attr('data-id');
			$checked = $(this).is(':checked') ? 1 : 0;
			window.alert($checked+"---"+$getCheckBoxID);
			if($checked == 0)
			{
				$($getCheckBoxID).addClass('col-sm-12 PreviewGone');
			}
		});*/
		
	});	




