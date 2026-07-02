package Views.Panels;

import SecondaryClasses.ObjectPlus;

import javax.swing.*;
import java.awt.*;

public class ExtentsPanel extends JPanel {

    private JList<Class<?>> classesList;

    private DefaultListModel<Class<?>> classModel;

    private JTextArea objectsArea;

    private JButton refreshButton;

    public ExtentsPanel() {

        initializeComponents();

        initializeLayout();

        initializeListeners();

        refreshClasses();

    }

    private void initializeComponents() {

        classModel = new DefaultListModel<>();

        classesList = new JList<>(classModel);

        objectsArea = new JTextArea();

        objectsArea.setEditable(false);

        refreshButton = new JButton("Refresh");

    }

    private void initializeLayout() {

        setLayout(new BorderLayout());

        JSplitPane split =

                new JSplitPane(

                        JSplitPane.HORIZONTAL_SPLIT,

                        new JScrollPane(classesList),

                        new JScrollPane(objectsArea)

                );

        split.setDividerLocation(200);

        add(split, BorderLayout.CENTER);

        add(refreshButton, BorderLayout.SOUTH);

    }

    private void initializeListeners() {

        refreshButton.addActionListener(e -> refreshClasses());

        classesList.addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {

                showObjects();

            }

        });

    }

    private void refreshClasses() {

        classModel.clear();

        for (Class<?> cls : ObjectPlus.getRegisteredClasses()) {

            classModel.addElement(cls);

        }

    }

    private void showObjects() {

        objectsArea.setText("");

        Class<?> selected = classesList.getSelectedValue();

        if (selected == null)
            return;

        for (Object object : ObjectPlus.getExtent(selected)) {

            objectsArea.append(object.toString());

            objectsArea.append("\n");

        }

    }

}