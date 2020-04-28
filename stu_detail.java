import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class stu_detail extends JFrame implements ActionListener
{
	JLabel msg=new JLabel("Welcome in OnLine Testing");
	JLabel name=new JLabel("Name");
	JLabel addr=new JLabel("Address");
         JLabel sex=new JLabel("Sex");
         JLabel qual=new JLabel("Qualification");
         JLabel cont=new JLabel("Contact");
	JLabel n_ame=new JLabel();
        JLabel a_ddr=new JLabel();
       JLabel s_ex=new JLabel();
         JLabel q_ual=new JLabel();
        JLabel c_no=new JLabel();
        JButton next= new JButton("Next");
        
       Container con;
	
        
	public stu_detail(String title,String user,String pass)
	{          
                  msg.setFont(new Font("Arial",Font.BOLD,15)); 
                con = getContentPane();
                con.setLayout(null);
		setTitle("OnLine Testing System:Student Detail Section");
		setSize(600,600);
                Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
                 int sw=(int) d.getWidth();
                 int sh=(int) d.getHeight();
		
		setLocation((sw-600)/2,(sh-600)/2);
                setResizable(false);
		con.add(msg);
                con.add(name);
                con.add(addr);
                con.add(sex);
                con.add(qual);
                con.add(cont);
                con.add(n_ame);
                con.add(a_ddr);
                con.add(s_ex);
                con.add(q_ual);
                con.add(c_no);
                con.add(next);
                

                msg.setBounds(220,20,250,20);//(x,y,width,height)
		name.setBounds(100,120,200,50);name.setFont(new Font("Arial",Font.BOLD,15));
		addr.setBounds(100,170,200,50);addr.setFont(new Font("Arial",Font.BOLD,15));
		sex.setBounds(100,220,200,50);sex.setFont(new Font("Arial",Font.BOLD,15));
		qual.setBounds(100,270,200,50);qual.setFont(new Font("Arial",Font.BOLD,15));
		cont.setBounds(100,320,200,50);cont.setFont(new Font("Arial",Font.BOLD,15));
                n_ame.setBounds(300,128,200,30);n_ame.setFont(new Font("Arial",Font.BOLD,15));
                a_ddr.setBounds(300,178,200,30);a_ddr.setFont(new Font("Arial",Font.BOLD,15));
                s_ex.setBounds(300,230,200,30);s_ex.setFont(new Font("Arial",Font.BOLD,15));
                q_ual.setBounds(300,280,200,30);q_ual.setFont(new Font("Arial",Font.BOLD,15));
                c_no.setBounds(300,330,200,30);c_no.setFont(new Font("Arial",Font.BOLD,15));
                next.setBounds(250,400,100,40);
                
                next.addActionListener(this);
               
		
	   

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            
                                    
                                   try{
                                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                     Connection con=DriverManager.getConnection("jdbc:odbc:test123");
                                     Statement st=con.createStatement();
                                     ResultSet rs=st.executeQuery("(select * from Register where uid= '"+user+"'and pwd='"+pass+"')");
                                     if(rs.next())
                                        {
                                            n_ame.setText(rs.getString("uname"));
                                            a_ddr.setText(rs.getString("address"));
                                            s_ex.setText(rs.getString("sex")); 
                                            q_ual.setText(rs.getString("qual")); 
                                            c_no.setText(rs.getString("contact")); 
                                         }
                                     }  
                                     catch(Exception e1)
                                     {e1.printStackTrace();}   
                                
 }                              
                                    public void actionPerformed(ActionEvent e)
                                      {  
                                       
                                        dispose();
                                        new test_detail();
                                      }  



             
	
          


             
}
	