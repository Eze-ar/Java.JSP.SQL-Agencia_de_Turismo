<%-- 
    Document   : index
    Created on : 9/12/2021, 01:29:59 PM
    Author     : Ing. Adrián Ezequiel Angió
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es-AR">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>A-Travel</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">

        <!-- =======================================================
        * Template Name: Company - v4.7.0
        * Template URL: https://bootstrapmade.com/company-free-html-bootstrap-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
    </head>

    <body>
        <% //chequeo de sesión activa con user/pass válidos
            HttpSession sesion = request.getSession();
            String usuario = (String) sesion.getAttribute("usuario");
            //sin usuario válido mando al log in:
            if(usuario == null) response.sendRedirect("login.jsp");
        %>

        <!-- ======= Header ======= -->
        <header id="header" class="fixed-top">
            <div class="d-flex flex-row-reverse">
                <!--muestro qué usuario tiene sesión activa -->
                <div class="p-2">Bienvenido, <b><%=usuario%></b>  |  <a href="login.jsp">[Nuevo usuario]</div>
            </div>
            <div class="container d-flex align-items-center">

                <h1 class="logo me-auto"><a href="index.jsp">A-TRAVEL</a></h1>

                <!-- Uncomment below if you prefer to use an image logo -->
                <!-- <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
                <nav id="navbar" class="navbar order-last order-lg-0">
                    <ul>
                        <li><a href="index.jsp" class="active">INICIO</a></li>
                        <li class="dropdown"><a href="#"><span>SERVICIOS</span> <i class="bi bi-chevron-down"></i></a>
                            <ul>
                                <li><a href="form-servicio.jsp">ALTA SERVICIOS</a></li>
                                <li><a href="lista-servicios.jsp">LISTA SERVICIOS</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a href="#"><span>PAQUETES</span> <i class="bi bi-chevron-down"></i></a>
                            <ul>
                                <li><a href="form-paquete.jsp">ALTA PAQUETE</a></li>
                                <li><a href="lista-paquetes.jsp">LISTA PAQUETES</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a href="#"><span>CLIENTES</span> <i class="bi bi-chevron-down"></i></a>
                            <ul>
                                <li><a href="form-cliente.jsp">ALTA CLIENTE</a></li>
                                <li><a href="lista-clientes.jsp">LISTA CLIENTES</a></li>
                            </ul>
                        </li>
                        <li class="dropdown"><a href="#"><span>EMPLEADOS</span> <i class="bi bi-chevron-down"></i></a>
                            <ul>
                                <li><a href="form-empleado.jsp">ALTA EMPLEADO</a></li>
                                <form action="SvLeeEmpleados" method="GET">
                                    <li><a href="lista-empleados.jsp" class="SUBMIT">LISTA EMPLEADOS</a></li>
                                </form>
                            </ul>
                        </li>
                        
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav><!-- .navbar -->
            </div>
        </header><!-- End Header -->

        <!-- ======= Hero Section ======= -->
        <section id="hero">
            <div id="heroCarousel" data-bs-interval="5000" class="carousel slide carousel-fade" data-bs-ride="carousel">

                <div class="carousel-inner" role="listbox">

                    <!-- Slide 1 -->
                    <div class="carousel-item active" style="background-image: url(assets/img/slide/slide-1.jpg);">
                        <div class="carousel-container">
                            <div class="carousel-content animate__animated animate__fadeInUp">
                                <h2>Welcome to <span>Company</span></h2>
                                <p>Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>
                                <div class="text-center"><a href="" class="btn-get-started">Read More</a></div>
                            </div>
                        </div>
                    </div>

                    <!-- Slide 2 -->
                    <div class="carousel-item" style="background-image: url(assets/img/slide/slide-2.jpg);">
                        <div class="carousel-container">
                            <div class="carousel-content animate__animated animate__fadeInUp">
                                <h2>Lorem Ipsum Dolor</h2>
                                <p>Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>
                                <div class="text-center"><a href="" class="btn-get-started">Read More</a></div>
                            </div>
                        </div>
                    </div>

                    <!-- Slide 3 -->
                    <div class="carousel-item" style="background-image: url(assets/img/slide/slide-3.jpg);">
                        <div class="carousel-container">
                            <div class="carousel-content animate__animated animate__fadeInUp">
                                <h2>Sequi ea ut et est quaerat</h2>
                                <p>Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>
                                <div class="text-center"><a href="" class="btn-get-started">Read More</a></div>
                            </div>
                        </div>
                    </div>

                </div>

                <a class="carousel-control-prev" href="#heroCarousel" role="button" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon bi bi-chevron-left" aria-hidden="true"></span>
                </a>

                <a class="carousel-control-next" href="#heroCarousel" role="button" data-bs-slide="next">
                    <span class="carousel-control-next-icon bi bi-chevron-right" aria-hidden="true"></span>
                </a>

                <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>

            </div>
        </section><!-- End Hero -->


        <!-- ======= Footer ======= -->
        <footer id="footer">
            <div class="container d-md-flex py-4">

                <div class="me-md-auto text-center text-md-start">
                    <div class="copyright">
                        &copy;Copyright Adrián Ezequiel Angió
                    </div>
                    <div class="credits">
                        <!-- All the links in the footer should remain intact. -->
                        <!-- You can delete the links only if you purchased the pro version. -->
                        <!-- Licensing information: https://bootstrapmade.com/license/ -->
                        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/company-free-html-bootstrap-template/ -->

                    </div>
                </div>
            </div>
        </footer><!-- End Footer -->

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/aos/aos.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
        <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
        <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>

    </body>

</html>