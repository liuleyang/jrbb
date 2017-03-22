package actionForm;

import org.apache.struts.action.ActionForm;

public class PrizeForm extends ActionForm {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String grade;
    private String name;
    private String picPath;
    private int quantity;
    private int id;
    
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPicPath() {
        return picPath;
    }
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
