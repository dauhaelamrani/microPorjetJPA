<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title><fmt:message key="sign_up" bundle="${bundle}" /> - SEBO</title>
  </head>
  <body>
	<div class="container mt-5">
  		<div class="row">
  			<div class="col-md-8">
  				<div class="card">
  					<div class="card-header">
  						<fmt:message key="sign_up" bundle="${bundle}" />
  					</div>
  					<div class="card-body">
	  					<c:if test="${ errors != null }">
	  						<div class="alert alert-danger">
	  							<ul class="mb-0">
	  							<c:forEach var="error" items="${errors}">
	  								<li>
	  									<fmt:message key="${error}" bundle="${bundle}" />
	  								</li>
	  							</c:forEach>
	  							</ul>
	  						</div>
	  					</c:if>
  						<form action="<%= request.getContextPath() %>/inscrire" method="POST">
						  <div class="mb-3">
						    <label for="nom" class="form-label"><fmt:message key="last_name" bundle="${bundle}" /></label>
						    <input type="text" class="form-control" id="nom" name="nom">
						  </div>
						  <div class="mb-3">
						    <label for="prenom" class="form-label"><fmt:message key="first_name" bundle="${bundle}" /></label>
						    <input type="text" class="form-control" id="prenom" name="prenom">
						  </div>
						  <div class="mb-3">
						    <label for="adresse" class="form-label"><fmt:message key="address" bundle="${bundle}" /></label>
						    <input type="text" class="form-control" id="adresse" name="adresse">
						  </div>
						  <div class="mb-3">
						    <label for="email" class="form-label"><fmt:message key="email" bundle="${bundle}" /></label>
						    <input type="text" class="form-control" id="email" name="email">
						  </div>
						  <div class="mb-3">
						    <label for="motPasse" class="form-label"><fmt:message key="password" bundle="${bundle}" /></label>
						    <input type="password" class="form-control" id="motPasse" name="motPasse">
						  </div>
						  <button type="submit" class="btn btn-primary"><fmt:message key="sign_up_button" bundle="${bundle}" /></button>
						</form>
  					</div>
  				</div>
  			</div>
  		</div>
  	</div>
</body>
</html>