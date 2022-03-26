 INSERT INTO role VALUES (1, 'Admin role','ADMIN');
 INSERT INTO role VALUES (2, 'User role','USER');
INSERT INTO `dbdisney`.alkemy_user VALUES ('500', 'adrian@adrian.com', 'adrian fersa', '$2a$10$p/cAv1X4K6RiR.iB/ES1HeYYT/2G8kMCXILov5/FBcTDSwgSd5l9a');
-- password: admin
 INSERT INTO `dbdisney`.`user_roles` (`user_id`, `role_id`) VALUES ('500', '1');

-- imagen película:
 INSERT INTO `dbdisney`.`imagen` VALUES (50002, 'https://i0.wp.com/hipertextual.com/wp-content/uploads/2021/02/orig_234330.jpg');
-- imagen personaje:
 INSERT INTO `dbdisney`.`imagen`  VALUES (50003, 'https://imagenes.elpais.com/resizer/r0DM4kylqGwYosNN8yzgAas-64c=/1960x1103/cloudfront-eu-central-1.images.arcpublishing.com/prisa/2OSN42W7ZYH5F4KXCNBD64CUKU.jpg');
-- imagen genero:
 INSERT INTO `dbdisney`.`imagen`  VALUES (50004, 'https://upload.wikimedia.org/wikipedia/commons/f/fd/Copy_of_accion-logo.png');

-- Película:
INSERT INTO `dbdisney`.`pelicula` (`id_pelicula`, `calificacion`, `fecha_creacion`, `titulo`, `imagen_id_imagen`) VALUES (50505050, 5, '1995-01-29', 'SUPERMAN', 50002);

-- personaje:
 INSERT INTO `dbdisney`.`personaje`  VALUES (50002, 23, 'habia una vez', 'superman', 90,50003);

-- película_personaje:
 INSERT INTO `dbdisney`.`pelicula_personaje` VALUES (50505050, 50002);

-- género:
 INSERT INTO `dbdisney`.`genero` (`id_genero`, `nombre`, `imagen_id_imagen`) VALUES (50010, 'Accion', 50004);

-- película_género:
 INSERT INTO `dbdisney`.`pelicula_genero` (`id_pelicula`, `id_genero`) VALUES (50505050, 50010);

