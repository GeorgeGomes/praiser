<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="background-color: #ffffff">
	<div ng-controller="SlideController as ctrl">
		 <input type="text" name="musica" id="musica" placeholder="Qual música você quer?"/>
		 <button type="button">Fazer upload da letra</button>
		 <div style="border-bottom:2px dashed #f5f5f5"></div>
		 <div>Preview</div>
		 <textarea ng-model="ctrl.slide.musicLetter"></textarea>
		 <div></div>
		 <button type="button" ng-click="ctrl.create()">Próximo</button>
		 
	</div>

</div>

<script src="<c:url value='/static/app/service/slide_service.js' />"></script>
<script src="<c:url value='/static/app/controller/slide_controller.js' />"></script>


