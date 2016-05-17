<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div style="background-color: #ffffff">
	<div ng-controller="LoginController as ctrl">
		
		<form:form method="POST" action="authentication" modelAttribute="user">
			<div style="padding-top: 4em; padding-bottom: 4em; width: 100%">
				<div style="max-width: 48em; margin: 0 auto">
				${error}
					<div style="margin: 0 auto; width: 22em; float: left">
						<div style="margin-bottom: 0.8em">
							<div style="color: #333333; font-weight: bold">E-mail</div>
							<div>
								<input type="text" name="email" id="email" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
							</div>
						</div>
						<div style="margin-bottom: 0.8em">
							<div style="color: #333333; font-weight: bold">Senha</div>
							<div>
								<input type="text" name="password" id="password" style="width: 20em; background-color: #F8F8FF; border: 1px solid #BEBEBE" />
							</div>
						</div>
						<div>
							<button type="submit" style="display: block; margin: 2em auto; background-color: #00FF7F; font-weight: bold; border: 0px; border-radius: 0.3em; padding: 0.4em; font-size: 1.2em">Entrar</button>
						</div>
					</div>
					<div style="float: left; color: #8B8989">
						<div style="width: 0.6em; margin: 0.2em; height: 5em; border-right: 1px solid #8B8989"></div>
						<div style="margin: 0.8em 0em 0.8em 0em">ou</div>
						<div style="width: 0.6em; margin: 0.2em; height: 5em; border-right: 1px solid #8B8989"></div>
					</div>

					<div style="padding-top: 0em; margin: 0 auto; width: 22em; float: left">
						<button class="btn-facebook"></button>
						<button class="btn-googleplus"></button>

					</div>
				</div>
			</div>
		</form:form>


	</div>

</div>


