package com.milu.work;

import com.milu.work.小米._2_;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static ReentrantLock lock = new ReentrantLock(false);
    private static int xiang = 100;

    public static void main(String[] args) {
        //三只小狗抢100根小肠，一次抢一根，直到抢完为止，抢完统计每只小狗分别抢到几根
        for(int i = 0; i <3; i++) {
            new Thread(new Runnable() {
                int have;

                @Override
                public void run() {
                    while(xiang != 0) {
                        lock.lock();
                        if(xiang != 0) {
                            have++;
                            xiang--;
                        }
                        lock.unlock();
                    }
                    System.out.println("当前线程"+ have);
                }
            }).run();
        }
    }
}
