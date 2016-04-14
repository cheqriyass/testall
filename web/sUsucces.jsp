<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up succes</title>
</head>
<body>
Sign Up Succes:<br/>
First name: <bean:write name="signUpF" property="fname"/><br/>
Last name: <bean:write name="signUpF" property="lname"/><br/>
email: <bean:write name="signUpF" property="email"/><br/>
Gender: <bean:write name="signUpF" property="gender"/><br/>

</body>
</html>
