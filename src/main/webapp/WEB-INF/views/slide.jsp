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
				<div style="width:33em;margin:8em auto">
					<input style="float:left;display:block;border-right:0px;border-left:1px solid #BEBEBE;border-top:1px solid #BEBEBE;border-bottom:1px solid #BEBEBE;font-size:1.4em;padding:0.2em;width:20em;height:40px" type="text" name="musica" id="musica" placeholder="Qual música você quer?"/>
	   				<div style="width:5em;height:40px;border-bottom:1px solid #BEBEBE;border-left:0px;border-top:1px solid #BEBEBE;border-right:1px solid #BEBEBE;float:left">Buscar</div>
	   				
					<div style="clear:both"></div>
					
					<button type="button" ng-click="ctrl.upload()" style="margin-top:0.2em;float:right;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">Fazer upload da letra</button>
					<div style="clear:both"></div>
					
					<textarea id="musictest" ng-model="ctrl.musictest"></textarea>
					
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
		 	<div>
		 		<div id="panelFont" style="float:left;width:33%;color:#d9d9d9">
		 			FONTE:
		 			<div style="background-color: #d9d9d9">
<!-- 			 			<div class="btn-font"> -->
<!-- 			 				<div>LEAGUE</div> -->
<!-- 			 				<div style="color:blue;font-size:0.6em">Type</div> -->
<!-- 			 			</div> -->
<!-- 			 			<div class="btn-font"> -->
<!-- 			 				Open Sans -->
<!-- 			 				<div style="color:blue;font-size:0.6em">Type</div> -->
<!-- 			 			</div> -->
<!-- 			 			<div class="btn-font"> -->
<!-- 			 				Josefine -->
<!-- 			 				<div style="color:blue;font-size:0.6em">Type</div> -->
<!-- 			 			</div> -->
<!-- 			 			<div class="btn-font"> -->
<!-- 			 				Montserrat -->
<!-- 			 				<div style="color:blue;font-size:0.6em">Type</div> -->
<!-- 			 			</div> -->
<!-- 			 			<div class="btn-font"> -->
<!-- 			 				Helvetica -->
<!-- 			 				<div style="color:blue;font-size:0.6em">Type</div> -->
<!-- 			 			</div> -->
<!-- 			 			<div class="btn-font font-asul" ng-click="ctrl.changeFont('asul')"> -->
<!-- 			 				Asul -->
<!-- 			 				<div style="color:blue;font-size:0.6em">Type</div> -->
<!-- 			 			</div> -->
<!-- 			 			<div class="btn-font font-cabin-sketch" ng-click="ctrl.changeFont('cabinSketch')"> -->
<!-- 			 				Sketch -->
<!-- 			 				<div style="color:blue;font-size:0.6em">Type</div> -->
<!-- 			 			</div> -->
<!-- 			 			<div class="btn-font"> -->
<!-- 			 				QUICKSAND -->
<!-- 			 				<div style="color:blue;font-size:0.6em">Type</div> -->
<!-- 			 			</div> -->
<!-- 			 			<div class="btn-font"> -->
<!-- 			 				OVERPASS -->
<!-- 			 				<div style="color:blue;font-size:0.6em">Type</div> -->
<!-- 			 			</div> -->

						<div ng-repeat="font in ctrl.fonts" style="font-family:{{font.font}};margin:0.2em;float:left;width:12em">
							<div ng-click="ctrl.changeFont(font.font)" style="font-family:{{font.font}};font-size:0.8em;text-align:center;padding:0.6em;border:1px solid #000000;background-color:#ffffff;" >
								<div style="font-weight: bold;color:#000000">{{font.font}}</div>
								<div style="color: blue">Type</div>
								<div class="clearfix"></div>
							</div>
							<div class="clearfix"></div>
						</div>


		 				<div class="clearfix"></div>
		 			</div>
		 		</div>
		 		<div style="float:left;width:34%;color:#d9d9d9">
		 			COR:
		 			<div style="background-color: #d9d9d9">
		 			
		 			</div>
		 			<div class="clearfix"></div>
		 		</div>
		 		<div style="float:left;width:33%;color:#d9d9d9">
		 			FORMATO:
		 			<div style="background-color: #d9d9d9">
		 			</div>
		 			<div class="clearfix"></div>
		 		</div>
		 		<div class="clearfix"></div>
		 	</div>
		 
		 	 
		 	<div ng-repeat="phase in ctrl.phases">
	 			<div style="background-image:url(/praizer/static/img/sishelp.png);font-family:{{ctrl.font}};margin:0.2em;border:1px solid #000000;text-align:center;width:300px;height:200px;float:left">
		 			{{phase}}
	 				<div style="clear:both"></div>
	 			</div>
		 	</div>	
		 	<div style="clear:both"></div>
		 	<button type="button" ng-click="ctrl.done()" style="margin-top:0.2em;float:right;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">Próximo</button>
		 </div>
		 
		<div id="done" ng-show="ctrl.statusDone">
			<div>Uau! Olha como ficou...</div>
			<div id="canvasSlide">
		 		<div name="slide" ng-repeat="phase in ctrl.phases">
					<div style="background-image:url(/praizer/static/img/sishelp.png);font-family:{{ctrl.font}};margin:0.2em;border:1px solid #000000;text-align:center;width:300px;height:200px;float:left">
		 				{{phase}}
	 					<div style="clear:both"></div>
	 				</div>
				</div>
		 		<div style="clear:both"></div>
		 	</div>
			<div style="clear:both"></div>
			<button type="button" ng-click="ctrl.download()" style="margin:0.2em auto;padding:0.4em;border:0px;background-color:#00ffed;color:#ffffff;font-size:1.2em;font-weight:bold">Download</button>
			<div style="clear:both"></div>
		</div>
		
		
		
		<button ng-click="ctrl.saveSlide()">teste</button>
			<div id="img-out"></div>
		
		
		
		
		<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
		<div>Ajuda a gente!</div>
     	<div>
     		Você já vai baixar seu arquivo e não<br/>
     		precisa pagar nada, mas se você<br/>
     		puder contribuir com umas<br/>
     		moedinhas vai ajudar muuito!
     	</div>
     	<button type="button">Doar</button>
     	<a href="#" ng-click="ctrl.saveSlide()">Hoje não, talvez na próxima...</a>
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

<script src="<c:url value='/static/app/service/font_service.js' />"></script>
<script src="<c:url value='/static/app/service/slide_service.js' />"></script>
<script src="<c:url value='/static/app/controller/slide_controller.js' />"></script>


