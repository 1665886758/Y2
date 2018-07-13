package cn.smbms.dao.user;

import java.sql.Connection;
import java.util.List;
import cn.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	/**
	 * 增加用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int add(User user);

	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(@Param("userCode") String userCode,@Param("userPassword") String userPassword);

	/**
	 * 通过条件查询-userList
	 * @throws Exception
	 */
	public List<User> getUserList(@Param("userName") String userName,@Param("userRole") int userRole,@Param("currentPageNo") int currentPageNo,@Param("pageSize") int pageSize);

	/**
	 * 通过条件查询-用户表记录数
	 * @param userName
	 * @param userRole
	 * @return
	 * @throws Exception
	 */
	public int getUserCount(@Param("userName") String userName,@Param("userRole") int userRole);
	
	/**
	 * 通过userId删除user
	 * @param delId
	 * @return
	 * @throws Exception
	 */
	public int deleteUserById(@Param("id")Integer delId);
	
	
	/**
	 * 通过userId获取user
	 * @param connection
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getUserById(Connection connection, String id)throws Exception;
	
	/**
	 * 修改用户信息
	 * @param connection
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int modify(Connection connection, User user)throws Exception;
	
	
	/**
	 * 修改当前用户密码
	 * @param connection
	 * @param id
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public int updatePwd(Connection connection, int id, String pwd)throws Exception;
	
	
}
