
public class Monom implements Comparable<Monom> {
	private double coef;
	private int exp;
	public Monom(double coef,int exp)
	{
		this.coef=coef;
		this.exp=exp;
	}
	public Monom() {
	
	}
	public Monom sumaMonom(Monom a)
	{
		if(this.coef+a.getCoef()==0)
			return(new Monom(0,0));
		else
			return new Monom(this.coef+a.getCoef(),this.exp);
	}
	public Monom diferentaMonom(Monom a)
	{
		if(this.coef-a.getCoef()==0)
		return(new Monom(0,0));
		else
		return new Monom(this.coef-a.getCoef(),this.exp);
	}
	public Monom produsMonom(Monom a)
	{
		return new Monom(this.coef*a.getCoef(),this.exp+a.getExp());
	}
	public Monom raportMonom(Monom a)
	{
		return new Monom(this.coef/a.getCoef(),this.exp-a.getExp());
	}
	
	public double getCoef() {
		return coef;
	}		
	public int getExp() {
		return exp;
	}
	@Override public int compareTo(Monom m)
	{
		if(this.getExp()>m.getExp())
			return -1;
		else if(this.getExp()<m.getExp())
			return 1;
		else return 0;
	}
	@Override public String toString()
	{
		return new String(this.getCoef()+"x^"+this.getExp()+"+");
	
	}
	



}
