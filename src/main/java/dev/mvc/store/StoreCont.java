package dev.mvc.store;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.menu.MenuProcInter;
import dev.mvc.menu.MenuVO;
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
    
    public StoreCont() {
        System.out.println("-> StoreCont created.");
    }

    /*
     * @RequestMapping(value = "/store/store.do", method = RequestMethod.GET) public
     * ModelAndView main() { ModelAndView mav = new ModelAndView();
     * mav.setViewName("/store/food_main"); // webapp/WEB-INF/views/store/create.jsp
     * 
     * return mav; // forward }
     */
    @RequestMapping(value = "/store/store.do", method = RequestMethod.GET)
    public ModelAndView store(int storeno) {
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
        mav.setViewName("/store/food_main"); // webapp/WEB-INF/views/store/create.jsp
                
        return mav; // forward
    }
    
    
   
    @RequestMapping(value = "/store/create.do", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/store/create"); // webapp/WEB-INF/views/store/create.jsp

        return mav; // forward
    }
    
    @RequestMapping(value = "/store/create.do", method = RequestMethod.POST)
    public ModelAndView create(StoreVO storeVO) {
        ModelAndView mav = new ModelAndView();
        int cnt = this.storeProc.create(storeVO);
        mav.addObject("cnt", cnt);
        mav.addObject("code", "create_success");
        if(cnt==1) {          
            mav.setViewName("redirect:/store/list.do");  // webapp/WEB-INF/views/store/list_all.jsp
        }
        return mav; // forward
    }
    
    
    @RequestMapping(value = "/store/list.do", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        List<StoreVO> list = this.storeProc.list_all();
        mav.addObject("list", list); 
        mav.setViewName("/store/list");  // webapp/WEB-INF/views/store/list_all.jsp
        return mav; // forward
    }
    
    @RequestMapping(value="/store/read_ajax.do", method=RequestMethod.GET )
    @ResponseBody
    public String read_ajax(int storeno) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }    

       StoreVO storeVO = this.storeProc.read(storeno);
          
        JSONObject json = new JSONObject();
        json.put("storeno", storeVO.getStoreno());
        json.put("name", storeVO.getName());
        json.put("adress", storeVO.getAdress());
        json.put("lat", storeVO.getLat());
        json.put("lng", storeVO.getLng());
        json.put("visible", storeVO.getVisible());

          
        return json.toString();
    }
    
    @RequestMapping(value = "/store/update.do", method = RequestMethod.POST)
    public ModelAndView update(StoreVO storeVO) {
        ModelAndView mav = new ModelAndView();
        int cnt = this.storeProc.update(storeVO);
        mav.addObject("cnt", cnt);
        mav.addObject("code", "create_success");
        if(cnt==1) {          
            mav.setViewName("redirect:/store/list.do");  // webapp/WEB-INF/views/store/list_all.jsp
        }
        return mav; // forward
    }
    
    @RequestMapping(value = "/store/delete.do", method = RequestMethod.POST)
    public ModelAndView delete(int storeno) {
        ModelAndView mav = new ModelAndView();
        int cnt = this.storeProc.delete(storeno);
        mav.addObject("cnt", cnt);
        mav.addObject("code", "create_success");
        if(cnt==1) {          
            mav.setViewName("redirect:/store/list.do");  // webapp/WEB-INF/views/store/list_all.jsp
        }
        return mav; // forward
    }
}
