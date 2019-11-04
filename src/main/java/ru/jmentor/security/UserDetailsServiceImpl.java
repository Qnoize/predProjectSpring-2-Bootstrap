package ru.jmentor.security;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.core.userdetails.UserDetails;import org.springframework.security.core.userdetails.UserDetailsService;import org.springframework.security.core.userdetails.UsernameNotFoundException;import org.springframework.stereotype.Service;import ru.jmentor.DAO.UserDao;import ru.jmentor.model.User;import java.util.Optional;@Servicepublic class UserDetailsServiceImpl implements UserDetailsService {    private final UserDao userDao;    @Autowired    public UserDetailsServiceImpl(UserDao userDao) { this.userDao = userDao; }    @Override    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {        Optional<User> optionalUsers = Optional.ofNullable(userDao.getByName(userName));        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));        return optionalUsers.map(UserDetailsImpl::new).get();    }}