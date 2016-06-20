<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-controller="SlideController as ctrl">
	<div>
		<div class="stepUpload {{ctrl.statusUpload == true ? 'pink' : 'green'}}" style="">Passo 1: escolha a música</div>
		<div class="stepPersonalize {{ctrl.statusPersonalize == true ? 'purple' : 'gray'}}">{{ctrl.statusPersonalize == true ? 'Passo 2: Personalizar' : ''}}</div>
	</div>
	<div class="clearfix"></div>

<div style="background-color: #ffffff">
	
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
			
			<div id="personalize" ng-show="ctrl.statusPersonalize">						
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
							<div class="content-fonts">
								<div class="mlOverflow" style="height:17em;overflow-y:hidden;position: absolute;width: 28%;background-color: #fafafa" data-mlOverflow_more="Expand" data-mlOverflow_less="Contract">
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
							<div class="content-backgrounds">
								<div>
									<div ng-repeat="background in ctrl.backgrounds" style="background-image:url(/praiser/uploads/admin/{{background.filename}})" class="btn-background" ng-click="ctrl.changeBackground(background.filename, background.colorTitle, background.colorBody)">											
										<div class="font-color left" style="background-color:{{background.colorTitle}}"></div>
										<div class="font-color right" style="background-color:{{background.colorBody}}"></div>
										<div class="clearfix"></div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="content-ratios">
								<div>
									<div class="btn-ratio {{ctrl.ratio == '4:3' ? 'btn-ratio-border' : ''}}" style="width:100px" ng-click="ctrl.selectRatio('4:3')">4:3</div>
			 						<div class="btn-ratio {{ctrl.ratio == '16:9' ? 'btn-ratio-border' : ''}}" style="width:133px;margin:1em auto" ng-click="ctrl.selectRatio('16:9')">16:9</div>
			 						<div class="clearfix"></div>
			 					</div>
							</div>
							<div class="clearfix"></div>
						</div>
						
						<div class="content-preview">
							<div class="titlePersonalise">Preview:</div>
							<div class="clearfix"></div>
						
							<div ng-repeat="phase in ctrl.phases track by $index" style="margin:0.2em;position:relative;float:left;width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px">
					 			<div title="Editar slide!" ng-mouseleave="ctrl.editMouseLeave('slideEdit'+$index)" ng-mouseover="ctrl.editMouseOver('slideEdit'+$index)" ng-click="ctrl.selectSlide($index)" class="slide" style="position:relative;float:left;font-size:{{ctrl.slideFontSize / 7}}em;background-size:{{ctrl.slideWidth / 7}}px {{ctrl.slideHeight / 7}}px;width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px;color:{{$index == 0 ? ctrl.slideColorTitle : ctrl.slideColorBody}};{{ctrl.slideBackground == '' ? 'background-color:#ffffff' : 'background-image:url(/praiser/uploads/admin/' + ctrl.slideBackground + ')'}};font-family:{{ctrl.slideFont}}">
					 				<div title="Editar" class="slideEdit" id="slideEdit{{$index}}" style="width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px"></div>
					 				<div id="slideContent{{$index}}" class="slideContent" ng-bind-html="phase"></div>
				 					<div class="clearfix"></div>
				 				</div>
				 				<div title="Excluir" class="slideDelete" id="slideDelete{{$index}}" ng-click="ctrl.deleteSlide($event, $index)"></div>
					 		</div>
					 		<div>
					 			<div title="Adicionar slide!" ng-click="ctrl.newSlide()" class="slide slideNew" style="margin:0.2em;position:relative;float:left;width:{{ctrl.slideWidth / 7}}px;height:{{ctrl.slideHeight / 7}}px;">
				 				</div>
					 		</div>
					 		<div class="clearfix"></div>
					 		<div style="padding-top:2em">
					 			<button type="button" ng-click="ctrl.back()" class="btn-back">Voltar</button>
								<button type="button" ng-click="ctrl.download()" class="btn-download"><img src="static/img/download-from-cloud.png" alt="download" width="30" style="margin:5px"/>Download</button>
							</div>
				 		</div>
					 </div>
				
			 </div>
		 </div> 
		
		
<div id="canvasSlide" style="position: absolute; opacity: 0.0;display:none">
	<div ng-repeat="phase in ctrl.phases track by $index">
		<div class="slideSave" data-index="{{$index}}" style="border:1px solid black;font-size:{{ctrl.slideFontSize}}em;background-size:{{ctrl.slideWidth}}px {{ctrl.slideHeight}}px;width:{{ctrl.slideWidth}}px;height:{{ctrl.slideHeight}}px;color:{{$index == 0 ? ctrl.slideColorTitle : ctrl.slideColorBody}};{{ctrl.slideBackground == '' ? 'background-color:#ffffff' : 'background-image:url(/praiser/uploads/admin/' + ctrl.slideBackground + ')'}};font-family:{{ctrl.slideFont}}">
			<div ng-bind-html="phase"></div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearfix"></div>
</div>	
		
		


<div class="modal fade" id="mySlide" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
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
		


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="stepDownloadOne"></div>
			<div class="stepDownloadTwo {{ctrl.downloadStep < 2 ? 'gray' : ''}}">{{ctrl.downloadStep < 2 ? '' : 'Preparando o download'}}</div>
			<div class="stepDownloadThree {{ctrl.downloadStep < 3 ? 'gray' : ''}}">{{ctrl.downloadStep < 3 ? '' : 'Download...'}}</div>
			
				<div id="downloadStepOne" ng-show="ctrl.downloadStep == 1">
					<div style="padding:2em">
						<div style="text-align:center;padding:0.6em;font-size:2em;font-weight: bold;color:#fe4a72">Ajuda a gente!</div>
				     	<div style="font-size:1.2em;padding:0.6em;text-align:center">
				     		Você já vai baixar seu arquivo e <span style="font-weight: bold">não<br>
				     		precisa pagar nada</span>, mas se você<br>
				     		puder contribuir com umas<br>
				     		moedinhas vai ajudar muuito!
				     	</div>
				     	<button type="button" style="border-radius:0.2em;border:0px;display:block;margin:0.6em auto;width:160px;background-color:#00b0f5;color:#ffffff;font-size:2em;font-weight:bold">Doar</button>
				     	<div style="padding:0.6em">
				     		<a href="#" data-dismiss="modal" aria-label="Close" style="text-align:left;">voltar</a>
				     		<a href="#" ng-click="ctrl.saveSlide()" style="text-align:center;color:#084B8A;font-weight:bold">Hoje não, talvez na próxima...</a>
				     	</div>
			     	</div>
				</div>
				<div id="downloadStepTwo" ng-show="ctrl.downloadStep == 2">
					<div style="padding:2em">
				    	<div style="text-align:center;padding:0.6em;font-size:2em;font-weight: bold;color:#fe4a72">Estamos preparando o download!</div>
				    	<div class="clearfix"></div>
						
						<div style="text-align:center;padding:0.6em;font-size:2em;font-weight: bold;color:#03e571">Aguarde um momentinho...</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div id="downloadStepThree" ng-show="ctrl.downloadStep == 3">
					<div style="padding:2em">
						<div style="text-align:center;padding:0.6em;font-size:2em;font-weight: bold;color:#fe4a72">Prontinho!</div>
						<div style="padding:0.6em;text-align:center">
							<button  ng-click="ctrl.resetSlide()" style="margin:0 auto;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">fazer outro</button>
							<button  ng-click="ctrl.home()" style="margin:0 auto;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">voltar para home</button>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			
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


<script src="<c:url value='/static/app/service/background_service.js' />"></script>
<script src="<c:url value='/static/app/service/font_service.js' />"></script>
<script src="<c:url value='/static/app/service/slide_service.js' />"></script>
<script src="<c:url value='/static/app/controller/slide_controller.js' />"></script>


<div id="mascara"></div>