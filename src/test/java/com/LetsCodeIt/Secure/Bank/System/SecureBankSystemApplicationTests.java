package com.LetsCodeIt.Secure.Bank.System;

import com.LetsCodeIt.Secure.Bank.System.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class SecureBankSystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	private UserRepository userRepository;

	public void whenUsersPasswordIsLargerThan8Digit_thenSuccess(){

	}

}
