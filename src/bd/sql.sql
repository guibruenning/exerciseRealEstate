-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `realState` DEFAULT CHARACTER SET utf8 ;
USE `realState` ;

-- -----------------------------------------------------
-- Table `mydb`.`stage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`stage` (
  `id` INT NOT NULL,a
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`funnel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`funnel` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idfunnel_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`funnel_has_stage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`funnel_has_stage` (
  `funnel_id` INT NOT NULL,
  `stage_id` INT NOT NULL,
  PRIMARY KEY (`funnel_id`, `stage_id`),
  INDEX `fk_funnel_has_stage_stage1_idx` (`stage_id` ASC) VISIBLE,
  INDEX `fk_funnel_has_stage_funnel_idx` (`funnel_id` ASC) VISIBLE,
  CONSTRAINT `fk_funnel_has_stage_funnel`
    FOREIGN KEY (`funnel_id`)
    REFERENCES `realState`.`funnel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funnel_has_stage_stage1`
    FOREIGN KEY (`stage_id`)
    REFERENCES `realState`.`stage` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
