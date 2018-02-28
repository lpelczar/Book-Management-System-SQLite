package com.codecool.library.data.statements;

import com.codecool.library.data.contracts.BookTypeEntry;

public class BookTypeStatement {


    public String selectBookTypeById() {
        return "SELECT * FROM " + BookTypeEntry.TABLE_NAME +
                " WHERE " + BookTypeEntry.type_id + " = ?;" ;
    }
}
