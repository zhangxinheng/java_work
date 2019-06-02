package Generator_mode;

import javax.swing.*;

public interface SQL_Bulider {
    public abstract void connect_sql();
    public abstract void create_sql();
    public abstract void create_form();
    public abstract void search_form();
    public abstract void delete_form();
    public abstract JPanel getPanel();//JButton button
}
