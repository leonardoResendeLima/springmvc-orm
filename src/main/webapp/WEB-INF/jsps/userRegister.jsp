<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Registration</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>

<form action="registerUser" method="post">
    <pre>
        Id : <input type="text" name="id" id="id"> <span class="errMessage"></span> <br/>
        Name : <input type="text" name="name"> <br/>
        Email : <input type="text" name="email"> <br/>
    </pre>
    <input type="submit" name="register" value="Save">
</form>

${result}
</body>


<script>
    $(document).ready(function () {
        $("#id").change(function () {
            $.ajax({
                url: "validateEmail",
                data: {id: $("#id").val()},
                success: function (responseText) {
                    $(".errMessage").text(responseText);
                    if (responseText)
                        $("#id").focus();
                }
            })
        })
    })

</script>
</html>