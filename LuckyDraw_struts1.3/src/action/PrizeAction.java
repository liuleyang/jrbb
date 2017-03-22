package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;

import actionForm.PrizeForm;
import dao.PersonDao;
import dao.PrizeDao;

public final class PrizeAction extends DispatchAction {
    private PrizeDao dao;
    private PersonDao dao1;
    
    public PrizeAction() {
        super();
        dao = new PrizeDao();
        dao1 = new PersonDao();
    }
    // 奖品起始画面
    public ActionForward showAllPrizes(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest req,
                                       HttpServletResponse res) throws Exception {
        req.setAttribute("prizes", dao.getAllPrizes());
        return (mapping.findForward("main"));
    }
    // 修改奖品画面列表
    public ActionForward showPrizes(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest req,
                                    HttpServletResponse res) throws Exception {
        req.setAttribute("prizes", dao.getAllPrizes());
       // JSONArray jsonArray = JSONArray.fromObject(dao.getAllPrizes());
       // req.setAttribute("prizesJson", jsonArray);
        return (mapping.findForward("show"));
    }
    // 添加/修改奖品操作
    public ActionForward cuPrize(ActionMapping mapping,
                                  ActionForm form,
                                  HttpServletRequest req,
                                  HttpServletResponse res) throws Exception {
        PrizeForm prize = new PrizeForm();
        
        prize.setGrade(req.getParameter("grade"));
        prize.setName(req.getParameter("name"));
        prize.setQuantity(Integer.parseInt(req.getParameter("quantity")));
        prize.setPicPath("/image/"+ req.getParameter("image"));
        
        String id = req.getParameter("id");
        if(id == null || id.isEmpty())
        {
           dao.addPrize(prize);
        }
        else
        {
            prize.setId(Integer.parseInt(id));
            dao.updatePrize(prize);
        }
        res.sendRedirect("PrizeAction.do?method=showPrizes");
        return null;
    }
    // 添加奖品画面跳转
    public ActionForward addPrize(ActionMapping mapping,
                                  ActionForm form,
                                  HttpServletRequest req,
                                  HttpServletResponse res) throws Exception {
        System.out.println("add");
        return (mapping.findForward("add"));

    }
    // 删除奖品操作
    public ActionForward deletePrize(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest req,
                                     HttpServletResponse res) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.deletePrize(id);
        res.sendRedirect("PrizeAction.do?method=showPrizes");
        System.out.println("delete");
        return null;
    }
    // 修改奖品画面跳转
    public ActionForward editPrize(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest req,
                                   HttpServletResponse res) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        PrizeForm prize = dao.getPrizeById(id);
        req.setAttribute("prize", prize);
        System.out.println("edit");
        return (mapping.findForward("edit"));
    }
    // 抽奖结果展示
    public ActionForward showPrizesbyaward(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest req,
            HttpServletResponse res) throws Exception {
    	PersonDao dao=new PersonDao();
    	req.setAttribute("person", dao.getPersonByAward());
    	//req.setAttribute("prizes", dao.getPersonByAward());
    	return (mapping.findForward("next"));
    }
	//单个奖品展示
	public ActionForward selectPrize(ActionMapping mapping,
    							     ActionForm form,
    							     HttpServletRequest req,
    							     HttpServletResponse res) throws Exception{
    	int id = Integer.parseInt(req.getParameter("id"));
    	PrizeForm prize = dao.getPrizeById(id);
    	String grade = prize.getGrade();
    	int quantity = prize.getQuantity();
    	int a=0,a1=0;
    	if(grade.equals("一等奖"))
    		a=1;
    	if(grade.equals("二等奖"))
    		a=2;
    	if(grade.equals("三等奖"))
    		a=3;
    	if(grade.equals("四等奖"))
    		a=4;
    	if(grade.equals("神秘奖"))
    		a1=1;
    	List award = dao1.updateAward(a);
  	    int b = quantity-award.size();
  	    dao1.selectName(b, a);
  	    req.setAttribute("award", award);
    	JSONArray jsonArray = JSONArray.fromObject(dao1.getAllPerson());
  	    req.setAttribute("person", jsonArray);
        req.setAttribute("prize", prize);
        System.out.println("jump");
        return (mapping.findForward("jump"));
    }
	
}
