/**
*	@file PokerCard.java
*	@author Sergio Romero Barra
*
*	Defines a poker card object. Can store its suit and face.
*	It has two static method to retrieve suit and face options.
*/

package com.sergiorb.java_beca_coritel.ud7.cards;

public class PokerCard {

	private String suit; // Card suit.
	private String face; // Card face.
	// Suit options for Poker cards.
	private final static String[] suitOptions = {"Ace", "Deuce", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King",};
	// Face options for Poker cards.
	private final static String[] faceOptions = {"Hearts", "Diamonds", "Clubs", "Spades"};
	
	 /** @return the face */ 
	public String getFace() {
		return face;
	}
	
	/** @param face the face to set */
	public void setFace(String face) {
		this.face = face;
	}
	
	/**  @return the suit */
	public String getSuit() {
		return suit;
	}
	
	/** @param suit the suit to set */
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	/** @return all suit options */
	public static String[] getAllSuitOptions() {
		return suitOptions;
	}
	
	/** @ return all face options */
	public static String[] getAllFaceOptions() {
		return faceOptions;
	}
}
