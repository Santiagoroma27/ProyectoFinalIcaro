# language: es

Característica: Agregar producto a favoritos
    Escenario: Usuario agrega producto a favorito
    Dado que el usuario ingresa a la pagina de opencart
    Y el usuario ingresa al registro
    Cuando el usuario completa el formulario de registro con datos validos
    Y El usuario ingresa a la sección Cameras
    Y El usuario agrega un producto a favoritos "Canon EOS 5D"
    Y El usuario hace clic en Wish List
    Entonces Se valida que exista un producto en favoritos

