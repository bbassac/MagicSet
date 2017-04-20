package com.lioncorps.magicset.model.MasterCard;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by b.bassac on 20/04/2017.
 */
public class Background {
    private String HtmlColor;

    private String Name;

    @JsonProperty("HtmlColor")
    public String getHtmlColor() {
        return HtmlColor;
    }

    @JsonProperty("HtmlColor")
    public Background setHtmlColor(String htmlColor) {
        HtmlColor = htmlColor;
        return this;
    }

    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    @JsonProperty("Name")
    public Background setName(String name) {
        Name = name;
        return this;
    }
}
