SET DEFINE OFF

INSERT INTO SYSTEM_USER (USER_ID, NAME, PASSWORD, EMAIL, TELEPHONE, STATE, CREATED_ON, CREATED_USER, MODIFIED_ON, MODIFIED_USER) 
VALUES (1.0, 'Administrador', 'SuperUsuario', 'admin@gmail.com', '2424-2150', 1.0, to_timestamp('30/08/2019 02:42', 'YYYY-MM-DD HH24:MI:SS'), 'MADX', to_timestamp('30/08/2019 02:42', 'YYYY-MM-DD HH24:MI:SS'), 'NULL');

INSERT INTO SYSTEM_USER (USER_ID, NAME, PASSWORD, EMAIL, TELEPHONE, STATE, CREATED_ON, CREATED_USER, MODIFIED_ON, MODIFIED_USER) 
VALUES (2.0, 'ACTUALIZAR', '1234567890', 'ACTUALIZAR@GMAIL.COM', '12345678', 1.0, to_timestamp('31/08/2019 02:19', 'YYYY-MM-DD HH24:MI:SS'), 'NULL', to_timestamp('31/08/2019 02:19', 'YYYY-MM-DD HH24:MI:SS'), 'NULL');

INSERT INTO SYSTEM_USER (USER_ID, NAME, PASSWORD, EMAIL, TELEPHONE, STATE, CREATED_ON, CREATED_USER, MODIFIED_ON, MODIFIED_USER) 
VALUES (3.0, 'Permiso 4942382', '123456789', 'PAKO@GMAIL.COM', '12345678', 1.0, to_timestamp('31/08/2019 02:22', 'YYYY-MM-DD HH24:MI:SS'), 'NULL', to_timestamp('31/08/2019 02:22', 'YYYY-MM-DD HH24:MI:SS'), 'NULL');

-- Importar Datos a la Tabla SYSTEM_USER del Archivo C:\Users\Ervin LG\UMG20192\DesarrolloWeb\Data_proyect\SystemUser.csv . Tarea correcta enviada a hoja de trabajo.