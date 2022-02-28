package com.pjem.cidade.apicidade.cidades.repository;

import com.pjem.cidade.apicidade.cidades.entities.Cidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CidadesRepository extends JpaRepository<Cidades, Long> {

    String QUERY = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> "
            + "(SELECT lat_lon FROM cidade WHERE id=?2)) as distance";

/*    @Query(value = QUERY, nativeQuery = true)
    Double distanciaByPoints(final Long cidadesId1, final Long cidadesId2);
*/
    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distancieByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

}
