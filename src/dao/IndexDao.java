package dao;

import java.sql.*;
import dao.model.Index;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/23/13
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class IndexDao {

    static IndexDao instance;

    DbHelper dbHelper = DbHelper.getInstance();
    ResultSet rs;

    public IndexDao(){
        //dbHelper.dropTable(dbHelper.getIndexTbName());
        //dbHelper.createIndexTable();
    }

    public static IndexDao getInstance(){
        if(instance == null){
           instance = new IndexDao();
        }
        return instance;

    }

    public Index getIndexbyId(int id){
        Index index = new Index();
        try{
            rs = dbHelper.st.executeQuery("select * from " + dbHelper.getIndexTbName() + " where id=" + id);
            while (rs.next()) {
                index.setId(rs.getInt("id"));
                index.setCatoryId(rs.getInt("catogory_id"));
                index.setName(rs.getString("name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return index;
    }

    public boolean insert(Index index){
        try{
            dbHelper.st.execute("insert into " + dbHelper.getIndexTbName()
                    + "(catogory_id, name) "
                    + "values("+ index.getCatogoryId() + ","
                         + "'" + index.getName() + "'"
                               + ")"
            );
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Index> getIndexByCatogoryId(int catogoryId){
        List list = new ArrayList();
        Index index;
        try{
            rs = dbHelper.st.executeQuery("select * from " + dbHelper.getIndexTbName() + " where catogory_id=" + catogoryId);
            while (rs.next()) {
                index = new Index();
                index.setId(rs.getInt("id"));
                index.setCatoryId(rs.getInt("catogory_id"));
                index.setName(rs.getString("name"));
                list.add(index.getId(),index);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return list;
    }

    public List<Index> getIndexs(){
        List list = new ArrayList();
        Index index = new Index();
        try{
            rs = dbHelper.st.executeQuery("select * from " + dbHelper.getIndexTbName());
            while (rs.next()) {
                index.setId(rs.getInt("id"));
                index.setCatoryId(rs.getInt("catogory_id"));
                index.setName(rs.getString("name"));
                list.add(index);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return list;
    }

}
