package mapstruct.mapper;

import javax.annotation.Generated;
import mapstruct.beans.User;
import mapstruct.beans.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-07T23:33:19+0530",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.9.jar, environment: Java 11.0.15 (JetBrains s.r.o.)"
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
