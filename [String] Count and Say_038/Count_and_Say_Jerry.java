package com.example.starlitya.onlineassement.practice;


import java.util.LinkedList;
import java.util.Queue;

/*

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 */
public class Count_and_Say_Jerry {

    public String countAndSay(int n) {
        if ( n <=0) {
            throw new IllegalArgumentException("invalid input");
        }

        //TODO could be changed to StringBuilder
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> temp;
        queue.offer(1);

        for(int target=2; target <= n; target++) {
            temp = new LinkedList<>();
            int sayCount = 1;
            int say = queue.poll();

            while(!queue.isEmpty()) {
                int current = queue.poll();
                if (current == say) {
                    sayCount++;
                } else {
                    temp.offer(sayCount);
                    temp.offer(say);

                    sayCount = 1;
                    say = current;
                }
            }

            // last one
            temp.offer(sayCount);
            temp.offer(say);

            queue = temp;
        }

        // convert string
        StringBuilder result = new StringBuilder();
        for (Integer i : queue) {
            result.append(i);
        }

        return result.toString();
    }

}