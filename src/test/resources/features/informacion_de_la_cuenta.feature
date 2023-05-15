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


  Escenario: Verificar los datos de las transacciones recientes
    Entonces el usuario debe ver 6 transacciones en la sección de transacciones recientes
    Y los valores positivos de las transacciones deben visualizarse en color verde y los valores negativos en color rojo


  Escenario: Verificar los datos del Panorama financiero
    Entonces el usuario debe ver en la sección de Panorama financiero el balance total y el valor del crédito disponible
      | Balance total      | 350    |
      | Crédito disponible | 17,800 |



