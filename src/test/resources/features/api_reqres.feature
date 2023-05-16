#language: es

Característica: Pruebas de consumos de API de reqres in
  Yo como Automatizador
  Quiero realizar los consumos de la API reqres.in
  Para obtener los resultados esperados en cada tipo de Consumo.

  Antecedentes: Definir Precondiciones Propias para todos los escenarios
    Dado que 'Cindy' realiza el consumo de la url base 'https://reqres.in/api'

  Escenario: Insertar un empleado en lista de empleados en la API
    Cuando inserte un usuario en la API con características
      | Nombre  | Test User         |
      | Trabajo | Automation Engineer |
    Entonces el servicio me debe responder con un status code 201
    Y al consultar el id del empleado creado en el servicio
    Entonces el servicio me debe responder con un status code 200




