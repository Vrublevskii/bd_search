<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>DB_Search</title>
</head>
<body>
<h2>Поиск</h2>
<form method="post">
    ID <input type="number" name="id">
    use<input type="checkbox" name=id_checkbox><br>
    NAME <input type="text" name="name">
    use<input type="checkbox" name=name_checkbox><br>
    COLOR <input type="text" name="color">
    use<input type="checkbox" name=color_checkbox><br>
    YEAR <input type="number" name="year">
    use<input type="checkbox" name=year_checkbox><br>
    <input type="submit" value="Submit">
</form>

<table border="1">
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>COLOR</td>
        <td>YEAR</td>
    </tr>
    <c:forEach items="${searchedCars}" var="searchedCars">
        <tr>
            <td>${searchedCars.id}</td>
            <td>${searchedCars.name}</td>
            <td>${searchedCars.color}</td>
            <td>${searchedCars.year}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>