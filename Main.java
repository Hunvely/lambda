import account.AccountView;
import board.BoardView;
import user.UserView;
import crawler.CrawlerView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner input = new Scanner(System.in);

        while (true){
            System.out.println("=== 0-Exit " +
                    "1-User " +
                    "2-Board " +
                    "3-Account " +
                    "4-Crawler " +
                    "===");
            switch (input.next()){
                case "0":  return;
                case "1": UserView.main(input);break;
                case "2": BoardView.main(input); break;
                case "3": AccountView.main(input); break;
                case "4":  CrawlerView.main(input); break;
            }
        }
    }
}