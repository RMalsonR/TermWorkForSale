package sample.repositories;

import sample.models.User;

import java.beans.IntrospectionException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositories {
    public static ArrayList<User> getAllUsers() throws IOException {
        ArrayList<User> users = new ArrayList<>();
        File file = new File("src/sample/repositories/allUsers.txt");
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");
            int hashCode = Integer.parseInt(info[0]);
            String login = info[1];
            String password = info[2];
            String surName = info[3];
            String name = info[4];
            String lastName = info[5];
            String bDate = info[6];
            String citizen = info[7];
            String city = info[8];
            int salary = Integer.parseInt(info[9]);
            String phoneNumber = info[10];
            String creditTarget = info[11];
            users.add(new User(hashCode, login, password, name, lastName, surName, bDate, citizen, city, salary, phoneNumber, creditTarget));
        }
        reader.close();
        return users;
    }

    public static User getUserByLogin(String login) throws IOException {
        ArrayList<User> allUsers = getAllUsers();
        User returnedUser = null;
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getLogin().equals(login)) {
                returnedUser = allUsers.get(i);
                break;
            }
        }
        return returnedUser;
    }

    public static void update(User model) throws IOException {
        ArrayList<User> users = getAllUsers();
        File file = new File("src/sample/repositories/allUsers.txt");
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        int count = 0;
        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");
            int value = Integer.parseInt(info[0]);
            if (value == model.getHashCode()) {
                users.remove(count);
                users.add(model);
                break;
            }
            count++;
        }
        reader.close();
        FileWriter fileWriter = new FileWriter(file, false);
        for (User writeUsers : users) {
            fileWriter.write(writeUsers.toString() + "\n");
        }
        fileWriter.close();
    }

    public static void write(User model) throws IOException {
        FileWriter writer = new FileWriter("src/sample/repositories/allUsers.txt", true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write("\n" + model.toString());
        bufferWriter.close();
    }

    public static void writeCreditHistory(User model) throws IOException {
        FileWriter writer = new FileWriter("src/sample/repositories/creditsFiles.txt", true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write(model.getHashCode() + " " + model.getCredit().toString() + "\n");
        bufferWriter.flush();
        bufferWriter.close();
    }

    public static String viewCreditHistory(User model) throws IOException{
        File file = new File("src/sample/repositories/creditsFiles.txt");
        String line;
        String result="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");
            if(Integer.parseInt(info[0]) == model.getHashCode()){
                result = "Сумма кредита: " + info[1] + "р. Срок: " + info[2] + " лет. Выплата в месяц: " + info[3] +"р.";
            }
        }
        return result;
    }

    public static boolean checkCreditHistory(User model) throws IOException {
        File file = new File("src/sample/repositories/creditsFiles.txt");
        String line;
        boolean result = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");
            if (line != null) {
                int value = Integer.parseInt(info[0]);
                if (value == model.getHashCode()) result = true;
            }
        }
        return result;
    }
}
