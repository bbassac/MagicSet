package com.lioncorps.magicset.model.MasterCard;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by b.bassac on 20/04/2017.
 */
public class Power {
    private String Description;

    @JsonProperty("Description")
    public String getDescription() {
        return Description;
    }

    @JsonProperty("Description")
    public Power setDescription(String description) {
        Description = description;
        return this;
    }
}
