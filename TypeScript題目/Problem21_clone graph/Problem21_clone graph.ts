
function cloneGraph(node: Node | null): Node | null {
    //為了避免建立出相同的Node(val相同)導致無限遞迴，以BFS或DFS的方式遍歷Graph
    var indexs : Node[] = [];
    function DFS(node: Node| null): Node | null{
        if(node == null ){
            return null;
        }
        let new_node = new Node(node.val);
        indexs[new_node.val-1] = new_node;
        let neighbor_length = node.neighbors.length;
        for(let i=0; i<neighbor_length; i++){
            let index = node.neighbors[i].val;
            if(indexs[index-1] == null){
                let temp_node = DFS(node.neighbors[i]);
                if(temp_node != null){
                    new_node.neighbors.push(temp_node);
                }
            }
            else{
                new_node.neighbors.push(indexs[index-1]);
            }           
        }

        return new_node;
    }

    return DFS(node);
	
};