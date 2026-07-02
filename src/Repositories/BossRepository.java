package Repositories;


import Models.Boss;

import java.io.*;

public class BossRepository {

    private static final String FILE_NAME = "boss.dat";

    public static void save(Boss boss) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(boss);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boss load() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (Boss) in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean exists() {
        return new File(FILE_NAME).exists();
    }
}