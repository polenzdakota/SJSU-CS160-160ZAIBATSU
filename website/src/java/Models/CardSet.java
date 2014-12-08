package Models;

import java.util.*;
import java.sql.*;

public class CardSet {
	private HashMap<Card, Integer> cards;
	
	public CardSet() {
		cards = new HashMap<Card,Integer>();
	}
	
	public CardSet(HashMap<Card,Integer> cards) {
		this.cards = cards;
	}
	
	public int getQuantity(Card card) {
		if (cards.containsKey(card)) {
			return cards.get(card);
		}
		return 0;
	}
	
	public List<Card> listCards() {
		ArrayList<Card> cardList = new ArrayList<Card>();
		for(Map.Entry<Card, Integer> entry : cards.entrySet()) {
			cardList.add(entry.getKey());
		}
		return cardList;
	}

}
