package ciphers;
import java.util.*;

public class columnar{
    static class KeyPair{
        char ch;
        int index;
        KeyPair(char ch,int idx){
            this.ch=ch;
            this.index=idx;
        }
    }
    public static String encrypt(String plainText,String key){ 
        
        int col=key.length();
        int row=(int)Math.ceil((double)plainText.length() / col);
        StringBuilder cipherText=new StringBuilder();

        char[][] mat=new char[row][col];

        int k=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(k<plainText.length()) mat[i][j]=plainText.charAt(k);
                else mat[i][j]='X';
                k++;
            }
        }

        KeyPair[] arr=new KeyPair[col];
        for(int i=0;i<col;i++){
            arr[i]=new KeyPair(key.charAt(i),i);
        }
        Arrays.sort(arr,(a,b)->Character.compare(a.ch,b.ch));

        for(int p=0;p<col;p++){
            int colIdx=arr[p].index;
            for(int i=0;i<row;i++){
                cipherText.append(mat[i][colIdx]);
            }
        }
        return cipherText.toString();

    }
    
    public static String decrypt(String cipherText,String key){
        int col=key.length();
        int row=(int)Math.ceil((double)cipherText.length() / col);
        StringBuilder plainText=new StringBuilder();

        char[][] mat=new char[row][col];

        KeyPair[] arr=new KeyPair[col];
        for(int i=0;i<col;i++){
            arr[i]=new KeyPair(key.charAt(i),i);
        }
        Arrays.sort(arr,(a,b)->Character.compare(a.ch,b.ch));

        int k=0;
        for(int i=0;i<col;i++){
        int colIdx=arr[i].index;
            for(int j=0;j<row;j++){
                if(k<cipherText.length()){
                    mat[j][colIdx]=cipherText.charAt(k);
                    k++;
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]!='X') plainText.append(mat[i][j]);
            }
        }
        return plainText.toString();
    }
}