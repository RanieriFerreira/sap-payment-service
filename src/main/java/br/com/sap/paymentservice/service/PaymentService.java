package br.com.sap.paymentservice.service;

import br.com.sap.paymentservice.domain.ResponseReceiveBatch;
import br.com.sap.paymentservice.domain.ResponseSendBatch;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    ResponseSendBatch getBatch();
    ResponseReceiveBatch sendBatch();
    void sendBatchWithPaymentConfirmation();
}
