<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	<link type="text/css"
		rel="stylesheet"
		href="${ pageContext.request.contextPath }/resources/css/style.css" />
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<!-- add customer -->
			<input type="button" value="Add Customer"
				   onclick="window.location.href='add'; return false;"
				   class="add-button"
			/>
			<!-- filter customer -->
			<form action="list" method="GET">
				<input type="hidden" name="pageNo" value="0" />
				<label>Search Term:</label>
               	<input type="text" name="searchTerm" />&nbsp;
               	<label>Sort By:</label>
               	<select name="sortBy">
               		<option value="firstName">First Name</option>
               		<option value="lastName" selected>Last Name</option>
               	</select>&nbsp;
                <input type="submit" value="Filter" class="add-button" />
            </form>
			<table>
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>E-mail</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${ customers }" >
						<c:url var="updateLink" value="/customer/update" >
							<c:param name="id" value="${ customer.id }" />
						</c:url>
						<c:url var="deleteLink" value="/customer/delete" >
							<c:param name="id" value="${ customer.id }" />
						</c:url>
						<tr>
							<td>${ customer.firstName }</td>
							<td>${ customer.lastName }</td>
							<td>${ customer.email }</td>
							<td><a href="${ updateLink }">Update</a> | 
								<a onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false"
									href="${ deleteLink }">Delete</a>
							</td>
						</tr>
					</c:forEach>	
				</tbody>
			</table>
		</div>
		<!-- pagination -->
		<br>
		<c:if test="${ pageNo != 0 }">
			<c:choose>
				<c:when test="${ (searchTerm ne null) && (sortBy ne null) }">
					<c:url var="pageLink" value="/customer/list">
						<c:param name="pageNo" value="${ pageNo-1 }" />
						<c:param name="searchTerm" value="${ searchTerm }" />
						<c:param name="sortBy" value="${ sortBy }" />
					</c:url>
				</c:when>
				<c:otherwise>
					<c:url var="pageLink" value="/customer/list">
						<c:param name="pageNo" value="${ pageNo-1 }" />
					</c:url>
				</c:otherwise>
			</c:choose>
			<a href="${ pageLink }">Previous</a>
		</c:if>
		<c:forEach var="i" begin="0" end="${ totalPages-1 }" step="1">
			<c:choose>
				<c:when test="${ (searchTerm ne null) && (sortBy ne null) }">
					<c:url var="pageLink" value="/customer/list">
						<c:param name="pageNo" value="${ i }" />
						<c:param name="searchTerm" value="${ searchTerm }" />
						<c:param name="sortBy" value="${ sortBy }" />
					</c:url>
				</c:when>
				<c:otherwise>
					<c:url var="pageLink" value="/customer/list">
						<c:param name="pageNo" value="${ i }" />
					</c:url>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${ pageNo eq i }">
					<a href="${ pageLink }"><b>${ i+1 }</b></a>
				</c:when>
				<c:otherwise>
					<a href="${ pageLink }">${ i+1 }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${ pageNo != totalPages-1 }">
			<c:choose>
				<c:when test="${ (searchTerm ne null) && (sortBy ne null) }">
					<c:url var="pageLink" value="/customer/list">
						<c:param name="pageNo" value="${ pageNo+1 }" />
						<c:param name="searchTerm" value="${ searchTerm }" />
						<c:param name="sortBy" value="${ sortBy }" />
					</c:url>
				</c:when>
				<c:otherwise>
					<c:url var="pageLink" value="/customer/list">
						<c:param name="pageNo" value="${ pageNo+1 }" />
					</c:url>
				</c:otherwise>
			</c:choose>
			<a href="${ pageLink }">Next</a>
		</c:if>
	</div>
	
	
</body>

</html>