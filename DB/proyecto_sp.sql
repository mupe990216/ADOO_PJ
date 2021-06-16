##---------------------------------- LOGIN ----------------------------------
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

##---------------------------------- Visualizar Mi Cuenta ----------------------------------
drop procedure if exists sp_VerMiCuenta;
delimiter **
create procedure sp_VerMiCuenta(in usur varchar(64), in pswd varchar(64))
begin
declare existe int;
declare msj varchar(64);
set existe = (select count(*) from credencial where credencial.Usuario = usur);
	if existe = 0 then
		set msj = 'No existe el usuario';
        select msj as Respuesta;
            else
				select persona.ApePaterno as "Apellido Paterno", persona.ApeMaterno as "Apellido Materno", 
                persona.Nombre as "Nombre(s)", persona.Email, persona.Usuario as "Nombre de usuario", credencial.contrasenia as "Contraseña"
                from persona inner join credencial on persona.Usuario=credencial.Usuario and persona.Usuario=usur;
	end if;			
end **
delimiter ;

##---------------------------------- Alta de Administrador ----------------------------------
drop procedure if exists sp_AltaAdmin;
delimiter **
create procedure sp_AltaAdmin(in nom varchar(64), in ap1 varchar(64), in ap2 varchar(64), in correo varchar(64),
							   in usur varchar(64), in pswd varchar(64))
begin
declare existe int;
declare msj varchar(64);

set existe = (select count(*) from Persona where persona.Email=correo);
	if existe = 1 then
		set msj = 'Correo Existente';
    else
		set existe = (select count(*) from persona where persona.Nombre=nom and persona.ApePaterno=ap1 and persona.ApeMaterno=ap2);
		if existe = 1 then 
			set msj = 'Persona Existente';
        else
			set existe = (select count(*) from credencial where credencial.Usuario=usur);
            if existe = 1 then
				set msj = 'Nombre de usuario Existente';
            else
				insert into credencial values(usur,pswd); -- Primero Insertamos en Credenciales
				insert into Persona values(correo,nom,ap1,ap2,usur,1); -- Damos de alta al administrador, el uno es del tipo de usuario "admin"
				set msj = 'Administrador Registrado Exitosamente';
            end if;			
        end if;
    end if;
    select msj as Respuesta;
end **
delimiter ;
call sp_AltaAdmin('nombre','apellidoP','apellidoM','correo','nusr','psw');

##---------------------------------- Baja de Administrador ----------------------------------
drop procedure if exists sp_BajaAdmin;
delimiter **
create procedure sp_BajaAdmin(in correo varchar(64),in usur varchar(64))
begin
declare existe int;
declare msj varchar(64);

set existe = (select count(*) from persona where persona.Email=correo and persona.idTipoUsuario=1);
	if existe = 0 then
		set msj = 'El Correo NO Existe';
    else
		set existe = (select count(*) from credencial where credencial.usuario=usur);
        if existe = 0 then
			set msj = 'El usuario NO existe';
        else
			set existe = (select count(*) from persona where persona.Email=correo and persona.Usuario=usur);
            if existe = 0 then
				set msj = 'Combinacion Invalida';
			else
				delete from persona where persona.Email=correo and persona.idTipoUsuario=1;
				delete from credencial where credencial.usuario=usur;
				set msj = 'Administrador Eliminado';
            end if;			
        end if;
	end if;
    select msj as Respuesta;
end **
delimiter ;

##---------------------------------- Consulta Administradores ---------------------------------- 
drop procedure if exists sp_ConsultaAdmin;
delimiter **
create procedure sp_ConsultaAdmin(in correo varchar(64))
begin
declare existe int;
declare msj varchar(64);

set existe = (select count(*) from persona where idTipoUsuario=1);
	if existe < 2 then 
		set msj = 'No existen Administradores Registrados';
        select msj as Respuesta;
    else
		select Email,Nombre, ApePaterno as "Apellido_Uno", ApeMaterno as "Apellido_Dos", Usuario
			from persona where (idTipoUsuario=1 and Email != correo); -- Obtenemos a todos los Administradores, menos con el que estamos logeados, por eso el operador != diferente a
    end if;
end **
delimiter ;
call sp_ConsultaAdmin('dsadsa');

##---------------------------------- Cambio Administrador ---------------------------------- 
drop procedure if exists sp_CambioAdmin;
delimiter **
create procedure sp_CambioAdmin(in correo varchar(64), in nom varchar(64), in ap1 varchar(64), in ap2 varchar(64),
							  in usur varchar(64), in pswd varchar(64))
begin
declare existe int;
declare msj varchar(64);
set existe = (select count(*) from persona where persona.Email=correo);
	if existe = 0 then
		set msj = 'El Correo NO Existe';
    else
		set existe = (select count(*) from credencial where credencial.Usuario=usur);
		if existe = 0 then
			set msj = 'El nombre usuario NO existe';
        else
			set existe = (select count(*) from persona where persona.Email=correo and persona.Usuario=usur);
			if existe = 0 then
				set msj = 'Combinacion Invalida';
				update persona set Nombre=nom, ApePaterno=ap1, ApeMaterno=ap2
						where (persona.Email=correo and persona.Usuario=usur);
				update credencial set Contrasenia=pswd where Usuario=usur;
				set msj = 'Administrador Modificado';
			end if;
        end if;		
    end if;
	select msj as Respuesta;
end **
delimiter ;

##---------------------------------- Alta de Usuario ----------------------------------
drop procedure if exists sp_AltaUsuario;
delimiter **
create procedure sp_AltaUsuario(in correo varchar(64), in nom varchar(64), in ap1 varchar(64), in ap2 varchar(64),
							  in usur varchar(64), in pswd varchar(64))
begin
declare existe int;
declare msj varchar(64);

set existe = (select count(*) from persona where persona.Email=correo);
	if existe = 1 then
		set msj = 'Correo Existente';
    else
		set existe = (select count(*) from persona where persona.Nombre=nom and persona.ApePaterno=ap1 and persona.ApePaterno=ap2);
		if existe = 1 then 
			set msj = 'Persona Existente';
        else
			set existe = (select count(*) from credencial where credencial.Usuario=usur);
            if existe = 1 then
				set msj = 'Nombre de usuario Existente';
            else
				insert into credencial values(usur,pswd); -- Primero Insertamos en Credenciales
				insert into persona values(correo,nom,ap1,ap2,usur,2); -- Damos de alta al usuario
				set msj = 'Usuario Registrado Exitosamente';
            end if;			
        end if;
    end if;
    select msj as Respuesta;
end **
delimiter ;


##---------------------------------- Baja de Usuario ----------------------------------
drop procedure if exists sp_BajaUsuario;
delimiter **
create procedure sp_BajaUsuario(in correo varchar(64),in usur varchar(64))
begin
declare existe int;
declare msj varchar(64);

set existe = (select count(*) from persona where persona.Email=correo and persona.idTipoUsuario=2);
	if existe = 0 then
		set msj = 'El Correo NO Existe';
    else
		set existe = (select count(*) from credencial where credencial.Usuario=usur);
        if existe = 0 then
			set msj = 'El usuario NO existe';
        else
			set existe = (select count(*) from persona where persona.Email=correo and persona.Usuario=usur);
            if existe = 0 then
				set msj = 'Combinacion Invalida';
			else
				delete from persona where persona.Email=correo and persona.idTipoUsuario=2;
				delete from Credenciales where Credenciales.usr=usur;
				set msj = 'Usuario Eliminado';
            end if;			
        end if;
	end if;
    select msj as Respuesta;
end **
delimiter ;

##---------------------------------- Consulta Usuario ----------------------------------
drop procedure if exists sp_ConsultaUsuario;
delimiter **
create procedure sp_ConsultaUsuario()
begin
declare existe int;
declare msj varchar(64);

set existe = (select count(*) from persona where idTipoUsuario=2);
	if existe = 0 then 
		set msj = 'No existen Usuarios Registrados';
        select msj as Respuesta;
    else
		select Email, Nombre,ApePaterno as "Apellido_Uno",ApeMaterno as "Apellido_Dos", Usuario
			from Persona where (idTipoPersona=2); -- Obtenemos a todos los Administradores, menos con el que estamos logeados, por eso el operador != diferente a
    end if;
end **
delimiter ;

##---------------------------------- Cambio Usuario ----------------------------------
drop procedure if exists sp_CambioUsuario;
delimiter **
create procedure sp_CambioUsuario(in correo varchar(64), in nom varchar(64), in ap1 varchar(64), in ap2 varchar(64),
							  in usur varchar(64), in pswd varchar(64))
begin
declare existe int;
declare msj varchar(64);
set existe = (select count(*) from perona where persona.Email=correo);
	if existe = 0 then
		set msj = 'El Correo NO Existe';
    else
		set existe = (select count(*) from credencial where credencial.Usuario=usur);
		if existe = 0 then
			set msj = 'El usuario NO existe';
        else
			set existe = (select count(*) from persona where persona.Email=correo and persona.Usuario=usur);
			if existe = 0 then
				set msj = 'Combinacion Invalida';
			else
				update persona set Nombre=nom, ApePaterno=ap1, ApeMaterno=ap2
						where (persona.Email=correo and persona.Usuario=usur);
				update credencial set Contrasenia=pswd where Usuario=usur;
				set msj = 'Usuario Modificado';
			end if;
        end if;		
    end if;
	select msj as Respuesta;
end **
delimiter ;
select *from Persona;
use Prueba;
