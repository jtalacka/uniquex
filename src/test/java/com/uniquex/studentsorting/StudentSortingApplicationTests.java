package com.uniquex.studentsorting;

import com.uniquex.studentsorting.Model.UserData;
import com.uniquex.studentsorting.Service.DataHandlerService;
import com.uniquex.studentsorting.Service.IOFileService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class StudentSortingApplicationTests {

    @Autowired
    IOFileService fileReaderService;
    @Autowired
    DataHandlerService dataHandlerService;

    private String fileName = "testData.txt";

    @Test
    void checkloadedFile() throws IOException, URISyntaxException {
        List<UserData> user = dataHandlerService.processData(getAbsolutePath());
        assertFalse(user.isEmpty());

    }

    @Test
    void checkFileRead() throws IOException, URISyntaxException {
        List<String> user = fileReaderService.readFromFile(getAbsolutePath());
        assertFalse(user.isEmpty());

    }
    @Test
    void checkSort() throws URISyntaxException, IOException {
        List<UserData> user = dataHandlerService.processData(getAbsolutePath());
        List<UserData>  sortedUser = dataHandlerService.sortData(user,"BubbleSort");

        assertFalse(sortedUser.isEmpty());
    }


    private String getAbsolutePath() throws URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        return String.valueOf(Paths.get(resource.toURI()).toFile());
    }

}
