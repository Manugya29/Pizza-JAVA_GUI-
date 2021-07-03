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

class PanelDeliveryMode extends JPanel
{
    private JRadioButton    rdbEatIn;
    private JRadioButton    rdbTakeOut;
    private ButtonGroup     btgMode;
    private String          deliveryMode = "";
    private JRadioButton makeRadioButton(String s,int x,int y)
    {
        ActionListener act = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JRadioButton ob = (JRadioButton)e.getSource();
                deliveryMode = ob.getText();
                //System.out.println(deliveryMode);
            }
        };
        JRadioButton temp =new JRadioButton(s);
        temp.setBounds(x, y, 150,30);
        temp.setFont(new Font("Courier New",1,16));
        temp.setOpaque(false);
        btgMode.add(temp);
        temp.addActionListener(act);
        add(temp);
        return temp ;
    }
    public PanelDeliveryMode()
    {
        this.setBackground(Color.ORANGE);
        Border b1 = BorderFactory.createLineBorder(Color.BLUE, 2);
        Border b2 = BorderFactory.createTitledBorder(b1, "Mode of Delivery",TitledBorder.LEFT,TitledBorder.CENTER, new Font("Georgia",1,16));
        this.setBorder(b2);
        btgMode     = new ButtonGroup();
        rdbEatIn    = makeRadioButton("Eat In",  10,20);
        rdbEatIn.setSelected(true);
        rdbTakeOut  = makeRadioButton("Take Out", 10,45);
    }
    public String getDeliveryMode()
    {
        return deliveryMode;
    }
    public void setDefault()
    {
        rdbEatIn.setSelected(true);
        deliveryMode = "Eat In";
    }
}
