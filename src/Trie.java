import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given an array of words, find all shortest unique prefixes to represent each word
// Input: ["zebra", "dog", "duck", "dove"] -> dog, dov, du, z
// ["geeksgeeks", "geeksquiz", "geeksforgeeks"] -> geeksf, geeksg, geeksq

// Does it need to be stable?

// Naive solution:
// Consider every prefix of every word and if it is not a prefix of any other String, print it.

// More efficient approach:
// Use a TRIE!
// Insert each String into the Trie...
// Maintain a count in every node, incrementing every time you revisit a node.
// For every word, find the character nearest to the root with frequency 1.
// The prefix of the word is the path from the root to this character.

// Traverse the Trie starting from the root
//    Check node's frequency
//      If frequency = 1, print all characters from root to this node and stop traversing.

public class Trie{
	public int freq = 0;
	public Map<Character, Trie> children = new HashMap<Character, Trie>();

	public void insert(String s, int i){
	    freq++; //Increase count each time
	    while(i<s.length()){
	      char c = s.charAt(i);
	      if(!children.containsKey(c)){
	        children.put(c, new Trie());
	      }
	      Trie child = children.get(c);
	      child.insert(s, i+1);
	    }
	  }

  public String search(String s, int i){
    String prefix = "";
    if(i > 0 && freq == 1){
      prefix = s.substring(0, i);
    }else{
      char ch = s.charAt(i);
      Trie child = children.get(ch);
      prefix = child.search(s, i+1);
    }
    return prefix;
  }

  public List<String> findUniquePrefixes(List<String> words){
    Trie root = new Trie();
    for(String s : words){
      root.insert(s, 0);
    } // Fill the Trie with all the words.

    List<String> prefixes = new ArrayList<String>(); //Initialize resulting list.

    for(String s : words){
      prefixes.add(root.search(s, 0));
    }

    return prefixes;
  }
}
