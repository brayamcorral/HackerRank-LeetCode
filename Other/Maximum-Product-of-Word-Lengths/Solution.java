// https://leetcode.com/problems/maximum-product-of-word-lengths/

class Solution {

    public boolean charShared(String s1, String s2){

        HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();

        for(Character c : s1.toCharArray()){
            map.put(c, true);
        }

        for(Character c : s2.toCharArray()){
            if(map.getOrDefault(c, false))
                return true;
        }

        return false;
    
    }
    public int maxProduct(String[] words) {
        
        // sort words: biggest to small length
        Arrays.sort(words, (a,b)-> b.length() - a.length());
         
        int maxProduct = Integer.MIN_VALUE;
        int product;

        for(int i = 0; i < words.length-1; ++i){
            for(int j = i+1; j < words.length; ++j){
                product = words[i].length() * words[j].length();
                if(charShared(words[i], words[j]))
                    continue;
                else if(product > maxProduct)
                    maxProduct = product;
                else if(product <= maxProduct)
                    break;
            }
        }
        return (maxProduct == Integer.MIN_VALUE) ? 0 : maxProduct;
    }
}
