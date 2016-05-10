<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-app="praizer" ng-cloak style="background-color: #ffffff">
	<div ng-controller="SlidesController as ctrl">
		 <input type="text" name="musica" id="musica" placeholder="Qual música você quer?"/>
		 <button type="button">Fazer upload da letra</button>
		 <div style="border-bottom:2px dashed #f5f5f5"></div>
		 <div>Preview</div>
	</div>

</div>

<!-- Angular Material requires Angular.js Libraries -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js"></script>
<script src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.0-rc4/angular-material.js"></script>

<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/static/app/controller/slides_controller.js' />"></script>


