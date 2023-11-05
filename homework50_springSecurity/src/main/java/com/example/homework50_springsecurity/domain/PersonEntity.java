package com.example.homework50_springsecurity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    private String password;

    private Boolean isEnabled = true;

    @OneToMany(mappedBy = "person" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PermissionEntity> permissionEntityList;
}
