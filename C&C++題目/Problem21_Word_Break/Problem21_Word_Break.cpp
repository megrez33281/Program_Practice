class Solution {
    //利用遞迴的方式從s的左側開始逐漸切除有匹配到wordDict中字串的部分（匹配的s的子字串必須從s的左側開始）
    //**為了避免重複計算，需要想辦法紀錄遞迴過的s的子字串的長度（由於是依序切除，遞迴中相同長度的s代表相同的子字串）**
public:
    int max_len = 0;    //紀錄wordDict中最長的長度，當從s中切出的字串長於max_len，代表wordDict中沒有匹配的字串
    bool wordBreak(string s, vector<string>& wordDict) {
        for(int i=0; i<wordDict.size(); i++){
            if(max_len < wordDict[i].length()){
                max_len = wordDict[i].length();
            }
        }
        int length = s.length();    //用來記錄個長度的s是否符合wordBreak（由於從s的左側開始依序切除在dict中出現的字串，因此利用一大小等於s長度的陣列紀錄嘗試匹配過的s片段的長度，避免重複計算）
        int* wordBreakList = new int[length];
        for(int i=0; i<length; i++){
            wordBreakList[i] = 0;
        }
        bool wordBreak = wordBreak_from_dict(s, wordDict, wordBreakList);
        delete [] wordBreakList;
        return wordBreak;
    }

    bool wordBreak_from_dict(string s, vector<string>& wordDict, int* wordBreakList) {
        if(wordBreakList[s.length() -1] == 1){
            return false;
        }
        bool TheWordBreak = false;
        for(int i=1; i<=max_len; i++){
            if(i > s.length()){
                break;
            }
            string sub_s = s.substr(0, i);
            for(int j=0; j<wordDict.size(); j++){
                if(wordDict[j] == sub_s){
                    if(i == s.length()){
                        //i等於sub_s的長度
                        return true;
                    }
                    TheWordBreak = TheWordBreak | wordBreak_from_dict(s.substr(i, s.length()-i), wordDict, wordBreakList);
                }
                if(TheWordBreak){
                    //已發現匹配的配置
                    break;
                }
            }
            if(TheWordBreak){
                //已發現匹配的配置
                break;
            }

        }
        //表示該長度的s被處理過
        wordBreakList[s.length() -1] = 1;
        return TheWordBreak;
    }
};