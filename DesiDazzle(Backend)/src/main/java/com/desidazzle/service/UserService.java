package com.desidazzle.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidazzle.controller.model.LoginBody;
import com.desidazzle.controller.model.PasswordResetBody;
import com.desidazzle.controller.model.RegistrationBody;
import com.desidazzle.exception.EmailFailureException;
import com.desidazzle.exception.EmailNotFoundException;
import com.desidazzle.exception.UserAlreadyExistsException;
import com.desidazzle.exception.UserNotVerifiedException;
import com.desidazzle.model.Customer;
import com.desidazzle.repository.CustomerRepo;

@Service
public class UserService implements IUserService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private EncryptionService encryptionService;

	@Autowired
	private JWTService jwtService;

	/** if Exception of duplicate bean remove this. */
	public UserService(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	/**
	 * @param registrationBody
	 * @return
	 * @throws UserAlreadyExistsException
	 * @throws EmailFailureException
	 */
	@Override
	public Customer registerUser(RegistrationBody registrationBody)
			throws UserAlreadyExistsException, EmailFailureException {

		if (customerRepo.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException("Email is already registered.");
		} else if (customerRepo.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
			throw new UserAlreadyExistsException("username is already registered.");
		}
		Customer cust = new Customer();
		cust.setEmail(registrationBody.getEmail());
		cust.setFirstName(registrationBody.getFirstName());
		cust.setLastName(registrationBody.getLastName());
		cust.setUsername(registrationBody.getUsername());

		// TODO: Encrypt password!! -> done
		cust.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));
		return customerRepo.save(cust);
	}

	/**
	 * @param loginBody
	 * @return
	 * @throws UserNotVerifiedException
	 * @throws EmailFailureException
	 */
	@Override
	public String loginUser(LoginBody loginBody) throws UserNotVerifiedException, EmailFailureException {
		Optional<Customer> optUser = customerRepo.findByUsernameIgnoreCase(loginBody.getUsername());
		if (optUser.isPresent()) {
			Customer cust = optUser.get();
			if (encryptionService.verifyPassword(loginBody.getPassword(), cust.getPassword())) {
				return jwtService.generateJWT(cust);
			}
		}
		return null;
	}

	/**
	 * @param token
	 * @return
	 */
	@Override
	public boolean verifyUser(String token) {
		return false;
	}

	/**
	 * @param email
	 * @throws EmailNotFoundException
	 * @throws EmailFailureException
	 */
	@Override
	public void forgotPassword(String email) throws EmailNotFoundException, EmailFailureException {

	}

	/**
	 * @param body
	 */
	@Override
	public void resetPassword(PasswordResetBody body) {

	}

	/**
	 * @param user
	 * @param id
	 * @return
	 */
	@Override
	public boolean userHasPermissionToUser(Customer user, Long id) {
		return false;
	}
}
