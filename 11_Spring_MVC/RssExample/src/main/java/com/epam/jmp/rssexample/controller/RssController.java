package com.epam.jmp.rssexample.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.colorfulsoftware.rss.RSS;
import com.colorfulsoftware.rss.RSSDoc;
import com.epam.jmp.rssexample.model.SampleContent;

@Controller
public class RssController {

	@RequestMapping(value="/rssfeed", method = RequestMethod.GET)
	public ModelAndView getFeedInRss() {

		List<SampleContent> items = new ArrayList<SampleContent>();

		SampleContent content  = new SampleContent();
		content.setTitle("Test title 1");
		content.setUrl("http://1");
		content.setSummary("Tutorial 1 summary ...");
		content.setCreatedDate(new Date());
		items.add(content);

		SampleContent content2  = new SampleContent();
		content2.setTitle("Test title 2");
		content2.setUrl("http://2");
		content2.setSummary("Tutorial 2 summary ...");
		content2.setCreatedDate(new Date());
		items.add(content2);
 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rssViewer");
		mav.addObject("feedContent", items);

		return mav;

	}

	@RequestMapping(value = "/readfeeds", method = RequestMethod.GET)
	@ResponseBody
	public String readFeedsFromUrl() throws Exception {

		String urlStr = "http://localhost:8081/RssExample/rssfeed";
		RSS myRSS = new RSSDoc().readRSSToBean(new URL(urlStr));

		return "READ from [" + urlStr + "]:\n" + myRSS.toString();
	}

}
