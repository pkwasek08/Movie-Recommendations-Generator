package pl.project.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<MovieEntity> getAllMovieList() {
        return movieService.getAllMovieList();
    }

    @PostMapping("/newMovie")
    @CrossOrigin(origins = "*")
    public MovieEntity addMovie(@RequestBody MovieEntity userEntity) {
        return movieService.addMovie(userEntity);
    }

    @PutMapping(value = "/updateMovie")
    @CrossOrigin(origins = "*")
    public MovieEntity updateMovie(@RequestBody MovieEntity userEntity) {
        return movieService.addMovie(userEntity);
    }

    @DeleteMapping(value = "/{id}")
    @CrossOrigin(origins = "*")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }

    @GetMapping(value = "/generate")
    @CrossOrigin(origins = "*")
    public MovieEntity generateMovie(@RequestParam Integer id) {
        return movieService.generateMovies(id);
    }

}