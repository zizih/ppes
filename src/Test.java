import dao.CatogoryDao;
import dao.DbHelper;
import dao.IndexDao;
import dao.NormDao;
import view.MainWindow;
import dao.model.*;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/22/13
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    static  Gson gson = new Gson();

    String[] catos = new String[]{
            "农业机械化科研课题绩效评价指标体系",
            "农业机械化示范基地项目绩效评价指标体系",
            "区域性农业机械推广站建设项目绩效评价指标体系"
    };
    String[] indexs = new String[]{
            "一级指标",
            "二级指标"
    };
    String[] norm1 = new String[]{
            "基本指标（A）",
            "绩效指标（B）",
            "科研条件（C）",
            "完成情况（D）",
            "发展潜力（E）"
    };

    public static void main1(String[] args){

    	new MainWindow("Test");

    }


    public static void main(String[] args){

    	/*Catogory catogory = new Catogory();
    	catogory.setId(1);
    	catogory.setName("农业机械化科研课题绩效评价指标体系");
    	CatogoryDao.getInstance().insert(catogory);


        System.out.println(gson.toJson(CatogoryDao.getInstance().getCatogorys()));

        Index index = new Index();
        index.setName("一级指标");
        index.setCatoryId(1);
        IndexDao.getInstance().insert(index);

        Index index2 = new Index();
        index.setName("二级指标");
        index.setCatoryId(1);
        IndexDao.getInstance().insert(index);*/
        System.out.println(gson.toJson(IndexDao.getInstance().getIndexs()));
        System.out.println(gson.toJson(IndexDao.getInstance().getIndexByCatogoryId(1)));

        /*Norm norm = new Norm();
        norm.setIndexId(1);
        norm.setName("基本指标");
        NormDao.getInstance().insert(norm);
        System.out.println(gson.toJson(NormDao.getInstance().getNorms()));*/


    }
}
