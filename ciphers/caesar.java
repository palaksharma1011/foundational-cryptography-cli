package ciphers;
import java.util.*;

public class caesar{
    public static String encrypt(String plainText,int key){
        StringBuilder cipherText=new StringBuilder();
        key=((key%26)+26)%26;
        // System.out.println("key after % is " + key);

        for(int i=0;i<plainText.length();i++){
            char ch=plainText.charAt(i);

            if(Character.isUpperCase(ch)){
                char shifted=(char)((ch-'A'+key)%26 +'A');
                cipherText.append(shifted);
            }
            else if(Character.isLowerCase(ch)){
                char shifted=(char)((ch-'a'+key)%26 +'a');
                cipherText.append(shifted);
            }
            else{
                cipherText.append(ch);
            }

        }
        return cipherText.toString();
    }

    public static String decrypt(String cipherText,int key){
        return encrypt(cipherText,-key);
    }
}