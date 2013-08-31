package dao.model;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/22/13
 * Time: 8:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Index {

    int id;
    int catogoryId;
    String name;

    public int getId() {
        return id;
    }

    public int getCatogoryId() {
        return catogoryId;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCatoryId(int catoryId) {
        this.catogoryId = catoryId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
