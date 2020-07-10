package com.swetha.deckofcards.service;

import com.swetha.deckofcards.model.Deck;
import com.swetha.deckofcards.util.DataUtil;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class DeckService {

	public static Deck createNewDeck(int decks,boolean withJoker) {
		
		if(withJoker) {
		
			//with joker using POST
			//POST is failing as it is getting CSRF error.
			Response response = 
					given()
						.param("deck_count",decks)
						.param("jokers_enabled", withJoker)
					.when()
						.post(DataUtil.getValue("api.newdeck"));
			
			
			Deck deck = response.as(Deck.class);
			deck.setStatusCode(response.getStatusCode());
			
			return deck;
			
		}else {
			
			//no joker using GET
			
			Response response = 
					given()
						.param("deck_count",decks)
					.when()
						.get(DataUtil.getValue("api.newdeck"));
			
			Deck deck = response.as(Deck.class);
			deck.setStatusCode(response.getStatusCode());
			
			return deck;
		}
		
	}
	
	
	public static Deck drawCard(String deckId, int count) {
		
		Response response = 
				given()
					.param("count", count)
					.pathParam("deckId", deckId)
				.when()
					.get(DataUtil.getValue("api.draw"));
		
		Deck deck = response.as(Deck.class);
		deck.setStatusCode(response.getStatusCode());
		
		return deck;
	}
	
}
