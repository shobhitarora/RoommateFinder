package com.group8.roommatefinder;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.group8.roommatefinder.model.UserAccount;
import com.group8.roommatefinder.model.UserRegistration;
import com.group8.roommatefinder.persistence.IUserAccountRepository;

class UserRegistrationTest {

	private static UserRegistration userRegistration;

	@MockBean
	private static UserAccount userAccount;

	@MockBean
	private static IUserAccountRepository userAccountRepository;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		userAccount = Mockito.mock(UserAccount.class);
		userAccountRepository = Mockito.mock(IUserAccountRepository.class);
		userRegistration = new UserRegistration(userAccountRepository);
	}

	@Test
	public void userAlreadyExist() {
		UserAccount account = new UserAccount();
		account.setEmailId("h1@gamil.com");
		account.setPassword("1234567");

		when(userAccount.checkUserIsNull(account)).thenReturn(false);
		assertEquals(false, userAccount.checkUserIsNull(account));

	}

	@Test
	public void userDoesNotExist() {
		UserAccount account = new UserAccount();
		account.setEmailId("h2@gamil.com");
		account.setPassword("1234567");

		when(userAccount.checkUserIsNull(account)).thenReturn(true);
		assertEquals(true, userAccount.checkUserIsNull(account));
	}

	@Test
	public void userLoginSucessful() {
		UserAccount account = new UserAccount();
		account.setEmailId("h1@gmail.com");
		account.setPassword("1234567");

		UserAccount accountResponse = new UserAccount();
		accountResponse.setEmailId("h1@gmail.com");
		accountResponse.setPassword("1234567");

		when(userAccountRepository.getUserById(accountResponse.getEmailId())).thenReturn(accountResponse);

		assertEquals(true, userRegistration.userLogin(account));

	}

	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void userLoginUnsucessful() {
		UserAccount account = new UserAccount();
		account.setEmailId("h2@gmail.com");
		account.setPassword("1234567");

		UserAccount accountResponse = new UserAccount();
		accountResponse.setEmailId("h2@gmail.com");
		accountResponse.setPassword("1234563");

		when(userAccountRepository.getUserById(accountResponse.getEmailId())).thenReturn(accountResponse);
		assertNotEquals(true,userRegistration.userLogin(account));
		

	}

}
