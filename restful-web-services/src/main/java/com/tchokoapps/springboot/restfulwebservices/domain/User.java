package com.tchokoapps.springboot.restfulwebservices.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description="All details about the user.")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2,message = "Name should have at least 2 characters")
    @ApiModelProperty(notes="Name should have atleast 2 characters")
    private String name;

    @ApiModelProperty(notes="Birth date should be in the past")
    @Past
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
