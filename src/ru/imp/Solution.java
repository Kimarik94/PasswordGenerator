package ru.imp;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/*
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        List<Integer> password = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            password.add(null);
        }
        boolean bigCharUsed = false;
        boolean smallCharUsed = false;
        boolean digitUsed = false;
        int randomPos;

        while(password.contains(null)){
            int i = 1;
            randomPos = (int)(Math.random()*((7-0)+1))+0;
            if(password.get(randomPos)==null){
                int temp = (int)(Math.random() * ((3-i)+1))+i;
                if(temp == 1 && !bigCharUsed) {
                    password.set(randomPos, (int) (Math.random() * ((90 - 65) + 1)) + 65);
                    bigCharUsed = true;
                    if(digitUsed || smallCharUsed) i = 2;
                } else if (temp == 2 && !smallCharUsed) {
                    password.set(randomPos, (int) (Math.random() * ((122-97)+1))+97);
                    smallCharUsed = true;
                    if(bigCharUsed || digitUsed) i = 2;
                } else if (temp == 3 && !digitUsed) {
                    password.set(randomPos, (int) (Math.random() * ((57-48)+1))+48);
                    digitUsed = true;
                    if(bigCharUsed || smallCharUsed) i = 2;
                }else{
                    bigCharUsed = false;
                    smallCharUsed = false;
                    digitUsed = false;
                    i=1;
                }
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for(int i=0;i<password.size();i++){
            byteArrayOutputStream.write(password.get(i));
        }

        return byteArrayOutputStream;
    }
}