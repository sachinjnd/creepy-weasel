package org.helpiez.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.helpiez.api.DAO.GroupDAO;
import org.helpiez.api.DAO.StoryDAO;
import org.helpiez.api.DAO.UserDAO;
import org.helpiez.api.model.Group;
import org.helpiez.api.model.Story;
import org.helpiez.api.model.User;
import org.helpiez.api.response.ResStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class StoryController {
	
	@Autowired
    private StoryDAO storydao;
	
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
    private GroupDAO groupDAO;

  	@RequestMapping(value=URI_Constants.GET_STORY_BY_ID, method=RequestMethod.GET)
    public Story getStorybyId(@PathVariable("id") int id) {	    	
  		Story story = storydao.getStorybyID(id); 
    	return story;
    }
  	
  	@RequestMapping(value=URI_Constants.GET_STORY, method=RequestMethod.GET)
    public ResStory getStory(@PathVariable("urlname") String uString) {
  			
  		ResStory res= new ResStory();
  		Story story = storydao.getStory(uString); 
  		res.setStory(story);
  		User user = userDAO.getshortuserbyid(Integer.parseInt(story.getAuthorid()));
  		res.setAuthor(user);
  		String str= userDAO.getUsermeta(Integer.parseInt(story.getAuthorid()),"about");
  		Group group =groupDAO.getshortorgbyid(story.getGroupid());
  		res.setGroup(group);	
  		res.setAuthordesc(str);
    	return res;
    }
  	
  	@RequestMapping(value=URI_Constants.GET_STORYS, method=RequestMethod.GET)
    public List<ResStory> getStorys(@PathVariable("type") String type, @PathVariable("id") String id ) {
  		List<ResStory> lsts= new ArrayList<ResStory>(); 
  		List<Story> lst = storydao.getStorys(type, id);
  		if (lst!=null && lst.size()>0)
  		{
  			for (Story string : lst) {
  				ResStory res= new ResStory();
  		  		Story story = storydao.getStory(string.getUrl()); 
  		  		res.setStory(story);
  		  		User user = userDAO.getshortuserbyid(Integer.parseInt(story.getAuthorid()));
  		  		res.setAuthor(user);
  		  	    Group group =groupDAO.getshortorgbyid(story.getGroupid());
  		  	    res.setGroup(group);
  		  		lsts.add(res);
			}
  		}
  		
  		return lsts;
    }
  	
  	@RequestMapping(value=URI_Constants.UPDATE_STORY, method=RequestMethod.PUT)
    public boolean editStorybyId(@RequestBody Story story) {	    	
  		Story story2 = storydao.getStorybyID(story.getId()); 
    	return storydao.update(story, story2);
    }
  	
  	@RequestMapping(value=URI_Constants.INSERT_STORY, method=RequestMethod.POST)
    public long createstory(@RequestBody Story story) {	    	
  		// check whether in proper format
		if (story.getName()!=null)
		{
    	return storydao.createStory(story);
		}
		else{ return 0;}
    }

}
