import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        Astar astar = new Astar();
        List<String> ladder = astar.findLadder("hit", "log", wordList);
        System.out.println(String.join(" -> ", ladder));
    }
}
