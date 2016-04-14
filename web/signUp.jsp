<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link type="text/css" rel="stylesheet" href="include/style.css"/>
</head>
<body>

<s:form method="post" action="signup.do">
    <fieldset style="background-color: #DDDDDD">
        <legend>Sign Up</legend>
        <div style="color: red">
            <s:errors/>
        </div>

        <table>
            <tr>
                <td>First name:</td>
                <td><html:text property="fname" name="signUpF"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><html:text property="lname" name="signUpF"/></td>
            </tr>

            <tr>
                <td>email:</td>
                <td><html:text property="email" name="signUpF"/></td>

            </tr>
            <tr>
                <td>Password:</td>
                <td><html:password property="password" name="signUpF"/></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><html:password property="password" name="signUpF"/></td>
            </tr>

            <tr>
                <td>Gender:</td>
                <td>
                    <html:radio property="gender" name="signUpF" value="male"/>Male
                    <html:radio property="gender" name="signUpF" value="female"/> Female
                </td>
            </tr>
        </table>

        <html:reset value="Reset"/>
        <html:submit value="Login"/>
    </fieldset>
</s:form>

</body>
</html>
