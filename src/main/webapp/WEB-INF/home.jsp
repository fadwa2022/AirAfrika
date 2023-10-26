<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Theory by TEMPLATED</title>
    <meta charset="utf-8">

    <meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href='<c:url value="/./CSS/assets/css/main.css"/>'>
</head><body>
<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500" rel="stylesheet" />
<link href='<c:url value="/./search/css/main.css"/>' rel="stylesheet"  type="text/css" />
<!-- Header -->
<header id="header"><div class="inner">
    <a href="index.html" class="logo">Theory</a>
    <nav id="nav"><a href="index.html">Home</a>
        <a href="generic.html">Generic</a>
        <a href="elements.html">Elements</a>
    </nav><a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
</div>
</header><!-- Banner -->
<section id="banner"><h1>Welcome to Theory</h1>

    <div class="s002">
        <form  action="Search" method="POST">
            <fieldset>
                <legend>SEARCH HOTEL</legend>
            </fieldset>
        <div class="inner-form">
                <div class="input-field ">
                    <div class="icon-wrap">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path d="M17 12h-5v5h5v-5zM16 1v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2h-1V1h-2zm3 18H5V8h14v11z"></path>
                        </svg>
                    </div>
                    <label>date d arrivee</label>
                    <input name="DateArrivee"  id="depart" type="datetime-local" placeholder="Date Arrivee" />
                </div>
                <div class="input-field">
                    <div class="icon-wrap">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path d="M17 12h-5v5h5v-5zM16 1v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2h-1V1h-2zm3 18H5V8h14v11z"></path>
                        </svg>
                    </div>
                    <label>date de depart</label>

                    <input name="DateDepart"  id="return" type="datetime-local" placeholder="Date Depart" />
                </div>
               <div class="input-field fouth-wrap">

                   <div class="icon-wrap">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                            <path d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z"></path>
                        </svg>
               </div>
                   <label>Aeroport de depart</label>

                   <select  data-trigger=""  name="aeroportdepart">
                       <option value="0" >Sélectionnez </option>

                       <c:forEach items="${aeroports}" var="aeroport">
                            <option value="${aeroport.id}">${aeroport.nomdaeroport}</option>
                        </c:forEach>
                    </select>
               </div>
              <div class="input-field fouth-wrap">

                <div class="icon-wrap">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                        <path d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z"></path>
                    </svg>
                </div>
                  <label>Aeroport d'arrivee</label>

                  <select  data-trigger=""  name="aeroportdarrivee">
                      <option value="0" >Sélectionnez </option>

                      <c:forEach items="${aeroports}" var="aeroport">
                        <option value="${aeroport.id}">${aeroport.nomdaeroport}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-field fifth-wrap">
                    <button class="btn-search" type="submit">SEARCH</button>
                </div>
                </div>

        </form>
    </div>
</section><!-- One -->
<section id="one" class="wrapper"><div class="inner">
<div class="flex flex-3">
<c:forEach items="${vols}" var="vol">
<article>
    <form action="Reservation?id=${vol.id}" method="POST">
    <header>
            <h3>Vol ${vol.villedepart.nomdaeroport}</h3>
    </header>
    <p > <em style="color: black">Aeroport D'arrivée :</em> ${vol.villearrivee.nomdaeroport}</p>
    <p> <em style="color: black">Date et Heure de Départ : </em>${vol.dateetheurededépart}</p>
    <p>  <em style="color: black"> Date et Heure de D'arrivée :</em> ${vol.dateetheurearrivée}</p>
    <div style="display: flex;">
        <p style="margin-right: 10px;">
            <em style="color: black">Tarif :</em>
            <span class="prix" data-id="${vol.id}" data-devise="MAD">${vol.tarif} MAD</span>
        </p>        <select class="currency" style="width: 80px;height: 20px;background: transparent; border: none" onchange="maFonction(this)">
            <option selected value="MAD"  >MAD</option>
            <option value="EUR">EURO</option>
        </select>
    </div>
    <p style="margin-right: 10px;"> <em style="color: black">Escals :</em>
        <c:forEach items="${escals}" var="escal">

        <c:if test="${vol.id == escal.vol_ID.id}">
    <span >${escal.aeroport_ID.nomdaeroport}</span>
            <span style="color: black">-></span>

        </c:if>
        </c:forEach>

    </p>
    <div>
        <label>Ajouter des extras ?</label>
        <input type="radio" id="yesChoice${vol.id}" value="yes" onclick="showExtras(${vol.id})"> Oui
        <input type="radio" id="noChoice${vol.id}" value="no" onclick="hideExtras(${vol.id})" checked> Non
    </div>
    <div id="extrasSection${vol.id}" style="display: none;">
        <p><em style="color: black">Sélectionnez des extras :</em></p>
        <c:forEach items="${extras}" var="extra" varStatus="loop">
            <input type="checkbox" id="${extra.id}${vol.id}" name="extra${loop.index}" value="${extra.id}">
            <label for="${extra.id}${vol.id}">${extra.nom} : ${extra.tarif} </label>
        </c:forEach>
    </div>

    <footer>
            <button type="submit"  class="button special">Reserver</button>
    </footer>
</form>
    </article>

</c:forEach>



</div>
</div>
</section><!-- Two -->
<section id="two" class="wrapper style1 special"><div class="inner">
<header><h2>Ipsum Feugiat</h2>
    <p>Semper suscipit posuere apede</p>
</header><div class="flex flex-4">
    <div class="box person">
        <div class="image round">
            <img src="../CSS/images/pic03.jpg" alt="Person 1" width="168" height="168"></div>
        <h3>Magna</h3>
        <p>Cipdum dolor</p>
    </div>
    <div class="box person">
        <div class="image round">
            <img src="../CSS/images/pic04.jpg" alt="Person 2" width="168" height="168"></div>
        <h3>Ipsum</h3>
        <p>Vestibulum comm</p>
    </div>
    <div class="box person">
        <div class="image round">
            <img src="../CSS/images/pic05.jpg" alt="Person 3" width="168" height="168"></div>
        <h3>Tempus</h3>
        <p>Fusce pellentes</p>
    </div>
    <div class="box person">
        <div class="image round">
            <img src="../CSS/images/pic06.jpg" alt="Person 4" width="168" height="168"></div>
        <h3>Dolore</h3>
        <p>Praesent placer</p>
    </div>
</div>
</div>
</section><!-- Three -->
<section id="three" class="wrapper special"><div class="inner">
<header class="align-center"><h2>Nunc Dignissim</h2>
    <p>Aliquam erat volutpat nam dui </p>
</header><div class="flex flex-2">
    <article><div class="image fit">
        <img src="../CSS/images/pic01.jpg" alt="Pic 01" width="576" height="196"></div>
        <header><h3>Praesent placerat magna</h3>
        </header><p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor lorem ipsum.</p>
        <footer><a href="#" class="button special">More</a>
        </footer></article><article><div class="image fit">
    <img src="../CSS/images/pic02.jpg" alt="Pic 02" width="576" height="196"></div>
    <header><h3>Fusce pellentesque tempus</h3>
    </header><p>Sed adipiscing ornare risus. Morbi est est, blandit sit amet, sagittis vel, euismod vel, velit. Pellentesque egestas sem. Suspendisse commodo ullamcorper magna non comodo sodales tempus.</p>
    <footer><a href="#" class="button special">More</a>
    </footer></article></div>
</div>
</section><!-- Footer --><footer id="footer"><div class="inner">
<div class="flex">
    <ul class="icons"><li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
        <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
        <li><a href="#" class="icon fa-linkedin"><span class="label">linkedIn</span></a></li>
        <li><a href="#" class="icon fa-pinterest-p"><span class="label">Pinterest</span></a></li>
        <li><a href="#" class="icon fa-vimeo"><span class="label">Vimeo</span></a></li>
    </ul></div>
</div>
</footer><div class="copyright">
Site made with: <a href="https://templated.co/">TEMPLATED.CO</a>
</div>

<!-- Scripts -->
<script>
    function convertMADtoEUR(madAmount) {
        const tauxConversion = 0.10;
        return (madAmount * tauxConversion).toFixed(2);
    }

    function convertEURtoMAD(euroAmount) {
        const tauxConversion = 10;
        return (euroAmount * tauxConversion).toFixed(2);
    }

    const currencySelect = document.getElementById('currency');

    function maFonction(selectElement) {
        var selectedValue = selectElement.value;
        const prixElements = document.querySelectorAll('.prix');

        prixElements.forEach(function(prixElement) {
            const id = prixElement.getAttribute('data-id');
            const devise = prixElement.getAttribute('data-devise');
            const prix = parseFloat(prixElement.textContent);

            if (selectedValue === "EUR" && devise === "MAD") {
                prixElement.textContent = convertMADtoEUR(prix) + " EUR";
                prixElement.setAttribute('data-devise', '');
            } else if (selectedValue === "MAD" && devise === "EUR") {
                prixElement.textContent = convertEURtoMAD(prix) + " MAD";
                prixElement.setAttribute('data-devise', '');
            }
        });
    }
</script>
<script src="../CSS/assets/js/jquery.min.js"></script>
<script src="../CSS/assets/js/skel.min.js"></script>
<script src="../CSS/assets/js/util.js"></script>
<script src="../CSS/assets/js/main.js"></script>
<script src='<c:url value="/./search/js/extention/choices.js"/>'></script>
<script src='<c:url value="/./search/js/extention/flatpickr.js"/>'></script>
<script>
    flatpickr(".datepicker",
        {});

</script>
<script>
    const choices = new Choices('[data-trigger]',
        {
            searchEnabled: false,
            itemSelectText: '',
        });

</script>
<script>
    function showExtras(volId) {
        document.getElementById("extrasSection" + volId).style.display = "block";
    }

    function hideExtras(volId) {
        document.getElementById("extrasSection" + volId).style.display = "none";
    }

</script>
</body></html>

