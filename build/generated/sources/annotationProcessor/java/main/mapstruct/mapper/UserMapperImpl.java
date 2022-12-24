package mapstruct.mapper;

import javax.annotation.Generated;
import mapstruct.beans.User;
import mapstruct.beans.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-24T12:39:20+0530",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 1.8.0_311 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto getUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( user.getName() );
        userDto.setPhoneNumber( user.getPhoneNumber() );

        return userDto;
    }
}
