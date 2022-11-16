package com.book.demo.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor

public class AllExceptionDTO {
	
	
	private @Getter @Setter String msg;
	private @Getter @Setter String publisherInput;
	private @Getter @Setter String dateAndTime;
	
	public void setMsg(String localizedMessage) {
		// TODO Auto-generated method stub
		
	}

	public void setPublisherInput(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setDateAndTime(String string) {
		// TODO Auto-generated method stub
		
	}

}
