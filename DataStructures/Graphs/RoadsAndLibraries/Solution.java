// https://www.hackerrank.com/challenges/torque-and-development/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static int DFS(boolean[] visited, int source,  List<List<Integer>> adjacencyList){
        
        visited[source] = true;
        int answer = 1;
        
        for(int i = 0; i < adjacencyList.get(source).size(); ++i){
            
            if(!visited[adjacencyList.get(source).get(i)]){
                answer += DFS(visited, adjacencyList.get(source).get(i), adjacencyList);
            }
        }
                
        return answer;
    }
    
    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        
        List<List<Integer>> adjacencyList;
        adjacencyList = new ArrayList<>();
        for(int i = 0; i < n+1; ++i){
            adjacencyList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < cities.length; i++){
            adjacencyList.get(cities[i][0]).add(cities[i][1]);
            adjacencyList.get(cities[i][1]).add(cities[i][0]);
        }
        
        boolean[] visited = new boolean[n+1];
        List<Integer> componentSizes = new ArrayList<>();;
        for(int i = 1; i <= n; ++i){
            
            if(!visited[i] && adjacencyList.get(i).size() > 0)
                componentSizes.add(DFS(visited, i, adjacencyList));
                
            else if(adjacencyList.get(i).size() == 0)
                componentSizes.add(1);  
        }
        
        long answer = 0;
        for(int i = 0; i < componentSizes.size(); ++i){
            
            answer += Math.min((c_lib * componentSizes.get(i)), 
                        ((c_road*(componentSizes.get(i) - 1)) + c_lib));
        }
        
        return answer;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
