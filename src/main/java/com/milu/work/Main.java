package com.milu.work;

import com.milu.work.小米._2_;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        System.out.println(list.get(0));

    }
}
