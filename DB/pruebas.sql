select * from persona;
select * from credencial;
call sp_VerMiCuenta('emo','12345');
call sp_ConsultaUsuario();
call sp_ConsultaAdmin('admin@admin.com')
call sp_AltaAdmin('Erick Hazel','Ramirez','Morales','erick@gmail.com','emo','12345');