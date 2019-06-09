package company.example.service;

import company.example.model.entity.*;
import company.example.model.repos.ApartmentOrderRepo;
import company.example.model.repos.ApartmentRepo;
import company.example.model.repos.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private ApartmentRepo apartmentRepo;
    @Autowired
    private ApartmentOrderRepo orderRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationRepo reservationRepo;

    public void makeOrder(ApartmentOrder order, long apartmentId, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        Optional<Apartment> apartment = apartmentRepo.findById(apartmentId);
        order.setCreationTime(Instant.now());
        order.setApartment(apartment.get());
        order.setUser(user);
        order.setStatus(OrderStatus.PAYMENT_EXPECTED);
        long days = -ChronoUnit.DAYS.between(order.getCheckOutDate(), order.getCheckInDate());
        order.setPricePerDayAtTheTimeOfOrder(apartment.get().getPricePerDay());
        order.setTotalPrice(apartment.get().getPricePerDay() * days);
        orderRepo.save(order);
        reservationRepo.save(new Reservation(order));
    }

    public Collection<ApartmentOrder> getOrdersByUsername(String username) {
        User curUser = userService.findByUsername(username);
        return orderRepo.findAllByUserId(curUser.getId());
    }

    public Collection<ApartmentOrder> getOrders(Principal principal) {
        User curUser = userService.findByUsername(principal.getName());
        if (curUser.getRole() == UserRole.CLIENT) {
            return getOrdersByUsername(curUser.getUsername());
        } else if (curUser.getRole() == UserRole.ADMIN) {
            return orderRepo.findAll();
        }
        throw new UnsupportedOperationException("Unexpected status");
    }

    public void payForOrder(long orderId) {
        ApartmentOrder order = orderRepo.findById(orderId).get();
        order.setStatus(OrderStatus.PAID);
        Bill bill = new Bill(order.getTotalPrice(), "1234-1234-1234-1234", "alske234234sadfasg");
        order.setBill(bill);
        orderRepo.save(order);
    }

    public void disapproveOrder(long orderId) {
        ApartmentOrder order = orderRepo.findById(orderId).get();
        order.setStatus(OrderStatus.CANCELED);
        orderRepo.save(order);
        // dropping reservation
        Reservation reservation = reservationRepo.findByApartmentOrder(order);
        reservationRepo.delete(reservation);
    }
}