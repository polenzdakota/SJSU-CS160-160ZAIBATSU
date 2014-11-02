SELECT * FROM USERS;
SELECT * FROM LIBRARY;
SELECT * FROM COLLECTION1;
SELECT * FROM DECK;
SELECT * FROM COLLECTION_LINK;




#Select Collection_ID from USERS,COLLECTION1 WHERE Username ='Chris is dumb' and Collection_ID ='1'; #Find the Collection ID of One particular user

#Query will return Card_name of all the instances of that card in the users collection
Select Card_Name, COLLECTION1.LIBRARY_ID from Users,COLLECTION1,LIBRARY where LIBRARY.LIBRARY_ID = COLLECTION1.LIBRARY_ID and Username ='Chris is dumb'; 

Select Username,count(COLLECTION_ID) from Users,DECK where USERS.USER_ID=Deck.USER_ID; #count how many cards are in the deck

SELECT order_id,product_name,qty FROM orders
INTO OUTFILE '/tmp/orders.txt'











