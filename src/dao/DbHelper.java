package dao;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/22/13
 * Time: 2:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class DbHelper {

    static DbHelper instance;
    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    String protocol = "jdbc:derby";
    String DbName = "ppesDB";
    String tb_catogory = "ppes_catogory";
    String tb_index = "ppes_index";
    String tb_norm = "ppes_norm";
    String tb_weight = "ppes_weight";

    Connection conn;
    Statement st;

    public static DbHelper getInstance() {
        if(instance == null){
           instance = new DbHelper();
        }
        return instance;
    }

    public DbHelper() {
        try {
            Class.forName(driver).newInstance();
            this.conn = DriverManager.getConnection(protocol+":"+DbName+";create=true");
            st = conn.createStatement();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public static void init(){
        DbHelper instance = getInstance();
        instance.dropAllTable();
        if(!instance.hasTable(instance.getCatogoryTbName())) instance.createCatogoryTable();
        if(!instance.hasTable(instance.getIndexTbName())) instance.createIndexTable();
        if(!instance.hasTable(instance.getNormTbName())) instance.createNormTable();
        if(!instance.hasTable(instance.getWeightTbName())) instance.createWeightTable();
    }

    public void createCatogoryTable(){
        try {
            st.execute("create table " + tb_catogory +"("
                    + "id int primary key"
                    + ",name varchar(20) not null"
                    + ")"
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void createIndexTable(){
        try {
            st.execute("create table " + tb_index + "("
                    + "id int GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key"
                    + ",catogory_id int not null"
                    + ",name varchar(30) not null"
                    + ",constraint catogory foreign key(catogory_id) references " + tb_catogory + "(id)"
                    + ")"
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void createNormTable(){
        try {
            st.execute("create table " + tb_norm + "("
                    + "id int generated by default as identity primary key"
                    + ",index_id int"
                    + ",name varchar(20) not null"
                    + ",constraint index foreign key(index_id) references " + tb_index + "(id)"
                    + ")"
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void createWeightTable(){
        try {
            st.execute("create table " + tb_weight + "("
                    + "id int generated by default as identity primary key"
                    + ",norm_id int"
                    + ",weight int not null"
                    + ",constraint norm foreign key(norm_id) references " + tb_norm + "(id)"
                    + ")"
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void dropTable(String tbName){
        try{
            st.execute("drop table "+tbName);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean hasTable(String table){
        boolean state = false;
        try{
            if(this.conn == null){
                throw new SQLException("Connection has not been established!");
            }
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet set = meta.getTables(null, null, table.toUpperCase(), null);
            while (set.next()) {
                state = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
            state = false;
        }
        return state;
    }

    public void dropAllTable(){
        if(hasTable(getWeightTbName())) dropTable(getWeightTbName());
        if(hasTable(getNormTbName())) dropTable(getNormTbName());
        if(hasTable(getIndexTbName())) dropTable(getIndexTbName());
        if(hasTable(getCatogoryTbName())) dropTable(getCatogoryTbName());
    }

    private static void getDbSystemDir(String dbHome) {
        System.getProperty("derby.system.home");
        System.getProperty("user.dir");
    }

    public String getCatogoryTbName() {
        return tb_catogory;
    }

    public String getIndexTbName() {
        return tb_index;
    }

    public String getNormTbName() {
        return tb_norm;
    }

    public String getWeightTbName() {
        return tb_weight;
    }
}