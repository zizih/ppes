package dao;

import dao.model.Catogory;
import dao.model.Index;
import dao.model.Weight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: rain Date: 3/23/13 Time: 11:14 PM To change
 * this template use File | Settings | File Templates.
 */
public class WeightDao {

	static WeightDao instance;
	DbHelper dbHelper = DbHelper.getInstance();
	ResultSet rs;

	public WeightDao() {
		//dbHelper.createWeightTable();
	}

	public static WeightDao getInstance() {
		if (instance == null) {
			instance = new WeightDao();
		}
		return instance;
	}

	public Weight getbyId(int id) {
		Weight weight = new Weight();
		try {
			rs = dbHelper.st.executeQuery("select * from "
					+ dbHelper.getWeightTbName() + " where id=" + id);
			while (rs.next()) {
				weight.setId(rs.getInt("id"));
				weight.setNormId(rs.getInt("norm_id"));
				weight.setWeight(rs.getInt("weight"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return weight;
	}

	public boolean insert(Weight weight) {
		try {
			dbHelper.st.execute("insert into " + dbHelper.getCatogoryTbName()
					+ "(norm_id,weight)" + "values(" + weight.getNormId() + ","
					+ weight.getWeight() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Weight> getCatogorys() {
		List list = new ArrayList();
		Weight weight = new Weight();
		try {
			rs = dbHelper.st.executeQuery("select * from "
					+ dbHelper.getCatogoryTbName());
			while (rs.next()) {
				weight.setId(rs.getInt("id"));
				weight.setNormId(rs.getInt("norm_id"));
				weight.setWeight(rs.getInt("weight"));
				list.add(weight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

}
