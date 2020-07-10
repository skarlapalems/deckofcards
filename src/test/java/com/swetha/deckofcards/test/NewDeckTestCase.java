package com.swetha.deckofcards.test;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swetha.deckofcards.model.Deck;
import com.swetha.deckofcards.service.DeckService;

public class NewDeckTestCase {

	
	@Test
	public void createDeckTest() {
		
		log("Starting createDeckTest ...");
		
		Deck deck = DeckService.createNewDeck(1, false);
		assertEquals(deck.getStatusCode(), 200);
		//deck should have 52 cards without jokers
		assertEquals(deck.getRemaining(), 52);
		log("Deck Code: "+deck.getDeck_id());
	}
	
	@Test
	public void createDeckWithJokerTest() {
		
		log("Starting createDeckWithJokerTest ...");
		
		Deck deck = DeckService.createNewDeck(1, true);
		assertEquals(deck.getStatusCode(), 200);
		//deck should have 54 cards with jokers
		assertEquals(deck.getRemaining(), 54);
		log("Deck Code: "+deck.getDeck_id());
	}
	
	private void log(String msg) {
	
		Reporter.log(msg,true);
	}

	@Parameters({ "deck-count" })
	@Test
	public void createMultiDeckTest(int deckCount) {
		
		log("Starting createMultiDeckTest ...");
		
		Deck deck = DeckService.createNewDeck(deckCount, false);
		assertEquals(deck.getStatusCode(), 200);
		//deck should have 52 cards without jokers
		assertEquals(deck.getRemaining(), deckCount*52);
		log("Deck Code: "+deck.getDeck_id());
	}

}
