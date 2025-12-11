package org.example.maturalast.persistence;

import org.example.maturalast.domain.Invoice;
import org.example.maturalast.dto.SalesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    Optional<Invoice> findInvoicesByInvoiceId_InvoiceId(Long id);

    @Query("""
    select new org.example.maturalast.dto.SalesDto(e,c,i,it) from Invoice i 
    join i.employee e   
    join i.customer c
    join i.invoiceItems it 
    where e.userId = :id 
""")
    List<SalesDto> findSalesByEmployee(Long id);
}
