package com.example.jpatutorials.dao;

/**
 * 手动操作数据库
 */
public interface TestDao {

  void testTransactionManually(boolean throwEx);

  void testJdbcTemplate();
}
