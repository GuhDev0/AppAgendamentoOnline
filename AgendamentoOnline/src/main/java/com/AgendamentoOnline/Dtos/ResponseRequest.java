package com.AgendamentoOnline.Dtos;

public class ResponseRequest {

     private String resposta;
     private String status;

    public ResponseRequest(String resposta, String status) {
        this.resposta = resposta;
        this.status = status;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
