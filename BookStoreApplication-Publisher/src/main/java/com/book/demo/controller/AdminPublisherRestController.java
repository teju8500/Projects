package com.book.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.demo.entity.Publisher;
import com.book.demo.service.PublisherService;


@RestController
@RequestMapping("/admin")
public class AdminPublisherRestController {
	@Autowired
	PublisherService publisherService;

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	@PostMapping("/addPublisher")
	public ResponseEntity<String> addPublisher(@RequestBody Publisher publisher) {

		try {
			Publisher savedPublisher = publisherService.addPublisher(publisher);
			String responseMsg = savedPublisher.getPublisherName()+" save with Id "+ savedPublisher.getPublisherId();
			mylogs.info("A value is added ");
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
	
	@PutMapping("/publisher/{publisherId}")
	public Publisher updatePublisher(@PathVariable int publisherId, @RequestBody Publisher  publisherDetails) throws Exception {
		publisherService.getPublisherByPublisherId(publisherId);
		publisherDetails.setPublisherId(publisherId);
		Publisher updatePublisher = publisherService.addPublisher(publisherDetails);
		return updatePublisher;
	}
	@DeleteMapping("/delete/{searchPublisherid}")
	public void deletePublisherById(@PathVariable int searchPublisherid) {

		try {
			publisherService.deletePublisherById(searchPublisherid);
			
		  }catch(Exception e){
			  e.printStackTrace();
		  }
	}
	
	

	@GetMapping("/id/{searchPublisherid}")
	public Publisher getPublisherByPublisherID(@PathVariable int searchPublisherid) throws Exception {
		return publisherService.getPublisherByPublisherId(searchPublisherid);
	}

	

	@GetMapping("/publisherbyId")
	public List<Publisher> getPublisherSBetweenIds(@RequestParam int range1, @RequestParam int range2) throws Exception {

		return publisherService.getPublishersBetweenIds(range1, range2);
	}
	
	
	
	@GetMapping("/filterPublisherName/{publisherName}")
	public List<Publisher> filterPublisher1(@PathVariable String publisherName) throws Exception {
		
		    	List<Publisher> allfiltered=publisherService.filterByPublisherName(publisherName);
				return allfiltered;
	}

	@GetMapping("/filterAddress/{address}")
	public List<Publisher> filterPublisher2(@PathVariable String address) throws Exception {
		
		List<Publisher> allfiltered=publisherService.filterByAddress(address);
		return allfiltered;
	}

	@GetMapping("/filterCountry/{country}")
	public List<Publisher> filterPublisher3(@PathVariable String country) throws Exception {
		
		List<Publisher> allfiltered=publisherService.filterByCountry(country);
		return allfiltered;
	}
	@GetMapping("/sort/{country}")
	   public List<Publisher> getBySorting() throws Exception
		    {
		    	List<Publisher> allPublishers=publisherService.SortingPublishersBasedOnCountry();
		    	return allPublishers;
		    }
	}


