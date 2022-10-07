package br.com.sap.paymentservice.controller;

import br.com.sap.paymentservice.domain.ResponseReceiveBatch;
import br.com.sap.paymentservice.domain.ResponseSendBatch;
import br.com.sap.paymentservice.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/send/async")
    ResponseEntity<ResponseReceiveBatch> paymentAsync(ResponseSendBatch responseSendBatch) {
        LOGGER.info("controllerSendBatch");
        return ResponseEntity.ok(paymentService.sendBatch(responseSendBatch));
    }

    @GetMapping("/send/sync")
    void paymentSync(ResponseSendBatch responseSendBatch) {
        LOGGER.info("controllerConfirmPayment");
        paymentService.sendBatchWithPaymentConfirmation(responseSendBatch);
    }
}
