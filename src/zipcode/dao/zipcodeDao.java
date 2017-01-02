package zipcode.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zipcode.dto.zipcodeDto;
import zipcode.util.jdbc;
import zipcode.util.zipcodeUtil;

public class zipcodeDao {
	private static final zipcodeDao instance = new zipcodeDao();

	public static zipcodeDao getInstance() {
		return instance;
	}
	private zipcodeDao(){}
	public List<zipcodeDto> selectInfoByAll(){
		List<zipcodeDto> list = new ArrayList<zipcodeDto>();
		zipcodeDto zip = null;
		String sql = "SELECT zipcode,sido,sigungu,doro,building1,building2 from zipcode.zipcode";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			pstmt = zipcodeUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()){
				list.add(getObject(rs));
			//	zip = new zipcodeDto(rs.getString("zipcode"), rs.getString("sido")
			//			, rs.getString("sigungu"), rs.getString("doro"), rs.getInt("building1"), rs.getInt("building2"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close(); 
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<zipcodeDto> selectInfoBycode(){
		List<zipcodeDto> List =  new ArrayList<zipcodeDto>();
		String sql = "SELECT zipcode,sido,sigungu,doro,building1,building2 from zipcode where zipcode=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = zipcodeUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				List.add(getObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close(); 
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return List;
	}
	public List<zipcodeDto> selectsido(){
		List<zipcodeDto> List =  new ArrayList<zipcodeDto>();
//		String sql = "SELECT zipcode,sido,sigungu,doro,building1,building2 from zipcode where zipcode=?";
		String sql = "SELECT DISTINCT sido from zipcode";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = zipcodeUtil.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				List.add(getObject(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close(); 
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return List;
	}
	
	
	
	public List<zipcodeDto> selectdoro() {
		List<zipcodeDto> List =  new ArrayList<zipcodeDto>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        try {
                 String sql = "SELECT DISTINCT doro from zipcode";
               //SELECT DISTINCT doro from zipcode;

                 pstmt = zipcodeUtil.getConnection().prepareStatement(sql);
     		   	 rs = pstmt.executeQuery();
                 while(rs.next()){
     				List.add(getObject(rs));

                         //zipcodeDto zipcode = new zipcodeDto();
                      //   zipcode.setDoro(rs.getString("GUGUN"));
                     //    List.add(zipcode);
                 }
        } catch (SQLException e) {
        }
                        
        return List;         
}
	
	
	
//	private zipcodeDto getObject(ResultSet rs) throws SQLException {
//		return new zipcodeDto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
//	}
	private zipcodeDto getObject(ResultSet rs) throws SQLException {
		return new zipcodeDto(rs.getString(1));
	}
}
