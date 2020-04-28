import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Login extends JFrame implements ActionListener ,FocusListener
{
	                      JLabel msg=new JLabel("Welcome in OnLine Testing");
                             
	                      JLabel u_id=new JLabel("Enter Userid");
	                      JLabel pass_wd=new JLabel("Enter Password");
	                     JTextField userid=new JTextField(10);
	                     JPasswordField password=new JPasswordField(10);
	                     JButton newuser_b= new JButton("New User");
                             JButton login_b= new JButton("Login");
                             JButton exit_b= new JButton("Exit");
	                     Container con;
	
        
	       public Login()
	      {
                   msg.setFont(new Font("Arial",Font.BOLD,15));
                con = getContentPane();
                con.setLayout(null);
		setTitle("OnLine Testing System:Login Section");
		setSize(600,600);
		setLocation(500,125);
                setResizable(false);
		con.add(msg);
		
		con.add(u_id);
		con.add(pass_wd);
		con.add(userid);
		con.add(password);
		con.add(newuser_b);
		con.add(exit_b);
		con.add(login_b);
		msg.setBounds(210,20,250,20);//(x,y,width,height)
		u_id.setBounds(100,120,250,50);u_id.setFont(new Font("Arial",Font.BOLD,15));
		pass_wd.setBounds(100,170,250,50);pass_wd.setFont(new Font("Arial",Font.BOLD,15));
		userid.setBounds(250,130,200,30);

		password.setBounds(250,180,200,30);
		newuser_b.setBounds(60,300,100,40);
		login_b.setBounds(340,300,100,40);
		exit_b.setBounds(340,400,100,40);
		
	        password.setEchoChar('*');
  
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                newuser_b.addActionListener(this);
                login_b.addActionListener(this);  
                 exit_b.addActionListener(this); 
                userid.addFocusListener(this);
                password.addFocusListener(this);
              
				

              }

		

               public void actionPerformed(ActionEvent e)
		{
                     if(e.getSource()==login_b)
                      {
                        
                             try{
                                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                     Connection con=DriverManager.getConnection("jdbc:odbc:test123");
                                     Statement st=con.createStatement();
                                     ResultSet rs=st.executeQuery("select * from Register where uid='"+userid.getText()+"' and pwd='"+password.getText()+"'");
                                     if(rs.next()==false)
                                     JOptionPane.showMessageDialog(this,"Either Userid or Password is incorrect"); 
                                     else
                                     {
                                      new stu_detail("STUDENT INFORMATION",userid.getText(),password.getText()) ;
                                      dispose();    
                                     }
                                   }catch(Exception exc){exc.printStackTrace();}
                                
                      
		          }
                          
                          else if(e.getSource()==exit_b)
                                  System.exit(0);
                           else if(e.getSource()==newuser_b)
                                {
                                  new regis_client();
                                  dispose();
                                  }
                   }
 
              public void focusGained(FocusEvent e)
                   {
                        if(e.getSource()==userid)
                           { if(userid.getText()=="Enter UserId")
                           userid.setText("");
                           }
                         else if(e.getSource()==password)
                          {if(password.getText()=="Enter Password")
                            password.setText("");}
                                     
                              
                  }
              
              public void focusLost(FocusEvent e)
                {
                      
                        if(e.getSource()==userid)
                         {if(userid.getText().length()==0)
                           userid.setText("Enter UserId");}
                        else if(e.getSource()==password)
                          {if(password.getText().length()==0)
                             password.setText("Enter Password");}
                }
          
                 
		
		
       

      

	public static void main(String[] args) {
		new Login();
		
                  
                     
	}
}

//...............Registration...........



class regis_client extends JFrame implements ItemListener,FocusListener,ActionListener
{
	                            JLabel msg=new JLabel("Welcome in OnLine Testing System");
	                            JLabel id=new JLabel("ID");
	                            JLabel name=new JLabel("Name");
	                             JLabel addr=new JLabel("Address");
	                           JLabel cont_no=new JLabel("Contact no");
	                            JLabel sex= new JLabel("Sex");
	                           JLabel qual=new JLabel("Qualification");
	                           JLabel pass=new JLabel("Password");
                                   JLabel cpass=new JLabel("Confirm Password");
	                           JTextField i_d=new JTextField(10);
	                           JTextField n_ame=new JTextField(15);
	                           JTextField a_ddr=new JTextField(15);
	                          JTextField c_no=new JTextField(12);
	                         JRadioButton male = new JRadioButton("Male",true);
                                 JRadioButton female = new JRadioButton("Female");
                                 ButtonGroup grp = new ButtonGroup();
	
	                       JPasswordField p_ass=new JPasswordField(10);
                               JPasswordField cp_ass=new JPasswordField(10);  
	                       JButton submit=new JButton("submit");
                                JButton back=new JButton("Back");
                                JComboBox q_ual = new JComboBox(); 
	                        Container con;
                                String s_ex ="Male"; 

       public regis_client()
    {    
            msg.setFont(new Font("Arial",Font.BOLD,15));

	     con = getContentPane();
	     con.setLayout(null);
       //Window setup
		setTitle(" OnLine Testing System:Registration Section");
		setSize(550,600);
		setLocation(500,125);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(false);  
    // Labels
		con.add(msg);
		con.add(id);
		con.add(name);
		con.add(addr);
		con.add(cont_no);
		con.add(sex);
		con.add(qual);
		con.add(pass);
                 con.add(cpass);
    //TextFields
		con.add(i_d);
		con.add(n_ame);
		con.add(cont_no);
	  con.add(qual);
		con.add(pass);
		con.add(a_ddr);
		con.add(c_no);
    //RadioButtons
		con.add(male);
    con.add(female);
    grp.add(male);
    grp.add(female);
    //Combobox 
		con.add(q_ual);
    q_ual.addItem("BCA");
    q_ual.addItem("MCA");
    q_ual.addItem("BTECH");
    //PasswordField
    con.add(p_ass);
    con.add(cp_ass);
    //Button
    con.add(submit);con.add(back);

    
//  setBounds
		msg.setBounds(150,20,250,50);//(x,y,width,height)
		id.setBounds(150,120,100,50);id.setFont(new Font("Arial",Font.BOLD,15));
    name.setBounds(150,160,100,50);name.setFont(new Font("Arial",Font.BOLD,15));
    addr.setBounds(150,200,100,50);addr.setFont(new Font("Arial",Font.BOLD,15));
    cont_no  .setBounds(150,240,100,50);cont_no.setFont(new Font("Arial",Font.BOLD,15));
   sex.setBounds(150,280,100,50);sex.setFont(new Font("Arial",Font.BOLD,15));
   qual.setBounds(150,320,100,50);qual.setFont(new Font("Arial",Font.BOLD,15));
   pass.setBounds(150,360,100,50);pass.setFont(new Font("Arial",Font.BOLD,15));
   cpass.setBounds(150,400,150,50);cpass.setFont(new Font("Arial",Font.BOLD,15));
  i_d.setBounds(350,135,100,20);
   n_ame.setBounds(350,175,100,20);
  a_ddr.setBounds(350,215,100,20);
  c_no.setBounds(350,255,100,20);
   male.setBounds(300,295,100,20);
  female.setBounds(400,295,100,20);
  q_ual.setBounds(350,335,100,20);
  p_ass.setBounds(350,375,100,20);
  cp_ass.setBounds(350,415,100,20);
  submit.setBounds(350,450,80,30);
  back.setBounds(200,450,80,30);
     
     //Registration of Events
    submit.addActionListener(this);
     back.addActionListener(this);
    male.addItemListener(this);
    female.addItemListener(this);
        i_d .addFocusListener(this);
       c_no .addFocusListener(this);
       cp_ass .addFocusListener(this);
    
    
    p_ass.setEchoChar('*');
     cp_ass.setEchoChar('*');
     
}
       boolean isNumeric(String s) 
       {
               for(int i=0;i<s.length();)
                {
                if((s.charAt(i)>='0' && s.charAt(i)<='9')||s.charAt(i)=='+'||s.charAt(i)=='-')
                 i++;
                 else
                return false;
                }
              return true;
               
       } 
      
       
                  


     
       //Event for RadioButton
        public void itemStateChanged(ItemEvent e)
        {
                    if(e.getSource()==male)
                          s_ex="Male";
                    else if(e.getSource()==female)
                          s_ex="Female";
         }


    
         


        
            

	    public void focusLost(FocusEvent e)
	   {  
            try{
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con=DriverManager.getConnection("jdbc:odbc:test123");
                Statement st=con.createStatement();
              
                                     
                  if(e.getSource()==i_d)
                    {
                      ResultSet rs=st.executeQuery("(select * from Register where uid='"+i_d.getText()+"')"); 
                             if(rs.next() )
                    {JOptionPane.showMessageDialog(this,"This userid is not available");  i_d.setText("");i_d.requestFocus();}
                              
                             
                    }
                
                   else if(e.getSource()==c_no)
                        {
                           String s=c_no.getText();
                          if(isNumeric(s)==false)
                         { JOptionPane.showMessageDialog(this,"Invalid or Blank Entry"); c_no.setText("");}
                         }
                 
                     else if(e.getSource()==cp_ass)
                       {
                        int i=cp_ass.getText().compareTo(p_ass.getText());
                           if(i!=0)
                       { cp_ass.setText(""); cp_ass.requestFocus(); JOptionPane.showMessageDialog(this,"ReEnter Your Password");}
                          
                       } 
                    }catch(Exception e1){System.out.println(e1);}
         }// End of focus Lost
          
                public void focusGained(FocusEvent e){}
              
           public void actionPerformed(ActionEvent e)
            {        
                              if(e.getSource()==submit)
                        {
                             String s1=i_d.getText();
                             String s2=n_ame.getText();
                             String s3=a_ddr.getText();
                             String s4=c_no.getText();
                             String s5=p_ass.getText();
                           if(s1.length()==0||s2.length()==0||s3.length()==0||s4.length()==0||s5.length()==0)
                        JOptionPane.showMessageDialog(this,"This Field cann't leave Blank"); 
                           else
                        {
                              try{
                                   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                  Connection con=DriverManager.getConnection("jdbc:odbc:test123");
                                  Statement st=con.createStatement();
                             st.executeUpdate("insert into Register (uid,uname,address,contact,sex,qual,pwd) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s_ex+"','"+q_ual.getSelectedItem().toString()+"','"+s5+"')");
                              st.close();
                                 }catch(Exception e2){System.out.print(e2);}
                            dispose();
                         JOptionPane.showMessageDialog(this,"You Have Successfully Registered with userid "+s1); 
                            new Login();
                        }
                     }

                               
                              if(e.getSource()==back)
                               new Login();
                }
       




                 
         
             
 
 }//end of class     

//...............Student Details ...........
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
		setLocation(500,125);
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

/*................Test Details................................*/
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
	       setLocation(500,125);
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
                con.add(next);//con.add(start);

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
           

/*................Exam Panel................................*/

class exam extends JFrame  implements ActionListener,ItemListener,Runnable
{                           
                             int size=10;
                             static int i=0;
                             
                     
                           String resp[]=new String[size];
                           int counter=0;
                           int total=size;
	                   String Ans[]=new String[size];
      			   String Marks[]=new String[size];
                           int time; 
                           Thread tt;
		           String tc;
                           String uid;

                           boolean rflag=true;
                           String a[]=new String[size];  
                           String b[]=new String[size]; 
                           String c[]=new String[size]; 
                           String d[]=new String[size]; 
                           String e[]=new String[size]; 
                           String f[]=new String[size]; 
                           
                            JLabel to=new JLabel(" ");
                            JLabel qno=new JLabel(" ");
                            JLabel ques=new JLabel("  ");
                            JLabel opt1=new JLabel(" ");
                            JLabel opt2=new JLabel(" ");
                            JLabel opt3=new JLabel(" ");
                            JLabel opt4=new JLabel(" ");
                            JRadioButton o_pt1=new  JRadioButton(" ");
                            JRadioButton o_pt2=new  JRadioButton(" ");
                            JRadioButton o_pt3=new  JRadioButton(" ");
                            JRadioButton o_pt4=new  JRadioButton(" ");
                            ButtonGroup grp=new ButtonGroup();
                            JButton next=new JButton("Next");
                            JButton prev=new JButton("Prev");
                            JButton first=new JButton("First");
                            JButton last=new JButton("Last");
                            JButton submit=new JButton("Submit");
                            Container con;

                                 public exam(String s1,String s2)
                               {     tc = s1; uid = s2;
                                    JLabel msg=new JLabel(s2);
                                  
                                    con = getContentPane();
	                            con.setLayout(null);
                                    setTitle("Welcome to Online Test"); 
		                    setSize(1400,800);
		                    setVisible(true);
		                   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                   
                                  con.add(msg);msg.setFont(new Font("Arial",Font.BOLD,15));
				   con.add(to);
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
                                 con.add(o_pt3);
                               con.add(o_pt4);grp.add(o_pt1);grp.add(o_pt2);grp.add(o_pt3);grp.add(o_pt4);
                            msg.setBounds(730,20,210,50);
                            to.setBounds(620,60,50,20);
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
                                                    Ans[j]=rs.getString(7);
						    Marks[j]=rs.getString(8);
						    resp[j]="0";
                                                }


     rs=st.executeQuery("select * from Test_Master where tcode='" + tc+"'");


              rs.next();
              time = Integer.parseInt(rs.getString("tdur"));

             tt = new Thread(this);
             tt.start();  


            
             int i=0; 
             counter=0;
             
                                              
 
 

}


catch(Exception e){System.out.print(e);}setValues();
                                        
            
                                    } /* End of exam()*/

                   public void showOptions()
                   {
                      if(i<total)
                         {
                         rflag=false;
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
                  rflag=true;
                 }
                }

                public void itemStateChanged(ItemEvent evt)
                {
                   if(evt.getSource()==o_pt1 && rflag)
                    resp[i]="1"; 
                   else if(evt.getSource()==o_pt2 && rflag)
                   resp[i]="2";
                   else if(evt.getSource()==o_pt3 && rflag)
                    resp[i]="3";
                   else  if(evt.getSource()==o_pt4 && rflag)
                   resp[i]="4";
                   
                }

public void run()
       {
              for(int i = time ; i>=0;i--)
                 { 
                      if(i==0)
                         {
             int score=0;
             for(int ii = 0; ii<total;ii++)
               {
             if(resp[ii].equals(Ans[ii]))
             score = score + Integer.parseInt(Marks[ii]);
               }
             
             Result frm=new Result("RESULT",tc,uid,score);
             frm.setSize(550,350);
             frm.setVisible(true);
             frm.show(); 
             hide(); 
                         }
                    try
                      {
                           to.setText(i+""); 
                           Thread.sleep(1000*60);
                       }
                       catch(Exception e) 
                       {System.out.println(e);}

                        
                 }            
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
                                    {    int marks=0;
                                            
                                           
                                          
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
                                                        
                                                       int score=0;
             for(int i = 0; i<total;i++)
               {
             if(resp[i].equals(Ans[i]))
             score = score + Integer.parseInt(Marks[i]);
               }
             
             Result frm=new Result("RESULT",tc,uid,score);
             frm.setSize(550,350);
             frm.setVisible(true);
             frm.show(); 
             hide();
           }                
                                                       
                                                        
                                                   
                                                }
                                     }
                                  
                                



             



/*................Result Panel................................*/

     class Result extends JFrame implements ActionListener
    {
   
      JLabel msg1 =new JLabel("RESULT");
      JLabel Ttitle =new JLabel("Test title");
      JLabel maxmarks =new JLabel("Test max. marks-");
      JLabel minmarks =new JLabel("Min. marks-");
      JLabel Score =new JLabel("Score-");
      JLabel msg2 =new JLabel("Performance Report");

      JLabel tt=new JLabel(" ");
      JLabel maxm=new JLabel(" ");
      JLabel minm=new JLabel(" ");
      JLabel S=new JLabel(" ");
      JLabel m2=new JLabel(" "); 
     
      JButton exit=new JButton("Exit");

      
      Container con= getContentPane();
      Connection conn;
      Statement smt;
      ResultSet rs;

      String testtitle[]= new String[10];
      String testmax[]= new String[10];
      String testmin[]= new String[10];

        int size;
        int counter;
        String tcode,userid;
        int score;  
            	 

    public Result(String title,String tc,String uid,int s )
    {
        super(title);
         tcode=tc;
         userid=uid;
         score=s;   
       
        con.setLayout(null);	
        con.add(msg1);
        con.add(Ttitle);
        con.add(tt);
        con.add(maxmarks);
        con.add(maxm);
        con.add(minmarks);
        con.add(minm);
        con.add(Score);
        con.add(S);
        con.add(msg2);
        con.add(m2);
        con.add(exit);
       
        msg1.setBounds(220,10,280,20);
        Ttitle.setBounds(60,60,170,20);
        tt.setBounds(120,60,160,20);
        maxmarks.setBounds(60,100,200,20);
        maxm.setBounds(180,100,50,20);
        minmarks.setBounds(350,100,200,20);
        minm.setBounds(430,100,50,20);
        Score.setBounds(60,130,200,20);
        S.setBounds(120,130,50,20);
        m2.setBounds(140,230,300,20);
        msg2.setBounds(150,250,200,20);
        exit.setBounds(400,280,100,20);

 

  try
          {
             ResultSet rs;  
             Connection conn;
             Statement smt; 
             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             conn = DriverManager.getConnection("jdbc:odbc:test125");  
             smt = conn.createStatement();     

             System.out.println("select * from Test_Master where tcode='" + tc + "'");

             rs=smt.executeQuery("select * from Test_Master where tcode='" + tc + "'");
             rs.next(); 
  int r= Integer.parseInt(rs.getString("tmin"));  

             tt.setText(rs.getString("ttitle"));   
             maxm.setText(rs.getString("tmax"));
             minm.setText(r+"");
             S.setText(score+"");

            String sql= "insert into testscore values";
             sql=sql + "('" + tc + "','" + uid;
              sql= sql + "','" + score +"" + "')";
              System.out.println(sql);  
 
             smt.executeUpdate(sql);

           

              if(score>=r)
               m2.setText("Congratulation For Success in Test");
              else

        m2.setText("Sorry, For Failure in Test");  
   

              
         }
           catch(Exception e)
           {e.printStackTrace();}


        
        
    
        exit.addActionListener(this);

          
     } 
   
      
  
     public void actionPerformed(ActionEvent e)
     {
       if(e.getSource() == exit)
     {
       System.exit(0);
     }
     }
  }

