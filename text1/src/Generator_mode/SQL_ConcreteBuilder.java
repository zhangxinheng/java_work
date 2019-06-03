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
        listenerSIX li_six=new listenerSIX();
        product=new SQL_Product();
        product.bar=new JMenuBar();
        product.button1=new JButton("确定");
        product.textArea= new JTextArea(4,30);
        product.textField=new JTextField(10);
        product.menu=new JMenu("菜单");
        product.item_con=new JMenuItem("链接数据库");
        product.item_cre_sql=new JMenuItem("创建数据库");
        product.item_cre_form=new JMenuItem("创建数据表");
        product.item_sea_form=new JMenuItem("查询数据表");
        product.item_del_sql=new JMenuItem("删除数据表");
        product.item_ins_form=new JMenuItem("插入数据表");
        product.item_cre_sql.addActionListener(li_one);
        product.item_con.addActionListener(li_two);
        product.item_cre_form.addActionListener(li_three);
        product.item_sea_form.addActionListener(li_four);
        product.item_del_sql.addActionListener(li_five);
        product.item_ins_form.addActionListener(li_six);
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
    public void ins_sql_form() {
        bu_lis_six Bu_lis_six=new bu_lis_six();
        product.button1.addActionListener(Bu_lis_six);
    }

    @Override
    public JPanel getPanel() {
//        product.button1=button;
        product.add(product.textArea);
        product.add(product.textField);
        product.menu.add(product.item_con);
        product.menu.add(product.item_cre_sql);
        product.menu.add(product.item_cre_form);
        product.menu.add(product.item_sea_form);
        product.menu.add(product.item_del_sql);
        product.menu.add(product.item_ins_form);
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
    class listenerSIX implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            product.menu=new JMenu("插入数据表");
        }
    }
    public void con_sql(String text){
        try{
            conn= DriverManager.getConnection(JDBC_URL+"/"+text,USER,PASSWORD);
            JOptionPane.showMessageDialog(null, "链接成功", "", JOptionPane.INFORMATION_MESSAGE);

            System.out.println("链接成功");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "出错啦!检查是否有此数据库", "", JOptionPane.ERROR_MESSAGE);
            System.out.println("链接失败");
            e.printStackTrace();
        }
    }
    public void cre_sql(String text){
        try{
            Statement stat=conn.createStatement();
            stat.executeUpdate("create database "+text);
            JOptionPane.showMessageDialog(null, "数据库创建成功", "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("数据库创建成功");
            stat.close();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "出错啦!检查是否重复创建", "", JOptionPane.ERROR_MESSAGE);
            System.out.println("数据库创建失败");
        }
    }
    public void cre_form_sql(String text){
        try{
            Statement stat=conn.createStatement();
            stat.executeUpdate("create table "+text);
            JOptionPane.showMessageDialog(null, "数据表创建成功", "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("数据表创建成功");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "数据表创建失败", "", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "数据表删除成功", "", JOptionPane.INFORMATION_MESSAGE);

            System.out.println("数据表删除成功");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "数据表删除失败", "", JOptionPane.ERROR_MESSAGE);
            System.out.println("数据表删除失败");
        }
    }
    public void ins_form(String text1,String text2){
        try{
            Statement stat=conn.createStatement();
            stat.executeUpdate("insert into "+text2+" values"+text1);

            JOptionPane.showMessageDialog(null, "数据表插入成功", "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("已经插入数据");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "数据表插入失败", "", JOptionPane.ERROR_MESSAGE);
            System.out.println("数据表创建失败");
        }
    }

    class bu_lis_one implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea te=product.textArea;
            if(product.menu.getText()=="查询数据表"){
                String text=te.getText();
                sea_sql(text);
            }
        }
    }
    class bu_lis_two implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea te=product.textArea;
            if(product.menu.getText()=="创建数据表"){
                String text=te.getText();
                cre_form_sql(text);
            }
        }
    }
    class bu_lis_three implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea te=product.textArea;
            if(product.menu.getText()=="链接数据库"){
                String text=te.getText();
                con_sql(text);
            }
        }
    }
    class bu_lis_four implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea te=product.textArea;
            if(product.menu.getText()=="创建数据库"){
                String text=te.getText();
                cre_sql(text);
            }
        }
    }
    class bu_lis_five implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea te=product.textArea;
            if(product.menu.getText()=="删除数据表"){
                String text=te.getText();
                del_sql(text);
            }
        }
    }
    class bu_lis_six implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea te=product.textArea;
            JTextField tf=product.textField;
            if(product.menu.getText()=="插入数据表"){
                String text1=te.getText();
                String text2=tf.getText();
                ins_form(text1,text2);
            }
        }
    }
}
