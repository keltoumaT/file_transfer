package com.training.filetransfer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String password;
}
