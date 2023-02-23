package com.jdbl44.library.management.system.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
@Data
@Getter
@Setter
@Builder
public class Student {
    @NotNull
    private int studentId;
    @NotNull
    private String name;
    private String contact;
    private String branch;
    private String accountStatus;
    private Date registeredOn;
    private String password;
}
