class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s,result, path);
        return result;

    }
    private void dfs(String s, List<List<String>> result, List<String> path) {
    //Base case
    int size = s.length();
    if(size==0 || s == null){
        result.add(new ArrayList<>(path));
        return;
    }
    
    //Recursive case
    for(int i = 1; i <= size; i++){
        String subStr = s.substring(0,i);
        //action
        if(!isPalindrome(subStr)) continue;
  
        path.add(subStr);
        //Recursive call
        dfs(s.substring(i, s.length()), result, path);
         //backtrack  
        path.remove(path.size()-1);  
    }
    }

    private boolean isPalindrome(String s){
        int left =0; int right = s.length()-1;
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
