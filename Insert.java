import java.sql.*;
class insert
{
   static String user;
insert(int marks)
{
                   try{
                                     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                     Connection con=DriverManager.getConnection("jdbc:odbc:test123");
                                     Statement st=con.createStatement();
                                     System.out.print("uid="+user+"marks="+marks);
                            st.executeQuery("update Register set uscore=marks where uid='"+user+"' ");
                        }  catch(Exception e){System.out.print(e);}
                     
}
}

