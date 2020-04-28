import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class exam extends JFrame  implements ActionListener,ItemListener
{                           
                             int size=10;
                             static int i=0;
                             result r=new result();
                             
                           String resp[]=new String[size];
                           
                           String a[]=new String[size];  
                           String b[]=new String[size]; 
                           String c[]=new String[size]; 
                           String d[]=new String[size]; 
                           String e[]=new String[size]; 
                           String f[]=new String[size]; 
                           String g[]=new String[size]; 
                            JProgressBar pb=new JProgressBar();
                            JLabel qno=new JLabel();
                            JLabel ques=new JLabel();
                            JLabel opt1=new JLabel();
                            JLabel opt2=new JLabel();
                            JLabel opt3=new JLabel();
                            JLabel opt4=new JLabel();
                            JRadioButton o_pt1=new  JRadioButton();
                            JRadioButton o_pt2=new  JRadioButton();
                            JRadioButton o_pt3=new  JRadioButton();
                            JRadioButton o_pt4=new  JRadioButton();
                            ButtonGroup grp=new ButtonGroup();
                            JButton next=new JButton("Next");
                            JButton prev=new JButton("Prev");
                            JButton first=new JButton("First");
                            JButton last=new JButton("Last");
                            JButton submit=new JButton("Submit");
                            Container con;

                                 public exam(String s1,String s2)
                               {
                                    JLabel msg=new JLabel(s2);
                                  
                                    con = getContentPane();
	                            con.setLayout(null);
                                    setTitle("Welcome to Online Test"); 
		                    setSize(1400,800);
		                    setVisible(true);
		                   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                   
                                  con.add(msg);msg.setFont(new Font("Arial",Font.BOLD,15));
                                   con.add(qno);
                                   con.add(ques); 
                                   con.add(opt1);
                                   con.add(opt2);
                                   con.add(opt3);
                                   con.add(opt4);
                                 con.add(next);
                                   con.add(prev);
                                    con.add(last);
                                  con.add(first);
                                   con.add(last);
                                 con.add(submit);
                                con.add(o_pt1);
                                 con.add(o_pt2);
                                 con.add(o_pt3);con.add(pb);
                               con.add(o_pt4);grp.add(o_pt1);grp.add(o_pt2);grp.add(o_pt3);grp.add(o_pt4);
                            msg.setBounds(660,20,210,50);
                            qno.setBounds(110,100,30,30);
                             ques.setBounds(140,100,800,30);ques.setFont(new Font("Arial",Font.BOLD,15));
                            o_pt1.setBounds(100,350,40,20);
                          o_pt2.setBounds(100,370,40,20);
                          o_pt3.setBounds(100,390,40,20);
                           o_pt4.setBounds(100,410,40,20);
                          opt1.setBounds(140,350,100,20);
                           opt2.setBounds(140,370,100,20);
                           opt3.setBounds(140,390,100,20);
                           opt4.setBounds(140,410,100,20);
                           next.setBounds(140,450,80,30);
                           prev.setBounds(230,450,80,30);
                           last.setBounds(320,450,80,30);
                          first.setBounds(410,450,80,30);
                         submit.setBounds(500,450,80,30);
                            pb.setBounds(150,600,1100,20);                           

                          next.addActionListener(this);
                          prev.addActionListener(this);
                          first.addActionListener(this); 
                          last.addActionListener(this);
                          submit.addActionListener(this); 
                          o_pt1.addItemListener(this);
                          o_pt2.addItemListener(this);
                          o_pt3.addItemListener(this);
                          o_pt4.addItemListener(this);
                                    try{
                                           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                          Connection con=DriverManager.getConnection("jdbc:odbc:test125");
                                          Statement st=con.createStatement();
                                            ResultSet rs=st.executeQuery("(select * from "+s1+")");
                                             for(int j=0;rs.next();j++)
                                                 {  a[j]=rs.getString(1);
                                                    b[j]=rs.getString(2);
                                                    c[j]=rs.getString(3);
                                                    d[j]=rs.getString(4);
                                                    e[j]=rs.getString(5);
                                                    f[j]=rs.getString(6);
                                                    g[j]=rs.getString(7);
						    resp[j]="0";
                                                }
                                        }catch(Exception e){System.out.print(e);} setValues();r.print(s1);
             } /* End of exam()*/

                   public void showOptions()
                   { 
                     if(resp[i].equals("0"))
                     {
                      o_pt1.setSelected(true);
                      o_pt2.setSelected(false);
                      o_pt3.setSelected(false);
                      o_pt4.setSelected(false);
                    }
                     else if(resp[i].equals("1"))
                    {
                     o_pt1.setSelected(true);
                    o_pt2.setSelected(false);
                    o_pt3.setSelected(false);
                   o_pt4.setSelected(false);
                    }
                   else if(resp[i].equals("3"))
                   {
                      o_pt1.setSelected(false);

                      o_pt2.setSelected(false);
                      o_pt3.setSelected(true);
                      o_pt4.setSelected(false);
                   }                               
                  else if(resp[i].equals("4"))
                  {
                  o_pt1.setSelected(false);
                  o_pt2.setSelected(false);
                  o_pt3.setSelected(false);
                  o_pt4.setSelected(true);
                  }
                  else if(resp[i].equals("2"))
                 {
                   o_pt1.setSelected(false);
                   o_pt2.setSelected(true);
                   o_pt3.setSelected(false);
                   o_pt4.setSelected(false);
                 }
                
              }
                

                public void itemStateChanged(ItemEvent evt)
                {  
                   if(evt.getSource()==o_pt1 && resp[i]!="0")
                    resp[i]="1"; 
                   else if(evt.getSource()==o_pt2 )
                   resp[i]="2";
                   else if(evt.getSource()==o_pt3 )
                    resp[i]="3";
                   else  if(evt.getSource()==o_pt4 )
                   resp[i]="4";
                   
                }


                                           
                                                   void setValues()
                                                   {
                                                  qno.setText(a[i]);
                                                  opt1.setText(b[i]);
                                                  opt2.setText(c[i]);
                                                  opt3.setText(d[i]);
                                                  opt4.setText(e[i]); 
                                                  ques.setText(f[i]);
                                                   showOptions();
                                                   }
                                   public void actionPerformed(ActionEvent evt)
                                    {    
                                            
                                           
                                          
                                                 if(evt.getSource()==next)
                                               {
                                                    if(i<size-1)
                                                  {   
                                                      i++;
                                                     setValues();  
                                                        
                                                    
                                                         
                                                  }    
                                                   else
                           JOptionPane.showMessageDialog(this,"You are on the Last Ques");  
                                                  
                                               }
                                           
                                                else if(evt.getSource()==prev)
                                                {

                                                      if(i>0)
                                                   {    i--;
                                                     setValues();
                                                  }
                                                  else
                           JOptionPane.showMessageDialog(this,"You are on the First Ques"); 
                                                }

                                               else if(evt.getSource()==first)
                                                    { 
                                                       i=0;
                                                      setValues(); 
                                                     
                                                    }
                                                
                                                 else if(evt.getSource()==last)
                                                    { 
                                                       i=size-1;
                                                      setValues();
                                                    }
                                              
                                                  else if(evt.getSource()==submit) 
                                                   { 
                                                        int marks=0;
                                                       for(int j=0;j<size;j++)
                                                        {
                                                          if(resp[j].compareTo(g[j])==0)
                                                               marks=marks+1;
                                                          else if(resp[j]!="0" &&resp[j].compareTo(g[j])!=0)
                                                               marks=marks-1;
                                                        }  for(int j=0;j<size;j++)System.out.print(resp[j]);
                                                        new insert(marks); 
                                                       r.show(Integer.toString(marks));
                                                       dispose();
                                                       r.setVisible(true);
                                                  
                                                   
                                                }
                                              
                                     }
                                  
                                }/*End of class*/
                
    
                            
                        
                        











             
