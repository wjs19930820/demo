/*
 * Powered By zgtx scm team
 * Web Site: http://www.zgxcw.com
 * Since 2016
 */

package com.example.demo.controller;

import com.example.demo.domain.Result;
import com.example.demo.domain.Review;
import com.example.demo.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 的Rest实现
 * 
 * @author zsp
 * @date 2018-5-15
 */
@Controller
@RequestMapping("review")
public class ReviewControllerImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewControllerImpl.class);

	@Autowired ReviewService reviewService;

	@RequestMapping(value = "/get")
	@ResponseBody
	public Result<Review> findOneReview(@RequestParam Long reviewId) {
		Review result = reviewService.getReview(reviewId);
		return Result.result(result);
	}

	@RequestMapping("/reviewList")
	public ModelAndView reviewList() {
		return new ModelAndView("review/reviewList");
	}

	@RequestMapping(value = "/testStratagy")
	@ResponseBody
	public void testStratagy() {
		reviewService.testStratagy();
	}
	
	/*@RequestMapping(value = "list-by-ids", method = RequestMethod.POST)
	public CommonResponse<List<ReviewDto>> findAllReviewByIds(@RequestBody Collection<ReviewDto> col) {
		try {
			List<Long> ids = null;
			List<ReviewDto> reviewDtoList = copyAll2Dto(reviewService.findAllReviewByIds(ids));
			return CommonResponse.result(reviewDtoList);
		} catch (Throwable t) {
			logger.error(CommonResponse.INTERNAL_SERVER_ERROR_MSG, t);
			return CommonResponse.error();
		}
	}*/
	
}
