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
			
			<h2><c:out value="${newCustomers ? 'Add a new customer' : 'Update customer'}" /></h2>
			
			<form action="/CRMapp/customers/save" method="post">
			  <div class="mb-3">
			    <input type="hidden" class="form-control" name="id" value="${customers.id}">
			  </div>
			  <div class="mb-3">
			    <label for="FirstName" class="form-label">First Name</label>
			    <input type="text" class="form-control" id="FirstName" name="FirstName" value="${customers.FirstName}">
			  </div>
			  <div class="mb-3">
			    <label for="LastName" class="form-label">Last Name</label>
			    <input type="text" class="form-control" id="LastName" name="LastName" value="${customers.LastName}">
			  </div>
			  <div class="mb-3">
			    <label for="Email" class="form-label">Email</label>
			    <input type="text" class="form-control" id="Email" name="Email" value="${customers.Email}">
			  </div>
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			  
			  <a href="/CRMapp/customers/list" class="btn btn-danger">Cancel</a>
			</form>
		</div>
		
	</body>
</html>