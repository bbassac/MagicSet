package model;

/**
 * Created by b.bassac on 04/04/2017.
 */
public class Card {
    private String hasStyling;
    private String notes;
    private String timeCreated;
    private String timeModified;
    private String borderColor;
    private String cardColor;
    private String name;
    private String castingCost;
    private String image;
    private String superType;
    private String subType;
    private String rarity;
    private String ruleText;
    private String flavorText;
    private String power;
    private String toughness;
    private String copyright;
    private String image2;
    private String superType2;
    private String subType2;
    private String copyright2;
    private static String CRLF = System.getProperty("line.separator");

    public Card(String hasStyling, String notes,String borderColor, String cardColor, String name, String castingCost, String image, String superType, String subType, String rarity, String ruleText, String flavorText, String power, String toughness, String copyright) {
        this.hasStyling = hasStyling;
        this.notes = notes;
        this.timeCreated = "2017-03-02 14:40:21";
        this.timeModified = "2017-03-02 14:46:52";
        this.borderColor = borderColor;
        this.cardColor = cardColor;
        this.name = name;
        this.castingCost = castingCost;
        this.image = image;
        this.superType = superType;
        this.subType = subType;
        this.rarity = rarity;
        this.ruleText = ruleText;
        this.flavorText = flavorText;
        this.power = power;
        this.toughness = toughness;
        this.copyright = copyright;
        this.image2 = image2;
        this.superType2 = superType2;
        this.subType2 = subType2;
        this.copyright2 = copyright2;
    }

    @Override
    public String toString() {
        return "card:" +CRLF+
                 "\thas styling: "+ hasStyling + CRLF+
                 "\tnotes: "+ notes   +CRLF+
                 "\ttime created: "+ timeCreated +CRLF+
                 "\ttime modified: "+ timeModified   +CRLF+
                 "\tborder color: "+ borderColor   +CRLF+
                 "\tcard color: "+ cardColor   +CRLF+
                 "\tname: "+ name   +CRLF+
                 "\tcasting cost: "+ castingCost   +CRLF+
                 "\timage: "+ image   +CRLF+
                 "\tsuper type: "+ superType   +CRLF+
                 "\tsub type: "+ subType   +CRLF+
                 "\trarity: "+ rarity   +CRLF+
                 "\trule text: "+ ruleText   +CRLF+
                 "\tflavor text: "+ flavorText   +CRLF+
                 "\tpower: "+ power   +CRLF+
                 "\ttoughness: "+ toughness   +CRLF+
                 "\tcopyright: "+ copyright   +CRLF+
                 "\timage 2: "+ image2   +CRLF+
                 "\tsuper type 2: "+ superType2   +CRLF+
                 "\tsub type 2: "+ subType2   +CRLF+
                 "\tcopyright 2: "+ copyright2   +CRLF+
                "";
    }

    public String getHasStyling() {
        return hasStyling;
    }

    public void setHasStyling(String hasStyling) {
        this.hasStyling = hasStyling;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(String timeModified) {
        this.timeModified = timeModified;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCastingCost() {
        return castingCost;
    }

    public void setCastingCost(String castingCost) {
        this.castingCost = castingCost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSuperType() {
        return superType;
    }

    public void setSuperType(String superType) {
        this.superType = superType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getRuleText() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getSuperType2() {
        return superType2;
    }

    public void setSuperType2(String superType2) {
        this.superType2 = superType2;
    }

    public String getSubType2() {
        return subType2;
    }

    public void setSubType2(String subType2) {
        this.subType2 = subType2;
    }

    public String getCopyright2() {
        return copyright2;
    }

    public void setCopyright2(String copyright2) {
        this.copyright2 = copyright2;
    }


}
