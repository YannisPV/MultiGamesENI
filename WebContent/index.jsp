<jsp:include page="PageStructure/head.jsp">
	<jsp:param name="titre" value="Accueil" />
</jsp:include>

<main class="center">
	<form action="<%=request.getContextPath()%>/jeux" method="POST" class="formPseudo">
		<input type="text" class="" id="pseudo" name="pseudo" placeholder="Insert Pseudo" />
		<input type="submit" class="btnOld" value="Start Game" />
	</form>
</main>