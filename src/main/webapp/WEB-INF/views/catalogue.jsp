<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title><fmt:message key="catalog" bundle="${bundle}" /> - SEBO</title>
  </head>
  <body>
	<div class="container mt-5">
  		<div class="row">
  			<div class="col-md-8">
  				<div class="card">
  					<div class="card-header d-flex justify-content-between">
  						<fmt:message key="products" bundle="${bundle}" />
  						<a href="<%= request.getContextPath() %>/commandes"><fmt:message key="orders" bundle="${bundle}" /></a>
  					</div>
  					<div class="card-body">
  						<c:if test="${articles != null}">
	  						<table class="table">
							  <thead>
							    <tr>
							      <th scope="col"><fmt:message key="code" bundle="${bundle}" /></th>
							      <th scope="col"><fmt:message key="article_name" bundle="${bundle}" /></th>
							      <th scope="col"><fmt:message key="photo" bundle="${bundle}" /></th>
							      <th scope="col"><fmt:message key="price" bundle="${bundle}" /></th>
							      <th scope="col"></th>
							    </tr>
							  </thead>
							  <tbody>
							  <c:forEach var="article" items="${articles}">
								    <tr>
								      <th scope="row">
								      	<a href="<%= request.getContextPath() %>/detail?codeArticle=${article.codeArticle}">${article.codeArticle}</a>
								      </th>
								      <td>${article.designation}</td>
								      <td><img style="width:6rem;height:6rem;" class="img-thumbnail rounded" src="${article.photo}" alt="poster" /></td>
								      <td><fmt:formatNumber value="${article.prix}" type="currency" /></td>
								      <td>
								      	<a href="<%= request.getContextPath() %>/panier/ajouter?codeArticle=${article.codeArticle}" class="btn btn-sm btn-primary">
								      		<fmt:message key="add_to_cart" bundle="${bundle}" />
								      	</a>
								      </td>
								    </tr>
							    </c:forEach>
							  </tbody>
							</table>
						</c:if>
  					</div>
  				</div>
  			</div>
  		</div>
  	</div>
</body>
</html>