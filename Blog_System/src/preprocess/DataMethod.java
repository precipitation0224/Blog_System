package preprocess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataMethod {
	/* 数据库的连接逻辑 */
	public Connection DataConn() {
		try {
			//DataValue value = new DataValue();
			//Class.forName("com.mysql.jdbc.Driver");
			//String url=value.GetDataBaseValue_Url();
			//String loginName=value.GetDataBaseValue_loginName();
			//String loginPass=value.GetDataBaseValue_loginPass();
			//Connection conn=DriverManager.getConnection(url,loginName,loginPass);
			String url="jdbc:mysql://localhost:3306/users?user='root'&password='root'"; 
			Connection conn=DriverManager.getConnection(url);
			return conn;
		}catch(Exception error) {
			error.printStackTrace();
			return null;
		}	
	}
	/* 数据库成功登录的信息 */
	public boolean isSuccess(Connection conn, String userName, String password) throws SQLException {
		boolean flag;
		PreparedStatement stmt = conn.prepareStatement("select * from recording where username='peiqi' and password='123456'");
		//stmt.setString(1, userName);
		//stmt.setString(2, password);
		ResultSet rs=stmt.executeQuery();
		if(rs.next()){	
			flag=true;
		} else {
			flag=false;
		}
		rs.close();
		stmt.close();
		conn.close();
		return flag;
	}
	/* 数据是否存在目标行 */
	public boolean ifExist(Connection conn, String userName) throws SQLException {
		boolean flag;
		PreparedStatement stmt = conn.prepareStatement("select * from user where user_name=?");
		stmt.setString(1, userName);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			flag = true;
		} else {
			flag = false;
		}
		rs.close();
		stmt.close();
		conn.close();
		return flag;
	}
	/* 对注册用户进行新建 */
	public void Insert(Connection conn, String userName, String password, String email) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("insert into user(user_name,password,user_email) values(?,?,?)");
		stmt.setString(1, userName);
		stmt.setString(2, password);
		stmt.setString(3, email);
		stmt.executeUpdate();	
		stmt.close();
		conn.close();
	}
	/* 对密码进行修改 */
	public void Update(Connection conn, String userName, String password) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("update user set password=? where user_name=?");
		stmt.setString(2, userName);
		stmt.setString(1, password);
		stmt.executeUpdate();
		stmt.close();
		conn.close();
	}
}