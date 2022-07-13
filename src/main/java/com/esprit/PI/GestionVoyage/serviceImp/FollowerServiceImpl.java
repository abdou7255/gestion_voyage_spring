package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Feedback;
import com.esprit.PI.GestionVoyage.entities.Follower;
import com.esprit.PI.GestionVoyage.repository.FollowerRepository;
import com.esprit.PI.GestionVoyage.service.FollowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@Slf4j
public class FollowerServiceImpl implements FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    @Override
    public Object create(Follower entity) {
        return followerRepository.save(entity);
    }

    @Override
    public Object update(Long id, Follower entity) {
        try{

            entity.setIdFollower(id);
            return followerRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        followerRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return followerRepository.findById(id).get();
    }

    @Override
    public List<Follower> getAll() {
        return followerRepository.findAll();
    }

    @Override
    public Page<Follower> getAll(Pageable pageable) {
        Page<Follower> zonePage = followerRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());    }

}
