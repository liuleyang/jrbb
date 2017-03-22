package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;

import actionForm.PersonForm;
import dao.PersonDao;


public final class PersonAction extends DispatchAction {
    private PersonDao dao;
    
    public PersonAction() {
        super();
        dao = new PersonDao();
    }
    // 奖品起始画面
    public ActionForward showAllPerson(ActionMapping mapping,
                                       ActionForm form,
                                       HttpServletRequest req,
                                       HttpServletResponse res) throws Exception {
        req.setAttribute("person", dao.getAllPerson());
        return (mapping.findForward("main"));
    }
    // 修改奖品画面列表
    public ActionForward showPerson(ActionMapping mapping,
                                    ActionForm form,
                                    HttpServletRequest req,
                                    HttpServletResponse res) throws Exception {
        req.setAttribute("person", dao.getAllPerson());
       // JSONArray jsonArray = JSONArray.fromObject(dao.getAllPrizes());
       // req.setAttribute("prizesJson", jsonArray);
        return (mapping.findForward("show"));
    }
    // 添加/修改奖品操作
    public ActionForward cuPerson(ActionMapping mapping,
                                  ActionForm form,
                                  HttpServletRequest req,
                                  HttpServletResponse res) throws Exception {
        PersonForm person = new PersonForm();
        
        person.setPerson_name(req.getParameter("person_name"));
        person.setPerson_photo("/image/"+ req.getParameter("image"));
        
        String id = req.getParameter("person_id");
        if(id == null || id.isEmpty())
        {
           dao.addPerson(person);
        }
        else
        {
        	person.setPerson_id(Integer.parseInt(id));
            dao.updatePerson(person);
        }
        res.sendRedirect("PersonAction.do?method=showPerson");
        return null;
    }
    // 添加奖品画面跳转
    public ActionForward addPerson(ActionMapping mapping,
                                  ActionForm form,
                                  HttpServletRequest req,
                                  HttpServletResponse res) throws Exception {
        System.out.println("add");
        return (mapping.findForward("add"));

    }
    // 删除奖品操作
    public ActionForward deletePerson(ActionMapping mapping,
                                     ActionForm form,
                                     HttpServletRequest req,
                                     HttpServletResponse res) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.deletePerson(id);
        res.sendRedirect("PersonAction.do?method=showPerson");
        System.out.println("delete");
        return null;
    }
    // 修改奖品画面跳转
    public ActionForward editPerson(ActionMapping mapping,
                                   ActionForm form,
                                   HttpServletRequest req,
                                   HttpServletResponse res) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        PersonForm person = dao.getPersonById(id);
        req.setAttribute("person", person);
        System.out.println("edit");
        return (mapping.findForward("edit"));
    }
 
  		
  	/*	<% List<PrizeForm> l=(List<PrizeForm>)request.getAttribute("prize"); %> 
  		<%
  		int a=0;
  		if(l.get(0).getGrade().equals("一等奖"))
  			a=1;
  		if(l.get(0).getGrade().equals("二等奖"))
  			a=2;
  		if(l.get(0).getGrade().equals("三等奖"))
  			a=3;
  		PersonDao dao = new PersonDao();	
  		List<PersonForm> list = null;
  		dao.delete();
  		list=dao.selectPerson();

  		PersonDao dao1 = new PersonDao();	
  		List list1 = null;	
  		list1=dao.selectName(l.get(0).getQuantity(),a);
  		%>*/
  	
    
}
