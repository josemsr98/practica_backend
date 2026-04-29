-- Insertar géneros
INSERT INTO genero_entity (nombre) VALUES ('Masculino');
INSERT INTO genero_entity (nombre) VALUES ('Femenino');

-- Insertar puestos de trabajo
INSERT INTO puesto_de_trabajo_entity (nombre_puesto) VALUES ('Desarrollador');
INSERT INTO puesto_de_trabajo_entity (nombre_puesto) VALUES ('Analista');
INSERT INTO puesto_de_trabajo_entity (nombre_puesto) VALUES ('Administrador');
INSERT INTO puesto_de_trabajo_entity (nombre_puesto) VALUES ('Soporte');

-- Insertar usuario (ajusta los IDs según los generados en tu base de datos)
INSERT INTO usuario_entity (
  contrasena, fecha_hora_creacion, fecha_nacimiento, hora_desayuno, nick_usuario, nombre, primer_apellido, segundo_apellido, genero_id, puesto_de_trabajo_id
) VALUES (
  'password123', NOW(), '1990-01-01', '08:00:00', 'usuario1', 'Juan', 'Pérez', 'García', 1, 1
);

-- Insertar dirección para el usuario (ajusta el usuario_id según el generado)
INSERT INTO direccion_entity (
  direccion_principal, nombre_calle, numero_calle, usuario_id
) VALUES (
  1, 'Calle Falsa', 123, 1
);