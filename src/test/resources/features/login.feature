# language: es

Característica: login

Escenario: Login exitoso
  #  Dado que el usuario ingresa al login
  Dado Que el usuario ingresa a la pagina de opencart
  Y el usuario ingresa al login
  Cuando el usuario ingresa credenciales validos
  Entonces se valida que el usuario se encuentra en su cuenta



