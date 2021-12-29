
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int output[] = new int[numCourses];
        Set<Integer> set = new HashSet<>();

        int current = 0;
        boolean emptyFound = false;

        // move data into a list of lists
        // 0: preReq1, preReq2
        // 1: preReq1, preReq2
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // System.out.println(list);
        // System.out.println(list);
        // System.out.println(list.size());

        // Loop until all classes are in array
        while (current <= numCourses) {

            // loop though lists to find empty lists
            for (int a = 0; a < list.size(); a++) {

                // remove class from graph if it has no prereqs
                if (list.get(a).size() == 0 && !set.contains(a)) {
                    emptyFound = true;
                    // System.out.println(a + " is empty");

                    // remove all connections to node with no prereq
                    for (int i = 0; i < list.size(); i++) {
                        for (int j = 0; j < list.get(i).size(); j++) {
                            if (list.get(i).get(j) == a) {
                                list.get(i).remove(j);
                            }
                        }
                    }

                    // Put class into output
                    output[current] = a;
                    set.add(a);
                    current++;

                    if (current >= numCourses)
                        return output;

                    // list.remove(a);
                    // System.out.println(list);

                }
            }

            if (!emptyFound) {
                // System.out.println("empty");
                return new int[0];
            } else
                emptyFound = false;

        }

        return output;

    }
}