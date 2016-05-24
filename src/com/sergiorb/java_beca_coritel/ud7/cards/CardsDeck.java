/**
*	@file CardsDeck.java
*	@author Sergio Romero Barra
*
*	Defines a car deck to store Poker cards, shuffle them and print them.
*/

package com.sergiorb.java_beca_coritel.ud7.cards;

import java.security.SecureRandom;

public class CardsDeck {

	private PokerCard[] deck; // Card array.
	private int CARDS_NUMBER; // Deck number of cards.
	private SecureRandom randomNumbers = new SecureRandom(); // Retireve secure random number.
	
	/** Contructor */
	public CardsDeck() {
		
		// Calculates the number of cards, based on card faces and suits
		this.CARDS_NUMBER = PokerCard.getAllFaceOptions().length * 
				PokerCard.getAllSuitOptions().length;
		// Initializes deck array.
		this.deck = new PokerCard[CARDS_NUMBER];
		// Generates cards.
		this.generatePokerCards();
	}
	
	/** Constructor with cards */
	public CardsDeck(PokerCard[] cards) {
		
		this.setDeck(cards);
	}
	
	/** Generates poker cards and fill the desk */
	private void generatePokerCards() {
		
		int control = 0; // Stores array position controller.
		
		// Retrieves suits and faces from PokerCard class
		String[] suits = PokerCard.getAllSuitOptions();
		String[] faces = PokerCard.getAllFaceOptions();
		
		// Card object
		PokerCard card;
		
		// For every suit...
		for (int i = 0; i < suits.length; i++) {
			// ... and every face...
			for (int j = 0; j < faces.length; j++) {
				
				card = new PokerCard(); // Generate card.
				card.setFace(faces[j]); // Sets its face.
				card.setSuit(suits[i]); // Sets its suit.
				deck[control] = card; // Append card to desk.
				control++; // Increase array position controller.
			}
		}
	}
	
	/** @return deck getter */
	public PokerCard[] getDeck() {
		
		return this.deck;
	}
	
	/** @sets deck setter */
	public void setDeck(PokerCard[] cards) {
		
		// If new desk length is equal or smaller that CARDS_NUMBER
		if(cards.length <= CARDS_NUMBER) {
			
			this.deck = cards; // sets new card array.
			
		// if it's greater...
		} else {
			
			this.deck = null; // Sets array to null
			// Inform user
			System.out.printf("The cards limit is: %d. "
					+ "Your deck has &d\n", CARDS_NUMBER, cards.length);
		}
	}
	
	/** @method shuffle cards in deck */
	public void shuffleCards() {
		
		// For every position in the desk...
		for (int i = 0; i < deck.length; i++) {
			
			// Generate a random position from deck
			int randomIndex = randomNumbers.nextInt(CARDS_NUMBER);
			// Stores in a temporal variable current card to swap.
			PokerCard temp = deck[i];
			// Picks a random card (using randomIndex) from desk and sets it as current card.
			deck[i] = deck[randomIndex];
			// Sets the random card position as the current card.
			deck[randomIndex] = temp;
		}
	}
	
	/** @method prints deck */
	public void printDeck() {
		
		for (int i = 0; i < deck.length; i++) {
			
			System.out.printf("%s of %s \n", deck[i].getSuit(), deck[i].getFace());
		}
	}
}
