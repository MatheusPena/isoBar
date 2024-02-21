package com.example.isobar.service;

import com.example.isobar.api.model.Albums;
import com.example.isobar.api.model.Artists;
import com.example.isobar.api.model.Tracks;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class TrackService {

    public List<Tracks> getTracks(String id) throws Exception {

            final String url = "https://dws-recruiting-bands-api.dwsbrazil.io/api/bands";

            WebClient.Builder builder = WebClient.builder();

            try {
                List<Tracks> trackList = builder.build()
                        .get()
                        .uri(url)
                        .retrieve()
                        .bodyToFlux(Artists.class)
                        .flatMapIterable(Artists::getAlbums) // Assuming Band class has getter for albums field
                        .flatMapIterable(Albums::getTracks)
                        .collectList()
                        .block();

                if(trackList == null || trackList.isEmpty()){
                    throw new Exception("Não foi possível encontrar nenhum resultado");
                }

                return getTracksById(trackList, id);
            }catch (Exception e) {
                throw new Exception("Erro ao acessar o serviço. ");
            }
    }

    private List<Tracks> getTracksById(final List<Tracks> tracksList, final String filter){

        List<Tracks> filteredList = tracksList.stream()
                .filter(track ->  track.getId().equals(filter)).toList();

        if(!filteredList.isEmpty())
            return filteredList;

        filteredList = tracksList.stream()
                .filter(track ->  track.getName().contains(filter)).toList();

        if(!filteredList.isEmpty())
            return filteredList;

        return filteredList;
    }
}
