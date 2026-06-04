class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char>mp;
        int maxLong=0;
        int start=0;

        for(int i=0;i<s.length();i++){

            while(mp.find(s[i])!=mp.end()){
                mp.erase(s[start]);
                start++;
            }

            mp.insert(s[i]);        

            maxLong=max(maxLong,i-start+1);
        }
        return maxLong;
    }
};
