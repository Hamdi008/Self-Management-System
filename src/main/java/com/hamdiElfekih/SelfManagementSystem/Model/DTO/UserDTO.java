package com.hamdiElfekih.SelfManagementSystem.Model.DTO;

import com.hamdiElfekih.SelfManagementSystem.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    // @Autowired
    // private ModelMapper modelMapper;

    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String jobTitle;

    // convert User to UserDTO using ModelMapper dependency
    /*
     * public UserDTO convertUserToDTO(User user) {
     * return modelMapper.map(user, UserDTO.class);
     * }
     */

    // convert UserDTO to User using ModelMapper dependency
    /*
     * public User convertDTOToUser(UserDTO dto) {
     * return modelMapper.map(dto, User.class);
     * }
     */

    // convert User to UserDTO manually

    public static UserDTO convertUserToDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setJobTitle(user.getJobTitle());
        return dto;
    }

    // convert UserDTO to User manually

    public static User convertDTOToUser(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setJobTitle(dto.getJobTitle());
        return user;
    }

}
