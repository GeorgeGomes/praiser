<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="static/css/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="static/css/style.css"/>" />
  <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/angular_material/1.1.0-rc2/angular-material.min.css">
<link rel="stylesheet"
	href="https://material.angularjs.org/1.1.0-rc4/docs.css" />
<script src="<c:url value="static/js/jquery.min.js"/>"></script>
<script src="<c:url value="static/js/bootstrap.min.js"/>"></script>
<!--[if gte IE 9]>
  <style type="text/css">
    .gradient {
       filter: none;
    }
  </style>
<![endif]-->
</head>
<body>

<md-dialog aria-label="Mango (Fruit)"> <md-icon md-svg-src="img/icons/ic_close_24px.svg" aria-label="Close dialog" ng-click="hide()"></md-icon> </md-button>
<div style="padding: 4em; width: 36em;">
	<div style="margin:0 auto;width: 22em">
		<div style="line-height: 50px; height: 50px; font-size: 1.4em; font-weight: bold; float: left; width: 5em">Feito por:</div>
		<div style="height: 50px; float: left; width: 50px">
			<img src="<c:url value="static/img/user.png"/>" width="50" style="border-radius: 100%" />
		</div>
		<div style="height: 50px; float: left; width: 11em">
			<div style="font-weight: bold; font-size: 1.4em;">Mari Galindo</div>
			<div style="font-size: 1em;">Hilsong SP</div>
		</div>
		<div style="clear: both;"></div>
	</div>
	
	<div style="box-shadow: 10px 5px 20px #888888;text-align:center;margin: 1em auto;width: 22em;background-color:#c0c0c0;height:12em;line-height:12em">
	<span style="font-size:2em;color:#ffffff;">HOSANA!!</span>
	
	</div>
	
	
	<div style="text-align:center">
	<div>Para fazer download você precisa</div>
	<div>entrar na sua conta ou se cadastrar</div>

	</div>
	<div style="width:20em;margin:0 auto;">
	<a style="margin:0.1em;float:left;width:8em;text-align:center;display:block;font-size:1.2em;font-weight:bold;background-color:#ffffff;border-radius:0.4em;color:#000000;padding:0.8em 1.5em 0.8em 1.5em;border:1px solid #000000" href="login">Login</a>
	<a style="margin:0.1em;float:left;width:8em;text-align:center;display:block;font-size:1.2em;font-weight:bold;background-color:#00FFFF;border-radius:0.4em;color:#000000;padding:0.8em 1.5em 0.8em 1.5em" href="signup">Sign Up</a>
	<div style="clear: both;"></div>
	</div>
	
	<div style="clear: both;"></div>
</div>

</md-dialog>

<!-- Angular Material requires Angular.js Libraries -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script> -->
<!-- <script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js"></script> -->
<!-- <script src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.0-rc4/angular-material.js"></script> -->

<%-- <script src="<c:url value='/static/app/app.js' />"></script> --%>
<%-- <script src="<c:url value='/static/app/controller/login_controller.js' />"></script> --%>

</body>
</html>
