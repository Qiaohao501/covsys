package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*���ݿ��������*/
public class BaseDao {
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public boolean getConnection(){
		try {
//			���ز�ͬ���ݿ⳧���ṩ������
			//Class.forName(ConfigerManager.getInstance().getString("jdbc.driver"));
//			��1����·����ȡ����Connection��
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/precov";
			String username = "root";
			String password = "123456";
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// ��ɾ��
	public int executeUpdate(String sql,Object[] params){
		int updateRows = 0;
		if(this.getConnection()){
			try {
				pstmt = connection.prepareStatement(sql);
				//���ռλ��
				for(int i= 0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
				updateRows = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return updateRows;
	}
	
	
	//��
	public ResultSet executeSQL(String sql,Object[] params){
		if(this.getConnection()){
			try {
				pstmt = connection.prepareStatement(sql);
				//���ռλ��
				for(int i= 0;i<params.length;i++){
					pstmt.setObject(i+1, params[i]);
				}
				rs = pstmt.executeQuery();
				//System.out.print("adadadfaf");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	// �ͷ���Դ(ע���ͷ���Դ��˳��)
	public boolean closeResource(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
