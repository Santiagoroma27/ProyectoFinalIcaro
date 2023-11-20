# language: es

Funcionalidad: Comprar un producto

Contexto:
Dado que el usuario abre la página "https://opencart.abstracta.us/"

Escenario: Agregar un producto al carrito
Cuando el usuario hace clic en Cameras
Y el usuario hace clic en Canon EOS 5D
Y el usuario selecciona una opción y agrega el producto al carrito
Y el usuario hace clic en el carrito
Y el usuario hace clic en View Cart
Entonces se valida que el producto se encuentra en el carrito
