package com.vmc.interview.netcracker;

import java.util.Arrays;

public class SortArrayWithOptimized {
    public static void main(String[] args) {
        int[] array={1,0,0,1,0,1};
        //print zeros first and ones last using single for loop and same array.
        int zeroPos=0;
        for (int i=0;i<array.length;i++){
            if(array[i]==0){
                int temp=array[i]; //i=1,2,4
                array[i]=array[zeroPos]; //value 1 assigned to 1 index ,2 index ,4 index
                array[zeroPos]=temp; // value 0 assigned to 0 index , 1 index 2 index
                zeroPos++;
            }
           //{0,1,0,1,0,1};{0,0,1,1,0,1};{0,0,0,1,1,1}
        }
        Arrays.stream(array).forEach(ele->System.out.print(ele+","));
    }
}
