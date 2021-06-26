package cinema.system.mappers;

import com.capgemini.domain.*;
import cinema.system.types.ReservationTO;
import cinema.system.types.ReservationTO.ReservationTOBuilder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReservationMapper {

    public static ReservationTO toReservationTO(ReservationEntity reservationEntity) {
        if (reservationEntity == null)
            return null;

        return new ReservationTOBuilder().withAuditorium(AuditoriumMapper.toAuditoriumTO(reservationEntity.getAuditorium())).withId(reservationEntity.getId())
                .withPrice(reservationEntity.getPrice()).withCustomer(CustomerMapper.toCustomerTO(reservationEntity.getCustomer())).withSeats(SeatMapper.map2TOs(reservationEntity.getSeats()))
                .withScreening(ScreeningMapper.toScreeningTO(reservationEntity.getScreening())).withBookingType(reservationEntity.getBookingType()).withStatus(reservationEntity.getStatus())
                .withCreatedDate(reservationEntity.getCratedDate())
                .build();
    }

    public static ReservationEntity toReservationEntity(ReservationTO reservationTO) {
        if (reservationTO == null)
            return null;

        AuditoriumEntity auditorium = AuditoriumMapper.toAuditoriumEntity(reservationTO.getAuditorium());
        CustomerEntity customer = CustomerMapper.toCustomerEntity(reservationTO.getCustomer());
        ScreeningEntity screening = ScreeningMapper.toScreeningEntity(reservationTO.getScreening());

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setId(reservationTO.getId());
        reservationEntity.setAuditorium(auditorium);
        reservationEntity.setSeats(SeatMapper.map2Entities(reservationTO.getSeats()));
        reservationEntity.setCustomer(customer);
        reservationEntity.setPrice(reservationTO.getPrice());
        reservationEntity.setScreening(screening);
        reservationEntity.setBookingType(reservationTO.getBookingType());
        reservationEntity.setStatus(reservationTO.getStatus());
        reservationEntity.setCratedDate(reservationTO.getCreatedDate());

        return reservationEntity;
    }

    public static List<ReservationTO> map2TOs(List<ReservationEntity> reservations) {
        return reservations.stream().map(ReservationMapper::toReservationTO).collect(Collectors.toList());
    }

    public static List<ReservationEntity> map2Entities(List<ReservationTO> reservations) {
        return reservations.stream().map(ReservationMapper::toReservationEntity).collect(Collectors.toList());
    }

    public static Set<ReservationTO> map2TOs(Set<ReservationEntity> reservations) {
        return reservations.stream().map(ReservationMapper::toReservationTO).collect(Collectors.toSet());
    }

    public static Set<ReservationEntity> map2Entities(Set<ReservationTO> reservations) {
        return reservations.stream().map(ReservationMapper::toReservationEntity).collect(Collectors.toSet());
    }
}
