
DROP DATABASE IF EXISTS veteritson;
CREATE DATABASE veteritson
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_0900_ai_ci;

USE veteritson;

-- -----------------------------------------------------------------------------
-- Veterinario
-- -----------------------------------------------------------------------------
CREATE TABLE veterinario (
    idVeterinario   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre          VARCHAR(100) NOT NULL,
    telefono        VARCHAR(15)  NOT NULL,
    correo          VARCHAR(100) NOT NULL,
    cedula          VARCHAR(20)  NOT NULL COMMENT 'Cedula profesional',
    diasDisponible  SET('Lunes','Martes','Miercoles','Jueves','Viernes','Sabado','Domingo') NOT NULL,
    CONSTRAINT pk_veterinario PRIMARY KEY (idVeterinario),
    CONSTRAINT uq_veterinario_cedula UNIQUE (cedula),
    CONSTRAINT uq_veterinario_correo UNIQUE (correo)
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- Cliente
-- -----------------------------------------------------------------------------
CREATE TABLE cliente (
    idCliente   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre      VARCHAR(100) NOT NULL,
    telefono    VARCHAR(15)  NOT NULL,
    correo      VARCHAR(100) NULL,
    CONSTRAINT pk_cliente PRIMARY KEY (idCliente),
    CONSTRAINT uq_cliente_correo UNIQUE (correo)
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- Mascota
-- -----------------------------------------------------------------------------
CREATE TABLE mascota (
    idMascota   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre      VARCHAR(60)  NOT NULL,
    especie     VARCHAR(40)  NOT NULL,
    raza        VARCHAR(60)  NULL,
    sexo        ENUM('Macho','Hembra') NOT NULL,
    peso        DECIMAL(6,2) NULL COMMENT 'Kilogramos',
    senas       VARCHAR(255) NULL COMMENT 'Senas particulares',
    imagen      VARCHAR(255) NULL COMMENT 'Ruta o URL de la foto',
    idCliente   INT UNSIGNED NOT NULL COMMENT 'Dueno',
    CONSTRAINT pk_mascota PRIMARY KEY (idMascota),
    CONSTRAINT ck_mascota_peso CHECK (peso IS NULL OR peso > 0),
    CONSTRAINT fk_mascota_cliente FOREIGN KEY (idCliente)
        REFERENCES cliente (idCliente)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- Cita
--   atiende  : Veterinario 1 --- N Cita
--   solicita : Cliente     1 --- N Cita
--   asiste   : Mascota     1 --- N Cita
-- -----------------------------------------------------------------------------
CREATE TABLE cita (
    idCita          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    fecha           DATE         NOT NULL,
    hora            TIME         NOT NULL,
    motivo          VARCHAR(150) NOT NULL,
    estado          ENUM('Pendiente','Confirmada','Atendida','Cancelada') NOT NULL DEFAULT 'Pendiente',
    idVeterinario   INT UNSIGNED NOT NULL,
    idCliente       INT UNSIGNED NOT NULL,
    idMascota       INT UNSIGNED NOT NULL,
    CONSTRAINT pk_cita PRIMARY KEY (idCita),
    -- Un veterinario no puede tener dos citas a la misma fecha y hora
    CONSTRAINT uq_cita_veterinario_horario UNIQUE (idVeterinario, fecha, hora),
    CONSTRAINT fk_cita_veterinario FOREIGN KEY (idVeterinario)
        REFERENCES veterinario (idVeterinario)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_cita_cliente FOREIGN KEY (idCliente)
        REFERENCES cliente (idCliente)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_cita_mascota FOREIGN KEY (idMascota)
        REFERENCES mascota (idMascota)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB;

CREATE INDEX ix_cita_fecha ON cita (fecha, hora);

-- -----------------------------------------------------------------------------
-- Cartilla
-- -----------------------------------------------------------------------------
CREATE TABLE cartilla (
    idCartilla      INT UNSIGNED NOT NULL AUTO_INCREMENT,
    fechaCreacion   DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    idMascota       INT UNSIGNED NOT NULL,
    CONSTRAINT pk_cartilla PRIMARY KEY (idCartilla),
    -- UNIQUE garantiza la relacion 1:1 (una cartilla por mascota)
    CONSTRAINT uq_cartilla_mascota UNIQUE (idMascota),
    CONSTRAINT fk_cartilla_mascota FOREIGN KEY (idMascota)
        REFERENCES mascota (idMascota)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- Vacuna (catalogo de vacunas / tratamientos)
-- -----------------------------------------------------------------------------
CREATE TABLE vacuna (
    idVacuna    INT UNSIGNED NOT NULL AUTO_INCREMENT,
    nombre      VARCHAR(100) NOT NULL,
    CONSTRAINT pk_vacuna PRIMARY KEY (idVacuna),
    CONSTRAINT uq_vacuna_nombre UNIQUE (nombre)
) ENGINE = InnoDB;

-- -----------------------------------------------------------------------------
-- Aplicacion (renglon de la cartilla: una vacuna aplicada a una mascota)
--   registra    : Cartilla    1 --- N Aplicacion
--   corresponde : Vacuna      1 --- N Aplicacion
--   aplica      : Veterinario 1 --- N Aplicacion
--   Resuelve la N:M Cartilla-Vacuna; la misma vacuna puede aplicarse varias
-- -----------------------------------------------------------------------------
CREATE TABLE aplicacion (
    idAplicacion    INT UNSIGNED NOT NULL AUTO_INCREMENT,
    fechaAplicacion DATE         NOT NULL,
    lote            VARCHAR(30)  NOT NULL,
    estado          ENUM('Pendiente','Aplicada','Cancelada') NOT NULL DEFAULT 'Aplicada',
    idCartilla      INT UNSIGNED NOT NULL,
    idVacuna        INT UNSIGNED NOT NULL,
    idVeterinario   INT UNSIGNED NOT NULL,
    CONSTRAINT pk_aplicacion PRIMARY KEY (idAplicacion),
    CONSTRAINT fk_aplicacion_cartilla FOREIGN KEY (idCartilla)
        REFERENCES cartilla (idCartilla)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_aplicacion_vacuna FOREIGN KEY (idVacuna)
        REFERENCES vacuna (idVacuna)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_aplicacion_veterinario FOREIGN KEY (idVeterinario)
        REFERENCES veterinario (idVeterinario)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB;

CREATE INDEX ix_aplicacion_cartilla_fecha ON aplicacion (idCartilla, fechaAplicacion);
