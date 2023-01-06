package com.example.intelligentstore.controller;

import com.example.intelligentstore.dto.FournisseurDto;
import com.example.intelligentstore.entity.Fournisseur;
import com.example.intelligentstore.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
@CrossOrigin(origins = "*")
public class FournisseurController {
    @Autowired
    private FournisseurService fournisseurservice;

    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAll() {
        return ResponseEntity.ok(fournisseurservice.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id) {
        return ResponseEntity.ok(fournisseurservice.findById(id));
    }

    @PostMapping("/add")
    public Fournisseur addfournisseur(@RequestBody FournisseurDto request) {
        var name = request.getName();
        var numero = request.getNumero();
        var mail = request.getMail();
        Fournisseur fournisseur = new Fournisseur(name, numero, mail);
        return fournisseurservice.save(fournisseur);


    }

    @PutMapping(value = "/modify/{id}", consumes = "application/json")
    public Fournisseur updatefournisseur(@PathVariable Long id, @RequestBody FournisseurDto request) {
        Fournisseur fournisseur = fournisseurservice.findById(id);
        fournisseur.setName(request.getName());
        fournisseur.setMail(request.getMail());
        fournisseur.setNumero(request.getNumero());
        return fournisseurservice.save(fournisseur);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.fournisseurservice.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
