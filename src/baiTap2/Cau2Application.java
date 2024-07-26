package baiTap2;

import java.util.Scanner;

public class Cau2Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		SinhVien sv = new SinhVien();
		sv.nhapThongTin(scanner);

		scanner.close();

	}
}
