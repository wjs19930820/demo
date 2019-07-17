package com.example.demo.service;


import com.example.demo.dao.ReviewDao;
import com.example.demo.domain.Result;
import com.example.demo.domain.Review;
import com.example.demo.domain.ReviewQuery;
import com.example.demo.stratagy.Stratagy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 的Service实现
 * 
 * @author zsp
 * @date 2018-5-15
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    /**
     * 注入的的Dao接口实现
     */
	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private Map<String, Stratagy> stratagyMap;

	@Autowired
	private List<Stratagy> stratagyList;

	@Autowired
	@Qualifier("Stratagy2")
	private Stratagy stratagy;

	@Override
	public void testStratagy(){
		System.out.println("===========map===========");
		for (Map.Entry<String, Stratagy> stringStratagyEntry : stratagyMap.entrySet()) {
			System.out.println(stringStratagyEntry.getKey() + "  -  "+ stringStratagyEntry.getValue());
			System.out.println(stringStratagyEntry.getValue().calCharge(100D));
		}
		System.out.println("===========list===========");
		for (Stratagy stratagy1 : stratagyList) {
			System.out.println(stratagy1.calCharge(100D));
		}
		System.out.println("===========stratagy===========");
		System.out.println(stratagy.calCharge(100D));
	}

	@Override
	public Result<Review> saveReview(Review review) {
		reviewDao.saveReview(review);
		return null;
	}
	
	@Override
	public Result<?> saveAllReview(Collection<Review> col) {
		reviewDao.saveAllReview(col);
		return null;
	}
	
	@Override
	public Result<?> updateReview(Review review) {
		if(review.getReviewId() == null) {
			throw new IllegalArgumentException();
		}
		reviewDao.updateReview(review);
		return null;
	}
	
	@Override
	public void deleteReview(Long id) {
		reviewDao.deleteReview(id);
	}
	
	@Override
	public boolean isReviewExists(Long id) {
		return reviewDao.isReviewExists(id);
	}
	
	@Override
	public Review getReview(Long id) {
		return reviewDao.getReview(id);
	}

	@Override
	public List<Review> listReviewByIds(Collection<Long> col) {
		return reviewDao.listReviewByIds(col);
	}
	
	@Override
	public List<Review> listReview(ReviewQuery query) {
		return reviewDao.listReview(query);
	}
	
	@Override
	public long countReview(ReviewQuery query) {
		return reviewDao.countReview(query);
	}
	
}
