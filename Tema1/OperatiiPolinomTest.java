import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperatiiPolinomTest {
	
	
	@Test
	void testSumaPolinom() {
		Polinom p=new Polinom();
		Polinom q=new Polinom();
		p.parsarePolinom("2x^2+4x+3");
		q.parsarePolinom("x+1");
		Polinom result=p.sumaPolinom(q);
		assertEquals("2.0x^2+5.0x+4.0",result.afisarePolinom());
	}
	@Test
	void testDiferentaPolinom() {
		Polinom p=new Polinom();
		Polinom q=new Polinom();
		p.parsarePolinom("2x^2+4x+3");
		q.parsarePolinom("x+1");
		Polinom result=p.diferentaPolinom(q);
		assertEquals("2.0x^2+3.0x+2.0",result.afisarePolinom());
	}
	@Test
	void testProdusPolinom() {
		Polinom p=new Polinom();
		Polinom q=new Polinom();
		p.parsarePolinom("2x^2+4x+3");
		q.parsarePolinom("x+1");
		Polinom result=p.produsPolinom(q);
		assertEquals("2.0x^3+6.0x^2+7.0x+3.0",result.afisarePolinom());
	}
	@Test
	void testRaportPolinom() {
		Polinom p=new Polinom();
		Polinom q=new Polinom();
		p.parsarePolinom("2x^2+4x+3");
		q.parsarePolinom("x+1");
		Polinom result=p.raportPolinom(q);
		assertEquals("2.0x+2.0",result.afisarePolinom());
	}

}
