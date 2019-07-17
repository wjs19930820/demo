package com.example.demo.service;

import com.example.demo.domain.Result;
import com.example.demo.domain.Review;
import com.example.demo.domain.ReviewQuery;

import java.util.Collection;
import java.util.List;

/**
 * 的Service接口
 * 
 * @author zsp
 * @date 2018-5-15
 */
public interface ReviewService {

	void testStratagy();

	/**
	 * 保存
	 *
	 * @param review
	 * @return 如果成功，返回的结果的errorCode为null；否则返回错误码。
	 */
	Result<Review> saveReview(Review review);
	
	/**
	 * 保存多个
	 *
	 * @param col
	 * @return 如果成功，返回的结果的errorCode为null；否则返回错误码。
	 */
	Result<?> saveAllReview(Collection<Review> col);
	
	/**
	 * 更新
	 *
	 * @param review
	 * @return 如果成功，返回的结果的errorCode为null；否则返回错误码。
	 */
	Result<?> updateReview(Review review);
	
	/**
	 * 删除
	 *
	 * @param id
	 */
	void deleteReview(Long id);
	
	/**
	 * 判断是否存在
	 *
	 * @param id
	 * @return 
	 */
	boolean isReviewExists(Long id);
	
	/**
	 * 查找一个
	 *
	 * @param id
	 * @return 
	 */
	Review getReview(Long id);
	
	/**
	 * 查找多个
	 *
	 * @return 如果成功，返回的结果的errorCode为null；否则返回错误码。
	 */
	List<Review> listReviewByIds(Collection<Long> col);
	
	/**
	 * 查找多个
	 *
	 * @param query 查找条件
	 * @return
	 */
	List<Review> listReview(ReviewQuery query);
	
	/**
	 * 统计个数
	 *
	 * @return
	 */
	long countReview(ReviewQuery query);
	
}
