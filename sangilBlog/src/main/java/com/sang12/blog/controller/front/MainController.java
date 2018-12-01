package com.sang12.blog.controller.front;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rometools.rome.feed.rss.Channel;
import com.sang12.blog.service.common.CommonService;
import com.sang12.blog.vo.front.MainPageVo;


@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private CommonService commonService;
	
	@RequestMapping("/")
	public ModelAndView main(MainPageVo vo){
		logger.info("vo:::::"+vo);
		Map<String, Object> data = commonService.getMainData(vo);
		logger.info("data:::::"+data);
		return new ModelAndView("front/main", "mainData", data);
	}
	
	@RequestMapping("/category/{largeCategoryName}")
	public ModelAndView largeCategory(MainPageVo vo, @PathVariable String largeCategoryName){
		logger.info("vo:::::"+vo);
		vo.setLargeCategoryName(largeCategoryName);
		Map<String, Object> data = commonService.getMainData(vo);
		logger.info("data:::::"+data);
		return new ModelAndView("front/main", "mainData", data);
	}
	
	@RequestMapping("/category/{largeCategoryName}/{middleCategoryName}")
	public ModelAndView MiddleCategory(MainPageVo vo, @PathVariable String largeCategoryName, @PathVariable String middleCategoryName){
		logger.info("vo:::::"+vo);
		vo.setLargeCategoryName(largeCategoryName);
		vo.setMiddleCategoryName(middleCategoryName);
		Map<String, Object> data = commonService.getMainData(vo);
		logger.info("data:::::"+data);
		return new ModelAndView("front/main", "mainData", data);
	}
	
	@RequestMapping("/tag/{tagName}")
	public ModelAndView tag(MainPageVo vo, @PathVariable String tagName){
		logger.info("vo:::::"+vo);
		vo.setTagName(tagName);
		Map<String, Object> data = commonService.getMainData(vo);
		//tag로 검색여부를 알려주기위한 변수값
		data.put("type", "tag");
		data.put("tagName", vo.getTagName());
		logger.info("data:::::"+data);
		return new ModelAndView("front/main", "mainData", data);
	}
	
	@RequestMapping("/intro")
	public String intro(){
		return "front/intro";
	}
	
	@RequestMapping("/guestbook")
	public ModelAndView guestbook(){
		return new ModelAndView("front/guestbook");
	}
	
	@GetMapping("/rss")
	@ResponseBody
	public Channel rss() {
		return commonService.getRssList();
	}
	
	@RequestMapping(value = "/robots.txt")
	@ResponseBody
	public String robots() {
		return "User-agent: *\nDisallow: /md\n";
	}
	
	@RequestMapping("/{articleId}")
	public ModelAndView getArticle(@PathVariable int articleId){
		Map<String, Object> data = commonService.getArticle(articleId);
		logger.info("data:::::"+data);
		return new ModelAndView("front/main", "mainData", data);
	}
	
	@RequestMapping("/search/{keyword}")
	public ModelAndView search(@PathVariable String keyword){
		logger.info("data:::::"+keyword);
		Map<String, Object> data = commonService.searchKeyword(keyword);
		return new ModelAndView("front/search", "mainData", data);
	}
	
}
