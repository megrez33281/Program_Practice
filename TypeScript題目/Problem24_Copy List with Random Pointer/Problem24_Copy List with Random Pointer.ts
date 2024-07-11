function copyRandomList(head: Node | null): Node | null {
    //先記錄下線型的Node串列，再為各Node連接next 與 random
    function getIndex(node: Node| null):number {
        //找到node在該串列的位置(從該node開始後面還有多少個Node)
        let length = 0;
        let ptr = node;
        while(ptr != null){
            length++;
            ptr = ptr.next;
        }
        return length;

    };

    var node_list: Node[] = [];

    let ptr = head;
    while(ptr != null){
        node_list.push(new Node(ptr.val));
        ptr = ptr.next;
    }

    let length = node_list.length;
    ptr = head;
    for(let index=0; index<length; index++){
        if(ptr == null){
            break;
        }

        //連接next
        if(index != length-1){
            node_list[index].next = node_list[index+1];
        }
        else{
            node_list[index].next = null;
        }
        
        //連接random
        if(ptr.random == null){
            node_list[index].random = null;
        }
        else{
            let random_index = length - getIndex(ptr.random);
            node_list[index].random = node_list[random_index];
        }
        ptr = ptr.next;

    }
    return node_list[0];

};

