function singleNumber(nums: number[]): number {

    var num_stack = new Array();
    var once = 0;
    for(let i=0; i<nums.length; i++){
        let index = nums[i];
        if(num_stack[index] == undefined){
            //第一次出現
            num_stack[index] = 1;
            once += nums[i];
        }
        else{
            //出現次數 > 1
            num_stack[index]++;
            if(num_stack[index] == 2){
                //出現第2次時減回去，此後不再管它
                once -= nums[i];
            }
        }
    }

    return once;
    
};


var nums = [0,1,0,1,0,1,98];
var once = singleNumber(nums);
console.log(once);


