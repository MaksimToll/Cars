<%--
  Created by IntelliJ IDEA.
  User: maks
  Date: 28.01.2015
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<%@include file="../elements/header.jsp"%>
<body>

<%--<%@include file="../elements/maib_menu.jsp"%>--%>
<div class="container">

    <%--<form class="form-signin">--%>
        <%--<h2 class="form-signin-heading">Please sign in</h2>--%>
        <%--<label for="inputEmail" class="sr-only">Email address</label>--%>
        <%--<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>--%>
        <%--<label for="inputPassword" class="sr-only">Password</label>--%>
        <%--<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>--%>
        <%--<div class="checkbox">--%>
            <%--<label>--%>
                <%--<input type="checkbox" value="remember-me"> Remember me--%>
            <%--</label>--%>
        <%--</div>--%>
        <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
    <%--</form>--%>

    <form class="form-horizontal" action="registration" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Registration</legend>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="email">email</label>
                <div class="col-md-4">
                    <input id="email" name="email" type="text" placeholder="eamil" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="login">login</label>
                <div class="col-md-4">
                    <input id="login" name="login" type="text" placeholder="login" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="phone">phone</label>
                <div class="col-md-4">
                    <input id="phone" name="phone" placeholder="placeholder" class="form-control input-md" type="text">

                </div>
            </div>


            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="name">input name</label>
                <div class="col-md-4">
                    <input id="name" name="name" type="text" placeholder="name" class="form-control input-md">

                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="passport">pasport</label>
                <div class="col-md-4">
                    <input id="passport" name="passport" type="text" placeholder="AA12345" class="form-control input-md">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password">password</label>
                <div class="col-md-4">
                    <input id="password" name="password" type="password" placeholder="placeholder" class="form-control input-md">

                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="password_repeat"> repeat password</label>
                <div class="col-md-4">
                    <input id="password_repeat" name="passwordinput" type="password" placeholder="placeholder" class="form-control input-md">

                </div>
            </div>


            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="submit">Single Button</label>
                <div class="col-md-4">
                    <button id="submit" name="singlebutton" class="btn btn-primary">Button</button>
                </div>
            </div>

        </fieldset>
    </form>

</div> <!-- /container -->

</body>
</html>
