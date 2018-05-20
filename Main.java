
import com.google.gson.Gson;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    static StringBuilder inputJSONStringBuilder = new StringBuilder();
    String inputJSONString;
    static Account account;
    static float A_sum;
    static float I_sum;
    static float V_sum;
    static float A_dolg = 0;
    static float I_dolg = 0;
    static float V_dolg = 0;
    static float taxi = 0;
    static String input;



    public static void main(String... args) {

        try {
            //Scanner scanner = new Scanner(new FileInputStream("account.json"));
            Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream("D:\\JSon_Check\\account.json"), StandardCharsets.UTF_8));
            while (scanner.hasNext()) {
                inputJSONStringBuilder.append(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
        }

        String jsonString = inputJSONStringBuilder.toString().trim();
        Gson g = new Gson();
        account = g.fromJson(jsonString, Account.class);

        JPanel panel = new JPanel();


        for (Good good : account.items) {
       //     System.out.println(good.toString());
        }


        System.out.print("A_sum : ");
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
        {
            A_sum = Float.parseFloat(bufferedReader.readLine());
            System.out.print("I_sum : ");
            I_sum = Float.parseFloat(bufferedReader.readLine());
            System.out.print("V_sum : ");
            V_sum = Float.parseFloat(bufferedReader.readLine());

            System.out.println(A_sum + " " + I_sum + " " + V_sum);
            System.out.print("Taxi : ");

            taxi = Float.parseFloat(bufferedReader.readLine());

            account.items.add(new Good("Taxi", taxi * 100));
            for (Good good : account.items)
            {
                System.out.println(good.getName() + " Цена: " + good.getSum() / 100 + " Кол-во: " + good.getQuantity());
                input = bufferedReader.readLine();
                if (input.length() == 3)
                {
                    A_dolg = A_dolg + (good.getSum() / 100) / 3;
                    I_dolg = I_dolg + (good.getSum() / 100) / 3;
                    V_dolg = V_dolg + (good.getSum() / 100) / 3;
                }
                else if (input.length() == 2)
                {
                    A_dolg = input.contains("A") ? A_dolg + (good.getSum() / 100) / 2 : A_dolg ;
                    I_dolg = input.contains("I") ? I_dolg + (good.getSum() / 100) / 2 : I_dolg ;
                    V_dolg = input.contains("V") ? V_dolg + (good.getSum() / 100) / 2 : V_dolg ;
                }
                else if (input.length() == 1)
                {
                    A_dolg = input.equals("A") ? A_dolg + (good.getSum() / 100) : A_dolg ;
                    I_dolg = input.equals("I") ? I_dolg + (good.getSum() / 100) : I_dolg ;
                    V_dolg = input.equals("V") ? V_dolg + (good.getSum() / 100) : V_dolg ;
                }
            }

            System.out.println("A dolg: " + A_dolg);
            System.out.println("I dolg: " + I_dolg);
            System.out.println("V dolg: " + V_dolg);

            System.out.println("A dolg - A_sum : " + (A_dolg - A_sum));
            System.out.println("V dolg - V_sum : " + (V_dolg - V_sum));
            System.out.println("I dolg - I_sum : " + (I_dolg - I_sum));




        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}






