package com.desidazzle.service;

import com.desidazzle.controller.model.LoginBody;
import com.desidazzle.controller.model.PasswordResetBody;
import com.desidazzle.controller.model.RegistrationBody;
import com.desidazzle.exception.EmailFailureException;
import com.desidazzle.exception.EmailNotFoundException;
import com.desidazzle.exception.UserAlreadyExistsException;
import com.desidazzle.exception.UserNotVerifiedException;
import com.desidazzle.model.Customer;

public class UserService implements IUserService{
    /**
     * @param registrationBody
     * @return
     * @throws UserAlreadyExistsException
     * @throws EmailFailureException
     */
    @Override
    public Customer registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException, EmailFailureException {
        return null;
    }

    /**
     * @param loginBody
     * @return
     * @throws UserNotVerifiedException
     * @throws EmailFailureException
     */
    @Override
    public String loginUser(LoginBody loginBody) throws UserNotVerifiedException, EmailFailureException {
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
