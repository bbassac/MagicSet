package com.lioncorps.magicset.model.MasterCard;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by b.bassac on 20/04/2017.
 */
public class CardProject {

    public CardProject(){
        Cards = new ArrayList<>();
    }
    private List<Card> Cards;

    @JsonProperty("Cards")
    public List<Card> getCards() {
        return Cards;
    }
    @JsonProperty("Cards")
    public CardProject setCards(List<Card> cards) {
        Cards = cards;
        return this;
    }

}
