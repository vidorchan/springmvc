<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<html>
  <head>
    <title>Welcome page</title>
  </head>
  <%--<script src="static-content/js/jquery-1.8.2-min.js" type="text/javascript"></script>--%>
  <script type="text/javascript" src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js" ></script>
  <script type="text/javascript" src="//cdn.bootcss.com/handlebars.js/4.0.6/handlebars.min.js"></script>
  <script type="text/javascript">
      $(document).ready(function () {
          Handlebars.registerHelper('checkMarriage', function(age) {
              return (age > 30 ? '<spring:message text="married" code="married" />': '<spring:message text="not married" code="not.married" />');
          });

          $('#ShowUsers').click(function(){
              $.ajax({
                  url:"rest/demo/query_users",
                  type:"POST",
                  headers: {
                      'Content-Type': 'application/json; charset=utf-8'
                  },
                  success:function(result){
                     console.log(result);
                      var source   = $("#table-template").html();
                      var template = Handlebars.compile(source);
                      //extend(dest,src1,src2,src3...);
                      $('#container').append(template($.extend({}, {test1: "use extend"}, result)));
                  },
                  fail: function (error) {
                      console.log(error);
                  }
              });
          });
      });
  </script>

  <body>
    ${message}&nbsp;&nbsp;&nbsp;<spring:message code="language"/>
    <button type="button" id="ShowUsers">show users</button>
    <t:userList></t:userList>
  </body>
</html>