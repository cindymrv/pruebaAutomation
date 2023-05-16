# Prueba Automation
Prueba técnica para el rol de Posición QA Semi Senior.

La rama donde estan desarrollados todos los puntos de la prueba es: Master.

Las pruebas corren con el driver de Google que se encuentra dentro del proyecto, la versión de driver es la ChromeDriver 93.0.4577.63

## Las tecnologias usadas son:
* Java
* Cucumber
* Gradle
* Selenium
* Serenity

## Herramientas requeridas:

* Java JDK [download](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* Gradle [download](https://gradle.org/install/)
* Git executable [download](https://git-scm.com/downloads)

## Herramientas recomendadas:

* IDE - IntelliJ IDEA Community Edition [download](https://www.jetbrains.com/idea/download)

## Configuración de las variables de entorno necesarias

Consultar la documentación oficial para la configuración necesaria.

* Java [Documentation](https://java.com/en/download/help/path.html)
* Gradle [Documentation](https://gradle.org/install/)

## Compilación del proyecto

```
gradle compileJava
```
And
``` 
gradle clean assemble
```

## Ejecución del proyecto

* Ejecución de todas las pruebas y generación de informes - Para ejecutar todas las pruebas del proyecto y generar el informe Serenity.
``` java
 gradle clean test aggregate
```

# Los runners son:
```
Para el punto de servicios: APIReqresRunner
Para el punto de automatización de Front: InformacionDeCuentaRunner - LoginRunner
```

## Reporte
El proyecto es soportado por Serenity para la generación de reportes.

El reporte se encontrara en ->

``` 
├──pruebaAutomation
|   └── target
|       └── site
|           └── serenity
|               └── index.html
```
