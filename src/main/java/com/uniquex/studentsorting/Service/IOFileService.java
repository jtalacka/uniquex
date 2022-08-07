package com.uniquex.studentsorting.Service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class IOFileService {

    public IOFileService() {
    }

    public List<String> readFromFile(String url) {

        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(url))) {
            result = lines.collect(Collectors.toList());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void writeToFile(String url, List<String> data) {
        Path output = Paths.get(url);
        try {
            Files.write(output, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
