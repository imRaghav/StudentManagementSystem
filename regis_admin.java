import  javax.swing.*;
import java.awt.*;
class demo_r extends JFrame
{
	JLabel msg=new JLabel("Welcome in OnLine Testing System");
	JLabel id=new JLabel("ID");
	JLabel name=new JLabel("Name");
	JLabel addr=new JLabel("Address");
	JLabel cont_no=new JLabel("Contact no");
	JLabel sex= new JLabel("Sex");
	JLabel qual=new JLabel("Qualification");
	JLabel pass=new JLabel("Password");
	JTextField i_d=new JTextField(10);
	JTextField n_ame=new JTextField(10);
	JTextField a_ddr=new JTextField(10);
	JTextField c_no=new JTextField(10);
	JTextField s_ex=new JTextField(10);
	JTextField q_ual=new JTextField(10);
	JTextField p_ass=new JTextField(10);
	JButton next=new JButton("Next");
	JButton prev=new JButton("Prev");
	JButton first=new JButton("First");
	JButton last=new JButton("Last");
	JButton add=new JButton("Add");
	JButton save=new JButton("Save");
	JButton delete=new JButton("Delete");
	JButton find=new JButton("Find");
	JButton click_next=new JButton("Click ");
	Container con;


public demo_r()
{

	 con = getContentPane();
                con.setLayout(null);
		setTitle("Welcome to Online Test");
		setSize(1400,768);
		//setLocation(500,125);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.add(msg);
		con.add(id);
		con.add(name);
		con.add(addr);
		con.add(cont_no);
		con.add(sex);
		con.add(qual);
		con.add(pass);
		con.add(first);
		con.add(last);
		con.add(next);
		con.add(prev);
		con.add(add);
		con.add(save);
		con.add(delete);
		con.add(find);
		con.add(click_next);
		con.add(i_d);
		con.add(n_ame);
		con.add(cont_no);
		con.add(sex);
		con.add(qual);
		con.add(pass);
		con.add(a_ddr);
		con.add(c_no);
		con.add(s_ex);
		con.add(q_ual);
		con.add(p_ass);
		con.add(next);
		con.add(first);
		con.add(prev);
		con.add(last);
		con.add(add);
		con.add(save);
		con.add(delete);
		con.add(find);
		con.add(click_next);
		msg.setBounds(600,20,210,50);//(x,y,width,height)
		id.setBounds(450,120,100,50);
        name.setBounds(450,160,100,50);
         addr.setBounds(450,200,100,50);
         cont_no  .setBounds(450,240,100,50);
         sex .setBounds(450,280,100,50);
          qual.setBounds(450,320,100,50);
          pass.setBounds(450,360,100,50);
        i_d.setBounds(750,135,100,20);
        n_ame.setBounds(750,175,100,20);
        a_ddr.setBounds(750,215,100,20);
        c_no.setBounds(750,255,100,20);
        s_ex.setBounds(750,295,100,20);
        q_ual.setBounds(750,335,100,20);
        p_ass.setBounds(750,375,100,20);
        next.setBounds(420,450,80,30);
        prev.setBounds(540,450,80,30);
        first.setBounds(660,450,80,30);
        last.setBounds(780,450,80,30);
       add.setBounds(420,500,80,30);
        save.setBounds(540,500,80,30);
        delete.setBounds(660,500,80,30);
        find.setBounds(780,500,80,30);
        
        click_next.setBounds(860,500,80,30);











}	
public static void main(String[] args) {
	new demo_r();
}
}








