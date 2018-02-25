
package info.androidhive.expandablelistview.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Desserts {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("ppu")
    @Expose
    private Double ppu;
    @SerializedName("batters")
    @Expose
    private Batters batters;
    @SerializedName("topping")
    @Expose
    private ArrayList<Topping> topping = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPpu() {
        return ppu;
    }

    public void setPpu(Double ppu) {
        this.ppu = ppu;
    }

    public Batters getBatters() {
        return batters;
    }

    public void setBatters(Batters batters) {
        this.batters = batters;
    }

    public ArrayList<Topping> getTopping() {
        return topping;
    }

    public void setTopping(ArrayList<Topping> topping) {
        this.topping = topping;
    }

}
