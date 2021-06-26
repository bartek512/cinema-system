package cinema.system.mappers;

import cinema.system.domain.CinemaEntity;
import cinema.system.types.CinemaTO;
import cinema.system.types.CinemaTO.CinemaTOBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class CinemaMapper {

    public static CinemaTO toCinemaTo(CinemaEntity cinemaEntity) {
        if (cinemaEntity == null)
            return null;

        return new CinemaTOBuilder().withId(cinemaEntity.getId()).withAdress(cinemaEntity.getAdress())
                .withName(cinemaEntity.getName()).build();
    }

    public static CinemaEntity toCinemaEntity(CinemaTO cinemaTO) {
        if (cinemaTO == null)
            return null;
        CinemaEntity cinemaEntity = new CinemaEntity();
        cinemaEntity.setId(cinemaTO.getId());
        cinemaEntity.setAdress(cinemaTO.getAdress());
        cinemaEntity.setName(cinemaTO.getName());
        return cinemaEntity;
    }

    public static List<CinemaTO> map2TOs(List<CinemaEntity> cinemaEntities) {
        return cinemaEntities.stream().map(CinemaMapper::toCinemaTo).collect(Collectors.toList());
    }

    public static List<CinemaEntity> map2Entities(List<CinemaTO> cinemaTOs) {
        return cinemaTOs.stream().map(CinemaMapper::toCinemaEntity).collect(Collectors.toList());
    }
}
