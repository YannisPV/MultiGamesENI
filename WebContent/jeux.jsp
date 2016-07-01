<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="PageStructure/head.jsp">
	<jsp:param name="titre" value="Liste des Jeux" />
</jsp:include>

<main>
	<div class="">Liste des Jeux</div>
	<c:if test="${!empty sessionScope.joueurConnecte}">
		<h2>${joueurConnecte.getNom()}</h2>
	</c:if>
	
	<a href="<%=request.getContextPath()%>/displayGuess">JEUX DU GUESS</a>
</main>