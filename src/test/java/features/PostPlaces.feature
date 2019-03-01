Feature: PostPlace
  Test POST places using REST-assured library

  Scenario: Verificar Post Operation para PLaces
    Given Un post operation para places for "/places/{placeNro}/profile" with body
     |place | name      | description  |
     |9     | Boulevard | Bar & Disco  |
    Then Deberia obtener el nombre "Boulevard"