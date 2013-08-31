package dao;

import dao.model.Index;
import dao.model.Norm;
import dao.model.Weight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/23/13
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class NormDao {

    static NormDao instance;

    DbHelper dbHelper = DbHelper.getInstance();
    ResultSet rs;

    public NormDao(){
        //dbHelper.createNormTable();
    }

    public static NormDao getInstance(){
        if(instance == null){
            instance = new NormDao();
        }
        return instance;
    }

    public Norm getbyId(int id){
        Norm norm = new Norm();
        try{
            rs = dbHelper.st.executeQuery("select * from " + dbHelper.getNormTbName() + " where id=" + id);
            while (rs.next()) {
                norm.setId(rs.getInt("id"));
                norm.setIndexId(rs.getInt("index_id"));
                norm.setName(rs.getString("name"));
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return norm;
    }

    public boolean insert(Norm norm){
        try{
            dbHelper.st.execute("insert into " + dbHelper.getCatogoryTbName()
                    + "(name)"
                    + "values("+ norm.getName() +")"
            );
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Norm> getNorms() {
		List list = new ArrayList();
		Norm norm = new Norm();
		try {
			rs = dbHelper.st.executeQuery("select * from "
					+ dbHelper.getNormTbName());
			while (rs.next()) {
				norm.setId(rs.getInt("id"));
				norm.setIndexId(rs.getInt("index_id"));
				norm.setName(rs.getString("name"));
				list.add(norm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

}
