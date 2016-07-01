<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/PageStructure/head.jsp">
	<jsp:param name="titre" value="Liste des Jeux" />
</jsp:include>

<main>
<c:if test="${!empty sessionScope.joueurConnecte}">
	<h4 class="nomJoueur">Pseudo: ${joueurConnecte.getNom()}</h4>
</c:if> 
<div class="menu">
	<h1>Liste des Jeux</h1>
	<ul>
		<li><a href="<%=request.getContextPath()%>/jeux/displayGuess">JEUX DU GUESS</a></li>

	</ul>
</div>
</main>
