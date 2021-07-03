package mcdonald;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

class PanelPizzaSize extends JPanel
{
    private JRadioButton    rdbSmall;
    private JRadioButton    rdbMedium;
    private JRadioButton    rdbLarge;
    private ButtonGroup     btgSize;
    private String          pizzaSize="";
    private JRadioButton makeRadioButton(String s,int x,int y)
    {
        ActionListener act = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JRadioButton ob = (JRadioButton)e.getSource();
                pizzaSize = ob.getText();
            }
        };
        JRadioButton temp =new JRadioButton(s);
        temp.setBounds(x, y, 100,30);
        temp.setFont(new Font("Courier New",1,16));
        temp.setOpaque(false);
        btgSize.add(temp);
        temp.addActionListener(act);
        add(temp);
        return temp ;
    }
    public PanelPizzaSize()
    {
        this.setBackground(Color.ORANGE);
        Border b1 = BorderFactory.createLineBorder(Color.BLUE, 2);
        Border b2 = BorderFactory.createTitledBorder(b1, "Size",TitledBorder.LEFT,TitledBorder.CENTER, new Font("Georgia",1,16));
        this.setBorder(b2);
        btgSize     = new ButtonGroup();
        rdbSmall    = makeRadioButton("Small",  10,20);
        rdbMedium   = makeRadioButton("Medium", 10,45);
        rdbMedium.setSelected(true);
        rdbLarge    = makeRadioButton("Large",  10,70);
    }
    public String getPizzaSize()
    {
        return pizzaSize;
    }
    public void setDefault()
    {
        rdbMedium.setSelected(true);
        pizzaSize = "Medium";
    }
}
