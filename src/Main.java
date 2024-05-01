import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        try {
            String path = "./words_dictionary.txt";
            System.out.println("Welcome to WordLadder Well!!\n");

            Set<String> dictSet = new HashSet<>();
            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                stream.forEach(dictSet::add);
            }

            boolean passWord = false;
            Scanner beginScanner = null;
            Scanner endScanner = null;
            Scanner algoScanner = null;
            String beginWord = "";
            String endWord = "";

            while (!passWord){
                beginScanner = new Scanner(System.in);
                System.out.print("Enter the start word: ");
                beginWord = beginScanner.nextLine().toLowerCase();
                final String finalBeginWord = beginWord;
                
                endScanner = new Scanner(System.in);
                System.out.print("Enter the end word: ");
                endWord = endScanner.nextLine().toLowerCase();
                final String finalEndWord = endWord;
            
                if (!dictSet.contains(beginWord) && !dictSet.contains(endWord)){
                    System.out.println("I'm pretty sure those start word and end word are not English words. Please input English words only.\n");
                }
                else if(!dictSet.contains(beginWord) && dictSet.contains(endWord)){
                    System.out.println("I'm pretty sure that start word is not an English word. Please input English words only.\n");
                }
                else if(dictSet.contains(beginWord) && !dictSet.contains(endWord)){
                    System.out.println("I'm pretty sure that end word is not an English word. Please input English words only.\n");
                }
                else if(finalBeginWord.length() != finalEndWord.length()){
                    System.out.println("You have to enter words with the same length.\n");
                }
                else{
                    passWord = true;
                    dictSet.removeIf(word -> word.length() != finalBeginWord.length());
                }
            }

            
            List<String> dictList = new ArrayList<>(dictSet);

            boolean passAlgo = false;
            long startTime = 0;
            while (!passAlgo){

                System.out.println("\nChoose the algorithm: ");
                System.out.println("1. Uniform-Cost Search (UCS)");
                System.out.println("2. A* Algorithm");
                System.out.println("3. Greedy Best-First-Search");
                System.out.print("\nEnter choosen algorithm: ");
                algoScanner = new Scanner(System.in);

                try {
                    int algorithm = algoScanner.nextInt();
                    System.out.println();
                    if (algorithm == 1){
                        startTime = System.currentTimeMillis();
                        passAlgo = true;
                        UCS ucs = new UCS();
                        List<String> ladder =  ucs.findLadder(beginWord, endWord, dictList);
                        System.out.println("Path: " + String.join(" -> ", ladder));
                        
                    }
                    else if (algorithm == 2){
                        startTime = System.currentTimeMillis();
                        passAlgo = true;
                        Astar astar = new Astar();
                        List<String> ladder = astar.findLadder(beginWord, endWord, dictList);
                        System.out.println("Path: " + String.join(" -> ", ladder));
                    }
                    else if (algorithm == 3){
                        startTime = System.currentTimeMillis();
                        passAlgo = true;
                        GreedyBFS gbfs = new GreedyBFS();
                        List<String> ladder = gbfs.findLadder(beginWord, endWord, dictList);
                        System.out.println("Path: " + String.join(" -> ", ladder));
                    }
                    else{
                        System.out.println("There's no choice with that number.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    algoScanner.next();
                }
            }

            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.println("Execution time: " + executionTime + " ms");

            beginScanner.close();
            endScanner.close();
            algoScanner.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
