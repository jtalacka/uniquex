package com.uniquex.studentsorting;

import com.uniquex.studentsorting.Model.UserData;
import com.uniquex.studentsorting.Service.DataHandlerService;
import com.uniquex.studentsorting.Service.IOFileService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
class StudentSortingApplicationTests {

    @Autowired
    IOFileService fileService;
    @Autowired
    DataHandlerService dataHandlerService;

    private String fileName = "testData.txt";
    private String saveFileName = "saveData.txt";

    @Test
    void checkloadedFile() throws IOException, URISyntaxException {
        List<UserData> user = dataHandlerService.processData(getAbsolutePath(fileName));
        assertFalse(user.isEmpty());

    }

    @Test
    void checkFileRead() throws IOException, URISyntaxException {
        List<String> user = fileService.readFromFile(getAbsolutePath(fileName));
        assertFalse(user.isEmpty());

    }

    @Test
    void checkSort() throws URISyntaxException, IOException {
        List<UserData> user = dataHandlerService.processData(getAbsolutePath(fileName));
        List<UserData> sortedUser = dataHandlerService.sortData(user, "BubbleSort",null);

        assertFalse(sortedUser.isEmpty());
    }

    @Test
    void writeToFile() throws URISyntaxException, IOException {
        List<UserData> user = dataHandlerService.processData(getAbsolutePath(fileName));
        dataHandlerService.saveData(user, getAbsolutePath(saveFileName));

    }


    private String getAbsolutePath(String name) throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(name);
        return String.valueOf(Paths.get(resource.toURI()).toFile());
    }


}
