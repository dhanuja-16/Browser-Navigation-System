import java.util.Stack;
import java.util.Scanner;

public class BrowserNavigation{

    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage = "Home";

    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear(); // Clear forward history
        System.out.println("Visiting: " + currentPage);
    }

    public void back() {
        if (backStack.isEmpty()) {
            System.out.println("No pages in back history!");
            return;
        }
        forwardStack.push(currentPage);
        currentPage = backStack.pop();
        System.out.println("Back -> Current Page: " + currentPage);
    }

    public void forward() {
        if (forwardStack.isEmpty()) {
            System.out.println("No pages in forward history!");
            return;
        }
        backStack.push(currentPage);
        currentPage = forwardStack.pop();
        System.out.println("Forward -> Current Page: " + currentPage);
    }

    public void showCurrentPage() {
        System.out.println("Current Page: " + currentPage);
    }

    public static void main(String[] args) {
        BrowserNavigation browser = new BrowserNavigation();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("Browser Navigation System (Using Stack) :");

        do {
            System.out.println("\n1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Show Current Page");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();
                    browser.visit(url);
                    break;

                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.forward();
                    break;

                case 4:
                    browser.showCurrentPage();
                    break;

                case 5:
                    System.out.println("Exiting Browser...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}