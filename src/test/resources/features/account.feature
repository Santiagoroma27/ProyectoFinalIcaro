# language: es

Característica: Página de Cuenta
  Escenario: Validar la página de cuenta
    Dado que el usuario ingresa a la página de opencart
    Y el usuario ingresa al login
    Cuando el usuario ingresa credenciales válidos
    Y se valida que el usuario se encuentra en su cuenta
    Entonces se valida la información en la página de cuenta
