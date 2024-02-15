package com.LetsCodeIt.Secure.Bank.System;

import com.LetsCodeIt.Secure.Bank.System.Util.enums.SuggestionStatus;
import com.LetsCodeIt.Secure.Bank.System.entity.GuestEntity;
import com.LetsCodeIt.Secure.Bank.System.entity.UserEntity;
import com.LetsCodeIt.Secure.Bank.System.repository.GuestRepository;
import com.LetsCodeIt.Secure.Bank.System.repository.UserRepository;
import com.LetsCodeIt.Secure.Bank.System.service.UserService;
import com.LetsCodeIt.Secure.Bank.System.service.suggestions.SuggestionsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SecureBankSystemApplicationTests {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@MockBean
	private GuestRepository guestRepository;

	@Autowired
	private SuggestionsService suggestionsService;
@Test
	public void whenUsersPasswordIsLargerThan8Digit_thenSuccess(){
		UserEntity user1 = new UserEntity();
		user1.setName("othman");
		user1.setPassword("098765432");

		UserEntity user2 = new UserEntity();
		user2.setName("mubarak");
		user2.setPassword("098765432");

		UserEntity user3 = new UserEntity();
		user3.setName("thaer");
		user3.setPassword("0987");

		List<UserEntity> mockUsers = Arrays.asList(user1, user2, user3);

		Mockito.when(userRepository.findAll()).thenReturn(mockUsers);

		assertEquals(Arrays.asList("othman", "mubarak"), userService.getAllUsersWithStrongPassword());
	}

	@Test
	public void whenGetCreateStatusSuggestions_thenSuccess(){
		List<GuestEntity> suggestions = Arrays.asList(new GuestEntity("text", 5, SuggestionStatus.CREATE), new GuestEntity("text", 5, SuggestionStatus.CREATE), new GuestEntity("text", 5, SuggestionStatus.REMOVE), new GuestEntity("text", 5, SuggestionStatus.REMOVE), new GuestEntity("text", 5, SuggestionStatus.CREATE));
		Mockito.when(guestRepository.findAll()).thenReturn(suggestions);

		Assertions.assertEquals(Arrays.asList(new GuestEntity("text", 5, SuggestionStatus.CREATE).getStatus(), new GuestEntity("text", 5, SuggestionStatus.CREATE).getStatus(), new GuestEntity("text", 5, SuggestionStatus.CREATE).getStatus()), suggestionsService.findSuggestions("CREATE").stream().map(GuestEntity::getStatus).collect(Collectors.toList()));
	}

	@Test
	public void whenGetRemoveStatusSuggestions_thenSuccess(){
		List<GuestEntity> suggestions = Arrays.asList(new GuestEntity("text", 5, SuggestionStatus.CREATE), new GuestEntity("text", 5, SuggestionStatus.CREATE), new GuestEntity("text", 5, SuggestionStatus.REMOVE), new GuestEntity("text", 5, SuggestionStatus.REMOVE), new GuestEntity("text", 5, SuggestionStatus.CREATE));
		Mockito.when(guestRepository.findAll()).thenReturn(suggestions);

		Assertions.assertEquals(Arrays.asList(new GuestEntity("text", 5, SuggestionStatus.REMOVE).getStatus(), new GuestEntity("text", 5, SuggestionStatus.REMOVE).getStatus()), suggestionsService.findSuggestions("REMOVE").stream().map(GuestEntity::getStatus).collect(Collectors.toList()));
	}
}

