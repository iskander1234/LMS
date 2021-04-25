package com.example.demo.interfacerepo;

import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByIdAndDeletedAtIsNull(long id);
    Order findByBookIdAndDeletedAtIsNull(long id);
    Order findByLibraryIdAndDeletedAtIsNull(long id);
    Order findByClientIdAndDeletedAtIsNull(long id);
    Order findByPassedDateAndDeletedAtIsNull(Date passedDate);
    Order findByPassingDateAndDeletedAtIsNull(Date passingDate);
    List<Order> findAllByDeletedAtIsNull();
}
