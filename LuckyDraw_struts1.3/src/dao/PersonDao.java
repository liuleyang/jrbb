package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import actionForm.PersonForm;
import util.DbUtil;

public class PersonDao {
	private Connection connection;
	private PreparedStatement ps=null;
	public PersonDao(){
		connection = DbUtil.getConnection();
	}
	
	public List<PersonForm> getAllPerson() {
        List<PersonForm> list = new ArrayList<PersonForm>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from person");
            while (rs.next()) {
            	PersonForm pp = new PersonForm();
                pp.setPerson_id(rs.getInt("person_id"));
                pp.setPerson_name(rs.getString("person_name"));
                pp.setPerson_photo(rs.getString("person_photo"));
                pp.setAward(rs.getInt("award"));
                pp.setBw_flag(rs.getInt("bw_flag"));
                list.add(pp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
	
	

	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from person where person_id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public PersonForm getPersonById(int id) {
		// TODO Auto-generated method stub
		PersonForm person = new PersonForm();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from person where person_id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
            	person.setPerson_id(rs.getInt("person_id"));
            	person.setPerson_name(rs.getString("person_name"));
            	person.setPerson_photo(rs.getString("person_photo").substring(7));
            	person.setAward(rs.getInt("award"));
            	person.setBw_flag(rs.getInt("bw_flag"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
	}

	public void addPerson(PersonForm person) {
		// TODO Auto-generated method stub
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into person(person_name,person_photo) values (?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, person.getPerson_name());
            preparedStatement.setString(2, person.getPerson_photo());
            preparedStatement.executeUpdate();
            preparedStatement.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void updatePerson(PersonForm person) {
		// TODO Auto-generated method stub
		try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update person set person_name=?, person_photo=?" + "where person_id=?");
            // Parameters start with 1
            preparedStatement.setString(1, person.getPerson_name());
            preparedStatement.setString(2, person.getPerson_photo());
            preparedStatement.setInt(3, person.getPerson_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	//抽奖页面显示
	public List<PersonForm> getPersonByAward() {
		 List list = new ArrayList();
			
	        try {
	        	PreparedStatement preparedStatement = connection
	                    .prepareStatement("select * from person where award!=0");
	        	ResultSet rs = preparedStatement.executeQuery();
			    while (rs.next()) {
			    	PersonForm person= new PersonForm();
				    person.setPerson_id(rs.getInt(1));
				    person.setPerson_name(rs.getString(2));
				    person.setPerson_photo(rs.getString(3));
				    person.setAward(rs.getInt(4));
				    person.setBw_flag(rs.getInt(5));
				    list.add(person);  
			    }
	           
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }

	        return list;
		}
	public List<PersonForm> selectPerson() {
		List<PersonForm> list = new ArrayList<PersonForm>();
	    PersonForm person = null;
	    
		try {
			ps=connection.prepareStatement("select * from person");
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
			    person = new PersonForm();
			    person.setPerson_id(rs.getInt(1));
			    person.setPerson_name(rs.getString(2));
			    person.setPerson_photo(rs.getString(3));
			    person.setAward(rs.getInt(4));
			    person.setBw_flag(rs.getInt(5));
			    list.add(person);
		    }
	    }   
		catch(SQLException ex){
		}					
		return list;				
	}
	public void delete() {		
		try {								    
		    PreparedStatement ps = connection.prepareStatement("update person set award = 0 ");
		    ps.executeUpdate();
	    }   
		catch(SQLException ex){
		}					
				
	}
	public List selectName(int number,int flag) {
		List Name=new ArrayList();						
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT person_name FROM  person WHERE person_id >= (SELECT FLOOR( MAX(person_id) * RAND()) FROM person )and bw_flag=0 and award=0 LIMIT ?");
			ps.setInt(1, number);		
		    ResultSet rs = ps.executeQuery();
		    PreparedStatement ps0 = connection.prepareStatement("update person set award = ? where person_name = ? ");
		    ps0.setInt(1, flag);
		    while (rs.next()) {	
		    	String name=null;
		    	name=rs.getString(1);
		    	ps0.setString(2, name);
			    ps0.executeUpdate();
			    Name.add(name);			    			   			   
		    }
		   		 
	    }   
		catch(SQLException ex){
		}		
		return Name;				
	}
	public List updateAward(int number) {
		List Name=new ArrayList();						
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT person_name FROM  person WHERE bw_flag =?  ");
			ps.setInt(1, number);		
		    ResultSet rs = ps.executeQuery();
		    PreparedStatement ps0 = connection.prepareStatement("update person set award = ? where person_name = ? ");
		    ps0.setInt(1, number);
		    while (rs.next()) {	
		    	String name=null;
		    	name=rs.getString(1);
		    	ps0.setString(2, name);
			    ps0.executeUpdate();
			    Name.add(name);			    			   			   
		    }
		   		 
	    }   
		catch(SQLException ex){
		}		
		return Name;				
	}
	
	
	
	
}
