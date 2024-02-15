package com.LetsCodeIt.Secure.Bank.System.service.auth;

import com.LetsCodeIt.Secure.Bank.System.bo.auth.AuthenticationResponse;
import com.LetsCodeIt.Secure.Bank.System.bo.auth.CreateLoginRequest;
import com.LetsCodeIt.Secure.Bank.System.bo.auth.CreateSignupRequest;
import com.LetsCodeIt.Secure.Bank.System.bo.auth.LogoutResponse;

public interface AuthService {
    void signup(CreateSignupRequest createSignupRequest);

    AuthenticationResponse login(CreateLoginRequest createLoginRequest);

    void logout(LogoutResponse logoutResponse);
}
