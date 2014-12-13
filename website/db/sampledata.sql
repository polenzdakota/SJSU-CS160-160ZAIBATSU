insert into User (user_login_name,user_login_password) values('sean','1ba3d16e9881959f8c9a9762854f72c6e6321cdd44358a10a4e939033117eab9');
insert into User (user_login_name,user_login_password) values('Chris','e6c3da5b206634d7f3f3586d747ffdb36b5c675757b380c6a5fe5c570c714349');

DROP TABLE IF EXISTS `mydb`.`sean` ;

CREATE TABLE IF NOT EXISTS `mydb`.`sean` (
  `card_id` INT(11) NOT NULL DEFAULT '0',
  `quantity` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`card_id`),
  CONSTRAINT `sean_ibfk_1`
    FOREIGN KEY (`card_id`)
    REFERENCES `mydb`.`Cards` (`card_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS `mydb`.`Chris` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Chris` (
  `card_id` INT(11) NOT NULL DEFAULT '0',
  `quantity` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`card_id`),
  CONSTRAINT `Chris_ibfk_1`
    FOREIGN KEY (`card_id`)
    REFERENCES `mydb`.`Cards` (`card_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

insert into sean (card_id,quantity) values ('555','50');
insert into Chris(card_id,quantity) values ('975','80');
