package br.com.sap.paymentservice.client;

import br.com.sap.paymentservice.domain.RequestCheckProcessing;
import br.com.sap.paymentservice.domain.RequestReceiveBatch;
import br.com.sap.paymentservice.domain.ResponseCheckProcessing;
import br.com.sap.paymentservice.domain.ResponseReceiveBatch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "bank-client", url = "https://fiap-reactjs-presencial.herokuapp.com")
public interface BankClient {
    @PostMapping("/challengeSap/banco/recebeLote")
    ResponseReceiveBatch receiveBatch(@RequestBody RequestReceiveBatch requestReceiveBatch);

    @PostMapping("/challengeSap/banco/verificaProcessamento")
    ResponseCheckProcessing checkPayment(@RequestBody RequestCheckProcessing requestCheckProcessing);
}
