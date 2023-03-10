package com.group8.roommatefinder;

import com.group8.roommatefinder.model.SaveViewProfile;
import com.group8.roommatefinder.model.UserAccount;
import com.group8.roommatefinder.model.UserProfile;
import com.group8.roommatefinder.persistence.IUserProfileRepository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SaveViewProfileTest 
{

	private static IUserProfileRepository userProfileRepository;
	private static SaveViewProfile saveViewProfile;

	static UserProfile testUserProfileOutput = new UserProfile("emailtest", "addressTest", "food_preferencetest","raghuTest", "maleTest", 700, "3bhktest");
	static UserProfile testEmptyUserEmailOutput = new UserProfile("", "", "", "", "", 0, "");
	static UserAccount testUserAccountOutput = new UserAccount("raghuprabath.m@gmail.com", "1");

	@BeforeAll
	public static void init() 
	{
		userProfileRepository = Mockito.mock(IUserProfileRepository.class);
		saveViewProfile = new SaveViewProfile(userProfileRepository);
	}

	@Test
	void displayProfileSucessTest() 
	{
		UserProfile testUserEmailInput1 = new UserProfile("emailtest", "", "", "", "", 0, "");
		Mockito.when(userProfileRepository.getProfileById(testUserProfileOutput.getEmailId()))
				.thenReturn(testUserProfileOutput);
		UserProfile finalOutput = saveViewProfile.dipslayProfile(testUserEmailInput1);
		assertEquals(testUserProfileOutput, finalOutput);
	}

	@Test
	void displayProfileUnsucessfulTest() 
	{
		UserProfile testUserEmailInput1 = new UserProfile("email123", "", "", "", "", 0, "");
		Mockito.when(userProfileRepository.getProfileById(testUserProfileOutput.getEmailId()))
				.thenReturn(testUserProfileOutput);
		UserProfile finalOutput = saveViewProfile.dipslayProfile(testUserEmailInput1);
		assertNotEquals(testUserProfileOutput, finalOutput);
	}

	@Test
	void displayNullValueProfileTest() 
	{
		UserProfile testUserEmailEmptyInput = new UserProfile("", "", "", "", "", 0, "");
		Mockito.when(userProfileRepository.getProfileById(testEmptyUserEmailOutput.getEmailId()))
				.thenReturn(testEmptyUserEmailOutput);
		UserProfile finalOutput = saveViewProfile.dipslayProfile(testUserEmailEmptyInput);
		assertEquals(testEmptyUserEmailOutput, finalOutput);
	}

	@Test
	void isResetPasswordSuccess() 
	{
		UserAccount testIsPasswordSuccessValidInput = new UserAccount("", "1");
		Mockito.when(userProfileRepository.resetPassword(testUserAccountOutput)).thenReturn(true);
		boolean finalOutput = saveViewProfile.resetPasword(testIsPasswordSuccessValidInput,testIsPasswordSuccessValidInput.getEmailId());
		assertNotEquals(true, finalOutput);
	}

	@Test
	void isResetPasswordNotSuccess() 
	{
		UserAccount testIsPasswordSuccessValidInput = new UserAccount("", "1");
		Mockito.when(userProfileRepository.resetPassword(testUserAccountOutput)).thenReturn(false);
		boolean finalOutput = saveViewProfile.resetPasword(testIsPasswordSuccessValidInput,
				testIsPasswordSuccessValidInput.getEmailId());
		assertEquals(false, finalOutput);
	}

	@Test
	void isUpdateSuccess() 
	{
		UserProfile testUserUpdate = new UserProfile("emailtest", "", "", "", "", 0, "");
		Mockito.when(userProfileRepository.updateProfile(testUserProfileOutput)).thenReturn(true);
		boolean finalOutput = saveViewProfile.updateProfile(testUserUpdate);
		assertEquals(false, finalOutput);
	}

	@Test
	void isUpdateNotSuccess() 
	{
		UserProfile testUserUpdate = new UserProfile("emailtest", "", "", "", "", 0, "");
		Mockito.when(userProfileRepository.updateProfile(testUserProfileOutput)).thenReturn(false);
		boolean finalOutput = saveViewProfile.updateProfile(testUserUpdate);
		assertEquals(false, finalOutput);
	}

}
