drop procedure if exists sp_Login;
delimiter **
create procedure sp_Login(in usr varchar(64), in psw varchar(64))
begin
declare existe int;
declare msj varchar(64);
#declare tipoUSR int;
declare tipoUSR varchar(64);
set existe = (select count(*) from Credencial where Credencial.Usuario = usr);
	if existe = 0 then
		set msj = 'No existe el usuario';
        set tipoUSR = 'null';
	else
		set existe = (select count(*) from Credencial where Credencial.Usuario = usr and Credencial.Contrasenia = psw);
        if existe = 0 then
			set msj = 'Contraseña Invalida';
            set tipoUSR = 'null';
        else
			set msj = 'Acceso Concedido';
            set tipoUSR = (select Descripcion from TipoUsuario where TipoUsuario.idTipoUsuario = (select idTipoUsuario from Persona where Persona.Usuario = usr));
        end if;		
	end if;
	select msj as Respuesta, tipoUSR;
end **
delimiter ;


-- Seccion de prueba para ir checando la BD --
insert into Credencial values('usr01','123');
insert into Persona values('admin@admin.com','Admin','No se we','Que te importa','usr01',1);

insert into Credencial values('usr02','123');
insert into Persona values('client@client.com','Client','No se we','Que te importa','usr02',2);

call sp_Login('usr01','123');


#select idTipoUsuario from Persona where Persona.Usuario = 'usr01';
