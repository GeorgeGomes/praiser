<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>

	<div ng-controller="ExploreController as ctrl">

		<div style="padding-top: 4em; padding-bottom: 4em; width: 100%; background-color: #ffffff; height: 38em">
			<div style="max-width: 62em; margin: 0 auto">

				<div style="text-align: center; font-size: 2.2em; font-weight: bold">Explore</div>
				<div style="text-align: center; font-size: 1.2em">Talvez o slide que você procura alguém já fez e você pode encontrá-lo aqui:</div>

				<div>
					<form ng-submit="ctrl.submit()" name="myForm">
						<input style="width: 100%" placeholder="Digite o nome da música" />
					</form>
				</div>


				<div id="freewall">
<!-- 					<div ng-repeat="n in ctrl.getExplores()" ng-click="ctrl.viewDownload(event)" style="cursor:pointer;padding:2em;text-align:center;float:left;width:{{ctrl.randomWidth($index)}};background-color:{{ctrl.randomColor()}};margin:{{ctrl.randomMargin($index)}};height:15em"> -->
<!-- 						<div style="font-size:{{ctrl.randomTextsize(n.nome)}}"> -->
<!-- 						{{n.nome}} -->
<!-- 						</div> -->
						
<!-- 					</div> -->
					
				<div ng-repeat="n in ctrl.getExplores()" ng-click="ctrl.viewDownload(event)" style="background-color:{{ctrl.gridList[$index].color}};cursor:pointer;padding:2em;text-align:center;float:left;width:{{ctrl.gridList[$index].width}};margin:{{ctrl.gridList[$index].margin}};height:15em">
						<div style="font-size:{{ctrl.gridList[$index].textSize}}">
						{{n.nome}}
						</div>
						
					</div>

					<div style="clear: both"></div>
				</div>

			</div>

		</div>

	</div>

</div>




<!-- Angular Material requires Angular.js Libraries -->
<script src="<c:url value='/static/js/angular/angular.min.js' />"></script>
<script src="<c:url value='/static/js/angular/angular-messages.min.js' />"></script>

<script src="<c:url value='/static/app/app.js' />"></script>
<script src="<c:url value='/static/app/service/explore_service.js' />"></script>
<script src="<c:url value='/static/app/controller/explore_controller.js' />"></script>
<script src="<c:url value='/static/app/factory/explore_factory.js' />"></script>



