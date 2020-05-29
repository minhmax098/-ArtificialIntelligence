package GradientDescent;

import java.util.Random;

public class RoiDoc {
	public static void main(String[] args) {
		new RoiDoc();
	}
	
	double f(double x) {
		return (x-1)*(x-1); 
	}
	
	double f1(double x) {
		double d = 1e-8;
		//return 2*(x-1);
		return (f(x+d)-f(x))/d;
	}
	
	Random rand = new Random();
	
	public RoiDoc() {
		//Random tại các giá trị của x 
		//double x = rand.nextDouble();
		double x =5;
		//double alpha = 0.5;
		double alpha = 0.1;
		for(int i =0; i<100; i++) {
			System.out.println(x + ","+ f(x));
			x = x- alpha*f1(x);
			//System.out.println(x + ","+ f(x));
		}
	}
	

}
