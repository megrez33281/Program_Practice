
function solve(board: string[][]): void {
    //用遞迴的方式進行DFS更快
    function DFS(row:number, col:number): void{
        if(row < 0 || row == height || col < 0 || col == width){
            return;
        }
        if(board[row][col] == "O"){
            board[row][col] = "N";
            DFS(row+1,col);
            DFS(row-1,col);
            DFS(row,col+1);
            DFS(row,col-1);
          
        }
    };
    //先遍歷外圍，出現"O"時利用DFS將其與其相連的"O"都改成"N"表示不會被翻轉
    var height = board.length;
    var width = board[0].length;
    //上圍&下圍
    for(let col=0; col<width; col++){
        if(board[0][col] == "O"){
            DFS(0, col);
        }
        if(board[height-1][col] == "O"){
            DFS(height-1, col);
        }
    }
    //左圍&右圍
    for(let row=0; row<height; row++){
        if(board[row][0] == "O"){
            DFS(row, 0);
        }
        if(board[row][width-1] == "O"){
            DFS(row, width-1);
        }
    }
    
    //遍歷borad，將"O"翻轉成"X"並將"N"轉回"O"
    for(let row=0; row<height; row++){
        for(let col=0; col<width; col++){
            if(board[row][col] == "O"){
                board[row][col] = "X";
            }
            else if(board[row][col] == "N"){
                board[row][col] = "O";
            }
        }
    }
    
};


var board: string[][] = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]];
solve(board);
console.log(board)

