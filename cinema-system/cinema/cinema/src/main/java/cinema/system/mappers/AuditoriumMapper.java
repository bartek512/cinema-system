package cinema.system.mappers;

import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.CinemaEntity;
import cinema.system.types.AuditoriumTO;
import cinema.system.types.AuditoriumTO.AuditoriumTOBuilder;
import cinema.system.types.CinemaTO;

import java.util.List;
import java.util.stream.Collectors;

public class AuditoriumMapper {

    public static AuditoriumTO toAuditoriumTO(AuditoriumEntity auditoriumEntity) {
        if (auditoriumEntity == null)
            return null;

        CinemaTO cinema = CinemaMapper.toCinemaTo(auditoriumEntity.getCinema());
        return new AuditoriumTOBuilder().withAuditoriumNumber(auditoriumEntity.getAuditoriumNumber()).withId(auditoriumEntity.getId())
                .withSeats(auditoriumEntity.getSeats()).withAuditoriumType(auditoriumEntity.getAuditoriumType()).withScreeningList(auditoriumEntity.getScreeningSet())
                .withCinema(cinema).build();
    }

    public static AuditoriumEntity toAuditoriumEntity(AuditoriumTO auditoriumTO) {
        if (auditoriumTO == null)
            return null;
        CinemaEntity cinema = CinemaMapper.toCinemaEntity(auditoriumTO.getCinema());

        AuditoriumEntity auditoriumEntity = new AuditoriumEntity();
        auditoriumEntity.setId(auditoriumTO.getId());
        auditoriumEntity.setAuditoriumNumber(auditoriumTO.getAuditoriumNumber());
        auditoriumEntity.setAuditoriumType(auditoriumTO.getAuditoriumType());
        auditoriumEntity.setCinema(cinema);
        auditoriumEntity.setScreeningSet(auditoriumTO.getScreeningSet());
        auditoriumEntity.setSeats(auditoriumTO.getSeats());
        return auditoriumEntity;
    }

    public static List<AuditoriumTO> map2TOs(List<AuditoriumEntity> auditoriumEntityList) {
        return auditoriumEntityList.stream().map(AuditoriumMapper::toAuditoriumTO).collect(Collectors.toList());
    }

    public static List<AuditoriumEntity> map2Entities(List<AuditoriumTO> auditoriumTOS) {
        return auditoriumTOS.stream().map(AuditoriumMapper::toAuditoriumEntity).collect(Collectors.toList());
    }
}
