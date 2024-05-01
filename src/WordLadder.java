import java.util.*;

public abstract class WordLadder {
    protected static class Node {
        String word;
        int steps;
        Node prev;
        
        public Node(String word, int steps, Node prev){
            this.word = word;
            this.steps = steps;
            this.prev = prev;
        }
    }


    // virtual method to find the path
    public abstract List<String> findLadder(String beginWord, String endWord, List<String> wordList);
}
