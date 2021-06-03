use web;
##---------------------------------- Validar Login y Acceso ----------------------------------
drop procedure if exists sp_Login;
delimiter **
create procedure sp_Login(in usur nvarchar(64), in pswd nvarchar(64))
begin
declare existe int;
declare msj nvarchar(32);
declare tipoUSR int;

set existe = (select count(*) from Credenciales where Credenciales.usr=usur); -- Validamos que El usuario Exista
	if existe = 0 then
		set msj = 'Usuario Invalido';
	else 
		set existe = (select count(*) from Credenciales where Credenciales.psw=pswd); -- Validamos que la Contraseña concuerde con el usuario
		if existe = 0 then 
			set msj = 'Contraseña Invalida';
		else
			set existe = (select count(*) from Credenciales where Credenciales.usr=usur and Credenciales.psw=pswd);
            if existe = 0 then 
				set msj = 'Combinacion Invalida';
            else
				set msj = (select TipoPersona.Descripcion from TipoPersona, Persona 
					where Persona.idTipoPersona=TipoPersona.idTipoPersona and Persona.usr=usur); -- Devolvemos el tipo de usuario
            end if;
			
        end if;
	end if;
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Alta de Administrador ----------------------------------
drop procedure if exists sp_AltaAdmin;
delimiter **
create procedure sp_AltaAdmin(in correo nvarchar(128), in nom nvarchar(32), in ape1 nvarchar(32), in ape2 nvarchar(32),
							  in idgener int(2), in edad int(2), in usur nvarchar(64), in pswd nvarchar(64))
begin
declare existe int;
declare msj nvarchar(32);
declare idage int(2);

set existe = (select count(*) from Persona where Persona.email=correo);
	if existe = 1 then
		set msj = 'Correo Existente';
    else
		set existe = (select count(*) from Persona where Persona.nombre=nom and Persona.apellido1=ape1 and Persona.apellido2=ape2);
		if existe = 1 then 
			set msj = 'Persona Existente';
        else
			set existe = (select count(*) from Credenciales where Credenciales.usr=usur);
            if existe = 1 then
				set msj = 'Usuario Existente';
            else
				insert into Credenciales values(usur,pswd); -- Primero Insertamos en Credenciales
				set existe = (select count(*) from Edad where Edad.Descripcion=edad); -- Verificamos si la edad a registrar existe en el catalogo
				if existe = 1 then
					set idage = (select idEdad from Edad where Edad.Descripcion=edad); -- Si existe traemos el id correspondiente
				else
					set idage = (select ifnull(max(idEdad),0) + 1 from Edad); -- Calculamos el "idedad" del catalogo
					insert into Edad values(idage,edad); -- Si no existe la insertamos
				end if;
				insert into Persona values(correo,nom,ape1,ape2,1,idgener,idage,usur,1); -- Damos de alta al administrador, el primer uno es del emial a veriricar y el segundo uno es del tipo de usuario "admin"
				set msj = 'Administrador Registrado';
            end if;			
        end if;
    end if;
    select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Baja de Administrador ----------------------------------
drop procedure if exists sp_BajaAdmin;
delimiter **
create procedure sp_BajaAdmin(in correo nvarchar(128),in usur nvarchar(64))
begin
declare existe int;
declare msj nvarchar(32);

set existe = (select count(*) from Persona where Persona.email=correo and Persona.idTipoPersona=1);
	if existe = 0 then
		set msj = 'El Correo NO Existe';
    else
		set existe = (select count(*) from Credenciales where Credenciales.usr=usur);
        if existe = 0 then
			set msj = 'El usuario NO existe';
        else
			set existe = (select count(*) from Persona where Persona.email=correo and Persona.usr=usur);
            if existe = 0 then
				set msj = 'Combinacion Invalida';
			else
				delete from Persona where Persona.email=correo and Persona.idTipoPersona=1;
				delete from Credenciales where Credenciales.usr=usur;
				set msj = 'Administrador Eliminado';
            end if;			
        end if;
	end if;
    select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta Administradores ---------------------------------- Dentro del menu de administrador para consultar otros admins
drop procedure if exists sp_ConsultaAdmin;
delimiter **
create procedure sp_ConsultaAdmin(in correo nvarchar(128))
begin
declare existe int;
declare msj nvarchar(64);

set existe = (select count(*) from Persona where idTipoPersona=1);
	if existe < 2 then 
		set msj = 'No existen Administradores Registrados';
        select msj as Respuesta;
    else
		select email as Email, nombre as Nombre, apellido1 as "Apellido_Uno", apellido2 as "Apellido_Dos", usr as Usuario
			from Persona where (idTipoPersona=1 and email != correo); -- Obtenemos a todos los Administradores, menos con el que estamos logeados, por eso el operador != diferente a
    end if;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Cambio Administrador ---------------------------------- Con la cuenta que estemos Logeados poder cambiar datos
drop procedure if exists sp_CambioAdmin;
delimiter **
create procedure sp_CambioAdmin(in correo nvarchar(128), in nom nvarchar(32), in ape1 nvarchar(32), in ape2 nvarchar(32),
							  in idgener int(2), in edad int(2), in usur nvarchar(64), in pswd nvarchar(64))
begin
declare existe int;
declare msj nvarchar(32);
declare idage int(2);
set existe = (select count(*) from Persona where Persona.email=correo);
	if existe = 0 then
		set msj = 'El Correo NO Existe';
    else
		set existe = (select count(*) from Credenciales where Credenciales.usr=usur);
		if existe = 0 then
			set msj = 'El usuario NO existe';
        else
			set existe = (select count(*) from Persona where Persona.email=correo and Persona.usr=usur);
			if existe = 0 then
				set msj = 'Combinacion Invalida';
			else
				set existe = (select count(*) from Edad where Edad.Descripcion=edad); -- Verificamos si la edad a registrar existe en el catalogo
				if existe = 1 then
					set idage = (select idEdad from Edad where Edad.Descripcion=edad); -- Si existe traemos el id correspondiente
				else
					set idage = (select ifnull(max(idEdad),0) + 1 from Edad); -- Calculamos el "idedad" del catalogo
					insert into Edad values(idage,edad); -- Si no existe la insertamos
				end if;
				update Persona set nombre=nom, apellido1=ape1, apellido2=ape2, idGenero=idgener, idEdad=idage
						where (Persona.email=correo and Persona.usr=usur);
				update Credenciales set psw=pswd where usr=usur;
				set msj = 'Administrador Modificado';
			end if;
        end if;		
    end if;
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Alta de las Categorias ----------------------------------
drop procedure if exists sp_AltaCategoria;
delimiter **
create procedure sp_AltaCategoria(in Descri nvarchar(32))
begin
declare existe int;
declare msj nvarchar(32);
declare idcatego int(2);

set existe = (select count(*) from CategoriaPostal where Descripcion=Descri);
	if existe = 1 then
		set msj = 'Categoria Existente';
    else
		set idcatego = (select ifnull(max(idCategoria),0) + 1 from CategoriaPostal);
        insert into CategoriaPostal values(idcatego,Descri);
        set msj = 'Categoria Registrada';
    end if;
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Baja de las Categorias ----------------------------------
drop procedure if exists sp_BajaCategoria;
delimiter **
create procedure sp_BajaCategoria(in idcatego int(2))
begin
declare existe int;
declare msj nvarchar(32);
set existe = (select count(*) from CategoriaPostal where idCategoria=idcatego);
	if existe = 0 then
		set msj = 'Categoria Inexistente';
    else
		delete from CategoriaPostal where idCategoria=idcatego;
        set msj = 'Categoria Eliminada';
    end if;
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta de Categorias ----------------------------------
drop procedure if exists sp_ConsultaCategoria;
delimiter **
create procedure sp_ConsultaCategoria()
begin
declare existe int;
declare msj nvarchar(32);
set existe = (select count(*) from CategoriaPostal);
	if existe = 0 then
		set msj = 'NO existen categorias';
        select msj as Respuesta;
    else
		select * from CategoriaPostal;
    end if;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Cambio de Categorias ----------------------------------
drop procedure if exists sp_CambioCategoria;
delimiter **
create procedure sp_CambioCategoria(in idcatego int(2),in Descri nvarchar(32))
begin
declare existe int;
declare msj nvarchar(32);
set existe = (select count(*) from CategoriaPostal where idCategoria=idcatego);
	if existe = 0 then
		set msj = 'Categorias Inexistente';
    else
		update CategoriaPostal set Descripcion=Descri where (idCategoria=idcatego);
        set msj = 'Categorias Modificada';
    end if;
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Alta de las Postales ----------------------------------
drop procedure if exists sp_AltaPostal;
delimiter **
create procedure sp_AltaPostal(in descrip nvarchar(32) ,in url nvarchar(512), in idCatego int(2))
begin
declare existe int;
declare msj nvarchar(64);
declare idPost int(128);
declare idRegis int(64);
set existe = (select count(*) from Postal where urlImagen=url);
	if existe = 1 then
		set msj = 'Postal Existente';
        set existe = (select count(*) from CategoriaPostal where idCategoria=idCatego);
        if existe = 0 then
			set msj = 'Categoria Inexistente';
        else
			set idPost = (select idPostal from Postal where urlImagen=url);
			set existe = (select count(*) from PostalCategoria where idPostal=idPost and idCategoria=idCatego);
			if existe = 1 then
				set msj = 'La Postal ya ha sido registrada en esta Categoria';
			else
				set idRegis = (select ifnull(max(idRegistro),0) + 1 from PostalCategoria);
				insert into PostalCategoria values(idRegis,idPost,idCatego);
				set msj = 'Postal Existente Registrada en otra Categoria';
			end if;
        end if;        
    else
		set existe = (select count(*) from CategoriaPostal where idCategoria=idCatego); -- La postal no se ha registrado y procedemos a validar la categoria
        if existe = 0 then
			set msj = 'Categoria Inexistente';
        else
			set idPost = (select ifnull(max(idPostal),0) + 1 from Postal);
			set idRegis = (select ifnull(max(idRegistro),0) + 1 from PostalCategoria);
			insert into Postal values(idPost,descrip,url);
			insert into PostalCategoria values(idRegis,idPost,idCatego);
			set msj = 'Postal Registrada';
        end if;        
    end if;
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Baja de las Postales ---------------------------------- Se elimina la postal de acuerdo a su id
drop procedure if exists sp_BajaPostal;
delimiter **
create procedure sp_BajaPostal(in idPost int(128))
begin
declare existe int;
declare msj nvarchar(32);
set existe = (select count(*) from Postal where idPostal=idPost);
	if existe = 0 then
		set msj = 'Postal Inexistente';
    else
		delete from Postal where idPostal=idPost;
        set msj = 'Postal Eliminada';
    end if;
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta de Postales ---------------------------------- Se realiza la consulta por categoria - Esto generará los menus que su vez traera toda la info de las postales para eliminar o modificar
drop procedure if exists sp_ConsultaPostal;
delimiter **
create procedure sp_ConsultaPostal(in idCatego int(2))
begin
declare existe int;
declare msj nvarchar(64);
set existe = (select count(*) from CategoriaPostal where idCategoria=idCatego);
	if existe = 0 then
		set msj = 'Categoria Inexistente';
        select msj as Respuesta;
    else
		set existe = (select count(*) from PostalCategoria where idCategoria=idCatego);
        if existe = 0 then
			set msj = 'NO existen postales en esta Categoria';
            select msj as Respuesta;
        else
			select p.* from Postal p, PostalCategoria pc where (p.idPostal=pc.idPostal and pc.idCategoria=idCatego);
        end if;
    end if;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Cambio de Postales ---------------------------------- Se cambia la postal de acuerdo a su id
drop procedure if exists sp_CambioPostal;
delimiter **
create procedure sp_CambioPostal(in idPost int(128),in descrip nvarchar(32), in url nvarchar(512))
begin
declare existe int;
declare msj nvarchar(32);
set existe = (select count(*) from Postal where idPostal=idPost);
	if existe = 0 then
		set msj = 'Postal Inexistente';
    else
		update Postal set Descripcion=descrip, urlImagen=url where idPostal=idPost;
        set msj = 'Postal modificada';
    end if;
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta CategoriasEstadistica ----------------------------------
drop procedure if exists sp_ConsultaCategoriasEstadisticas;
delimiter **
create procedure sp_ConsultaCategoriasEstadisticas()
begin
declare existe int;
declare msj nvarchar(64);
set existe = (select count(*) from CategoriasEstadistica);
	if existe = 0 then
		set msj = 'NO existe registro alguno';
        select msj as Respuesta;
    else
		select cp.Descripcion as Nombre, ce.Contador as Numero from CategoriaPostal cp, CategoriasEstadistica ce
			where cp.idCategoria=ce.idCategoria order by ce.Contador desc,cp.Descripcion;
    end if;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta PostalesEstadistica ----------------------------------
drop procedure if exists sp_ConsultaPostalesEstadisticas;
delimiter **
create procedure sp_ConsultaPostalesEstadisticas()
begin
declare existe int;
declare msj nvarchar(64);
set existe = (select count(*) from PostalesEstadistica);
	if existe = 0 then
		set msj = 'NO existe registro alguno';
        select msj as Respuesta;
    else
		select p.Descripcion as Nombre, pe.Contador as Numero from Postal p, PostalesEstadistica pe
			where p.idPostal=pe.idPostal order by pe.Contador desc,p.Descripcion;
    end if;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta GeneroEstadistica ----------------------------------
drop procedure if exists sp_ConsultaGeneroEstadisticas;
delimiter **
create procedure sp_ConsultaGeneroEstadisticas()
begin
declare existe int;
declare msj nvarchar(32);
set existe = (select count(*) from GeneroEstadistica);
	if existe = 0 then
		set msj = 'NO existe registro alguno';
        select msj as Respuesta;
    else
		select g.Descripcion as Nombre, ge.Contador as Numero  from Genero g, GeneroEstadistica ge
			where g.idGenero=ge.idGenero order by ge.Contador desc,g.Descripcion;
    end if;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta EdadEstadistica ----------------------------------
drop procedure if exists sp_ConsultaEdadEstadisticas;
delimiter **
create procedure sp_ConsultaEdadEstadisticas()
begin
declare existe int;
declare msj nvarchar(32);
set existe = (select count(*) from EdadEstadistica);
	if existe = 0 then
		set msj = 'NO existe registro alguno';
        select msj as Respuesta;
    else
		select e.Descripcion as Nombre, ee.Contador as Numero from Edad e, EdadEstadistica ee
			where e.idEdad = ee.idEdad order by ee.Contador desc,e.Descripcion;
    end if;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Alta de Usuario ----------------------------------
drop procedure if exists sp_AltaUsuario;
delimiter **
create procedure sp_AltaUsuario(in correo nvarchar(128), in nom nvarchar(32), in ape1 nvarchar(32), in ape2 nvarchar(32),
							  in idgener int(2), in edad int(2), in usur nvarchar(64), in pswd nvarchar(64))
begin
declare existe int;
declare msj nvarchar(32);
declare idage int(2);

set existe = (select count(*) from Persona where Persona.email=correo);
	if existe = 1 then
		set msj = 'Correo Existente';
    else
		set existe = (select count(*) from Persona where Persona.nombre=nom and Persona.apellido1=ape1 and Persona.apellido2=ape2);
		if existe = 1 then 
			set msj = 'Persona Existente';
        else
			set existe = (select count(*) from Credenciales where Credenciales.usr=usur);
            if existe = 1 then
				set msj = 'Usuario Existente';
            else
				insert into Credenciales values(usur,pswd); -- Primero Insertamos en Credenciales
				set existe = (select count(*) from Edad where Edad.Descripcion=edad); -- Verificamos si la edad a registrar existe en el catalogo
				if existe = 1 then
					set idage = (select idEdad from Edad where Edad.Descripcion=edad); -- Si existe traemos el id correspondiente
				else
					set idage = (select ifnull(max(idEdad),0) + 1 from Edad); -- Calculamos el "idedad" del catalogo
					insert into Edad values(idage,edad); -- Si no existe la insertamos
				end if;
				insert into Persona values(correo,nom,ape1,ape2,1,idgener,idage,usur,2); -- Damos de alta al administrador, el primer uno es del emial a veriricar y el segundo uno es del tipo de usuario "usuario publico"
				set msj = 'Administrador Registrado';
            end if;			
        end if;
    end if;
    select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Baja de Usuario ----------------------------------
drop procedure if exists sp_BajaUsuario;
delimiter **
create procedure sp_BajaUsuario(in correo nvarchar(128),in usur nvarchar(64))
begin
declare existe int;
declare msj nvarchar(32);

set existe = (select count(*) from Persona where Persona.email=correo and Persona.idTipoPersona=2);
	if existe = 0 then
		set msj = 'El Correo NO Existe';
    else
		set existe = (select count(*) from Credenciales where Credenciales.usr=usur);
        if existe = 0 then
			set msj = 'El usuario NO existe';
        else
			set existe = (select count(*) from Persona where Persona.email=correo and Persona.usr=usur);
            if existe = 0 then
				set msj = 'Combinacion Invalida';
			else
				delete from Persona where Persona.email=correo and Persona.idTipoPersona=2;
				delete from Credenciales where Credenciales.usr=usur;
				set msj = 'Usuario Eliminado';
            end if;			
        end if;
	end if;
    select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta Usuario ----------------------------------
drop procedure if exists sp_ConsultaUsuario;
delimiter **
create procedure sp_ConsultaUsuario()
begin
declare existe int;
declare msj nvarchar(64);

set existe = (select count(*) from Persona where idTipoPersona=2);
	if existe = 0 then 
		set msj = 'No existen Usuarios Registrados';
        select msj as Respuesta;
    else
		select email as Email, nombre as Nombre, apellido1 as "Apellido_Uno", apellido2 as "Apellido_Dos", usr as Usuario
			from Persona where (idTipoPersona=2); -- Obtenemos a todos los Administradores, menos con el que estamos logeados, por eso el operador != diferente a
    end if;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Cambio Usuario ----------------------------------
drop procedure if exists sp_CambioUsuario;
delimiter **
create procedure sp_CambioUsuario(in correo nvarchar(128), in nom nvarchar(32), in ape1 nvarchar(32), in ape2 nvarchar(32),
							  in idgener int(2), in edad int(2), in usur nvarchar(64), in pswd nvarchar(64))
begin
declare existe int;
declare msj nvarchar(32);
declare idage int(2);
set existe = (select count(*) from Persona where Persona.email=correo);
	if existe = 0 then
		set msj = 'El Correo NO Existe';
    else
		set existe = (select count(*) from Credenciales where Credenciales.usr=usur);
		if existe = 0 then
			set msj = 'El usuario NO existe';
        else
			set existe = (select count(*) from Persona where Persona.email=correo and Persona.usr=usur);
			if existe = 0 then
				set msj = 'Combinacion Invalida';
			else
				set existe = (select count(*) from Edad where Edad.Descripcion=edad); -- Verificamos si la edad a registrar existe en el catalogo
				if existe = 1 then
					set idage = (select idEdad from Edad where Edad.Descripcion=edad); -- Si existe traemos el id correspondiente
				else
					set idage = (select ifnull(max(idEdad),0) + 1 from Edad); -- Calculamos el "idedad" del catalogo
					insert into Edad values(idage,edad); -- Si no existe la insertamos
				end if;
				update Persona set nombre=nom, apellido1=ape1, apellido2=ape2, idGenero=idgener, idEdad=idage
						where (Persona.email=correo and Persona.usr=usur);
				update Credenciales set psw=pswd where usr=usur;
				set msj = 'Usuario Modificado';
			end if;
        end if;		
    end if;
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Registra Envio Postal ----------------------------------
drop procedure if exists sp_RegistraEnvioPostal;
delimiter **
create procedure sp_RegistraEnvioPostal()
begin
	select msj as Respuesta;
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta Postales Enviadas ---------------------------------- Se necesita el correo del usuario logeado y compararlo con EmailRemitente
drop procedure if exists sp_ConsultaPostalesEnviadas;
delimiter **
create procedure sp_ConsultaPostalesEnviadas()
begin
	
end **
delimiter ;
##-------------------------------------------------------------------------------------------

##---------------------------------- Consulta Postales Recibidas ---------------------------------- Se necesita el correo del usuario logeado y compararlo con EmailDestinatario
drop procedure if exists sp_ConsultaPostalesRecibidas;
delimiter **
create procedure sp_ConsultaPostalesRecibidas()
begin
	
end **
delimiter ;
##-------------------------------------------------------------------------------------------