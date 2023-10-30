package util;

public enum Strings {
    /*
     * RECORRENTES
     */
    SEPARATOR("--------------------------------------------------------\n"),
    DOUBLE_SEPARATOR("========================================================\n"),
    INVALID_OPTION("Invalid Option!!"),
    RETURNING_MENU("Return Menu!"),
    INVALID_OPTION_RETURN_MENU(INVALID_OPTION
            + "\n" + RETURNING_MENU),

    /*
     * MENUS
     */
    DESIRED_OPTION(">>> Enter the desired option: \n"),
    HEADER(
            SEPARATOR
                    + "" +DESIRED_OPTION),
    MAIN_MENU(""
            + DOUBLE_SEPARATOR
            + "Product registration Menu in Stock:\n"
            + HEADER
            + "1 - Add a new product\n"
            + "2 - See all products\n"
            + "3 - Search by name\n"
            + "4 - Search by Id\n"
            + "0 - Close Program"),
    RETURN_MENU("0 - Return Main Menu"),
    REGISTRATION_MENU(
            HEADER
                    + "1 - Show Order By Id Products\n"
                    + "2 - Show Order By Name Products\n"
                    + "3 - Show Order By Date Insert\n"

                    + RETURN_MENU),
    OPTIONS_UPDATE("\n"
            + HEADER
            + "1 - Change Product Name\n"
            + "2 - Change Product Type\n"
            + "3 - Change Product Model\n"
            + "4 - Change Product Brand\n"
            + "5 - Change Product Company\n"
            + "6 - Delete Product\n"
            + RETURN_MENU),
    CLOSING("Thank you for using our system!"),

    /*
     * CADASTRAMENTO
     */
    REGISTRATION(SEPARATOR
            + ">>> Registration:"),
    NAME("Product Name: "),
    TYPE("Type Product: "),
    MODEL("Model Product: "),
    BRAND("Brand Product: "),
    COMPANY("Name Company:"),
    REGISTERED("\n" +
            "Successfully registered!"
            + "\nID n° "),

    /*
     * SELEÇÃO/ALTERAÇÃO DE CADASTROS
     */
    LIST(SEPARATOR
            + ">>> List Products:"),
    REPORT_ID(SEPARATOR
            + ">>> \n" +
            "Enter the ID to select the corresponding registration \"\n" +
            "            + \"(or '0' to return to the main menu):"),
    REPORT_NAME("Enter the name or part of the product name: "),
    DATA_HEADER("Current data from the selected registration:\n"),
    HEADER_UPDATE(SEPARATOR + ""
            + DATA_HEADER),

    NO_OCCURRENCE("No occurrence with '"),
    NO_OCCURRENCE_2("' found!\n"
            + RETURNING_MENU),
    UPDATE("Updated Successfully!"),
    NOT_FOUND("Product not found!"),
    DELETE_PRODUCT(">>> Are you sure you want to remove the product permanently "),
    DELETE_PRODUCT_2("? (Y/N)"),
    DELETED("Product Removed Successfully\n!");

    private final String texto;

    Strings(final String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }




}