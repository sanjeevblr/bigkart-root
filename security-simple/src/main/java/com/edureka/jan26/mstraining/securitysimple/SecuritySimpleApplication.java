package com.edureka.jan26.mstraining.securitysimple;

import com.edureka.jan26.mstraining.securitysimple.model.UserAccount;
import com.edureka.jan26.mstraining.securitysimple.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class SecuritySimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuritySimpleApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserAccountRepository userAccountRepository){
        return args -> Stream.of("sanj,sanj", "edureka,edureka")
                .map(s -> s.split(","))
                .forEach(strings -> userAccountRepository.save(new UserAccount(strings[0], strings[1], true)));

    }

    @Bean
    public CommandLineRunner hello(){
        System.out.println("This is run");
        return args -> {};
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
    }

    @Service
    class MyUserDetailService implements UserDetailsService{

        @Autowired
        UserAccountRepository userAccountRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<UserAccount> byUserName = userAccountRepository.findByUserName(username);
            User user = byUserName.map(userAccount -> new User(userAccount.getUserName(), userAccount.getPassword(),
                    userAccount.isActive(),userAccount.isActive(), userAccount.isActive(),userAccount.isActive(), AuthorityUtils.createAuthorityList("ADMIN","USER")))
                    .orElseThrow(() -> new UsernameNotFoundException("user name not found in db "+ username));
            return user;
        }
    }






}
