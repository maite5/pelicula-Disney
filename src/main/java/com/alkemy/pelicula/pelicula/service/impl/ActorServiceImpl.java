package com.alkemy.pelicula.pelicula.service.impl;
import com.alkemy.pelicula.pelicula.dto.ActorBasicDTO;
import com.alkemy.pelicula.pelicula.dto.ActorDTO;
import com.alkemy.pelicula.pelicula.dto.ActorFiltersDTO;
import com.alkemy.pelicula.pelicula.entity.ActorEntity;
import com.alkemy.pelicula.pelicula.entity.MoviesEntity;
import com.alkemy.pelicula.pelicula.exception.ParamNotFound;
import com.alkemy.pelicula.pelicula.mapper.ActorMapper;
import com.alkemy.pelicula.pelicula.repository.ActorRepository;
import com.alkemy.pelicula.pelicula.repository.specification.ActorSpecification;
import com.alkemy.pelicula.pelicula.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alkemy.pelicula.pelicula.service.ActorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class ActorServiceImpl implements ActorService {
    // @Autowired
    private ActorMapper actorMapper;
    // @Autowired
    private ActorRepository actorRepository;
    private ActorSpecification actorSpecification;
    //private ActorService actorService;
    private MovieService movieService;

    @Autowired
    public ActorServiceImpl(
            ActorRepository actorRepository,
            ActorSpecification actorSpecification,
            MovieService movieService,
            ActorMapper actorMapper) {
        this.actorRepository = actorRepository;
        this.actorSpecification = actorSpecification;
        this.actorMapper = actorMapper;
        this.movieService = movieService;
    }

    public ActorDTO getDetailsById(Long id) {
        Optional<ActorEntity> entity = this.actorRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id actor no valido");
        }
        ActorDTO actorDTO = this.actorMapper.actorEntity2DTO(entity.get(), true);
        return actorDTO;
    }

    //filtrar
    public List<ActorBasicDTO> getAll() {
        List<ActorEntity> entities = this.actorRepository.findAll();
        List<ActorBasicDTO> actorBasicDTOS = this.actorMapper.actorEntitySet2BasicDTOList(entities);
        return actorBasicDTOS;
    }

    public List<ActorDTO> getByFilters(String name, String age, Set<Long> title, String order) {
        ActorFiltersDTO filtersDTO = new ActorFiltersDTO(name, age, title, order);
        List<ActorEntity> entities = this.actorRepository.findAll(this.actorSpecification.getByFilters(filtersDTO));
        List<ActorDTO> dtos = this.actorMapper.actorEntitySet2DTOList(entities, true);
        return dtos;
    }

    public ActorDTO save(ActorDTO dto) {
        ActorEntity entity = actorMapper.actorDTO2Entity(dto);
        ActorEntity entitySaved = actorRepository.save(entity);
        ActorDTO result = actorMapper.actorEntity2DTO(entitySaved, false);
        return result;
    }

    //update
    public ActorDTO update(Long id, ActorDTO actorDTO) {
        Optional<ActorEntity> entity = this.actorRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound( "Id actor no valido");
        }
        this.actorMapper.actorEntityRefreshValues(entity.get(), actorDTO);
        ActorEntity entitySaved = this.actorRepository.save(entity.get());
        ActorDTO result = this.actorMapper.actorEntity2DTO(entitySaved, false);
        return result;
    }

    public void addMovie(Long id, Long idMovie) {
        ActorEntity entity = this.actorRepository.getById(id);
        entity.getMoviess().size();
        MoviesEntity moviesEntity = this.movieService.getEntityById(idMovie);
        entity.addMovies(moviesEntity);
        this.actorRepository.save(entity); //NO PUEDE FINALIZAR GETBYID PORQ PERT GENRE CON MOVIE UBIC
    }   //UBICADO EN GENRESERVICE

    public void removeMovie(Long id, Long idMovie) {
        ActorEntity entity = this.actorRepository.getById(id);
        entity.getMoviess().size();
        MoviesEntity moviesEntity = this.movieService.getEntityById(idMovie);
        entity.removeMovies(moviesEntity);
        this.actorRepository.save(entity);
    }

    public void delete(Long id) {
        this.actorRepository.deleteById(id);
    }

}


