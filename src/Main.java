import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        try {
            Check.checkLoginAndPassword("Denis", "1234", "1234");
        } catch (WrongLoginException | WrongPasswordException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Проверка завершена");
        }
    }
}