package cinema.system.dao.impl;

import cinema.system.domain.PriceEntity;
import cinema.system.dao.PriceDao;
import org.springframework.stereotype.Repository;

@Repository
public class PriceDaoImpl extends AbstractDao<PriceEntity, Long> implements PriceDao {
}
