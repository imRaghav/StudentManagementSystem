import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class test_detail extends JFrame implements ActionListener
    {
                               
	                         JLabel msg=new JLabel("Welcome in OnLine Testing");
	                         JLabel code=new JLabel("TEST CODE");
	                         JLabel title=new JLabel("TEST TITLE");
                                 JLabel date=new JLabel("TEST DATE");
                                 JLabel dur=new JLabel("TEST DURATION");
                                 JLabel max=new JLabel("MAX MARKS");
	                         JLabel min=new JLabel("MIN MARKS");   
	                        JLabel t_itle=new JLabel("");
	                        JLabel d_ate=new JLabel("");
	                        JLabel m_ax=new JLabel("");
	                        JLabel d_ur=new JLabel("");
	                        JLabel m_in=new JLabel("");
                                 JLabel ins=new JLabel("INSTRUCTIONS");
                                 JLabel i_ns1=new JLabel("");
                                  JLabel i_ns2=new JLabel("");
                              JLabel i_ns3=new JLabel("");
	                        JButton next=new JButton("Next");  JButton start=new JButton("Start");
	                        
	                        JComboBox c_ode=new JComboBox();
                                Container con;




	           test_detail()
	     { 
                con = getContentPane();
                con.setLayout(null);
		setTitle("OnLine Testing System:Test Selection and Test Detail");
		setSize(600,600);
                Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
                 int sw=(int) d.getWidth();
                 int sh=(int) d.getHeight();
		
		setLocation((sw-600)/2,(sh-600)/2);
               setResizable(false);
               setVisible(true);
               setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                con.add(msg);
                con.add(title);
                con.add(date);
                con.add(dur);
                con.add(max);
                con.add(min);
                con.add(code);
                con.add(t_itle);
                con.add(d_ate);
                con.add(m_ax);
                con.add(m_in);
               con.add(d_ur);
               con.add(ins);
               con.add(i_ns1); con.add(i_ns2); con.add(i_ns3);
               con.add(c_ode);
               c_ode.addItem("C");c_ode.addItem("JAVA");c_ode.addItem("SQL");
                con.add(next);

                 msg.setBounds(220,20,210,20);//(x,y,width,height)
	         code.setBounds(100,120,200,50);
	        title.setBounds(100,170,200,50);
	        date.setBounds(100,220,200,50);
		 dur.setBounds(100,270,200,50);
		 max.setBounds(100,310,200,70);
		 min.setBounds(100,360,200,70);
                 c_ode.setBounds(300,130,60,30);
		t_itle.setBounds(300,167,200,50);
		 d_ate.setBounds(300,217,200,50);
                 d_ur.setBounds(300,267,200,50);
                 m_ax.setBounds(300,317,200,50);
                  m_in.setBounds(300,367,200,50);
	         ins.setBounds(100,420,200,30);
                   i_ns1.setBounds(290,417,200,30);
                  i_ns2.setBounds(290,437,200,30);
                 i_ns3.setBounds(290,460,300,40);
                next.setBounds(100,500,100,40);
                start.setBounds(220,500,100,40);
                next.addActionListener(this);
                 start.addActionListener(this);
               
            }     

                        public void actionPerformed(ActionEvent e)
                            {   
                                  
                                if(e.getSource()==next)
                                {         
                               try{
                                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                     Connection con=DriverManager.getConnection("jdbc:odbc:test125");
                                     Statement st=con.createStatement();
                                   ResultSet rs=st.executeQuery("(select * from Test_Master where tcode='"+c_ode.getSelectedItem().toString()+"')"); 
                                     if(rs.next())
                                        {
                                           t_itle.setText(rs.getString(2));
                                           d_ate.setText(rs.getString(3));
                                          d_ur.setText(rs.getString(4));
                                           m_ax.setText(rs.getString(5));
                                           m_in.setText(rs.getString(6));
                                           i_ns1.setText(rs.getString(7));
                                           i_ns2.setText(rs.getString(8));
                                          i_ns3.setText(rs.getString(9));
                                           
                                          }

                                      con.close();
                                      st.close();
                                   }catch(Exception exc){System.out.println(exc);}
                                con.add(start);
                              }
                              else if(e.getSource()==start)
                                    {   
                                       dispose();
                                        new exam(c_ode.getSelectedItem().toString(),t_itle.getText());
                                        
                                   }
                            }
                        
                       
                 

  }
                 






