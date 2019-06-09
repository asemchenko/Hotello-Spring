package company.example.service;

import company.example.model.entity.Apartment;
import company.example.model.entity.ApartmentCriteria;
import company.example.model.repos.ApartmentRepo;
import company.example.model.repos.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepo apartmentRepo;

    @Autowired
    private ReservationRepo reservationRepo;

    public Collection<Apartment> findApartments(ApartmentCriteria criteria) {
        List<Apartment> byPersistantProperties = apartmentRepo.findAll().stream()
                .filter(a -> a.getPlacesAmount() == criteria.getPlacesAmount())
                .filter(a -> criteria.getApartmentClass() == a.getStarsAmount()).collect(Collectors.toList());
        List<Apartment> alreadyBookedOnThatPeriod = reservationRepo.findAll().stream().filter(a ->
                checkIntervalsIntersected(a.getOrder().getCheckInDate(), a.getOrder().getCheckOutDate(), criteria.getCheckIn(), criteria.getCheckOut()))
                .map(a -> a.getOrder().getApartment())
                .collect(Collectors.toList());
        byPersistantProperties.removeAll(alreadyBookedOnThatPeriod);
        return byPersistantProperties;
    }

    private boolean checkIntervalsIntersected(LocalDate s1, LocalDate f1, LocalDate s2, LocalDate f2) {
        return (s1.isAfter(s2) && s1.isBefore(f2)) || (s2.isAfter(s1) && s2.isBefore(f1)) || s1.equals(s2);
    }
}
