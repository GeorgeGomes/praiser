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
	   				<div style="width:3em;height:40px;border-bottom:1px solid #BEBEBE;border-left:0px;border-top:1px solid #BEBEBE;border-right:1px solid #BEBEBE;float:left"><img src="<c:url value='/static/img/search.png' />" alt="Buscar" width="30" style="margin:5px"/></div>
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
						<div class="clearfix"></div>
						<div class="content-personalise">
							<div class="content-fonts">
								<div style="height:17em;overflow-y:hidden;position: absolute;width: 38%;background-color: #fafafa">
									<div class="mlOverflow_text">
										<div ng-repeat="font in ctrl.fonts track by $index" style="font-family:{{font.font}}" class="btn-font" ng-click="ctrl.changeFont(font)">
											<div>{{font.font}}</div>
											<div class="type">Type</div>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="content-backgrounds">
								<div>
									<div ng-repeat="background in ctrl.backgrounds" style="background-image:url(/praiser/uploads/admin/{{background.filename}})" class="btn-background {{ctrl.background.filename == '4:3' ? 'btn-selected' : ''}}" ng-click="ctrl.changeBackground(background)">											
										<div class="font-color left" style="background-color:{{background.colorTitle}}"></div>
										<div class="font-color right" style="background-color:{{background.colorBody}}"></div>
										<div class="clearfix"></div>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							
							<div class="clearfix"></div>
						</div>
						
						<div class="content-preview">
							<div class="titlePersonalise" style="padding-top:0em !important;padding-left:0em !important">Preview:</div>
							<div class="clearfix"></div>
						
							<div ng-repeat="phase in ctrl.phases track by $index" class="thumb-slide">
					 			<div title="Editar slide!" ng-mouseleave="ctrl.editMouseLeave('slideEdit'+$index)" ng-mouseover="ctrl.editMouseOver('slideEdit'+$index)" ng-click="ctrl.selectSlide($index)" class="slide thumb-slide" style="color:{{$index == 0 ? ctrl.slide.background.colorTitle : ctrl.slide.background.colorBody}};{{ctrl.slide.background.filename == '' ? 'background-color:#ffffff' : 'background-image:url(/praiser/uploads/admin/' + ctrl.slide.background.filename + ')'}};font-family:{{ctrl.slide.font.font}}">
					 				<div title="Editar" class="slideEdit" id="slideEdit{{$index}}"></div>
					 				<div id="slideContent{{$index}}" class="slideContent" ng-bind-html="phase"></div>
				 					<div class="clearfix"></div>
				 				</div>
				 				<div title="Excluir" class="slideDelete" id="slideDelete{{$index}}" ng-click="ctrl.deleteSlide($event, $index)"></div>
					 		</div>
					 		<div class="thumb-slide">
					 			<div title="Adicionar slide!" ng-click="ctrl.newSlide()" class="slide slide-new thumb-slide"></div>
					 		</div>
					 		<div class="clearfix"></div>
					 		<div style="padding-top:2em">
					 			<button type="button" ng-click="ctrl.back()" class="btn-back">Voltar</button>
								<button type="button" ng-click="ctrl.saveSlide2()" class="btn-download"><img src="<c:url value='/static/img/download-from-cloud.png' />" alt="download" width="30" style="margin:5px"/>Salvar</button>
							</div>
				 		</div>
					 </div>
				
			 </div>
		 </div> 
		
		
<div id="canvasSlide" style="position: absolute; opacity: 0.0;display:none">
	<div ng-repeat="phase in ctrl.phases track by $index">
		<div class="slideSave" style="border:1px solid black;font-size:{{ctrl.slideFontSize}}em;background-size:{{ctrl.slideWidth}}px {{ctrl.slideHeight}}px;width:{{ctrl.slideWidth}}px;height:{{ctrl.slideHeight}}px;color:{{$index == 0 ? ctrl.slideColorTitle : ctrl.slideColorBody}};{{ctrl.background.filename == '' ? 'background-color:#ffffff' : 'background-image:url(/praiser/uploads/admin/' + ctrl.background.filename + ')'}};font-family:{{ctrl.font.font}}">
			<div class="slideContent" ng-bind-html="phase"></div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="clearfix"></div>
</div>	
		
		


<div class="modal fade" id="mySlide" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div>
				<div style="height:560px;float:left;width:660px;padding:10px;border-top:1px solid #fafafa;border-right:1px solid #fafafa;border-bottom:1px solid #fafafa;background-color:#ffffff">
			 		<div style="text-align:right;position:relative;z-index:2">
						<button type="button" ng-click="ctrl.btnSlideCancel()" class="btn-cancel">Fechar</button>
					</div>
					
				 	<div id="slideStage" class="slideStage" style="font-size:1.9em;background-size:600px 450px;width:600px;height:450px;color:{{ctrl.slide.background.colorBody}};background-image:url(/praiser/uploads/admin/{{ctrl.slide.background.filename}});font-family:{{ctrl.slide.font.font}}">
				 		<div ng-bind-html="ctrl.phases[ctrl.slideEditIndex]" id="slideStageContent" class="alignCenterStage"></div>
			 		</div>
			 		
					<div style="text-align:right;position:relative;z-index:2">			 		
			 			<button type="button" ng-click="ctrl.btnSlideEdit()" ng-show="ctrl.visibleBtnSlideEdit" class="btn-edit">Editar</button>
						<button type="button" ng-click="ctrl.btnSlideConfirm()" ng-show="ctrl.visibleBtnSlideConfirm" class="btn-save">Salvar</button>
					</div>
		 		</div>
			
			
			</div>
		</div>
	</div>
</div>
		


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
				     		<a href="#" data-dismiss="modal" aria-label="Close" style="text-align:left;fon-size:1.2em;color:#7D7B7B;display:block;float:left">voltar</a>
				     		<a href="#" ng-click="ctrl.saveSlide2()" style="text-align:center;color:#084B8A;font-weight:bold;display:block;width:300px;margin:0 auto">Hoje não, talvez na próxima...</a>
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


<script>
$(".content-fonts").hover(function() {
    var height = $(this).height();
    var pad = height + 5;

var height2 = $(this)[0].scrollHeight;

if (height2 > 35)
    {
          $(this).animate({
                 height: height2
            }, 300);
    }
}, function() {
    $(this).stop(true, false).animate({
        height: 35
    },150);
});
</script>


<style ng-repeat="font in ctrl.fonts track by $index">
	@font-face {
		font-family: {{font.font}};
		src: url(/praiser/uploads/admin/{{font.filename}});
	}
</style>


<script src="<c:url value='/static/app/service/background_service.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/app/service/font_service.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/app/service/slide_service.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/app/controller/newSlide_controller.js' />" charset="utf-8"></script>
