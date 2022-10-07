package br.com.sap.paymentservice.controller;

import br.com.sap.paymentservice.domain.RequestCheckProcessing;
import br.com.sap.paymentservice.domain.ResponseReceiveBatch;
import br.com.sap.paymentservice.domain.ResponseSendBatch;
import br.com.sap.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    ResponseEntity<ResponseSendBatch> getBatch() {
        LOGGER.info("controllerSendBatch");
        return ResponseEntity.ok(paymentService.getBatch());
    }

    @PostMapping("/send/async")
    ResponseEntity<ResponseReceiveBatch> paymentAsync(@RequestBody ResponseSendBatch responseSendBatch) {
        LOGGER.info("controllerSendBatch");
        return ResponseEntity.ok(paymentService.sendBatch(responseSendBatch));
    }

    @PostMapping("/send/sync")
    void paymentSync(@RequestBody ResponseSendBatch responseSendBatch) {
        LOGGER.info("controllerConfirmPayment");
        paymentService.sendBatchWithPaymentConfirmation(responseSendBatch);
    }

    @PutMapping("/update/status")
    void updatePaymentStatus(@RequestBody RequestCheckProcessing requestCheckProcessing) {
        LOGGER.info("controllerUpdatePaymentStatus");
        paymentService.updatePaymentStatus(requestCheckProcessing);
    }
}
