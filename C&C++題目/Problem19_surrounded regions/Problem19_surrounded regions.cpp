#include <iostream>
#include <vector>
#include <string>
#include <set>

using namespace std;


class Solution {
public:
    void solve(vector<vector<char>>& board) {
        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board[i].size(); j++){
                if(board[i][j] == 'O'){
                    vector<vector<int>> loc;
                    set<vector<int>> compare;
                    loc.push_back({i,j});
                    compare.insert({i,j});
                    int ptr = 0;
                    int flip = 1;
                    while(ptr < loc.size()){
                        int r = loc[ptr][0];
                        int c = loc[ptr][1];
                        vector<vector<int>> aside = {{r+1, c}, {r-1,c}, {r, c+1}, {r, c-1}};
                        if(r-1 < 0 || c-1 <0 || r+1 >= board.size() || c+1>=board[i].size()){
                            flip = 0;
                            break;
                        }
                        for(int v=0; v<aside.size(); v++){
                            int row = aside[v][0];
                            int col = aside[v][1];
                            if(board[row][col] == 'O'){
                                int pre = compare.size();
                                compare.insert({row, col});
                                if(pre+1 == compare.size()){
                                    loc.push_back({row, col});
                                }                              
                            }
                        }
                        ptr++;
                    }

                    if(flip){
                        for(int v=0; v<loc.size(); v++){
                            int row = loc[v][0];
                            int col = loc[v][1];
                            board[row][col] = 'X';
                        }
                    }

                    
                }
                       
            }
        }

    }
};

int main()
{

    vector<vector<char>> board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
    Solution solution;
    solution.solve(board);
    return 0;
}