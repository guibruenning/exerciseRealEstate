-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema realState
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `realState` ;

-- -----------------------------------------------------
-- Schema realState
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `realState` DEFAULT CHARACTER SET utf8 ;
USE `realState` ;

-- -----------------------------------------------------
-- Table `realState`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`account` (
  `idAccount` INT NOT NULL AUTO_INCREMENT,
  `agency` INT NULL,
  `agencyDigit` INT NULL,
  `accountNumber` INT NULL,
  `accountNumberDigit` INT NULL,
  `bankName` VARCHAR(45) NULL,
  `bankNumber` INT NULL,
  `type` VARCHAR(1) NULL,
  PRIMARY KEY (`idAccount`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`person` (
  `idPerson` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `birth` DATE NULL,
  `cpf_cnpj` INT NULL,
  `street` VARCHAR(45) NULL,
  `district` VARCHAR(45) NULL,
  `number` INT NULL,
  `complement` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `origin` INT NULL,
  `creci` VARCHAR(45) NULL,
  `idAccount` INT NULL,
  PRIMARY KEY (`idPerson`),
  INDEX `fk_Person_Account1_idx` (`idAccount` ASC),
  CONSTRAINT `fk_Person_Account1`
    FOREIGN KEY (`idAccount`)
    REFERENCES `realState`.`account` (`idAccount`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`typePerson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`typePerson` (
  `idTypePerson` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`idTypePerson`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`person_has_typePerson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`person_has_typePerson` (
  `idPerson` INT NOT NULL,
  `idTypePerson` INT NOT NULL,
  PRIMARY KEY (`idPerson`, `idTypePerson`),
  INDEX `fk_Person_has_TypePerson_TypePerson1_idx` (`idTypePerson` ASC),
  INDEX `fk_Person_has_TypePerson_Person1_idx` (`idPerson` ASC),
  CONSTRAINT `fk_Person_has_TypePerson_Person1`
    FOREIGN KEY (`idPerson`)
    REFERENCES `realState`.`person` (`idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Person_has_TypePerson_TypePerson1`
    FOREIGN KEY (`idTypePerson`)
    REFERENCES `realState`.`typePerson` (`idTypePerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`building`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`building` (
  `idBuilding` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `purpose` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `rooms` INT NULL,
  `bedroom` INT NULL,
  `bathroom` INT NULL,
  `suite` INT NULL,
  `totalArea` FLOAT NULL,
  `privateArea` FLOAT NULL,
  `usefullArea` FLOAT NULL,
  `amountSale` FLOAT NULL,
  `amountRent` FLOAT NULL,
  `amountSeason` FLOAT NULL,
  `street` VARCHAR(45) NULL,
  `district` VARCHAR(45) NULL,
  `number` INT NULL,
  `complement` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `idPerson` INT NULL,
  PRIMARY KEY (`idBuilding`),
  INDEX `fk_building_person1_idx` (`idPerson` ASC),
  CONSTRAINT `fk_building_person1`
    FOREIGN KEY (`idPerson`)
    REFERENCES `realState`.`person` (`idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`lead`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`lead` (
  `idLead` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `phone` INT NULL,
  `email` VARCHAR(45) NULL,
  `origin` INT NULL,
  `idBuilding` INT NULL,
  PRIMARY KEY (`idLead`),
  INDEX `fk_lead_building1_idx` (`idBuilding` ASC),
  CONSTRAINT `fk_lead_building1`
    FOREIGN KEY (`idBuilding`)
    REFERENCES `realState`.`building` (`idBuilding`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `phone` INT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`stage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`stage` (
  `idStage` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idStage`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`funnel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`funnel` (
  `idFunnel` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `idStage` INT NULL COMMENT '--',
  PRIMARY KEY (`idFunnel`),
  INDEX `fk_funnel_stage1_idx` (`idStage` ASC),
  CONSTRAINT `fk_funnel_stage1`
    FOREIGN KEY (`idStage`)
    REFERENCES `realState`.`stage` (`idStage`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`deal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`deal` (
  `idDeal` INT NOT NULL AUTO_INCREMENT,
  `amount` FLOAT NULL,
  `idPerson` INT NOT NULL,
  `idUser` INT NOT NULL,
  `idFunnel` INT NOT NULL,
  `idBuilding` INT NOT NULL,
  PRIMARY KEY (`idDeal`),
  INDEX `fk_deal_person1_idx` (`idPerson` ASC),
  INDEX `fk_deal_user1_idx` (`idUser` ASC),
  INDEX `fk_deal_funnel1_idx` (`idFunnel` ASC),
  INDEX `fk_deal_building1_idx` (`idBuilding` ASC),
  CONSTRAINT `fk_deal_person1`
    FOREIGN KEY (`idPerson`)
    REFERENCES `realState`.`person` (`idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_deal_user1`
    FOREIGN KEY (`idUser`)
    REFERENCES `realState`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_deal_funnel1`
    FOREIGN KEY (`idFunnel`)
    REFERENCES `realState`.`funnel` (`idFunnel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_deal_building1`
    FOREIGN KEY (`idBuilding`)
    REFERENCES `realState`.`building` (`idBuilding`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`permission` (
  `idPermission` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `idPermissionDad` INT NULL,
  PRIMARY KEY (`idPermission`),
  INDEX `fk_permission_permission1_idx` (`idPermission` ASC),
  CONSTRAINT `fk_permission_permission1`
    FOREIGN KEY (`idPermissionDad`)
    REFERENCES `realState`.`permission` (`idPermission`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `realState`.`user_has_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `realState`.`user_has_permission` (
  `idUser` INT NOT NULL,
  `idPermission` INT NOT NULL,
  PRIMARY KEY (`idUser`, `idPermission`),
  INDEX `fk_user_has_permission_permission1_idx` (`idPermission` ASC),
  INDEX `fk_user_has_permission_user1_idx` (`idUser` ASC),
  CONSTRAINT `fk_user_has_permission_user1`
    FOREIGN KEY (`idUser`)
    REFERENCES `realState`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_permission_permission1`
    FOREIGN KEY (`idPermission`)
    REFERENCES `realState`.`permission` (`idPermission`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
