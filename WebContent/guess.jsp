<jsp:include page="PageStructure/head.jsp">
	<jsp:param name="titre" value="Jeu du Guess" />
</jsp:include>

<main>
	<div class="divTitle">Jeux du Guess</div>
	<form action="gues-validator" method="POST">
		<label for="inputNumber">Proposez un nombre</label>
		<input type="text" id="inputNumber" name="inputNumber" />
		<input type="submit" value="Vérifer" />
	</form>
</main>