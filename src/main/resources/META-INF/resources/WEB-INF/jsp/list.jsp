<!-- Exercise to implement login.jsp -->
<%@ taglib prefix="c" uri="jakarta.tags.core"  %>

<html>
  <head>
  <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>

    <title>Welcome </title>
  </head>
  <body>
  <div class = "container">
    <!-- Here we are using a expression language  -->
    <!-- Using JSTL -->
    <h1> Welcome ${userName}</h1>
    <table class = "table">
      <thead>
      <tr>
        <th>Description</th>
        <th>Target Date</th>
        <th>Is Completed?</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>${todo.description}</td>
            <td>${todo.targetDate}</td>
            <td>${todo.done}</td>
            <td><a href = "delete-todo?id=${todo.id}" class = "btn btn-warning"> DELETE </a></td> 
            <td><a href = "update-todo?id=${todo.id}" class = "btn btn-info"> UPDATE </a></td> 
        </tr>
    </c:forEach>
      </tbody>
    </table>
    <a href = "add-todo" class = "btn btn-success">Add Todo</a>
  </div>
  
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js" rel="stylesheet"/>
  <script src="webjars/jquery/3.6.0/jquery.min.js" rel="stylesheet"/>
  </body>
</html>

