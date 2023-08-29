package com.desidazzle.service;

import com.desidazzle.controller.model.LoginBody;
import com.desidazzle.controller.model.PasswordResetBody;
import com.desidazzle.controller.model.RegistrationBody;
import com.desidazzle.exception.EmailFailureException;
import com.desidazzle.exception.EmailNotFoundException;
import com.desidazzle.exception.UserAlreadyExistsException;
import com.desidazzle.exception.UserNotVerifiedException;
import com.desidazzle.model.Customer;

public interface IUserService {
    /**
     *
     * @param registrationBody
     * @return
     * @throws UserAlreadyExistsException
     * @throws EmailFailureException
     */
    Customer registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException, EmailFailureException;

    /**
     *
     * @param loginBody
     * @return
     * @throws UserNotVerifiedException
     * @throws EmailFailureException
     */
    String loginUser(LoginBody loginBody) throws UserNotVerifiedException, EmailFailureException;

    /**
     *
     * @param token
     * @return boolean true/false if user is correct
     */
    boolean verifyUser(String token);

    /**
     *
     * @param email
     * @throws EmailNotFoundException
     * @throws EmailFailureException
     */
    void forgotPassword(String email) throws EmailNotFoundException, EmailFailureException;

    /**
     *
     * @param body
     */
    void resetPassword(PasswordResetBody body);

    /**
     *
     * @param user
     * @param id
     */
    boolean userHasPermissionToUser(Customer user, Long id);

}
