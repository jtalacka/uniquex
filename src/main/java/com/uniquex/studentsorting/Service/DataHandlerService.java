package com.uniquex.studentsorting.Service;

import com.uniquex.studentsorting.Mapper.UserDataMapper;
import com.uniquex.studentsorting.Model.UserData;
import com.uniquex.studentsorting.Sorting.ISort;
import com.uniquex.studentsorting.Sorting.SortingSelection;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataHandlerService {
    private IOFileService fileService;

    public DataHandlerService(IOFileService fileReaderService) {
        this.fileService = fileReaderService;
    }

    public List<UserData> processData(String url) {
        List<String> dataLines = fileService.readFromFile(url);
        List<UserData> usersData = dataLines.stream().map(UserDataMapper::mapToUser).collect(Collectors.toList());
        return usersData;
    }

    public List<UserData> sortData(List<UserData> userData, String sorter, String duration) {
        ISort sort = SortingSelection.valueOf(sorter).selectSort();
        Instant start = Instant.now();
        List<UserData> data = sort.sort(userData);
        Instant end = Instant.now();
        duration += Duration.between(start, end).toString();
        System.out.println(duration);
        return data;
    }

    public void saveData(List<UserData> userData, String url) {
        List<String> convertedData = userData.stream().map(UserDataMapper::mapToString).toList();
        ;
        fileService.writeToFile(convertedData, url);
    }

}
