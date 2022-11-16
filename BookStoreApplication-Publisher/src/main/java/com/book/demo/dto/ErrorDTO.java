package com.book.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO implements MyDTO {
	
		private  @Getter @Setter String errorMsg;


	}

