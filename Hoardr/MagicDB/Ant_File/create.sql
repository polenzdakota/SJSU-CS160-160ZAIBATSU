-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cards`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cards` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Cards` (
  `card_id` INT NOT NULL,
  `card_name` VARCHAR(180) NULL,
  `card_cost` VARCHAR(45) NULL,
  `card_cmc` INT NULL,
  `card_colors` INT NULL,
  `card_supertypes` VARCHAR(45) NULL,
  `card_cardtypes` VARCHAR(45) NULL,
  `card_subtypes` VARCHAR(45) NULL,
  `card_text` TEXT(760) NULL,
  `card_power` VARCHAR(45) NULL,
  `card_toughness` VARCHAR(45) NULL,
  `card_loyalty` VARCHAR(45) NULL,
  `card_image_location` VARCHAR(45) NULL,
  PRIMARY KEY (`card_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Deck`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Deck` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Deck` (
  `deck_id` INT NOT NULL,
  `deck_card_id` INT NULL,
  `deck_collection_id` INT NULL,
  `card_is_in_collection` TINYINT(1) NULL,
  PRIMARY KEY (`deck_id`),
  INDEX `collection_id_idx` (`deck_collection_id` ASC),
  INDEX `card_id_idx` (`deck_card_id` ASC),
  CONSTRAINT `collection_id`
    FOREIGN KEY (`deck_collection_id`)
    REFERENCES `mydb`.`Collection` (`collection_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `card_id`
    FOREIGN KEY (`deck_card_id`)
    REFERENCES `mydb`.`Cards` (`card_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`UserDecks`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`UserDecks` ;

CREATE TABLE IF NOT EXISTS `mydb`.`UserDecks` (
  `userdecks_id` INT NOT NULL,
  `userdecks_deck_id` INT NULL,
  PRIMARY KEY (`userdecks_id`),
  INDEX `deck_id_idx` (`userdecks_deck_id` ASC),
  CONSTRAINT `deck_id`
    FOREIGN KEY (`userdecks_deck_id`)
    REFERENCES `mydb`.`Deck` (`deck_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Collection`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Collection` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Collection` (
  `collection_id` INT NOT NULL,
  `collection_card_id` INT NULL,
  `quantity` INT NULL,
  `collection_userdecks_id` INT NULL,
  PRIMARY KEY (`collection_id`),
  INDEX `userdecks_id_idx` (`collection_userdecks_id` ASC),
  CONSTRAINT `userdecks_id`
    FOREIGN KEY (`collection_userdecks_id`)
    REFERENCES `mydb`.`UserDecks` (`userdecks_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`User` ;

CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `user_id` INT NOT NULL,
  `user_collection_id` INT NULL,
  `user_login_name` VARCHAR(45) NULL,
  `user_login_password` VARCHAR(45) NULL,
  `user_userdecks_id` INT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `collection_id_idx` (`user_collection_id` ASC),
  INDEX `userdecks_id_idx` (`user_userdecks_id` ASC),
  CONSTRAINT `user_collection_id`
    FOREIGN KEY (`user_collection_id`)
    REFERENCES `mydb`.`Collection` (`collection_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_userdecks_id`
    FOREIGN KEY (`user_userdecks_id`)
    REFERENCES `mydb`.`UserDecks` (`userdecks_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
