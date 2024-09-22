#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int minDistance(string word1, string word2) {
        int len1 = word1.length() + 1;
        int len2 = word2.length() + 1;
        int operators[len1][len2];
        //初始化
        for(int row = 0; row < len1; row++){
            operators[row][0] = row;
        }
        for(int col = 0; col < len2; col++){
            operators[0][col] = col;
        }
        //DP開始
        for(int row = 1; row < len1; row++){
            for(int col = 1; col < len2; col++){
                if(word1[row-1] == word2[col-1]){
                    operators[row][col] = operators[row-1][col-1];
                }
                else{
                    operators[row][col] = min(operators[row-1][col-1], min(operators[row-1][col], operators[row][col-1])) + 1;
                }
            }
        }

        return operators[len1-1][len2-1];

        
    }
};

int main()
{
    cout << "example 1:\n";
    string word1 = "horse";
    string word2 = "ros";
    Solution solution;
    int operators = solution.minDistance(word1, word2);
    cout << "str1 = " << word1 << ", str2 = " << word2 << endl;
    cout << "operators: " << operators << endl << endl; 

    cout << "example 2: \n";
    word1 = "intention";
    word2 = "execution";
    operators = solution.minDistance(word1, word2);
    cout << "str1 = " << word1 << ", str2 = " << word2 << endl;
    cout << "operators: " << operators << endl << endl; 

    cout << "example 3: \n";
    word1 = "";
    word2 = "a";
    operators = solution.minDistance(word1, word2);
    cout << "str1 = " << word1 << ", str2 = " << word2 << endl;
    cout << "operators: " << operators << endl << endl; 

    cout << "example 4: \n";
    word1 = "sea";
    word2 = "eat";
    operators = solution.minDistance(word1, word2);
    cout << "str1 = " << word1 << ", str2 = " << word2 << endl;
    cout << "operators: " << operators << endl << endl; 

   
    return 0;
}