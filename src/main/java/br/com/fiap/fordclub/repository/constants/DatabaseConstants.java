package br.com.fiap.fordclub.repository.constants;

public class DatabaseConstants {

    public static final String TABLE_CUSTOMERS = "customers";

    public static final String TABLE_REWARDS = "rewards";
    public static final String TABLE_CATEGORIES = "reward_categories";

    public static final String SELECT_CUSTOMERS_BY_DOCUMENT_AND_EMAIL =
            " SELECT p.* " +
                    " FROM " + TABLE_CUSTOMERS + " p " +
                    " WHERE p.document = :document " +
                    "   AND p.email = :email ";

    public static final String SELECT_CUSTOMER_BY_DOCUMENT =
            " SELECT p.* " +
                    " FROM " + TABLE_CUSTOMERS + " p " +
                    " WHERE p.document = :document ";

    public static final String SELECT_CATEGORIES_BY_NAME =
            " SELECT p.* " +
                    " FROM " + TABLE_CATEGORIES + " p " +
                    " WHERE p.name = :name ";

    public static final String SELECT_REWARDS_BY_NAME =
            " SELECT p.* " +
                    " FROM " + TABLE_REWARDS + " p " +
                    " WHERE p.name = :name ";

    public static final String SELECT_ALL_REWARDS =
            " SELECT p.* " +
                    " FROM " + TABLE_REWARDS + " p ";
}
