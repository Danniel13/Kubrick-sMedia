package com.dani.dev.videotienda;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dani.dev.videotienda.model.entity.Category;
import com.dani.dev.videotienda.model.entity.Movie;
import com.dani.dev.videotienda.model.repository.CategoryRepository;
import com.dani.dev.videotienda.model.repository.MovieRepository;

import ch.qos.logback.core.joran.action.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
// Clase que va a permitir ejecutar proyecto, agregar configs iniciales del proyecto
@SpringBootApplication
public class VideotiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideotiendaApplication.class, args);
	}

	@Data
	@AllArgsConstructor
	public static class DataLoader implements CommandLineRunner {

		private final CategoryRepository categoryRepository;
		private final MovieRepository movieRepository;

		@Override
		public void run(String... args) throws Exception {
			loadData();

		}

		private void loadData() {
			var Action = categoryRepository.save(new Category("Action"));
			var Belic = categoryRepository.save(new Category("Belic"));
      var Comedy = categoryRepository.save(new Category("Comedyi"));
			var Awarderds = categoryRepository.save(new Category("Awarderds"));
      var Classic = categoryRepository.save(new Category("Classic"));

			var categories = Arrays.asList(
			new Category("Action"),
      new Category("Belic"),
      new Category("Comedy"),
      new Category("Awarderds"),
      new Category("Classic"));

			categoryRepository.saveAll(categories);

			var movies = Arrays.asList(
        // Categoría 1
        new Movie(001, "Spider-Man: No Way Home",
        "Spider-Man seeks the help of Doctor Strange to forget his exposed secret identity as Peter Parker. However, Strange's spell goes horribly wrong, leading to unwanted guests entering their universe.",
        "2h 20m",
        "/img/movies/spid.jpeg",
        Action),
        new Movie(002, "Fast & Furious: Hobbs & Shaw",
        "US agent Luke Hobbs and British mercenary Deckard Shaw are forced to put their rivalry side and work together to stop a genetically enhanced supervillain that after to manu time is an insencible person.",
        "2h 20m",
        "https://cdn.pocket-lint.com/r/s/1200x630/assets/images/155659-tv-news-feature-what-is-the-best-order-to-watch-the-matrix-movies-image6-n4msmyjaxw.jpg",
        Action)



    );
 

      // new Movie(2, "Fast & Furious: Hobbs & Shaw", 1,
      //     "US agent Luke Hobbs and British mercenary Deckard Shaw are forced to put their rivalry side and work together to stop a genetically enhanced supervillain that after to manu time is an insencible person.",
      //     "2h 15m", "/img/movies/fastfurious.jpg"),
      // new Movie(3, "Top Gun: Maverick", 1,
      //     "Film directed by Joseph Kosinski. It is the sequel to the 1986 film Top Gun and the second installment in the Top Gun film series. Written by Ehren Kruger, Eric Warren Singer, and Christopher McQuarrie, the film is based on a story by Peter Craig and Justin Marks.",
      //     "2h 10m", "/img/movies/top.jpg"),
      // new Movie(4, "Memory", 1,
      //     "Memory is a 2022 American action thriller film directed by Martin Campbell from a screenplay by Dario Scardapane. It is based on the novel De Zaak Alzheimer by Jef Geeraerts and is a remake of the novel's previous adaptation, the Belgian film The Alzheimer Case.",
      //     "1h 53m", "/img/movies/memory.jpg"),

//       // Category 2:

//       new MovieDto(5, "Greyhound", 2,
//           "Greyhound is a 2020 American war film directed by Aaron Schneider and starring Tom Hanks, who also wrote the screenplay. The film is based on the 1955 novel The Good Shepherd by C. S. Forester, and also stars Stephen Graham, Rob Morgan, and Elisabeth Shue.",
//           "1h 31m", "/img/movies/greyhound.jpg"),

//       new MovieDto(6, "Operation Mincemeat", 2,
//           "Operation Mincemeat is a 2021 British war drama film directed by John Madden. It is based upon Ben Macintyre's book on the British Operation Mincemeat during the Second World War. The film stars Colin Firth, Kelly Macdonald, Matthew Macfadyen, Penelope Wilton, Johnny Flynn and Jason Isaacs.",
//           "2h 7m", "/img/movies/mincemeat.jpg"),

//       new MovieDto(7, "Dunkirk", 2,
//           "Dunkirk is a 2017 war film written, directed, and produced by Christopher Nolan that depicts the Dunkirk evacuation of World War II through the perspectives of the land, sea, and air. During World War II, soldiers from the British Empire, Belgium and France try to evacuate from the town of Dunkirk.",
//           "2h 17m", "/img/movies/dunkir.jpg"),

//       // Category 3:

//       new MovieDto(8, "Dog", 3,
//           "Dog is a 2022 American comedy drama road film directed by Channing Tatum and Reid Carolin, both making their respective film directorial debuts, based on a story by Carolin and Brett Rodriguez. The film stars Tatum as an Army Ranger who is tasked with escorting the military dog of his fallen friend to his funeral.",
//           "1h 37m", "/img/movies/dog.jpg"),
//       new MovieDto(9, "The Addams Family", 3,
//       "The Addams Family is a fictional family created by American cartoonist Charles Addams. They originally appeared in a series of 150 unrelated single-panel cartoons, about half of which were originally published in The New Yorker over a 50-year period from their inception in 1938. This movie is an adaptation to Adams.",
//       "1h 39m", "/img/movies/adams.jpg"),
//       new MovieDto(10, "The Hangover 1", 3,
//       "The plot of The Hangover was inspired by a real event that happened to Tripp Vinson, a producer and friend of executive producer Chris Bender. Vinson had gone missing from his own Las Vegas bachelor party, blacking out and waking up in a strip club being threatened with a very, very large bill I was supposed to pay ",
//       "1h 49m", "/img/movies/hangover.jpg"),

//       new MovieDto(11, "Superbad", 3,
//       "perbad is a 2007 American coming-of-age teen buddy comedy film directed by Greg Mottola and produced by Judd Apatow. The film stars Jonah Hill and Michael Cera as Seth and Evan, two teenagers about to graduate from high school. ",
//       "1h 52m", "/img/movies/superband.jpg"),
      

//       // Category 4:
//       new MovieDto(12, "Parasite", 4,
//       "The struggling Kim family sees an opportunity when the son starts working for the wealthy Park family. Soon, all of them find a way to work within the same household and start living a parasitic life.",
//       "2h 16m", "/img/movies/parasite.jpg"),
//       new MovieDto(13, "The Shape Of Water", 4,
//       "Elisa, a lonely janitor, stumbles upon an amphibious creature that is held captive in a secret research facility. She then develops a unique relationship with the creature.",
//       "2h 03m", "/img/movies/sw.jpg"),



//       new MovieDto(14, "A Clockwork Orange", 5,
//       "A Clockwork Orange is a 1971 dystopian crime film  directed by Stanley Kubrick. Alex, a psychopathic delinquent, is imprisoned for murder and rape. In order to reduce his sentence, he volunteers for an experimental therapy conducted by the government.",
//       "1h 52m", "/img/movies/orange.jpg"),
//       new MovieDto(15, "Trainspotting", 5,
//       "Trainspotting is a 1996 Scottish black comedy-drama film directed by Danny Boyle. Renton is a drug addict who tries to mend his ways by moving to London and starting life afresh. He, however, is pulled back into the world of addiction by his friends.",
//       "1h 34m", "/img/movies/trains.jpg")





					// new Movie(10001L, "The Matrix",
					// 		"Cuando una bella desconocida lleva al hacker Neo a un inframundo prohibido, descubre la impactante verdad: la vida que conoce es un elaborado engaño de una ciberinteligencia malvada.",
					// 		120,
					// 		"https://cdn.pocket-lint.com/r/s/1200x630/assets/images/155659-tv-news-feature-what-is-the-best-order-to-watch-the-matrix-movies-image6-n4msmyjaxw.jpg",
					// 		scifi),
					// new Movie(10002L, "Dumb and Dumber", "Esta pelicula trata de ..", 90, null, comedy),
					// new Movie(10003L, "Dumb and Dumber",
					// 		"Cuando una bella desconocida lleva al hacker Neo a un inframundo prohibido, descubre la impactante verdad: la vida que conoce es un elaborado engaño de una ciberinteligencia malvada.",
					// 		90, null, comedy),
					// new Movie(10004L, "Dumb and Dumber", "Esta pelicula trata de ..", 90, null, comedy),
					// new Movie(10005L, "Dumb and Dumber", "Esta pelicula trata de ..", 90, null, comedy),
					// new Movie(10006L, "Dumb and Dumber", "Esta pelicula trata de ..", 90, null, comedy));

          movieRepository.saveAll(movies);
		}

	}

}
