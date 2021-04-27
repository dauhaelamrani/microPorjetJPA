<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title><fmt:message key="home" bundle="${bundle}" /> - SEBO</title>
  </head>
  <body>
	<div class="container mt-5">
  		<div class="row">
  			<div class="col-md-8">
  				<div class="card">
  					<div class="card-header">
  						<fmt:message key="greeting" bundle="${bundle}" /> ${ client.nom } ${ client.prenom }
  					</div>
  					<!--  <div class="card-body"> -->
  						<ul class="list-group list-group-flush">
					  		<li class="list-group-item">
					  			<a href="<%= request.getContextPath() %>/catalogue" class="list-group-item-action">
					  				<fmt:message key="consult_the_catalog" bundle="${bundle}" /> 
					  			</a>
					  		</li>
					  		<li class="list-group-item">
					  			<a href="<%= request.getContextPath() %>/commandes" class="list-group-item-action">
					  				<fmt:message key="track_orders" bundle="${bundle}" /> 
					  			</a>
					  		</li>
					  		<li class="list-group-item">
					  			<a href="<%= request.getContextPath() %>/commandes" class="list-group-item-action">
					  				<fmt:message key="view_cart" bundle="${bundle}" /> 
					  			</a>
					  		</li>
						</ul>
  					<!-- </div> -->
  				</div>
  			</div>
  		</div>
  	</div>
</body>
</html>