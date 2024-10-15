package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	@Autowired
	private PhonebookDao phonebookDao;

	/* 전체 가져오기 */
	public List<PersonVo> exeGetPersonList() {
		
		System.out.println("PhonebookService.exeGetPersonList()");

		List<PersonVo> personList = phonebookDao.getPersonList();

		return personList;
	}
	
	/* 삭제 */
	public int exePersonDelete(int no) {
		
		System.out.println("PhonebookService.exePersonDelete()");

		int count = phonebookDao.deletePerson(no);

		return count;

	}

}
