package com.milu.work.腾讯音乐;

public class _2_ {
    public static void main(String[] args) {
        _2_ a = new _2_();
        System.out.println(a.kawaiiStrings(4));
    }

    private static StringBuffer path = new StringBuffer();
    private static int result = 0;

    private static final char[] word = new char[]{'r', 'e', 'd'};

    private static char a = 'a';

    public int kawaiiStrings(int n) {
        // write code here
        digui(n);
        return result;
    }

    private void digui(int n) {
        if (path.length() == n) {
            isKe(path.toString());
            return;
        }
        for (char c : word) {
            if(c == a) continue;
            path.append(c);
            a = c;
            digui(n);
            path.deleteCharAt(path.length() - 1);
        }
    }

    private void isKe(String path) {
        //连续子串
        boolean red = path.contains("red");
        //不连续子串
        boolean r = false;
        boolean e = false;
        boolean d = false;
        for (char c : path.toCharArray()) {
            if (r) {

                if (e) {

                    if (d) {

                    } else {
                        if (c == 'd') {
                            d = true;
                        } else {
                            continue;
                        }
                    }

                } else {
                    if (c == 'e') {
                        e = true;
                    } else {
                        continue;
                    }
                }

            } else {
                if (c == 'r') {
                    r = true;
                } else {
                    continue;
                }
            }
        }

        if (r & e & d & !red) {
            System.out.println(path);
            result++;
        }
    }

}
