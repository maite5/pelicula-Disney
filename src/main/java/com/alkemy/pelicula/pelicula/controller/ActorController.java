package com.alkemy.pelicula.pelicula.controller;
import com.alkemy.pelicula.pelicula.dto.ActorDTO;
import com.alkemy.pelicula.pelicula.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actor")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping
    //public  ResponseEntity<ActorDTO> save(@RequestBody actorDTO actor){
    //  ActorDTO todosactorsave = actorServicesave(actor);
    // return  ResponseEntity.status(HttpStatus.CREATED).body(todosartorsave);
    //}
    public ResponseEntity<List<ActorDTO>> getAll() {
        List<ActorDTO> actores = this.actorService.getAllActor();
        return ResponseEntity.ok().body(actores);
    }

    @PostMapping
    public ResponseEntity<ActorDTO> save(@RequestBody ActorDTO actor) {
        ActorDTO actorSave = actorService.save(actor);
        return ResponseEntity.status(HttpStatus.CREATED).body(actorSave);
    }
    @PostMapping(*/{id}*)
    public ResponseEntity<ActorDTO> update(@PathVariable Long id, @RequestBody ActorDTO aactor){
        ActorDTO result= this.actorService.update(id, aactor);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.actorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
