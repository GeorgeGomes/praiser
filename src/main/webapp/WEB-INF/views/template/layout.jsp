<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html ng-app="praizer">
<head>
<title>Praizer</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/static/css/style.css"/>" />
<link rel="stylesheet" href="<c:url value="/static/css/angular-material.min.css"/>" />

<script src="<c:url value="/static/js/jquery.min.js"/>"></script>
<script src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
<script src="<c:url value='/static/js/angular/angular.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-animate.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-aria.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-cookies.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-loader.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-message-format.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-messages.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-parse-ext.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-resource.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-sanitize.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-touch.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-material.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-file-upload.min.js' />"></script>

<script src="<c:url value='/static/app/app.js' />"></script>

<!--[if gte IE 9]>
  <style type="text/css">
    .gradient {
       filter: none;
    }
  </style>
<![endif]-->
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>