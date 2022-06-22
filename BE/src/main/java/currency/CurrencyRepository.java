package warehouse;

import org.springframework.data.jpa.repository.JpaRepository;

interface CurrencyRepository extends JpaRepository<Currency, Long> {

}