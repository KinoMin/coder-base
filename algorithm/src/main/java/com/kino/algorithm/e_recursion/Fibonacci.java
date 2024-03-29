/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kino.algorithm.e_recursion;

import java.util.Arrays;

/**
 * 斐波那契是一个数列，这个数列的前两个数是0和1，从第三项开始，每一项都等于前两项之和。
 * 因此，这个数列的前几项是：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144，依此类推。
 *
 * @author kino
 * @date 2023/4/3 15:57
 */
public class Fibonacci {
    public static long[] fibonacci1(int n) {
        long[] arr = new long[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * 递归求第n项的值
     *
     * @param n
     * @return
     */
    public static long fibonacci2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        long x = fibonacci2(n - 1);
        long y = fibonacci2(n - 2);
        return x + y;
    }

    /**
     * 记忆法
     * 使用记忆法（Memoization）的优点在于可以缓存已经计算过的结果，避免重复计算，从而提高程序的性能。
     * 使用记忆法的斐波那契数列实现的时间复杂度为O(n)，而不使用记忆法的递归实现的时间复杂度为O(2^n)，
     * 因此在n较大的情况下，使用记忆法可以大大缩短程序的运行时间。
     * <p>
     * 另一方面，使用记忆法需要占用额外的存储空间来存储已经计算过的结果，
     * 因此在空间有限的情况下，使用记忆法可能会导致内存占用过高。
     * 而不使用记忆法的递归实现则不需要额外的存储空间，但是由于存在重复计算，时间复杂度较高，
     * 可能导致程序运行速度缓慢。
     * <p>
     * 在测试用例上, 取第排在第40位的结果, 未使用记忆法耗时: 261ms, 使用记忆法耗时: 1ms
     *
     * @param n
     * @return
     */
    public static long fibonacci3(int n) {
        long[] arr = new long[n + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        return fibonacciMemory(n, arr);
    }

    private static long fibonacciMemory(int n, long[] arr) {
        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = fibonacciMemory(n - 1, arr) + fibonacciMemory(n - 2, arr);
        return arr[n];
    }

    /**
     * 兔子问题:
     * 一对兔子在一年内繁殖出的兔子数量。假设一开始有一对年龄为1个月的兔子，
     * 它们在出生后第二个月变成了成年兔子，然后每个月可以繁殖一对新的兔子，
     * 新生的兔子从第二个月起也可以开始繁殖。
     * 问题是：在n个月后，有多少对兔子？
     *
     * @return
     */
    public static long fibonacciRabbit(int n) {
        long[] arr = new long[n + 1];
        Arrays.fill(arr, -1);
        arr[1] = 1;
        arr[2] = 1;

        return fibonacciRabbit(n, arr);
    }

    private static long fibonacciRabbit(int n, long[] arr) {
        if (arr[n] != -1) {
            return arr[n];
        }
        arr[n] = fibonacciRabbit(n - 1, arr) + fibonacciRabbit(n - 2, arr);
        return arr[n];
    }

    /**
     * 青蛙跳台阶问题:
     * 假设一个青蛙要跳上n个台阶，它可以跳1个台阶，也可以跳2个台阶。问青蛙跳上这n个台阶有多少种不同的跳法。
     * <p>
     * 台阶 方法(种)  跳法
     * 1    1       (1)
     * 2    2       (1,1)、(2)
     * 3    3       (1,1,1)、(1,2)、(2,1)
     * 4    5       (1,1,1,1)、(1,1,2)、(1,2,1)、(2,1,1)、(2,2)
     * 5    8       (1,1,1,1,1)、(1,1,1,2)、(1,1,2,1)、(1,2,1,1)、(2,1,1,1)、(2,1,2)、(2,2,1)、(1,2,2)
     * 6    13      ....
     * n    jump = (n -1) + (n - 2)
     *
     * @param n
     * @return
     */
    public static long fibonacciFrog(int n) {
        long[] arr = new long[n+1];
        Arrays.fill(arr, -1);
        arr[1] = 1;
        arr[2] = 2;
        return jump(n, arr);
    }

    private static long jump(int n, long[] arr) {
        if(arr[n] != -1){
            return arr[n];
        }
        arr[n] = jump(n - 1, arr) + jump(n - 2, arr);
        return arr[n];
    }

}
