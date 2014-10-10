DROP TABLE DECK;
DROP TABLE COLLECTION;
DROP TABLE USERS;
DROP TABLE LIBRARY;

SHOW TABLES;

LOAD DATA LOCAL INFILE 'C:\\Users\\Chris\\Documents\\MagicDB\\users.txt' INTO TABLE USERS;
LOAD DATA LOCAL INFILE 'C:\\Users\\Chris\\Documents\\MagicDB\\samplelibrary.txt' INTO TABLE LIBRARY;
LOAD DATA LOCAL INFILE 'C:\\Users\\Chris\\Documents\\MagicDB\\collection.txt' INTO TABLE COLLECTION1;
LOAD DATA LOCAL INFILE 'C:\\Users\\Chris\\Documents\\MagicDB\\deck.txt' INTO TABLE DECK;
#LOAD DATA LOCAL INFILE 'C:\\Users\\Chris\\Documents\\MagicDB\\collection_link.txt' INTO TABLE COLLECTION_LINK;