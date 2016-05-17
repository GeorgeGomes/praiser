<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-controller="UserController as ctrl">
	<div style="background-color: #ffffff">
		<form name="myForm" ng-submit="ctrl.submitUpdate()">
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

						<div>
							<button type="submit" ng-disabled="myForm.$invalid" style="display: block; margin: 2em auto; background-color: #00FF7F; font-weight: bold; border: 0px; border-radius: 0.3em; padding: 0.4em; font-size: 1.2em">Cadastrar</button>
						</div>
					</div>
				</div>
			</div>
		</form>


	</div>

</div>

<script src="<c:url value='/static/js/angular/angular.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-messages.min.js' />"></script>

<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/static/app/service/user_service.js' />"></script>
<script src="<c:url value='/static/app/controller/user_controller.js' />"></script>
