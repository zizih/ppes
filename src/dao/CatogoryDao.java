package dao;

import dao.model.Catogory;
import dao.model.Index;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/24/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class CatogoryDao {

    DbHelper dbHelper = DbHelper.getInstance();
    ResultSet rs;
    static CatogoryDao instance;

    public CatogoryDao(){
        //dbHelper.dropTable(dbHelper.getCatogoryTbName());
        //dbHelper.createCatogoryTable();
    }

    public static CatogoryDao getInstance(){
        if(instance == null){
            instance = new CatogoryDao();
        }
        return instance;
    }

    public Catogory getCatogorybyId(int id){
        Catogory catogory = new Catogory();
        try{
            rs = dbHelper.st.executeQuery("select * from " + dbHelper.getCatogoryTbName() + " where id=" + id);
            while (rs.next()) {
                catogory.setId(rs.getInt("id"));
                catogory.setName(rs.getString("name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return catogory;
    }

    public boolean insert(Catogory catogory){
        try{
            dbHelper.st.execute("insert into " + dbHelper.getCatogoryTbName()
                + "(id,name)"
                + "values("+ catogory.getId() + ",'" + catogory.getName() +"')"
            );
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Catogory> getCatogorys(){
        List list = new ArrayList();
        Catogory catogory = new Catogory();
        try{
            rs = dbHelper.st.executeQuery("select * from " + dbHelper.getCatogoryTbName());
            while (rs.next()) {
            	catogory.setId(rs.getInt("id"));
            	catogory.setName(rs.getString("name"));
                list.add(catogory);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return list;
    }

}
