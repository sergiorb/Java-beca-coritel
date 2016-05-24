/**
*	@file TestDeck.java
*	@author Sergio Romero Barra
*
*	Test CardsDeck and PokerCard classes.
*/

package com.sergiorb.java_beca_coritel.ud7.cards;

// Main Class
public class TestCards {

	// Main method
	public static void main(String[] args) {
		
		// Instantiate a deck object.
		CardsDeck deck = new CardsDeck();
		
		deck.shuffleCards(); // Shuffle cards
		deck.printDeck(); // Prints deck
		
		System.out.println("\n---------------------\n");
		
		PokerCard card = deck.dealCard(); // Deal a card
		System.out.println(card.toString());
		
		card = deck.dealCard(); // Deal a new card
		System.out.println(card.toString());
		
		card = deck.dealCard(); // Deal a new card
		System.out.println(card.toString());
		
	}

}
