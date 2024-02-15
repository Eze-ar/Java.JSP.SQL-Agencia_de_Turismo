# Agencia de Turismo "A-Travel"

## Aplicación Web usando Java y JSP

Este proyecto es una aplicación web desarrollada en Java, usando JSP para una agencia de turismo. Permite realizar operaciones como altas, bajas y listados de paquetes y servicios turísticos, así como altas, 
bajas y listados de empleados/usuarios del sistema.

Este proyecto formó constituyó mi proyecto final para el curso de Programador Full Stack con Java del Silicon (Polotic) Misiones del año 2021.

## Base de Datos requerida

Previo a la ejecución de la aplicación web, debe existir una base de datos SQL llamada "agencia" con el siguiente usuario y contraseña:

- **Nombre de la Base de Datos:** agencia
- **Usuario:** age
- **Contraseña:** 1234

Para ello en mi caso utilicé XAMPP.

## Ingreso y Administración de Usuarios

La primera vez que se ingrese a la aplicación, se debe ingresar en el login las siguientes credenciales:

- **Usuario:** admin
- **Contraseña:** 2435

  Que será el administrador por defecto.

Luego de cargar el primer empleado/usuario, se inhabilita el administrador por defecto, por seguridad. Es importante no dar de baja a todos los usuarios. Al menos debe quedar un administrador. 
En caso contrario, habrá que borrar la base de datos completa y volver a comenzar con las credenciales predeterminadas.

## Configuración de Paquetes y Servicios

El número máximo de servicios por paquete es 3 para esta demo, pero este límite es ampliable con modificaciones mínimas al programa. No se controla la repetición de usuarios en la aplicación.

Se agregó el campo "nombre" al paquete para facilitar la identificación. En la lista de servicios del paquete (al presentar por pantalla), se muestran los nombres de los servicios incluidos para ahorrar 
espacio visual. El listado completo de servicios se puede ver en el apartado correspondiente.

## Sobre el borrado de Paquetes, Servicio y Empleados

El borrado es borrado lógico. Al borrar un paquete, servicio o dar de baja un empleado su estado pasará a INACTIVO. 
En el caso de un empleado, al darlo de baja, también se inhabilita su usuario y contraseña para ingresar al sistema.

## Fechas

Las fechas se muestran en formato dd/MM/yyyy en la interfaz de usuario, pero se almacenan en la base de datos como yyyy-MM-dd.

## Consideraciones Importantes

- **Relación Cliente-Empleado:** En el modelo UML, la relación entre clientes y empleados está ligada por la transacción (venta), pero no es una agencia donde algún vendedor tenga clientes asignados.
  En caso de que sí lo hubiera, se requeriría otra relación 1-n entre empleados y clientes.

- **Página de Venta:** La página y servicio de venta no fue incluido en este proyecto.

## VIDEO DEMOSTRATIVO

En el siguiente video demuestro el uso de la aplicación web desde el login hasta el alta, baja y listado de paquetes, servicios y empleados/usuarios:

[Ver video Demostrativo](https://github.com/Eze-ar/Eze-ar-Java.JSP-Agencia_de_Turismo/blob/main/demostracion.mkv)

