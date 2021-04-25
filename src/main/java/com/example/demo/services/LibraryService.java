package com.example.demo.services;

import com.example.demo.interfacerepo.LibraryRepository;
import com.example.demo.model.Library;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService{
        private final LibraryRepository libraryRepo;

        public LibraryService(LibraryRepository libraryRepo) {
            this.libraryRepo = libraryRepo;
        }

        public Optional<Library> getId(Long id) {
            return libraryRepo.findById(id);
        }

        public Library add(Library library) {
            return libraryRepo.save(library);
        }

        public Library findById(Long id) {
            return libraryRepo.findByIdAndDeletedAtIsNull(id);
        }

        public Library findByName(String name) {
            return libraryRepo.findByNameAndDeletedAtIsNull(name);
        }

        public Library findByAddress(String address) {
            return libraryRepo.findByAddressAndDeletedAtIsNull(address);
        }

        public Library findByPhoneNumber(String phoneNumber) {
            return libraryRepo.findByPhoneNumberAndDeletedAtIsNull(phoneNumber);
        }

        public Library findByCity(String city) {
            return libraryRepo.findByCityAndDeletedAtIsNull(city);
        }

        public Library findByState(String state) {
            return libraryRepo.findByStateAndDeletedAtIsNull(state);
        }

        public Library getNameAndAddressResponse(long id) {
            Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
            Library libraryResponse = new Library(library.getName(), library.getAddress());
            return libraryResponse;
        }

        public Library addAddress(Library libraryRequest) {
            Library library = new Library();
            library.setAddress(libraryRequest.getAddress());
            libraryRepo.save(library);
            return library;
        }

        public Library addCity(Library libraryRequestCity) {
            Library library = new Library();
            library.setCity(libraryRequestCity.getCity());
            libraryRepo.save(library);
            return library;
        }

        public Library getCity(long id) {
            Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
            Library libraryResponseCity = new Library(library.getCity());
            return libraryResponseCity;
        }

        public Library addState(Library libraryRequestState) {
            Library library = new Library();
            library.setCity(libraryRequestState.getState());
            libraryRepo.save(library);
            return library;
        }

        public Library getState(long id) {
            Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
            Library libraryResponseState = new Library(library.getState());
            return libraryResponseState;
        }

        public String updateName(Long id, String name) {
            Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
            library.setName(name);
            libraryRepo.save(library);
            return "name updated";
        }

        public String updateAll(Long id, String name, String address, String phoneNumber) {
            Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
            library.setName(name);
            library.setAddress(address);
            library.setPhoneNumber(phoneNumber);
            libraryRepo.save(library);
            return "updated all";
        }

        public String delete(Long id) {
            Date date = new Date();
            Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
            library.setDeletedAt(date);
            libraryRepo.save(library);
            return "deleted";
        }

        public String deleteAddress(Long id) {
            Library library = libraryRepo.findByIdAndDeletedAtIsNull(id);
            library.setAddress(null);
            libraryRepo.save(library);
            return "address deleted";
        }

        public List<Library> findAll() {
            return libraryRepo.findAllByDeletedAtIsNull();
        }
}
