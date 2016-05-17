<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head ng-app="praizer">
<title></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<c:url value="static/css/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="static/css/style.css"/>" />
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
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>