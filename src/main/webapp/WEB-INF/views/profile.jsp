<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-controller="UserController as ctrl" style="width: 1000px; margin: 0 auto;">

<div style="padding-top:0.2em;padding-bottom:0.2em;font-size:3em;font-weight:bold">Profile</div>
<div style="clear:both"></div>
	<div style="background-color: #ffffff; border: 1px solid red; width: 300px; float: left">
		<img ng-src="{{ ctrl.user.imagemProfile != null && '/praizer/images/' + ctrl.user.imagemProfile || 'static/img/default-user.png' }}" style="display: block; margin: 0 auto; border-radius: 100%; width: 120px; height: 120px; border: 4px solid #ffffff" />
		

		<form name="myUpload">
			<input type="file" id="file" nv-file-select uploader="uploader" />
			<br />
			<div ng-show="ctrl.errorUpload">
				Faça upload apenas de arquivo "ttf"!
			</div>
			<ul>
				<li ng-repeat="item in uploader.queue">
					Name:
					<span ng-bind="item.file.name"></span>
					<br />
					<button ng-click="item.upload()">upload</button>
				</li>
			</ul>
		</form>

	</div>
	<div style="background-color: #ffffff; border: 1px solid red; width: 650px; float: left">
		<form name="myForm" ng-submit="ctrl.submit()">
			<div style="padding-top: 4em; padding-bottom: 4em; width: 100%">
				<div style="max-width: 48em; margin: 0 auto">
					<div style="margin: 0 auto; width: 22em; float: left">
						<div style="margin-bottom: 0.8em">
							<div style="color: #333333; font-weight: bold">Nome Completo</div>
							<div>
								<input type="text" ng-show="editMode" ng-model="ctrl.user.fullname" name="fullname" id="fullname" required ng-minlength="6" ng-maxlength="40" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
								<span ng-hide="editMode">{{ctrl.user.fullname}}</span>
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
								<input type="text" ng-show="editMode" ng-model="ctrl.user.church" name="church" id="church" required ng-minlength="3" ng-maxlength="30" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
								<span ng-hide="editMode">{{ctrl.user.church}}</span>
								<div ng-messages="myForm.church.$error" ng-if="myForm.church.$dirty">
									<div ng-message="required">Campo obrigatório</div>
									<div ng-message="minlength">Nome deve ter no mínimo 3 caracteres</div>
									<div ng-message="maxlength">Nome deve ter no máximo 30 caracteres</div>
								</div>
							</div>
						</div>
						<div>
							<button type="button" ng-hide="editMode" ng-click="ctrl.edit()" style="display: block; margin: 2em auto; background-color: #00FF7F; font-weight: bold; border: 0px; border-radius: 0.3em; padding: 0.4em; font-size: 1.2em">Editar</button>
							<button type="submit" ng-show="editMode" style="display: block; margin: 2em auto; background-color: #00FF7F; font-weight: bold; border: 0px; border-radius: 0.3em; padding: 0.4em; font-size: 1.2em">Salvar</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

</div>



