.. Spell Checker documentation master file, created by
   sphinx-quickstart on Fri Sep  6 22:19:21 2019.
   You can adapt this file completely to your liking, but it should at least
   contain the root `toctree` directive.

Spell Checker Documentation
============================


The Problem
-----------
SpellChecker is a Java project that allows the user to type in a word and the SpellChecker class will
tell you if your word is in a dictionary. If the word is not in the dictionary it will list all words 
in the dictionary that are one letter apart. If there are no words in the dictionary that are one letter 
apart then SpellChecker will not print anything.::

   Dictionary loaded...
   dog
   dog is correct.
   cat
   cat is correct.
   birb
   Suggesting alternatives ...
   barb
   bird
   fjkdlfdsfds
   Suggesting alternatives ...




Installation and Usage
----------------------
1. Clone the SpellChecker project from the github repository::

   $ git clone https://github.com/westkw/SpellChecker.git

2. Navigate to the SpellChecker directory::

   $ cd SpellChecker

3. Compile the classes using the included make file::

   $ make

4. Run the SpellChecker class::
   
   $ java SpellChecker

5. When finished type::
   
   $ [ctrl]C

6. To clean up the directory::
   
   $ make clean

*After running step 6 you will need to start at step 3 if you want to run SpellChecker*

FAQ
---
SpellChecker.java is an implementation of the StringSet class. The StringSet class is a `hash table 
<https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/tutorial/>`_ that 
supports the operations find, insert, and print. The elements of the hash table are StringNode objects. 
Each of these objects contain a single string value and a pointer to the next node::

   public StringNode(String _key, StringNode _next) {
      key = _key;
      next = _next;
   }

The StringNodes allow for string objects to be chained together into the hash table. The string objects are given to the 
SpellChecker through a dictornary.txt file containing all the correct words. Each object is then hashed::

   private int hash(String k) {
      int h = 0;
      //Compute a polynomial hash function for the String k. Make sure that the hash value h returned is a proper index 
    // in the hash table, ie. in the range [0...capacity-1]. 
      int x = 41;
      for (char a: k.toCharArray())
      {
         h = (h * x + a) % (size - 1);
      }
   return h;
   }

The h that is returned is the index that the string will be inserted into the StringSet. If two different strings hash to the same 
index the `collision <https://www.geeksforgeeks.org/hashing-set-2-separate-chaining/>`_ will be solved through chaining. SpellChecker 
uses that dictionary hash table to check if the string given is correct. It compares each letter of the string to every dictionary 
string and counts each time the letter is the same. If the count is one less than the string length you know the dictionary string is one letter apart:: 

   if(word.length() == iter.getKey().length())
   {
      if(sameCount == (word.length() - 1)) //checks if the count is one less meaning one letter difference    
      {
         suggestions.insert(iter.getKey());
      }
   }

If the dictionary string is one letter apart it is inserted to a different hash table called suggestions which then is printed to show all words that you might have wanted to type.

Contribute
-----------
If you would like to contribute to the SpellChecker project you can find the code `here <https://github.com/westkw/SpellChecker.git>`_::

   https://github.com/westkw/SpellChecker.git

Support
--------
If you have any questions or other concerns about the project you can contact me at::

   westkw@appstate.edu

Licensing
----------
Copyright (c) 2019 Kyle West

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to 
deal in the Software without  restriction,  including  without  limitation  the  rights  to  use,  copy,  modify, merge, publish, distribute, 
sublicense, and/or sell copies of the Software, and to per-mit persons to whom the Software is furnished to do so, subject to the following conditions:

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRAN-TIES OF MERCHANTABILITY, 
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS  BE  LIABLE  FOR  ANY  CLAIM,  DAMAGES  OR  
OTHER  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
