import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class tronWindow extends JFrame
{
    private JLabel item1;

    public tronWindow()
    {
        super("TRON");
        setLayout(new FlowLayout());

        item1 = new JLabel("This is a test window");
        item1.setToolTipText("WOAH!");
        add(item1);
    }
}
