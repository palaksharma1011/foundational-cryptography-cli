package ciphers;

import java.util.*;

public class hill{
    public static int[][] genKey(int n){
        int[][] key=new int[n][n];
        Random ran=new Random();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int num=ran.nextInt(26);
                key[i][j]=num;
            }
        }
        int det=det(key);

        if(gcd(det,26)==1) return key;
        else return (genKey(n));
    }
    static int[][] key=genKey(2);
    public static int det(int[][] mat){
        int det=((mat[0][0]*mat[1][1])-(mat[0][1]*mat[1][0]));
        det = ((det % 26) + 26) % 26;
        return det;
    }
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public static String encrypt(String plainText){
        // step 1: make matrix of plaintext
        plainText=plainText.replace(" ","");
        plainText=plainText.toUpperCase();
        
        if(plainText.length()%2!=0){
            plainText+='X';
        }
        int n=plainText.length();

        //step 2: key matrix 

        // int[][] key=genKey(2);
        System.out.println("KEY IS : ");
        printMatrix(key);
        // step 3: multiply plaintext mat and key mat
        
        StringBuilder cipherText=new StringBuilder();
        cipherText=mat_multiply(key, plainText, n);
        return cipherText.toString();
    }
    public static StringBuilder mat_multiply(int[][] key,String text,int n){
        StringBuilder converted_text=new StringBuilder();

        for(int i=0;i<n;i=i+2){
            int a=text.charAt(i)-'A';
            int b=text.charAt(i+1)-'A';

            int c1=((key[0][0]*a)+(key[0][1]*b));
            c1=((c1%26)+26)%26;
            int c2=((key[1][0]*a)+(key[1][1]*b));
            c2=((c2%26)+26)%26;

            converted_text.append((char)(c1+'A'));
            converted_text.append((char)(c2+'A'));

        }
        return converted_text;

    }
    public static String decrypt(String cipherText){
        int n=cipherText.length();
        // int[][] key={{1,2},{1,2}};
        int[][] invKey=inverse(key);
        System.out.println("Inversed KEY IS : ");
        printMatrix(invKey);
        // step 3: multiply plaintext mat and key mat
        StringBuilder plainText=new StringBuilder();
        plainText=mat_multiply(invKey, cipherText,n );
        
        return plainText.toString();
    }
     public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {        // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // move to next line
        }
    }
    public static int[][] inverse(int[][] key){
        int [][] newkey=new int[key.length][key[0].length];
        int det=det(key);
        int invdet=modInverse(det,26);
        int n=key.length;

        newkey[1][1]=key[0][0];
        newkey[0][0]=key[1][1];

        newkey[0][1]=-key[0][1];
        newkey[1][0]=-key[1][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                newkey[i][j] = newkey[i][j] * invdet;

                newkey[i][j] = ((newkey[i][j] % 26) + 26) % 26;
            }
        }
        return newkey;
    }
    public static int modInverse(int a,int m){

    a = ((a % m) + m) % m;

    for(int x=1;x<m;x++){
        if((a*x)%m==1){
            return x;
        }
    }

    return -1;
}
        
}