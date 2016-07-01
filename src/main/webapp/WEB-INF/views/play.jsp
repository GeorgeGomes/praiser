<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html ng-app="praiser">
<head>
<title>Praiser - Play</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>" charset="utf-8" />
<link rel="stylesheet" href="<c:url value="/static/css/style.css"/>" charset="utf-8" />
<link rel="stylesheet" href="<c:url value="/static/css/angular-material.min.css"/>" charset="utf-8" />

<script src="<c:url value="/static/js/jquery.min.js"/>" charset="utf-8"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>" charset="utf-8"></script>
<script src="<c:url value="/static/js/util.js"/>" charset="utf-8"></script>

<script src="<c:url value='/static/js/angular/angular.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-animate.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-aria.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-cookies.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-loader.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-message-format.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-messages.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-parse-ext.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-resource.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-sanitize.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-touch.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-material.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-file-upload.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-validation-match.min.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/angular/angular-route.js' />" charset="utf-8"></script>
<script src="<c:url value='/static/js/prefixfree.min.js' />" charset="utf-8"></script>



<script src="<c:url value='/static/app/app.js' />" charset="utf-8"></script>

<!--[if gte IE 9]>
  <style type="text/css">
    .gradient {
       filter: none;
    }
  </style>
<![endif]-->
</head>
<body>

<div ng-controller="PlayController as ctrl">

	<div ng-repeat="phase in ctrl.phases track by $index" on-finish-render="ngRepeatFinished">
		<div class="slidePlay slideHide" id="slide-{{$index+1}}" style="border:1px solid #000000;width:100%;color:{{$index == 0 ? ctrl.slide.background.colorTitle : ctrl.slide.background.colorBody}};{{ctrl.slide.background.filename == '' ? 'background-color:#ffffff' : 'background-image:url(/praiser/uploads/admin/' + ctrl.slide.background.filename + ')'}};font-family:{{ctrl.slide.font.font}}">
			<div class="slideContent" ng-bind-html="phase"></div>
		</div>
	</div>

	<style ng-repeat="font in ctrl.fonts track by $index">
		@font-face {
			font-family: {{font.font}};
			src: url(/praiser/uploads/admin/{{font.filename}});
		}
	</style>
	
</div>





	<script src="<c:url value='/static/app/service/background_service.js' />" charset="utf-8"></script>
	<script src="<c:url value='/static/app/service/font_service.js' />" charset="utf-8"></script>
	<script src="<c:url value='/static/app/service/slide_service.js' />" charset="utf-8"></script>
	<script src="<c:url value='/static/app/controller/play_controller.js' />" charset="utf-8"></script>
	<script src="<c:url value='/static/app/service/user_service.js' />" charset="utf-8"></script>
	<script src="<c:url value='/static/app/controller/user_controller.js' />" charset="utf-8"></script>
	
	<script>

	
	$(window).resize(function(){
		console.log("resize")
		var height = $( document ).height();	
		var width = $( document ).width();
		
		$(".slidePlay").css("height", height);
		$(".slidePlay").css("font-size", width/300 + "em");
	})

	
	</script>
	
	
</body>
</html>

