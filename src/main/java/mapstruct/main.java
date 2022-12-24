package mapstruct;

import mapstruct.beans.User;
import mapstruct.beans.UserDto;
import mapstruct.mapper.UserMapper;
import org.mapstruct.factory.Mappers;

public class main {


    public static void main(String[] args) {

        User user = new User("arvind","8238443");
        UserMapper userMapper = Mappers.getMapper(UserMapper.class);
        UserDto userDto = userMapper.getUserDto(user);
        System.out.println(userDto);
    }
}
