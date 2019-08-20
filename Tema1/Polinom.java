import java.util.*;

public class Polinom {
	private ArrayList<Monom> poli=new ArrayList<Monom>();
	public Polinom(ArrayList<Monom> poli)
	{
		this.poli=poli; 
	}
	
	public Polinom() 
	{
		
	}
	public Polinom sumaPolinom(Polinom poli)
	{
		ArrayList<Monom> m=new ArrayList<Monom>();
		int ok;
		for(Monom p1: this.poli)
		{
			ok=0;
			for(Monom p2: poli.getPoli())
			{
				if(p1.compareTo(p2)==0) 
				{
					m.add(p1.sumaMonom(p2));
					ok=1;	
				}
			}
			if(ok==0)
			{
				m.add(p1);
			}
		}
		for(Monom p1: poli.getPoli())
		{
			ok=0;
			for(Monom p2: this.getPoli())
			{
				if(p1.compareTo(p2)==0)
				{
					ok=1;	
				}
			}
			if(ok==0)
			{
				m.add(p1);
			}
		}
		m.sort(null);
		return new Polinom(m);
	}
	public Polinom diferentaPolinom(Polinom poli)
	{
		ArrayList<Monom> m=new ArrayList<Monom>();
		int ok;
		for(Monom p1: this.poli)
		{
			ok=0;
			for(Monom p2: poli.getPoli())
			{
				if(p1.compareTo(p2)==0) 
				{
					m.add(p1.diferentaMonom(p2));
					ok=1;	
				}
			}
			if(ok==0)
			{
				m.add(p1);
			}
		}
		for(Monom p1: poli.getPoli())
		{
			ok=0;
			for(Monom p2: this.getPoli())
			{
				if(p1.compareTo(p2)==0)
				{
					ok=1;	
				}
			}
			if(ok==0)
			{	
				m.add(new Monom(-p1.getCoef(),p1.getExp()));
			}
		}
		m.sort(null);
		return new Polinom(m);
	}
	private void restrangePolinom()
	{
		int i;
		ArrayList <Monom> m=new ArrayList<Monom>();
		Monom aux = new Monom();
		this.getPoli().sort(null);
		for(i=0;i<this.getPoli().size()-1;i++)	
		{	
			aux=new Monom(this.getPoli().get(i).getCoef(),this.getPoli().get(i).getExp());
			while(aux.compareTo(this.getPoli().get(i+1))==0 &&(i<this.getPoli().size()-2))
			{
				aux=aux.sumaMonom(this.getPoli().get(i+1));
				i++;
			}
			if(aux.compareTo(this.getPoli().get(this.getPoli().size()-1))!=0)
			m.add(aux);
		}
		if(aux.compareTo(this.getPoli().get(this.getPoli().size()-1))==0)
		{
			m.add(aux.sumaMonom(this.getPoli().get(this.getPoli().size()-1)));
		}
		else
		{
		m.add(new Monom(this.getPoli().get(this.getPoli().size()-1).getCoef(),this.getPoli().get(this.getPoli().size()-1).getExp()));
		}
		this.setPoli(m);
	}
	public Polinom produsPolinom(Polinom poli)
	{
		ArrayList<Monom> m=new ArrayList<Monom>();
		for(Monom m1: this.getPoli())
		{
			for(Monom m2: poli.getPoli())
				{
				m.add(m1.produsMonom(m2));
				}
		}
		m.sort(null);
		Polinom polinom=new Polinom(m);
		polinom.restrangePolinom();
		return polinom;
	}
	public Polinom raportPolinom(Polinom poli) 
	{
		Polinom deimpartit=this;
		Polinom impartitor=poli;
		ArrayList<Monom> m=new ArrayList<Monom>();
		if(this.grad()<poli.grad())
		{
			m.add(new Monom(0,0));
			return new Polinom(m);
			
		}
		if(poli.grad()==0)
		{
			for(Monom p1: this.poli)
				{
				m.add(p1.raportMonom(this.poli.get(0)));
				}
				return new Polinom(m);
		}
		while(impartitor.grad()<=deimpartit.grad())
		{
			
			Monom m1=deimpartit.getPoli().get(0);
			Monom m2=impartitor.getPoli().get(0);
			Monom m3=m1.raportMonom(m2);
			m.add(m3);
		    ArrayList <Monom> lista=new ArrayList<Monom>();
		    lista.add(m3);
			Polinom aux=new Polinom(lista);
			Polinom p=impartitor.produsPolinom(aux);
			deimpartit=deimpartit.diferentaPolinom(p); 
		}
		return new Polinom(m);	  
	}
	private int grad()
	{
		this.getPoli().sort(null);
		return this.getPoli().get(0).getExp();
	}
	public Polinom derivarePolinom()
	{
		ArrayList<Monom> m=new ArrayList<Monom>();
		for(Monom m1: this.getPoli())
		{
			m.add(new Monom(m1.getCoef()*m1.getExp(),m1.getExp()-1));
		}
		return new Polinom(m);
	}
	public Polinom integrarePolinom()
	{
		ArrayList<Monom> m=new ArrayList<Monom>();
		for(Monom m1: this.getPoli())
		{
			m.add(new Monom(m1.getCoef()/(m1.getExp()+1),m1.getExp()+1));
		}
		return new Polinom(m);
	}
	public void parsarePolinom(String s) 
	{
		ArrayList<Monom> p=new ArrayList<Monom>();
		s=s.replaceAll("-","\\+-");
		s=s.replaceAll(" ","");
		s=s.replaceAll("X","x");
		s=s.replaceAll("-x","-1x");
		s=s.replaceAll("\\+x","\\+1x");
		s=s.replaceAll("x\\+","x\\^1\\+");
		s=s.replaceAll("^x","1x");
		s=s.replaceAll("x$","x\\^1");
		String[] m=s.split("\\+");
		for(String monom: m)
		{
			if(!monom.equals(""))
			{
				if(!monom.contains("x"))
				{
					p.add(new Monom(new Double(monom),0));	
				}
				else
				{
					double coeficient=new Double(monom.substring(0,monom.indexOf('x')));
					int exponent=new Integer(monom.substring(monom.indexOf('^')+1));
					p.add(new Monom(coeficient,exponent));
				}
			}
		}
		this.setPoli(p);
		this.restrangePolinom();	
	}
	public String afisarePolinom()
	{
		this.restrangePolinom();
		String s=new String();
		for(Monom m: this.getPoli())
		{
			if(m.getCoef()!=0)
			{
				s=s+""+(m.toString());
			}
				
		}
		s=s.replaceAll("x\\^1\\+","x\\+");
		s=s.replaceAll("x\\^0","");
		s=s.replaceAll("\\+1.0x","\\+x");
		s=s.replaceAll("-1.0x","-x");
		s=s.replaceAll("^1.0x","\\+x");
		s=s.replaceAll("^-1.0x","-x");
		s=s.replaceAll("\\+-","-");
		s=s.replaceAll("^\\+","");
		s=s.replaceAll("\\+$","");
		return s;
	}	
	private ArrayList<Monom> getPoli() {
		return poli;
	}
	private void setPoli(ArrayList<Monom> poli) {
		this.poli = poli;
	}
}
