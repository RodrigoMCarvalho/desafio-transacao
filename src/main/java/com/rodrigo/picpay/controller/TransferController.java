package com.rodrigo.picpay.controller;

import com.rodrigo.picpay.domain.dto.TransferRequest;
import com.rodrigo.picpay.domain.dto.TransferResponse;
import com.rodrigo.picpay.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @PostMapping
    public ResponseEntity<TransferResponse> makeTransfer(@RequestBody TransferRequest request) {
        return ResponseEntity.ok(transferService.makeTransfer(request));
    }
}




