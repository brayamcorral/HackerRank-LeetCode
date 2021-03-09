// https://leetcode.com/problems/simplify-path/
class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> stack = new Stack<String>();
        Set<String> set = new HashSet<>(Arrays.asList("", ".", ".."));
        String canonicalPath = "";
        
        for(String s : path.split("/")){
            if(s.equals("..") && !stack.empty()) stack.pop();
            else if(!set.contains(s)) stack.push(s);
        }
        
        while(!stack.empty()){
            canonicalPath = "/" + stack.pop() + canonicalPath;
        }
        
        return canonicalPath.isEmpty() ? "/" : canonicalPath;
    }
}
