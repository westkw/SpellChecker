/**
 * This is a string set data structure, that is implemented as a Hash Table. 
 * This data structure supports operations insert, find and print - that insert a new 
 * String, finds a String key and prints the contents of the data structure resp.
 */
public class StringSet {

  StringNode [] table;	// Hash table - collisions resolved through chaining.
  int numelements;	// Number of elements actually stored in the structure.
  int size;					// Allocated memory (size of the hash table).

  /** 
   * Constructur: initilaizes numelements, size and initial table size.
   */
  public StringSet() {
	  numelements = 0;
	  size = 100;
	  table = new StringNode[size];
  }

  /*
   * inserts a new key into the set. Inserts it at the head of the linked list given by its hash value.
   */
  public void insert(String key) {
	  if(!find(key))
	  {
		  int index = hash(key);
		  StringNode ins = new StringNode(key, null);
		  StringNode iter;
		  if (numelements == size) {
			  //TODO: need to expand the hash table and rehash its contents.
			  StringSet expand = new StringSet();
			  expand.numelements = numelements;
			  expand.size = size * 2;
			  expand.table = new StringNode[expand.size];
			  for(int i = 0; i < size; i++)
			  {
				  iter = table[i];
				  while(iter != null)
				  {
					  expand.insert(iter.getKey());
					  iter = iter.getNext();
				  }
			  }
			  table = expand.table;
			  size = expand.size;

		  }
		  //TODO: Code for actual insert.
		  if(table[index] == null)
		  {
			  table[index] = ins;
		  }
		  else
		  {
			  iter = table[index];
			  while(iter.getNext() != null)
			  {
				  iter = iter.getNext();
			  }
			  iter.setNext(ins);

		  }
		  numelements++;
	  }

  }

  /*
   * finds if a String key is present in the data structure. Returns true if found, else false.
   */
  public boolean find(String key) {
    // TODO:
	int index = hash(key);
	StringNode iter = table[index];
	while(iter != null)
	{
		if(iter.getKey().equals(key))
		{
			return true;
		} 
		iter = iter.getNext();
	}
    return false;
  }

  /*
   * Prints the contents of the hash table.
   */
  public void print() {
    // TODO:
	  StringNode iter;
	  for(int i = 0; i < size; i++)
	  {
		  iter = table[i];
		  while(iter != null)
		  {
			  System.out.println(iter.getKey());
			  iter = iter.getNext();
		  }
	  }
  }

  /*
   * The hash function that returns the index into the hash table for a string k.
   */
  private int hash(String k) {
    int h = 0;
    // TODO: Compute a polynomial hash function for the String k. Make sure that the hash value h returned is a proper index 
    // in the hash table, ie. in the range [0...capacity-1]. 
    int x = 41;
    for (char a: k.toCharArray())
    {
    	h = (h * x + a) % (size - 1);
    }
    return h;
  }

}
