package dao;


/**
 * Created with IntelliJ IDEA.
 * User: rain
 * Date: 3/24/13
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class DBServer {

	public static void main(String[] args){
        DbHelper.init();
        System.out.println("db is ready!");
    }

}
