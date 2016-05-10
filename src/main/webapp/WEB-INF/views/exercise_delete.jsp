
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-app="stronger" ng-cloak>

	<div ng-controller="ExerciseController as ctrl">

		<h1>exer</h1>

		<form ng-submit="ctrl.submit()" name="myForm">
			<input type="hidden" ng-model="ctrl.exercise.codExercise"
				name="codExercise" id="codExercise" />

			<div layout-gt-sm="row">
				<md-select ng-model="ctrl.exercise.muscleGroup.codMuscleGroup"> 
					<md-option
						ng-repeat="u in ctrl.muscleGroups" value="{{u.codMuscleGroup}}"> {{u.nameMuscleGroup}} </md-option> 
				</md-select>
			</div>


			<div layout-gt-sm="row">
				<md-input-container class="md-block" flex-gt-sm="">
				<label>Nome</label> <input type="text" md-maxlength="40" required=""
					ng-model="ctrl.exercise.nameExercise" name="nameExercise"
					id="nameExercise" />
				<div ng-messages="myForm.nameExercise.$error">
					<div ng-message="required">Campo obrigat�rio!</div>
					<div ng-message="md-maxlength">Tamanho m�ximo de 40
						caracteres.</div>
				</div>
				</md-input-container>
			</div>

			<button type="submit">Salvar</button>
		</form>




		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID.</th>
					<th>Nome</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<tbody>
				<tr ng-repeat="u in ctrl.exercises">
					<td><span ng-bind="u.codExercise"></span></td>
					<td><span ng-bind="u.nameExercise"></span></td>
					<td>
						<button type="button" ng-click="ctrl.get(u.codExercise)">Editar</button>
						<button type="button"
							ng-click="ctrl.remove(u.codExercise, $event)">Remover</button>
					</td>
				</tr>
			</tbody>
			</tbody>
		</table>



	</div>
	<!-- Angular Material requires Angular.js Libraries -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.min.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js"></script>

	<script
		src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js"></script>

	<script
		src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.0-rc4/angular-material.js"></script>


	<script src="<c:url value='/static/app/app.js' />"></script>
	<script src="<c:url value='/static/app/service/exercise_service.js' />"></script>
	<script src="<c:url value='/static/app/service/muscleGroup_service.js' />"></script>
	<script
		src="<c:url value='/static/app/controller/exercise_controller.js' />"></script>
	<script
		src="<c:url value='/static/app/factory/exercise_factory.js' />"></script>
		<script
		src="<c:url value='/static/app/factory/muscleGroup_factory.js' />"></script>
</div>