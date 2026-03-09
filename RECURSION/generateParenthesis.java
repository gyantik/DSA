// LeetCode: generateParenthesis 
// Date: 09-03-2026 
 //approach 1
class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        solve("",n);
        return result;
    }
    public void solve(String curr, int n){
        if(curr.length()==2*n){
         if(isValid(curr)){
                result.add(curr);
            }
            return;
        }
         solve(curr + "(", n);
        solve(curr + ")", n);
    }
    public boolean isValid(String str){
     int count =0;
     for (char ch : str.toCharArray()){
        if(ch=='('){
            count++;
        }else{
            count--;
        }
        if(count<0) return false;
     }
         return count==0;
     }
}

//approach 2
class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        int open=0;
        int close=0;
        solve("",n,open ,close);
        return result;
    }
    public void solve(String curr, int n,int open,int close){
        if(curr.length()==2*n){
                result.add(curr);
                  return;
            }
        if(open<n){
         solve(curr + "(", n,open+1,close);
        }
        if(close<open){
        solve(curr + ")", n,open ,close + 1);
        }
    }
}