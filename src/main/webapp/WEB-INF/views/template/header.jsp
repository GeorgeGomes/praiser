<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div style="background-color: #000000; width: 100%; padding: 1em; color: #ffffff">
	<div style="font-size: 2em; float: left; width: 3em">
		<a href="/praizer/" style="color: #ffffff">Praizer</a>
	</div>


	<div ng-controller="UserController as ctrl" style="margin-left: 1em; float: right;; width: 18em; border-left: 1px solid #ffffff; margin-top: 1em;">
		<sec:authorize access="isAnonymous()">
			<a style="float: left; color: #ffffff; width: 6em; padding: 0.2em 2em 0.2em 2em" href="login">Login</a>
			<a style="font-weight: bold; float: left; background-color: #00FFFF; border-radius: 0.6em; color: #000000; padding: 0.2em 2em 0.2em 2em" href="signup">Sign Up</a>
			<div style="clear: both"></div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a href="profile">{{ctrl.user.fullname}}</a>
		</sec:authorize>
	</div>


	<div style="float: right; width: 18em; margin-top: 1em;">
		<a style="float: left; color: #ffffff; width: 6em" href="#">O que é?</a>
		<a style="float: left; color: #ffffff; width: 6em" href="explore">Explore</a>
		<a href="#" style="color: #ffffff; float: left; border: 1px solid #ffffff; width: 6em; text-align: center">Doar</a>
		<div style="clear: both"></div>
	</div>

	<div style="clear: both"></div>
</div>