<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../PageStructure/head.jsp">
	<jsp:param name="titre" value="Jeu du Guess" />
</jsp:include>

<main class="center">
	<h1>Jeux du Guess</h1>

	<form class="form" action="<%=request.getContextPath()%>/jeux/guess-validator" method="POST">
		<input type="number" id="inputNumber" name="inputNumber" required="required" placeholder="Proposez un nombre" />
		<input type="submit" class="btnOld" value="Vérifer" />
	</form>

	<c:if test="${!empty resultat }">

		<h2>${resultat}</h2>
	</c:if>
</main>

<script type="text/javascript">
window.onload = function(){
	document.getElementById("inputNumber").focus();
}
</script>