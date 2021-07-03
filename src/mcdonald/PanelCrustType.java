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

class PanelCrustType extends JPanel
{
    private JRadioButton    rdbThin;
    private JRadioButton    rdbThick;
    private ButtonGroup     btgType;
    private String          crustType="";
    private JRadioButton makeRadioButton(String s,int x,int y)
    {
        ActionListener act = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JRadioButton ob = (JRadioButton)e.getSource();
                crustType = ob.getText();
            }
        };
        JRadioButton temp =new JRadioButton(s);
        temp.setBounds(x, y, 150,30);
        temp.setFont(new Font("Courier New",1,16));
        temp.setOpaque(false);
        btgType.add(temp);
        temp.addActionListener(act);
        add(temp);
        return temp ;
    }
    public PanelCrustType()
    {
        this.setBackground(Color.ORANGE);
        Border b1 = BorderFactory.createLineBorder(Color.BLUE, 2);
        Border b2 = BorderFactory.createTitledBorder(b1, "Crust Type",TitledBorder.LEFT,TitledBorder.CENTER, new Font("Georgia",1,16));
        this.setBorder(b2);
        btgType     = new ButtonGroup();
        rdbThin    = makeRadioButton("Thin Crust",  10,20);
        rdbThin.setSelected(true);
        rdbThick   = makeRadioButton("Thick Crust", 10,45);
    }
    public String getCrustType()
    {
        return crustType;
    }
    public void setDefault()
    {
        rdbThin.setSelected(true);
        crustType = "Thin Crust";
    }
}
