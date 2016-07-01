<jsp:include page="PageStructure/head.jsp">
	<jsp:param name="titre" value="Accueil" />
</jsp:include>

<main>
	<div class="divTitle animText">Insert Pseudo</div>
	<form action="./jeux" method="POST" class="formPseudo">
		<input type="text" class="inputPseudo" />
		<input type="submit" class="btnStart" value="Start Game" />
	</form>
</main>