CREATE TABLE IF NOT EXISTS public."movie_generator_data"
(
    "id"              SERIAL PRIMARY KEY,
    "id_movie_output" integer NOT NULL
);

ALTER TABLE IF EXISTS public.movie_generator_data
    OWNER to postgres;

/*copy public.movie_generator_data FROM 'C:/Users/kwasi/Desktop/movie_recommendations_generator/src/main/resources/model_movie_generator_data.csv' DELIMITER ',' CSV*/
