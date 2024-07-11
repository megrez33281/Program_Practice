function canCompleteCircuit(gas: number[], cost: number[]): number {
    let stations = gas.length;
    let total_cost = 0;
    let total_gas = 0;
    let current_gas = 0;
    let start_station = 0;
    for(let station = 0; station<stations; station++){
        total_cost += cost[station];
        total_gas += gas[station];
        
        //current_gas代表從start_station到目前的station的消耗和收入的gas總和
        current_gas += gas[station] - cost[station];
        if(current_gas < 0){
            //當出現current_gas < 0的情形表示從start_station可以順暢地到達目前的station，並且會在目前的station卡住出不去
            //故當出現current_gas < 0時可以判斷從start_station到當前station皆不能作為起點(會在當前station卡住)
            //註：由於有此判斷機制，可以推得從start_station到station處的gas的收入都是大於消耗的(只是無法離開)，可以理解為若以start_station到station處的任一站點
            //做為起點(當在某站點current_gas>0時可以理解為以該站為起點時即使附帶初始gas還是會在station處卡住)，皆會在station處卡住，因此從start_station到station皆無法作為起點
            //起點站可能在station+1以及之後的站點
            //註：由於題目說明只可能有一個站點能作為起始站，或者無法完成Travel，故當所有站點的gas和-cost和 >= 0，代表必有一個站點可作為初始站
            //重點：當current_gas < 0 發生，代表從start_station到當前station都不能作為起始點(會在當前station卡住)
            start_station = station+1;
            current_gas = 0;
        }
    }

    //因果關係為：
    //已知total_gas >= total_cost時必有一站點能作為初始站
    //當淘汰掉所有不適合的站點時剩餘的站點即是答案
    return (total_gas >= total_cost)?start_station:-1;
};

var gas:number[] =  [5,8,2,8];
var cost:number[] = [6,5,6,6];
console.log(canCompleteCircuit(gas, cost));