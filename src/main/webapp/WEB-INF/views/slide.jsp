<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
	<div style="width:33%;float:left">Passo 1: escolha a música</div>
	<div style="width:33%;;float:left">Passo 2: Personalizar</div>
	<div style="width:33%;;float:left">Passo 3: Download!</div>
</div>

<div style="background-color: #ffffff">
	<div ng-controller="SlideController as ctrl">
		<div id="upload">
			 <input type="text" name="musica" id="musica" placeholder="Qual música você quer?"/>
			 <button type="button" ng-click="ctrl.upload()">Fazer upload da letra</button>
			
			<textarea ng-model="ctrl.musictest"></textarea>
		</div>
		<div id="stepOne" ng-show="ctrl.statusStepOne">
			 <div style="border-bottom:0.3em dashed #f5f5f5;margin:1em"></div> 
			 <div>
			 	<div style="width:30em;padding:0.4em;background-color:#FFD700;color:#ffffff;width:100px;font-weight:bold;font-size:1.4em;text-align:center">Preview</div>
			 	 <textarea ng-model="ctrl.slide.musicLetter" style="width:600px;height:500px"></textarea>
			 	<button type="button" ng-click="ctrl.stepOne()">Próximo</button>
			 </div>
		 </div> 
		 <div id="stepTwo" ng-show="ctrl.statusStepTwo">
		 	<div ng-repeat="phase in ctrl.phases" style="margin:0.2em;border:1px solid #000000;text-align:center;width:300px;height:200px;float:left">
		 		{{phase}}
		 		<div style="clear:both"></div>
		 	</div>
		 	<div style="clear:both"></div>
		 </div>
	</div>

</div>

<script src="<c:url value='/static/app/service/slide_service.js' />"></script>
<script src="<c:url value='/static/app/controller/slide_controller.js' />"></script>


