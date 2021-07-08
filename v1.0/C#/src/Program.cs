using System;
using System.Numerics;

namespace BigPrimes
{
    class Program
    {
		static BigInteger Mersenns(int k)
		{
			BigInteger Mplus1 = BigInteger.Pow(new BigInteger(2), k);
			return BigInteger.Subtract(Mplus1, BigInteger.One);

		}
		static bool isPrime(int p)
		{
			BigInteger Mp = Mersenns(p);
			Console.WriteLine("Number: " + Mp);
			Console.WriteLine("Digit count: " + Mp.ToString().Length);
			BigInteger Sp = new BigInteger(4);
			int k = 1;
			while (k != p - 1)
			{
				Sp = BigInteger.Multiply(Sp, Sp);
				Sp = BigInteger.Subtract(Sp, new BigInteger(2));
				Sp = BigInteger.Remainder(Sp, Mp);
				k++;

			}
			if (Sp.Equals(new BigInteger(0)))
				return true;
			else return false;

		}
		static void Main(string[] args)
        {
			Console.WriteLine("Enter odd prime number");
			var c = Console.ReadLine();
            int p = int.Parse(c);
			Console.WriteLine("Is prime: "+isPrime(p));
			Console.WriteLine("Press any key to exit");
			while (Console.ReadKey()==null)
			{ }	
        }
    }
}
