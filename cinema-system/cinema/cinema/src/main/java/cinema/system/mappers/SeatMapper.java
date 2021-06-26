package cinema.system.mappers;

import cinema.system.domain.AuditoriumEntity;
import cinema.system.domain.SeatEntity;
import cinema.system.types.SeatTO;
import cinema.system.types.SeatTO.SeatTOBuilder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SeatMapper {
    public static SeatTO toSeatTO(SeatEntity seatEntity) {
        if (seatEntity == null)
            return null;

        return new SeatTOBuilder().withAuditorium(AuditoriumMapper.toAuditoriumTO(seatEntity.getAuditorium()))
                .withId(seatEntity.getId()).withSeatType(seatEntity.getSeatType())
               .withSeatRow(seatEntity.getSeatRow()).withSeatNumber(seatEntity.getSeatNumber())
                .build();
    }

    public static SeatEntity toSeatEntity(SeatTO seatTO) {
        if (seatTO == null)
            return null;

        AuditoriumEntity auditoriumEntity = AuditoriumMapper.toAuditoriumEntity(seatTO.getAuditorium());

        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setId(seatTO.getId());
        seatEntity.setSeatType(seatTO.getSeatType());
        seatEntity.setAuditorium(auditoriumEntity);
        seatEntity.setSeatRow(seatTO.getSeatRow());
        seatEntity.setSeatNumber(seatTO.getSeatNumber());

        return seatEntity;
    }

    public static List<SeatTO> map2TOs(List<SeatEntity> seatsList) {
        return seatsList.stream().map(SeatMapper::toSeatTO).collect(Collectors.toList());
    }

    public static List<SeatEntity> map2Entities(List<SeatTO> seatTOs) {
        return seatTOs.stream().map(SeatMapper::toSeatEntity).collect(Collectors.toList());
    }

    public static Set<SeatTO> map2TOs(Set<SeatEntity> seatsList) {
        return seatsList.stream().map(SeatMapper::toSeatTO).collect(Collectors.toSet());
    }

    public static Set<SeatEntity> map2Entities(Set<SeatTO> seatTOs) {
        return seatTOs.stream().map(SeatMapper::toSeatEntity).collect(Collectors.toSet());
    }
}
