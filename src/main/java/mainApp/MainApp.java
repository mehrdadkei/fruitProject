package mainApp;

import utilities.SecurityUtil;
import utilities.Utils;
import models.Invoice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.time.LocalDate;
import java.time.LocalTime;


public class MainApp {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        while (true) {
            showMenu();
        }

    }

    private static void showMenu() throws IOException, NoSuchAlgorithmException {
        print("please select from menu");
        print("1- Add an invoice");
        print("2- Report");
        print("3-Exit");
        Integer mainMenu = Integer.valueOf(input());
        switch (mainMenu) {
            case 1:
                addInvoice();
                break;
            case 2://check validity to get report
                checkValidate();
                break;
            case 3:
                System.out.println("goodbye");
                return;
        }

    }

    private static void checkValidate() throws IOException, NoSuchAlgorithmException {
        print("please enter the user name");
        String username = input();
        print("please enter the password");
        String password = input();
        checkValidity(username, password);
    }


    private static void addInvoice() {
        Invoice invoice = new Invoice();
        print("please enter the title");
        invoice.setTitle(input());
        print("please enter the name");
        invoice.setName(input());
        print("please enter the pelak");
        invoice.setPelak(Integer.valueOf(input()));
        print("please enter the weight");
        invoice.setWeight(Integer.valueOf(input()));
        print("please enter per kilo price");
        invoice.setPrice(Long.valueOf(input()));
        invoice.setTotalPrice(invoice.getWeight() * invoice.getPrice());
        LocalDate date = LocalDate.now();
        invoice.setDate(String.valueOf(date));
        LocalTime time = LocalTime.now();
        invoice.setTime(String.valueOf(time));
        System.out.println("total price:" + invoice.getTotalPrice());
        String serialize = invoice.serialize() + "\n" + "//";
        String fileName = invoice.getDate() + ".txt";
        Utils utils = new Utils();
        utils.appendToFile(fileName, serialize);


    }

    private static void checkValidity(String userName, String password) throws IOException, NoSuchAlgorithmException {
        String fileName = "filename.txt";
        Utils utils = new Utils();
        String file = String.valueOf(utils.readFromFile(fileName));
        String[] split = file.split(":");
        String user = split[0];
        String pass = split[1];
        SecurityUtil securityUtils = new SecurityUtil();
        userName = securityUtils.hashMd5(userName);
        password = securityUtils.hashMd5(password);
        if (user.equals(userName) && pass.equals(password)) {
            getReport();
        } else print("access denied");



    }

    private static void getReport() throws IOException {
        print("1-today");
        print("2-by date");
        print("3-back");
        int getInput = Integer.parseInt(input());
        switch (getInput) {
            case 1:
                LocalDate now = LocalDate.now();
                showInvoiceByDate(String.valueOf(now));
                break;
            case 2:
                print("please enter the date (yyyy-mm-dd)");
                String customDate = input();
                showInvoiceByDate(customDate);
                break;
            case 3:
                return;

        }
    }

    private static void showInvoiceByDate(String date) throws IOException {
        Utils utils = new Utils();
        String path = date + ".txt";
        String fileName = String.valueOf(utils.readFromFile(path));
        String[] split = fileName.split("//");
        for (String str : split) {
            print(str);
        }


    }

    private static void print(String m) {
        System.out.println(m);
    }

    private static String input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
