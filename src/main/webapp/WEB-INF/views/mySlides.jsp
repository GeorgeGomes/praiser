<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-controller="SlideController as ctrl">

	<div style="padding:2em">
		<div style="padding-top:0.2em;padding-bottom:0.2em;font-size:3em;font-weight:bold">Meus Slides</div>
		
		<div ng-repeat="slide in ctrl.slides" style="margin:0.2em;position:relative;float:left;width:100px;height:100px">
			<div class="slide" style="position:relative;float:left;font-size:1em;background-size:100px 100px;width:100px;height:100px;color:#000000;background-color:#ffffff;font-family:arial">
				<div class="slideContent">{{slide.music}}</div>
			</div>
		</div>
		
		
		
		
		
	</div>

</div>

<script src="<c:url value='/static/app/service/background_service.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/app/service/font_service.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/app/service/slide_service.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/app/controller/slide_controller.js' />" charset="utf-8"></script>
