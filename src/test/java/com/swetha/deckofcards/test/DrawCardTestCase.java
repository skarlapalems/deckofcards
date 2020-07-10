package com.swetha.deckofcards.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.swetha.deckofcards.model.Deck;
import com.swetha.deckofcards.service.DeckService;

public class DrawCardTestCase {

	@Test
	public void drawCardTest() {
		
		log("Starting drawCardTest ...");
		
		Deck deck = DeckService.createNewDeck(1, false);
		Assert.assertNotNull(deck);
		
		int drawCount = 1;
		
		Deck cards = DeckService.drawCard(deck.getDeck_id(), drawCount);
		assertEquals(cards.getStatusCode(), 200);
		assertEquals(cards.getDeck_id(), deck.getDeck_id());
		assertEquals(cards.getCards().size(), drawCount);
		
		drawCount = 5;
		
		cards = DeckService.drawCard(deck.getDeck_id(), drawCount);
		assertEquals(cards.getStatusCode(), 200);
		assertEquals(cards.getDeck_id(), deck.getDeck_id());
		assertEquals(cards.getCards().size(), drawCount);
	}

	private void log(String msg) {
		
		Reporter.log(msg,true);
	}

}
