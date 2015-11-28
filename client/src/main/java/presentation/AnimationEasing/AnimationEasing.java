package presentation.AnimationEasing;

public class AnimationEasing {
	
	public static double easeInElastic(double x, double t, double b, double c, double d) {
		double s=1.70158;double p=0;double a=c;

        if (t==0) return b; 
        
        if ((t/=d)==1) return b+c;  
        
        if (p==0) p=d*.3;

        if (a < Math.abs(c)) { a=c;  s=p/4; }

        else  s = p/(2*Math.PI) * Math.asin (c/a);

        return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
	}
	
	public static double easeOutCubic(double x, double t, double b, double c, double d) {
		 if ((t/=d/2) < 1) 
			 return c/2*t*t*t + b;

         return c/2*((t-=2)*t*t + 2) + b;
	}
	
	public static double easeInQuad(double x, double t, double b, double c, double d) {
		return c*(t/=d)*t + b;
	}
	
	public static double easeInOutQuint(double x, double t, double b, double c, double d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t*t + b;

        return c/2*((t-=2)*t*t*t*t + 2) + b;
	}
	
}
