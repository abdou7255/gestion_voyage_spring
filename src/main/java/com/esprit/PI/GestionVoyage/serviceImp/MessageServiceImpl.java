package com.esprit.PI.GestionVoyage.serviceImp;

import com.esprit.PI.GestionVoyage.entities.Forum;
import com.esprit.PI.GestionVoyage.entities.Message;
import com.esprit.PI.GestionVoyage.repository.MessageRepository;
import com.esprit.PI.GestionVoyage.service.MessageService;
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
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Override
    public Object create(Message entity) {
        return messageRepository.save(entity);
    }

    @Override
    public Object update(Long id, Message entity) {
        try{

            entity.setIdMessage(id);
            return messageRepository.save(entity);}
        catch (EntityNotFoundException e){
            System.out.println (e.getMessage());
            return null;}
    }

    @Override
    public boolean delete(Long id) {
        messageRepository.deleteById(id);
        return true;
    }

    @Override
    public Object getOne(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Page<Message> getAll(Pageable pageable) {
        Page<Message> zonePage = messageRepository.findAll(pageable);
        return new PageImpl<>(zonePage.getContent(), pageable, zonePage.getTotalElements());
    }
}
