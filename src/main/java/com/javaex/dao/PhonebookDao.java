package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	// 필드
	@Autowired
	private SqlSession sqlSession;

	/* 전체 가져오기 */
	public List<PersonVo> getPersonList() {

		System.out.println("PhonebookDao.getPersonList()");
		List<PersonVo> personList = sqlSession.selectList("phoneList.selectList");

		return personList;
	}
	
	/* 삭제 */
	public int deletePerson(int no) {

		int count = sqlSession.delete("phoneList.delete", no);

		return count;
	}

}
