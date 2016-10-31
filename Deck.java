package B0244247;

import java.util.*;

class Deck {

	public ArrayList<Card> cards;
	public ArrayList<Card> usedCard;
	public int nUsed;

	public Deck(int nDeck) {

		cards = new ArrayList<Card>();
		usedCard= new ArrayList<Card>();
		
		for (int d = 1; d <= nDeck; d++) {

			for (Card.Suit s : Card.Suit.values()) {

				for (int r = 1; r <= 13; r++) {

					Card card = new Card(s, r);
					card.getSuit();
					card.getRank();
					cards.add(card);

				}
			}
		}
		shuffle();
	}

	public void printDeck() {
		for (Card card : cards) {
			card.printCard();
		}


	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}

	public void shuffle() {

		//cards = new ArrayList<Card>();
		
		for (int k = 0; k < usedCard.size(); k++) {
			cards.add(usedCard.get(k));
		}
	
		for (int i = 0; i < cards.size(); i++) {

			Random rnd = new Random();
			int j = rnd.nextInt(cards.size());

			Card temp = cards.get(i);
			cards.set(i, cards.get(j));
			cards.set(j, temp);
		}
		
		usedCard.clear();
		nUsed = 0;
	}


	public Card getOneCard() {
		
		
		if (cards.size() == 0) {
			shuffle();
		}
		Card card;
		card = cards.get(0);

		nUsed += 1;
		usedCard.add(card);
		cards.remove(0);

		return card;
	}
}
