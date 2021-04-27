<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>${article.designation} - SEBO</title>
  </head>
  <body>
	<div class="container mt-5">
  		<div class="row">
  			<div class="col-md-8">
  				<div class="card">
  				<img src="${article.photo}" class="card-img-top" style="width: 18rem;" alt="poster">
  					<!-- <div class="card-header">
  						Les produits
  					</div> -->
  					<div class="card-body">
  						<h5 class="card-title">${article.designation }</h5>
  						 <p class="card-text">
							<fmt:formatNumber value="${article.prix}" type="currency" />
  						 </p>
  					</div>
  					<ul class="list-group list-group-flush">
					    <li class="list-group-item">
					    	<span class="badge bg-secondary">Stock: ${article.stock}</span>
					    	<span class="badge bg-secondary mx-2">Category: ${article.categorie.cat}</span>
					    </li>
					    <li class="d-flex justify-between justify-content-between list-group-item">
					    	<a href="<%= request.getContextPath() %>/panier/ajouter?codeArticle=${article.codeArticle}" class="btn btn-primary">
					    		<fmt:message key="add_to_cart" bundle="${bundle}" />
					    	</a>
					    	<a href="<%= request.getContextPath() %>/catalogue" class="btn btn-white">
					    		<fmt:message key="back" bundle="${bundle}" />
					    	</a>
					    </li>
					  </ul>
  				</div>
  			</div>
  		</div>
  	</div>
</body>
</html>