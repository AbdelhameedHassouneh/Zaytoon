package com.avo.zaytoon.utils.models;

import com.avo.zaytoon.utils.enums.Gender;
import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,name = "first_name")
    private String firstName;

    @Column(nullable = false,name = "last_name")
    private String lastName;

    @Column(nullable = true,length = 10,name = "phone")
    private String phone;

    @Column(nullable = false,name = "email")
    private String email;

    @Column(nullable = true,name = "age")
    private Integer age;

    @Column(nullable = false,name = "height")
    private Double height;

    @Column(nullable = false,name = "weight")
    private Double weight;

    @Column(nullable = false,name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    public Integer getAge() {
        if (this.age == null){
            this.age=0;
        }
        return this.age;
    }

    public String getPhone() {
        if (this.phone == null){
            this.phone="-";
        }
        return this.phone;
    }
}
