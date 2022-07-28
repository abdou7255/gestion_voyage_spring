package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.dto.ActivityDomainDto;
import com.esprit.PI.GestionVoyage.entities.ActivityDomain;
import com.esprit.PI.GestionVoyage.repository.ActivityDomainRepository;
import com.esprit.PI.GestionVoyage.service.ActivityDomanService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
@Slf4j
public class ActivityDomainServiceImpl implements ActivityDomanService {

    @Autowired
    private  ActivityDomainRepository activityDomainRepository;



    @Override
    public ActivityDomain findOneByName(String name) {
        return activityDomainRepository.findOneByName(name);
    }

    @Override
    public Object create(ActivityDomain entity) {
        return activityDomainRepository.save(entity);
    }

    @Override
    public Object update(Long id, ActivityDomain entity) {
        try{

            entity.setIdActiviityDomain(id);
            return activityDomainRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(Long id) {
        activityDomainRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return  activityDomainRepository.findById(id).get();
    }

    @Override
    public List<ActivityDomain> getAll() {
        return activityDomainRepository.findAll();
    }

    @Override
    public Page<ActivityDomain> getAll(Pageable pageable) {
        Page<ActivityDomain> zonePage = activityDomainRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }
}
