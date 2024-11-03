package edu.icet.service;

import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<User> getAll() {
        List<User> userArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            userArrayList.add(mapper.map(entity, User.class));
        });
        return userArrayList;
    }

    @Override
    public void addUser(User user) {
        repository.save(mapper.map(user, UserEntity.class));
    }

    @Override
    public void deleteUserById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public User searchUserById(Integer id) {
        return mapper.map(repository.findById(id),User.class);
    }

    @Override
    public void updateUserById(User user) {
        repository.save(mapper.map(user, UserEntity.class));
    }
}
