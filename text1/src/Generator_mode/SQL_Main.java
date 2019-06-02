package Generator_mode;

import javax.swing.*;

public class SQL_Main {
    public static void main(String [] args){
        SQL_Bulider bulider=new SQL_ConcreteBuilder();
        SQL_Director director=new SQL_Director(bulider);
        JPanel jPanel =director.constructProduct();
        JFrame frame=new JFrame();
        frame.add(jPanel);
        frame.setBounds(0,0,800,800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
