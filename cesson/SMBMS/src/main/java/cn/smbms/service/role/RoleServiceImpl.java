package cn.smbms.service.role;

import java.sql.Connection;
import java.util.List;
import cn.smbms.dao.BaseDao;
import cn.smbms.dao.role.RoleMapper;
import cn.smbms.dao.user.UserMapper;
import cn.smbms.tools.MyBatisUtil;
import cn.smbms.pojo.Role;
import org.apache.ibatis.session.SqlSession;

public class RoleServiceImpl implements RoleService{
	
	private RoleMapper roleMapper;
	private SqlSession session;
	
	@Override
	public List<Role> getRoleList() {
//		// TODO Auto-generated method stub
//		Connection connection = null;
//		List<Role> roleList = null;
//		try {
//			connection = BaseDao.getConnection();
//			roleList = roleDao.getRoleList(connection);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			BaseDao.closeResource(connection, null, null);
//		}
//		return roleList;
		session= MyBatisUtil.sqlSessionOpen();
		roleMapper =session.getMapper(RoleMapper.class);
		List<Role> list=roleMapper.getRoleList();
		if(session!=null){
			session.close();
		}
		return list;
	}
	
}
