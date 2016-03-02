/*
 * Anthony Skinner
 * 2/2/2016 Lab 1
 */
package securitylab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.LinkedList;
import java.util.Scanner;

public class SecurityLab1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input file path to decode");
        System.out.println("Example: 'C:\\Users\\AJ\\Documents\\NetBeansProjects\\SecurityLab1\\memorydump.dmp'");
        String filePath =  sc.nextLine();
        System.out.println("");
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder builder = new StringBuilder();
        String dumpFile;
        //read file in
        while ((dumpFile = reader.readLine()) != null) {
            builder.append(dumpFile);
        }
        //this captures the large regex
        String regex = ("[%][B]\\d{16}\\^\\w+[/]\\w+\\^\\d{7}");
        checkerMain(regex, builder);

    }

    public static void checkerMain(String theRegex, StringBuilder data) {
        Pattern pattern = Pattern.compile(theRegex);
        Matcher matcher = pattern.matcher(data);
        LinkedList<CreditCardInfo> list = new LinkedList();
        while (matcher.find()) {
           
            checkerDetails("B|\\^|/", matcher, list);
        }
        //print it!
        System.out.println("There is "+list.size()+" credit card record in memory data");
        printCard(list);
       
    }

    public static void checkerDetails(String regex, Matcher matcher, LinkedList<CreditCardInfo> list){
        String[] str = matcher.group().split(regex);
        CreditCardInfo creditCard = new CreditCardInfo();
        creditCard.setcNum(str[1]);
        creditCard.setLname(str[3]);
        creditCard.setFname(str[2]);
        //had to break up the last string in order to get the Expiration date and CVC
        creditCard.setExpYear(str[4].substring(0,2));
        creditCard.setExpMon(str[4].substring(2,4));
        creditCard.setCVC(str[4].substring(4,7));
        list.add(creditCard);
        
    }
    
    public static void printCard(LinkedList<CreditCardInfo> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("<Information for Record " + (i+1) + " >");
            System.out.println("Cardholder's Name: "+ list.get(i).getFname() + " "+ list.get(i).getLname() );
            System.out.println("Card Number: " + list.get(i).getcNum());
            System.out.println("Expiration Date: "+ list.get(i).getExpMon() + "/20" + list.get(i).getExpYear());
            System.out.println("CVC Number: " + list.get(i).getCVC());
            System.out.println("");
        }
    }
}
