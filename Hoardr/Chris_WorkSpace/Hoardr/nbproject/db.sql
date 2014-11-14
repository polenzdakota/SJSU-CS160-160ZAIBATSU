CREATE TABLE `Library` (
  `PK` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(40),
  `Type` VARCHAR(15),
  `Cost` INT,
  `Color` VARCHAR,
  PRIMARY KEY  (`PK`)
);

CREATE TABLE `Collection` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Card_Id` INT,
  `Card2_Id` INT,
  PRIMARY KEY  (`ID`)
);

CREATE TABLE `Users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR,
  `Email` VARCHAR,
  `Password` VARCHAR,
  PRIMARY KEY  (`ID`)
);

CREATE TABLE `Deck` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ID_Collection` INT,
  `User_ID` INT,.
  `ID_Library` INT,
  PRIMARY KEY  (`ID`)
);


ALTER TABLE `Collection` ADD CONSTRAINT `Collection_fk1` FOREIGN KEY (`Card_Id`) REFERENCES Library(`PK`);
ALTER TABLE `Collection` ADD CONSTRAINT `Collection_fk2` FOREIGN KEY (`Card2_Id`) REFERENCES Library(`PK`);

ALTER TABLE `Deck` ADD CONSTRAINT `Deck_fk1` FOREIGN KEY (`ID_Collection`) REFERENCES Collection(`ID`);
ALTER TABLE `Deck` ADD CONSTRAINT `Deck_fk2` FOREIGN KEY (`User_ID`) REFERENCES Users(`ID`);
ALTER TABLE `Deck` ADD CONSTRAINT `Deck_fk3` FOREIGN KEY (`ID_Library`) REFERENCES Library(`PK`);
