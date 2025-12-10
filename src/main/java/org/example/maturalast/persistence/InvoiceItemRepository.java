package org.example.maturalast.persistence;

import org.example.maturalast.domain.Article;
import org.example.maturalast.domain.InvoiceItem;
import org.example.maturalast.dto.ArticleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {
    Optional<InvoiceItem> findInvoiceItemByInvoiceId_InvoiceItemId(Long id);

    @Query("""
    select new org.example.maturalast.dto.ArticleDto(a) from InvoiceItem it
    join it.invoice i 
    join it.article a
    where i.date > :startAt and i.date < :endAt
""")
    List<ArticleDto> findArticlesInTimeRange(@Param("startAt") LocalDateTime startAt, @Param("endAt") LocalDateTime endAt);
}
