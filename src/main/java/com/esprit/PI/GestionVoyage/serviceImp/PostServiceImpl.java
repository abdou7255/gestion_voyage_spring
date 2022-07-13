package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Message;
import com.esprit.PI.GestionVoyage.entities.Post;
import com.esprit.PI.GestionVoyage.repository.PostRepository;
import com.esprit.PI.GestionVoyage.service.PostService;
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
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public Object create(Post entity) {
        return postRepository.save(entity);
    }

    @Override
    public Object update(Long id, Post entity) {
        try{

            entity.setIdPost(id);
            return postRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        postRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Page<Post> getAll(Pageable pageable) {
        Page<Post> zonePage = postRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }
}
