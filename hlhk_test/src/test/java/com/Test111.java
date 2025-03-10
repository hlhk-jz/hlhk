package com;

public class Test111 {
    public static void main(String[] args){
        byte b = -1;
        String binaryString = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
        System.out.println(binaryString);
    }
}
