package com.example.demo.interfacerepo;

import com.example.demo.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
    Library findByIdAndDeletedAtIsNull(Long id);
    Library findByNameAndDeletedAtIsNull(String name);
    Library findByAddressAndDeletedAtIsNull(String address);
    Library findByPhoneNumberAndDeletedAtIsNull(String phoneNumber);
    Library findByCityAndDeletedAtIsNull(String city);
    Library findByStateAndDeletedAtIsNull(String state);
    List<Library> findAllByDeletedAtIsNull();
    List<Library> findAllByIdAndDeletedAtIsNull(long id);
}
