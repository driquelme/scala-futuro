# Scala Futuros con programación funcional

Ejemplos de código de presentación sobre Scala Futures con programación funcional.

## Texto de slides

### Historia

* 1976 - Daniel P. Friedman, David Wise (lazy programming, lazy streams, continuation objects, lambda calculus, The title Lisper, The litle MLer, The Seasoned Schemer, The Litle Java, A Few Patterns) propusieron el término “promesa" 

* 1976 - Peter Hubbard lo llamó "eventual" 

* 1977 - El concepto “futuro” es acuñado por Henry Baker (garbage collection, functional programming, linear logic y actor model) y Carl Hewitt (Actor model, open information systems, multi agent systems, logic programming, concurrent programming languages) 

### Sequential composition of actions that take time

* Operaciones “demorosas” que bloquean el hilo de ejecución

* Futuros: facilitan la ejecución de estas operaciones de forma asíncrona, y así no interrumpir el hilo de ejecución

### Sequential composition of actions that take time and can fail

* Isn't there a monad for that ?

* Composición funcional de acciones que toman tiempo y pueden fallar

### Qué son los futuros ?

* “Un Futuro es un Monad que puede manejar dos efectos: excepciones y latencia” (Erik Meijer https://en.wikipedia.org/wiki/Erik_Meijer_(computer_scientist))

* Permiten razonar sobre operaciones en paralelo

* Son objetos que contienen un valor que no necesariamente existe aún

* Utilizan callbacks en vez de operaciones que bloquean

* En Scala podemos usar combinadores funcionales y For-Comprehensions


### Ejemplos

1. Este ejemplo muestra una operación que bloquea el thread principal ya que "demora" en retornar un resultado.

2. Este ejemplo muestra como usar un futuro, utilizando callbacks, para evitar el bloqueo del ejemplo 1 y seguir ejecutando operaciones en el thread principal.

3. Este ejemplo muestra como manejar excepciones dentro de futuros utilizando callbacks.

4. Este ejemplo muestra como manejar un futuro que no lanza excepciones pero si maneja condiciones de error, utiliza callbacks.

5. Este ejemplo muestra como combinar 2 futuros utilizando el combiandor *map*

6. Este ejemplo muestra como delegar a otro futuro cuando un futuro falla. Se utiliza el combinador *fallbackTo*

7. Este ejemplo muestra como combinar 3 futuros utilizando for-comprehensions.

8. Este ejemplo muestra que ocurre cuando uno de los futuros combinados falla y como manejarlo mediante callbacks.

9. Este ejemplo es una variante de anterior, pero ahora se maneja la excepción utilizando el combinador *recoverWith*.
