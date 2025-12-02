import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.Row;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TableSawDemo {
    static void main(String[] args) {
        User u1 = new User("Harper", "Jamail", 5);
        User u2 = new User("Amara", "Jamail", 0);
        User u3 = new User("Kenzie", "Jamail", 24);

        List<User> userList = new ArrayList<User>(Arrays.asList(u1, u2, u3));

        Table myTable = Table.create("My Table");
        myTable.addColumns(StringColumn.create("First Name"), StringColumn.create("Last Name"), IntColumn.create("Age"));

        for (User user : userList) {
            Row newRow = myTable.appendRow();
            newRow.setString("First Name", user.getFirstName());
            newRow.setString("Last Name", user.getLastName());
            newRow.setInt("Age", user.getAge());
        }

        System.out.println(myTable.print());
    }
}
