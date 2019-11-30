import java.util.logging.Logger;

import org.aspectj.lang.Signature;


public aspect ProducerAspect {
	 Logger logger = Logger.getLogger("Tracing");  

		pointcut traceMethods() : (execution(* *(..))&& !cflow(within(Main)));
		 
	    before(): traceMethods(){
	    	
	        Signature sig = thisJoinPointStaticPart.getSignature();
	       // String line =""+ thisJoinPointStaticPart.getSourceLocation().getLine();
	       // String sourceName = thisJoinPointStaticPart.getSourceLocation().getWithinType().getCanonicalName();
	      System.out.println(
	    		  thisJoinPoint.getTarget() +" -> "+  sig.getDeclaringTypeName() + "." + sig.getName()
	        );
}
}
