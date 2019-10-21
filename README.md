# LibraryVirtualUMG-Spring

REQUERIMIENTOS
- JAVA JDK 8
- ORACLE DATABASE EXPRESS EDITION 11.2.0.2
- VISUAL STUDIO CODE (VSCODE)
  - PLUGIN JAVA EXTENSION PACK
  - PLUGIN SPRING BOOT EXTENSION PACK
  - PLUGIN SPRING BOOT SUPPORT
  - PLUGIN REST CLIENT
  

AGREGAR DRIVER OJDBC7 A MAVEN
- ojdbc7.jar SE ENCUENTRA EN LA RAIZ DEL PROYECTO 
- MOVER EL JAR A LA SIGUIENTE RUTA <code> C:\JAR </code>
- ABRIR NUEVA TERMINAL EN VSCODE Y EJECUTAR EL COMANDO SIGUIENTE:

<code>
  mvn install:install-file -Dfile=C:\JAR\ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=11.2.0.2 -Dpackaging=jar
</code>


AGREGAR DRIVER OJDBC7 A PROYECTO SPRING
- IR AL ARCHIVO pom.xml DEL PROYECTO Y AGREGAR O DESCOMENTAR LA SIGUIENTE DEPENDENCIA (SIN COMILLAS Y SIN ESPACIOS)
<code>
        <p>< dependency ></p><br>
		< groupId >com.oracle</ groupId >
		< artifactId >ojdbc7< /artifactId >
		< version >11.2.0.2< /version >
	< / dependency >
 </code>
  
CONFIGURAR USUARIO DE CONEXION EN LA BASE DE DATOS
- EL USUARIO QUE SE DEBE DE UTILZAR QUEDA A SU CRITERIO, SOLO TENGA EN CUENTA LO SIGUIENTE:
  - DEBE DE PODER REALIZAR SELECT, INSERT, UPDATE Y DELETE
  - DEBE DE PODER CREAR TABLAS RELACIONALES
  - DEBE DE PODER CREAR INDICES Y SECUENCIAS

CONFIGURAR BASE DE DATOS EN PROYECTO SPRING 
- IR AL ARCHIVO <code> application.properties </code> UBICADO EN <code> src > main > resources </code>
- ASIGNAR USUARIO Y CONTRASENIA DE LA BASE DE DATOS EN <code> spring.datasource.username </code> Y <code> spring.datasource.password </code> RESPECTIVAMENTE
- ASIGNAR USUARIO Y CONTRASENIA DE LA BASE DE DATOS EN <code> oracle.username </code> Y <code> oracle.password </code> RESPECTIVAMENTE
- EL USUARIO Y CONTRASENIA DE LOS DOS PUNTOS ANTERIORES DEBEN DE COINCIDIR

OBSERVACION
- SI REALIZA UN INSERT DIRECTAMENTE EN LA BASE DE DATOS, DEBE DE INGRESAR EL ID YA QUE NO SE EJECUTARA LA SECUENCIA
- LAS SECUENCIAS SOLO SE EJECUTAN CUANDO SE UTILIZAN LOS METODOS CREAR DEL CRUD DE CADA UNA DE LAS ENTIDADES DEL API

EJECUCION DEL API
- TRAS LA PRIMERA EJECUCION DEL API EN VSCODE, MOSTRARA UN ERROR DE QUE NO SE HAN CREADO LAS SECUENCIAS, IGUALMENTE EL API CONTINUARA SU EJECUCION SIN MOSTRAR UN ERROR QUE NO LE PERMITA INICIAR.
- RECOMIENDO RECARGAR EL API NUEVAMENTE Y PODRA OBSERVAR QUE YA NO MUESTRA EL ERROR DE SECUENCIAS Y EL API ESTA LISTA PARA USARSE

METODOS Y ESTRUCTURAS PROBADAS
- IR A LA CARPETA API_STRUCTURE UBICADA EN LA RAIZ DEL PROYECTO
- ENCONTRARA UN ARCHIVO CON EXTENCION http EL CUAL CORRESPONDE A CADA UNA DE LAS ENTIDATES DEL API
- CADA ARCHIVO CONTINE UN EJEMPLO DE LOS METODOS CRUD DE CADA ENTIDAD
- PARA EJECUTARLOS DESDE VSCODE DEBE DE TENER INSTALADO EL PLUGIN <code> REST CLIENT </code> Y DAR CLICK SOBRE <code> Send Request </code> PARA EJECUTAR DICHO METODO
