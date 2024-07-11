function partition(s: string): string[][] {
    function isPalindrome(str: string): number{
        let left = 0;
        let right = str.length-1;
        while(left <= right){
            if(str[left] != str[right]){
                return 0;
            }
            left++;
            right--;

        }

        return 1;
    }

    //利用"蠶食鯨吞法"從左到右從s切割出為Palindrome的子字串，並利用遞迴的方式找到後面所有可能的切割方式
    function slicing(index: number, sets:string[]): void{
        if(index >= s_length){
            palindrome_list.push(sets);
            return;
        }
        for(let i=index; i<s_length; i++){
            let sub:string = s.substring(index, i+1);
            if(isPalindrome(sub) == 1){
                let new_sets:string[] = [];
                sets.forEach((value)=>{
                    new_sets.push(value);
                })
                new_sets.push(sub);
                slicing(i+1, new_sets);
            }
        }

    }
    
    var s_length = s.length;
    var palindrome_list: string[][] = [];
    slicing(0, []);

    return palindrome_list;
};


var s: string = "aab";
var palindrome  = partition(s);
console.log(palindrome);

