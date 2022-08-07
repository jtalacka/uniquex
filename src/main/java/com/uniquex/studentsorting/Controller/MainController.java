package com.uniquex.studentsorting.Controller;

import com.uniquex.studentsorting.Sorting.SortingSelection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Stream;

public class MainController extends JFrame {
    private String[] args;
    @Autowired
    private FileChooser fileChooser;
    static JComboBox selectBox;
    static JLabel label;

    static JTable table;
    static DefaultTableModel dtm;

    public MainController(String title) {
        super();
        setTitle(title);
        setSize(740, 480);
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JButton openButton = new JButton("open");
        JButton saveButton = new JButton("save");

        openButton.addActionListener(fileChooser);
        saveButton.addActionListener(fileChooser);

        List<String> enumNames = Stream.of(SortingSelection.values())
                .map(SortingSelection::name).toList();

        selectBox = new JComboBox(enumNames.toArray());

        dtm = new DefaultTableModel(0, 2);
        table = new JTable(dtm);
        table.setBounds(30, 40, 200, 300);
        label = new JLabel();
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel p = new JPanel();
        p.add(scrollPane);
        p.add(selectBox);
        p.add(openButton);
        p.add(saveButton);
        p.add(label);
        this.add(p);
        show();


    }
}
