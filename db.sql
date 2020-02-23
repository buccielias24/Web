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
  `IdAstrobus` INT NOT NULL,
  `cantAsientos` INT NOT NULL,
  `distService` INT NULL DEFAULT NULL,
  `distLimite` INT NOT NULL,
  `estado` INT NOT NULL,
  `fecha_alta` DATE NOT NULL,
  `fecha_baja` DATE NULL DEFAULT NULL,
  `motivo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`IdAstrobus`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `astrobuses`.`planeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`planeta` (
  `IdPlaneta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `estado` INT NOT NULL DEFAULT '1',
  `motivo_baja` INT NULL DEFAULT NULL,
  `coordenadaX` INT NOT NULL,
  `coordenadaY` INT NOT NULL,
  PRIMARY KEY (`IdPlaneta`, `coordenadaX`, `coordenadaY`))
ENGINE = InnoDB
AUTO_INCREMENT = 341
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `astrobuses`.`raza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`raza` (
  `IdRaza` INT NOT NULL AUTO_INCREMENT,
  `nombreRaza` VARCHAR(45) NOT NULL,
  `nivelPeligro` INT NOT NULL,
  PRIMARY KEY (`IdRaza`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `astrobuses`.`resenia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`resenia` (
  `fecha` DATETIME NOT NULL,
  `comentario` VARCHAR(45) NULL DEFAULT NULL,
  `puntaje` INT NULL DEFAULT NULL,
  `idPlaneta` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idUsuario`, `idPlaneta`, `fecha`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `astrobuses`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`usuario` (
  `dgu` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `rol` INT NOT NULL,
  `us_raza` INT NOT NULL,
  PRIMARY KEY (`dgu`),
  INDEX `us_raza_idx` (`us_raza` ASC) VISIBLE,
  CONSTRAINT `raza de usuario`
    FOREIGN KEY (`us_raza`)
    REFERENCES `astrobuses`.`raza` (`IdRaza`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `astrobuses`.`viaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`viaje` (
  `idViaje` INT NOT NULL AUTO_INCREMENT,
  `salida` DATETIME NOT NULL,
  `llegada` DATETIME NOT NULL,
  `estadoViaje` INT NOT NULL DEFAULT '0',
  `origen` INT NOT NULL,
  `destino` INT NOT NULL,
  `distancia` DOUBLE NULL DEFAULT NULL,
  `astrobus` INT NULL DEFAULT NULL,
  `motivo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idViaje`),
  INDEX `origen_idx` (`origen` ASC) VISIBLE,
  INDEX `destino_idx` (`destino` ASC) VISIBLE,
  CONSTRAINT `destino`
    FOREIGN KEY (`destino`)
    REFERENCES `astrobuses`.`planeta` (`IdPlaneta`),
  CONSTRAINT `origen`
    FOREIGN KEY (`origen`)
    REFERENCES `astrobuses`.`planeta` (`IdPlaneta`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `astrobuses`.`viaje_astrobus_usuario_planeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `astrobuses`.`viaje_astrobus_usuario_planeta` (
  `fechaSalida` DATETIME NOT NULL,
  `fechaLlegada` DATETIME NOT NULL,
  `IdViaje` INT NOT NULL,
  `IdAstrobus` INT NOT NULL,
  `IdUsuario` INT NOT NULL,
  PRIMARY KEY (`fechaSalida`, `fechaLlegada`, `IdViaje`, `IdAstrobus`, `IdUsuario`),
  INDEX `viaje_idx` (`IdViaje` ASC) VISIBLE,
  INDEX `astrobus_idx` (`IdAstrobus` ASC) VISIBLE,
  INDEX `usuario_idx` (`IdUsuario` ASC) VISIBLE,
  CONSTRAINT `astrobus`
    FOREIGN KEY (`IdAstrobus`)
    REFERENCES `astrobuses`.`astrobus` (`IdAstrobus`),
  CONSTRAINT `usuario`
    FOREIGN KEY (`IdUsuario`)
    REFERENCES `astrobuses`.`usuario` (`dgu`),
  CONSTRAINT `viaje`
    FOREIGN KEY (`IdViaje`)
    REFERENCES `astrobuses`.`viaje` (`idViaje`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
