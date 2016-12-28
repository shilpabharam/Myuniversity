   		var url = window.location.href;
		var pieces = url.split("=");
		var bodyHeight = 0;
		var TotalDocuments = 0;
		var DocpageNum = 0;
		//var CKEditors = "";
		
		
		
		if(typeof(pieces[1]) === "undefined") {} else {
			
			localStorage.setItem("documentIdS", pieces[1]);
			
			$.get('/scrydocs/manageDocs/getDocumentFirstPreview?docId='+pieces[1], {}, function(result){
				TotalDocuments = result.pageCount;
				var templateID = result.templateID;
				$('.PickDocTemplate').attr('data-totaldoc',TotalDocuments);
				$('.PickDocTemplate').attr('data-doc',pieces[1]);
				var ticker_company_name = result.ticker_company_name;
				//CKEditors = CKEDITOR.instances[angular.element(document.getElementsByName('Editor'))];
				/*var instance = CKEDITOR.instances["Editor"];
		        if (instance) {
		            CKEDITOR.remove(instance);
		        }*/
		        

				var LoadedCKEditors = CKEDITOR.replace("Editor", { on: {instanceReady: function(ev) { $('.cke_button__smartdoc_icon').html('Track Content'); }},height: 1122,width: 1010});
				
				
				
				//CKEditors = CKEDITOR.instances['Editor'];
				$('.btndocpreview').attr('href','/scrydocs/#/preview?docid='+pieces[1]);
				$('.btn_publish').attr('href','/scrydocs/publish?docId='+pieces[1]);
				$('.btnPublish').attr('href','#/publish?docid='+pieces[1]);
				$('#loading').hide();
				
				$.each(result.docPages,function(key,value){
					DocpageNum = value.pageNum;
					var DocpageContent = value.pageContent;
					
					if(DocpageNum == 1){
						$('#dbTemplate').html(DocpageContent);
						$TempTitle = $('.PreviewTempTitle').text();
						$templateContent = $('.PreviewtemplateContent').text();
						//$('#tickerName').html("<h1>"+ticker_company_name+"</h1>");
					//	console.log("TempTitle --> "+$TempTitle);
						
						$(".widget-title").html('<input type="text" value="'+$TempTitle+'" name="title" class="col-sm-12 TempTitle">');
						//$(".PreviewtemplateContent").html('<textarea name="TemplateEditor" id="templateCKEditor">'+$templateContent+'</textarea>');
						
						//$('.PreviewtemplateContent').remove();
						$('.cke_textarea_inline').attr('id','templateCKEditor');
						
						$.post('/scrydocs/manageDocs/populateValues?templateId='+templateID+'&documentId='+pieces[1], {}, function(getTemplateresult){
							$.each(getTemplateresult,function(key,value){
								document.getElementById(key).innerHTML = value;
							});
						});
					}
					
					$('.cke_button__smartdoc_icon').text("Track Content");
					
					$('.PreviewGone > .col-sm-3 > .datachecked').prop('checked', false); 
					$('.PreviewGone.PreviewDone > .col-sm-3 > .datachecked').prop('checked', true); 
					
				});
				
				
				
				var imageFlag = false;
				var img = "";
				
				for(i=2;i<=TotalDocuments;i++){
					console.log("Loop Started");
					if(DocpageNum!=1){
						console.log("Page Ajax Started");
						
						$.get('/scrydocs/manageDocs/getDocumentPreviewByPageNumber?docId='+pieces[1]+'&pageNum='+i, {}, function(getresult){
							console.log("Data Loading to CKEDITOR");
							var pageContent = getresult.pageContent;
							if(pageContent != ""){
								if(pageContent.match("<img") && pageContent.match("base64")){
									//console.log("<img tag checking");
									imageFlag = true;
									img = img + pageContent;
								}else if(imageFlag == true && !pageContent.match("/>")){
									//console.log("<img end tag checking");
									img = img + pageContent;
								}else if (imageFlag == true && pageContent.match("/>")){
									//console.log("<img loaded");
									img = img + pageContent;
									LoadedCKEditors.setData(LoadedCKEditors.getData() + img);
									imageFlag = false;
									img = "";
								}else{
									//console.log(CKEditors);
									//console.log(CKEditors.getData());
									var CKDataget = LoadedCKEditors.getData();
									LoadedCKEditors.setData(CKDataget + pageContent);
									//angular.element( $('#cke_1_contents iframe').get(0)).append(pageContent);
									//var doc = $('#cke_1_contents iframe').get(0).contentDocument.body.innerHTML;
									
									
									
									/*var ckeditorFrame = $('#cke_1_contents iframe').get(0);
									var doc = (ckeditorFrame.get(0).contentDocument) ? ckeditorFrame.get(0).contentDocument.body.innerHTML : ckeditorFrame.get(0).contentWindow.document.body.innerHTML;
									$('#cke_1_contents iframe').get(0).contentDocument.body.innerHTML = doc + pageContent;*/
								}
							}
						});
					}
				}
				
				
				var config = {toolbar: [[ 'Bold', 'Italic', 'Underline' ]]};
				var inlineEditor = CKEDITOR.inline('templateCKEditor',config);
				
				
				
				//var inlineEditor = CKEDITOR.inline('TemplateEditor');
				//CKEDITOR.disableAutoInline = false;

				//CKEDITOR.inline( 'TemplateEditor' );
				
				/*var ck = CKEDITOR.inline('TemplateEditor');
				ck.on( 'instanceReady', function( ev ) {
				     var editor = ev.editor;
				     console.log("YES");
				});*/
				
				
				/*inlineEditor.on("instanceReady", function(){                    
				    this.document.on("keyup", function(){
				        var editorContent = $(inlineEditor.getData());
				        var plainEditorContent = editorContent.text().trim();
				        console.log(plainEditorContent);
				        console.log("Length: "+plainEditorContent.length);
				    });
				});*/
				
				
				/*if(pieces[2] == "true")
				{
					setTimeout(function(){
						window.self.window.self.window.window.location = "/smartdoc/#/edit?docid="+pieces[1]+"=false";
						
					}, 5000);
				}*/
				
			});
			
		}	
		
		
//		$(document).on('click', '.showPreview', function(e) {
//			var PageID = $(this).attr('data-id');
//			$('#loading').show();
//
//
//		});	
		
		/*$( 'textarea.Editor' ).ckeditor({
				height: 1122,
	            toolbarStartupExpanded: true,
	            width: 1000,
	            resize_enabled: false,
	            removePlugins: 'about'
		});	*/
		
		$(document).on('click', '#templateSave', function(e) {
			$DocID = parseInt($('.PickDocTemplate').attr('data-doc'));
			var TimeStamp = new Date().toISOString().replace(/\D/g,"").substr(0,14);
			var targetInputEle = $('.TempTitle');
			$.each(targetInputEle, function(index, ele){
				$(ele).replaceWith("<span class='PreviewTempTitle' data-ele='input'>" + $(ele).val() + "</span>");
			});
			
			//$('#templateCKEditor').val($('.cke_textarea_inline').html());
			//document.getElementById("templateCKEditor").value= $('.cke_textarea_inline').html();
			
//			var targetEle = $('#templateCKEditor');
//			$.each(targetEle, function(index, ele){
//				$(ele).replaceWith("<span class='PreviewtemplateContent' data-ele='textarea'>" + $(ele).val() + "</span>");
//			});
			
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
					$("#"+$getCheckBoxID).removeClass('col-sm-12 PreviewGone PreviewDone').addClass('col-sm-12 PreviewDone');
					console.log($getCheckBoxID);
				}
			    
			});
			
			$TemplateData = document.getElementById('dbTemplate').innerHTML;
			
	
			 
			
			
			var data = JSON.stringify({commit:true,docId:$DocID,docTimeStamp:parseInt(TimeStamp),docPage:{pageNum:1,pageContent:$TemplateData}});
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
			
			var TimeStamp = new Date().toISOString().replace(/\D/g,"").substr(0,14);
			$DocID = parseInt($('.PickDocTemplate').attr('data-doc'));
			
			/* TEMPLATE DATA */

			var targetInputEle = $('.TempTitle');
			$.each(targetInputEle, function(index, ele){
				$(ele).replaceWith("<span class='PreviewTempTitle' data-ele='input'>" + $(ele).val() + "</span>");
			});
			

			
			for(i=1;i<=8;i++)
			{
				$("#checked"+i).removeAttr('class').addClass('col-sm-12 PreviewGone');
			}
			
			//$(".widget-title").html('<span class="PreviewTitle">'+$TempTitle+'</span>');
			
			$('.datachecked:checked').each(function(){
				$getCheckBoxID = $(this).attr('data-id');
				$checked = $(this).is(':checked') ? 1 : 0;
				
				if($checked == 1)
				{
					$("#"+$getCheckBoxID).removeAttr('class').addClass('col-sm-12 PreviewDone');
					
				}
			    
			});
			
			$TemplateData = document.getElementById('dbTemplate').innerHTML;
			
	
			 
			
			
			var data = JSON.stringify({commit:true,docId:$DocID,docTimeStamp:parseInt(TimeStamp),docPage:{pageNum:1,pageContent:$TemplateData}});
			$.ajax({
				    url: '/scrydocs/manageDocs/saveUpdateDocHistory',
				    type: 'PUT',
				    headers: {"Content-Type": "application/json"},
				    dataType: 'json',
				    data: data,
				    success: function(result) {},
				    async:   false
				});
		
		
		/* TEMPLATE DATA */
			
			/* CKEDITOR DATA */
			$CKEditorData = $( 'textarea.Editor' ).val();
			var CKEditors = CKEDITOR.instances['Editor'].getData()
			var TotalPageLength = CKEditors.length;
			var TotalPages = Math.round((TotalPageLength / 5000 )) + 1 ;
				
			var StartCharacter = 0;
			var EndCharacter = 5000;
			
			var targetEle = $('.valueToHtml');
				$.each(targetEle, function(index, ele){
					$(ele).replaceWith("<p data-ele='textarea'>" + $(ele).val() + "</p>");
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
			
			$('#loading').hide();
		});
		
		//$(document).on('click', '.cke_textarea_inline', function(e) {
			/*$('.cke.cke_3.cke_reset_all.cke_chrome.cke_editor_editor1.cke_float.cke_ltr.cke_browser_gecko').css('margin-top','35px');
			$('.cke_textarea_inline').css('margin-top','35px');*/
		//});
		
		/*$("#templateEdit").click(function() {
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
		});*/
		
		$(document).on('load', 'textarea#templateCKEditor', function(e) {}).ckeditor({
			height: 400,
            toolbarStartupExpanded: false,
            width: 300,
            resize_enabled: false,
            removePlugins: 'about'
		});
