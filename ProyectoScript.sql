
DROP SCHEMA IF EXISTS `bancoEmpleo` ;
CREATE SCHEMA IF NOT EXISTS `bancoEmpleo` DEFAULT CHARACTER SET utf8 ;
USE `bancoEmpleo`;

-- -----------------------------------------------------

DROP TABLE IF EXISTS `requerimientos`;
DROP TABLE IF EXISTS `habilidades`;
DROP TABLE IF EXISTS `subcategoria`;
DROP TABLE IF EXISTS `categoria`;
DROP TABLE IF EXISTS `puesto`;
DROP TABLE IF EXISTS `oferente`;
DROP TABLE IF EXISTS `administrador`;
DROP TABLE IF EXISTS `empresa`;
DROP TABLE IF EXISTS `usuario`;

-- -----------------------------------------------------

DROP TABLE IF EXISTS `usuario`;


CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` INT NOT NULL,
  `tipo` INT NOT NULL,
  PRIMARY KEY (`id_usuario`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------

DROP TABLE IF EXISTS `empresa`;

CREATE TABLE IF NOT EXISTS `empresa` (
  `id_empresa` INT NOT NULL,
  `nombre_empresa`  VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `localizacion` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `correo` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `telefono` INT NOT NULL,
  `descripcion` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `clave` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `fecha_registro` TIMESTAMP NOT NULL,
  `estado` INT, -- 0-> En espera 1->Rechazado 2->Aprobado
  `usuario` INT NOT NULL,
	PRIMARY KEY (`id_empresa`),
	CONSTRAINT `fk_bancoEmpleo_usuario`
    FOREIGN KEY (`usuario`)
    REFERENCES `usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------

DROP TABLE IF EXISTS `administrador`;

CREATE TABLE IF NOT EXISTS `administrador` (
	`id_administrador` INT NOT NULL,
    `nombre_administrador` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
    `clave` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci',
    `usuario` INT NOT NULL,
      PRIMARY KEY (`id_administrador`),
      CONSTRAINT `fk_bancoEmpleo_usuario2`
      FOREIGN KEY (`usuario`)
      REFERENCES `usuario` (`id_usuario`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------

DROP TABLE IF EXISTS `puesto`;

CREATE TABLE IF NOT EXISTS `puesto` (
  `id_puesto` INT NOT NULL,
  `nombre_puesto` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `descripcion` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  `salario_ofrecido` INT NOT NULL,
  `tipo_publicacion` INT NOT NULL, -- 0 = Publico / 1 = Privado
  `estado_publicacion` INT NOT NULL, -- 0 = Disponible / 1 = Ocupado
  `empresa` INT NOT NULL,
  PRIMARY KEY (`id_puesto`),
  CONSTRAINT `fk_bancoEmpleo_empresa`
  FOREIGN KEY (`empresa`)
  REFERENCES `empresa` (`id_empresa`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------

DROP TABLE IF EXISTS `oferente`;

CREATE TABLE IF NOT EXISTS `oferente` (
	`id_oferente` INT NOT NULL,
    `nombre_oferente` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
    `primer_apellido` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
	`nacionalidad` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
    `telefono` INT,
    `correo` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
    `residencia` TEXT CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
    `estado` INT, -- 0-> En espera 1->Rechazado 2->Aprobado
	`usuario` INT NOT NULL,
      PRIMARY KEY (`id_oferente`),
      CONSTRAINT `fk_bancoEmpleo_usuario3`
      FOREIGN KEY (`usuario`)
      REFERENCES `usuario` (`id_usuario`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------

DROP TABLE IF EXISTS `categoria`;

CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` INT NOT NULL,
  `nombre_categoria` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
  PRIMARY KEY (`id_categoria`)
  )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------

DROP TABLE IF EXISTS `subCategoria`;

CREATE TABLE IF NOT EXISTS `subCategoria` (
	`id_subCategoria` INT NOT NULL,
    `nombre_subCategoria` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_spanish_ci' NOT NULL,
    `categoria` INT NOT NULL,
      PRIMARY KEY (`id_subCategoria`),
	  CONSTRAINT `fk_bancoEmpleo_categoria`
	  FOREIGN KEY (`categoria`)
	  REFERENCES `categoria` (`id_categoria`)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------

DROP TABLE IF EXISTS `habilidades`;

CREATE TABLE IF NOT EXISTS `habilidades` (
	`oferente` INT NOT NULL,
    `subCategoria` INT NOT NULL,
    `nivel` INT NOT NULL,
      PRIMARY KEY (`oferente`,`subCategoria`),
	  CONSTRAINT `fk_bancoEmpleo_oferente1`
	  FOREIGN KEY (`oferente`)
	  REFERENCES `oferente` (`id_oferente`)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION,
      CONSTRAINT `fk_bancoEmpleo_subCategoria1`
	  FOREIGN KEY (`subCategoria`)
	  REFERENCES `subCategoria` (`id_subCategoria`)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------

DROP TABLE IF EXISTS `requerimientos` ;

CREATE TABLE IF NOT EXISTS `requerimientos` (
	`puesto` INT NOT NULL,
    `subCategoria` INT NOT NULL,
    `nivel` INT NOT NULL,
      PRIMARY KEY (`puesto`,`subCategoria`),
	  CONSTRAINT `fk_bancoEmpleo_puesto`
	  FOREIGN KEY (`puesto`)
	  REFERENCES `puesto` (`id_puesto`)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION,
      CONSTRAINT `fk_bancoEmpleo_subCategoria`
	  FOREIGN KEY (`subCategoria`)
	  REFERENCES `subCategoria` (`id_subCategoria`)
	  ON DELETE NO ACTION
	  ON UPDATE NO ACTION
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
-- -------------------------------------------------

-- SELECCIONES DE TABLAS

SELECT * FROM usuario;
SELECT * FROM empresa;
SELECT * FROM administrador;
SELECT * FROM oferente;
SELECT * FROM puesto;
SELECT * FROM categoria;
SELECT * FROM subcategoria;
SELECT * FROM habilidades;
SELECT * FROM requerimientos;

-- INSERCIONES DE PRUEBA

INSERT INTO usuario (id_usuario, tipo) VALUES (1,1); -- EL tipo 1 es de administrador
INSERT INTO usuario (id_usuario, tipo) VALUES (2,2); -- El tipo 2 es de empresas
INSERT INTO usuario (id_usuario, tipo) VALUES (3,3); -- El tipo 3 es de oferentes

INSERT INTO administrador (id_administrador, nombre_administrador, clave, usuario) VALUES (123, 'Kristyn', '1234', 1);

INSERT INTO bancoempleo.empresa (id_empresa, nombre_empresa, localizacion, correo, telefono, descripcion, clave, fecha_registro, estado, usuario)
VALUES (1, 'Casino', 'Aurora Heredia', 'casino@gmail.com', 24668872, 'Venta de Ropa y Calzado', '1234', current_timestamp(), 0,2);

INSERT INTO bancoempleo.empresa (id_empresa, nombre_empresa, localizacion, correo, telefono, descripcion, clave, fecha_registro, estado, usuario)
VALUES (4, 'PNG', 'Ulloa', 'png@gmail.com', 24668898, 'Ventas', '1234', current_timestamp(), 0,2);

INSERT INTO oferente (id_oferente, nombre_oferente, primer_apellido, nacionalidad, telefono, correo, residencia, estado,usuario)
VALUES (117180070, 'Kristyn', 'Tenorio', 'Costarricense', 84285913, 'kristyn.tenorio@gmail.com', 'Heredia, Lagunilla', 0,3);

INSERT INTO puesto (id_puesto, nombre_puesto, descripcion, salario_ofrecido, tipo_publicacion, estado_publicacion, empresa)
VALUES (34, 'Programador Junior', 'Programacion Web', 500000, 0,0,4);

INSERT INTO categoria (id_categoria, nombre_categoria) VALUES (1, 'Lenguajes');

INSERT INTO subcategoria (id_subCategoria, nombre_subCategoria, categoria) VALUES (1, 'C++', 1);
INSERT INTO subcategoria (id_subCategoria, nombre_subCategoria, categoria) VALUES (2, 'Java', 1);
INSERT INTO subcategoria (id_subCategoria, nombre_subCategoria, categoria) VALUES (3, 'Phyton', 1);


INSERT INTO habilidades (oferente, subcategoria, nivel) VALUES (117180070, 1, 50);
INSERT INTO habilidades (oferente, subcategoria, nivel) VALUES (117180070, 2, 80);

INSERT INTO requerimientos (puesto, subcategoria, nivel) VALUES (34, 1, 80);
INSERT INTO requerimientos (puesto, subcategoria, nivel) VALUES (34, 2, 50);
INSERT INTO requerimientos (puesto, subcategoria, nivel) VALUES (34, 3, 40);
