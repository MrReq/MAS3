import SecondaryClasses.ObjectPlus;
import Views.Loging.LoginSelectionView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {

            ObjectPlus.loadExtents("data/extents.dat");

        } catch (Exception ignored) {

            System.out.println("First application start.");

        }

        Runtime.getRuntime().addShutdownHook(

                new Thread(() -> {

                    try {

                        ObjectPlus.saveExtents("data/extents.dat");

                        System.out.println("All extents saved.");

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

                })

        );

        SwingUtilities.invokeLater(() ->

                new LoginSelectionView().setVisible(true)

        );

    }

}