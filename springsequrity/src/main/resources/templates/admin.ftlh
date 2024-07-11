<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>User details</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <#if currentUser??>
            <li>
                <form action="/logout" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit">Log out</button>
                </form>
            </li>
        </#if>
            <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Screen for admins</h1>

<p>Это экран для администраторов</p>

</body>
</html>