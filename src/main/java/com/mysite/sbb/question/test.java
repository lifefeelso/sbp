package com.mysite.sbb.question;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class test {
    @Id
    private Integer id;
    private String Name;
    private LocalDateTime createDate;
    private LocalDateTime updateData;

}
