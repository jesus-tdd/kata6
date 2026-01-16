# IS2 - Kata 6
Sexta *kata* de Ingeniería del Software 2 del Grado Ingeniería Informática (ULPGC)


### Ejercicio
> Partiendo de la Kata anterior, ampliar el proyecto para convertirlo en un servicio web.
>  El nuevo servicio deberá permitir solicitar, mediante parámetros HTTP, la generación de un histograma específico y devolverlo en formato JSON.
> 
> Se implementará el patrón de diseño Adapter para desacoplar la arquitectura interna de la aplicación del formato y protocolo de comunicación del servicio web.


### Código.
Funcionalidades varias para el web service:
* Json con la lista de pokemons
* Json con todos los pokemon con un nombre específico (por ejemplo, las formas de Charizard)
* Json del histograma de pokemons por tipo

Utilización del patrón adapter para crear el Json del hisograma.


### Créditos
El dataset de siempre: [github.com/lgreski/pokemonData](https://github.com/lgreski/pokemonData/blob/master/Pokemon.csv)


### Dependencias
* [JFreeChart v1.5.6](https://mvnrepository.com/artifact/org.jfree/jfreechart/1.5.6)
* [SQLite v3.51.0.0](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc/3.51.0.0)
* [Javalin v6.7.0](https://mvnrepository.com/artifact/io.javalin/javalin/6.7.0)
* [SLF4J Simple Provider v2.0.16](https://mvnrepository.com/artifact/org.slf4j/slf4j-simple/2.0.16)
* [Jackson Databind v2.17.2](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.17.2)


## 
Ver vídeo (próximamente) | [Todas las Katas](https://www.youtube.com/playlist?list=PL_MLZ_QLgMQ8v5oYzwturBAajvCAg-p8c)
