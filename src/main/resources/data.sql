 INSERT INTO role VALUES (1, 'Admin role','ADMIN');
 INSERT INTO role VALUES (2, 'User role','USER');
INSERT INTO `dbdisney`.alkemy_user VALUES ('500', 'adrian@adrian.com', 'adrianfersa', '$2a$10$p/cAv1X4K6RiR.iB/ES1HeYYT/2G8kMCXILov5/FBcTDSwgSd5l9a');
-- password: admin
 INSERT INTO `dbdisney`.`user_roles` (`user_id`, `role_id`) VALUES ('500', '1');

-- imagen película:
 INSERT INTO `dbdisney`.`imagen` VALUES (50002, 'https://i0.wp.com/hipertextual.com/wp-content/uploads/2021/02/orig_234330.jpg');
    -- película batman
    INSERT INTO `dbdisney`.`imagen` VALUES (50006, 'https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/cinefilia/ranking-cual-es-la-mejor-pelicula-de-batman/100203545-19-esl-ES/Ranking-Cual-es-la-mejor-pelicula-de-Batman.jpg');
    -- película batichica
    INSERT INTO `dbdisney`.`imagen` VALUES (50008, 'https://cloudfront-us-east-1.images.arcpublishing.com/infobae/2C7HYQOEFFBNFCWDB6XP5YFJ4E.jpeg');

-- imagen personaje batman:
 INSERT INTO `dbdisney`.`imagen`  VALUES (50003, 'https://imagenes.elpais.com/resizer/r0DM4kylqGwYosNN8yzgAas-64c=/1960x1103/cloudfront-eu-central-1.images.arcpublishing.com/prisa/2OSN42W7ZYH5F4KXCNBD64CUKU.jpg');
    -- imagen personaje batichica:
    INSERT INTO `dbdisney`.`imagen`  VALUES (50007, 'https://www.mdzol.com/u/fotografias/m/2020/4/16/f850x638-35089_112578_5050.jpg');

    -- imagen personaje batman
     INSERT INTO `dbdisney`.`imagen`  VALUES (50005, 'https://i0.wp.com/hipertextual.com/wp-content/uploads/2021/08/batman-scaled.jpeg');

-- imagen genero:
 INSERT INTO `dbdisney`.`imagen`  VALUES (50004, 'https://upload.wikimedia.org/wikipedia/commons/f/fd/Copy_of_accion-logo.png');


-- Película:
INSERT INTO `dbdisney`.`pelicula` (`id_pelicula`, `calificacion`, `fecha_creacion`, `titulo`, `imagen_id_imagen`) VALUES (50505050, 3, '1995-01-29', 'SUPERMAN S', 50002);
-- Película de batman:
INSERT INTO `dbdisney`.`pelicula` (`id_pelicula`, `calificacion`, `fecha_creacion`, `titulo`, `imagen_id_imagen`) VALUES (50505051, 4, '1992-01-29', 'batman CONTRAATACA', 50006);
-- Película batichica:
INSERT INTO `dbdisney`.`pelicula` (`id_pelicula`, `calificacion`, `fecha_creacion`, `titulo`, `imagen_id_imagen`) VALUES (50505052, 5, '2022-01-29', 'batichica red', 50008);

-- personaje:
 INSERT INTO `dbdisney`.`personaje`  VALUES (50002, 23, 'habia una vez', 'superman', 90,50003);
 INSERT INTO `dbdisney`.`personaje`  VALUES (50003, 24, 'Noche contraataca', 'batman', 94,50005);
 INSERT INTO `dbdisney`.`personaje`  VALUES (50004, 25, 'La más poderosa', 'batichica', 67,50007);

-- película_personaje:
 INSERT INTO `dbdisney`.`pelicula_personaje` VALUES (50505050, 50002); -- Película: superman, personaje: superman
 INSERT INTO `dbdisney`.`pelicula_personaje` VALUES (50505051, 50003);  -- Película: batman CONTRAATACA, personaje: batman
  INSERT INTO `dbdisney`.`pelicula_personaje` VALUES (50505052, 50003); -- Película: batichica, personaje: batman
 INSERT INTO `dbdisney`.`pelicula_personaje` VALUES (50505052, 50004); -- Película: batichica, personaje: batichica

-- género:
 INSERT INTO `dbdisney`.`genero` (`id_genero`, `nombre`, `imagen_id_imagen`) VALUES (50010, 'Accion', 50004);

-- película_género:
 INSERT INTO `dbdisney`.`pelicula_genero` (`id_pelicula`, `id_genero`) VALUES (50505050, 50010);
 INSERT INTO `dbdisney`.`pelicula_genero` (`id_pelicula`, `id_genero`) VALUES (50505051, 50010);
 INSERT INTO `dbdisney`.`pelicula_genero` (`id_pelicula`, `id_genero`) VALUES (50505052, 50010);

