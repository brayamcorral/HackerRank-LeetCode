import java.util.*;

public class Graphs {

    public static void main(String[] args) {
        int[][] arr = new int[][] { {}, { 2, 3 }, { 1, 4, 5 }, { 1, 5 }, { 2, 5, 6 }, { 2, 3, 4, 5 }, { 4, 5 },
                { 3, 1 } };

        // print2d(arr);
        printDFS(arr, 1);
        printBFS(arr, 1);

    }

    public static void printBFS(int[][] arr, int head) {
        System.out.print("BFS: ");
        Queue<Integer> queue = new LinkedList<>();
        Boolean[] visited = new Boolean[arr.length];
        Arrays.fill(visited, false);
        queue.add(head);
        visited[head] = true;

        while (queue.size() > 0) {
            int curr = queue.remove();
            for (int i = 0; i < arr[curr].length; i++) {
                if (!visited[arr[curr][i]]) {
                    queue.add(arr[curr][i]);
                    visited[arr[curr][i]] = true;
                }
            }
            System.out.print(curr + " ");
        }
        System.out.print("\n");

    }

    public static void printDFS(int[][] arr, int head) {
        System.out.print("DFS: ");
        Stack<Integer> stack = new Stack<>();
        Boolean[] visited = new Boolean[arr.length];
        Arrays.fill(visited, false);
        visited[head] = true;

        stack.push(head);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int i = 0; i < arr[curr].length; i++) {
                if (!visited[arr[curr][i]]) {
                    stack.push(arr[curr][i]);
                    visited[arr[curr][i]] = true;
                }
            }
            System.out.print(curr + " ");
        }
        System.out.println();
    }

    public static void print2d(int[][] arr) {
        for (int[] subArr : arr) {
            for (int num : subArr) {
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}
