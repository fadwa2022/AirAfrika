<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard CRUD Vol</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #ff6b81, #2196F3); /* Dégradé de bleu à rose bébé en arrière-plan */
        }

        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
        }

        section {
            max-width: 600px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid #090202;
        }

        th, td {
            padding: 10px;
            text-align: left;
            color: black;
        }

        label, input {
            display: block;
            margin-bottom: 10px;
            color: black;

        }

        button {
            background-color: #2196F3;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #1769aa; /* Légère variation de la couleur au survol */
        }

    </style>
</head>
<body>
<header>
    <h1>Dashboard</h1>
</header>
<section id="flight-list">
    <h2>Liste des Vols</h2>
    <table>
        <tr>
            <th>Id du Vol</th>
            <th>Ville de Départ</th>
            <th>Ville d Arrivée</th>
            <th>Date Et Heure De Départ</th>
            <th>Date Et Heure De D'arrivée</th>
            <th>Places Disponibles</th>
        </tr>
        <c:forEach items="${vols}" var="vol">
            <tr>
                <td>${vol.id}</td>
                <td>${vol.villedepart.nomdaeroport}</td>
                <td>${vol.villearrivee.nomdaeroport}</td>
                <td>${vol.dateetheurededépart}</td>
                <td>${vol.dateetheurearrivée}</td>
                <td>${vol.nombreDePlacesDisponibles}</td>

            </tr>
        </c:forEach>
    </table>

</section>
<section id="add-flight">
    <h2>Ajouter un Vol</h2>
    <form action="Vols" method="POST">

        <label>Aeroport De Départ:</label>
        <select name="villedepart">
            <c:forEach items="${aeroports}" var="aeroport">
                <option value="${aeroport.id}">${aeroport.nomdaeroport}</option>
            </c:forEach>
        </select>
        <label>Aeroport D'arrivée:</label>
        <select  name="villearrivee">
            <c:forEach items="${aeroports}" var="aeroport2">
                <option  value="${aeroport2.id}">${aeroport2.nomdaeroport}</option>
            </c:forEach>
        </select>
        <label >Date et Heure de Départ:</label>
        <input type="datetime-local"  name="dateetheurededépart" required>
        <label >Date et Heure de D'arrivée:</label>
        <input type="datetime-local"  name="dateetheurearrivée" required>
        <label for="flight-time">Places Disponibles:</label>
        <input type="number" id="flight-time" name="nombreDePlacesDisponibles" required>
        <button type="submit">Ajouter</button>
    </form></section>
</body>
</html>
