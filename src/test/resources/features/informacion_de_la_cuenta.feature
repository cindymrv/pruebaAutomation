#language: es

Característica: Prueba de verificación de información de cuenta
  Yo como usuario
  Quiero verificar la información que se encuentra en la cuenta
  Para poder tomar deciones sobre futuras transacciones.

  Antecedentes: Iniciar sesión en la cuenta
    Dado que el 'usuario' se encuentra en la página web de Applitools
    Cuando ingrese el usuario y contraseña
      | Usuario    | testuser     |
      | Contraseña | testpassword |


  Escenario: Verifica que hay exactamente 6 transacciones en la tabla de gastos
    Entonces el usuario debe ver 6 transacciones en la tabla de gastos