package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.util.Date;

@Controller
@RestController
@RequestMapping("/api/order")
public class OrderController extends LMSController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Order order) {
        return buildResponse(orderService.add(order), HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return buildResponse(orderService.findById(id), HttpStatus.OK);
    }


    @GetMapping("/findByPassedDate")
    public ResponseEntity<?> findByPassedDate(@RequestParam Date passedDate) {
        return buildResponse(orderService.findByPassedDate(passedDate), HttpStatus.OK);
    }

    @GetMapping("/findByPassingDate")
    public ResponseEntity<?> findByPassingDate(@RequestParam Date passingDate) {
        return buildResponse(orderService.findByPassingDate(passingDate), HttpStatus.OK);
    }

    @PostMapping("/updateAll")
    public ResponseEntity<?> updateAll(@RequestParam Long id, Date passedDate, Date passingDate) {
        return buildResponse(orderService.updateAll(id, passedDate, passingDate), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Long id) {
        return buildResponse(orderService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return buildResponse(orderService.findAll(), HttpStatus.OK);
    }
}
