<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet">

    <title><fmt:message key="orders" bundle="${bundle}" /> - SEBO</title>
  </head>
  <body>
	<div class="container mt-5">
  		<div class="row">
  			<div class="col-md-8">
  				<form method="post">
	  				<div class="card">
	  					<div class="card-header d-flex justify-content-between">
	  						<fmt:message key="orders" bundle="${bundle}" />
	  						<a href="<%= request.getContextPath() %>/catalogue"><fmt:message key="back" bundle="${bundle}" /></a>
  					
	  					</div>
	  					<div class="card-body">
	  						<c:if test="${commande != null}">
		  						<table class="table">
								  <thead>
								    <tr>
								      <th scope="col"><fmt:message key="article_name" bundle="${bundle}" /></th>
								      <th scope="col"><fmt:message key="unit_price" bundle="${bundle}" /></th>
								      <th scope="col"><fmt:message key="qte" bundle="${bundle}" /></th>
								      <th scope="col"><fmt:message key="total_price" bundle="${bundle}" /></th>
								    </tr>
								  </thead>
								  <tbody>
								  <c:forEach var="ligneCommande" items="${lignesCommande}">
									    <tr>
									      <td>${ligneCommande.article.designation}</td>
									      <td>
									      	<fmt:formatNumber value="${ligneCommande.article.prix}" type="currency" />
									      </td>
									      <td>${ligneCommande.qteCode}</td>
									      <td>
									      	<fmt:formatNumber value=" ${ligneCommande.article.prix*ligneCommande.qteCode}" type="currency" />
									     </td>
									    </tr>
								    </c:forEach>
								  </tbody>
								</table>
							</c:if>
							<c:if test="${commande == null || lignesCommande.size() == 0}">
								<fmt:message key="card_empty" bundle="${bundle}" />
							</c:if>
	  					</div>
	  					
	  					<c:if test="${commande != null}">
		  					<div class="card-footer">
		  						<button class="btn btn-primary">
		  							<fmt:message key="submit" bundle="${bundle}" />
		  						</button>
		  					</div>
	  					</c:if>
	  				</div>
  				</form>
  			</div>
  		</div>
  	</div>
</body>
</html>