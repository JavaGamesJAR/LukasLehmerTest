import java.math.BigInteger;
import java.io.IOException;
import java.lang.Runtime.*;

public class primes 
{
	static void setStackSize(double a, char b) throws IOException
	{
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec("java -Xss"+a+b);
		
	}
	/*static BigInteger S(int k)
	{
		//System.out.println(k);
		if(k==1)
			return new BigInteger("4");
		else
			return (S(k-1).pow(2)).subtract(new BigInteger("2"));
		
	}*/
	static BigInteger Mersenns(int k)
	{
		return (new BigInteger("2").pow(k)).subtract(BigInteger.ONE);
		
	}
	BigInteger pow(BigInteger base, BigInteger exponent) {
		  BigInteger result = BigInteger.ONE;
		  while (exponent.signum() > 0) {
		    if (exponent.testBit(0)) result = result.multiply(base);
		    base = base.multiply(base);
		    exponent = exponent.shiftRight(1);
		  }
		  return result;
		}
	/*static boolean isPrime(int p)
	{
		BigInteger Mp = Mersenns(p);
		System.out.println(Mp);
		BigInteger Sp = S(p-1);
		System.out.println(Sp);
		BigInteger r = Sp.remainder(Mp);
		if(r.equals(BigInteger.ZERO))
			return true;
		else return false;
		
	}*/
	static boolean isPrime(int p)
	{
		BigInteger Mp = Mersenns(p);
		System.out.println("Number: "+Mp);
		System.out.println("Digit count: "+Mp.toString().length());
		BigInteger Sp = new BigInteger("4");
		int k = 1;
		while(k!=p-1)
		{
			//System.out.println(k);
			Sp = ((Sp.multiply(Sp)).subtract(new BigInteger("2"))).remainder(Mp);
			k++;
			
		}
		if(Sp.equals(BigInteger.ZERO))
			return true;
		else return false;
		
	}
	public static void main(String[] args) throws IOException 
	{
		setStackSize(10, 'm');
		int p = 19937; //TODO Change this to test another prime
		System.out.println("Is prime: "+isPrime(p));

	}

}
