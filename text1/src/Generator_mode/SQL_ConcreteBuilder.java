package Generator_mode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class SQL_ConcreteBuilder implements SQL_Bulider {
    private SQL_Product product;
    static  String JDBC_URL="jdbc:mysql://localhost:3306";
    static String USER="root";
    static String PASSWORD="qwer98kr";
    public Connection conn=null;
    private PreparedStatement pst=null;
    private ResultSet res=null;
    SQL_ConcreteBuilder(){
        listenerOne li_one=new listenerOne();
        listenerTWO li_two=new listenerTWO();
        listenerTHREE li_three=new listenerTHREE();
        listenerFOUR li_four=new listenerFOUR();
        listenerFIVE li_five=new listenerFIVE();
        product=new SQL_Product();
        product.bar=new JMenuBar();
        product.button1=new JButton("确定");
        product.textField= new JTextField(30);
        product.menu=new JMenu("菜单");
        product.item_con=new JMenuItem("链接数据库");
        product.item_cre_sql=new JMenuItem("创建数据库");
        product.item_cre_form=new JMenuItem("创建数据表");
        product.item_sea_form=new JMenuItem("查询数据表");
        product.item_del_sql=new JMenuItem("删除数据表");
        product.item_cre_sql.addActionListener(li_one);
        product.item_con.addActionListener(li_two);
        product.item_cre_form.addActionListener(li_three);
        product.item_sea_form.addActionListener(li_four);
        product.item_del_sql.addActionListener(li_five);
    }
//    public JPanel getPanel(JButton button){//SQL_Product
//        product.button=button;
//        product.add(product.textField);
//        product.menu.add(product.item_con);
//        product.menu.add(product.item_cre_sql);
//        product.menu.add(product.item_cre_form);
//        product.menu.add(product.item_sea_form);
//        product.menu.add(product.item_del_sql);
//        product.bar.add(product.menu);
//        product.add(product.bar);
//        return product;
//    }
    @Override
    public void connect_sql() {//链接数据库
        bu_lis_three Bu_lis_three=new bu_lis_three();
        product.button1.addActionListener(Bu_lis_three);
    }

    @Override
    public void create_sql() {//创建数据库
        bu_lis_four Bu_lis_four=new bu_lis_four();
        product.button1.addActionListener(Bu_lis_four);
    }

    @Override
    public void create_form() {//创建数据表
        bu_lis_two Bu_lis_two=new bu_lis_two();
            product.button1.addActionListener(Bu_lis_two);
    }

    @Override
    public void search_form() {//查询数据表
        bu_lis_one Bu_lis_one=new bu_lis_one();
            product.button1.addActionListener(Bu_lis_one);
    }

    @Override
    public void delete_form() {//删除数据表
        bu_lis_five Bu_lis_five=new bu_lis_five();
            product.button1.addActionListener(Bu_lis_five);
    }

    @Override
    public JPanel getPanel() {
//        product.button1=button;
        product.add(product.textField);
        product.menu.add(product.item_con);
        product.menu.add(product.item_cre_sql);
        product.menu.add(product.item_cre_form);
        product.menu.add(product.item_sea_form);
        product.menu.add(product.item_del_sql);
        product.bar.add(product.menu);
        product.add(product.bar);
        product.add(product.button1);
        return product;
    }
    class listenerOne implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            JButton b=new JButton("创建数据库");
//            product.button1=b;
//            product.remove(product.button1);
//            product.add(product.button1);
            product.menu=new JMenu("创建数据库");
        }
    }
    class listenerTWO implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            JButton b=new JButton("链接数据库");
//            product.button1=b;
//            product.remove(product.button1);
//            product.add(product.button1);
            product.menu=new JMenu("链接数据库");
        }
    }
    class listenerTHREE implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            JButton b=new JButton("创建数据表");
//            product.button1=b;
//            product.remove(product.button1);
//            product.add(product.button1);
            product.menu=new JMenu("创建数据表");
        }
    }
    class listenerFOUR implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            JButton b=new JButton("查询数据表");
//            product.button1=b;
//            product.remove(product.button1);
//            product.add(product.button1);
            product.menu=new JMenu("查询数据表");
        }
    }
    class listenerFIVE implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            JButton b=new JButton("删除数据表");
//            product.button1=b;
//            product.remove(product.button1);
//            product.add(product.button1);
            product.menu=new JMenu("删除数据表");
        }
    }
    public void con_sql(String text){
        try{
            conn= DriverManager.getConnection(JDBC_URL+"/"+text,USER,PASSWORD);
            System.out.println("链接成功");
        }
        catch(Exception e){
            System.out.println("链接失败");
            e.printStackTrace();
        }
    }
    public void cre_sql(String text){
        try{
            Statement stat=conn.createStatement();
            stat.executeUpdate("create database "+text);
            System.out.println("数据库创建成功");
            stat.close();
        }
        catch (Exception e){
            System.out.println("数据库创建失败");
        }
    }
    public void cre_form_sql(String text){
        try{
            Statement stat=conn.createStatement();
            stat.executeUpdate("create table "+text);
            System.out.println("数据表创建成功");
        }
        catch (Exception e){
            System.out.println("数据表创建失败");
        }
    }
    public void sea_sql(String text){
        try{
            Statement stat=conn.createStatement();
            res=stat.executeQuery("select * from "+text);
            while (res.next())
            {
                System.out.println(res);
            }
        }
        catch (Exception e){
            System.out.println("查询失败");
        }
    }
    public void del_sql(String text){
        try{
            Statement stat=conn.createStatement();
            stat.executeUpdate("delete table "+text);
            System.out.println("数据表删除成功");
        }
        catch (Exception e){
            System.out.println("数据表删除失败");
        }
    }
    class bu_lis_one implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField te=product.textField;
            if(product.menu.getText()=="查询数据表"){
                String text=te.getText();
                sea_sql(text);
            }
        }
    }
    class bu_lis_two implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField te=product.textField;
            if(product.menu.getText()=="创建数据表"){
                String text=te.getText();
                cre_form_sql(text);
            }
        }
    }
    class bu_lis_three implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField te=product.textField;
            if(product.menu.getText()=="链接数据库"){
                String text=te.getText();
                con_sql(text);
            }
        }
    }
    class bu_lis_four implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField te=product.textField;
            if(product.menu.getText()=="创建数据库"){
                String text=te.getText();
                cre_sql(text);
            }
        }
    }
    class bu_lis_five implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField te=product.textField;
            if(product.menu.getText()=="删除数据表"){
                String text=te.getText();
                del_sql(text);
            }
        }
    }
}
