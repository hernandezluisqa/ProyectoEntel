package modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Equipo {
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("price")
    private double price;

    // Getters
    public String getSku() {
        return sku;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

}