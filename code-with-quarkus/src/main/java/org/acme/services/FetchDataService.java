package org.acme.services;

import java.util.List;

import org.acme.dtos.NameListDTO;

public interface FetchDataService {

    /*
     * @return a list of Names fetched from a datasource.
     */
    public List<NameListDTO> getAllData();
}
