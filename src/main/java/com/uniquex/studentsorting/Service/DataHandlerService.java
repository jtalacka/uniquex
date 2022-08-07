package com.uniquex.studentsorting.Service;

import com.uniquex.studentsorting.Mapper.UserDataMapper;
import com.uniquex.studentsorting.Model.UserData;
import com.uniquex.studentsorting.Sorting.ISort;
import com.uniquex.studentsorting.Sorting.SortingSelection;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataHandlerService {
    private IOFileService fileReaderService;

    public DataHandlerService(IOFileService fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public List<UserData> processData(String url) throws IOException {
        List<String> dataLines = fileReaderService.readFromFile(url);
        List<UserData> usersData = dataLines.stream().map(UserDataMapper::mapToUser).collect(Collectors.toList());
        return usersData;
    }

    public List<UserData> sortData(List<UserData> userData, String sorter)
    {
        ISort sort = SortingSelection.valueOf(sorter).selectSort();
        List<UserData> data = sort.sort(userData);
        return data;
    }

}
