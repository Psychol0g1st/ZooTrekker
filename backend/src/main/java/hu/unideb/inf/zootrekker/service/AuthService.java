package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Auth;

import java.util.List;

public interface AuthService {
    // Save auth
    Auth saveAuth(Auth Auth);

    // Read operation
    Auth getAuthById(Long authId);
    List<Auth> getAllAuths();

    // Update operation
    Auth updateAuth(Auth Auth, Long AuthId);

    // Delete operation
    void deleteAuthById(Long AuthId);
}
