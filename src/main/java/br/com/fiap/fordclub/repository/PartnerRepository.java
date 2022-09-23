package br.com.fiap.fordclub.repository;

import br.com.fiap.fordclub.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, String> {
}
