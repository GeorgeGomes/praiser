<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div style="background-color: #000000; width: 100%; padding: 1em; color: #ffffff">
	<div style="font-size: 2em; float: left; width: 3em">
		<a href="/praiser/" style="color: #ffffff"><img src="<c:url value='/static/img/logo-praiser.png' />" alt="" style="width:120px"/></a>
	</div>
	
		
	<div ng-controller="UserController as ctrl" style="margin-left: 3em; float: right; width: 20em; border-left: 2px solid #ffffff;">
		<sec:authorize access="isAnonymous()">
			<div style="padding:0.6em">
				<a href="login" class="menu-text menu-login">Login</a>
				<a href="signup" class="menu-text menu-signup">Sign Up</a>
				<div style="clear: both"></div>
			</div>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<div class="menu-dropdown">
				<div class="menu-dropdown-user">
					<div style="margin:0px 0px 0px 2em;float:left;width:3em">
						<img ng-src="{{ ctrl.user.imagemProfile != null && '/praiser/uploads/user/' + ctrl.user.imagemProfile || 'static/img/default-user.png' }}" class="photo-circle" />
					</div>
					<div style="float:left;width:12em;margin-left:0.6em;padding-top:0.6em">
						<span style="color:#ffffff;font-weight:bold;font-size:16px">{{ctrl.user.fullname}}</span>
					</div>
					<div style="clear: both"></div>
				</div>
				<div class="menu-dropdown-list">
					<div style="border-bottom:0.1em solid #ffffff">
						<a href="mySlides">
							<img src="static/img/download-from-cloud.png" alt="Meus Slides" /> Meus Slides
						</a>
					</div>
					<div style="border-bottom:0.1em solid #ffffff">
						<a href="/praiser/profile">
							<img src="static/img/settings.png" alt="Configurações" /> Configurações
						</a>
					</div>
					<div>
						<a href="/praiser/logoff">
							<img src="static/img/logout.png" alt="Sair"  style="width:1.4em"/> Sair
						</a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<script>
				$(".menu-dropdown").mouseover(function(){
					$(".menu-dropdown-user").css("background-color","#4F4F4F");
					$(".menu-dropdown-list").css("display","block");
				})
				
				$(".menu-dropdown").mouseleave(function(){
					$(".menu-dropdown-user").css("background-color","transparent");
					$(".menu-dropdown-list").css("display","none");
				})
			</script>
		
		</sec:authorize>
	</div>


	<div style="float: right; width: 22em; padding-top: 1em;">
		<a href="#" class="menu-text" >O que é?</a>
		<a href="explore" class="menu-text" >Explore</a>
		<a href="#" class="menu-text menu-doar">Doar</a>
		<div class="clearfix"></div>
	</div>

	<div class="clearfix"></div>
</div>