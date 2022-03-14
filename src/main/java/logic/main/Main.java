package logic.main;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * using lambda expression
		 */
		ProvaInterfaccia pI = (a ,b) -> a+b; 
		
		ProvaInterfaccia pI2 = (a, b) -> {
			double a2 = a*2;
			double b2 = b*2;
			double c = a2+b2;
			return c;
		};
		
		double a = 5, b = 7;
		System.out.println("Using lambda expression");
		System.out.println("Risultato prima interfaccia: " + pI.esegui(a, b));
		System.out.println("Risultato seconda interfaccia: "+ pI2.esegui(a, b));
		
		/**
		 * without using lambda expression
		 */
		ProvaInterfaccia wpI = new ProvaInterfaccia() {

			@Override
			public double esegui(double a, double b) {
				return a+b;
			}
			
		};
		
		ProvaInterfaccia wpI2 = new ProvaInterfaccia() {

			@Override
			public double esegui(double a, double b) {
				double a2 = a*2;
				double b2 = b*2;
				double c = a2+b2;
				return c;
			}
			
		};
		
		double wa = 5, wb = 7;
		System.out.println("Without using lambda expression");
		System.out.println("Risultato prima interfaccia: " + wpI.esegui(wa, wb));
		System.out.println("Risultato seconda interfaccia: "+ wpI2.esegui(wa, wb));
		
	}

}
