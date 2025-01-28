package aula.jdbcmatutino.Dao;

public class ErroDao extends Exception {

    public ErroDao() {
        super("Erro dao");
    }

    public ErroDao(String message) {}

    public ErroDao(String message, Throwable cause) {
        super(message, cause);
    }

    public ErroDao(Throwable cause) {
        super(cause);
    }

    public ErroDao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    }

}
