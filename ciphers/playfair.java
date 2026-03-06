package ciphers;

import java.util.*;

import javax.crypto.Cipher;

public class playfair{
    public static char[][] createKeyMat(String key){
    char[][] mat = new char[5][5];
    boolean[] used = new boolean[26]; // track A-Z letters
    key = key.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');

    int i = 0, j = 0;

    // 1️⃣ Fill letters from key
    for (char ch : key.toCharArray()) {
        if (ch == 'J') ch = 'I';       // treat J as I
        int idx = ch - 'A';
        if (!used[idx]) {
            mat[i][j] = ch;
            used[idx] = true;
            j++;
            if (j == 5) { j = 0; i++; } // move to next row
        }
        // else: letter already used → just skip and move to next char in key
    }

    // 2️⃣ Fill remaining letters A-Z
    for (char ch = 'A'; ch <= 'Z'; ch++) {
        if (ch == 'J') continue;       // skip J
        int idx = ch - 'A';
        if (!used[idx]) {
            mat[i][j] = ch;
            used[idx] = true;
            j++;
            if (j == 5) { j = 0; i++; } // move to next row
        }
    }

    System.out.println("Key Matrix:");
    printMatrix(mat);
    return mat;
}
    static char [][] keyMat=new char[5][5];
    

    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {        // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // move to next line
        }
    }


    public static String encryptPair(String txt){
        StringBuilder str=new StringBuilder();
        int[] ch1=getIdx(keyMat,txt.charAt(0));
        int[] ch2=getIdx(keyMat,txt.charAt(1));
        // row same , 0 same 
        if(ch1[0]==ch2[0]) {
            str.append(keyMat[(ch1[0]+1)%5][ch1[1]]);
            str.append(keyMat[(ch2[0]+1)%5][ch2[1]]);
        }else if(ch1[1]==ch2[1]){
            // col same , 1 same 
            str.append(keyMat[ch1[0]][(ch1[1]+1)%5]);
            str.append(keyMat[ch2[0]][(ch2[1]+1)%5]);

        }else{
        // rect
            str.append(keyMat[ch1[0]][ch2[1]]);
            str.append(keyMat[ch2[0]][ch1[1]]);
        } 
        return str.toString();

    }
    public static String decryptPair(String txt){
        StringBuilder str=new StringBuilder();
        int[] ch1=getIdx(keyMat,txt.charAt(0));
        int[] ch2=getIdx(keyMat,txt.charAt(1));
        // row same , 0 same 
        if(ch1[0]==ch2[0]) {
            str.append(keyMat[(ch1[0]+4)%5][ch1[1]]);
            str.append(keyMat[(ch2[0]+4)%5][ch2[1]]);
        }else if(ch1[1]==ch2[1]){
            // col same , 1 same 
            str.append(keyMat[ch1[0]][(ch1[1]+4)%5]);
            str.append(keyMat[ch2[0]][(ch2[1]+4)%5]);

        }else{
        // rect
            str.append(keyMat[ch1[0]][ch2[1]]);
            str.append(keyMat[ch2[0]][ch1[1]]);
        } 
        return str.toString();

    }
    public static int[] getIdx(char[][] arr,char k){
        
        int xy[]=new int[2];
        for (int i = 0; i < arr.length; i++) {        // rows
            for (int j = 0; j < arr[i].length; j++) { // columns
                if(arr[i][j]==k){
                    xy[0]=i;
                    xy[1]=j;
                }
            }
        }
        return xy;

    }

    public static String encrypt(String plainText,String key){
        keyMat=createKeyMat(key);

        plainText = plainText.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        StringBuilder cipherText=new StringBuilder();

        for(int i=0;i<plainText.length();i=i+2){
            char ch1=plainText.charAt(i);
            char ch2 = (i+1 < plainText.length()) ? plainText.charAt(i+1) : 'X';
            if(ch1=='J') ch1='I';
            if(ch2=='J') ch2='I';

            String pair="";
            pair+=ch1;

            if((ch1==ch2)) {
                pair+='X';
                i--;
            }
            else pair+=ch2;

            String cipherPair=encryptPair(pair);
            cipherText.append(cipherPair);

        }
        return cipherText.toString();    
    }
    public static String  decrypt(String cipherText,String key){
        StringBuilder plainText=new StringBuilder();

        for(int i=0;i<cipherText.length();i=i+2){
            char ch1=cipherText.charAt(i);
            char ch2=cipherText.charAt(i+1);

            String pair="";
            pair+=ch1;

            pair+=ch2;

            String plainPair=decryptPair(pair);
            plainText.append(plainPair);

        }
        String plain =plainText.toString(); 
        plain=plain.replaceAll("X", "");
        return plain;

    }
}