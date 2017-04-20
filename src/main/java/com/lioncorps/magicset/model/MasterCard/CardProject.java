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


    private String ImagesDirectory = "F:\\\\Programmation\\\\VBA\\\\Cartes Bruno\\\\Cartes\\\\Images";


    private String TexturesDirectory = "F:\\\\Programmation\\\\VBA\\\\Cartes Bruno\\\\Cartes\\\\Textures";

    @JsonProperty("Cards")
    public List<Card> getCards() {
        return Cards;
    }
    @JsonProperty("Cards")
    public CardProject setCards(List<Card> cards) {
        Cards = cards;
        return this;
    }
    @JsonProperty("ImagesDirectory")
    public String getImagesDirectory() {
        return ImagesDirectory;
    }

    @JsonProperty("ImagesDirectory")
    public CardProject setImagesDirectory(String imagesDirectory) {
        ImagesDirectory = imagesDirectory;
        return this;
    }

    @JsonProperty("TexturesDirectory")
    public String getTexturesDirectory() {
        return TexturesDirectory;
    }

    @JsonProperty("TexturesDirectory")
    public CardProject setTexturesDirectory(String texturesDirectory) {
        TexturesDirectory = texturesDirectory;
        return this;
    }
}
