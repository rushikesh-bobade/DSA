class Solution {
    public int strStr(String haystack, String needle) {
        
        String s=haystack;
        String s1=needle;

        int l=s.length();
        int l1=s1.length();

        if(l1>l)return -1;
        
        int ans=s.indexOf(s1);
       return ans;

    }
}