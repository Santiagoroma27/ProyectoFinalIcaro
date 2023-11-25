# language: es

Característica: Agregar producto al carrito
  Escenario: Agregar un producto al carrito
    Dado que el usuario ingresa a la pagina
    Entonces el usuario se registra
    Y El usuario ingresa a la sección Cameras
    Y el usuario agrega un producto al carrito
    Y el usuario entra al carrito
    Entonces se valida que exista un producto en el carrito

