import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class result extends JFrame implements ActionListener
{
         JLabel msg=new JLabel("Performance Report");
   
         JLabel min=new JLabel("Min Marks:");
         JLabel max=new JLabel("Max Marks:");
         JLabel m_ax=new JLabel();
         JLabel m_in=new JLabel();
         JLabel score=new JLabel("Your score is:");
         JLabel s_core=new JLabel();
         JButton done= new JButton("Done");
         Container con;
       
                  public result()
               {  
                 msg.setFont(new Font("Arial",Font.BOLD,15)); 
                con = getContentPane();
                con.setLayout(null);
                 
		setTitle("OnLine Testing System: Performance Section");
                setSize(600,600);
                Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
                 int sw=(int) d.getWidth();
                 int sh=(int) d.getHeight();
		
		setLocation((sw-600)/2,(sh-600)/2);
		//setIconImage(Toolkit.getDefaultToolkit().getImage("a.png"));
                setResizable(false);setVisible(false);setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                con.add(msg);
                
                con.add(m_ax);  con.add(m_in);
                con.add(max);
                con.add(min);
                con.add(score);con.add(s_core);
                con.add(done);

                msg.setBounds(220,20,250,20);
               
                min.setBounds(150,100,100,20);min.setFont(new Font("Arial",Font.BOLD,15));
                max.setBounds(150,140,100,20);max.setFont(new Font("Arial",Font.BOLD,15));
                m_in.setBounds(250,100,100,20);m_in.setFont(new Font("Arial",Font.BOLD,15));
                m_ax.setBounds(250,140,100,20);m_ax.setFont(new Font("Arial",Font.BOLD,15));
                score.setBounds(150,180,100,20);score.setFont(new Font("Arial",Font.BOLD,15));
                s_core.setBounds(250,180,100,20);
                done.setBounds(220,250,80,40);
                done.addActionListener(this);
    }


               void  print(String s1)
               {
                    try{
                                           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                          Connection con=DriverManager.getConnection("jdbc:odbc:test125");
                                          Statement st=con.createStatement();
                                          ResultSet rs=st.executeQuery("(select * from Test_Master where tcode='"+s1+"')");
                                           if(rs.next())
                                          {  m_ax.setText(rs.getString("tmax"));
                                           m_in.setText(rs.getString("tmin"));}
                         }catch(Exception e){System.out.print(e);}
                
               }
               
             void show(String marks)
               {
                     s_core.setText(marks);
               
               }               
              public void actionPerformed(ActionEvent e)
              {
                    dispose();
              }
                                          
                                           
               

}