package mcdonald;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

class PanelToppings extends JPanel
{
    private final int NUMBER_OF_CHECKBOX = 6;
    private JCheckBox[] toppings  = new JCheckBox[NUMBER_OF_CHECKBOX];
    private String[]    topText   = {"Extra Cheese","Black Olives","Green Pepper","Mushroom","Onion","Tomato"};
    private boolean[]   topSelect = new boolean[NUMBER_OF_CHECKBOX];
    
    private JCheckBox makeCheckBox(String s,int x,int y,int i)
    {
        ActionListener act = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JCheckBox ob = (JCheckBox)e.getSource();
                int checkIndex = (Integer)ob.getClientProperty("index");
                topSelect[checkIndex] = toppings[checkIndex].isSelected();
            }
        };
        JCheckBox temp = new JCheckBox(s);
        temp.setBounds(x, y, 150,30);
        temp.setFont(new Font("Courier New",1,16));
        temp.setOpaque(false);
        temp.addActionListener(act);
        temp.putClientProperty("index", i);
        add(temp);
        return temp ;
    }
    public PanelToppings()
    {
        this.setBackground(Color.ORANGE);
        Border b1 = BorderFactory.createLineBorder(Color.BLUE, 2);
        Border b2 = BorderFactory.createTitledBorder(b1, "Toppings",TitledBorder.LEFT,TitledBorder.CENTER, new Font("Georgia",1,16));
        this.setBorder(b2);
        
        for(int ind=0,i=1,xpos=10;i<=2;i++,xpos+=160)
        {
            for(int j=1,ypos=20;j<=3;j++,ypos+=25,ind++)
            {
                toppings[ind] = makeCheckBox(topText[ind],xpos, ypos,ind);
            }
        }
//        toppings[0] = makeCheckBox(topText[0],10, 20);
//        toppings[1] = makeCheckBox(topText[1],10, 45);
//        toppings[2] = makeCheckBox(topText[2],10, 70);
//        toppings[3] = makeCheckBox(topText[3],170,20);
//        toppings[4] = makeCheckBox(topText[4],170,45);
//        toppings[5] = makeCheckBox(topText[5],170,70);
    }
    public boolean[] getToppings()
    {
        return topSelect;
    }
    public void setDefault()
    {
        for(int i=0;i<NUMBER_OF_CHECKBOX;i++) 
        {
            toppings[i].setSelected(false);
            topSelect[i] = false;
        }
    }
}

