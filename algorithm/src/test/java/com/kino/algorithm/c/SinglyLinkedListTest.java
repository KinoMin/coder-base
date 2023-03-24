package com.kino.algorithm.c;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author kino
 * @date 2023/3/21 00:49
 */
public class SinglyLinkedListTest {

    @Test
    @DisplayName("测试 get 方法")
    public void testGet() throws IllegalAccessException {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");

        Assertions.assertThrows(IllegalAccessException.class,() -> list.get(-1));
        Assertions.assertEquals("1", list.get(0));
        Assertions.assertEquals("2", list.get(1));
        Assertions.assertEquals("3", list.get(2));
        Assertions.assertThrows(IllegalAccessException.class,() -> list.get(3));
    }

    @Test
    @DisplayName("测试 add 方法")
    public void testAdd() throws IllegalAccessException {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");

        Assertions.assertThrows(IllegalAccessException.class, () -> list.add(-1, "100"));

        list.add(0, "10");
        Assertions.assertIterableEquals(Arrays.asList("10", "1", "2", "3"), list);

        list.add(2, "20");
        Assertions.assertIterableEquals(Arrays.asList("10", "1", "20", "2", "3"), list);

        list.add(4, "30");
        Assertions.assertIterableEquals(Arrays.asList("10", "1", "20", "2", "30", "3"), list);

        list.add(6, "40");
        Assertions.assertIterableEquals(Arrays.asList("10", "1", "20", "2", "30", "3", "40"), list);

        Assertions.assertThrows(IllegalAccessException.class, () -> list.add(8, "100"));
    }

    @Test
    @DisplayName("测试 addFirst 方法")
    public void testAddFirst(){
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("3");
        list.addFirst("2");
        list.addFirst("1");
        for (String value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试 addLast 方法")
    public void testAddLast() throws IllegalAccessException {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addLast("4");
        list.addLast("5");
        list.addLast("6");
        for (String value : list) {
            System.out.println(value);
        }
    }

    @Test
    @DisplayName("测试 removeFirst 方法")
    public void testRemoveFirst() throws IllegalAccessException {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        Assertions.assertThrows(IllegalAccessException.class , list::removeFirst);
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");
        list.removeFirst();
        Assertions.assertIterableEquals(Arrays.asList("5","6"), list);
        list.removeFirst();
        Assertions.assertIterableEquals(Arrays.asList("6"), list);
        list.removeFirst();
        Assertions.assertIterableEquals(Arrays.asList(), list);
        Assertions.assertThrows(IllegalAccessException.class , list::removeFirst);
    }

    @Test
    @DisplayName("测试 removeLast 方法")
    public void testRemoveLast() throws IllegalAccessException {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        Assertions.assertThrows(IllegalAccessException.class , list::removeFirst);
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");
        list.removeLast();
        Assertions.assertIterableEquals(Arrays.asList("4","5"), list);
        list.removeLast();
        Assertions.assertIterableEquals(Collections.singletonList("4"), list);
        list.removeLast();
        Assertions.assertIterableEquals(Collections.emptyList(), list);
        Assertions.assertThrows(IllegalAccessException.class , list::removeLast);
    }

    @Test
    @DisplayName("测试 remove 方法")
    public void testRemove() throws IllegalAccessException {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addLast("4");
        list.addLast("5");
        list.addLast("6");

        Assertions.assertThrows(IllegalAccessException.class , () -> list.remove(-1));
        list.remove(2);
        Assertions.assertIterableEquals(Arrays.asList("4","5"), list);
        list.remove(1);
        Assertions.assertIterableEquals(Collections.singletonList("4"), list);
        list.remove(0);
        Assertions.assertIterableEquals(Collections.emptyList(), list);
        Assertions.assertThrows(IllegalAccessException.class , () -> list.remove(100));
    }
}

