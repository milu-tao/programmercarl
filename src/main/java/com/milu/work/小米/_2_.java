package com.milu.work.小米;
import java.util.*;
public class _2_ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String[] split = input.split(",");
        List<Task> list = new ArrayList<>();

        for(String s : split) {
            String[] split1 = s.split(":");
            list.add(new Task(Integer.parseInt(split1[0]),Integer.parseInt(split1[1])));
        }

        //排序还得
        list.sort((a,b) -> {
            if(a.minBattery != b.minBattery){
                return Integer.compare(a.minBattery,b.minBattery);
            }else{
                return Integer.compare(b.need, a.need);
            }
        });
        int minBattery = 0;
        for(Task t : list){
            if(minBattery <= t.minBattery){
                minBattery = t.minBattery;
            }else{
                minBattery += t.need;
            }
        }
        System.out.println(minBattery);

    }
    public static class Task{
        public int need;
        public int minBattery;
        public Task(int a,int b){
            need = a;
            minBattery = b;
        }
    }
}
