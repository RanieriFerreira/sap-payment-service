package br.com.sap.paymentservice.service;

import br.com.sap.paymentservice.client.BankClient;
import br.com.sap.paymentservice.client.SapClient;
import br.com.sap.paymentservice.domain.*;
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
        LOGGER.info("m=serviceGetBatch, s=start");
        ResponseSendBatch sendBatch = sapClient.sendBatch();
        LOGGER.info("m=serviceGetBatch, s=finish");
        return sendBatch;
    }

    @Override
    public ResponseReceiveBatch sendBatch(ResponseSendBatch responseSendBatch) {
        LOGGER.info("m=serviceSendBatch, s=start");
        LOGGER.info("responseSendBatch={}", gson.toJson(responseSendBatch));
        RequestReceiveBatch requestReceiveBatch = mapperSendBatchToReceiveBatch(responseSendBatch);
        LOGGER.info("requestReceiveBatch={}", gson.toJson(requestReceiveBatch));

        ResponseReceiveBatch responseReceiveBatch = bankClient.receiveBatch(requestReceiveBatch);
        LOGGER.info("responseReceiveBatch={}", gson.toJson(responseReceiveBatch));
        LOGGER.info("m=serviceSendBatch s=finish");

        return responseReceiveBatch;
    }

    @Override
    public void sendBatchWithPaymentConfirmation(ResponseSendBatch responseSendBatch) {
        LOGGER.debug("m=sendBatchWithPaymentConfirmation, s=start");
        ResponseReceiveBatch responseReceiveBatch = sendBatch(responseSendBatch);
        LOGGER.info("responseSendBatch={}", gson.toJson(responseReceiveBatch));

        sapClient.confirmPayment(mapperCheckProcessingToConfirmPayment(responseReceiveBatch));
        LOGGER.debug("m=sendBatchWithPaymentConfirmation, s=finish");
    }

    @Override
    public void updatePaymentStatus(RequestCheckProcessing requestCheckProcessing) {
        LOGGER.debug("m=sendBatchWithPaymentConfirmation, s=start");
        bankClient.checkPayment(requestCheckProcessing);

        // TODO: Busca dados de pagamento no banco de dados
        // TODO: Envia confirmação para cliente SAP

        LOGGER.debug("m=sendBatchWithPaymentConfirmation, s=finish");
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
