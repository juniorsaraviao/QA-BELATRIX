Feature:
    Verificar diferentes tipos de operaciones GET usando Rest-Assured

    Scenario: Verificar el nombre de un author POSTS
      Given Un usuario desea realizar una operacion GET para el recurso "/posts"
      When realiza una operacion GET para el ID "2" y el Nombre "Belatrix"
      Then deberia ver el nombre del autor como "Belatrix"

    Scenario: Verificar los nombres de los Autores POSTS
      Given Un usuario desea realizar una operacion GET para el recurso "/posts"
      Then Deberia ver el nombre de los Autores "Juan Bryan Estrada Acosta", "Belatrix", "null"

    Scenario: Verificar la respuesta de la operacion GET con Parametros
      Given Un usuario desea realizar una operacion GET para el recurso "/posts"
      Then deberia poder ver y comprobar el parametro para la operacion "1"

     Scenario: Verificar la respuesta de la Operacion Get Con Parametros Query
       Given Un usuario desea realizar una operacion GET para el recurso "/posts"
       Then deberia poder ver y comprobar el parametro Query para la operacion "2"

     Scenario: Verificar la respuesta de la Operacion Post con Body y Parametros
       Given Un usuario desea realizar una operacion POST
       Then deberia poder insertar y compropar que los datos esten ingresados
