<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<h1>CUSTOMER RELATIONSHIP MANAGEMENT</h1>
			<hr />
			
			<h2>
				List of students
				<a href="/CRMapp/customers/new" class="btn btn-primary btn-sm float-end">Add customer</a>
			</h2>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customers}" var="customers">
						<tr>
							<td><c:out value="${customers.FirstName}" /></td>
							<td><c:out value="${customers.LastName}"/></td>
							<td><c:out value="${customers.Email}" /></td>
							<td>
								<a href="/CRMapp/customers/edit?id=${customers.id}" class="btn btn-secondary btn-sm">Update</a>
								<a href="/CRMapp/customers/delete?id=${customers.id}" class="btn btn-danger btn-sm">Delete</a>
							</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</body>
</html>