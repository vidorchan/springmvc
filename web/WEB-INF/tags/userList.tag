<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@tag description="Set up users table" pageEncoding="UTF-8"%>

<div id="container">
    <script id="table-template" type="text/x-handlebars-template">

        <table id="userTable" style="border: #ff5963 dotted 2px" data-control="table">
            <thead>
            <tr>
                <th><spring:message code="id" text="id" /></th>
                <th><spring:message code="name" text="name" /></th>
                <th><spring:message code="age" text="age" /></th>
                <th><spring:message code="state" text="state" /></th>
                <th><spring:message code="marriage" text="marriage" /></th>
            </tr>
            </thead>
            <tbody>
            {{#each value}}
            <tr>
                <td>{{this.userId}}</td>
                <td>{{this.username}}</td>
                <td>{{this.age}}</td>
                <td>{{../this.errMsg}}</td>
                <td>{{checkMarriage this.age}}</td>
            </tr>
            {{/each}}
            </tbody>
        </table>
        {{test1}}
    </script>
</div>
