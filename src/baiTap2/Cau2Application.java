package baiTap2;

import java.util.Scanner;

public class Cau2Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		QuanLySinhVien quanLySinhVien = new QuanLySinhVien();
		loop(scanner, quanLySinhVien);

		scanner.close();
	}

	public static int chooseOption(Scanner scanner) {
		System.out.printf("%n>>>>> MENU <<<<<%n");
		System.out.println("[1]- Nhập sinh viên");
		System.out.println("[2]- Tạo sinh viên tự động");
		System.out.println("[3]- In toàn bộ sinh viên");
		System.out.println("[4]- In sinh viên có ĐTB cao nhất");
		System.out.println("[5]- In sinh viên yếu");
		System.out.println("[6]- In sinh viên theo tên");
		System.out.println("[7]- In sinh viên theo mã SV");
		System.out.println("[8]- Xoá sinh viên theo mã SV");
		System.out.println("[9]- Dừng chương trình");

		int number;
		while (true) {
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				scanner.nextLine();
				if (number > 0 && number <= 9) {
					return number;
				} else {
					System.out.println("Vui lòng lựa chọn 1-9");
				}
			} else {
				System.out.println("Giá trị không hợp lệ. Vui lòng lựa chọn 1-9");
				scanner.next();
			}
		}
	}

	public static void loop(Scanner scanner, QuanLySinhVien quanLySinhVien) {
		int choose = 0;
		while (choose != 9) {
			choose = chooseOption(scanner);
			switch (choose) {
			case 1:
				quanLySinhVien.addNewSinhVien(scanner);
				break;

			case 2:
				int num = 0;
				do {
					System.out.println("Vui lòng nhập số lượng sinh viên muốn tạo:");
					if (scanner.hasNextInt()) {
						num = scanner.nextInt();
					} else {
						scanner.next();
					}
				} while (!(num > 0));
				quanLySinhVien.addSinhVienAuto(num);
				break;

			case 3:
				quanLySinhVien.printAllSinhVien();
				break;
			case 4:
				quanLySinhVien.printTop1();
				break;
			case 5:
				quanLySinhVien.printAllWeak();
				break;
			case 6:
				String name = "";
				do {
					System.out.println("Vui lòng nhập tên sinh viên muốn tìm:");
					if (scanner.hasNextLine()) {
						name = scanner.nextLine();
					} else {
						scanner.next();
					}
				} while (name == "");
				quanLySinhVien.printSinhVienByName(name);
				break;
			case 7:
				String id = "";
				do {
					System.out.println("Vui lòng nhập mã sinh viên muốn tìm:");
					if (scanner.hasNextLine()) {
						id = scanner.nextLine();
					} else {
						scanner.next();
					}
				} while (id == "");
				quanLySinhVien.printSinhVienByID(id);
				break;
			case 8:
				String idRemove = "";
				do {
					System.out.println("Vui lòng nhập mã sinh viên muốn xoá:");
					if (scanner.hasNextLine()) {
						idRemove = scanner.nextLine();
					} else {
						scanner.next();
					}
				} while (idRemove == "");
				quanLySinhVien.removeSinhVienByID(idRemove);
				break;
			default:
				break;
			}

		}
	}

}
