package cinema.system.mappers;

import cinema.system.domain.PriceEntity;
import cinema.system.types.PriceTO;
import cinema.system.types.PriceTO.PriceTOBuilder;

public class PriceMapper {

    public static PriceTO toPriceTO(PriceEntity priceEntity) {
        if (priceEntity == null)
            return null;

        return new PriceTOBuilder().withPrice(priceEntity.getPrice()).withId(priceEntity.getId()).withSeatType(priceEntity.getSeatType())
                .withAuditoriumType(priceEntity.getAuditoriumType()).withValidFrom(priceEntity.getValidFrom()).withValidUntil(priceEntity.getValidUntil())
                .withWeekDay(priceEntity.getWeekDay()).build();
    }

    public static PriceEntity toPriceEntity(PriceTO priceTO) {
        if (priceTO == null)
            return null;
        PriceEntity price = new PriceEntity();
        price.setId(priceTO.getId());
        price.setPrice(price.getPrice());
        price.setAuditoriumType(priceTO.getAuditoriumType());
        price.setSeatType(priceTO.getSeatType());
        price.setValidFrom(priceTO.getValidFrom());
        price.setValidUntil(priceTO.getValidUntil());
        price.setWeekDay(priceTO.getWeekDay());

        return price;
    }
}
