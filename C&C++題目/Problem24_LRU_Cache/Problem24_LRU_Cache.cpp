

class LRUCache {
    struct ListNode{
        int value;
        int key;
        ListNode* next;
        ListNode* prev;
    };
public:

    LRUCache(int capacity) {
        int least_index = 0;
        total_capacity = capacity;
    }
    
    int get(int key) {
        if(Cache[key]){
            //將該pair設為最近使用過
            KeyUsed(key);
            return Cache[key]->value;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(!Cache[key]){
            //增加新的內容
            if(used_capacity == total_capacity){
                //當前容量已滿，需替代Least Used的pair
                int LeastUsedKey = head->key;
                head = head->next;
                if(head){
                    head->prev = NULL;
                }
                if(Cache[LeastUsedKey] == tail){
                    //當Least Used的Node等於tail代表該Linked List只有一個Node
                    tail = NULL;
                }   
                delete Cache[LeastUsedKey]; //釋放空間
                Cache[LeastUsedKey] = NULL;
                NewPair(key, value);
            }
            else{
                used_capacity += 1;
                NewPair(key, value);

            }
            
        }
        else{
            //更新已有內容
            Cache[key]->value = value;
            
            //將該pair設為最近使用過
            KeyUsed(key);
        }
        
    }

private:
    int used_capacity = 0;
    int total_capacity = 0;
    ListNode* Cache[10001] = {NULL};
    ListNode* tail = NULL;
    ListNode* head = NULL;
    void NewPair(int key, int value){
        //新增Node
        //初始化新的ListNode
        ListNode* new_node = new ListNode;
        new_node->value = value;
        new_node->key = key;
        new_node->next = NULL;
        new_node->prev = NULL;

        if(tail){
            tail->next = new_node;
            new_node->prev = tail;
            tail = tail->next;
            //SeeKeyOrder();  
        }
        else{
            tail = new_node;
            head = tail;
        }
        Cache[key] = new_node;
    }
    void KeyUsed(int key){
        //將最近使用過的pair移動到LinkedList的最尾部
        ListNode* UsedNode = Cache[key];
        ListNode* leftNode = UsedNode->prev;
        ListNode* rightNode = UsedNode->next;
        if(!leftNode && !rightNode){
            //此時只有唯一node
            return;
        }
        else if(!leftNode){
            //沒有前一node
            rightNode->prev = NULL;
            head = rightNode;
        }
        else if(!rightNode){
            //沒有後一node（代表當前key為最新node，不須調整）
            return;
        }
        else{
            leftNode->next = rightNode;
            rightNode->prev = leftNode;
        }
        //將key對應的node放到最尾部  
        tail->next = UsedNode;
        UsedNode->prev = tail;
        UsedNode->next = NULL;
        tail = tail->next;
    }
    void SeeKeyOrder(){
        ListNode* ptr = head;
        while(ptr != tail){
            cout << ptr->value << " ";
            ptr = ptr->next;
        }
        cout << ptr->value << endl;
    }

};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */