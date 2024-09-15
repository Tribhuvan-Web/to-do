<!-- Exercise to implement login.jsp -->
<html>
  <head>
    <title>Login page</title>
  </head>
  <body>
  <div class = "container">
    <p>Login page using JSP</p>
    <pre>${errorMessage}</pre>
    <!-- <p>Welcome ${name}</p> -->
    <form method="post">
      Name: <input type="text" name="name" /><br /><br />
      Password <input type="password" name="password" />
      <input type="submit" />
    </form>
  </div>
  </body>
</html>
