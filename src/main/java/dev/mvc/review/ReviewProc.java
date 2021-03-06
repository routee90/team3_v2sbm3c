package dev.mvc.review;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component("dev.mvc.review.ReviewProc")
public class ReviewProc implements ReviewProcInter{
    @Autowired
    private ReviewDAOInter reviewDAO;
    
    @Override
    public int create(ReviewVO reviewVO) {
        int cnt=this.reviewDAO.create(reviewVO);
        return cnt;
    }

    @Override
    public List<ReviewVO> list_reviewno() {
        List<ReviewVO> list=this.reviewDAO.list_reviewno();
        return list;
    }

    @Override
    public ReviewVO read(int reviewno) {
        ReviewVO reviewVO = reviewDAO.read(reviewno);
        return reviewVO;
    }
    
    @Override
    public int update(ReviewVO reviewVO) {
        int cnt = this.reviewDAO.update(reviewVO);
        return cnt;
    }

    @Override
    public int delete(int reviewno) {
        int cnt=this.reviewDAO.delete(reviewno);
        return cnt;
    }
    
    
    
    public List<ReviewVO> list_storeno(int storeno) {
        List<ReviewVO> list=this.reviewDAO.list_storeno(storeno);
        return list;
    }

    @Override
    public int read_user(HashMap<String, Integer> hashmap){
        int cnt = this.reviewDAO.read_user(hashmap);
        return cnt;
    }

  
    
}
