
package info.androidhive.expandablelistview.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Batters {

    @SerializedName("batter")
    @Expose
    private ArrayList<Batter> batter = null;

    public List<Batter> getBatter() {
        return batter;
    }

    public void setBatter(ArrayList<Batter> batter) {
        this.batter = batter;
    }

}
