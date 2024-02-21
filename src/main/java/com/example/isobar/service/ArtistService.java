package com.example.isobar.service;

import com.example.isobar.api.model.Artists;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    public List<Artists> getArtists(String id) throws Exception {
        String url = "https://dws-recruiting-bands-api.dwsbrazil.io/api/bands";

        try {
            WebClient.Builder builder = WebClient.builder();

            List<Artists> artists = builder.build()
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToFlux(Artists.class)
                    .collectList()
                    .block();

            if(artists == null || artists.isEmpty()){
                throw new Exception("Não foi possível encontrar nenhum resultado");
            }

            return getArtistById(artists, id);
        } catch (Exception e) {
            throw new Exception("Erro ao acessar o serviço. ");
        }

    }

    private List<Artists> getArtistById(List<Artists> artistsList, String filter){

        List<Artists> filteredList = artistsList.stream()
                .filter(artist ->  artist.getId().equals(filter)).toList();

        if(!filteredList.isEmpty())
            return filteredList;

        filteredList = artistsList.stream()
                .filter(artist ->  artist.getName().contains(filter)).toList();

        if(!filteredList.isEmpty())
            return filteredList;

        filteredList = artistsList.stream()
                .filter(artist ->  artist.getGenre().contains(filter)).toList();

        return filteredList;
    }
}
