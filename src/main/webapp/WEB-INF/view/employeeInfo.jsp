<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>

<h1>Employee Information</h1>
<br>
<br>
<security:authorize access="hasAnyRole('IT', 'SECURITY', 'DIRECTOR')">
<input type="button" value="For it"
       onclick="window.location.href = 'it_info'">
Only for it and security and director
</security:authorize>
<br>
<br>
<security:authorize access="hasAnyRole('SECURITY', 'DIRECTOR')">
<input type="button" value="For security"
       onclick="window.location.href = 'security_info'">
Only for security and director
</security:authorize>
<br>
<br>
<security:authorize access="hasRole('DIRECTOR')">
<input type="button" value="For director"
       onclick="window.location.href = 'director_info'">
Only for director
</security:authorize>

</body>

</html>