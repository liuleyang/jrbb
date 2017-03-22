package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




import actionForm.PrizeForm;
import util.DbUtil;

public class PrizeDao {

    private Connection connection;

    public PrizeDao() {
        connection = DbUtil.getConnection();
    }

    public void addPrize(PrizeForm prize) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into prize(grade,name,picture,quantity) values (?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setString(1, prize.getGrade());
            preparedStatement.setString(2, prize.getName());
            preparedStatement.setString(3, prize.getPicPath());
            preparedStatement.setInt(4, prize.getQuantity());
            preparedStatement.executeUpdate();
            preparedStatement.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePrize(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from prize where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePrize(PrizeForm prize) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update prize set grade=?, name=?, quantity=?, picture=?" + "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, prize.getGrade());
            preparedStatement.setString(2, prize.getName());
            preparedStatement.setInt(3, prize.getQuantity());
            preparedStatement.setString(4, prize.getPicPath());
            preparedStatement.setInt(5, prize.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PrizeForm> getAllPrizes() {//抽奖页面共用
        List<PrizeForm> prizes = new ArrayList<PrizeForm>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from prize");
            while (rs.next()) {
                PrizeForm prize = new PrizeForm();
                prize.setGrade(rs.getString("grade"));
                prize.setName(rs.getString("name"));
                prize.setQuantity(rs.getInt("quantity"));
                prize.setPicPath(rs.getString("picture"));
                prize.setId(rs.getInt("id"));
                prizes.add(prize);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prizes;
    }
    
    public PrizeForm getPrizeById(int id) {
        PrizeForm prize = new PrizeForm();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from prize where id=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                prize.setGrade(rs.getString("grade"));
                prize.setName(rs.getString("name"));
                prize.setQuantity(rs.getInt("quantity"));
                prize.setId(rs.getInt("id"));
                prize.setPicPath(rs.getString("picture").substring(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prize;
    }
    //抽奖页面部分
    public List<PrizeForm> selectPrize(int id) {
		List<PrizeForm> list = new ArrayList<PrizeForm>();
		PrizeForm prize = null;
		try {
			PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from prize where id = ?");
			preparedStatement.setInt(1, id);
		    ResultSet rs = preparedStatement.executeQuery();
		    while (rs.next()) {
		    	prize = new PrizeForm();
		    	prize.setId(rs.getInt(1));
			    prize.setGrade(rs.getString(2));
			    prize.setName(rs.getString(3));
			    prize.setPicPath(rs.getString(4));
			    prize.setQuantity(rs.getInt(5));
			    list.add(prize);
		    }
	    }   
		catch(SQLException ex){
		}
		
		return list;
	}
	
		
	
}
