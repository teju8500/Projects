package com.book.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.demo.entity.Publisher;
import com.book.demo.service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class PublicPublisherRestController {
   
	@Autowired
	PublisherService publisherService;
	
	public PublicPublisherRestController() {
		System.out.println("\n\n\n=======>> Inside Constructor "+this);
	}
	
	@GetMapping("/allpublishers")
	public List<Publisher> getAllPublisher() {
		try {
			List<Publisher> allExtractedPublishers = publisherService.getAllPublishers();
			return allExtractedPublishers;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	

	@GetMapping("/id/{searchPublisherid}")
	public Publisher getPublisherByPublisherID(@PathVariable int searchPublisherid) throws Exception {
		return publisherService.getPublisherByPublisherId(searchPublisherid);
	}

	

	@GetMapping("/publisherbyId")
	public List<Publisher> getPublisherSBetweenIds(@RequestParam int range1, @RequestParam int range2) throws Exception {

		return publisherService.getPublishersBetweenIds(range1, range2);
	}
	
	
	
	@GetMapping("/filter/{publisherName}")
	public List<Publisher> filter1(@PathVariable String publisherName) throws Exception {
		
		    	List<Publisher> allfilteredPublishers=publisherService.filterByPublisherName(publisherName);
				return allfilteredPublishers;
	}

	@GetMapping("/filter/{address}")
	public List<Publisher> filter2(@PathVariable String adddress) throws Exception {
		
		List<Publisher> allfilteredAddress=publisherService.filterByAddress(adddress);
		return allfilteredAddress;
	}

	@GetMapping("/filter/{country}")
	public List<Publisher> filterByCountry(@PathVariable String country) throws Exception {
		
		List<Publisher> allfilteredCountry=publisherService.filterByCountry(country);
		return allfilteredCountry;
	}}