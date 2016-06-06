<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div style="background-color: #ffffff">
	<div ng-controller="BackgroundController as ctrl">
		Background

		<form name="myForm" ng-submit="ctrl.submit()">

			<div style="color: #333333; background-weight: bold">Nome do Background</div>
			<div>
				<input type="text" ng-model="ctrl.background.background" name="background" id="background" required ng-minlength="3" ng-maxlength="40" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
				<div ng-messages="myForm.background.$error" ng-if='myForm.background.$dirty'>
					<div ng-message="required">Campo obrigatório</div>
					<div ng-message="minlength">Nome deve ter no mínimo 3 caracteres</div>
					<div ng-message="maxlength">Nome deve ter no máximo 40 caracteres</div>
				</div>
			</div>
			
			<div style="color: #333333; background-weight: bold">Cor Título</div>
			<div>
				<input type="text" ng-model="ctrl.background.colorTitle" name="colorTitle" id="colorTitle" required ng-minlength="3" ng-maxlength="40" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
				<div ng-messages="myForm.colorTitle.$error" ng-if='myForm.colorTitle.$dirty'>
					<div ng-message="required">Campo obrigatório</div>
					<div ng-message="minlength">Nome deve ter no mínimo 3 caracteres</div>
					<div ng-message="maxlength">Nome deve ter no máximo 40 caracteres</div>
				</div>
			</div>
			
			<div style="color: #333333; background-weight: bold">Cor Body</div>
			<div>
				<input type="text" ng-model="ctrl.background.colorBody" name="colorBody" id="colorBody" required ng-minlength="3" ng-maxlength="40" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
				<div ng-messages="myForm.colorBody.$error" ng-if='myForm.colorBody.$dirty'>
					<div ng-message="required">Campo obrigatório</div>
					<div ng-message="minlength">Nome deve ter no mínimo 3 caracteres</div>
					<div ng-message="maxlength">Nome deve ter no máximo 40 caracteres</div>
				</div>
			</div>
			
			<div ng-show="ctrl.background.backgroundId != null">
				<div style="color: #333333; background-weight: bold">Arquivo da Background (.ttf)</div>
				<div>
					<input type="file" id="file" nv-file-select uploader="uploader" />
					<div style="background-size: 10px">
						<ul>
							<li ng-repeat="item in uploader.queue">
								Background:
								<span ng-bind="item.file.name"></span>
								<button type="button" ng-click="item.upload()">upload</button>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div ng-show="ctrl.background.backgroundId == null">
				Salve a backgrounde antes de adicionar o arquivo! 
			</div>
			<div>
				<button type="submit" ng-disabled="myForm.$invalid" style="display: block; margin: 2em auto; background-color: #00FF7F; background-weight: bold; border: 0px; border-radius: 0.3em; padding: 0.4em; background-size: 1.2em">Salvar</button>
			</div>
		</form>
		
		<div ng-repeat="background in ctrl.backgrounds">
			<div  style="height:90px;background-repeat:no-repeat;background-image:url(/praiser/uploads/admin/{{background.filename}});background-size:160px 90px;margin:0.2em;float:left;text-align:center;padding:0.6em;width:160px;border:1px solid #000000;">
				<div style="background-color:{{background.colorTitle}};width:20px;height:20px"></div>
				<div style="background-color:{{background.colorBody}};width:20px;height:20px"></div>
			</div>
		</div>

<style ng-repeat="background in ctrl.backgrounds">
@background-face {
	background-family: {{background.background}};
	src: url(/praiser/uploads/admin/{{background.filename}});
}
</style>

	</div>
</div>

<script src="<c:url value='/static/app/service/background_service.js' />"></script>
<script src="<c:url value='/static/app/controller/background_controller.js' />"></script>