<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/lib/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/lib/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/lib/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Connexion</title>
    <link type="text/css" rel="stylesheet" href="include/style.css"/>
</head>
<body>

<html:form method="post" action="login.do" >
    <fieldset>
        <legend>Connexion</legend>
        <div style="color: red">
            <html:errors />
        </div>
                 email:
                <html:text property="nomUtilisateur" name="loginF"/>

                Password:
                <html:password property="mdpUtilisateur" name="loginF"/>

                <html:reset  value="Reset"/>
                <html:submit value="Login"/>
    </fieldset>
</html:form>

<a href="" >Sign Up</a>

</body>
</html>
