import ciphers.*;
import java.util.*;

public class main{
    static Scanner sc=new Scanner(System.in);
    // static HashMap<Integer,String> menu=new HashMap<>();
    // while(true){
    //     menu.put(1,"Caesar Cipher");
    //     menu.put(2,"Hill Cipher");
    //     menu.put(3,"Playfair Cipher");
    //     menu.put(4,"Vernam Cipher");
    //     menu.put(5,"Monoalphabetic Cipher");
    //     menu.put(6,"Columnar Cipher");
    // }
    // public static void execute(int k){
    //     System.out.println("Enter the plain text");
    //     String plainText=sc.nextLine();

    //     System.out.println("Enter the key");
    //     int key=sc.nextInt();

    //     String converted_cipherText=cipher.encrypt()
    // }
    public static void menu(){

        while(true){
            System.out.println("\n===== Cipher Menu =====");
            System.out.println("1. Caesar Cipher");
            System.out.println("2. Hill Cipher");
            System.out.println("3. Playfair Cipher");
            System.out.println("4. Vernam Cipher");
            System.out.println("5. Monoalphabetic Substitution");
            System.out.println("6. Columnar Cipher");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {

                case 1:
                    System.out.print("Enter plaintext: ");
                    String p1 = sc.nextLine();
                    System.out.print("Enter shift key: ");
                    int key = sc.nextInt();

                    String c1 = caesar.encrypt(p1, key);
                    System.out.println("Encrypted Ciphertext: " + c1);

                    String converted_p1 = caesar.decrypt(c1, key);
                    System.out.println("Decrypted Plaintext: " + converted_p1);
                    break;

                case 2:
                    System.out.print("Enter the plaintext: ");
                    String p2 = sc.nextLine();
                    String c2 = hill.encrypt(p2);
                    System.out.println("Encrypted Ciphertext: " + c2);
                    String converted_p2 = hill.decrypt(c2);
                    System.out.println("Decrypted Plaintext: " + converted_p2);
                    break;

                case 3:
                    System.out.print("Enter the plaintext: ");
                    String p3 = sc.nextLine();
                    System.out.print("Enter key: ");
                    String key3 = sc.nextLine();

                    String c3 = playfair.encrypt(p3, key3);
                    System.out.println("Encrypted Ciphertext: " + c3);

                    String converted_p3 = playfair.decrypt(c3, key3);
                    System.out.println("Decrypted Plaintext: " + converted_p3);
                    break;

                case 4:
                    System.out.print("Enter the plaintext: ");
                    String p4 = sc.nextLine();
                    System.out.print("Enter key: ");
                    String key4 = sc.nextLine();

                    String c4 = vernam.encrypt(p4, key4);
                    System.out.println("Encrypted Ciphertext: " + c4);
                    String converted_p4 = vernam.decrypt(c4, key4);
                    System.out.println("Decrypted Plaintext: " + converted_p4);
                    break;

                case 5:
                    System.out.print("Enter the plaintext: ");
                    String p5 = sc.nextLine();
                    System.out.print("Enter key mapping: ");
                    String key5 = sc.nextLine();

                    String c5 = monoalphabeticSubs.encrypt(p5, key5);
                    System.out.println("Encrypted Ciphertext: " + c5);
                    String converted_p5 = monoalphabeticSubs.decrypt(c5, key5);
                    System.out.println("Decrypted Plaintext: " + converted_p5);
                    break;

                case 6:
                    System.out.print("Enter the plaintext: ");
                    String p6 = sc.nextLine();
                    System.out.print("Enter key: ");
                    String key6 = sc.nextLine();

                    String c6 = columnar.encrypt(p6, key6);
                    System.out.println("Encrypted Ciphertext: " + c6);

                    String converted_p6 = columnar.decrypt(c6, key6);
                    System.out.println("Decrypted Plaintext: " + converted_p6);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    public static void main(String[] args) {
        menu();
    }
}