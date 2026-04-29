-- Tabla de géneros
CREATE TABLE `genero_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Tabla de puestos de trabajo
CREATE TABLE `puesto_de_trabajo_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre_puesto` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Tabla de usuarios
CREATE TABLE `usuario_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(255) NOT NULL,
  `fecha_hora_creacion` datetime(6) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `hora_desayuno` time(6) DEFAULT NULL,
  `nick_usuario` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `primer_apellido` varchar(255) NOT NULL,
  `segundo_apellido` varchar(255) DEFAULT NULL,
  `genero_id` int NOT NULL,
  `puesto_de_trabajo_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjl20kpf4pu3t9rrldu2cv33rb` (`genero_id`),
  KEY `FKaxemmsbc8khat7mt2ny8n1jkp` (`puesto_de_trabajo_id`),
  CONSTRAINT `FKaxemmsbc8khat7mt2ny8n1jkp` FOREIGN KEY (`puesto_de_trabajo_id`) REFERENCES `puesto_de_trabajo_entity` (`id`),
  CONSTRAINT `FKjl20kpf4pu3t9rrldu2cv33rb` FOREIGN KEY (`genero_id`) REFERENCES `genero_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Tabla de direcciones
CREATE TABLE `direccion_entity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `direccion_principal` bit(1) NOT NULL,
  `nombre_calle` varchar(255) NOT NULL,
  `numero_calle` int DEFAULT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt4sgw6fyf29ixnibg1f6cyade` (`usuario_id`),
  CONSTRAINT `FKt4sgw6fyf29ixnibg1f6cyade` FOREIGN KEY (`usuario_id`) REFERENCES `usuario_entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;