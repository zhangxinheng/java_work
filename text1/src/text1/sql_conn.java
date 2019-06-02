package text1;
import jdk.nashorn.internal.scripts.JD;
import java.rmi.server.ExportException;
import java.sql.*;
public class sql_conn {
    static  String JDBC_URL="jdbc:mysql://localhost:3306";
    static String USER="root";
    static String PASSWORD="qwer98kr";
    public Connection conn=null;
    private PreparedStatement pst=null;
    private ResultSet res=null;
    public void sql(){
        try{
            conn=DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
            System.out.println("链接成功");
        }
        catch(Exception e){
            System.out.println("链接失败");
            e.printStackTrace();
        }
    }
    public void create_sql()//      创建数据库
    {
       try{
           Statement stat=conn.createStatement();
        stat.executeUpdate("create database text");
        System.out.println("数据库创建成功");
        stat.close();
    }
       catch (Exception e){
           System.out.println("数据库创建失败");
       }
   }
   public void connect_sql(){//链接到新的数据库
        try{
            conn.close();
            JDBC_URL="jdbc:mysql://localhost:3306/text";
            conn=DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
            System.out.println("链接新数据库成功");
        }
        catch (Exception e){
            System.out.println("链接新数据库失败") ;
        }
   }
   public void create_form(){
        try{
            Statement stat=conn.createStatement();
            stat.executeUpdate("create table text (id int, name varchar(80))");
            stat.executeUpdate("insert into test values(1, '张三')");
            stat.executeUpdate("insert into test values(2, '李四')");
            System.out.println("数据表创建成功,并已经插入数据");
        }
        catch (Exception e){
            System.out.println("数据表创建失败");
        }
   }
   public void select_form(){//查询数据
        try{
            Statement stat=conn.createStatement();
            res=stat.executeQuery("select * from text");
            while (res.next())
            {
                System.out.println(res.getInt("id") + " " + res.getString("name"));
            }

        }
        catch (Exception e){
            System.out.println("查询失败");
        }
   }
}
