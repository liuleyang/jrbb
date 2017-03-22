package actionForm;

import org.apache.struts.action.ActionForm;

public class PersonForm extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int person_id;
	private String person_name;
	private String person_photo;
	private int award;
	private int bw_flag;
	
	public int getBw_flag() {
		return bw_flag;
	}
	public void setBw_flag(int bw_flag) {
		this.bw_flag = bw_flag;
	}
	public int getAward() {
		return award;
	}
	public void setAward(int award) {
		this.award = award;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getPerson_photo() {
		return person_photo;
	}
	public void setPerson_photo(String person_photo) {
		this.person_photo = person_photo;
	}
	
}
