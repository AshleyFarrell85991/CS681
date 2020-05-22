import java.util.LinkedList;

public class PrimeFactorizer {
	protected long dividend, from, to;
	protected LinkedList<Long> factors = new LinkedList<Long>();
	
	public PrimeFactorizer(long dividend){
		if(dividend >= 2){
			this.dividend = dividend;
			this.from = 2;
			this.to = dividend;
		}else{
			throw new RuntimeException("dividend must be >= 2. dividend==" + dividend);
		}
	}
	
	public void generatePrimeFactors() {
		long divisor = 2;
	    while( dividend != 1 && divisor <= to ){
		    if(dividend % divisor == 0) {
		        factors.add(divisor);
		        dividend /= divisor;
		    }else {
		    	if(divisor==2){ divisor++; }
		    	else{ divisor += 2; }
		    	
		    }
		}
	}
	
	public LinkedList<Long> getPrimeFactors(){
		return factors;
	}



}
