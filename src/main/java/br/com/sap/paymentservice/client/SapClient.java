package br.com.sap.paymentservice.client;

import br.com.sap.paymentservice.domain.RequestConfirmPayment;
import br.com.sap.paymentservice.domain.ResponseSendBatch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sap-client", url = "https://fiap-reactjs-presencial.herokuapp.com")
public interface SapClient {
    @PostMapping("/challengeSap/sap/confirmaPagto")
    void confirmPayment(@RequestBody RequestConfirmPayment requestConfirmPayment);

    @GetMapping("/challengeSap/sap/enviaLote")
    ResponseSendBatch sendBatch();
}
