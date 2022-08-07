package com.uniquex.studentsorting.Mapper;

import com.uniquex.studentsorting.Model.UserData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDataMapper {

    public static UserData mapToUser(String data) {
        UserData userData = new UserData();
        userData.setName(data.split(",", 2)[0]);
        userData.setData(Double.parseDouble(data.split(",", 2)[1]));
        return userData;
    }

    public static String mapToString(UserData data) {
        return data.toString();
    }

    public static Object[] mapToArray(UserData data) {
        List<String> convertedData = new ArrayList<>();
        convertedData.add(data.getName());
        convertedData.add(String.valueOf(data.getData()));
        return convertedData.toArray();
    }
}
