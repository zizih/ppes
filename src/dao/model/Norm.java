package dao.model;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/22/13
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Norm {

    int id;
    int indexId;
    String name;

    public int getId() {
        return id;
    }

    public int getIndexId() {
        return indexId;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIndexId(int indexId) {
        this.indexId = indexId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
