package edu.joseph.app;

import edu.joseph.actions.ConsumingAPI;

public class Application {

	public static void main(String[] args) {

		var api = new ConsumingAPI();

		System.out.println("Welcome to the sticker generator");
		System.out.print("Would you like to use the standard APIs?(y/n): ");
		String option = api.readData();
		api.choiceAPI(option);

		if (option.equals("y")) {

			while (true) {
				System.out.println("1 - Top 250 movies");
				System.out.println("2 - Top 10 movies");
				System.out.println("3 - top 3 popular series");
				System.out.println("4 - generate sticker");
				System.out.println("5 - Exit");
				System.out.print("Choose the ranking option you want to see: ");
				String answer = api.readData();

				switch (answer) {

				case "1":
				case "2":
				case "3":
					api.usingAPI(Integer.parseInt(answer));
					break;
				case "4":
					System.out.print("Enter the number of the item you want to use: ");
					String item = api.readData();
					System.out.print("Enter the file name: ");
					String fileName = api.readData();
					if (api.generetSticker(Integer.parseInt(item), fileName)) {
						System.out.println("Sticker generated successfully");
						System.out.println();
					} else {
						System.out.println("An unexpected error occurred, please try again");
					}
					break;
				case "5":
					System.out.println("Application closed.");
					System.exit(0);
				default:
					System.out.println("Invalid option.");
					break;
				}
			}
		} else if (option.equals("n")) {
			System.out.println("ATTENTION: when adding an api it is possible that there are unexpected behaviors!");
			System.out.println();

			System.out.print("Enter the number of the item you want to use: ");
			String item = api.readData();
			System.out.print("Enter the file name: ");
			String fileName = api.readData();
			if (api.generetSticker(Integer.parseInt(item), fileName)) {
				System.out.println("Sticker generated successfully");
				System.out.println();
				System.out.println("Application closed.");
				System.exit(0);
			} else {
				System.out.println("An unexpected error occurred, please try again");
			}
		}
	}
}
