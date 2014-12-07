/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * This class holds all variables used in a card
 *
 * @author Dakota
 */
public class Card {

    private String name;
    private String id;
    private String color;
    private String cost;
    private String superType;
    private String types;
    private String subTypes;
    private String text;
    private String power;
    private String toughness;
    private String image;
    private String cmc;
    private String loyalty;

    /**
     * Constructs variables used in Card
     */
    public Card() {
        //TODO add actual code
        name = "Ajani Steadfast";
        id = "00001";
        color = "White";
        cost = "4";
        superType = "Planeswalker";
        types = "";
        subTypes = "Ajani";
        text = "FUCK";
        power = "4";
        toughness = "0";
        image = "Images/CardPictures/AjaniSteadfast.jpg";
        cmc = "4";
    }

    Card(String name, int id, int colors, String card_cost, int card_cmc, String card_supertypes, String card_cardtypes, String card_subtypes, String card_text, String card_power, String card_toughness, String card_loyalty, String image) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public String getName() {
        return name;
    }

    public String getCardID() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getCMC() {
        return cmc;
    }

    public String getCost() {
        return cost;
    }

    public String getSuperTypes() {
        return superType;
    }

    public String getTypes() {
        return types;
    }

    public String getSubTypes() {
        return subTypes;
    }

    public String getText() {
        return text;
    }

    public String getPower() {
        return power;
    }

    public String getToughness() {
        return toughness;
    }

    public String getImageURL() {
        return image;
    }
    
    public String getLoyalty() {
        return loyalty;
    }
}
