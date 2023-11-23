package hu.unideb.inf.zootrekker.service;

import hu.unideb.inf.zootrekker.entity.Auth;
import hu.unideb.inf.zootrekker.entity.Auth;
import hu.unideb.inf.zootrekker.entity.Auth;
import hu.unideb.inf.zootrekker.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AuthServiceImplementation implements AuthService{

    @Autowired
    private AuthRepository authRepository;

    @Override
    public Auth saveAuth(Auth auth) {
        return authRepository.save(auth);
    }

    @Override
    public Auth getAuthById(Long authId) {
        if (authRepository.findById(authId).isPresent()) {
            return authRepository.findById(authId).get();
        }
        return null;
    }

    @Override
    public List<Auth> getAllAuths() {
        return (List<Auth>) authRepository.findAll();
    }

    @Override
    public Auth updateAuth(Auth auth, Long authId) {
        Auth ujAuth = authRepository.findById(authId).get();

        if (Objects.nonNull(auth.getUsername()) && !"".equalsIgnoreCase(auth.getUsername())) {
            ujAuth.setUsername(auth.getUsername());
        }
        if (Objects.nonNull(auth.getPassword()) && !"".equalsIgnoreCase(auth.getPassword())) {
            ujAuth.setPassword(auth.getPassword());
        }
        if (Objects.nonNull(auth.getLastLogin())){
            ujAuth.setLastLogin(auth.getLastLogin());
        }
        
        return authRepository.save(ujAuth);
    }

    @Override
    public void deleteAuthById(Long authId) {
        authRepository.deleteById(authId);
    }
}
