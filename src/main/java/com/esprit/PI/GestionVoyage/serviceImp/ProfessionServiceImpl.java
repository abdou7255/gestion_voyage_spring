package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Post;
import com.esprit.PI.GestionVoyage.entities.Profession;
import com.esprit.PI.GestionVoyage.repository.ProfessionRepository;
import com.esprit.PI.GestionVoyage.service.ProfessionService;
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
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionRepository professionRepository;
    @Override
    public Object create(Profession entity) {
        return professionRepository.save(entity);
    }

    @Override
    public Object update(Long id, Profession entity) {
        try{

            entity.setIdProfession(id);
            return professionRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        professionRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
       return professionRepository.findById(id).get();

    }

    @Override
    public List<Profession> getAll() {
        return professionRepository.findAll();
    }

    @Override
    public Page<Profession> getAll(Pageable pageable) {
        Page<Profession> zonePage = professionRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }
}
