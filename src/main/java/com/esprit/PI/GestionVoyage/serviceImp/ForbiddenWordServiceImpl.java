package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Follower;
import com.esprit.PI.GestionVoyage.entities.ForbiddenWord;
import com.esprit.PI.GestionVoyage.repository.ForbiddenWordRepository;
import com.esprit.PI.GestionVoyage.service.ForbiddenWordService;
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
public class ForbiddenWordServiceImpl implements ForbiddenWordService {

    @Autowired
    private ForbiddenWordRepository forbiddenWordRepository;

    @Override
    public Object create(ForbiddenWord entity) {
        return forbiddenWordRepository.save(entity);
    }

    @Override
    public Object update(Long id, ForbiddenWord entity) {
        try{

            entity.setIdForbiddenWord(id);
            return forbiddenWordRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        forbiddenWordRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return forbiddenWordRepository.findById(id).get();
    }

    @Override
    public List<ForbiddenWord> getAll() {
        return forbiddenWordRepository.findAll();
    }

    @Override
    public Page<ForbiddenWord> getAll(Pageable pageable) {
        Page<ForbiddenWord> zonePage = forbiddenWordRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }
}
