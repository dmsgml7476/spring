package com.bookSystem.Entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUse {
	private int id;
	private int member_id;
	private int book_id;
	private String status;
	private LocalDate loan_date;
	private LocalDate return_date;
	

}
