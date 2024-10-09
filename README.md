# PeriferiaITCRUD
Prueba técnica de Periferia IT

# API CRUD de Usuarios con authenticación JWT

## Autor

- Miguel Angel Fuquene Arias

## Contrucción 

- IntelliJ-Editor de código y ambiente de desarrollo(IDE)
- Maven-gestor de dependencias 
- SpringBoot- Framework creación de APIs
- Spring security- registro y autenticación con JWT
- H2- Base de datos en Memoria
- Postman- Herramienta para enviar solicitudes a servidores web y recibir las respuestas correspondientes.
  

## Requerimientos
- Java 17 o superior
- Tener un Ide como IntelliJ, Eclipse o STS
- Spring framework
- Maven 3.0 o superior
- Tener instalado Postman para envio de peticiones


## Pasos para ejecucion

- En su directorio de preferencia ejecute el comando git clone https://github.com/MiguelFuquene1024/PeriferiaITCRUD.git
- Acceda a su IDE por ejemplo IntelliJ, busque la ruta donde clono el repositorio y abra el proyecto.
- Abra la terminal y ejecute los siguientes comandos
    . mvn clean 
    . mvn compile
- Luego corra la aplicación.
- Lo primero que tiene que hacer es registrar un nuevo usuario, este nos servira para posteriormente hacer la autenticación y poder usar los servicios del API. Para lograr esto abra postman, cree una nueva petición http de tipo POST y pegue la siguiente url (http://localhost:8080/auth/register), luego en el body ingrese un objeto JSON como se muestra en la siguiente imagen.


Puede alterar el nombre, email y el password como usted lo prefiera, la imagen es solo como referencia.

-  Luego de esto envie la peticion, la aplicacion le deberia arrojar una respuesta 200 y un JSON de respuesta con un token, este no lo necesitaremos por ahora, pero si nos hara saber que quedo registrado el nuevo usuario.
-  Luego de esto nos logearemos ahora si, para esto cree otra peticion POST e introduzca la siguiente URL (http://localhost:8080/auth/login) y en el body envie un JSON parecido al que envio en la peticion anterior solo que sin el nombre, unicamente indique email y password. IMPORTANTE: Tenga en cuenta que debe poner el mismo email y contraseña que uso cuando registro el usuario, de no ser asi la aplicacion no le arrojara ningun token.
Cuando envie la petición el servicio le debe responder con un token como se muestra en la siguiente imagen.
- Guarde este token o copielo en el bloc de notas, pues con este token nos autenticaremos para ahora si poder acceder a los servicos CRUD de la API.
- Cree una nueva petición de tipo POST, pegue la siguiente url (http://localhost:8080/v1/api/user) y en el body haga un JSON nuevamente con nombre, email y password. Adicionalmente vaya al apartado de authorization en el postman, en Auth Type seleccione la que dice Bearer Token y en el cuadro de texto pegue el token que copio anteriormente en el bloc de notas. Con este token lo que estará haciendo es authenticarse para acceder a los servicios, esta petición nos servirá para guardar un usuario en la base de datos.
- Debe obtener una respuesta como la que se muestra en la siguiente imagen:
  
- De no ser asi sera porque pego mal el token o en su defecto al momento de hacer el login puso mal el email o la contraseña con la que se regitro al inicio.
- Acceda desde su navegador a la siguiente dirección http://localhost:8080/h2-db
- Debera ver una pagina como la que se muestra a continuación, debe poner los mismos valores que se muestran en la imagen. Desde aqui es donde accederemos a la Base de datos en memoria de springboot(H2) para poder ver los datos que tenemos en esta.
  
- Al darle en conectar deber ver la siguiente imagen, de doble clic en la tabla users y en el cuadro de texto le debera aparecer este texto "SELECT * FROM users", deberá precionar run y luego vera en pantalla todos los usarios que tiene la base de datos.
- Tenga en cuenta que cada vez que corra la aplicación esta db se volvera a borrar, por lo cual tendrá que repetir el proceso de registro y authenticación.
- La aplicación tiene las opciones de Actualiza, Traer uno o todos los usuarios y eliminar usuario ademas de la de creación que ya vimos. Abajo les dejaré cada una de las url para probar esas acciones.
  -  Para actualizar:
      -   Peticion: PUT
      -   url: http://localhost:8080/v1/api/user/ seguido del id del usuario que quiere actulizar en la db por ejemplo (http://localhost:8080/v1/api/user/1)
      -   body: objeto JSON con el nombre,email y password que desea actualizar.
  -  Para eliminar:
      -  Petición: DELETE
      -  url: url: http://localhost:8080/v1/api/user/ seguido del id del usuario que quiere borrar de la db por ejemplo (http://localhost:8080/v1/api/user/1).
      -  Body: No lleva.
  -  Para obtener los usuarios:
      -  Petición: GET
      -  url: http://localhost:8080/v1/api/user
      -  body: no lleva
  -  Para obtener un solo usuario:
      -  Petición: GET
      -  url: http://localhost:8080/v1/api/user/ seguido del id del usuario que quiere obtener po ejemplo (http://localhost:8080/v1/api/user/1)
      -  body: No lleva

![](https://github.com/MiguelFuquene1024/NTTDataCustomerApi/blob/master/example/Prueba%20customerApi.png)

