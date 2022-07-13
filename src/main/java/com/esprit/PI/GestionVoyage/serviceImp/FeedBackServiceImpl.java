package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Employee;
import com.esprit.PI.GestionVoyage.entities.Feedback;
import com.esprit.PI.GestionVoyage.repository.FeedBackRepository;
import com.esprit.PI.GestionVoyage.service.FeedBackService;
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
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public Object create(Feedback entity) {
        return feedBackRepository.save(entity);
    }

    @Override
    public Object update(Long id, Feedback entity) {
        try{

            entity.setIdFeedBack(id);
            return feedBackRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        feedBackRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return feedBackRepository.findById(id);
    }

    @Override
    public List<Feedback> getAll() {
        return feedBackRepository.findAll();
    }

    @Override
    public Page<Feedback> getAll(Pageable pageable) {
        Page<Feedback> zonePage = feedBackRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());    }

}
