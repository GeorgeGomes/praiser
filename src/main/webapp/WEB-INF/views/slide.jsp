<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<div style="width:40%;font-family:ProximaNova;float:left;background-color:#00fe81;color:#ffffff;font-weight:bold;text-align:center;font-size:1em">Passo 1: escolha a música</div>
	<div style="width:60%;font-family:ProximaNova;float:left;background-color:#fd5dff;color:#ffffff;font-weight:bold;text-align:center;font-size:1em">Passo 2: Personalizar</div>
</div>

<div style="background-color: #ffffff">
	<div ng-controller="SlideController as ctrl">
		<div>
			<div id="upload" ng-show="ctrl.statusUpload" style="width:33em;margin:8em auto">
				<div style="width:31em;margin:8em auto">
					<input ng-model="ctrl.music" ng-change="ctrl.searchMusic()" style="float:left;display:block;border-right:0px;border-left:1px solid #BEBEBE;border-top:1px solid #BEBEBE;border-bottom:1px solid #BEBEBE;font-size:1.4em;padding:0.2em;width:20em;height:40px" type="text" name="musica" id="musica" placeholder="Qual música você quer?"/>
	   				<div style="width:3em;height:40px;border-bottom:1px solid #BEBEBE;border-left:0px;border-top:1px solid #BEBEBE;border-right:1px solid #BEBEBE;float:left"><img src="static/img/search.png" alt="Buscar" width="30" style="margin:5px"/></div>
	   				<div class="clearfix"></div>
	   				<div>
	   					<div style="position:absolute">		   					
		   					<div class="list-group" style="width:31em">
	  							<button type="button" class="list-group-item" ng-repeat="lyric in ctrl.lyrics.response.docs track by $index" ng-if="lyric.title != null" ng-click="ctrl.selectMusic(lyric)">
	  								{{lyric.title}} - {{lyric.band}}
	  							</button>
							</div>
	   					</div>
	   				</div>
					<div style="clear:both"></div>
					
					<button type="button" ng-click="ctrl.upload()" style="margin-top:0.2em;float:right;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">Buscar letra</button>
					<div class="clearfix"></div>
					
				</div>
			</div>
			
			<div id="preview" ng-show="ctrl.statusPreview">						
					<div>
						<div class="titlePersonalise">
								<div style="">Fonte:</div>
						</div>
						<div class="titlePersonalise">
								<div style="">Cor:</div>
						</div>
						<div class="titlePersonalise">
								<div style="">Formato:</div>
						</div>
						<div class="clearfix"></div>
						<div class="content-personalise">
							<div id="fonts" style="width:33%;float:left;padding:1em;height:16em;border-right:0.3em solid #ffffff">
								<div class="mlOverflow" style="height:200px;overflow-y:hidden;position: absolute;width: 28%;background-color: #fafafa" data-mlOverflow_more="Expand" data-mlOverflow_less="Contract">
									<div class="mlOverflow_text">
										<div ng-repeat="font in ctrl.fonts track by $index" style="font-family:{{font.font}}" class="btn-font" ng-click="ctrl.changeFont(font.font)">
											<div>{{font.font}}</div>
											<div class="type">Type</div>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div id="backgrounds" style="width:33%;float:left;padding:1em">
								<div>
									<div ng-repeat="background in ctrl.backgrounds" style="background-image:url(/praiser/uploads/admin/{{background.filename}})" class="btn-background" ng-click="ctrl.changeBackground(background.filename, background.colorTitle, background.colorBody)">											
										<div class="font-color left" style="background-color:{{background.colorTitle}}"></div>
										<div class="font-color right" style="background-color:{{background.colorBody}}"></div>
										<div class="clearfix"></div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div id="backgrounds" style="width:33%;float:left;padding:1em">
								<div>
									<div class="btn-ratio {{ctrl.ratio == '4:3' ? 'btn-ratio-border' : ''}}" style="width:100px" ng-click="ctrl.selectRatio('4:3')">4:3</div>
			 						<div class="btn-ratio {{ctrl.ratio == '16:9' ? 'btn-ratio-border' : ''}}" style="width:133px;margin:1em auto" ng-click="ctrl.selectRatio('16:9')">16:9</div>
			 						<div class="clearfix"></div>
			 					</div>
							</div>
							<div class="clearfix"></div>
						</div>
						
						<div class="content-preview">
						<div>width:{{ctrl.slideWidth}}px;</div>
						<div>height:{{ctrl.slideHeight}}px</div>
						<div>width:{{ctrl.slideWidth / 7}}px;</div>
						<div>height:{{ctrl.slideHeight / 7}}px</div>
							<div ng-repeat="phase in ctrl.phases track by $index" style="position:relative;float:left;width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px">
					 			<div title="Editar slide!" ng-mouseleave="ctrl.editMouseLeave('slideEdit'+$index)" ng-mouseover="ctrl.editMouseOver('slideEdit'+$index)" ng-click="ctrl.selectSlide($index)" class="slide" style="position:relative;float:left;font-size:{{ctrl.slideFontSize / 7}}em;background-size:{{ctrl.slideWidth / 7}}px {{ctrl.slideHeight / 7}}px;width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px;color:{{ctrl.slideColorBody}};background-image:url(/praiser/uploads/admin/{{ctrl.slideBackground}});font-family:{{ctrl.slideFont}}">
					 				<div title="Editar" class="slideEdit" id="slideEdit{{$index}}" style="width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px"></div>
					 				<div id="slideContent{{$index}}" class="slideContent" ng-bind-html="phase"></div>
				 					<div class="clearfix"></div>
				 				</div>
				 				<div title="Excluir" class="slideDelete" id="slideDelete{{$index}}" ng-click="ctrl.deleteSlide($index)"></div>
					 		</div>
					 		<div>
					 			<div title="Adicionar slide!" ng-click="ctrl.newSlide()" class="slide slideNew" style="position:relative;float:left;width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px;">
				 				</div>
					 		</div>
					 		<div class="clearfix"></div>
				 		</div>
						

						<div class="clearfix"></div>
						<button type="button" ng-click="ctrl.download()" style="display:block;margin:0.2em auto;padding:0.4em;border:0px;background-color:#7d01a1;color:#ffffff;font-size:1.6em;font-weight:bold;width:14em"><img src="static/img/download-from-cloud.png" alt="download" width="30" style="margin:5px"/>Download</button>
						
					 </div>
				
			 </div>
		 </div> 
		 	 

		 
		<div id="done" ng-show="ctrl.statusDone">
			<div style="max-width: 1100px;margin:2em auto;padding-top:3px">
				<div style="font-size:2em;font-weight:bold;color:#fd5dff;padding-bottom:0.5em">Uau! Olha como ficou...</div>
			 		<div ng-repeat="phase in ctrl.phases track by $index">
		 				<div class="slide" style="font-size:{{ctrl.slideFontSize / 7}}em;background-size:{{ctrl.slideWidth / 7}}px {{ctrl.slideHeight / 7}}px;width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px;color:{{ctrl.slideColorBody}};background-image:url(/praiser/uploads/admin/{{ctrl.slideBackground}});font-family:{{ctrl.slideFont}}">
				 			<div class="contentSlide" ng-bind-html="phase"></div>
		 					<div class="clearfix"></div>
		 				</div>
			 		</div>
		 			<div class="clearfix"></div>
		 	</div>
			<div style="clear:both"></div>
			
			<div style="clear:both"></div>
		</div>		
		
		
		
		
		
		
		
		
		<div id="canvasSlide" style="display:none">
	<div ng-repeat="phase in ctrl.phases track by $index">
		<div class="slideSave" style="border:1px solid black;font-size:{{ctrl.slideFontSize}}em;background-size:{{ctrl.slideWidth}}px {{ctrl.slideHeight}}px;width:{{ctrl.slideWidth}}px;height:{{ctrl.slideHeight}}px;color:{{ctrl.slideColorBody}};background-image:url(/praiser/uploads/admin/{{ctrl.slideBackground}});font-family:{{ctrl.slideFont}}">
			<div ng-bind-html="phase"></div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearfix"></div>
</div>	
		
		


<div class="modal fade" id="mySlide" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div>
				<div style="height:520px;float:left;width:660px;padding:10px;border-top:1px solid #fafafa;border-right:1px solid #fafafa;border-bottom:1px solid #fafafa">
			 		<div style="text-align:right;position:relative;z-index:2">
			 			<button type="button" ng-click="ctrl.btnEdit()" ng-show="ctrl.visibleEdit" class="btn-edit">Editar</button>
						<button type="button" ng-click="ctrl.btnConfirm()" ng-show="ctrl.visibleConfirm">Confirmar</button>
					</div>
					
				 	<div id="slideStage" class="slideStage" style="font-size:{{ctrl.slideFontSize / 3}}em;background-size:{{ctrl.slideWidth / 3}}px {{ctrl.slideHeight / 3}}px;width:{{ctrl.slideWidth / 3}}px;height:{{ctrl.slideHeight / 3}}px;color:{{ctrl.slideColorBody}};background-image:url(/praiser/uploads/admin/{{ctrl.slideBackground}});font-family:{{ctrl.slideFont}}">
				 		<div ng-bind-html="ctrl.phases[ctrl.slideEditIndex]" id="slideStageContent" class="alignCenterStage"></div>
			 		</div>
		 		</div>
			
			
			</div>
		</div>
	</div>
</div>
		
<script>

// var editable = document.getElementById("editable");

// $(".slideStage div").bind('input', function() { 
// 	console.log("chamou");
// 	console.log(html);
// 	var html = $(".slideStage div").html().replace(/<div>/gi,'<br>').replace(/<\/div>/gi,'');
// 	console.log(html);
// 	$(".slideStage div").html(html);
// })



</script>
		
		
		<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div>
				<div id="downloadStepOne" ng-show="ctrl.downloadStep == 1">
			    	<div style="float:left;height: 20px;width:20%;background-color:#00ffed"></div>
			    	<div style="text-align:center;float:left;height: 20px;width:80%;color:#ffffff;background-color:#d9d9d9">
			    		Preparando o download
			    	</div>
			    
					<div style="text-align:center;padding:0.6em;font-size:2em;font-weight: bold;color:#fe4a72">Ajuda a gente!</div>
			     	<div style="font-size:1.2em;padding:0.6em;text-align:center">
			     		Você já vai baixar seu arquivo e <span style="font-weight: bold">não<br>
			     		precisa pagar nada</span>, mas se você<br>
			     		puder contribuir com umas<br>
			     		moedinhas vai ajudar muuito!
			     	</div>
			     	<button type="button" style="border-radius:0.2em;border:0px;display:block;margin:0.6em auto;width:160px;background-color:#00b0f5;color:#ffffff;font-size:2em;font-weight:bold">Doar</button>
			     	<div style="padding:0.6em;text-align:center">
			     		<a href="#" ng-click="ctrl.saveSlide()" style="color:#084B8A;font-weight:bold">Hoje não, talvez na próxima...</a>
			     	</div>
				</div>
				
				<div id="downloadStepTwo" ng-show="ctrl.downloadStep == 2">
					<div style="float:left;height: 20px;width:20%;background-color:#00ffed"></div>
			    	<div style="text-align:center;float:left;height: 20px;width:80%;color:#ffffff;background-color:#d9d9d9">
			    		Download...
			    	</div>
			    	<div class="clearfix"></div>
					
					<div style="text-align:center;padding:0.6em;font-size:2em;font-weight: bold;color:#fe4a72">Prontinho!</div>
					<div style="padding:0.6em;text-align:center">
						<a href="/praiser/slide" style="margin-top:0.2em;float:right;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">fazer outro</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
</div>

	<style ng-repeat="font in ctrl.fonts track by $index">
	@font-face {
		font-family: {{font.font}};
		src: url(/praiser/uploads/admin/{{font.filename}});
	}
</style>
		
	</div>






</div>

<script>
// $("#musicLetter").jqte({
// 	format: false,
// 	link: false,
// 	source:false,
// 	p: false
// });


// (function() {
	 
// 	  window.onload = function() {
	   
// 	    editor = ContentTools.EditorApp.get();
// 	    editor.init('[data-editable]', 'data-name');
	    
// 	    $(".ct-widget").css("display","none");
// 	  };

// 	}).call(this);



</script>

<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/static/css/content-tools.min.css' />"> --%>

<%-- <script src="<c:url value='/static/js/content-tools.min.js' />"></script> --%>

<script src="<c:url value='/static/js/mlOverflow.js' />"></script>


<script src="<c:url value='/static/app/service/background_service.js' />"></script>
<script src="<c:url value='/static/app/service/font_service.js' />"></script>
<script src="<c:url value='/static/app/service/slide_service.js' />"></script>
<script src="<c:url value='/static/app/controller/slide_controller.js' />"></script>




<div id="mascara"></div>