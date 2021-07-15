<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Phone Book</h1>
<br />
<br />
<br />
<a href="form">Add New Person</a>
<br />
<br />
<table border="2" width="70%" cellpadding="2">
<tr><th>Name</th><th>Phone</th><th>Email</th><th>address</th><th>Edit</th><th>Delete</th></tr>
   <c:forEach var="person" items="${list}">
   <tr>
   <td>${person.name}</td>
   <td>${person.phoneNumber}</td>
   <td>${person.email}</td>
   <td>${person.adress}</td>
   <td><a href="edit/${person.id}">Edit</a></td>
   <td><a href="delete/${person.id}">Delete</a></td>
   </tr>
   </c:forEach>
   </table>

