package service.Impl;

import model.Post;
import service.BlogService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogServiceImpl implements BlogService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/qlbaiviet?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    private static final String SELECT_ALL_POSTS = "select * from posts";
    private static final String SEARCH_BY_TITLE = "select * from posts where title like ?";


    public BlogServiceImpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, "root", "ductai2401");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Post> selectAllPosts() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Post> posts = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int accountId = rs.getInt("accountId");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int status = rs.getInt("status");
                String image = rs.getString("image");
                String comment = rs.getString("comment");
                posts.add(new Post(id,accountId,title,content,status,image,comment));
            }
        } catch (SQLException e) {
//            printSQLException(e);
        }
        return posts;
    }

    @Override
    public List<Post> searchPost(String title) {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Post> posts = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_TITLE);) {
            preparedStatement.setString(1, title);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int accountId = rs.getInt("accountId");
                String title1 = rs.getString("title");
                String content = rs.getString("content");
                int status = rs.getInt("status");
                String image = rs.getString("image");
                String comment = rs.getString("comment");
                posts.add(new Post(id, accountId, title1, content, status, image, comment));
            }
        } catch (SQLException e) {
//            printSQLException(e);
        }
        return posts;
    }


}
