package com.said_market.web.controller;

import com.said_market.domain.Purchase;
import com.said_market.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    @Operation(summary = "Get all the purchases")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK) ;
    }

    @GetMapping("/{idClient}")
    @Operation(summary = "Get all the purchases of a client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId){
        return purchaseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @Operation(summary = "Make a purchase")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<Purchase> save (@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }

}
