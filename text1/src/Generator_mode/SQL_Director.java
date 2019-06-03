package Generator_mode;
import javax.swing.*;
public class SQL_Director {
    private SQL_Bulider bulider;
    SQL_Director(SQL_Bulider bulider)
    {
        this.bulider=bulider;
    }
    public JPanel constructProduct(){
        bulider.search_form();
        bulider.delete_form();
        bulider.create_sql();
        bulider.create_form();
        bulider.connect_sql();
        bulider.ins_sql_form();
        JPanel product=bulider.getPanel();
        return  product;
    }
}
