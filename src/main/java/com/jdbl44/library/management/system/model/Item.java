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
public class Item {
    @NotNull
    private int itemId;
    @NotNull
    private String name;
    private String author;
    private String publisher;
    @NotNull
    private String catagory;
    private int availableCopies;

}

