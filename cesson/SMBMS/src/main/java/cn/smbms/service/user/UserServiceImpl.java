package cn.smbms.service.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.smbms.dao.BaseDao;
import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.User;
import cn.smbms.tools.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{
	
	private UserMapper userMapper;
	private SqlSession session;
	//打开连接
	@Override
	public boolean add(User user) {
//		// TODO Auto-generated method stub
//
//		boolean flag = false;
//		Connection connection = null;
//		try {
//			connection = BaseDao.getConnection();
//			connection.setAutoCommit(false);//开启JDBC事务管理
//			int updateRows = userMapper.add(user);
//			connection.commit();
//			if(updateRows > 0){
//				flag = true;
//				System.out.println("add success!");
//			}else{
//				System.out.println("add failed!");
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			try {
//				System.out.println("rollback==================");
//				connection.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		}finally{
//			//在service层进行connection连接的关闭
//			BaseDao.closeResource(connection, null, null);
//		}
//		return flag;
		session= MyBatisUtil.sqlSessionOpen();
		userMapper =session.getMapper(UserMapper.class);
		boolean flag=false;
		try{
			int count=userMapper.add(user);
			if(count==1){
				flag=true;
			}
			session.commit();
		}catch (Exception e){
			e.printStackTrace();
			flag=false;
			session.rollback();
		}finally {
			if(session!=null){
				session.close();
			}
		}
		return flag;
	}

	/**
	 * 登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	//登录
	@Override
	public User login(String userCode,String userPassword) {
		// TODO Auto-generated method stub
//		Connection connection = null;
//		User user = null;
//		try {
//			connection = BaseDao.getConnection();
//			user = userMapper.getLoginUser(connection, userCode);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
//
//		//匹配密码
//		if(null != user){
//			if(!user.getUserPassword().equals(userPassword))
//				user = null;
//		}
//
//		return user;
		session= MyBatisUtil.sqlSessionOpen();
		userMapper =session.getMapper(UserMapper.class);
		User user=userMapper.getLoginUser(userCode,userPassword);
		if(session!=null){
			session.close();
		}
		return user;
	}
	//信息列表
	@Override
	public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo, int pageSize) {
//		// TODO Auto-generated method stub
//		Connection connection = null;
//		List<User> userList = null;
//		System.out.println("queryUserName ---- > " + queryUserName);
//		System.out.println("queryUserRole ---- > " + queryUserRole);
//		System.out.println("currentPageNo ---- > " + currentPageNo);
//		System.out.println("pageSize ---- > " + pageSize);
//		try {
//			connection = BaseDao.getConnection();
//			userList = userMapper.getUserList(queryUserName,queryUserRole,currentPageNo,pageSize);
//		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
//		return userList;
		session= MyBatisUtil.sqlSessionOpen();
		userMapper =session.getMapper(UserMapper.class);
		List<User> list= userMapper.getUserList(queryUserName,queryUserRole,(currentPageNo-1)*pageSize,pageSize);
		if(session!=null){
			session.close();
		}
		return  list;
	}
	@Override
	public User selectUserCodeExist(String userCode) {
//		// TODO Auto-generated method stub
//		Connection connection = null;
//		User user = null;
//		try {
//			connection = BaseDao.getConnection();
//			user = userMapper.getLoginUser(connection, userCode);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
//		return user;
		return null;
	}
	@Override
	public boolean deleteUserById(Integer delId) {
//		// TODO Auto-generated method stub
//		Connection connection = null;
//		boolean flag = false;
//		try {
//			connection = BaseDao.getConnection();
//			if(userMapper.deleteUserById(connection,delId) > 0)
//				flag = true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
//		return flag;
		session= MyBatisUtil.sqlSessionOpen();
		userMapper =session.getMapper(UserMapper.class);
		boolean flag=false;
		try{
			int count=userMapper.deleteUserById(delId);
			if(count==1){
				flag=true;
			}
			session.commit();
		}catch (Exception e){
			e.printStackTrace();
			flag=false;
			session.rollback();
		}finally {
			if(session!=null){
				session.close();
			}
		}
		return flag;
	}
	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		User user = null;
		Connection connection = null;
		try{
			connection = BaseDao.getConnection();
			user = userMapper.getUserById(connection,id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			user = null;
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return user;
	}
	@Override
	public boolean modify(User user) {
		// TODO Auto-generated method stub
		Connection connection = null;
		boolean flag = false;
		try {
			connection = BaseDao.getConnection();
			if(userMapper.modify(connection,user) > 0)
				flag = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return flag;
	}
	@Override
	public boolean updatePwd(int id, String pwd) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Connection connection = null;
		try{
			connection = BaseDao.getConnection();
			if(userMapper.updatePwd(connection,id,pwd) > 0)
				flag = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return flag;
	}
	//列表记录数
	@Override
	public int getUserCount(String queryUserName, int queryUserRole) {
//		// TODO Auto-generated method stub
//		Connection connection = null;
//		int count = 0;
//		System.out.println("queryUserName ---- > " + queryUserName);
//		System.out.println("queryUserRole ---- > " + queryUserRole);
//		try {
//			connection = BaseDao.getConnection();
//			count = userMapper.getUserCount(connection, queryUserName,queryUserRole);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
//		return count;
		session= MyBatisUtil.sqlSessionOpen();
		userMapper =session.getMapper(UserMapper.class);
		int count=userMapper.getUserCount(queryUserName,queryUserRole);
		if(session!=null){
			session.close();
		}
		return  count;
	}
	
}
