<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<div style="width:33%;float:left;background-color:#00fe81;color:#ffffff;font-weight:bold;text-align:center;font-size:1em">Passo 1: escolha a música</div>
	<div style="width:34%;float:left;background-color:#fd5dff;color:#ffffff;font-weight:bold;text-align:center;font-size:1em">Passo 2: Personalizar</div>
	<div style="width:33%;float:left;background-color:#00ffed;color:#ffffff;font-weight:bold;text-align:center;font-size:1em">Passo 3: Download!</div>
</div>

<div style="background-color: #ffffff">
	<div ng-controller="SlideController as ctrl">
		<div>
			<div id="upload" ng-show="ctrl.statusUpload" style="width:33em;margin:8em auto">
				<div style="width:31em;margin:8em auto">
					<input ng-model="ctrl.music" ng-keydown="ctrl.searchMusic()" style="float:left;display:block;border-right:0px;border-left:1px solid #BEBEBE;border-top:1px solid #BEBEBE;border-bottom:1px solid #BEBEBE;font-size:1.4em;padding:0.2em;width:20em;height:40px" type="text" name="musica" id="musica" placeholder="Qual música você quer?"/>
	   				<div style="width:3em;height:40px;border-bottom:1px solid #BEBEBE;border-left:0px;border-top:1px solid #BEBEBE;border-right:1px solid #BEBEBE;float:left"><img src="static/img/search.png" alt="Buscar" width="30" style="margin:5px"/></div>
	   				<div class="clearfix"></div>
	   				<div>
	   					<div style="position:absolute">		   					
		   					<div class="list-group" style="width:31em">
	  							<button type="button" class="list-group-item" ng-repeat="lyric in ctrl.lyrics.response.docs" ng-if="lyric.title != null" ng-click="ctrl.selectMusic(lyric)">
	  								{{lyric.title}} - {{lyric.band}}
	  							</button>
							</div>
	   					</div>
	   				</div>
					<div style="clear:both"></div>
					
					<button type="button" ng-click="ctrl.upload()" style="margin-top:0.2em;float:right;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">Fazer upload da letra</button>
					<div style="clear:both"></div>
					
				</div>
			</div>
			
			<div id="preview" ng-show="ctrl.statusPreview">
				<div>
					<div style="border-bottom:0.3em dashed #f5f5f5;margin:1em"></div> 
					<div style="width:60em;margin:0 auto">
						<div style="width:30em;padding:0.4em;background-color:#FFD700;color:#ffffff;width:100px;font-weight:bold;font-size:1.4em;text-align:center">Preview</div>
						<textarea id="musicLetter" ng-model="ctrl.slide.musicLetter"></textarea>
						<button type="button" ng-click="ctrl.personalize()" style="margin-top:0.2em;float:right;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">Próximo</button>
					 </div>
				 </div>
			 </div>
		 </div> 
		 	 
		 <div id="personalize" ng-show="ctrl.statusPersonalize">
		 	<div style="padding-top: 5em">
		 		<div style="float:left;width:33%;padding-left: 1em;font-size:2em;color:#d9d9d9">Fonte:</div>
		 		<div style="float:left;width:34%;padding-left: 1em;font-size:2em;color:#d9d9d9">Cor:</div>
		 		<div style="float:left;width:33%;padding-left: 1em;font-size:2em;color:#d9d9d9">Formato:</div>
		 		
		 		<div class="clearfix"></div>
		 		
		 		<div style="background-color: #fafafa;padding:2em">
			 		<div id="panelFont" style="float:left;width:33%;border-right:5px solid #ffffff">
			 			<div style="padding:2em">
							<div ng-repeat="font in ctrl.fonts" style="font-family:{{font.font}};margin:0.2em;float:left">
								<div ng-click="ctrl.changeFont(font.font)" style="font-family:{{font.font}};font-size:1em;text-align:center;padding:1em;border:0px;background-color:#ffffff" >
									<div style="font-weight: bold;color:#000000">{{font.font}}</div>
									<div style="color: blue">Type</div>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
	
			 				<div class="clearfix"></div>
			 			</div>
			 		</div>
			 		
			 		<div style="float:left;width:34%">
			 			<div style="padding:2em">
	
			 				<div ng-repeat="background in ctrl.backgrounds">
								<div ng-click="ctrl.changeBackground(background.filename, background.colorTitle, background.colorBody)" style="height:90px;background-repeat:no-repeat;background-image:url(/praiser/uploads/admin/{{background.filename}});background-size:160px 90px;margin:0.2em;float:left;text-align:center;padding:0.6em;width:160px;border:1px solid #000000;">
									<div style="width:50%;float:left;margin-top:20px">
										<div style="margin:0 auto;border-radius:100%;background-color:{{background.colorTitle}};width:30px;height:30px"></div>
									</div>
									<div style="width:50%;float:left;margin-top:20px">
										<div style="margin:0 auto;border-radius:100%;background-color:{{background.colorBody}};width:30px;height:30px"></div>
									</div>
								</div>
							</div>	
							
			 				<div class="clearfix"></div>
			 			</div>
			 			<div class="clearfix"></div>
			 		</div>
			 		
			 		<div style="float:left;width:33%">
			 			<div style="padding:2em">
			 			
			 				<div style="text-align:center;font-weight:bold;width:100px;height:75px;background-color:#ffffff;margin:0 auto;font-size:2em;color:gray;padding:0.6em" ng-click="ctrl.selectRatio(1333,1000)">4:3</div>
			 				
			 				<div style="text-align:center;font-weight:bold;width:133px;height:75px;background-color:#ffffff;margin:1em auto;font-size:2em;color:gray;padding:0.6em" ng-click="ctrl.selectRatio(1777,1000)">16:9</div>
			 			
			 			</div>
			 			<div class="clearfix"></div>
			 		</div>
			 		<div class="clearfix"></div>
		 		</div>
		 	</div>
		 	 
			<div style="max-width: 1100px;margin:2em auto;">
			 	<div ng-repeat="phase in ctrl.phases">
		 			<div class="slide" style="background-size:{{ctrl.slideWidth / 7}}px {{ctrl.slideHeight / 7}}px;width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px;color:{{ctrl.slideColorBody}};background-image:url(/praiser/uploads/admin/{{ctrl.slideBackground}});font-family:{{ctrl.slideFont}}">
			 			<div ng-bind-html="phase"></div>
		 				<div class="clearfix"></div>
		 			</div>
			 	</div>
		 	</div>	
		 	<div style="clear:both"></div>
		 	<button type="button" ng-click="ctrl.done()" style="margin-top:0.2em;float:right;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">Próximo</button>
		 </div>
		 
		<div id="done" ng-show="ctrl.statusDone">
			<div style="max-width: 1100px;margin:2em auto;padding-top:3px">
				<div style="font-size:2em;font-weight:bold;color:#fd5dff;padding-bottom:0.5em">Uau! Olha como ficou...</div>
			 		<div ng-repeat="phase in ctrl.phases">
		 				<div class="slide" style="background-size:{{ctrl.slideWidth / 7}}px {{ctrl.slideHeight / 7}}px;width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px;color:{{ctrl.slideColorBody}};background-image:url(/praiser/uploads/admin/{{ctrl.slideBackground}});font-family:{{ctrl.slideFont}}">
				 			<div ng-bind-html="phase"></div>
		 					<div class="clearfix"></div>
		 				</div>
			 		</div>
		 			<div class="clearfix"></div>
		 	</div>
			<div style="clear:both"></div>
			<button type="button" ng-click="ctrl.download()" style="display:block;margin:0.2em auto;padding:0.4em;border:0px;background-color:#7d01a1;color:#ffffff;font-size:1.6em;font-weight:bold;width:14em"><img src="static/img/download-from-cloud.png" alt="download" width="30" style="margin:5px"/>Download</button>
			<div style="clear:both"></div>
		</div>		
		
		
		
		
		
		
		
		
		<div id="canvasSlide" style="display:none">
	<div ng-repeat="phase in ctrl.phases">
		<div class="slideSave" style="background-size:{{ctrl.slideWidth}}px {{ctrl.slideHeight}}px;width:{{ctrl.slideWidth}}px;height:{{ctrl.slideHeight}}px;color:{{ctrl.slideColorBody}};background-image:url(/praiser/uploads/admin/{{ctrl.slideBackground}});font-family:{{ctrl.slideFont}}">
			<div ng-bind-html="phase"></div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearfix"></div>
</div>	
		
		
		
		
		
		
		<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="width:320px">
	<div class="modal-dialog" role="document" style="width:320px">
		<div class="modal-content" style="width:320px">
			<div style="width:319px">
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

	
		
	</div>

<style ng-repeat="font in ctrl.fonts">
	@font-face {
		font-family: {{font.font}};
		src: url(/praiser/uploads/admin/{{font.filename}});
	}
</style>




</div>

<script>
$("#musicLetter").jqte({
	format: false,
	link: false,
	source:false
});
</script>

<script src="<c:url value='/static/app/service/background_service.js' />"></script>
<script src="<c:url value='/static/app/service/font_service.js' />"></script>
<script src="<c:url value='/static/app/service/slide_service.js' />"></script>
<script src="<c:url value='/static/app/controller/slide_controller.js' />"></script>


