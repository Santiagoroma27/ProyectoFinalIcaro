# language: es

Característica: Agregar producto a favoritos

    Escenario: Usuario agrega producto a favoritos
    Dado Que el usuario ingresa a la pagina de opencart
    Cuando El usuario hace clic en My Account
    Y El usuario hace clic en Login
    Y El usuario realiza el login
    Y El usuario ingresa a la sección Cameras
    Y El usuario agrega un producto a favoritos "Canon EOS 5D"
    Y El usuario hace clic en Wish List
    Entonces Se valida que exista un producto en favoritos
    Y Se valida que el producto en la grilla sea "Canon EOS 5D"
