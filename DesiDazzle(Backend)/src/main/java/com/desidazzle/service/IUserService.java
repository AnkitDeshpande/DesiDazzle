package com.desidazzle.service;

import com.desidazzle.controller.model.LoginBody;
import com.desidazzle.controller.model.PasswordResetBody;
import com.desidazzle.controller.model.RegistrationBody;
import com.desidazzle.exception.EmailFailureException;
import com.desidazzle.exception.EmailNotFoundException;
import com.desidazzle.exception.UserAlreadyExistsException;
import com.desidazzle.exception.UserNotVerifiedException;
import com.desidazzle.model.Customer;

/**
 * Interface defining user-related operations.
 */
public interface IUserService {

	/**
	 * Registers a new customer with the provided registration information.
	 *
	 * @param registrationBody The registration information for the new customer.
	 * @return The newly registered customer.
	 * @throws UserAlreadyExistsException If a user with the given information
	 *                                    already exists.
	 * @throws EmailFailureException      If there is an issue with sending the
	 *                                    email during registration.
	 */
	Customer registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException, EmailFailureException;

	/**
	 * Logs in a user using the provided login credentials and returns an
	 * authentication token.
	 *
	 * @param loginBody The login credentials.
	 * @return The authentication token upon successful login.
	 * @throws UserNotVerifiedException If the user's email is not verified.
	 * @throws EmailFailureException    If there is an issue with sending the email.
	 */
	String loginUser(LoginBody loginBody) throws UserNotVerifiedException, EmailFailureException;

	/**
	 * Verifies the validity of a user's token.
	 *
	 * @param token The token to verify.
	 * @return True if the token is valid and the user is verified, false otherwise.
	 */
	boolean verifyUser(String token);

	/**
	 * Initiates the password recovery process by sending a reset link to the user's
	 * email.
	 *
	 * @param email The email address of the user.
	 * @throws EmailNotFoundException If the provided email address is not
	 *                                associated with any user.
	 * @throws EmailFailureException  If there is an issue with sending the email.
	 */
	void forgotPassword(String email) throws EmailNotFoundException, EmailFailureException;

	/**
	 * Resets the user's password based on the provided password reset information.
	 *
	 * @param body The password reset information.
	 */
	void resetPassword(PasswordResetBody body);

	/**
	 * Checks whether the authenticated customer has permission to access a user's
	 * data.
	 *
	 * @param user The authenticated customer.
	 * @param id   The ID of the user's data.
	 * @return True if the customer has permission, false otherwise.
	 */
	boolean userHasPermissionToUser(Customer user, Long id);
}
