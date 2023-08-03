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
package com.kino.algorithm.g_stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author kino
 * @date 2023/8/3 11:55 PM
 */
public class TestLinkedStack {
    @Test
    public void test(){
        LinkedStack<Integer> stack = new LinkedStack<>(5);
        Assertions.assertTrue(stack.push(1));
        Assertions.assertTrue(stack.push(2));
        Assertions.assertTrue(stack.push(3));
        Assertions.assertTrue(stack.push(4));
        Assertions.assertTrue(stack.push(5));
        Assertions.assertFalse(stack.push(6));
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
