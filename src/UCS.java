import java.util.*;

public class UCS extends WordLadder {

    @Override
    public List<String> findLadder(String beginWord, String endWord, List<String> wordList){
        
        // if the end word is not available in the dictionary, then return empty list
        if (!wordList.contains(endWord)){
            return Collections.emptyList();
        }

        Set<String> dict = new HashSet<>(wordList); // convert wordList into a HashSet for faster look-up times
        
        // initializes a priority queue that orders nodes by the number of steps taken, characteristic of UCS
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.steps));
        queue.add(new Node(beginWord, 1, null));

        // create a list to store the checked nodes
        List<String> checkedNodes = new ArrayList<>();

        while (!queue.isEmpty()){
            Node node = queue.remove(); // removes the node with the lowest number of steps from the queue
            String word = node.word; // stores the current word from the node

            checkedNodes.add(word);

            // checks if the current word is the endWord
            if (word.equals(endWord)){ 
                List<String> ladder = new ArrayList<>();
                while (node != null){ 
                    ladder.add(0, node.word);
                    node = node.prev;
                }
                System.out.println("Number of Checked Nodes: " + checkedNodes.size());
                return ladder;
            }

            // converts the word to a character array to make checking easier
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++){ // loops over each character in the array
                for (char c = 'a'; c < 'z'; c++){
                    char temp = arr[i]; // stores the original character for restoration later
                    if (arr[i] != c){ // change the character if the character is different
                        arr[i] = c;
                    }

                    String newWord = new String(arr); // creates a new string from the modified character
                    
                    // if the new word is in the dictionary, add a mew node for the new word
                    if (dict.contains(newWord)){ 
                        queue.add(new Node(newWord, node.steps + 1, node));
                        dict.remove(newWord); // remove the new word from the dictionary to avoid revisiting
                    }

                    arr[i] = temp; // restores the original character
                }
            }
        }
        return Collections.emptyList(); // return empty list if no path found
    }
}
