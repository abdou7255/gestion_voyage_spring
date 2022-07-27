package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Post;
import com.esprit.PI.GestionVoyage.entities.React;
import com.esprit.PI.GestionVoyage.repository.ReactRepository;
import com.esprit.PI.GestionVoyage.service.ReactService;
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
public class ReactServiceImpl implements ReactService {

    @Autowired
    private ReactRepository reactRepository;


    @Override
    public Object create(React entity) {

        entity.setReactDate(new Date(System.currentTimeMillis()));
        return reactRepository.save(entity);
    }

    @Override
    public Object update(Long id, React entity) {
        try{

            entity.setIdReact(id);
            return reactRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        reactRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return reactRepository.findById(id).get();
    }

    @Override
    public List<React> getAll() {
        return reactRepository.findAll();
    }

    @Override
    public Page<React> getAll(Pageable pageable) {
        Page<React> zonePage = reactRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }
}
