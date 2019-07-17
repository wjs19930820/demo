package com.example.demo.dao;

import com.example.demo.domain.Review;
import com.example.demo.domain.ReviewQuery;

import java.util.Collection;
import java.util.List;

/**
 * 的Dao
 * 
 * @author zsp
 * @date 2018-5-15
 */
public interface ReviewDao {
	
	/**
	 * 保存
	 *
	 * @param review
	 */
	void saveReview(Review review);
	
	/**
	 * 保存多个
	 *
	 * @param col
	 */
	void saveAllReview(Collection<Review> col);
	
	/**
	 * 更新
	 *
	 * @param review
	 */
	int updateReview(Review review);
	
	/**
	 * 删除
	 *
	 * @param id
	 */
	int deleteReview(Long id);
	
	/**
	 * 判断是否存在
	 *
	 * @param id
	 * @return 返回true表示存在；否则返回false表示不存在。
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
	 * @param ids 标识集合
	 * @return
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
	 * @param 查找条件
	 * @return
	 */
	long countReview(ReviewQuery query);
	
}
