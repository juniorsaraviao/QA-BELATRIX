Feature:
  Obtener la lista de restaurantes segun descripcion usando Rest-Assured

  Scenario: Obtener la lista de restaurantes segun su descripcion
    Given Dado un usuario que desea desea obtener la lista de restaurantes con la misma descripcion para el recurso "/places"
    Then deberia listar los restaurantes con la descripcion "Japanesse Food"
