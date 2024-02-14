## Ejercicio - Armas de fuego.

### Descripción:

1. Implementar una clase ArmaDeFuego con sus métodos y propiedades:

2. Propiedades (ninguna de las propiedades, excepto danio y radio, podrá accederse desde fuera de esta clase)

   - nombre: String
   - municion: Int
   - municionARestar: Int
   - tipoDeMunicion: String (9mm, 7.62mm, 60mm, RPG, ... etc)

   Estas dos últimas propiedades solo deben declararse, sin inicializarse en la clase Armas de fuego.
   - danio: Int
   - radio: String (puede tomar solo los valores "Reducido", "Corto", "Intermedio", "Amplio" y "Enorme")
  
   Todas las armas de fuego deberán compartir la caja de municiones extra para recargar:
   - cantidadMunicionExtra: Int (debe inicializarse con un valor aleatorio entre 5 y 15)

4. Metodos

   - dispara: resta munición (utiliza correctamente a municionARestar) y muestra un mensaje dónde indiques que arma de fuego se ha disparado y la munición restante.
     Si no tiene suficiente munción debe recargar y disparar.
     Si no tiene munición extra de recarga debe mostrar "No hay suficiente munición para disparar.".
   
   - recarga: aumenta la munición y muestra un mensaje dónde indiques que arma de fuego se ha recargado y la munición actual después de dicha recarga.
     Debe intentar recargar el doble de la municion a restar cuando dispara.
     Si no hay suficiente munición extra, entonces intenta recargar solo la munición a restar.
     Si no puede realizar la recarga debe mostrar el mensaje "No hay suficiente munición extra para recargar.".
   
   - mostrarInfo: debe mostrar el valor de todas sus propiedades (Nombre: Rifle, Munición: 6, Tipo de Munición: 9mm, Daño: 5, Radio: Intermedio).

***NOTA***: Se pretende que la clase ArmaDeFuego refleje la intención del programador de que sirva como una superclase para tipos más específicos de armas y prevenir 
su instanciación directa, manteniendo así la coherencia y la claridad en la jerarquía de clases del programa.

### El ejercicio constará de dos partes:

***Parte 1: Implementa las sub-armas.***

- Pistola: Resta munición * 1
   * Debe requerir que danio sea un valor entre 1 y 5; radio debe ser reducido o corto.
- Rifle: Resta munición * 2
   * Debe requerir que danio sea un valor entre 5 y 10; radio debe ser corto o intermedio.
- Bazooka: Resta munición * 3
  * Debe requerir que danio sea un valor entre 10 y 30; radio debe estar entre intermedio y enorme.

1. Crea una instancia de cada arma desde el programa principal denro de una lista.
2. Muestra en mensaje con la munición extra que existe... "\nMunición extra = 11... para todas las armas de fuego.\n"
3. Crea un mapa en el que registrar aletoriamente 12 disparos sobre armas... cada arma realizará entre 1 y 3 disparos de forma aleatoria.
4. Recorre el mapa... dispara y muestra su información cada vez que dispares.

   Para ello, crea una lista de armas de fuego con las 3 sub-armas.
   Muestra el mensaje de la munición extra.
   val disparos = (1..12).map { armas.random() to (1..3).random() } // Creación del mapa (punto 3.)
   Recorre disparos disparando y mostrando la info según el número de veces aleatoria que se haya creado en cada elemento de la lista disparos (analiza bien la instrucción anterior)

   Si no puedes resolverlo cómo se indica en las instrucciones anteriores hazlo a tu forma... debes crear 12 sub-armas de forma aleatoria que disparen y muestren su info de forma aleatoria entre 1 y 3 veces cada una.
   
   Deben dispararse 12 armas, cada una entre 1 y 3 veces... muestra también un mensaje que identifique cada comienzo de los 12 disparos

***NOTA***: Todas los objetos o instancias que realicemos de la clase Pistola tendrán como nombre "Pistola" sin necesidad de pasar ningún String su constructor. 
Lo mismo ocurrirá con Rifle y Bazooka.

Ejemplo de resultado en la consola:

![Resultado de ejecución del programa en consola](/assets/armasFuegoConsola.jpg)

*** Parte 2: Modifica el programa para contemplar que otros objetos puedan Disparar. *** 

1. Genera aleatoriamente disparos, en este caso 9, para las armas de fuego y para tres clases más (Casa, Coche y Bocadillo).
2. La clase Casa dispara confetti.
3. La clase Coche dispara ráfagas de luz larga.
4. La clase Bocadillo dispara olor a jamón.

### Recursos

  - Apuntes sobre principios de la programación orientada a objetos.
  - Documentación oficial de Kotlin sobre herencia, clases y métodos.

### Evaluación y calificación
  
  RA y CE evaluados: RA4, CE b-k

