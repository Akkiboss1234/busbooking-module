package com.busbookingreservation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegistration {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
@Lob
@Column(name = "profile_picture", length = 16777215) // Adjust length as needed

    private byte[] profilepicture;
}
