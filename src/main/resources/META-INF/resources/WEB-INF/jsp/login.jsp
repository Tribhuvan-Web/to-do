<!-- Exercise to implement login.jsp -->
<html>
  <head>
    <title>Login page</title>
  </head>
   <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>

  <body>
  <div class = "container">
    <h1>Login page using JSP</h1>
    <pre>${errorMessage}</pre>
    <!-- <p>Welcome ${name}</p> -->
    <form method="post">
      Name: <input type="text" name="name" /><br /><br />
      Password <input type="password" name="password" />
      <input type="submit" />
    </form>
  </div>
  </body>
   <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" rel="stylesheet"/>
  <script src="webjars/jquery/3.6.0/jquery.min.js" rel="stylesheet"/>
</html>
