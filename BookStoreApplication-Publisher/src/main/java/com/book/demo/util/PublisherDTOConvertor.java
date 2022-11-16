package com.book.demo.util;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.book.demo.dto.PublisherDefaultResponseDTO;
import com.book.demo.entity.Publisher;

@Component
@Scope("singleton")
public class PublisherDTOConvertor {
	public  PublisherDefaultResponseDTO  getPublisherDefaultDTO(Publisher publisher)
	{
		PublisherDefaultResponseDTO dto = new PublisherDefaultResponseDTO(
				                 publisher.getPublisherName(), 
				                 publisher.getAddress(),
				                 publisher.getCountry()); 
				                
		return dto;
	}
	
	
	
	
	/*public  PublisherPostCreatedResponseDTO getPostCreatedDTO(Publisher publisher,Book book)
	{
		PublisherPostCreatedResponseDTO dto = new PublisherPostCreatedResponseDTO(
				 publisher.getPublisherName(), 
                 publisher.getPublisherAddress(), 
                 book.getDescription(),
                 "book Added "+book.getDate()
                 );
				 
				 return dto;
	}*/

}