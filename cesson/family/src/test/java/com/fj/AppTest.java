package com.fj;

import static org.junit.Assert.assertTrue;

import com.fj.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.fj.mapper.famyMapper;
import com.fj.entity.husband;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        SqlSession sqlSession=null;
       try{
           sqlSession= MyBatisUtil.sqlSessionOpen();
           husband husband=sqlSession.getMapper(famyMapper.class).selectByPrimaryKey(1);
           System.out.println(husband);
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           sqlSession.close();
       }
    }

    @Test
    public void shouldAnswerWithTrue2()
    {
        SqlSession sqlSession=null;
        try{
            sqlSession= MyBatisUtil.sqlSessionOpen();
            husband husband=sqlSession.getMapper(famyMapper.class).selectByPrimaryKey2(2);
            System.out.println(husband);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

//    @Test
//    public void shouldAnswerWithTrue3()
//    {
//        SqlSession sqlSession=null;
//        try{
//            sqlSession= MyBatisUtil.sqlSessionOpen();
//            husband husband=sqlSession.getMapper(famyMapper.class).selectByPrimaryKey3(1);
//            System.out.println(husband);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            sqlSession.close();
//        }
//    }
}
