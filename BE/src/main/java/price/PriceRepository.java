package warehouse;

import org.springframework.data.jpa.repository.JpaRepository;

interface PriceRepository extends JpaRepository<Price, Long> {

}