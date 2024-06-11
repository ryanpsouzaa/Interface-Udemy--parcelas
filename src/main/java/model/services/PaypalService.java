package model.services;

public class PaypalService implements OnlinePaymentService{

    public static final Double TAXA_PAYPAL = 0.02;

    public PaypalService() {}

    @Override
    public Double taxaPagamento(Double quantia) {
        return quantia + (quantia * TAXA_PAYPAL);
    }

    @Override
    public Double juros(Double quantia, Integer meses) {
        return quantia + (quantia * meses/100);
    }
}
