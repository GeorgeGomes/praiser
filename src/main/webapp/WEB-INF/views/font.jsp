<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div style="background-color: #ffffff">
	<div ng-controller="FontController as ctrl">
		Font

		<form name="myForm" ng-submit="ctrl.submit()">

			<div style="color: #333333; font-weight: bold">Nome da Fonte</div>
			<div>
				<input type="text" ng-model="ctrl.font.font" name="font" id="font" required ng-minlength="3" ng-maxlength="40" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
				<div ng-messages="myForm.font.$error" ng-if='myForm.font.$dirty'>
					<div ng-message="required">Campo obrigatório</div>
					<div ng-message="minlength">Nome deve ter no mínimo 3 caracteres</div>
					<div ng-message="maxlength">Nome deve ter no máximo 40 caracteres</div>
				</div>
			</div>
			<div ng-show="ctrl.font.fontId != null">
				<div style="color: #333333; font-weight: bold">Arquivo da Fonte (.ttf)</div>
				<div>
					<input type="file" id="file" nv-file-select uploader="uploader" />
					<div style="font-size: 10px">
						<ul>
							<li ng-repeat="item in uploader.queue">
								Fonte:
								<span ng-bind="item.file.name"></span>
								<button type="button" ng-click="item.upload()">upload</button>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div ng-show="ctrl.font.fontId == null">
				Salve a fonte antes de adicionar o arquivo! 
			</div>
			<div>
				<button type="submit" ng-disabled="myForm.$invalid" style="display: block; margin: 2em auto; background-color: #00FF7F; font-weight: bold; border: 0px; border-radius: 0.3em; padding: 0.4em; font-size: 1.2em">Salvar</button>
			</div>
		</form>
		
		<div ng-repeat="font in ctrl.fonts">
			<div  style="font-family:{{font.font}};margin:0.2em;float:left;font-size:0.8em;text-align:center;padding:0.6em;width:12em;border:1px solid #000000;background-color:#ffffff;" >
				<div style="font-weight:bold">{{font.font}}</div>
				<div style="color:blue">{{font.filename}}</div>
			</div>
		</div>

<style ng-repeat="font in ctrl.fonts">
@font-face {
	font-family: {{font.font}};
	src: url(/praiser/uploads/admin/{{font.filename}});
}
</style>

	</div>
</div>

<script src="<c:url value='/static/app/service/font_service.js' />"></script>
<script src="<c:url value='/static/app/controller/font_controller.js' />"></script>