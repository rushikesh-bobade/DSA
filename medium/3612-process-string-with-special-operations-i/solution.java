class Solution {
    public String processStr(String s) {
        StringBuilder result=new StringBuilder();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);
 
            if(ch=='#'){
                result.append(result);
            }else if(ch=='%'){
                result.reverse();
            }else if(ch=='*'){
                if(result.length()>0){
                    result.deleteCharAt(result.length()-1);
                }
            }else{
                result.append(ch);
            }
        }

        String ans=result.toString();
        return ans;
    }
}