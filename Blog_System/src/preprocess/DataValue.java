package preprocess;
/* 数据库的基本信息 */
public class DataValue {
		public String GetDataBaseValue_Url() {
			String url="jdbc:mysql://localhost:3306/users";
			return url;
		}
		public String GetDataBaseValue_loginName() {
			String loginName="root";
			return loginName;
		}
		public String GetDataBaseValue_loginPass() {
			String loginPass="root";
			return loginPass;
		}
}
