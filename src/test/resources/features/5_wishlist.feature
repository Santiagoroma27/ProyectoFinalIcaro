# language: es

Característica: Agregar producto a favoritos
    Escenario: Usuario agrega producto a favorito
    Dado que el usuario esta en home
    Entonces El usuario agrega un producto a favoritos "Canon EOS 5D"
    Y El usuario hace clic en Wish List
    Entonces Se valida que exista un producto en favoritos

