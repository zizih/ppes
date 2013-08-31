package dao.model;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/22/13
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Weight {

    int id;
    int normId;
    int weight;

    public int getNormId() {
        return normId;
    }

    public int getWeight() {
        return weight;
    }

    public void setNormId(int normId) {
        this.normId = normId;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
