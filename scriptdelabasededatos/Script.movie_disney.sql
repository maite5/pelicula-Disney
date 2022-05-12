
select * from movie_disney.genre;
select * from tienda.productos;

use tienda;
insert into productos(imagen,nombre,descripcion,precio)
        values ('panes.jpg','Pasta','pasta frola','25,00');
       
       

alter table products 
add primary key(iD); 

use tieda;
CREATE TABLE productos(id int unsigned AUTO_INCREMENT,
imagen varchar(200)NOT NULL,
descripcion varchar(300)NOT NULL,
precio decimal (9, 2) DEFAULT null)
primary key (id)
); 

use tienda;
CREATE TABLE productos(
id  bigint(20) UNSIGNED NOT NULL,
imagen varchar(200)NOT NULL,
descripcion varchar(300)NOT NULL,
precio decimal (9, 2) DEFAULT null,
primary key (id)
); 



