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
        <!-- Icons font CSS-->
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <!-- Font special for pages-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

        <!-- Vendor CSS-->
        <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
        <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

        <!-- Main CSS-->
        <link href="css/main2.css" rel="stylesheet" media="all">


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
            if (usuario == null) {
                response.sendRedirect("login.jsp");
            }
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
                        <li><a href="index.jsp">INICIO</a></li> <!--quito el clase activa -->
                        <li class="dropdown"><a href="#"  class="active"><span>SERVICIOS</span> <i class="bi bi-chevron-down"></i></a>
                            <ul>                 <!--pongo a SERVICIO como clase activa -->
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
                                <li><a href="lista-empleados.jsp">LISTA EMPLEADOS</a></li>
                            </ul>
                        </li>
                       
                    </ul>      
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav><!-- .navbar -->
            </div>
        </header><!-- End Header -->

         <main id="main">

            <div class="page-wrapper bg-gra-03 p-t-45 p-b-50">
                <div class="wrapper wrapper--w790">
                    <div class="card card-5" style="margin-top: 80px;"> <!-- agrego style para que no me pise el navbar -->
                        <div class="card-heading">
                            <h2 class="title">ERROR</h2>
                        </div>
                        <div class="card-body">
                            NO SE PUEDEN REPETIR SERVICIO EN 1 MISMO PAQUETE
                        </div>
                    </div>
                </div>
            </div>
        </main><!-- End #main -->


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
        <!-- Jquery JS-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <!-- Vendor JS-->
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/datepicker/moment.min.js"></script>
        <script src="vendor/datepicker/daterangepicker.js"></script>

        <!-- Main JS-->
        <script src="js/global.js"></script>



        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>

    </body>

</html>
