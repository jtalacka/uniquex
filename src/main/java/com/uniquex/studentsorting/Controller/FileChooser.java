package com.uniquex.studentsorting.Controller;

import com.uniquex.studentsorting.Mapper.UserDataMapper;
import com.uniquex.studentsorting.Model.UserData;
import com.uniquex.studentsorting.Service.DataHandlerService;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.util.List;

@Service
public class FileChooser implements ActionListener {
    private DataHandlerService dataHandlerService;

    private List<UserData> userData;

    public FileChooser(DataHandlerService dataHandlerService) {
        this.dataHandlerService = dataHandlerService;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String com = e.getActionCommand();
        if (com.equals("open")) {
            openOperation();
        } else if (com.equals("save")) {
            saveOperation();
        }


    }

    private void openOperation() {
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "TXT files", "txt");
        fileChooser.setFileFilter(filter);
        int option = fileChooser.showOpenDialog(null);

        if (option == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            String sortingAlgorithm = MainController.selectBox.getSelectedItem().toString();

            userData = dataHandlerService.processData(filePath);
            String duration = new String();
            userData = dataHandlerService.sortData(userData, sortingAlgorithm,duration);
            MainController.dtm.setRowCount(0);
            userData.forEach(item ->
            {
                MainController.dtm.addRow(UserDataMapper.mapToArray(item));
            });
        } else
            MainController.label.setText("the user cancelled the operation");
    }

    private void saveOperation() {
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int r = j.showSaveDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            String filePath = j.getSelectedFile().getAbsolutePath();
            dataHandlerService.saveData(userData, filePath);
        } else
            MainController.label.setText("the user cancelled the operation");
    }
}

