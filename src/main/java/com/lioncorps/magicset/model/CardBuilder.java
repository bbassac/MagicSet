package com.lioncorps.magicset.model;

/**
 * Created by b.bassac on 04/04/2017.
 */
public class CardBuilder {
    private Card card;

    private CardBuilder(String cardName) {
        card = new Card();
        card.setName(cardName);
    }

    public static CardBuilder newCard(String cardName) {
        return new CardBuilder(cardName);
    }

    public Card build() {
        return this.card;
    }

    public CardBuilder hasStyle(String hasStyling) {
        this.card.setHasStyling(hasStyling);
        return this;
    }

    public CardBuilder notes(String notes) {
        this.card.setNotes(notes);
        return this;
    }

    public CardBuilder borderColor(String borderColor) {
        this.card.setBorderColor(borderColor);
        return this;
    }

    public CardBuilder cardColor(String cardColor) {
        this.card.setCardColor(cardColor);
        return this;
    }

    public CardBuilder castingCost(String castingCost) {
        this.card.setCastingCost(castingCost);
        return this;
    }

    public CardBuilder image(String image) {
        this.card.setImage(image);
        return this;
    }

    public CardBuilder superType(String superType) {
        this.card.setSuperType(superType);
        return this;
    }

    public CardBuilder subType(String subType) {
        this.card.setSubType(subType);
        return this;
    }

    public CardBuilder rarity(String rarity) {
        this.card.setRarity(rarity);
        return this;
    }

    public CardBuilder ruleText(String ruleText) {
        this.card.setRuleText(ruleText);
        return this;
    }

    public CardBuilder flavorText(String flavorText) {
        this.card.setFlavorText(flavorText);
        return this;
    }

    public CardBuilder power(String power) {
        this.card.setPower(power);
        return this;
    }

    public CardBuilder toughness(String toughness) {
        this.card.setToughness(toughness);
        return this;
    }

    public CardBuilder copyright(String copyright) {
        this.card.setCopyright(copyright);
        return this;
    }

    public CardBuilder subType2(String subType2) {
        this.card.setSubType2(subType2);
        return this;
    }

    public CardBuilder superType2(String superSubType2) {
        this.card.setSuperType2(superSubType2);
        return this;
    }

    public CardBuilder cardType(String cardType){
        this.card.setCardType(cardType);
        return this;
    }
}
