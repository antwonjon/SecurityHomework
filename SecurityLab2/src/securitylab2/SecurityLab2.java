/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package securitylab2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author Anthony Skinner
 * 2/8/16
 */
public class SecurityLab2 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.security.NoSuchAlgorithmException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
        BufferedReader passwordFile1 = new BufferedReader(new FileReader("passwords.txt"));
        BufferedReader passwordFile2 = new BufferedReader(new FileReader("passwords.txt"));
        BufferedReader needToCrack = new BufferedReader(new FileReader("needToCrack.txt"));
        //Scanner passwordFile = new Scanner(new File("passwords.txt"));
        //Scanner needToCrack = new Scanner(new File("needToCrack.txt"));
        ArrayList<String> regularFile = regularFile(passwordFile1);
        ArrayList<String> encryptedFile = encryptFile(passwordFile2);
        ArrayList<String> needsCracking = regularFile(needToCrack);
        ArrayList<Password> crackedList = findPassword(encryptedFile, regularFile, needsCracking);
        printPasswords(crackedList);
    }

    public static void printPasswords(ArrayList<Password> c) {
       
        for (int i = 0; i < c.size(); i++) {
            System.out.println("The password for hash value " + c.get(i).getValue() + " is " + c.get(i).getActual() + ", it takes the program " + (c.get(i).getTime()/1000000000.0) + " sec to recover this password");
        }
    }

    public static ArrayList<Password> findPassword(ArrayList<String> encryptedFile, ArrayList<String> regularFile, ArrayList<String> needsCracking) {
        
        ArrayList<Password> finalList = new ArrayList<>();
        for (int i = 0; i < needsCracking.size(); i++) {
            long startTime = System.nanoTime();

            for (int j = 0; j < encryptedFile.size(); j++) {

                if (needsCracking.get(i).compareTo(encryptedFile.get(j)) == 0) {
                    long endTime = System.nanoTime();
                    long elapsedTime = endTime - startTime;
                    Password newPassword = new Password(needsCracking.get(i), regularFile.get(j), elapsedTime);
                    finalList.add(newPassword);
                    j = encryptedFile.size();
                }
            }
        }
       
        return finalList;
    }

    public static ArrayList<String> encryptFile(BufferedReader passwordFile) throws IOException, NoSuchAlgorithmException {
        ArrayList<String> encryptedFile = new ArrayList<>();
        String line = "";
        
        while ((line = passwordFile.readLine()) != null) {
            
            StringBuilder s = new StringBuilder();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(line.getBytes());
            
            byte[] temp = md5.digest();
            for (int i = 0; i < temp.length; i++) {
                s.append(Integer.toString((temp[i] & 0xff)+ 0x100, 16).substring(1));
            }
            
            encryptedFile.add(s.toString());
        }
        
        return encryptedFile;
    }

    public static ArrayList<String> regularFile(BufferedReader sc) throws IOException {
        ArrayList<String> regularFile = new ArrayList<>();
        String part = "";
        while ((part = sc.readLine())!= null) {
            regularFile.add(part);
        }

        return regularFile;
    }
}
