package br.com.sap.paymentservice.service;

import br.com.sap.paymentservice.client.BankClient;
import br.com.sap.paymentservice.client.SapClient;
import br.com.sap.paymentservice.domain.RequestConfirmPayment;
import br.com.sap.paymentservice.domain.RequestReceiveBatch;
import br.com.sap.paymentservice.domain.ResponseReceiveBatch;
import br.com.sap.paymentservice.domain.ResponseSendBatch;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaymentServiceImpl implements PaymentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final Gson gson = new Gson();

    private final SapClient sapClient;
    private final BankClient bankClient;

    public PaymentServiceImpl(SapClient sapClient, BankClient bankClient) {
        this.sapClient = sapClient;
        this.bankClient = bankClient;
    }

    @Override
    public ResponseSendBatch getBatch() {
        LOGGER.info("m=serviceSendBatch");
        return sapClient.sendBatch();
    }

    @Override
    public ResponseReceiveBatch sendBatch() {

        LOGGER.info("m=serviceSendBatch");
        ResponseSendBatch responseSendBatch = getBatch();
        LOGGER.info("responseSendBatch={}", gson.toJson(responseSendBatch));

        RequestReceiveBatch requestReceiveBatch = mapperSendBatchToReceiveBatch(responseSendBatch);
        LOGGER.info("requestReceiveBatch={}", gson.toJson(requestReceiveBatch));

        return bankClient.receiveBatch(requestReceiveBatch);
    }

    @Override
    public void sendBatchWithPaymentConfirmation() {
        LOGGER.debug("m=sendBatchWithPaymentConfirmation");
        ResponseReceiveBatch responseReceiveBatch = sendBatch();
        LOGGER.info("responseSendBatch={}", gson.toJson(responseReceiveBatch));

        sapClient.confirmPayment(mapperCheckProcessingToConfirmPayment(responseReceiveBatch));
    }

    private RequestReceiveBatch mapperSendBatchToReceiveBatch(ResponseSendBatch responseSendBatch) {
        responseSendBatch.getLotes().forEach(completeBatchInfo -> {
            completeBatchInfo.setNoPagamento(completeBatchInfo.getNoPagamento()+1);
            if(Objects.isNull(completeBatchInfo.getCodBanco()) || completeBatchInfo.getCodBanco() < 1.0) {
                completeBatchInfo.setCodBanco(341F);
            }
            if(completeBatchInfo.getDigito() < 1.0) {
                completeBatchInfo.setDigito(1F);
            }
        });

        RequestReceiveBatch requestReceiveBatch = new RequestReceiveBatch();
        requestReceiveBatch.setLotes(responseSendBatch.getLotes());

        return requestReceiveBatch;
    }

    private RequestConfirmPayment mapperCheckProcessingToConfirmPayment(ResponseReceiveBatch responseReceiveBatch) {
        RequestConfirmPayment requestConfirmPayment = new RequestConfirmPayment();
        requestConfirmPayment.setLotes(responseReceiveBatch.getLotes());

        return requestConfirmPayment;
    }
}
