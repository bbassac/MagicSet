package com.lioncorps.magicset.model.MasterCard;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by b.bassac on 04/04/2017.
 */
public class Card {
   private String Attack;
   private Background Background;
   private String Chakra;
   private String Citation;
   private String Comments;
   private int Count;
   private String Cost;
   private String Defense;
   private String Element;
   private String Kind;
   private String Name;
   private String Rank;
   private String Team;
   private List<Power> powers;

   @JsonProperty("Attack")
    public String getAttack() {
        return Attack;
    }
    @JsonProperty("Attack")
    public void setAttack(String attack) {
        Attack = attack;
    }

    @JsonProperty("Background")
    public Background getBackground() {
        return Background;
    }
    @JsonProperty("Background")
    public void setBackground(Background background) {
        Background = background;
    }

    @JsonProperty("Chakra")
    public String getChakra() {
        return Chakra;
    }
    @JsonProperty("Chakra")
    public void setChakra(String chakra) {
        Chakra = chakra;
    }

    @JsonProperty("Citation")
    public String getCitation() {
        return Citation;
    }
    @JsonProperty("Citation")
    public void setCitation(String citation) {
        Citation = citation;
    }

    @JsonProperty("Comments")
    public String getComments() {
        return Comments;
    }
    @JsonProperty("Comments")
    public void setComments(String comments) {
        Comments = comments;
    }

    @JsonProperty("Count")
    public int getCount() { return Count;  }
    @JsonProperty("Count")
    public void setCount(int count) { Count = count;    }

    @JsonProperty("Cost")
    public String getCost() {
        return Cost;
    }
    @JsonProperty("Cost")
    public void setCost(String cost) {
        Cost = cost;
    }

    @JsonProperty("Defense")
    public String getDefense() {
        return Defense;
    }
    @JsonProperty("Defense")
    public void setDefense(String defense) {
        Defense = defense;
    }

    @JsonProperty("Element")
    public String getElement() {
        return Element;
    }
    @JsonProperty("Element")
    public void setElement(String element) {
        Element = element;
    }

    @JsonProperty("Kind")
    public String getKind() {
        return Kind;
    }
    @JsonProperty("Kind")
    public void setKind(String kind) {
        Kind = kind;
    }

    @JsonProperty("Name")
    public String getName() {
        return Name;
    }
    @JsonProperty("Name")
    public void setName(String name) {
        Name = name;
    }

    @JsonProperty("Rank")
    public String getRank() {
        return Rank;
    }
    @JsonProperty("Rank")
    public void setRank(String rank) {
        Rank = rank;
    }

    @JsonProperty("Team")
    public String getTeam() {
        return Team;
    }
    @JsonProperty("Team")
    public void setTeam(String team) {
        Team = team;
    }

    @JsonProperty("Powers")
    public List<Power> getPowers() {
        return powers;
    }
    @JsonProperty("Powers")
    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }
}
