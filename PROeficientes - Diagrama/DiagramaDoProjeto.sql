-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema PROficientes
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema PROficientes
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PROficientes` DEFAULT CHARACTER SET utf8 ;
USE `PROficientes` ;

-- -----------------------------------------------------
-- Table `PROficientes`.`tb_tema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PROficientes`.`tb_tema` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NULL,
  `descricao` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PROficientes`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PROficientes`.`tb_usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  `foto` VARCHAR(255) NULL,
  `tipo` VARCHAR(255) NOT NULL,
  `sobre` VARCHAR(1000) NULL,
  `data_nacimento` DATE NOT NULL,
  `logo` VARCHAR(255) NULL,
  `seguidores` VARCHAR(255) NULL,
  `seguindo` VARCHAR(255) NULL,
  `certificados` VARCHAR(255) NULL,
  `formacao_academica` VARCHAR(255) NULL,
  `idiomas` VARCHAR(255) NULL,
  `telefone` VARCHAR(255) NULL,
  `link_redes_sociais` VARCHAR(255) NULL,
  `avaliacao` INT NULL,
  `mensagens` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PROficientes`.`tb_postagens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `PROficientes`.`tb_postagens` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `tema_id` BIGINT NOT NULL,
  `usuario_id` BIGINT NOT NULL,
  `publicar` VARCHAR(100) NULL,
  `data_hora` DATETIME NOT NULL,
  `comentario` VARCHAR(500) NULL,
  `like` INT NULL,
  `midia` VARCHAR(255) NULL,
  `compartilhar` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tb_postagens_tb_tema_idx` (`tema_id` ASC) VISIBLE,
  INDEX `fk_tb_postagens_tb_usuario1_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `fk_tb_postagens_tb_tema`
    FOREIGN KEY (`tema_id`)
    REFERENCES `PROficientes`.`tb_tema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_postagens_tb_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `PROficientes`.`tb_usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
