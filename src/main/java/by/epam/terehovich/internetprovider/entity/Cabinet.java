package by.epam.terehovich.internetprovider.entity;

import java.util.GregorianCalendar;

/**
 * Created by Artyom on 13.08.2015.
 */
public class Cabinet extends Entity {

    private int idAccount;
    private int idTariff;
    private GregorianCalendar connectDate;
    private int money;
    private int status;

    public Cabinet(int id) {
        super(id);
    }

    public Cabinet(int id, int idAccount, int idTariff, GregorianCalendar connectDate, int money, int status){
        super(id);
        this.idAccount = idAccount;
        this.idTariff = idTariff;
        this.connectDate = connectDate;
        this.money = money;
        this.status = status;
    }
}
