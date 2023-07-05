package mapstruct.mapper;

import mapstruct.beans.User;
import mapstruct.beans.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper()
public interface UserMapper {

    /*@Mapping(target = "name", source = "name")
    public  UserDto getUserDto(User user);*/

}
