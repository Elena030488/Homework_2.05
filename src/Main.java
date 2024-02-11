import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String login = "user_1";
        String password = "12_345";
        String confirmPassword = "12_345";
        try {
            verificationOfLoginAndPassword(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            throw new RuntimeException(e);
        } catch (WrongPasswordException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Проверка логина и пароля произведена успешно");
        }
    }

    public static void verificationOfLoginAndPassword(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        verificationOfLogin(login);
        verificationOfPassword(password, confirmPassword);
    }

    private static void verificationOfLogin(String login) throws WrongLoginException {
        Pattern p = Pattern.compile("^[A-Za-z0-9_]{1,20}$");
        if (!p.matcher(login).matches()) {
            throw new WrongLoginException("Логин некорректен или превышает длиной 20 символов");
        }
    }

    private static void verificationOfPassword(String password, String confirmPassword) throws WrongPasswordException {
        Pattern p = Pattern.compile("^[A-Za-z0-9_]{1,20}$");
        if (!p.matcher(password).matches()) {
            throw new WrongPasswordException("Пароль некорректен или превышает длиной 20 символов");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Введенные пароли не совпадают");
        }
    }
}