package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PhonebookService;
import com.javaex.util.JsonResult;
import com.javaex.vo.PersonVo;

@RestController
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;

	/* 리스트 가져오기 */
	@GetMapping("/api/persons") 
	public JsonResult getList() {
		System.out.println("PhonebookController.getList()");

		List<PersonVo> personList = phonebookService.exeGetPersonList();
		System.out.println(personList);

		return JsonResult.success(personList);
	}

	/* 삭제 */
	@DeleteMapping("/api/persons/{no}")
	public JsonResult delPerson(@PathVariable(value = "no") int no) {
		System.out.println("PhonebookController.delPerson()");
		System.out.println(no);

		int count = phonebookService.exePersonDelete(no);

		if (count != 1) { // 삭제 실패
			return JsonResult.fail("해당번호가 없습니다");
		} else { // 삭제 성공
			return JsonResult.success(count);
		}
	}

}
