package com.fj;

import com.fj.mapper.BookMapper;
import com.fj.entity.Book;
import com.fj.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class BookTest {

    /**
     * 查询
     */
    @Test
    public void selectAll() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.sqlSessionOpen();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            List<Book> list = bookMapper.getBookListInfo();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 删除
     */
    @Test
    public void deleteBookById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.sqlSessionOpen();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            int count = bookMapper.delBookById(1);
            System.out.println("操作行数:" + count);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 修改
     */
    @Test
    public void upBookInfoById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.sqlSessionOpen();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            Book book = new Book();
            book.setId(2);
            book.setName("哈哈");
            int count = bookMapper.upBookInfoById(book);
            System.out.println("操作行数:" + count);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 新增
     */
    @Test
    public void addBookInfo() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.sqlSessionOpen();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            Book book = new Book();
            book.setName("JAVASCRIPT");
            book.setISBN("55442-232");
            book.setPrice(100);
            book.setDiscount(20);
            book.setPublisher("北大青鸟");
            int count = bookMapper.addBookInfo(book);
            System.out.println("操作行数:" + count);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    /**
     * 条件查询
     */
    @Test
    public void sel1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.sqlSessionOpen();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            Book b = new Book();
            b.setName("java");
            List<Book> students = bookMapper.selectBookInfoById(b);
            System.out.println(students);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 新增
     */
    @Test
    public void add2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.sqlSessionOpen();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            Book b = new Book();
            b.setName("jsp");
            int result = bookMapper.addBook(b);
            System.out.println("操作数" + result);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * 修改
     */
    @Test
    public void up2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.sqlSessionOpen();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            Book b = new Book();
            b.setName("jsp2");
            b.setId(1);
            if (b.getId() == null) {
                return;
            }
            int result = bookMapper.upBook(b);
            System.out.println("操作数" + result);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    /**
     * one to n
     */
    @Test
    public void oneToN() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.sqlSessionOpen();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            List<Book> list = bookMapper.getBookInfo(2);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    /**
     * n to one
     */
    @Test
    public void nToOne() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtil.sqlSessionOpen();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            List<Book> list=bookMapper.getBookInfo2(2,3);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


}