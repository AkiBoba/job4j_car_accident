<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <style>
        .container {
            width: 750px;
            height: auto;
            background-color: bisque;
            padding-top: 50px;
            text-align: left;
        }
        body {
            padding: 50px;
            background-color: darkgrey;
        }
        header {
            text-align: center;
            background-color: cadetblue;
        }
        .table
        {
            display:table;
            text-align: left;
        }

        .table-row
        {
            display:table-row;
        }

        .table-cell
        {
            display: inline-block;
            margin-right: 10px;
            width: 10%;
        }

        .table-cell:nth-child(6)
        {
            margin-right: 0px;
        }
        .form-control.name {
            width: auto;
        }
    </style>

    <title>CreateAccident</title>
</head>
<body>
<div class="container">
    <header>
        <h5>Edit accident</h5>
    </header>
    <nav>
    </nav>
    <div class="table">
        <div class="table-row">
            <div class="table-cell" type='hidden'># </div>
            <div class="table-cell">Name </div>
            <div class="table-cell">Text </div>
            <div class="table-cell">Address </div>
            <div class="table-cell">Type </div>
            <div class="table-cell">Rules </div>
        </div>
        <form action="<c:url value='/update'/>" method='POST'>
            <div class="table-row">
                <div class="table-cell">
                    <input type='hidden' class="form-control" name='id' value="${accident.id}">
                </div>
                <div class="table-cell">
                    <input type='text' class="form-control" name='name' value="${accident.name}">
                </div>
                <div class="table-cell">
                    <input type='text' class="form-control" name='text' value="${accident.text}">
                </div>
                <div class="table-cell">
                    <input type='text' class="form-control" name='address' value="${accident.address}">
                </div>
                <div class="table-cell">
                    <select name="type.id" class="form-control name">
                        <c:forEach var="type" items="${types}" >
                            <option value="${type.id}">${type.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="table-row">
                <select name="rIds" multiple>
                    <c:forEach var="rule" items="${rules}" >
                        <option value="${rule.id}">${rule.name}</option>
                    </c:forEach>
                </select>
            </div>
            </div>
            <div class="table-row">
                <div class="table-cell">
                    <button name="submit" type="submit" class="btn btn-info">
                        ??????????????????
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
