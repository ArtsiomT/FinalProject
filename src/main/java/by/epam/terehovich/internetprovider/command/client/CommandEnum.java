package by.epam.terehovich.internetprovider.command.client;

import by.epam.terehovich.internetprovider.command.*;

/**
 * Created by aterehovich on 18.7.15.
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    LOCALE {
        {
            this.command = new LocaleCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },
    CHANGEPASS{
        {
            this.command = new ChangePasswordCommand();
        }
    },
    CABINET {
        {
            this.command = new CabinetCommand();
        }
    };

    ActionCommand command;
    public ActionCommand getCurrentCommand(){
        return this.command;
    }
}
