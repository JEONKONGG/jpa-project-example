package com.example.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jpa.entity.Users;
import com.example.jpa.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public List<Users> getUsersService(String name){
		if(name.isBlank()) 	// name 파라미터가 null 이면 전체 user 리턴
			return userRepository.findAll();
		else				// name 이 존재하면 Like 쿼리로 2개만 리턴
			return userRepository.findFirst2ByUsernameLikeOrderByIDDesc(name);
	}
	
	public String createUserService(Users user) {
		userRepository.save(user);		// User Insert 쿼리 수행
		return "등록 완료";
	}
}
