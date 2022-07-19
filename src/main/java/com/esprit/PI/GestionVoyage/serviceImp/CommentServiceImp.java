package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.ActivityDomain;
import com.esprit.PI.GestionVoyage.entities.Comment;
import com.esprit.PI.GestionVoyage.repository.CommentRepository;
import com.esprit.PI.GestionVoyage.service.BaseService;
import com.esprit.PI.GestionVoyage.service.CommentService;
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
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Object create(Comment entity) {
        entity.setCreatedDate(new Date(System.currentTimeMillis()));
        entity.setUpdatedDate(null);
        return commentRepository.save(entity);
    }

    @Override
    public Object update(Long id, Comment entity) {
        try{

            entity.setUpdatedDate(new Date(System.currentTimeMillis()));
            entity.setIdCommment(id);
            entity.setCreatedDate(new Date(System.currentTimeMillis()));
            return commentRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        commentRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return
                commentRepository.findById(id).get();
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Page<Comment> getAll(Pageable pageable) {
        Page<Comment> zonePage = commentRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }
}
