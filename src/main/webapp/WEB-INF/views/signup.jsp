<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-app="praizer" ng-cloak style="background-color: #ffffff">
	<div ng-controller="SignupController as ctrl">
		<form name="myForm" ng-submit="ctrl.submitCreate()">
			<div style="padding-top: 4em; padding-bottom: 4em; width: 100%">
				<div style="max-width: 48em; margin: 0 auto">
					<div style="margin: 0 auto; width: 22em; float: left">
						<div style="margin-bottom: 0.8em">
							<div style="color: #333333; font-weight: bold">Nome Completo</div>
							<div>
								<input type="text" ng-model="ctrl.user.fullname" name="fullname" id="fullname" required ng-minlength="6" ng-maxlength="40" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
								<div ng-messages="myForm.fullname.$error" ng-if='myForm.fullname.$dirty'>
									<div ng-message="required">Campo obrigatório</div>
									<div ng-message="minlength">Nome deve ter no mínimo 5 caracteres</div>
      								<div ng-message="maxlength">Nome deve ter no máximo 40 caracteres</div>
								</div>
							</div>
						</div>
						<div style="margin-bottom: 0.8em">
							<div style="color: #333333; font-weight: bold">Em qual igreja você vai?</div>
							<div>
								<input type="text" ng-model="ctrl.user.church" name="church" id="church" required ng-minlength="3" ng-maxlength="30" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
								<div ng-messages="myForm.church.$error" ng-if="myForm.church.$dirty">
									<div ng-message="required">Campo obrigatório</div>
									<div ng-message="minlength">Nome deve ter no mínimo 3 caracteres</div>
      								<div ng-message="maxlength">Nome deve ter no máximo 30 caracteres</div>
								</div>
							</div>
						</div>
						<div style="margin-bottom: 0.8em">
							<div style="color: #333333; font-weight: bold">E-mail</div>
							<div>
								<input type="email" ng-model="ctrl.user.email" name="email" id="email" ng-minlength="10" ng-maxlength="60" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
								<div ng-messages="myForm.email.$error" ng-if='myForm.email.$dirty'>
									<div ng-message="required">Campo obrigatório</div>
									<div ng-message="minlength">Nome deve ter no mínimo 10 caracteres</div>
      								<div ng-message="maxlength">Nome deve ter no máximo 60 caracteres</div>
      								<div ng-message="email">Digite um e-mail válido</div>
								</div>
							</div>
						</div>
						<div style="margin-bottom: 0.8em">
							<div style="color: #333333; font-weight: bold">Senha</div>
							<div>
								<input type="password" ng-model="ctrl.user.password" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
							</div>
						</div>
						
						<div style="margin-bottom: 0.8em">
							<div style="color: #333333; font-weight: bold">Confirme a senha</div>
							<div>
								<input type="password" ng-model="ctrl.user.confPassword" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
							</div>
						</div>
						<div style="color: #8B8989; font-weight: bold">
							<md-checkbox ng-model="ctrl.termo" required aria-label="" id="term" name="term"> Li e aceito os <a href="#" style="color: #333333">Termos de uso</a> </md-checkbox>
						
						</div>
						<div>
							<button type="submit" ng-disabled="myForm.$invalid" style="display: block; margin: 2em auto; background-color: #00FF7F; font-weight: bold; border: 0px; border-radius: 0.3em; padding: 0.4em; font-size: 1.2em">Cadastrar</button>
						</div>
					</div>
					<div style="float: left; color: #8B8989">
						<div style="width: 0.6em; margin: 0.2em; height: 10em; border-right: 1px solid #8B8989"></div>
						<div style="margin: 0.8em 0em 0.8em 0em">ou</div>
						<div style="width: 0.6em; margin: 0.2em; height: 10em; border-right: 1px solid #8B8989"></div>
					</div>


					<div style="padding-top: 7em; margin: 0 auto; width: 22em; float: left">
						<button class="btn-facebook"></button>
						<button class="btn-googleplus"></button>

					</div>
				</div>
			</div>
		</form>


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
<script src="<c:url value='/static/app/service/user_service.js' />"></script>
<script src="<c:url value='/static/app/controller/user_controller.js' />"></script>


