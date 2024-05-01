import java.util.*;

public class Astar extends WordLadder  {
    private int heuristic(String word, String endWord){
        int diff = 0;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) != endWord.charAt(i)){
                diff++;
            }
        }
        return diff;
    }

    @Override
    public List<String> findLadder(String beginWord, String endWord, List<String> wordList){
        if (!wordList.contains(endWord)){
            return Collections.emptyList();
        }

        Set<String> dict = new HashSet<>(wordList);
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.steps + heuristic(node.word, endWord)));
        queue.add(new Node(beginWord, 1, null));

        while (!queue.isEmpty()){
            Node node = queue.remove();
            String word = node.word;

            if (word.equals(endWord)){
                List<String> ladder = new ArrayList<>();
                while (node != null){
                    ladder.add(0, node.word);
                    node = node.prev;
                }
                return ladder;
            }
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++){
                for (char c = 'a'; c < 'z'; c++){
                    char temp = arr[i];
                    if (arr[i] != c){
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (dict.contains(newWord)){
                        queue.add(new Node(newWord, node.steps + 1, node));
                        dict.remove(newWord);
                    }

                    arr[i] = temp;
                }
            }
        }
        return Collections.emptyList();
    }
}
