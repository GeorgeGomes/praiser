<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div style="background-color: #000000; width: 100%; padding: 1em; color: #ffffff">
	<div style="font-size: 2em; float: left; width: 3em">
		<a href="/praiser/" style="color: #ffffff"><img src="static/img/logo-praiser.png" alt="" style="width:120px"/></a>
	</div>
	
		
	<div ng-controller="UserController as ctrl" style="margin-left: 3em; float: right;; width: 18em; border-left: 2px solid #ffffff;">
		<sec:authorize access="isAnonymous()">
			<div style="padding:0.6em">
				<a style="float: left; color: #ffffff; width: 6em; padding: 0.2em 2em 0.2em 2em" href="login">Login</a>
				<a style="font-weight: bold; float: left; background-color: #00FFFF; border-radius: 0.6em; color: #000000; padding: 0.2em 2em 0.2em 2em" href="signup">Sign Up</a>
				<div style="clear: both"></div>
			</div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<div class="dropdown" style="margin-left:0.2em;width:16em">
				<div class="dropdown-toggle" id="dropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<img ng-src="{{ ctrl.user.imagemProfile != null && '/praiser/uploads/user/' + ctrl.user.imagemProfile || 'static/img/default-user.png' }}" style="margin:0px 0px 0px 3em;float:left;border-radius:100%;width:40px;height:40px;border:4px solid #ffffff" />
					<div style="float:left;width:100px;margin-left:0.6em;padding-top:0.6em">
						<span style="color:#ffffff;font-weight:bold;font-size:16px">{{ctrl.user.fullname}}</span>
					</div>
					<div style="clear: both"></div>
				</div>
				<ul class="dropdown-menu" style="width:16em;margin-top:-0.12em" aria-labelledby="dropdownProfile">
					<li style="border-bottom:0.1em solid #ffffff;padding:0.8em;">
						<a href="dowloads" style="color:#ffffff;font-weight:bold;font-size:16px"><img src="static/img/download-from-cloud.png" alt="Downloads" style="width:25"/> Meus Downloads</a>
					</li>
					<li style="border-bottom:0.1em solid #ffffff;padding:0.6em;">
						<a href="/praiser/profile" style="color:#ffffff;font-weight:bold;font-size:16px"><img src="static/img/settings.png" alt="Configurações"  style="width:25"/> Configurações</a>
					</li>
					<li style="padding:0.8em;">
						<a href="/praiser/logoff" style="color:#ffffff;font-weight:bold;font-size:16px"><img src="static/img/logout.png" alt="Sair"  style="width:25"/> Sair</a>
					</li>
				</ul>
				
				<div style="clear: both"></div>
			</div>

		
		</sec:authorize>
	</div>


	<div style="float: right; width: 18em; padding-top: 1em;">
		<a style="float: left; color: #ffffff; width: 6em" href="#">O que é?</a>
		<a style="float: left; color: #ffffff; width: 6em" href="explore">Explore</a>
		<a href="#" style="color: #ffffff; float: left; border: 1px solid #ffffff; width: 6em; text-align: center">Doar</a>
		<div style="clear: both"></div>
	</div>

	<div style="clear: both"></div>
</div>