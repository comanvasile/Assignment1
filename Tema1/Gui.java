import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Gui extends JFrame implements ActionListener  {
	private static final long serialVersionUID=1L;
	private JPanel pane=new JPanel(new GridBagLayout());
	GridBagConstraints c=new GridBagConstraints();
	private JLabel l1=new JLabel("Polinom 1");
	private JLabel l2=new JLabel("Polinom 2");
	private JLabel l3=new JLabel("Rezultat/Cat");
	private JLabel l4=new JLabel("Rest Impartire");
	private JTextField tf1=new JTextField(40);
	private JTextField tf2=new JTextField(40);
	private JTextField tf3=new JTextField(40);
	private JTextField tf4=new JTextField(40);
	private JButton btn1=new JButton("Citeste");
	private JButton btn2=new JButton("Citeste");
	private JButton btn3=new JButton("+");
	private JButton btn4=new JButton("-");
	private JButton btn5=new JButton("*");
	private JButton btn6=new JButton("/");
	private JButton btn7=new JButton("Integrare");
	private JButton btn8=new JButton("Derivare");
	private JCheckBox c1=new JCheckBox();
	private JCheckBox c2=new JCheckBox();
	private Polinom p=new Polinom();
	private Polinom q=new Polinom();
	
	public Gui(String name)
	{
		super(name);
		c.gridx=3;
		c.gridy=0;
		pane.add(c1,c);
		c1.addActionListener(this);
		c.gridx=3;
		c.gridy=1;
		pane.add(c2,c);
		c2.addActionListener(this);
		c.gridx=0;
		c.gridy=0;
		pane.add(l1,c);
		c.gridx=0;
		c.gridy=1;
		pane.add(l2,c);
		c.gridx=1;
		c.gridy=0;
		pane.add(tf1,c);
		c.gridx=1;
		c.gridy=1;
		pane.add(tf2,c);
		c.gridx=2;
		c.gridy=0;
		pane.add(btn1,c);
		btn1.addActionListener(this);
		c.gridx=2;
		c.gridy=1;
		pane.add(btn2,c);
		btn2.addActionListener(this);
		c.gridx=4;
		c.gridy=0;
		pane.add(btn3,c);
		btn3.addActionListener(this);
		c.gridx=4;
		c.gridy=1;
		pane.add(btn4,c);
		btn4.addActionListener(this);
		c.gridx=4;
		c.gridy=2;
		pane.add(btn5,c);
		btn5.addActionListener(this);
		c.gridx=4;
		c.gridy=3;
		pane.add(btn6,c);
		btn6.addActionListener(this);
		c.gridx=4;
		c.gridy=4;
		pane.add(btn7,c);
		btn7.addActionListener(this);
		c.gridx=4;
		c.gridy=5;
		pane.add(btn8,c);
		btn8.addActionListener(this);
		c.gridx=0;
		c.gridy=2;
		pane.add(l3,c);
		c.gridx=0;
		c.gridy=3;
		pane.add(l4,c);
		c.gridx=1;
		c.gridy=2;
		pane.add(tf3,c);
		c.gridx=1;
		c.gridy=3;
		pane.add(tf4,c);
		
		this.add(pane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		Polinom r;
		r=new Polinom();
		tf4.setVisible(false);
		l4.setVisible(false);
		if(c1.isSelected())
		{
			c2.setSelected(false);		
		}
		if(source==btn1)
		{
			p.parsarePolinom(tf1.getText());
		}
		if(source==btn2)
		{
			q.parsarePolinom(tf2.getText());
		}
		if(source==btn3)
		{
			
			r=p.sumaPolinom(q);
			tf3.setText(r.afisarePolinom());
		}
		if(source==btn4)
		{
			
			r=p.diferentaPolinom(q);
			tf3.setText(r.afisarePolinom());
		}
		if(source==btn5)
		{
			
			r=p.produsPolinom(q);
			tf3.setText(r.afisarePolinom());
		}
		if(source==btn6)
		{
			tf4.setVisible(true);
			l4.setVisible(true);
			r=p.raportPolinom(q);
			tf3.setText(r.afisarePolinom());
			tf4.setText(p.diferentaPolinom(q.produsPolinom(r)).afisarePolinom());
		}
		if(source==btn7)
		{	
			if(c1.isSelected())
				r=p.integrarePolinom();
			else if(c2.isSelected())
				r=q.integrarePolinom();
			tf3.setText(r.afisarePolinom());
		}
		if(source==btn8)
		{	
			if(c1.isSelected())
				r=p.derivarePolinom();
			else if(c2.isSelected())
				r=q.derivarePolinom();
			tf3.setText(r.afisarePolinom());
		}
	
		
		
	}
	
	public static void main(String[] args) {
		JFrame frame=new Gui("Polinom");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	

}
