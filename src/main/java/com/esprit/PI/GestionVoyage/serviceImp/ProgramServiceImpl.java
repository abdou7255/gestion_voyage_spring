package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Program;
import com.esprit.PI.GestionVoyage.repository.ProgramRepository;
import com.esprit.PI.GestionVoyage.service.ProgramService;
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
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    private ProgramRepository programRepository;

    @Override
    public Object create(Program entity) {
        return programRepository.save(entity);
    }

    @Override
    public Object update(Long id, Program entity) {
        try{

            entity.setIdProgram(id);
            return programRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}    }

    @Override
    public boolean delete(Long id) {
        programRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return programRepository.findById(id).get();
    }

    @Override
    public List<Program> getAll() {
        return programRepository.findAll();
    }

    @Override
    public Page<Program> getAll(Pageable pageable) {
        Page<Program> zonePage = programRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());

    }
}
