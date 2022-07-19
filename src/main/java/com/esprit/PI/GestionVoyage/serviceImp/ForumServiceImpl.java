package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.ForbiddenWord;
import com.esprit.PI.GestionVoyage.entities.Forum;
import com.esprit.PI.GestionVoyage.repository.ForumRepository;
import com.esprit.PI.GestionVoyage.service.ForumServicee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
@Service
@Slf4j
public class ForumServiceImpl implements ForumServicee {
    @Autowired
    private ForumRepository forumRepository;
    @Override
    public Object create(Forum entity) {
        entity.setCreatedDate(new Date(System.currentTimeMillis()));
        entity.setUpdatedDate(null);
        return forumRepository.save(entity);
    }

    @Override
    public Object update(Long id, Forum entity) {
        try{
            entity.setUpdatedDate(new Date(System.currentTimeMillis()));
            entity.setIdForum(id);
            return forumRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        forumRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return forumRepository.findById(id).get();
    }

    @Override
    public List<Forum> getAll() {
        return forumRepository.findAll();
    }

    @Override
    public Page<Forum> getAll(Pageable pageable) {
        Page<Forum> zonePage = forumRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }
}
