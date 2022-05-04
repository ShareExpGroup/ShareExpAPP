package com.shareExp.backend.controller;

import com.shareExp.backend.enumeration.Role;
import com.shareExp.backend.model.ShareExpClient;
import com.shareExp.backend.model.SuperUser;
import com.shareExp.backend.model.User;
import com.shareExp.backend.security.JwtChangePassword;
import com.shareExp.backend.security.JwtProperties;
import com.shareExp.backend.service.ClientService;
import com.shareExp.backend.service.SuperUserService;
import com.shareExp.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/account")
public class UserController {

    ClientService clientService;
    SuperUserService superUserService;
    UserService userService;

    public UserController( ClientService clientService,
                          SuperUserService superUserService, UserService userService) {

        this.clientService = clientService;
        this.superUserService = superUserService;
        this.userService = userService;
    }

    // create users:



    @PostMapping(path = "/create/client",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShareExpClient> createClient(@RequestBody ShareExpClient client) throws Throwable {
        client.setRole(Role.CLIENT);
        return new ResponseEntity<>(
                clientService.createUser(client),
                HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/create/superuser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuperUser> createSuperUser(@RequestBody SuperUser superUser) throws Throwable {
        superUser.setRole(Role.SUPERUSER);
        return new ResponseEntity<>(
                superUserService.createUser(superUser),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/list/client/all")
    public ResponseEntity<List<ShareExpClient>> listAllClients(){
        return new ResponseEntity<>(
                clientService.getAllUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/list/superuser/all")
    public ResponseEntity<List<SuperUser>> listAllSuperUsers(){
        return new ResponseEntity<>(
                superUserService.getAllUsers(),
                HttpStatus.OK
        );
    }

    // delete users:

    @DeleteMapping(path = "/delete/ByEmail")
    public ResponseEntity<Void> deleteUserByEmail(@RequestHeader String email) {
        userService.deleteUserWithEmail(email);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete/ById/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable long id) {
        userService.deleteUserWithId(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteCurrentUser(@RequestHeader("Authorization") String jwtToken) {
        if (jwtToken == null || !jwtToken.startsWith(JwtProperties.TOKEN_PREFIX)){
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                userService.deleteUserWithToken(jwtToken)
        );
    }

    @PutMapping(path = "/changePassword")
    public ResponseEntity<User> changePassword(@RequestBody JwtChangePassword jwtChangePassword,
                                               @RequestHeader("Authorization") String jwtToken) {
        return new ResponseEntity<>(
                userService.changePassword(jwtToken, jwtChangePassword)
        );
    }
}
