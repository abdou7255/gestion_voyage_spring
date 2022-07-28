package com.esprit.PI.GestionVoyage.service;

import com.esprit.PI.GestionVoyage.dto.ProfessionDto;
import com.esprit.PI.GestionVoyage.entities.ActivityDomain;
import com.esprit.PI.GestionVoyage.entities.Profession;

public interface ProfessionService extends BaseService<ProfessionDto,Long, Profession>{
    Profession findOneByName(String name);
}
