package com.uniquex.studentsorting.Mapper;

import com.uniquex.studentsorting.Model.UserData;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {

    public static UserData mapToUser(String data) {
        UserData userData = new UserData();
        userData.setName(data.split(",", 2)[0]);
        userData.setData(Double.parseDouble(data.split(",", 2)[1]));
        return userData;
    }
    public static String mapToString(UserData data)
    {
        return data.toString();
    }
}
