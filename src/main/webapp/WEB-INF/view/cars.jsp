<%@ page import="com.example.model.entity.Car" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.entity.Mechanic" %>
<%@ page import="org.springframework.ui.Model" %>
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
    ID_CAR <input type="number" name="id_car">
    use<input type="checkbox" name=id_car_checkbox><br>

    NAME <input type="text" name="name">
    use<input type="checkbox" name=name_checkbox><br>

    COLOR <input type="text" name="color">
    use<input type="checkbox" name=color_checkbox><br>

    YEAR <input type="number" name="year">
    use<input type="checkbox" name=year_checkbox><br>

    ID_DRIVER <input type="number" name="id_driver">
    use<input type="checkbox" name=id_driver_checkbox><br>

    DRIVER NAME <input type="text" name="name_driver">
    use<input type="checkbox" name=name_driver_checkbox><br>

    DRIVER LAST NAME <input type="text" name="last_name_driver">
    use<input type="checkbox" name=last_name_driver_checkbox><br>

    <input type="submit" value="Submit">
</form>

<table border="1">
    <tr>
        <td>ID_CAR</td>
        <td>NAME</td>
        <td>COLOR</td>
        <td>YEAR</td>
        <td>DRIVER ID</td>
        <td>DRIVER NAME</td>
        <td>DRIVER LAST NAME</td>
        <td>MECHANIC ID</td>
        <td>MECHANIC NAME</td>
        <td>MECHANIC LAST NAME</td>
        <td>MECHANIC CATEGORY</td>
    </tr>
    <c:forEach items="${searchedCars}" var="searchedCars">
        <c:forEach items="${searchedCars.mechanics}" var="mechanics">
            <tr>
                <td>${searchedCars.id_car}</td>
                <td>${searchedCars.name}</td>
                <td>${searchedCars.color}</td>
                <td>${searchedCars.year}</td>
                <td>${searchedCars.driver.id_driver}</td>
                <td>${searchedCars.driver.name_driver}</td>
                <td>${searchedCars.driver.last_name_driver}</td>
                <td>${mechanics.id_mechanic}</td>
                <td>${mechanics.name_mechanic}</td>
                <td>${mechanics.last_name_mechanic}</td>
                <td>${mechanics.category_mechanic}</td>
            </tr>
        </c:forEach>
    </c:forEach>
</table>
</body>
</html>