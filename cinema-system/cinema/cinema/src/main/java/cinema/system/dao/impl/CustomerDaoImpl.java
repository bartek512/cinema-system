package cinema.system.dao.impl;

import cinema.system.domain.CustomerEntity;
import cinema.system.dao.CustomerDao;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerEntity, Long> implements CustomerDao {
}
