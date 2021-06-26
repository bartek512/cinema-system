package cinema.system.mappers;

import cinema.system.domain.CustomerEntity;
import cinema.system.types.CustomerTO;
import cinema.system.types.CustomerTO.CustomerTOBuilder;

public class CustomerMapper {

    public static CustomerTO toCustomerTO(CustomerEntity customerEntity) {
        if (customerEntity == null)
            return null;

        return new CustomerTOBuilder().withEmail(customerEntity.getEmail()).withId(customerEntity.getId()).withFirstName(customerEntity.getFirstName())
                .withLastName(customerEntity.getLastName()).withPhoneNumber(customerEntity.getPhoneNumber()).build();
    }

    public static CustomerEntity toCustomerEntity(CustomerTO customerTo) {
        if (customerTo == null)
            return null;
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerTo.getId());
        customerEntity.setFirstName(customerTo.getFirstName());
        customerEntity.setLastName(customerTo.getLastName());
        customerEntity.setEmail(customerTo.getEmail());
        customerEntity.setPhoneNumber(customerTo.getPhoneNumber());
        return customerEntity;
    }
}
