<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="PageStructure/head.jsp">
	<jsp:param name="titre" value="Jeu du Guess" />
</jsp:include>

<main>
	<div class="">Jeux du Guess</div>

	<form action="<%=request.getContextPath()%>/guess-validator" method="POST">

		<label for="inputNumber">Proposez un nombre</label>
		<input type="text" id="inputNumber" name="inputNumber" />
		<input type="submit" value="Vérifer" />
	</form>

	<c:if test="${!empty resultat }">

		<h2>${resultat}</h2>
	</c:if>
</main>