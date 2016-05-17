<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="background-color: #ffffff">
	<div ng-controller="SlidesController as ctrl">
		 <input type="text" name="musica" id="musica" placeholder="Qual música você quer?"/>
		 <button type="button">Fazer upload da letra</button>
		 <div style="border-bottom:2px dashed #f5f5f5"></div>
		 <div>Preview</div>
		 
		 <div></div>
	</div>

</div>

<script src="/static/js/angular/angular.min.js"></script>
<script src="/static/js/angular/angular-messages.min.js"></script>

<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/static/app/controller/slides_controller.js' />"></script>


