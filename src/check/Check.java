package check;

import java.util.Objects;
import java.util.Scanner;

public class Check {
    private Scanner Input = new Scanner(System.in);

    public int checkInput() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(Input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Không Phải Số. Mời Nhập Lại ^^");
                System.out.print("Nhập Lựa Chọn: ");
            }
        }
        return input;
    }

    public int checkInputNumber(String str) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(Input.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Không Phải Số. Mời Nhập Lại ^^");
                System.out.print(str);
            }
        }
        return input;
    }

    public String checkRegex(String str, String regex) {
        String input;
        boolean check = false;
        do {
            System.out.print(str);
            input = Input.nextLine();
            check = input.matches(regex);
            if (check == false) {
                System.out.println("ID Đã Nhập Không Đúng Định Dạng. Mời Nhập Lại 0.0");
            }
        } while (!check);
        return input;
    }
}