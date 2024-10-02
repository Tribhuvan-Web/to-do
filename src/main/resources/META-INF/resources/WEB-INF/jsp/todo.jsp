<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
  <head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet"/>
    <title>Add to do page</title>
  </head>
  <body>
    <div class="container">
      <h1>Enter Todo Details</h1>
      <form:form method="post" modelAttribute="todo">

      <fieldset class= "mb-3">
      <form:label path = "description"> Description </form:label>
      <form:input path="description" required="required" type = "text"/>
      <form:errors path = "description" cssClass= "text-warning"/>
      </fieldset>

      <fieldset class= "mb-3">
      <form:label path = "targetDate"> Target Date </form:label>
      <form:input path="targetDate" required="required" type = "text"/>
      <form:errors path = "targetDate" cssClass= "text-warning"/>
      </fieldset>

      <input type="submit" class="btn btn-success" /><br>

      <form:input path="id" type = "hidden"/>

      <form:input path="done" type = "hidden"/>

      </form:form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

    <script type = "text/javascript">
    $(.#targetdate).datepicker({
      format: 'yyyy/mm/dd',
      });
    </script>
  </body>
</html>
