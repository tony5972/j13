import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class myFrame extends JFrame  implements ActionListener
{
	JLabel rno,name,per;
	JTextField t1,t2,t3;
	JButton b3;
	JPanel p1,p2,p3;
	Connection con;
	PreparedStatement ps;
Statement st;
ResultSet rs;
JTable jt;
JScrollPane jsp;
	public myFrame(String s) 
	{
		super(s);
		p1=new JPanel();
		p2=new JPanel();
p3=new JPanel();
		rno=new JLabel("rno");
		name=new JLabel("name");
		per=new JLabel("percentage");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
                b3=new JButton("display");
		p1.setLayout(new GridLayout(3,2));
		p1.add(rno);
		p1.add(t1);
		p1.add(name);
		p1.add(t2);
		p1.add(per);
		p1.add(t3);

		
  		p2.add(b3);
				
                b3.addActionListener(this);
		Container c=getContentPane();
		c.setLayout(new GridLayout(3,1));
		c.add(p1);
		c.add(p2);

                c.add(p3);
		setSize(300,300);
		setVisible(true);
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:tybcs");
			ps=con.prepareStatement("Insert into student values(?,?,?)");
st=con.createStatement();
		}
		catch(Exception e) {}
	}
	public void actionPerformed(ActionEvent ae)
	{
		

		if(ae.getSource()==b3)
		{
			JFrame f= new JFrame();
			try
			{
			rs=st.executeQuery("select * from student");
		ResultSetMetaData rsmd=rs.getMetaData();
int  nc=rsmd.getColumnCount();
System.out.println(nc);
String colheads[]=new String[nc];
Object [][]o =null;

for(int i=0;i<nc;i++)
{
colheads[i]=rsmd.getColumnName(i+1);


}
o=new Object[100][nc];
System.out.println("sss");
int R=0,NumberOfRows,C;
while(rs.next())
{

            
                for(C=1; C<=nc;C++)
{
                    o[R][C-1]=rs.getObject(C);
//System.out.println(rs.getObject(C));
}                R++;


} 
rs.close();
            NumberOfRows=R;
            Object[][] TempArray=o;
            o=new Object[NumberOfRows][nc];
            for(R=0;R<NumberOfRows;R++)
                for(C=0;C<nc;C++)
                    o[R][C]=TempArray[R][C];
            

JTable jt=new JTable(o,colheads);
int v= ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
int h= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
JScrollPane jsp=new JScrollPane(jt,v,h);
  jsp.setBounds(3, 120, 460, 150);
        
        

f.getContentPane().add(jsp,BorderLayout.CENTER);

f.setSize(300,300);


jt.setVisible(true);
f.show();


}
catch(Exception e){e.printStackTrace();}
}





}
		public static void main(String args[])
	{
		myFrame f=new myFrame("Student Details");
	}
}
