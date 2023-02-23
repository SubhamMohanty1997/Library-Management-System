package com.jdbl44.library.management.system.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
@Data

@Getter
@Setter
@Builder

public class Librarian {
    @NotNull
    private int librarianId;
    @NotNull
    private String name;
    private String contact;
    private String password;
}
