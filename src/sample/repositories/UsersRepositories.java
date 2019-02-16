package sample.repositories;

import sample.models.User;

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
            String[] info = line.split(" ", 12);
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
        return users;
    }

    public static User getUserByLogin(String login) throws IOException{
        ArrayList<User> allUsers = getAllUsers();
        User returnedUser = null;
        for (int i=0; i< allUsers.size();i++){
            if(allUsers.get(i).getLogin().equals(login)) {
                returnedUser = allUsers.get(i);
                break;
            }
        }
        return returnedUser;
    }

    public static void update(User model) throws IOException {
        Path path = Paths.get("allUsers.txt");
        List<String> fileContent = new ArrayList<>(Files.readAllLines(path));
        String userToString = model.toString();
        for (int i = 0; i < fileContent.size(); i++) {
            String[] info = fileContent.get(i).split(" ", 12);
            if (info[0].equals(model.getHashCode())) {
                fileContent.set(i, userToString);
                break;
            }
        }

        Files.write(path, fileContent);
    }

    public static void write(User model) throws IOException {
        FileWriter writer = new FileWriter("src/sample/repositories/allUsers.txt", true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write("\n" + model.toString());
        bufferWriter.close();
    }

    public static void writeCreditHistory(User model) throws IOException{
        FileWriter writer = new FileWriter("src/sample/repositories/creditsFiles.txt", true);
        BufferedWriter bufferWriter = new BufferedWriter(writer);
        bufferWriter.write("\n" + model.getHashCode());
        bufferWriter.close();
    }
}
