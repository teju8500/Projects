package com.book.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class PublisherDefaultResponseDTO  implements MyDTO{
		private @Getter @Setter String publisherName;
		private @Getter @Setter String   address;
		private @Getter @Setter String country;
		
		
		public PublisherDefaultResponseDTO(String publisherName, String address, String country) {
			super();
			this.publisherName = publisherName;
			this.address = address;
			this.country = country;
		}
		
		
		
	}
