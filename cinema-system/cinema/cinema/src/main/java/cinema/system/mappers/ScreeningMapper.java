package cinema.system.mappers;

import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.MovieEntity;
import cinema.system.domain.ScreeningEntity;
import cinema.system.types.ScreeningTO;
import cinema.system.types.ScreeningTO.ScreeningTOBuilder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ScreeningMapper {

    public static ScreeningTO toScreeningTO(ScreeningEntity screeningEntity) {
        if (screeningEntity == null)
            return null;

        return new ScreeningTOBuilder().withAuditorium(AuditoriumMapper.toAuditoriumTO(screeningEntity.getAuditorium()))
                .withMovie(MovieMapper.toMovieTO(screeningEntity.getMovie()))
                .withId(screeningEntity.getId()).withDate(screeningEntity.getDate())
                .build();
    }

    public static ScreeningEntity toScreeningEntity(ScreeningTO screeningTO) {
        if (screeningTO == null)
            return null;

        AuditoriumEntity auditoriumEntity = AuditoriumMapper.toAuditoriumEntity(screeningTO.getAuditorium());
        MovieEntity movieEntity = MovieMapper.toMovieEntity(screeningTO.getMovie());

        ScreeningEntity screeningEntity = new ScreeningEntity();
        screeningEntity.setId(screeningTO.getId());
        screeningEntity.setAuditorium(auditoriumEntity);
        screeningEntity.setDate(screeningTO.getDate());
        screeningEntity.setMovie(movieEntity);

        return screeningEntity;
    }


    public static List<ScreeningTO> map2TOs(List<ScreeningEntity> screenings) {
        return screenings.stream().map(ScreeningMapper::toScreeningTO).collect(Collectors.toList());
    }

    public static List<ScreeningEntity> map2Entities(List<ScreeningTO> screenings) {
        return screenings.stream().map(ScreeningMapper::toScreeningEntity).collect(Collectors.toList());
    }

    public static Set<ScreeningEntity> map2Entities(Set<ScreeningTO> screenings) {
        return screenings.stream().map(ScreeningMapper::toScreeningEntity).collect(Collectors.toSet());
    }
}
