package org.helpiez.api.controller;

import java.util.List;

import org.helpiez.api.DAO.EventsDAO;
import org.helpiez.api.DAO.GroupDAO;
import org.helpiez.api.DAO.UserDAO;
import org.helpiez.api.model.Events;
import org.helpiez.api.response.ResActivity;
import org.helpiez.api.response.ResEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class EventController {
	

	@Autowired
    private EventsDAO eventdao;
	
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
    private GroupDAO groupDAO;

  	@RequestMapping(value=URI_Constants.GET_EVENT_BY_ID, method=RequestMethod.GET)
    public Events getEventbyId(@PathVariable("id") long id) {	    	
  		Events event = eventdao.getEventbyID(id); 
    	return event;
    }
  	
  	@RequestMapping(value=URI_Constants.GET_CUSTOM_EVENT_BY_NAME, method=RequestMethod.GET)
  	public ResEvents getCustumEvent(@PathVariable("urlname") String urlname ) {	    	
  		ResEvents event = new ResEvents();
  		event.setEvents(eventdao.getEvent(urlname));
  		event.setAuthor(userDAO.getshortuserbyid(Integer.parseInt(event.getEvents().getAuthorid())));
  		event.setGroup(groupDAO.getshortorgbyid(event.getEvents().getGroupid()));
    	return event;
    }
  	
  	@RequestMapping(value=URI_Constants.UPDATE_EVENT, method=RequestMethod.PUT)
    public Boolean updateEvent(@RequestBody Events event) {	 
  		Events event2= eventdao.getEventbyID(event.getId()); 
  		return eventdao.update(event, event2);
    }
  	
	@RequestMapping(value=URI_Constants.INSERT_EVENT, method=RequestMethod.POST)
    public String insertEvent(@RequestBody Events event) {	 
    	return eventdao.save(event);
    }
	
	@RequestMapping(value=URI_Constants.GET_EVENT, method=RequestMethod.GET)
    public Events getEvent(@PathVariable("urlname") String urlname ) {	    	
  		Events event = eventdao.getEvent(urlname); 
    	return event;
    }
	
	@RequestMapping(value=URI_Constants.GET_EVENTS, method=RequestMethod.GET)
    public List<ResActivity> getEvents(@PathVariable("id") long id ) {	    	
		List<ResActivity> event = eventdao.getEvents(id); 
    	return event;
    }

}
