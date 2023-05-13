#language: es

Característica: Pruebas de inicio de sesión en applitools
  Yo como usuario
  Quiero iniciar sesión en applitools
  Para poder revisar mi panorama financiero y mis transacciones.

  Escenario: Iniciar sesión en la aplicación applitools
    Dado que el 'usuario' se encuentra en la página web de Applitools
    Cuando ingrese el usuario y contraseña
      | Usuario    | testuser     |
      | Contraseña | testpassword |
    Entonces el sistema deberá direccionarlo a la página de de la tabla de gastos

