package com.example.isobar.service;

import com.example.isobar.api.model.Albums;
import com.example.isobar.api.model.Artists;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Service
public class AlbumService {
    public List<Albums> getAlbum(String id) throws Exception{
        final String url = "https://dws-recruiting-bands-api.dwsbrazil.io/api/bands";

        WebClient.Builder builder = WebClient.builder();

        try {
            List<Albums> albumsList = builder.build()
                    .get()
                    .uri(url)
                    .retrieve()
                    .bodyToFlux(Artists.class)
                    .flatMapIterable(Artists::getAlbums)
                    .collectList()
                    .block();

            if(albumsList == null || albumsList.isEmpty()){
                throw new Exception("Não foi possível encontrar nenhum resultado");
            }

            return getAlbumsByFilter(albumsList, id);

        }catch (Exception e) {
            throw new Exception("Erro ao acessar o serviço. ");
        }

    }

    private List<Albums> getAlbumsByFilter(List<Albums> albumsList, String filter){

        List<Albums> filteredList = albumsList.stream()
                .filter(album ->  album.getId().equals(filter)).toList();

        if(!filteredList.isEmpty())
            return filteredList;

        filteredList = albumsList.stream()
                .filter(album ->  album.getName().contains(filter)).toList();

        if(!filteredList.isEmpty())
            return filteredList;

        filteredList = albumsList.stream()
                .filter(album ->  album.getBand().contains(filter)).toList();

        return filteredList;
    }

}
