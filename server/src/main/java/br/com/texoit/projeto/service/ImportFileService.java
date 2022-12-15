package br.com.texoit.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.texoit.projeto.model.Film;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class ImportFileService {

    @Autowired
    private FilmService filmService;

    @Scheduled(initialDelay = 1000 * 3, fixedDelay=Long.MAX_VALUE)
    public void importFileCsv() {
        String path = "movielist.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            filmService.deleteAll();
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] vect = line.split(";");
                Integer year = Integer.parseInt(vect[0]);
                String title = vect[1];
                String studios = vect[2];
                String producers = vect[3];
                String winner = vect.length > 4 ? vect[4] : "No";
                Film film = new Film(year, title, studios, producers, winner);
                filmService.create(film);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
