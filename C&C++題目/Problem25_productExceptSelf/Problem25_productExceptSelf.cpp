class Solution {
public:
	/*
		解題思路：
			題目要求要用O(n)的時間完成，因此最多只能使用一層Loop迴圈
			此處採用先計算出所有元素相乘的值，再計算出除去對應index元素值的結果
			考慮到會出現除0的情形，會出現以下情形：
				1. 除0，且陣列中除去當前元素外有其他元素為0
				2. 除0, 且陣列中除去當前元素外沒有其他元素為0
				3. 除非0, 陣列中除去當前元素外有其他元素為0
				4. 除非0, 陣列中除去當前元素外沒有其他元素為0
			依據不同的情形進行處理即可
	*/
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> answer;
        int total_product = 1;
        int total_product_with_zero = 1;
        int twozeros = -1;
        for(int i=0; i<nums.size(); i++){
            if(nums[i] != 0){
                total_product *= nums[i];
            }
            else{
                total_product_with_zero = 0;
                twozeros++;
            }
        }
        if(total_product_with_zero == 1){
            total_product_with_zero = total_product;
        }
        for(int i=0; i<nums.size(); i++){
            if(nums[i] == 0){
                if(twozeros < 1){
                    answer.push_back(total_product);
                }
                else{
                    answer.push_back(total_product_with_zero);
                }
            }
            else{
                answer.push_back(total_product_with_zero/nums[i]);
            }
            
        }
        return answer;
    }
};