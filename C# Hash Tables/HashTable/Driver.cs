using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HashTable
{
    class Driver
    {
        static void Main(string[] args)
        {
            HashTable<string> table = new HashTable<string>(33, .75);

            Random rand = new Random();
            table.insert(new KeyPair<string>(3, "apple"));
            for (int i = 0; i < 30; i++)
            {
                table.insert(new KeyPair<string>((Math.Abs((int)(rand.NextDouble()*100))), (Math.Abs((int)(rand.NextDouble() * 1000)) + "")));
            }
            Console.WriteLine(table.to_string());
        }
    }
}
