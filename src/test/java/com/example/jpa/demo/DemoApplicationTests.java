package com.example.jpa.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.jpa.demo.springdatajpa.domain.User;
import com.example.jpa.demo.springdatajpa.repository.UserRepository;


import org.assertj.core.api.Assertions;
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void page() throws Exception {
		// given
		userRepository.save(new User("member1", 10));
		userRepository.save(new User("member2", 10));
		userRepository.save(new User("member3", 10));
		userRepository.save(new User("member4", 10));
		userRepository.save(new User("member5", 10));
		// when
		PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC,
				"username"));
		Page<User> page = userRepository.findByAge(10, pageRequest);
		// then
		List<User> content = page.getContent(); // 조회된 데이터
		Assertions.assertThat(content.size()).isEqualTo(3); // 조회된 데이터 수
		Assertions.assertThat(page.getTotalElements()).isEqualTo(5); // 전체 데이터 수
		Assertions.assertThat(page.getNumber()).isEqualTo(0); // 페이지 번호
		Assertions.assertThat(page.getTotalPages()).isEqualTo(2); // 전체 페이지 번호
		Assertions.assertThat(page.isFirst()).isTrue(); // 첫번째 항목인가?
		Assertions.assertThat(page.hasNext()).isTrue(); // 다음 페이지가 있는가?
	}
}
