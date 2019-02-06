package com.delly.DellyApp.dto;

import com.delly.DellyApp.enums.Role;
import lombok.Data;

/**
 * Represents user request dto.
 *
 * @author spralas
 */
@Data
public class UserRequestDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String userName;

    private String password;

    private Role role;

    private String stripeToken;

    private String vehicleName;

    private String licensePlate;
}
