package com.springStudy1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springStudy1.DAO.SchoolDAO;
import com.springStudy1.DTO.School;

@Service
public class SchoolService {
	
	private final SchoolDAO schoolDao;
	
	@Autowired //  자동 주입 - SchoolService 객체 가 생성되면 SchoolDAO객체생성하여 주입
	public SchoolService(SchoolDAO schoolDao) {
		this.schoolDao=schoolDao; //약한결합 
	}
	
	public List<School> typeSelect(String type){
		return schoolDao.findAllByType(type);
		// 이 메서드의 역할은 controller 클래스가  유치워느 초등학교, 중학교 등의 요청이 들어올경우
		// controller의 의해서 실행 되어야 하는 메서드이다.
		// service 클래스는  controller 클래스의 클라이언트 요청 처리를 실행 하기 위한 클래스
		//  DAO와 controller 사이에서 전달자의 역할을 하기 도 한다.
		// controller에서 직접 DAO를 호출하는 방식을 쓰기도 하지만 service를 통해 받는걸 권장
		
	}
}



