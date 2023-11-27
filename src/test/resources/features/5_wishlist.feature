# language: es

Característica: Agregar producto a favoritos
    Escenario: Usuario agrega producto a favorito
    Dado que el usuario esta en home
        Entonces El usuario se loguea
    Entonces El usuario hace click en el boton Cameras
    Entonces El usuario elige el modelo de camara "Canon EOS 5D"
    Entonces El usuario agrega el producto a favoritos
    Entonces El usuario hace clic en Wish List
    Entonces Se valida que exista un producto en favoritos "Canon EOS 5D"

