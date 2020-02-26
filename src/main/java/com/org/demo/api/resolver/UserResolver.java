
package com.org.demo.api.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.org.demo.api.models.User;
import com.org.demo.api.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLQueryResolver{
    
    @Autowired
    private UserService userService;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> users(){
        return userService.users();
    }
    
}
