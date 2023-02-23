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
public class ItemAllocation {
    @NotNull
private int itemAllocationId;
    @NotNull
private int userId;
    @NotNull
private int itemId;
private Date allocationDate;
private Date expectedReturnDate;
private Date returnedOn;
private int dueByDays;
private int librarianId;
private String dueStatus;
}
