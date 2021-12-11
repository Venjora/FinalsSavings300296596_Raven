<%--
  Created by IntelliJ IDEA.
  User: raven
  Date: 2021-12-11
  Time: 9:29 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Savings Investment Record</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        h1 {
            text-align:center;
            background-color: cyan;

        }

        .btn {

            width: 100%;
        }


    </style>
</head>
<body>
<h1>Savings Investment Record</h1>
<script>
    document.getElementById("mes").innerHTML = "";
</script>


<div class="container">

    <h1 id="mes">${errorMessage}</h1>
    <div class="container2">
        <h2>The following are the savings records...</h2>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Customer number</th>
                <th>Customer Name</th>
                <th>Customer Deposit</th>
                <th>Number of years</th>
                <th>samplePackage.Savings Type</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${todos}" var="todo">

                <tr>
                    <td>${todo.custno}</td>
                    <td>${todo.custname}</td>

                    <td>    <a type="button" class="btn btn-primary"
                               href="update-todo?id=${todo.custno}" >Edit</a> </td>



                    <td>    <a type="button" class="btn btn-primary"
                               href="delete-todo?id=${todo.custname}" >Delete</a> </td>



                    <td>    <a type="button" class="btn btn-primary" onmouseout="myFunction()"
                               href="see-todo?id=${todo.custno}" >Projected Investment</a> </td>


                </tr>


            </c:forEach>
            </tbody>
        </table>
    </div>

    <form method="GET">
        <a class="btn btn-success" href="add-todo">Add</a>

    </form>

</div>

<script>

    function myFunction() {

        document.getElementById("mes").innerHTML = "";
    }

</script>

</body>
</html>