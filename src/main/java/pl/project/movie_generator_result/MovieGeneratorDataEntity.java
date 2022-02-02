package pl.project.movie_generator_result;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movie_generator_data")
public class MovieGeneratorDataEntity {
    private int id;
    private int idMovieOutput;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_movie_output", nullable = false)
    public int getIdMovieOutput() {
        return idMovieOutput;
    }

    public void setIdMovieOutput(int idMovieOutput) {
        this.idMovieOutput = idMovieOutput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieGeneratorDataEntity that = (MovieGeneratorDataEntity) o;
        return id == that.id &&
                idMovieOutput == that.idMovieOutput;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idMovieOutput);
    }
}
