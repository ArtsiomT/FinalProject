package by.epam.terehovich.internetprovider.entity;

/**
 * Created by aterehovich on 9/2/15.
 */
public class Application extends Entity {

    private int idAccount;
    private int idTask;
    private int idTariff;
    private int idStatus;

    public Application(int id, int idAccount, int idTask, int idTariff, int idStatus) {
        super(id);
        this.idAccount = idAccount;
        this.idTask = idTask;
        this.idTariff = idTariff;
        this.idStatus = idStatus;
    }
}
