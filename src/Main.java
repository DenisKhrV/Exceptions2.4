import exception.WrongLoginException;
import exception.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            checkLoginAndPassword("Denis", "1234", "1234");
        } catch (WrongLoginException | WrongPasswordException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Проверка завершена");
        }
    }

    public static void checkLoginAndPassword(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        checkLogin(login);
        checkPassword(password, confirmPassword);
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина не должна превышать 20 символов");
        }
        Pattern p = Pattern.compile("^[A-Za-z0-9_]{1,20}$");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginException("Логин содержит недопустимые символы");
        }
    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() > 20) {
            throw new WrongPasswordException("Длина пароля не должна превышать 20 символов");
        }
        Pattern p = Pattern.compile("^[A-Za-z0-9_]{1,20}$");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль содержит недопустимые символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}