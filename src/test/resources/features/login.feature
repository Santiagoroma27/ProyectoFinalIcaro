# language: es

Característica: Login exitoso
  Escenario: Login exitoso
    Dado que el usuario ingresa a la pagina de opencart
    Entonces se valida que el usuario se encuentra en la home
    Y el usuario ingresa al login
    Cuando el usuario ingresa credenciales validas
    Entonces se valida que el usuario se encuentra en su cuenta