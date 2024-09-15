<!-- Exercise to implement login.jsp -->
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<html>
  <head>
  <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>
  <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>

    <title>Add to do page </title>
  </head>
  <body>
  <div class = "container">
    <!-- Here we are using a expression language  -->
    <!-- Using JSTL -->
    <h1> Enter Todo Details</h1>
    <form:form method = "post" modelAttribute = "todo">
        Description : <form : input type = "text" path="description" required = "required"/>
        <input type = "submit" class = "btn btn-success"/>
        </form:form>
  </div>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" rel="stylesheet"/>
  <script src="webjars/jquery/3.6.0/jquery.min.js" rel="stylesheet"/>
  </body>
</html>

