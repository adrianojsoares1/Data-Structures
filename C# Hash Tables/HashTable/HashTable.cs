using System;
using System.Text;

namespace HashTable
{
    class KeyPair<V> where V : IComparable
    {   
        public KeyPair(int key, V val)
        {
            Key = key;
            Value = val;
        }
        public int Key { get; set; }
        public V Value { get; set; }
    }

    class HashTable<V> where V : IComparable

    {
        public double load_factor { get; private set; }
        private int size;
        public int active_elements { get; private set; }
        private readonly int default_size;

        private KeyPair<V>[] map { get; set; }

        public HashTable(int size, double load_factor)
        {
            this.load_factor = load_factor;
            this.size = size;
            default_size = size;
            active_elements = 0;
            map = new KeyPair<V>[size];
        }

        /// <summary>
        /// Generate an index given a key
        /// </summary>
        /// <param name="key">key to be indexed</param>
        /// <returns>int</returns>
        private int _hash(int key)
        {
            /* string hasher, if need be.
            int val = 0;
            for(int i = 0; i < key.Length; i++)
            {
                val += key[i];
            }
            (val * key.Length) % this.size;
            */
            return key % size;
        }

        /// <summary>
        /// Return overall table size. NOT active elements.
        /// </summary>
        /// <returns>int</returns>
        public int Length() { return size; }

        /// <summary>
        /// Set the table back to default size.
        /// </summary>
        public void clear()
        {
            map = new KeyPair<V>[default_size];
        }

        /// <summary>
        /// Inserts an element into the table using _linear_insert()
        /// </summary>
        /// <param name="pair">The KeyPair to be added to the table.</param>
        public void insert(KeyPair<V> pair)
        {
            if (((double)active_elements / size) > load_factor)
                _increase_capacity();

            if (pair != null)
            {
                int index = _hash(pair.Key);
                _linear_insert(pair, index);
            }
        }

        /// <summary>
        /// Retrieve a KeyPair from the table.
        /// </summary>
        /// <param name="key">Key of KeyPair to be found.</param>
        /// <returns></returns>
        public V get(int key)
        {
            int index = _hash(key);
            for (int i = 0; i < size; i++)
            {
                if (map[index].Key.Equals(key))
                {
                    Console.WriteLine("Pair found at index: " + index);
                    return map[index].Value;
                }
                index++;
                if (index >= size - 1)
                    index = 0;
            }
            Console.WriteLine("Key not found in table!");
            return default(V);
        }

        /// <summary>
        /// delete a given KeyPair from the table, given its key.
        /// </summary>
        /// <param name="key">the key of KeyPair to be deleted.</param>
        public void delete(int key)
        {
            int index = _hash(key);
            for (int i = 0; i < size; i++)
            {
                if (map[index].Key.Equals(key))
                {
                    map[index] = null;
                    active_elements--;
                }
                index++;
                if (index >= size - 1)
                    index = 0;
            }
            Console.WriteLine("Key not found in table!");
        }

        /// <summary>
        /// Insert given KeyPair of type V into the table using Linear Open Addressing.
        /// </summary>
        /// <param name="pair">KeyPair of type V to be added.</param>
        /// <param name="index">Index to start looking at.</param>
        private void _linear_insert(KeyPair<V> pair, int index)
        {
            for(int i = 0; i < size; i++)
            {
                if(map[index] == null)
                {
                    map[index] = pair;
                    active_elements++;
                    return;
                }
                if (index >= size - 1)
                    index = -1;
                index++;
            }
            Console.WriteLine("Table was full! Could not insert Key Value pair: " + pair);
        }

        /// <summary>
        /// If load capacity is hit, double the table, copying elements.
        /// </summary>
        private void _increase_capacity()
        {
            KeyPair<V>[] temp = new KeyPair<V>[size];
            Array.Copy(map, temp, size);
            active_elements = 0;
            size += size;
            map = new KeyPair<V>[size];

            foreach(KeyPair<V> pair in temp)
                if (pair != null)
                {
                    int index = _hash(pair.Key);
                    _linear_insert(pair, index);
                }
            Console.WriteLine("Table size has been doubled. New length is now " + size + ".");
        }

        /// <summary>
        /// Returns a list of all active elements and their indeces.
        /// </summary>
        /// <returns>string</returns>
        public string to_string()
        {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < map.Length; i++)
                if(!(map[i] == null))
                    str.Append("Pos: " + i + " | " + "Key: " + map[i].Key + " | Value: \"" + map[i].Value + "\"\n");
            return str.ToString();
        }
    }
}