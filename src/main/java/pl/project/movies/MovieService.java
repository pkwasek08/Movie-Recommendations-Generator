package pl.project.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.movie_generator_result.MovieGeneratorDataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieGeneratorDataService movieGeneratorDataService;

    public MovieEntity getMovie(Integer id) {
        Optional<MovieEntity> movie = movieRepository.findById(id);
        return movie.isPresent() ? movie.get() : null;
    }

    public MovieEntity generateMovies(Integer id) {
        Integer movieGenerateOutputId = movieGeneratorDataService.getMovieGenerateOutputId(id);
        return movieGenerateOutputId != null ? getMovie(movieGenerateOutputId) : null;
    }

    public List<MovieEntity> getAllMovieList() {
        return new ArrayList<>(movieRepository.findAllByOrderByTitleAsc());
    }

    public MovieEntity addMovie(MovieEntity newMovie) {
        return movieRepository.save(newMovie);
    }

    public void deleteMovie(Integer userId) {
        movieRepository.deleteById(userId);

    }
}
