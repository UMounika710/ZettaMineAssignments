<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deposit Page</title>
</head>
<body>
    <h2>Deposit Form</h2>
    <form action="/deposit" method="post">
        <!-- Your deposit form fields go here -->
        <label for="amount">Deposit Amount:</label>
        <input type="text" id="amount" name="amount" required><br>

        <input type="submit" value="Deposit">
    </form>
</body>
</html>