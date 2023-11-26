package hu.unideb.inf.zootrekker.controller;

import hu.unideb.inf.zootrekker.entity.Auth;
import hu.unideb.inf.zootrekker.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/auths")
public class AuthController {
    @Autowired private AuthService authService;
    @PostMapping("/add")
    public Auth saveAuth(@RequestBody Auth auth)
    {
        return authService.saveAuth(auth);
    }

    @GetMapping("/get/{id}")
    public Auth getAuthById(@PathVariable("id") Long authId) {
        return authService.getAuthById(authId);
    }

    @GetMapping("/getall")
    public List<Auth> getAllAuths()
    {
        return authService.getAllAuths();
    }

    @PutMapping("/update/{id}")
    public Auth updateAuth(@RequestBody Auth auth, @PathVariable("id") Long authId)
    {
        return authService.updateAuth(auth, authId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthById(@PathVariable("id") Long authId)
    {
        authService.deleteAuthById(authId);
        return "Deleted Successfully!";
    }
}