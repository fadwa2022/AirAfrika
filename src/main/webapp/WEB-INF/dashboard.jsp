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
            <th>Tarifs</th>

        </tr>
        <c:forEach items="${vols}" var="vol">
            <tr>
                <form method="POST" action="Vols/Update">
                <td class="idvol" name="id">${vol.id}</td>
                <td data-field="villedepart">
                    <select name="villedepart">
                        <c:forEach items="${aeroports}" var="aeroport2">
                            <option value="${aeroport2.id}" ${vol.villedepart.id == aeroport2.id ? 'selected' : ''}>
                                    ${aeroport2.nomdaeroport}
                            </option>
                        </c:forEach>
                    </select>

                </td>
                <td data-field="villearrivee" >
                    <select name="villearrivee" >
                        <c:forEach items="${aeroports}" var="aeroport">
                            <option value="${aeroport.id}"
                                ${vol.villearrivee.id == aeroport.id ? 'selected' : ''}>
                                    ${aeroport.nomdaeroport}
                            </option>
                        </c:forEach>
                    </select>
                </td>
                <td data-field="dateetheurededépart" name="dateetheurededépart">${vol.dateetheurededépart}</td>
                <td data-field="dateetheurearrivée" name="dateetheurearrivée">${vol.dateetheurearrivée}</td>
                <td data-field="nombreDePlacesDisponibles" name="nombreDePlacesDisponibles">${vol.nombreDePlacesDisponibles}</td>
                <td data-field="tarif" name="tarif">${vol.tarif}</td>
                <td>
                    <button type="submit"><i class="fas fa-pencil-alt"></i> Modifier</button>
                    <a href="/demo4_war_exploded/Vols/Delete/${vol.id}"><i class="fas fa-trash-alt"></i> Supprimer</a>

                </td>

                </form>
            </tr>
        </c:forEach>
    </table>
</section>
<section id="add-flight">
    <h2>Ajouter un Vol</h2>
    <form  id="flight-form" action="Vols" method="POST">

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
        <input  id="dateetheurededépart" type="datetime-local"  name="dateetheurededepart" required>
        <label >Date et Heure de D'arrivée:</label>
        <input  id="dateetheurearrivée" type="datetime-local"  name="dateetheurearrivee" required>
        <label >Places Disponibles:</label>
        <input id="nombreDePlacesDisponibles" type="number" name="nombreDePlacesDisponibles" required>
        <label >Trif:</label>
        <input id="tarif" type="number" name="tarif" required>
        <label>Escales:</label>
        <div id="escales-container">
            <p>Sélectionnez l'aéroport d'escale:</p>
            <select name="escale1">
                <c:forEach items="${aeroports}" var="aeroport2">
                    <option value="${aeroport2.id}">${aeroport2.nomdaeroport}</option>
                </c:forEach>
            </select>
        </div>
        <input type="hidden" name="dernierId" value="${vols[vols.size() - 1].id}" />

        <button type="button" id="ajouter-escale">+</button>

        <button type="submit">Ajouter</button>
    </form></section>
<script>
    var editableCells = document.querySelectorAll('td[data-field]');
    editableCells.forEach(function(cell) {
        cell.addEventListener('click', function() {
            var input;

            var fieldType = cell.getAttribute('data-field');

            if (fieldType === 'dateetheurededépart' || fieldType === 'dateetheurearrivée') {

                input = document.createElement('input');
                input.type = 'datetime-local';

            } else if (fieldType === 'villedepart' || fieldType === 'villearrivee') {

            } else {
                input = document.createElement('input');
                input.type = 'number';
            }

            input.value = cell.textContent;

            cell.innerHTML = '';
            cell.appendChild(input);

            input.focus();

            input.addEventListener('keyup', function(e) {
                if (e.key === 'Enter') {
                    cell.textContent = input.value;


                }
            });
        });
    });



</script>
<script>
    var escaleCount = 1;

    document.getElementById("ajouter-escale").addEventListener("click", function() {
        escaleCount++;

        var escaleContainer = document.getElementById("escales-container");
        var newSelect = document.createElement("select");
        newSelect.name = "escale" + escaleCount;

        // Clone the options from the original select
        var originalSelect = document.querySelector('select[name="escale1"]');
        for (var i = 0; i < originalSelect.options.length; i++) {
            var originalOption = originalSelect.options[i];
            var newOption = document.createElement("option");
            newOption.value = originalOption.value;
            newOption.text = originalOption.text;
            newSelect.appendChild(newOption);
        }

        escaleContainer.appendChild(newSelect);
    });
</script>
<script>
    var escales = [];

    document.getElementById('ajouter-escale').addEventListener('click', function() {
        var escale = document.querySelector('#escales-container select').value;

        escales.push(escale);

        document.querySelector('#escales-container select').value = '';

        console.log(escales);
    });

</script>


</body>
</html>
