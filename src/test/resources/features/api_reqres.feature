#language: es

Característica: Pruebas de consumos de API de reqres in
  Yo como Automatizador
  Quiero realizar los consumos de la API reqres.in
  Para obtener los resultados esperados en cada tipo de Consumo.

  Antecedentes: Definir Precondiciones Propias para todos los escenarios
    Dado que 'Cindy' realiza el consumo de la url base 'https://reqres.in/api'

  Escenario: Insertar un empleado en la lista de empleados en la API
    Cuando inserte un usuario en la API con características
      | Nombre  | Test User         |
      | Trabajo | Automation Engineer |
    Entonces el servicio me debe responder con un status code 201
    Y al consultar el id del empleado creado anteriormente
    Entonces se debe visualizar el nombre 'Test User' del usuario insertado


  Escenario: Obtener respuesta de un usuario no registrado en la API
    Cuando consulte un usuario no registrado en la API
    Entonces el servicio me debe responder con un status code 404


  Escenario: Actualizar lista de empleados en la API
    Cuando actualice un usuario en la API con características
      | Nombre  | Oscar         |
      | Trabajo | Líder Técnico |
    Entonces el servicio me debe responder con un status code 200

  Escenario: Eliminar usuario
    Cuando elimine un usuario en la API con id 4
    Entonces el servicio me debe responder con un status code 204





