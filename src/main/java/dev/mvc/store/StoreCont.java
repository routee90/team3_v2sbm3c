package dev.mvc.store;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.cate.CateProcInter;
import dev.mvc.cate.Cate_StoreVO;
import dev.mvc.keyword.KeywordProcInter;
import dev.mvc.menu.MenuProcInter;
import dev.mvc.menu.MenuVO;
import dev.mvc.review.ReviewProcInter;
import dev.mvc.review.ReviewVO;
import dev.mvc.users.UsersProcInter;
import dev.mvc.users.UsersVO;
import dev.mvc.work.WorkProcInter;
import dev.mvc.work.WorkVO;

@Controller
public class StoreCont {
    @Autowired
    @Qualifier("dev.mvc.store.StoreProc")
    private StoreProcInter storeProc;

    @Autowired
    @Qualifier("dev.mvc.menu.MenuProc")
    private MenuProcInter menuProc;

    @Autowired
    @Qualifier("dev.mvc.work.WorkProc")
    private WorkProcInter workProc;

    @Autowired
    @Qualifier("dev.mvc.review.ReviewProc")
    private ReviewProcInter reviewProc;

    @Autowired
    @Qualifier("dev.mvc.keyword.KeywordProc")
    private KeywordProcInter keywordProc;
    
    @Autowired
    @Qualifier("dev.mvc.cate.CateProc") 
    private CateProcInter cateProc;
    
    @Autowired
    @Qualifier("dev.mvc.users.UsersProc")
    private UsersProcInter usersProc;

    public StoreCont() {
        // System.out.println("-> StoreCont created.");
    }
    /**
     * 상품 목록 http://localhost:9091/store/store.do?storeno=1
     * 
     * @return
     */
    
    @RequestMapping(value = "/store/store.do", method = RequestMethod.GET)
    public ModelAndView store2(HttpServletRequest request , int storeno) throws Exception{
        ModelAndView mav = new ModelAndView();
        StoreVO storeVO = this.storeProc.read(storeno);
        mav.addObject("storeVO", storeVO);
        List<MenuVO> m_list = this.menuProc.list_storeno(storeno);
        mav.addObject("m_list", m_list);
        List<WorkVO> w_list = this.workProc.list_storeno(storeno);
        mav.addObject("w_list", w_list);
        int work_count = this.workProc.count_by_storeno(storeno);
        mav.addObject("work_count", work_count);
        int menu_count = this.menuProc.count_by_storeno(storeno);
        mav.addObject("menu_count", menu_count);
        List<ReviewVO> list = this.reviewProc.list_storeno(storeno);
        mav.addObject("r_list", list);
        List<String> cate_s = this.cateProc.read_s(storeno);
        mav.addObject("cate_s", cate_s);
        HttpSession session = request.getSession();
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        List<Users_ReviewVO> users_reveiwVO= new ArrayList<Users_ReviewVO>();
        int usersno=0;
        int adminno=0;
        if (session.getAttribute("usersno") != null) {
            usersno = (int)session.getAttribute("usersno");
            mav.setViewName("/store/food_main_user");
            
        } 
        else if(session.getAttribute("adminno") != null){           
            adminno = (int)session.getAttribute("adminno");
            mav.setViewName("/store/food_main_admin");
        }else {
            mav.setViewName("/store/food_main");
        }
        
        hmap.put("storeno", storeno);
        hmap.put("usersno", usersno);
        int user_c = this.reviewProc.read_user(hmap);
        List<UsersVO> list_user = this.usersProc.read_name(storeno);
        for(int i=0; i<list.size(); i++) {
            Users_ReviewVO user = new Users_ReviewVO();
            user.addReviewVO(list.get(i));               
            user.setName(list_user.get(i).getName());    
            users_reveiwVO.add(user);
        }                    
        mav.addObject("user_c", user_c);
        mav.addObject("usersno", usersno);
       mav.addObject("users_reveiwVO", users_reveiwVO);
        
        int count_1 = this.keywordProc.count_1(storeno);
        int count_2 = this.keywordProc.count_2(storeno);
        int count_3 = this.keywordProc.count_3(storeno);
        int count_4 = this.keywordProc.count_4(storeno);
        int count_5 = this.keywordProc.count_5(storeno);
        int count_6 = this.keywordProc.count_6(storeno);
        mav.addObject("count_1", count_1);
        mav.addObject("count_2", count_2);
        mav.addObject("count_3", count_3);
        mav.addObject("count_4", count_4);
        mav.addObject("count_5", count_5);
        mav.addObject("count_6", count_6);
        
        return mav; // forward
    }
    /**
     * 등록폼 http://localhost:9091/store/create.do
     * 
     * @return
     */
    @RequestMapping(value = "/store/create.do", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/store/create"); // webapp/WEB-INF/views/store/create.jsp

        return mav; // forward
    }
    /**
     * 등록 처리 http://localhost:9091/store/create.do
     * 
     * @return
     */

    @RequestMapping(value = "/store/create.do", method = RequestMethod.POST)
    public ModelAndView create(StoreVO storeVO) {
        ModelAndView mav = new ModelAndView();
        int cnt = this.storeProc.create(storeVO);
        mav.addObject("cnt", cnt);
        mav.addObject("code", "create_success");
        if (cnt == 1) {
            mav.setViewName("redirect:/store/list.do"); // webapp/WEB-INF/views/store/list_all.jsp
        }
        return mav; // forward
    }

    /*
     * @RequestMapping(value = "/store/list.do", method = RequestMethod.GET) public
     * ModelAndView list() { ModelAndView mav = new ModelAndView(); List<StoreVO>
     * list = this.storeProc.list_all(); mav.addObject("list", list);
     * mav.setViewName("/store/list"); // webapp/WEB-INF/views/store/list_all.jsp
     * return mav; // forward }
     */
    /**
     * 목록  + 페이징 지원
     * http://localhost:9090/store/list.do?storeno=1&now_page=1
     * 
     * @param storeno
     * @param now_page
     * @return
     */
    
    @RequestMapping(value = "/store/list.do", method = RequestMethod.GET)
    public ModelAndView list_search_paging(@RequestParam(value = "storeno", defaultValue = "1") int storeno,
                                                            @RequestParam(value = "now_page", defaultValue = "1") int now_page) {
      System.out.println("--> now_page: " + now_page);

      ModelAndView mav = new ModelAndView();

      HashMap<String, Object> map = new HashMap<String, Object>();
      map.put("storeno", storeno); // #{cateno}
      map.put("now_page", now_page); // 페이지에 출력할 레코드의 범위를 산출하기위해 사용
      
      List<StoreVO> list = this.storeProc.list_search_paging(map);
    
      mav.addObject("list", list);
     
      int cnt = this.storeProc.count();
      String paging = this.storeProc.pagingBox(storeno,cnt, now_page);
      mav.addObject("paging", paging);

      mav.setViewName("/store/list");

      return mav;
    }      
    /**
     * 상품  수정 삭제 폼 사전 준비된 레코드: 
     * http://localhost:9091/store/create.do?storeno=1
     * 
     * @param storeno     상품번호
     * @return
     */

    @RequestMapping(value = "/store/read_ajax.do", method = RequestMethod.GET)
    @ResponseBody
    public String read_ajax(int storeno) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int menu_c = this.menuProc.count_by_storeno(storeno);
        int work_c = this.workProc.count_by_storeno(storeno);
        StoreVO storeVO = this.storeProc.read(storeno);

        JSONObject json = new JSONObject();
        json.put("storeno", storeVO.getStoreno());
        json.put("name", storeVO.getName());
        json.put("address", storeVO.getaddress());
        json.put("lat", storeVO.getLat());
        json.put("lng", storeVO.getLng());
        json.put("visible", storeVO.getVisible());
        json.put("menu_c", menu_c);
        json.put("work_c", work_c);

        return json.toString();
    }

    /**
     * 상품 수정 처리 http://localhost:9091/store/update.do
     * 
     * @return
     */
    @RequestMapping(value = "/store/update.do", method = RequestMethod.POST)
    public ModelAndView update(StoreVO storeVO) {
        ModelAndView mav = new ModelAndView();
        int cnt = this.storeProc.update(storeVO);
        mav.addObject("cnt", cnt);
        mav.addObject("code", "create_success");
        if (cnt == 1) {
            mav.setViewName("redirect:/store/list.do"); // webapp/WEB-INF/views/store/list_all.jsp
        }
        return mav; // forward
    }
    /**
     * 상품 삭제 처리 http://localhost:9091/store/delete.do
     * 
     * @return
     */
    @RequestMapping(value = "/store/delete.do", method = RequestMethod.POST)
    public ModelAndView delete(int storeno) {
        ModelAndView mav = new ModelAndView();
        int cnt = this.workProc.count_by_storeno(storeno);
        if (cnt > 0) {
            this.workProc.delete_s(storeno);
        }
        cnt = this.menuProc.count_by_storeno(storeno);
        if (cnt > 0) {
            this.menuProc.delete_s(storeno);
        }
        cnt = this.storeProc.delete(storeno);
        mav.addObject("cnt", cnt);
        mav.addObject("code", "create_success");
        if (cnt == 1) {
            mav.setViewName("redirect:/store/list.do"); // webapp/WEB-INF/views/store/list_all.jsp
        }
        return mav; // forward
    }
}
