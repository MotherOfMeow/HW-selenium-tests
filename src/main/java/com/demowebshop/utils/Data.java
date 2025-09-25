package com.demowebshop.utils;

import com.demowebshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Data {

    @DataProvider
    public Iterator<Object[]> addNewUser() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Alice", "Smith", "alice.smith1@gmail.com", "pass12345"});
        list.add(new Object[]{"Bob", "Johnson", "bob.johnson2@gmail.com", "secure987"});
        list.add(new Object[]{"Charlie", "Brown", "charlie.brown3@gmail.com", "qwerty456"});
        list.add(new Object[]{"Diana", "Miller", "diana.miller4@gmail.com", "hello2025"});
        list.add(new Object[]{"Ethan", "Wilson", "ethan.wilson5@gmail.com", "pwd78910"});
        list.add(new Object[]{"Fiona", "Taylor", "fiona.taylor6@gmail.com", "login1122"});
        list.add(new Object[]{"George", "Anderson", "george.anderson7@gmail.com", "alpha3344"});
        list.add(new Object[]{"Hannah", "Thomas", "hannah.thomas8@gmail.com", "beta5566"});
        list.add(new Object[]{"Ian", "Moore", "ian.moore9@gmail.com", "gamma7788"});
        list.add(new Object[]{"Julia", "Clark", "julia.clark10@gmail.com", "delta9900"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addNewUserWithCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Users.csv")));
        String line = reader.readLine();

        while (line != null) {

            String[] split = line.split(",");

            list.add(new Object[]{new User()
                    .setFirstName(split[0])
                    .setLastName(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])});

            line = reader.readLine();
        }
        return list.iterator();
    }
}
