package com.example.intelligentstore.service;

import com.example.intelligentstore.entity.Fournisseur;
import com.example.intelligentstore.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FournisseurService {
    @Autowired
    FournisseurRepository fournisseurrepository;

    public List<Fournisseur> findAll() {
        return fournisseurrepository.findAll();
    }

    public Fournisseur save(Fournisseur fournisseur) {
        return fournisseurrepository.save(fournisseur);
    }

    public Fournisseur findById(Long id) {
        return fournisseurrepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "founrnisseur with id" + id + "not found"));
    }

    public void deleteById(Long id) {
        try {
            this.fournisseurrepository.deleteById(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BAD REQUEST");
        }
    }

}
