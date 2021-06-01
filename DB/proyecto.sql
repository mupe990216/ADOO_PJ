-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema prueba
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema prueba
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `prueba` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `prueba` ;

-- -----------------------------------------------------
-- Table `prueba`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`administrador` (
  `nombre` VARCHAR(45) NOT NULL,
  `correoAdmin` VARCHAR(45) NOT NULL,
  `contraseña` VARCHAR(45) NOT NULL,
  `Gestiona_correoAdmin` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`correoAdmin`),
  INDEX `FK6` (`Gestiona_correoAdmin` ASC) VISIBLE,
  CONSTRAINT `FK6`
    FOREIGN KEY (`Gestiona_correoAdmin`)
    REFERENCES `prueba`.`administrador` (`correoAdmin`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prueba`.`modulo_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`modulo_info` (
  `id_modulo` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `imagenes` INT NOT NULL,
  PRIMARY KEY (`id_modulo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prueba`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`categoria` (
  `id_categoria` INT NOT NULL,
  `descripción_` VARCHAR(45) NOT NULL,
  `id_modulo` INT NOT NULL,
  PRIMARY KEY (`id_categoria`),
  INDEX `FK1` (`id_modulo` ASC) VISIBLE,
  CONSTRAINT `FK1`
    FOREIGN KEY (`id_modulo`)
    REFERENCES `prueba`.`modulo_info` (`id_modulo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prueba`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`cliente` (
  `contraseña` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `correoCliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`correoCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prueba`.`foro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`foro` (
  `autor` VARCHAR(45) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `descripción_` VARCHAR(45) NOT NULL,
  `id_foro` INT NOT NULL,
  PRIMARY KEY (`id_foro`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prueba`.`controla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`controla` (
  `correoAdmin` VARCHAR(45) NOT NULL,
  `id_foro` INT NOT NULL,
  PRIMARY KEY (`correoAdmin`, `id_foro`),
  INDEX `FK10` (`id_foro` ASC) VISIBLE,
  CONSTRAINT `FK10`
    FOREIGN KEY (`id_foro`)
    REFERENCES `prueba`.`foro` (`id_foro`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK9`
    FOREIGN KEY (`correoAdmin`)
    REFERENCES `prueba`.`administrador` (`correoAdmin`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prueba`.`gestionacliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`gestionacliente` (
  `correoCliente` VARCHAR(45) NOT NULL,
  `correoAdmin` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`correoCliente`, `correoAdmin`),
  INDEX `FK8` (`correoAdmin` ASC) VISIBLE,
  CONSTRAINT `FK7`
    FOREIGN KEY (`correoCliente`)
    REFERENCES `prueba`.`cliente` (`correoCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK8`
    FOREIGN KEY (`correoAdmin`)
    REFERENCES `prueba`.`administrador` (`correoAdmin`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prueba`.`gestionamodulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`gestionamodulo` (
  `correoAdmin` VARCHAR(45) NOT NULL,
  `id_modulo` INT NOT NULL,
  PRIMARY KEY (`correoAdmin`, `id_modulo`),
  INDEX `FK12` (`id_modulo` ASC) VISIBLE,
  CONSTRAINT `FK11`
    FOREIGN KEY (`correoAdmin`)
    REFERENCES `prueba`.`administrador` (`correoAdmin`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK12`
    FOREIGN KEY (`id_modulo`)
    REFERENCES `prueba`.`modulo_info` (`id_modulo`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prueba`.`mensaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`mensaje` (
  `contenido` VARCHAR(45) NOT NULL,
  `id_mensaje` INT NOT NULL,
  `autor_` VARCHAR(45) NOT NULL,
  `correoCliente` VARCHAR(45) NOT NULL,
  `id_foro` INT NOT NULL,
  PRIMARY KEY (`id_mensaje`, `correoCliente`, `id_foro`),
  INDEX `FK4` (`correoCliente` ASC) VISIBLE,
  INDEX `FK5` (`id_foro` ASC) VISIBLE,
  CONSTRAINT `FK4`
    FOREIGN KEY (`correoCliente`)
    REFERENCES `prueba`.`cliente` (`correoCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK5`
    FOREIGN KEY (`id_foro`)
    REFERENCES `prueba`.`foro` (`id_foro`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `prueba`.`participa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`participa` (
  `correoCliente` VARCHAR(45) NOT NULL,
  `id_foro` INT NOT NULL,
  PRIMARY KEY (`correoCliente`, `id_foro`),
  INDEX `FK3` (`id_foro` ASC) VISIBLE,
  CONSTRAINT `FK2`
    FOREIGN KEY (`correoCliente`)
    REFERENCES `prueba`.`cliente` (`correoCliente`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK3`
    FOREIGN KEY (`id_foro`)
    REFERENCES `prueba`.`foro` (`id_foro`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
