-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema astrobuses
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema astrobuses
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `astrobuses` DEFAULT CHARACTER SET utf8 ;
USE `astrobuses` ;

-- -----------------------------------------------------
-- Table `astrobuses`.`astrobus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`astrobus` (
  `id` INT(11) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `cantAsientos` INT(3) NOT NULL,
  `distService` INT(255) NULL DEFAULT NULL,
  `distLimite` INT(255) NOT NULL,
  `tiempoDesdeSinUso` DATE NOT NULL,
  `estado` INT(11) NOT NULL,
  `fecha_alta` DATE NOT NULL,
  `fecha_baja` DATE NULL DEFAULT NULL,
  `motivo` INT(11) NULL DEFAULT NULL,
  `comentario` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `astrobuses`.`frecuencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`frecuencia` (
  `lunes` BIT(1) NULL DEFAULT NULL,
  `martes` BIT(1) NULL DEFAULT NULL,
  `miercoles` BIT(1) NULL DEFAULT NULL,
  `jueves` BIT(1) NULL DEFAULT NULL,
  `viernes` BIT(1) NULL DEFAULT NULL,
  `sabado` BIT(1) NULL DEFAULT NULL,
  `domingo` BIT(1) NULL DEFAULT NULL,
  `origen` INT(11) NOT NULL,
  `destino` INT(11) NOT NULL,
  PRIMARY KEY (`origen`, `destino`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `astrobuses`.`planetas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`planetas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `estado` INT(11) NOT NULL DEFAULT '1',
  `motivo_baja` INT(11) NULL DEFAULT NULL,
  `fecha_alta` DATETIME NOT NULL,
  `fecha_baja` DATETIME NULL DEFAULT NULL,
  `coordenadaX` INT(11) NOT NULL,
  `coordenadaY` INT(11) NOT NULL,
  `url` LONGTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `coordenadaX`, `coordenadaY`))
ENGINE = InnoDB
AUTO_INCREMENT = 341
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `astrobuses`.`raza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`raza` (
  `idRaza` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreRaza` VARCHAR(45) NOT NULL,
  `nivelPeligro` INT(11) NOT NULL,
  PRIMARY KEY (`idRaza`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `astrobuses`.`resenia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`resenia` (
  `fecha` DATETIME NOT NULL,
  `comentario` VARCHAR(45) NULL DEFAULT NULL,
  `puntaje` INT(11) NULL DEFAULT NULL,
  `idPlaneta` INT(11) NOT NULL,
  `idUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario`, `idPlaneta`, `fecha`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `astrobuses`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`usuarios` (
  `dgu` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `rol` INT(1) NOT NULL,
  PRIMARY KEY (`dgu`, `usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `astrobuses`.`viaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`viaje` (
  `idViaje` INT(11) NOT NULL AUTO_INCREMENT,
  `salida` DATETIME NOT NULL,
  `llegada` DATETIME NOT NULL,
  `estadoViaje` INT(11) NOT NULL DEFAULT '0',
  `origen` INT(11) NOT NULL,
  `destino` INT(11) NOT NULL,
  `distancia` DOUBLE NULL DEFAULT NULL,
  `astrobus` INT(11) NULL DEFAULT NULL,
  `motivo` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idViaje`),
  INDEX `origen_idx` (`origen` ASC),
  INDEX `destino_idx` (`destino` ASC),
  INDEX `astrobus_idx` (`astrobus` ASC),
  CONSTRAINT `astrobus`
    FOREIGN KEY (`astrobus`)
    REFERENCES `astrobuses`.`astrobus` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `destino`
    FOREIGN KEY (`destino`)
    REFERENCES `astrobuses`.`planetas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `origen`
    FOREIGN KEY (`origen`)
    REFERENCES `astrobuses`.`planetas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
