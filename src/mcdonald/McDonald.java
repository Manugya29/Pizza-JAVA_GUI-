
package mcdonald;






import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

class Customer
{
    private String      custName;
    private String      phoneNum;
    private String      pizzaSize;
    private String      crustType;
    private String      deliMode;
    private boolean[]   topSelect;
    private int i=1;
  
    public Customer()
    {
        
    }
    public Customer(String cn,String pn,String ps,String ct,String dm,boolean[] ts)
    {
        custName  = cn;
        phoneNum  = pn;
        pizzaSize = ps;
        crustType = ct;
        deliMode  = dm;
        topSelect = ts;
    }
    @Override
    public String toString()
   {
//        String msg = custName+"|"+phoneNum+"|"+pizzaSize+"|"+crustType+"|"+deliMode+"|"+
//                     topSelect[0]+"|"+topSelect[1]+"|"+topSelect[2]+"|"+topSelect[3]+"|"+
//                     topSelect[4]+"|"+topSelect[5]+"\n";
        
         String msg="\n"  +custName + "                  "+ phoneNum +  "   "           
                       + pizzaSize +"   "+ crustType+ "   "+deliMode+"      "+topSelect[0]+ "     "+topSelect[1] + "     "+topSelect[2] +"       "
                       + topSelect[3] +"   " +topSelect[4] 
                       + "  " +topSelect[5];
      

        
        return msg;
      
    }
    
}

class MainFrame extends JFrame
{
    private MainFrame           father = null;
    private JLabel              lblCaption,lblCustName,lblPhone;
    private JTextField          txtCustName,txtPhone;
    private PanelPizzaSize      pnlPizzaSize;
    private PanelCrustType      pnlCrustType;
    private PanelToppings       pnlToppings;
    private PanelDeliveryMode   pnlDeliMode;
    private JButton             btnSubmit, btnCommit,btnShow,btnExit,btnShowLess;
    private JTextArea           txtReport;
    private JScrollPane         spReport;
    private ArrayList<Customer> custList = new ArrayList<Customer>();
     File newfile;
    FileWriter fwrite;
    
    private JLabel makeLabel(String msg, int x, int y, int w, int h, int mode)
    {
        JLabel t = new JLabel(msg);
        t.setBounds(x, y, w, h);
        if(mode == 1)
        {
            Border br1 = BorderFactory.createLineBorder(Color.RED,   3);
            Border br2 = BorderFactory.createLineBorder(Color.WHITE, 2);
            Border br3 = BorderFactory.createCompoundBorder(br1, br2);
            t.setOpaque(true);
            t.setBackground(Color.PINK);
            t.setForeground(Color.BLUE);
            t.setFont(new Font("Verdana",1,25));
            t.setHorizontalAlignment(JLabel.CENTER);
            t.setBorder(br3);
        }
        else if(mode == 2)
        {
            t.setFont(new Font("Courier New",1,18));
        }
        add(t);
        return t;
    }
    private JTextField makeTextField(int x, int y, int w, int h)
    {
        JTextField t = new JTextField();
        t.setFont(new Font("Courier New",1,18));
        t.setBounds(x, y, w, h);
        t.setHorizontalAlignment(JTextField.CENTER);
        Border br = BorderFactory.createLineBorder(Color.BLUE, 1);
        t.setBorder(br);
        add(t);
        return t;
    }
    private JPanel createPanel(int x, int y, int w, int h, int mode)
    {
        JPanel t = null;
        if(mode == 1)
            t = new PanelPizzaSize();   //super class pointer pointing to subclass object
        else if(mode == 2)
            t = new PanelCrustType();   //super class pointer pointing to subclass object
        else if(mode == 3)
            t = new PanelToppings();    //super class pointer pointing to subclass object
        else if(mode == 4)
            t = new PanelDeliveryMode();//super class pointer pointing to subclass object
        
        t.setLayout(new BorderLayout());
        t.setBounds(x,y,w,h);
        add(t);
        return t;
    }
    private JButton makeButton(String msg, int x, int y, int w, int h)
    {
        ActionListener act = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Object ob = e.getSource();
                if(ob==btnSubmit)
                {
                    String      custName  = txtCustName.getText();
                    String      pnoneNum  = txtPhone.getText();
                    String      pizzaSize = pnlPizzaSize.getPizzaSize();
                    String      crustType = pnlCrustType.getCrustType();
                    String      deliMode  = pnlDeliMode.getDeliveryMode();
                    boolean[]   topSelect = pnlToppings.getToppings();
                    Customer temp = new Customer(custName, pnoneNum, pizzaSize, crustType, deliMode, topSelect);
                    custList.add(temp);
                     

                    
                    txtReport.append(temp.toString());
                }
                else if(ob==btnCommit)
                  {
                    try
                          {
            fwrite=new FileWriter(newfile,true);
            for(int j=0;j<custList.size();j++)
                    {
                Customer em= custList.get(j);
                {
                    fwrite.write(em.toString());               
                 }
                       
                     }
                      fwrite.close();
                      
              String msg= "Data Committed to Order.csv";
                    JOptionPane optionpane=new JOptionPane();
                    optionpane.setMessage(msg);
                    optionpane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog=optionpane.createDialog("Committed");
               dialog.setVisible(true);
                  
                             }
            catch(Exception f){}
                    
                    
                    
                    
                    
                }
                else if(ob==btnShow)
                {
                    father.setSize(640,610);
                    father.setLocationRelativeTo(null);
                }
                else if(ob==btnExit)
                {
                    System.exit(0);
                }
                else if(ob==btnShowLess)
                {
                    father.setSize(640,395);
                    father.setLocationRelativeTo(null);
                }
            }
        };
        JButton t = new JButton(msg);
        t.setFont(new Font("Georgia",1,16));
        t.setBounds(x, y, w, h);
        t.addActionListener(act);
        add(t);
        return t;
    }
    public MainFrame()
    {
        try{
        father       = this;
        lblCaption   = makeLabel("Domino's Pizza",   10,10,610,50,1);
        lblCustName  = makeLabel("Customer Name",    10,70,150,30,2);
        txtCustName  = makeTextField(               170,70,200,30);
        lblPhone     = makeLabel("Phone",           380,70, 70,30,2);
        txtPhone     = makeTextField(               450,70,167,30);
        pnlPizzaSize = (PanelPizzaSize)createPanel(      10,110,230,120,1);
        pnlCrustType = (PanelCrustType)createPanel(      10,240,230,80,2);
        pnlToppings  = (PanelToppings)createPanel(      250,110,370,120,3);
        pnlDeliMode  = (PanelDeliveryMode)createPanel(  250,240,370,80,4);
        
        btnSubmit    = makeButton("Submit", 48, 330,100,30);
        btnCommit    = makeButton("Commit",196, 330,100,30);
        btnShow      = makeButton("Show>>",344, 330,100,30);
        btnExit      = makeButton("Exit",  492, 330,100,30);
        
        txtReport    = new JTextArea();
        txtReport.setFont(new Font("Courier New",1,16));
        txtReport.setBackground(Color.BLACK);
        txtReport.setForeground(Color.WHITE);
         txtReport.setText("  Customer Name    |  Phone no.  | Size  |  Crust Type | Delivery  |Ex.Cheese | "
                    + "Blk.Olives |G.Pepper |Mushroom|Onion|Tomato \n " + "------------------|-------------|-------|-------------|--------"
                    + "---|----------|------------|---------|--------|-----|--------");
        spReport     = new JScrollPane(txtReport);
        spReport.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        spReport.setBounds(10,370,610,160);
        add(spReport);
        
        btnShowLess  = makeButton("Show Less<<",  245, 540,150,30);
        
         newfile=new File("Order.CSV");
           
            fwrite=new FileWriter(newfile,true);
            
    }
        catch (Exception e){}
    }
}
public class McDonald
        {
    public static void main(String[] args)
    {
        MainFrame mf = new MainFrame();
        mf.setLayout(new BorderLayout());
        mf.getContentPane().setBackground(Color.YELLOW);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setVisible(true);
        mf.setTitle("Pizza Order Collection Form");
        mf.setSize(640,395);
        mf.setResizable(false);
        mf.setLocationRelativeTo(null);
    }
}