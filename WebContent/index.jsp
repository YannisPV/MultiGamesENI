<jsp:include page="PageStructure/head.jsp">
	<jsp:param name="titre" value="Accueil" />
</jsp:include>

<main>
	<form action="<%=request.getContextPath()%>/jeux" method="POST" class="formPseudo">
		<input type="text" class="inputPseudo" id="pseudo" name="pseudo" value="Insert Pseudo" />
		<input type="submit" class="btnStart" value="Start Game" />
	</form>
</main>