package java0718;

public class InterEx {

	public static void main(String[] args) {
		ImpLc imp = new ImpLc();
		
		InterA ia = imp;
		ia.methodA();
		
		InterB ib = imp;
		ib.methodB();
		
		InterC ic = imp;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}

}
