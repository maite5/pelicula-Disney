package com.alkemy.pelicula.pelicula.controller;
import com.alkemy.pelicula.pelicula.dto.ActorBasicDTO;
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

    private ActorService actorService;
    @Autowired
    public ActorController(ActorService actorService){ this.actorService = actorService;}
    @GetMapping("/all")
    public ResponseEntity<List<ActorBasicDTO>> getAll() {
        List<ActorBasicDTO> actor = this.actorService.getAll();
        return ResponseEntity.ok(actor);
    }

    @GetMapping("/{id}") //31 word
    public  ResponseEntity<ActorDTO> getDetailsById(@PathVariable Long id){
    ActorDTO actor =this.actorService.getDetailsById(id);
    return ResponseEntity.ok(actor);
    }
    @GetMapping
    //public ResponseEntity<List<ActorDTO>>getAllActor(
    public ResponseEntity<List<ActorDTO>>getDetailsByFiltes(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String age,
            @RequestParam(required = false) String title,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ) {
        List<ActorDTO> actor = this.actorService.getByFilters(name,age,title,order);
        return ResponseEntity.ok(actor);
    }
    @PostMapping
    public ResponseEntity<ActorDTO> save(@RequestBody ActorDTO actor){
        ActorDTO result = this.actorService.save(actor);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
     @PutMapping("/{id}")
    public ResponseEntity<ActorDTO> update(@PathVariable Long id, @RequestBody ActorDTO actor){
        ActorDTO result= this.actorService.update(id, actor);
        return ResponseEntity.ok().body(result);
    }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id){
            this.actorService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        @PostMapping("/{id}/movie/{idMovie}")
                public ResponseEntity<Void> addMovie(@PathVariable Long id, @PathVariable Long idMovie){
         this.actorService.addMovie(id, idMovie);
         return ResponseEntity.status(HttpStatus.CREATED).build(); //69
        }
        @DeleteMapping("/{id}/movie/{idMovie}")
                public ResponseEntity<Void> removeMovie(@PathVariable Long id, @PathVariable Long idMovie){
                this.actorService.removeMovie(id, idMovie);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
     }
     //save actor
    /* @PostMapping
     public  ResponseEntity<ActorDTO> save(@RequestBody ActorDTO actor){
         ActorDTO actorGuardado = actorService.save(actor);
         return ResponseEntity.status(HttpStatus.CREATED).body(actorGuardado);
     }*/
     }