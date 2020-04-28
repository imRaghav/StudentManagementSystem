import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
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
		setSize(600,600);
                Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
                 int sw=(int) d.getWidth();
                 int sh=(int) d.getHeight();
		
		setLocation((sw-600)/2,(sh-600)/2);
		
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
                              {
                                   dispose();
                                  new Login();
                              }
                }
       




                 
         
             
 
 }//end of class                
             
                     
                     
                
	

  

    
  




        









